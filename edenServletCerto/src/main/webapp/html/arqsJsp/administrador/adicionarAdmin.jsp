<%@ page import="dao.AdminDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username != null) {
// Usuário logado, pode acessar a página
            System.out.println("Acesso permitido");
        } else {
// Redireciona para login se não estiver logado
            response.sendRedirect("/HTMLS/edenLogin.jsp");
            System.out.println("Usuario que nao é admin esta querendo invadir o site");
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
    <link rel="stylesheet" href="../../../CSS's/edenAreaRestritaPrimeiros_top.css">
    <link rel="stylesheet" href="../../../CSS's/edenHeader.css">
    <link rel="stylesheet" href="../../../CSS's/edenAsideAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../../CSS's/edenPopUpAreaRestritaPrimeiros.css">
    <link rel="icon" href="../../../Imagens/logoEden.png">
    <link rel="stylesheet" href="caixaAdd.css">
</head>
<body>
    <!-- Nav-Bar -->
    <header class="main-header">
        <a href="edenAreaAdmins.jsp"><img src="../../../Imagens/logoEden.png" alt="" id="edenLogo"></a>

        <nav>
            <ul>
                <a href="edenAreaRestritaPrimeiros.jsp"><li>Área Administrativa Eden</li></a>
            </ul>
        </nav>

        <a href="">
            <%=session.getAttribute("nomeAdmin")%>
            <img src="../../../Imagens/cadeado-aberto-navbar.png" alt="" id="cadeado_navbar">
        </a>

    </header>

    <!-- Parte Fixa -->
    <div class="indice">
        <div class="background">
            <a href="../../areaRestrita/edenAreaRestritaPrimeiros_admins.jsp" id="indiceColor">Admin</a>
            <a href="../../areaRestrita/edenAreaRestritaPrimeiros_artigos.jsp">Artigo</a>
            <a href="../../areaRestrita/edenAreaRestritaPrimeiros_ativarPlano.jsp">Ativar Plano</a>
            <a href="../../areaRestrita/edenAreaRestritaPrimeiros_categoria.jsp">Categoria</a>
            <a href="../../areaRestrita/edenAreaRestritaPrimeiros_plano.jsp">Plano</a>
        </div>
    </div>

    <!-- Parte Principal -->
    <div class="partePrincipal">
        <h1>Adicione um dao </h1>
        <br>
        <form action="addAdmin" method="post">
            <input type="text" placeholder="Nome completo" name="nomeCompleto" required>
            <br>
            <input type="text" placeholder="E-mail" name="email" required>
            <br>
            <input type="password" placeholder="Senha" name="pass" required>
            <br>
            <input type="submit" value="Adicionar" id="submit">
        </form>
    </div>
</body>
</html>