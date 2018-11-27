package by.bsac.aaa.accounting;

import by.bsac.model.Account;

import java.sql.Connection;
import java.sql.SQLException;

public interface AccountDAO {

    Account findByName(Connection a_con,  String a_name) throws SQLException;
    Account findByMail(Connection a_con,  String a_mail);

    /*
        Method to create account in database;
        Parameters:
        Parameter 1: Free connection to database;
        Parameter 2: User account;
        Return: nothing;
        Exception: SQL exception;
     */
    void create(Connection a_con,  Account a_account) throws SQLException;



    void delete(Connection a_con,  Account a_account);
    void update(Connection a_con,  Account a_account);
}
