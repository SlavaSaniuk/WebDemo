<%@ page import="static java.lang.Boolean.FALSE" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>

    <%!
        private Boolean authenticated = Boolean.valueOf(FALSE); //Session authenticated attribute
    %>

    <%
      //Create session object and set parameters to it
      session.setAttribute("authenticated", this.authenticated);
    %>

    <link rel="stylesheet" href="styles/template.css">
    <link rel="stylesheet" href="styles/styles.css">
    <script src="libs/register_script.js"> </script>
    <script src="libs/login_script.js"> </script>
    <title> Hello </title>
  </head>
  <body>

  <div class="login-page">

    <div class="form">


      <!-- Registration form -->
      <form class="register-form" method="post" action="${pageContext.request.contextPath}/registration" >

        <input type="hidden" name="form_function" value="registration_form" />

        <input type="text" id="user_name" placeholder="name" name="user_name"/>

        <input type="password" id="user_pass" placeholder="password" name="user_pass"
                                onblur="validatePassword(this)" onkeyup="validatePassword(this)"/>

        <input type="text" id="user_mail" placeholder="email address" name="user_mail"
                                onblur="validateMail(this, event)" onkeyup="validateMail(this, event)" />

        <button type="submit" id="send_btn"> sign up </button>

        <!-- If JavaScript is enabled, disable submit button, before script is validate user arguments. -->
        <script>
          document.getElementById("send_btn").disabled = true;
        </script>

      </form>

        <!-- login form -->
      <form class="login-form" method="post" action="${pageContext.request.contextPath}/login" >

          <input type="hidden" name="form_function" value="login_form" />

          <input type="text" id="user_login" placeholder="name or mail" name="user_login"
                 onblur="validateLogin(this)" onkeyup="validateLogin(this)" />

          <input type="password" id="login_user_pass" placeholder="password" name="user_pass"
                 onblur="validateLoginPassword(this)" onkeyup="validateLoginPassword(this)" />

          <button type="submit" id="login_send_btn"> sign in </button>

          <!-- If JavaScript is enabled, disable submit button, before script is validate user arguments. -->
          <script>
              document.getElementById("login_send_btn").disabled = true;
          </script>

      </form>


      <div class="err_msg">
        <p class="err_msg_text"> </p>
      </div>

        <p class="message"> Already registered? </p> <a onclick="changeForm(this)" id="form_switch" name="registration" href="#" >Sign In</a>

        <!-- If JavaScript is enabled, prevent link transition -->
        <script>
            document.getElementById("change_link").addEventListener("click", function(event){event.preventDefault()});
        </script>


    </div>

  </div>

  </body>
</html>
