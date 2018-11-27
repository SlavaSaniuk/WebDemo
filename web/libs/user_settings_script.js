/*
************** Script global variables ***********
 */

//WebApp variables
    var root_path = document.getElementsByTagName("COMMENT")[0].id; //path to root directory of container.

// 'user settings' icons:
    var icon = root_path +"/resources/img/gear_wheel_32x32.png"; //path to common icon
    var icon_active = root_path +"/resources/img/gear_wheel_32x32_hover.png"; //path to active icon
    var user_setting_menu = document.getElementById("")


/*
    Function to change common icon for active icon.
    Parameter 1: caller pic;
 */
function changeToActiveIcon(pic) {
    pic.src=icon_active;
}

/*
    Function to change active icon for common icon.
    Parameter 1: caller pic;
 */
function changeToCommonIcon(pic) {
    pic.src=icon;
}