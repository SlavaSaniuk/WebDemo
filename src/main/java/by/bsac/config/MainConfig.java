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


    //Class variables:
    public static String path_to_conf_directory; //Identify path to configuration files;
    private ConnectionPooling connection_pool; //Identify connection pool;
    private File database_properties; //File contain database properties;

    /*
        Method calls, when servlet container is begin started;
        1)Setting class variables.
        2)Creating connection pool and initialize them.
     */

    public void contextInitialized(ServletContextEvent sce) {

        //Setting class variables:
        path_to_conf_directory = System.getenv("PROJECTS_BASE"); //Get path to configuration directory;
        this.database_properties = new File(path_to_conf_directory //Get database.properties file;
                + File.separator + "WebDemo"
                + File.separator + "database_properties.properties");

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
        1)Release database connection pool;
     */

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
