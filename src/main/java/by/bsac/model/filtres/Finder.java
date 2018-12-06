package by.bsac.model.filtres;



import by.bsac.exceptions.authentication.AccountAlreadyExistException;
import by.bsac.model.RequestType;

import javax.servlet.ServletRequest;

public interface Finder {

    /**
     * Process login request before servlet procession.
     * Method find accounts in database, getting them and set it to ServletRequest as Attribute.
     * @param a_req - request to servlet (default: HttpServletRequest);
     */
    void processLoginRequest(ServletRequest a_req);

    /**
     * Process registration request before servlet procession.
     * Method find accounts in database.
     * Default: accounts with specified parameter(name or mail) should not exist in database.
     * If accounts exist, method generate AccountAlreadyExistException;
     * @param a_req - request to servlet (default: HttpServletRequest);
     * @throws AccountAlreadyExistException - Generated, if accounts with specified parameter(name or mail) exist in database.
     */
    void processRegistrationRequest(ServletRequest a_req) throws AccountAlreadyExistException;

    /**
     * Detect which type or request going to servlet (login or registration).
     * @param a_req - request to servlet (default: HttpServletRequest);
     * @return - Request type (login or registration).
     */
    default RequestType detectRequest(ServletRequest a_req){

        //Get value of hidden input:
        String req = a_req.getParameter("form_function");

        if (req.equals("registration_form")) return RequestType.REGISTRATION;
        else return RequestType.LOGIN;
    }
}
