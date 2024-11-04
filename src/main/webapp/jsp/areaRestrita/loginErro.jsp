<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Ajuste os caminhos para suas folhas de estilo -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenLogin.css">
    <link rel="stylesheet" href="../../css/edenHeader.css">
    <link rel="icon" href="../../imagens/logoEden.png">
</head>

<body>
<!-- Nav-Bar -->
<header class="main-header">
    <a href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/imagens/logoEden.png" alt="" id="edenLogo"></a>

    <nav>
        <ul>
            <li><a href="../../index.jsp">Início</a></li>
            <li><a href="../edenQuemSomos.html">Quem somos</a></li>
            <li><a href="../../index.jsplink do segundo ano">App</a></li>
        </ul>
    </nav>

    <a href="../../index.jsp"><img src="../../imagens/cadeado-navbar.png" alt="" id="cadeado_navbar"></a>
</header>

<img src="../../imagens/cadeado-login.png" alt="" id="cadeado">
<div class="partePrincipal">
    <h1>Área Restrita</h1>
    <p>Área reservada para administradores do grupo Luminary</p>
    <form action="./jsp/edenlogin" method="post">
        <input type="text" placeholder="User" name="user" required>
        <input type="password" placeholder="Senha" name="passwd" required>
        <input type="submit" value="Login" id="submit">
    </form>
</div>

<!-- Pop-up -->
<div id="pop-upLogin" class="pop-upLogin">
    <div class="conteudoPop-Up">
        <span class="closePop-UpLogin">&times;</span>
        <h5>Usuário ou senha inválidos!<br>Por favor, verifique e tente novamente.</h5>
    </div>
</div>
</body>
</html>
