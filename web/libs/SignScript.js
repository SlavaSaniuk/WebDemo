
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
    "Name must not be empty"
];

/** Field contain a link on error message paragraph
 * @type {Object}

var error_message_paragraph;
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
    if(user_name === ""){

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

