package by.bsac.config;

import by.bsac.database.ConnectionPoolImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;

@WebListener
public class MainConfig implements ServletContextListener {


    //Class variables:
    private String path_to_conf_directory; //Identify path to configuration files;
    private ConnectionPoolImpl connection_pool; //Identify connection pool;
    private File database_properties; //File contain database properties;

    /*
        Method calls, when servlet container is begin started;
        1)Setting class variables.
        2)Creating connection pool and initialize them.
     */

    public void contextInitialized(ServletContextEvent sce) {

        //Setting class variables:
        this.path_to_conf_directory = System.getenv("PROJECTS_BASE"); //Get path to configuration directory;
        this.database_properties = new File(this.path_to_conf_directory //Get database.properties file;
                + File.separator + "WebDemo"
                + File.separator + "database_properties.properties");

        //Create connection pool and initialize them:
        {
            this.connection_pool = ConnectionPoolImpl.getInstance();
            connection_pool.create(this.database_properties);
        }

    }



    /*
        Method calls, when servlet container is begin stopped;
        1)Release database connection pool;
     */

    public void contextDestroyed(ServletContextEvent sce) {

        //Destroy connection pool:
        this.connection_pool.close();
    }
}
