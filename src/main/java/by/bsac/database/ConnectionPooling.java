package by.bsac.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

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

    public ConnectionPooling() {

        try {

            this.ds_context = new InitialContext(); //Create context object
            ds = (DataSource) this.ds_context.lookup("java:comp/env/jdbc/WebDemo"); //Init DataSource object via JNDI

        } catch (NamingException exc) {
            exc.printStackTrace();
        }

    }

    /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */

    /*
        Method to get connection from DataSource;
        Return - connection;
     */
    public static Connection getConnection() {
        Connection con = null;
        try{
            con = ds.getConnection();
        }catch(SQLException exc){
            exc.printStackTrace();
        }
        return con;
    }


}
