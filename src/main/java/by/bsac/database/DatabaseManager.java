package by.bsac.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */


    /*
        Method to get last used id in table account.
        Parameter 1: Connection to database from connection pool;
        Return - last user id,
                   or 0 if table are empty.
    */
    public static int getLastAccountID(Connection a_connection) {

        String stm_syntax = "SELECT MAX(user_id) FROM account;"; //Select max. user id statement syntax
        int result = 0; //Max. user id

        //Create statement object
        try(Statement stm = a_connection.createStatement()) {


            ResultSet rs = stm.executeQuery(stm_syntax);// Execute statement

            //Check result for emptiness
            if (!isEmpty(rs)) result = rs.getInt(1); //If not empty, get last account id

            //Close connection
            a_connection.close();

        }catch (SQLException exc){
            exc.printStackTrace();
        }finally {

            //Force close connection object
            if (a_connection != null){
                a_connection = null;
            }
        }

        return result; //Return result

    }

    /*
        Method to check for emptiness ResultSet object.
        Parameter 1: ResultSet object;
        Return true - if ResultSet is empty;
                false - other wise;
    */
    private static boolean isEmpty( ResultSet a_result) throws SQLException {

        return !a_result.next();
    }

}


