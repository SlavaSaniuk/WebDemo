
/**
 * Script validate user inputs on different parameters:
 * 1) Emptiness
 * 2) Minimal password length
 * 3) email syntax
 * Also it hide/show other form (login or registration).
 * This script used on login page(index.jsp ).
 */

/**
 * Identify minimal password length of registration form.
 * @type {number}
 */
var MINIMAL_PASS_LENGTH = 8;

/**
 * Function hide active form, and show other form.
 * @param a_link - link on form switch element '<a>'.
 * @return - nothing.
 */
function changeForm(a_link) {

    //Getting links:
    var active_form_name = a_link.getAttribute("name"); //Name of active form
    var form_names = ["registration", "login"]; //Array of available form names


    //Detect, which form active now
    if(active_form_name === form_names[0]) {

        //If registration form active now:
        a_link.setAttribute("name", form_names[1]) //Set new attribute


    }






}