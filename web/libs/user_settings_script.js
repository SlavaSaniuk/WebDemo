/*
************** Script global variables ***********
 */

//WebApp variables
    var root_path = document.getElementsByTagName("COMMENT")[0].id; //path to root directory of container.

// 'user settings' icons:
    var icon_common = root_path +"/resources/img/gear_wheel_32x32.png"; //path to common icon
    var icon_active = root_path +"/resources/img/gear_wheel_32x32_hover.png"; //path to active icon
    var user_settings_icon; //Contain link to user settings icon element
    var user_settings_menu; //Contain link to user settings menu element


/*
    Function to show user settings menu.
    1) Change icon to active.
    2) Show user settings menu.
 */
function showUserSettingsMenu() {

    //Change icon to active:
    this.user_settings_icon = document.getElementById("user_settings_icon"); //Init link to icon element
    this.user_settings_icon.src=icon_active; //Set active icon

    //Show menu:
    this.user_settings_menu = document.getElementById("user_settings_menu"); //Init link to menu element
    this.user_settings_menu.style.display = "block"; //Show user settings menu
}

/*
    Function to hide user settings menu.
    1) Change icon to common.
    2) Hide user settings menu.
 */
function hideUserSettingsMenu() {

    this.user_settings_icon.src=icon_common; //Set common icon
    this.user_settings_menu.style.display = "none"; //Hide user settings menu

}