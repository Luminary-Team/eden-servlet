<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username == null) {
            response.sendRedirect("/jsp/areaRestrita/index.jsp");
        }
    }
%>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenAreaAdmins.css">
    <link rel="stylesheet" href="../../css/edenHeader.css">
    <link rel="icon" href="../../imagens/logoEden.png">
</head>
<body>
    <!-- Nav-Bar -->
    <header class="main-header">
        <a href="../areaRestrita/edenAreaAdmins.jsp"><img src="../../imagens/logoEden.png" alt="" id="edenLogo"></a>

        <nav>
            <ul>
                <li>Área Administrativa Eden</li>
            </ul>
        </nav>

        <img src="../../imagens/cadeado-aberto-navbar.png" alt="" id="cadeado_navbar">
    </header>
    <div class="nomeAdmin" style="position: absolute; float: right; right: 4%; top: 2.5%; z-index: 1000"><%= session.getAttribute("nomeAdmin")%></div>

    <!-- Parte Principal -->
    <div class="partePrincipal">
        <div class="divisao">
            <h1>1° ano<br>Administração</h1>
            <a href="edenAreaRestritaPrimeiros.jsp">Entrar</a>
        </div>

        <div class="divisao">
            <h1>2° ano<br>Administração</h1>
            <a href="https://eden-restrict-area.onrender.com/">Entrar</a>
        </div>
    </div>

    <a href="../../index.html" class="exit"><img src="../../imagens/exit.png" style="width: 50px; position: absolute; float: right; top: 90%; right: 2%"></a>
</body>
</html>
