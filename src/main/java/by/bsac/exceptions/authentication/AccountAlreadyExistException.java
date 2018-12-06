package by.bsac.exceptions.authentication;

public class AccountAlreadyExistException extends Exception {

    public AccountAlreadyExistException(String a_account_parameter) {
            super("Account with specified parameter already exist in database. Parameter: " + a_account_parameter);
    }

}
