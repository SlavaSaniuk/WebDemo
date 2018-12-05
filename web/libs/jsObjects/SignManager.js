function SignManager() {

    /** Field contain a link on error message paragraph
     * @type {Object}
     */
    var error_message_paragraph;

    /**
     * Constructor.
     * Initialize global variables.
     * @return - nothing.
     */
    this.init = function() {

        //Init parameters:
        error_message_paragraph = document.getElementById("err_msg");
    };

    /**
     * Function mark user input as valid of invalid input.
     * Set red border around invalid input.
     * Set common border around  valid input.
     * @param a_input - invalid input.
     * @param valid - boolean: true - if input is valid;
     *                         false - if input is invalid;
     * @return - nothing.
     */
    this.markInputAs = function(a_input, valid) {

        if (valid === false) {

            //If input is invalid:
            a_input.style.border = "1px solid #EF3B3A"; //Set red border
        }

        if (valid === true) {

            //If input is valid:
            a_input.style.border = "1px"; //Set common border
        }

    };


    /**
     * Function show error message paragraph, and set error message text to them.
     * @param error_message - text of error message.
     * @return - nothing.
     */
    this.showErrMessage = function(error_message) {

        error_message_paragraph.innerHTML = error_message; //Set text to paragraph
        error_message_paragraph.style.display = "block"; //Show paragraph

    };

    /**
     * Function clear text in error message paragraph, and hide them.
     * @return - nothing.
     */
    this.hideErrMessage = function() {

        error_message_paragraph.innerHTML = ""; //Clear error message text;
        error_message_paragraph.style.display = "none"; //Hide error message paragraph;

    };
    
}