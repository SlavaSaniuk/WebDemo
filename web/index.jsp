
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <link rel="stylesheet" href="styles/template.css">
    <link rel="stylesheet" href="styles/styles.css">
    <script src="libs/register_script.js"> </script>
    <title> Hello </title>
  </head>
  <body>

  <div class="login-page">

    <div class="form">

      <form class="register-form" method="post" action="${pageContext.request.contextPath}/registration" >
        <input type="text" id="user_name" placeholder="name" name="user_name"/>
        <input type="password" id="user_pass" placeholder="password" name="user_pass"
                                onblur="validatePassword(this)" onkeyup="validatePassword(this)"/>
        <input type="text" id="user_mail" placeholder="email address" name="user_mail"
                                onblur="validateMail(this, event)" onkeyup="validateMail(this, event)" />
        <button type="submit" id="send_btn"> create </button>

        <!-- If JavaScript is enabled, disable submit button, before script is validate user arguments. -->
        <script>
          document.getElementById("send_btn").disabled = true;
        </script>

      </form>
      <div class="err_msg">
        <p class="err_msg_text"> </p>
      </div>
    </div>

  </div>

  </body>
</html>
