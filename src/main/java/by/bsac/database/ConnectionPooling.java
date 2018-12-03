package by.bsac.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

    /*
        This class represent a simple connection pool.
        The class base at 'Singleton' pattern, because we need use only single connection pool per single JVM.
        Use 'getInstance()' method, to create and get connection pool object.
    */

public class ConnectionPooling {

    /*
    --------------------------------------
    ---------- Class variables -----------
    --------------------------------------
     */
    private Context ds_context; //Database context;
    public static DataSource ds; //Data source;

    /*
    --------------------------------------
    ---------- Class constructors --------
    --------------------------------------
     */

    //Singleton pattern:
    private ConnectionPooling() {

        try {

            this.ds_context = new InitialContext(); //Create context object
            ds = (DataSource) this.ds_context.lookup("java:comp/env/jdbc/WebDemo"); //Init DataSource object via JNDI

        } catch (NamingException exc) {
            exc.printStackTrace();
        }

    }
    private static class ConnectionPoolingHelper {
        private static final ConnectionPooling connection_pool = new ConnectionPooling();
    }
    //End of singleton pattern.


    /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */


    /*
        Method to create connection pool object.
        Return - connection pool object;
     */
    public static ConnectionPooling getInstance() {
        return ConnectionPoolingHelper.connection_pool;
    }

    /*
        Method to get connection from DataSource;
        Return - connection;
     */
    public synchronized static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
