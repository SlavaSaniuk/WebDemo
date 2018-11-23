package by.bsac.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
    This class represent a simple connection pool.
    The class base at 'Singleton' pattern, because we need use only single connection pool per single JVM.
    Use 'getInstance()' method, to create and get connection pool object.

 */


public class ConnectionPoolImpl implements ConnectionPool {



    /*
    --------------------------------------
    ---------- Class variables -----------
    --------------------------------------
     */

    private Properties database_properties = new Properties(); //Database properties;
    private static List<Connection> connection_pool; //Pool of free connections;
    private static List<Connection> used_pool = new ArrayList<>(); //Pool of used connections;
    private static int POOL_SIZE; //Size of connections pool;



    /*
    --------------------------------------
    ---------- Class constructors --------
    --------------------------------------
     */

    //Singleton pattern:
    private ConnectionPoolImpl() {
    }
    private static class ConnectionPollImplHelper {
        private static final ConnectionPoolImpl connection_pool = new ConnectionPoolImpl();
    }
    //End of singleton pattern.




    /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */


    /*
        Method to create and get connection pool object.
        Return - connection pool object;
     */
    public static ConnectionPoolImpl getInstance() {
        return ConnectionPollImplHelper.connection_pool;
    }

    /*
        Method to create a pool of connections.
        Parameter 1: Specify a path to database properties file.
        Return - nothing.
     */
    @Override
    public void create(File a_database_properties) {

        //Local variables:
        //*loading from property file:
        String db_url;
        String db_database;
        String db_user;
        String db_user_pass;
        String db_driver_class_name;

        //Load properties:
        try {

            //load property file:
            //IOException
            this.database_properties.load(new FileInputStream(a_database_properties));

            //set loaded properties:
            db_url = this.database_properties.getProperty("db.url");
            db_database = this.database_properties.getProperty("db.database");
            db_user = this.database_properties.getProperty("db.user");
            db_user_pass = this.database_properties.getProperty("db.user.pass");
            db_driver_class_name = this.database_properties.getProperty("db.driverClassName");
            POOL_SIZE = Integer.parseInt(this.database_properties.getProperty("db.max.pool.size"));

            //Register driver:
            //ClassNotFoundException
            Class.forName(db_driver_class_name);

            //Create connections pool:
            connection_pool = new ArrayList<>(POOL_SIZE);

            //Initialize connection pool:
            for (int i=0; i<POOL_SIZE; i++) {

                //Create connection and add them to pool:
                //SQL Exception
                connection_pool.add(this.createConnection(db_url + db_database, db_user, db_user_pass));

            }


            //Close property file:
            this.database_properties = null;


        }catch (IOException | ClassNotFoundException | SQLException exc) {
            exc.printStackTrace();
        }
    }

    /*
        Method to close connection pool.
        Return - nothing;
     */
    @Override
    public void close(){

        //Remove all connections from used pool:
        for (Connection connection : connection_pool){
            releaseConnection(connection);
        }

        //Release used pool resources:
        used_pool = null;

        //Close all database connections:
        for(Connection connection : connection_pool){

            try{
                //Close connection:
                this.closeConnection(connection);
                //remove it from pool:
                connection_pool.remove(connection);

            }catch (SQLException exc){
                exc.printStackTrace();
            }finally {
                //Force close connection:
                if(connection != null){
                    try {
                        connection.close();

                        //remove it from pool:
                        connection_pool.remove(connection);

                    } catch (SQLException exc) {
                        exc.printStackTrace();
                    }
                }

            }
        }

        //Release connection pool resources:
        connection_pool = null;

    }

    /*
        Method to get free unused connection to database.
        Return - connection to database;
     */
    public static Connection getConnection(){

        //Remove unused connection from connection pool:
        Connection unused_connection = connection_pool.remove(connection_pool.size()-1);

        //Add them to used connection pool:
        used_pool.add(unused_connection);

        //Return connection:
        return unused_connection;
    }

    /*
        Method to release unnecessary connection.
        Parameter 1: Unnecessary connection to database.
        Nothing return.
     */
    public static void releaseConnection(Connection a_connection) {

        //Release connection and remove it from used pool;
        Connection unnecessary_connection = used_pool.remove(used_pool.indexOf(a_connection));

        //Add this connection to connections pool;
        connection_pool.add(unnecessary_connection);

    }

    /*
        Method to get number of used connections.
        Return - number of used connections;
     */
    public static int getUsedConnectionsCount(){
        return used_pool.size();
    }

    /*
        Method to get number of unused connections.
        Return - number of unused connections;
     */
    public static int getFreeConnectionsCount() {
        return connection_pool.size();
    }

    /*
        Method to get connection pool size.
        Return - connection pool size;
    */
    public static int getPoolSize() {
        return POOL_SIZE;
    }


    /*
        Method to create a single database connection.
        Parameter 1 - Database URL;
        Parameter 2 - Database User name;
        Parameter 3 - Database User password;
        Return - java.sql.Connection.
        Exception - SQLException.
     */
    private Connection createConnection(String a_db_url, String a_db_user_name, String a_db_user_pass) throws SQLException {

        Connection connection; //Connection to return;

             //Create connection via DriverManager;
             connection = DriverManager.getConnection(a_db_url,a_db_user_name, a_db_user_pass);

         return connection;
     }

    /*
        Method to close a single database connection.
        Parameter 1 - a database active connection.
        Return nothing.
        Exception: java.sql.Exception.
     */
    private void closeConnection(Connection a_connection) throws SQLException {

        a_connection.close();

    }

}
