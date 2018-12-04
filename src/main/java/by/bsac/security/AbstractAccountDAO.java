package by.bsac.security;

import by.bsac.model.Account;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractAccountDAO implements AccountDAO {

    /*
    --------------------------------------
    ---------- Class variables -----------
    --------------------------------------
     */

    public final String create_statement;
    private final String find_by_name_statement;
    private final String find_by_mail_statement;


    /*
    --------------------------------------
    ---------- Class constructors --------
    --------------------------------------
     */

    public AbstractAccountDAO() {

        //Initialize statements syntax;
        this.create_statement = "INSERT INTO account( user_id, user_name, user_mail, user_pass) VALUES (?, ?, ?, ?)";
        this.find_by_name_statement = "SELECT * FROM account WHERE user_name = ?";
        this.find_by_mail_statement = "SELECT * FROM account WHERE user_name = ?";
    }


     /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */


    @Override
    public Account[] findByName(String a_name) throws SQLException {
        return null;
    }

    @Override
    public Account[] findByMail(String a_mail) {
        return null;
    }

    /*
                Method to create account in database;
             */
    @Override
    public void create(Account a_account) throws SQLException {


    }

    @Override
    public void delete(Connection a_con, Account a_account) {

    }

    @Override
    public void update(Connection a_con, Account a_account) {

    }

}
