
<!--
    This 'comment' contains the path to the root directory of the application,
    in it's ID attribute.
-->
<comment id="${pageContext.servletContext.contextPath}"></comment>


<!--
    Import JavaScript.
-->
<script src="<%=pageContext.getServletContext().getContextPath()%>/libs/UserSettingsScript.js"> </script>


<!--
    HTML Markup
-->
<header class="site_header">

    <div class="header_content">

        <div class="user_settings" onmouseover="showUserSettingsMenu()" onmouseout="hideUserSettingsMenu()">

            <img id="user_settings_icon" src="${pageContext.servletContext.contextPath}/resources/img/gear_wheel_32x32.png" alt="User settings">

            <menu id="user_settings_menu">
                <a href="<%=pageContext.getServletContext().getContextPath()%>/content/user/settings/account_settings.jsp"> <li> Account settings </li> </a>
                <a href="<%=pageContext.getServletContext().getContextPath()%>/content/user/settings/user_settings.jsp"> <li> User settings </li> </a>
            </menu>

        </div>

    </div>

</header>
