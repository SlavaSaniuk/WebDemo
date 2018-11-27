package by.bsac.aaa.accounting;

import by.bsac.database.ConnectionPoolImpl;
import by.bsac.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {

    /*
    --------------------------------------
    ---------- Class variables -----------
    --------------------------------------
     */

    private final String create_statement;


    /*
    --------------------------------------
    ---------- Class constructors --------
    --------------------------------------
     */

    public AccountDAOImpl(String db_table_name) {

        //Initialize statements syntax;
        this.create_statement = "INSERT INTO " +db_table_name +"( user_id, user_name, user_mail, user_pass) VALUES (?, ?, ?, ?)";

    }


     /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */

    @Override
    public Account findByName(Connection a_con, String a_name) throws SQLException {

        return null;
    }

    @Override
    public Account findByMail(Connection a_con, String a_mail) {
        return null;
    }

    /*
        Method to create account in database;
     */
    @Override
    public void create(Connection a_con, Account a_account) throws SQLException {

        //Create PreparedStatement object:
        PreparedStatement stm = a_con.prepareStatement(this.create_statement);

        //Set Parameter
        stm.setInt(1, a_account.getID()); //Set user id;
        stm.setString(2, a_account.getUserName()); //Set user name;
        stm.setString(3, a_account.getUserMail()); //Set user mail;
        stm.setString(4, a_account.getUserPass()); //Set user pass;

        //Execute statement:
        stm.executeUpdate();

        //Realese connection
        ConnectionPoolImpl.releaseConnection(a_con);

    }

    @Override
    public void delete(Connection a_con, Account a_account) {

    }

    @Override
    public void update(Connection a_con, Account a_account) {

    }
}
