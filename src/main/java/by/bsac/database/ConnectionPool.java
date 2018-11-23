package by.bsac.database;

import java.io.File;

public interface ConnectionPool {

    /*
        Create connection pool.
        1) Load property file;
        2) Set properties to local variables;
        3) Register database driver;
        4) Create connection pool object (ArrayList<Connection>);
        5) Initialize connection pool;
        6) Release property file memory;
        Parameter 1: Path to property file.
        Return - nothing.
        Exceptions:
            ClassNotFoundException;
            IOException;
            SQLException;
     */
    void create(File a_database_properties);


    /*
        Close connection pool;
        1) Release all connections from used pool;
        2) Release used pool memory;
        3) Close all connections;
        4) Release connection pool memory;
        Return - nothing;
        Exceptions:
            SQLException;
     */
    void close();


}