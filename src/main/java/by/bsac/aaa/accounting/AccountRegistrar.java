package by.bsac.aaa.accounting;

import by.bsac.database.ConnectionPoolImpl;
import by.bsac.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountRegistrar extends AbstractAccountDAO {

    /*
    --------------------------------------
    ---------- Class variables -----------
    --------------------------------------
     */

    private final Connection dedicated_connection = ConnectionPoolImpl.getConnection(); //Connection to database;
    private PreparedStatement create_stm; //'Create' statement object;

    /*
    --------------------------------------
    ---------- Class constructors --------
    --------------------------------------
     */

    public AccountRegistrar() {


        try {

            //Init statement object
            this.create_stm = dedicated_connection.prepareStatement(
                    "INSERT INTO account( user_id, user_name, user_mail, user_pass) VALUES (?, ?, ?, ?);");

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

    }


    /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */


    /*
        Method to create account in database;
        Parameters:
        Parameter 1: User account;
        Return: nothing;
        Exception: SQL exception;
     */
    @Override
    public synchronized void create(Account a_account) throws SQLException {

        //Set parameters to stm
        this.create_stm.setInt(1, a_account.getID());
        this.create_stm.setString(2, a_account.getUserName());
        this.create_stm.setString(3, a_account.getUserMail());
        this.create_stm.setString(4, a_account.getUserPass());

        //execute stm (Insert)
        this.create_stm.executeUpdate();

    }

    /*
        Method to destroy all usage resources.
        Return: nothing;
        Exception: SQL exception;
    */
    public void destroy() throws SQLException {

        //Close statement object
        this.create_stm.close();

        //Release connection to database
        ConnectionPoolImpl.releaseConnection(this.dedicated_connection);
    }


}
