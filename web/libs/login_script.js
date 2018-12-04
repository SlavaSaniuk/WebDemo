
/**
 * Array contain error strings.
 * For login, password input.
 * @type {string[]} - error string.
 */
var error_messages = [
    "Name or mail must not be empty",
    "Password must not be empty"
];


/**
 *  Functions change form on login page(index.jsp).
 *  From 'registration' to 'login' form, and vice versa.
 *  @Paramater a_link - link to 'change_form' control element.
 *  @Return - nothing.
 */
function changeForm(a_link) {

    //Getting elements
    var active_form_name = a_link.getAttribute("name"); //name of active form
    var registration_form_link = document.getElementsByClassName("register-form")[0]; //link on registration form
    var login_form_link = document.getElementsByClassName("login-form")[0]; //link on login form
    var form_message = document.getElementsByClassName("message")[0]; //link on message paragraph



    //Determine which form is currently active:
    // 1) If currently active registration form, change them to login form
    if(active_form_name == "registration") {

        //Change message text
        form_message.innerHTML = "Not registered?";

        //Change text on link
        a_link.innerHTML = "Create an account";

        //Hide registration form
        registration_form_link.style.display = "none";

        //Show login form
        login_form_link.style.display = "block";

        //Set attribute name to login
        a_link.setAttribute("name", "login");

    }

    // 2) If currently active login form, change them to registration form
    if(active_form_name == "login") {

        //Change message text
        form_message.innerHTML = "Already registered?";

        //Change text on link
        a_link.innerHTML = "Sign In";

        //Show login form
        login_form_link.style.display = "none";

        //Hide registration form
        registration_form_link.style.display = "block";

        //Set attribute name to login
        a_link.setAttribute("name", "registration");

    }

}

/**
 *  Functions validating user login.
 *  Check user login on emptiness.
 *  @Paramater a_link - link to user login input field.
 *  @Return - Boolean;
 *  'true' - if user login is valid.
 *  'false' - in other case.
 */
function validateLogin(a_link) {

    //Getting elements
    var login_value = document.getElementById(a_link.id).value;
    var send_btn = document.getElementById("login_send_btn");

    //Check on emptiness
    if (login_value.length == 0){

        //If non-valid
        this.selectNonValid(a_link); //Set non-valid
        this.switchSendingButton(send_btn, true); //Disable sending button
        this.displayErrMsg(error_messages[0]); //Display and set error message text
        return false;



    }else {

        //If valid
        this.selectValid(a_link); //Set valid
        this.switchSendingButton(send_btn, false); //Enable sending button
        this.hideErrMsg(); //Hide error message div
        return true;
    }



}

/**
 *  Functions validating user password.
 *  Check user password on emptiness.
 *  @Paramater a_link - link to user password input field.
 *  @Return - Boolean;
 *  'true' - if user password is valid.
 *  'false' - in other case.
 */
function validateLoginPassword(a_link) {

    //Getting elements
    var password_value = document.getElementById(a_link.id).value;
    var send_btn = document.getElementById("login_send_btn");

    //Check on emptiness
    if (password_value.length == 0){

        //If non-valid
        this.selectNonValid(a_link); //Set non-valid
        this.switchSendingButton(send_btn, true); //Disable sending button
        this.displayErrMsg(error_messages[0]); //Display and set error message text
        return false;



    }else {

        //If valid
        this.selectValid(a_link); //Set valid
        this.switchSendingButton(send_btn, false); //Enable sending button
        this.hideErrMsg(); //Hide error message div
        return true;
    }



}


/**
 * Functions enable/disable sending button.
 * @param switch_button - link on sending button.
 * @param disable - Boolean:
 *  'true' - disable sending button;
 *  'false' - enable sending button;
 * @return - nothing
 */
function switchSendingButton(switch_button, disable) {

    var sending_button = document.getElementById(switch_button.id);

    if (disable == true) {
        sending_button.disabled = true;
        sending_button.style.opacity = "0.3";
    }
    if (disable == false) {
        sending_button.disabled = false;
        sending_button.style.opacity = "1";
    }

}

/**
 * Function set red border around caller element.
 * @param caller_element - non-valid element.
 * @return - nothing.
 */
function selectNonValid(caller_element) {

    //Set red border
    document.getElementById(caller_element.id).style.border = "1px solid #EF3B3A";

}

/**
 * Function set common border around caller element.
 * @param caller_element - valid element.
 * @return - nothing.
 */
function selectValid(caller_element) {

    //Set common border
    document.getElementById(caller_element.id).style.border = "1px";

}

/**
 *  Functions to show error message div.
 *  Specify error message text.
 *  @param err_msg_text - error message string.
 *  @return - nothing.
 */
function displayErrMsg(err_msg_text) {

    document.getElementsByClassName("err_msg_text")[0].innerHTML = err_msg_text; //Set error message text in error message field.
    document.getElementsByClassName("err_msg")[0].style.display = "block"; //Display error message div.

}

/**
 *  Functions to hide error message div.
 *  @return - nothing.
 */
function hideErrMsg() {

    document.getElementsByClassName("err_msg_text")[0].innerHTML = ""; //Set empty error message.
    document.getElementsByClassName("err_msg")[0].style.display = "none"; //hide error message div.

}


