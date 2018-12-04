/*
************** Script global variables ***********
 */

//Minimal password length;
var MIN_PASSWORD_LENGTH = 8;

/**
 * Array contain error strings.
 * For name, password, mail.
 * @type {string[]} - error string.
 */
var error_messages = [
    "Password must not be empty",
    "Password must contain a minimum of 8 characters",
    "Email must not be empty",
    "Email must be a valid"
];

// *Identify user account
var user_account = {

    user_name: null, //Identify user login;
    user_mail: null, //Identify user mail address;
    user_pass: null //Identify user password;

};




/*
************** Script global variables ***********
*/

/*
    Function to check on valid user mail.
    *Mail must not be empty.
    *Mail must contain @ sign.
    Parameter - user mail.
    Return: true - if mail is valid;
            false - if mail in not valid;
 */
function validateMail(user_mail, caller_event) {

    var mail_value = document.getElementById(user_mail.id).value; // local variable contain user mail address;
    var pressed_key = caller_event.which || caller_event.keyCode; //Get key code of pressed key in unicode;

    //*1
    if (mail_value.length == 0) {
        this.displayErrMsg(this.error_messages[2]); //Display error message;
        this.selectNonValid(user_mail); //Set red border;
        this.switchSendingButton(true); //Disable sending button;
        return false;
    }

    //*2
    if (mail_value.indexOf('@') == -1) {
        this.displayErrMsg(this.error_messages[3]); //Display error message;
        this.selectNonValid(user_mail); //Set red border;
        this.switchSendingButton(true); //Disable sending button;
        return false;
    }

    //Return 'true', if mail  contain '@' sign.
    if (String.fromCharCode(pressed_key) == '@') {
        document.getElementById(user_mail.id).style.border = "1px"; //Hide red border near caller element.
        this.hideErrMsg(); //Hide error message div.
        this.switchSendingButton(false); //Enabling sending button;
        return true;
    }


    //Return 'true', if mail  is valid.
    document.getElementById(user_mail.id).style.border = "1px"; //Hide red border near caller element.
    this.hideErrMsg(); //Hide error message div.
    this.switchSendingButton(false); //Enabling sending button;
    return true;
}


/*
        Function to check on valid user password.
        *Password must not be empty.
        *Password must contain a minimum of 8 characters.
        Parameter - user password.
        Return: true - if password is valid;
                false - if password in not valid;
     */
function validatePassword(user_password) {

    var password_length = document.getElementById(user_password.id).value.length; // local variable contain number of password characters// ;

    //*1
    if (password_length == 0) {
        this.displayErrMsg(this.error_messages[0]); //Display error message;
        this.selectNonValid(user_password); //Set red border;
        this.switchSendingButton(true); //Disable sending button;
        return false;
    }

    //*2
    if (password_length < this.MIN_PASSWORD_LENGTH) {
        this.displayErrMsg(this.error_messages[1]); //Display error message;
        this.selectNonValid(user_password); //Set red border;
        this.switchSendingButton(true); //Disable sending button;
        return false;
    }
    
    //Return 'true', if password is valid.
    document.getElementById(user_password.id).style.border = "1px"; //Hide red border near caller element.
    this.hideErrMsg(); //Hide error message div.
    this.switchSendingButton(false); //Enabling sending button;
    return true;
}


/*  Function to switch sending button.
    Parameter - boolean:
                false - enable sending button.
                true - disabling sending button.
 */
function switchSendingButton(switch_button) {

    var sending_button = document.getElementById("send_btn");

    if(switch_button == true) {
        sending_button.disabled = true;
        sending_button.style.opacity = "0.3";
    }else {
        sending_button.disabled = false;
        sending_button.style.opacity = "1";
    }
}

/* Function to select non-valid element
    Set red border via caller input field.
    Parameter - caller element, which will be selected.
*/
function selectNonValid(caller_element) {
    document.getElementById(caller_element.id).style.border = "1px solid #EF3B3A";
}

/*
    Function to display error messages.
    Parameter  - text of error message.
 */
function displayErrMsg(err_msg_text) {

    document.getElementsByClassName("err_msg_text")[0].innerHTML = err_msg_text; //Set error message text in error message field.
    document.getElementsByClassName("err_msg")[0].style.display = "block"; //Display error message div.

}

/*
    Function to hide error messages.
 */
function hideErrMsg() {

    document.getElementsByClassName("err_msg_text")[0].innerHTML = ""; //Set empty error message.
    document.getElementsByClassName("err_msg")[0].style.display = "none"; //hide error message div.

}