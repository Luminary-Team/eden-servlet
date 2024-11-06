<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenLogin.css">
    <link rel="stylesheet" href="../../css/edenHeader.css">
    <link rel="stylesheet" href="../../css/media-query-header.css">
    <link rel="icon" href="../../imagens/logoEden.png">
</head>

<body>
    <!-- Nav-Bar -->
    <header class="main-header">
        <a href="../../index.html"><img src="../../imagens/logoEden.png" alt="" id="edenLogo"></a>

        <nav>
            <ul>
                <li><a href="https://eden-landing-page.onrender.com/index.html">Início</a></li>
                <li><a href="https://eden-landing-page.onrender.com/html/edenQuemSomos.html">Quem somos</a></li>
                <li><a href="https://eden-landing-page.onrender.com/index.html#app">App</a></li>
            </ul>
        </nav>

        <a href="index.jsp"><img src="../../imagens/cadeado-navbar.png" alt="" id="cadeado_navbar"></a>
    </header>

    <img src="../../imagens/cadeado-login.png" alt="cadeado" id="cadeado-login">
    <div class="partePrincipal">
        <h1>Área Restrita </h1>
        <p>Área resevada para administradores do grupo Luminary</p>
        <form action="../../jsp/areaRestrita/edenlogin" method="post">
            <input type="text" placeholder="User" name="user" required>
            <input type="password" placeholder="Senha" name="passwd" required>
            <input type="submit" value="Login" id="submit">
        </form>
    </div>

        <br>

    <% String message = (String) session.getAttribute("erro");
//    Recebe mensagem de erro passado na classe controller
    %>
    <% if (message != null) { %>
        <div id="message-box" class="conteudoPop-Up">
            <h5>Usuário ou senha inválidos!<br>Por favor, verifique e tente novamente.</h5>
        </div>

    <script>
        // Definir um tempo para esconder a mensagem após 5 segundos (5000 milissegundos)
        setTimeout(function() {
            var messageBox = document.getElementById('message-box');
            if (messageBox) {
                messageBox.style.display = 'none'; // Ocultar a mensagem
            }
        }, 3000); // 3000 milissegundos = 3 segundos
    </script>
    <%}%>
</body>
</html>