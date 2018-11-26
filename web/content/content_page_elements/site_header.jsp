


<!--
    This 'comment' contains the path to the root directory of the application,
    in it's ID attribute.
-->
<comment id="${pageContext.servletContext.contextPath}"></comment>


<!--
    Import JavaScript.
-->
<script src="${pageContext.servletContext.contextPath}/libs/user_settings_script.js"> </script>


<!--
    HTML Markup
-->
<header class="site_header">

    <div class="header_content">

        <div class="user_settings">
            <img id="user_settings_icon" src="${pageContext.servletContext.contextPath}/resources/img/gear_wheel_32x32.png" alt="User settings"
                onmouseover="changeToActiveIcon(this)" onmouseout="changeToCommonIcon(this)">
        </div>

    </div>

</header>
