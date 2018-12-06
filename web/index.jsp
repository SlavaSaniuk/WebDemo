<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>

    <%!
        private Boolean authenticated = Boolean.FALSE; //Session authenticated attribute
    %>

    <%
      //Create session object and set parameters to it
      session.setAttribute("authenticated", this.authenticated);
    %>

    <link rel="stylesheet" href="styles/template.css">
    <link rel="stylesheet" href="styles/styles.css">

    <script src="libs/jsObjects/SignManager.js"> </script>
    <script src="libs/SignScript.js"> </script>

    <title> Hello </title>
  </head>
  <body onload="init()">

  <div class="login-page">

    <div class="form">


      <!-- Registration form -->
      <form class="register-form" method="post" action="${pageContext.request.contextPath}/registration"
            onsubmit="return validateAllInputs();" >

        <input type="hidden" name="form_function" value="registration_form" />

        <input type="text" id="user_name" placeholder="name" name="user_name"
               oninput="validateName(this)"/>

        <input type="password" id="user_pass" placeholder="password" name="user_pass"
               oninput="validatePassword(this)"/>

        <input type="text" id="user_mail" placeholder="email address" name="user_mail"
               oninput="validateMail(this)" />

        <button type="submit" id="reg_sub_btn"> sign up </button>

        <!-- If JavaScript is enabled, disable submit button, before script is validate user arguments. -->
        <script>
          document.getElementById("reg_sub_btn").disabled = true;
        </script>

      </form>

        <!-- login form -->
      <form class="login-form" method="post" action="${pageContext.request.contextPath}/login"
            onsubmit="return validateAllInputs()">

          <input type="hidden" name="form_function" value="login_form" />

          <input type="text" id="user_login" placeholder="name or mail" name="user_login"
                 oninput="validateName(this)" />

          <input type="password" id="log_user_pass" placeholder="password" name="user_pass"
                 oninput="validatePassword(this)"/>

          <button type="submit" id="log_sub_btn"> sign in </button>



      </form>


        <!-- If JavaScript detect a in valid => show error message -->
        <p id="err_msg"> </p>


        <p class="message"> Already registered? </p> <a onclick="changeForm()" id="form_switch" name="registration" href="#" >Sign In</a>

    </div>

  </div>

  </body>
</html>
