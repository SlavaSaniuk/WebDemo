package by.bsac.aaa.accounting;

import by.bsac.database.ConnectionPooling;
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


    /*
    --------------------------------------
    ---------- Class constructors --------
    --------------------------------------
     */

    public AccountRegistrar() { }


    /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */


    /*
        Method to create account in database;
        Engine: "Insert account object to database."
        Parameters:
        Parameter 1: User account;
        Return: nothing;
        Exception: SQL exception;
     */
    @Override
    public synchronized void create(Account a_account) throws SQLException {

        Connection con = ConnectionPooling.getConnection(); //Get connection to database

        PreparedStatement create_stm = con.prepareStatement(super.create_statement); //Create statement object

        //Set parameters to stm
        create_stm.setInt(1, a_account.getID());
        create_stm.setString(2, a_account.getUserName());
        create_stm.setString(3, a_account.getUserMail());
        create_stm.setString(4, a_account.getUserPass());

        //execute stm (Insert)
        create_stm.executeUpdate();

        //Close statement object
        create_stm.close();

        //Close connection to database
        con.close();

    }


}
