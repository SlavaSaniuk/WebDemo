package by.bsac.aaa;

import by.bsac.model.Account;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccountDAO {

    Account[] findByName(String a_name) throws SQLException;
    Account[] findByMail(String a_mail);

    /*
        Method to create account in database;
        Parameters:
        Parameter 1: User account;
        Return: nothing;
        Exception: SQL exception;
     */
    void create(Account a_account) throws SQLException;



    void delete(Connection a_con,  Account a_account);
    void update(Connection a_con,  Account a_account);
}
