package by.bsac.model;

public class Account {

    private String user_name; //Identify user login;
    private String user_mail; //Identify user email address;
    private String user_pass; //Identify user password;
    private int user_id; //Identify user id;
    public static int current_id = 1;

    //Constructor
    public Account(String user_name, String user_mail, String user_pass) {
        this.user_name = user_name;
        this.user_mail = user_mail;
        this.user_pass = user_pass;
    }

    //Method to set ID to user;
    public void setID() {
        this.user_id = current_id; //Set id to user;
        current_id++; //Increment current id value;
    }
}
