<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username == null) {
            response.sendRedirect("/HTMLS/index.jsp");
        }
    }
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenHeader.css">
    <link rel="stylesheet" href="../../css/edenAsideAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../../css/edenAreaRestritaPrimeiros_inserido.css">
    <link rel="icon" href="../../imagens/logoEden.png">
</head>
<body>
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

<!-- Parte Fixa -->
<div class="indice">
    <div class="background">
        <a href="../areaRestrita/admins">Admin</a>
        <a href="../areaRestrita/arts">Artigo</a>
        <a href="../areaRestrita/categ">Categoria</a>
        <a href="../areaRestrita/plan">Plano</a>
        <a href="../areaRestrita/atvPlan">Ativar Plano</a>
    </div>
</div>

<!-- Parte Principal -->
<div class="partePrincipal">
    <img src="../../imagens/roboEden.png" alt="roboEden">
    <h3>Dados atualizados com sucesso!</h3>
</div>
</body>
</html>