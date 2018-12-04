package by.bsac.security.authentication;

import by.bsac.security.AbstractAccountDAO;
import by.bsac.database.ConnectionPooling;
import by.bsac.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * AccountFinder сlass used to find accounts in database.
 * AccountFinder can search account by name or mail.
 * @author SlavaSaniuk - saniuk.vyacheslav.97@gmail.com
 * @version 1.0
 */

public class AccountFinder extends AbstractAccountDAO {

    /**
     * Method find accounts in database by user name.
     * @param a_name - looking user name.
     * @return array of founded accounts, or 'null' - if such accounts does not exist.
     */
    @Override
    public synchronized Account[] findByName(String a_name) {

        // SQL syntax of 'find_by_name' statement
        String find_by_name_stx = "SELECT * FROM account WHERE user_name = ?";

        return this.findBy(find_by_name_stx, a_name);

    }

    /**
     * Method find accounts in database by user mail.
     * @param a_mail - looking user mail.
     * @return array of founded accounts, or 'null' - if such accounts does not exist.
     */
    @Override
    public synchronized Account[] findByMail(String a_mail) {

        // SQL syntax of 'find_by_mail' statement
        String find_by_mail_stx = "SELECT * FROM account WHERE user_mail = ?";

        return this.findBy(find_by_mail_stx, a_mail);

    }

    /*
     * Private method find accounts in database by user login(name or mail).
     * @param a_login - looking user name or user login.
     * @return array of founded accounts, or 'null' - if such accounts does not exist.
     * @exception  SQLException
     */
    private Account[] findBy(String a_find_stx, String a_login) {

        ArrayList<Account> accounts = new ArrayList<>(); //list of founded accounts

        // Get connection to database
        // Create statement object
        // Using try-with-resources
        try (Connection con = ConnectionPooling.getConnection();
             PreparedStatement stm = con.prepareStatement(a_find_stx)) {

            //Set parameters to statement;
            stm.setString(1, a_login);

            // Execute query (SELECT);
            ResultSet rs = stm.executeQuery();

            // Init 'accounts' list;
            while(rs.next()){
                accounts.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        //Check on emptiness
        if (accounts.isEmpty()) return null;
        else return (Account[]) accounts.toArray(new Account[0]);

    }



}
