package by.bsac.config;

import by.bsac.database.ConnectionPooling;
import by.bsac.database.DatabaseManager;
import by.bsac.model.Account;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.sql.SQLException;

@WebListener
public class MainConfig implements ServletContextListener {


    /*
    --------------------------------------
    ---------- Class variables -----------
    --------------------------------------
     */
    private ConnectionPooling connection_pool; //Identify connection pool;


    /*
    --------------------------------------
    ---------- Class methods -------------
    --------------------------------------
     */
    /*
        Method calls, when servlet container is begin started;
        1)Setting class variables.
        2)Creating connection pool and initialize them.
     */

    public void contextInitialized(ServletContextEvent sce) {

        //Create connection pool and initialize them:
            this.connection_pool = ConnectionPooling.getInstance();


        //Get last user id, increment them and set current user id:
        {
            int last_used_id = 0;
            try {
                last_used_id = DatabaseManager.getLastAccountID(ConnectionPooling.getConnection());

            } catch (SQLException exc) {
                exc.printStackTrace();
            }
            last_used_id++;
            Account.current_id = last_used_id;
        }


    }



    /*
        Method calls, when servlet container is begin stopped;
     */

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
