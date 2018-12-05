
/**
 * Script validate user inputs on different parameters:
 * 1) Emptiness
 * 2) Minimal password length
 * 3) email syntax
 * Also it hide/show other form (login or registration).
 * This script used on login page(index.jsp ).
 */

/** Array contain texts of error messages.
 * @type {String[]}
 */
var error_messages = [
    "Name must not be empty",
    "Password must not be empty",
    "Password must be at least ",
    "Email must not be empty"
];



/** Create new SignManager object.
 * @type {Object}
*/
var sign_manager = new SignManager();

/**
 * Constructor.
 * When page(index.jsp) is loaded initialize global variables.
 * @return - nothing.
 */
function init() {

    this.sign_manager.init(); //Init SignManager object;
}


/**
 * Function change active form to other form.
 * @param a_link - link on form switch element '<a>'.
 * @return - nothing.
 */
function changeForm(a_link) {

    //Getting links:
    var active_form_name = a_link.getAttribute("name"); //Name of active form
    var registration_form = document.getElementsByClassName("register-form")[0]; //Link on registration form
    var login_form = document.getElementsByClassName("login-form")[0]; //Link on login form
    var message = document.getElementsByClassName("message")[0]; //Link on message element '<p>'
    var form_names = ["registration", "login"]; //Array of available form names


    //Detect, which form active now
    if(active_form_name === form_names[0]) {

        //If registration form active now:
        registration_form.style.display = "none"; //Hide registration form
        login_form.style.display = "block"; //Show login form
        message.innerHTML = "Not registered?";//Set new text on message element
        a_link.innerHTML = "Create account";
        a_link.setAttribute("name", form_names[1]); //Set new attribute


    }

    if(active_form_name === form_names[1]) {

        //If login form active now:
        login_form.style.display = "none"; //Hide login form
        registration_form.style.display = "block"; //Show registration form
        message.innerHTML = "Already registered?";//Set new text on message element
        a_link.innerHTML = "Sign In";
        a_link.setAttribute("name", form_names[0]); //Set new attribute
    }

}

/**
 * Function validate user name.
 * Check on emptiness.
 * @param a_name_input - input for user name value.
 * @return boolean: true - if user name is valid;
 *                  false - in other case;
 */
function validateName(a_name_input) {


    var user_name = a_name_input.value; //Get name value:

    //Check on emptiness:
    if(user_name.length === 0){

        //If user name is empty:
        sign_manager.markInputAs(a_name_input, false); //Mark input as invalid;
        sign_manager.showErrMessage(this.error_messages[0]); //Set error message text;
        return false;
    }

    //IF user name is valid
    sign_manager.markInputAs(a_name_input, true); //Mark input as valid;
    sign_manager.hideErrMessage(); //Hide error message paragraph.
    return true;

}

/**
 * Function validate user password.
 * Check on emptiness.
 * Check for minimal length (default: 8 characters).
 * @param a_password_input - input for user password value.
 * @return boolean: true - if user password is valid;
 *                  false - in other case;
 */
function validatePassword(a_password_input) {

    var MIN_PASS_LENGTH = 8; //Minimal password length;
    var user_password_length = a_password_input.value.length; //Get password length value;


    //Check on emptiness:
    if(user_password_length === 0){

        //If user password is empty:
        sign_manager.markInputAs(a_password_input, false); //Mark input as invalid;
        sign_manager.showErrMessage(this.error_messages[1]); //Set error message text;
        return false;
    }

    //Check for minimal length:
    if (user_password_length < MIN_PASS_LENGTH ) {

        //If user password length less them MIN_PASS_LENGTH:
        sign_manager.markInputAs(a_password_input, false); //Mark input as invalid;
        sign_manager.showErrMessage(this.error_messages[2] +MIN_PASS_LENGTH + " characters"); //Set error message text;
        return false;

    }

    //IF user password is valid
    sign_manager.markInputAs(a_password_input, true); //Mark input as valid;
    sign_manager.hideErrMessage(); //Hide error message paragraph.
    return true;

}

/**
 * Function validate user mail.
 * Check on emptiness. *
 * @param a_mail_input - input for user mail value.
 * @return boolean: true - if user mail is valid;
 *                  false - in other case;
 */
function validateMail(a_mail_input) {

    var user_mail = a_mail_input.value; //Get password length value;


    //Check on emptiness:
    if(user_mail.length === 0){

        //If user mail is empty:
        sign_manager.markInputAs(a_mail_input, false); //Mark input as invalid;
        sign_manager.showErrMessage(this.error_messages[3]); //Set error message text;
        return false;
    }

    //IF user password is valid
    sign_manager.markInputAs(a_mail_input, true); //Mark input as valid;
    sign_manager.hideErrMessage(); //Hide error message paragraph.
    return true;

}

