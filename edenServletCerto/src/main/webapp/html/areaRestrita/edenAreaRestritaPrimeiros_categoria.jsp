<%@ page import="java.util.List" %>
<%@ page import="model.Categ" %>
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

    List<Categ> categList = (List<Categ>) request.getAttribute("categList");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../CSS's/edenAreaRestritaPrimeiros_top.css">
    <link rel="stylesheet" href="../../CSS's/edenHeader.css">
    <link rel="stylesheet" href="../../CSS's/edenAsideAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../CSS's/edenPopUpAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../../CSS's/tabelas.css">
    <link rel="icon" href="../../Imagens/EDEN%20logotipo%20png.png">
</head>
<body>
    <!-- Nav-Bar -->
    <header class="main-header">
        <a href="edenAreaAdmins.jsp"><img src="../../Imagens/EDEN%20logotipo%20png.png" alt="" id="edenLogo"></a>

        <nav>
            <ul>
                <a href="edenAreaRestritaPrimeiros.jsp"><li>Área Administrativa Eden</li></a>
            </ul>
        </nav>
        <%= session.getAttribute("nomeAdmin")%>
        <img src="../../Imagens/cadeado-navbar.png" alt="" id="cadeado_navbar">
    </header>

    <!-- Parte Fixa -->
    <div class="indice">
        <div class="background">
            <a href="admins">Admin</a>
            <a href="arts">Artigo</a>
            <a href="atvPlan">Ativar Plano</a>
            <a href="categ" id="indiceColor">Categoria</a>
            <a href="plan">Plano</a>
        </div>
    </div>

    <!-- Parte Principal -->
    <div class="partePrincipal">
        <div class="top">
            <button id="openPop-Up">Adicionar categoria</button>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>PK_ID</th>
            <th>CATEGORIA</th>
            <th>DESCRIÇÃO</th>
            <th class="icons">EDITAR | REMOVER</th>
        </tr>
        <%

            // Verificando se a lista não é nula ou vazia
            if ( categList != null && !categList.isEmpty()) {
                for (int i = 0; i < categList.size(); i++) {
        %>
        <tr>
            <td><%= categList.get(i).getPk_id() %></td> <!-- pk_id -->
            <td><%= categList.get(i).getCategory()%></td> <!-- categoria -->
            <td><%= categList.get(i).getDesciption() %></td> <!-- descrição -->
            <td class="icons">
                <a href="editar?id=<%= categList.get(i).getPk_id() %>"><img src="../../Imagens/lapis-edicao.png" alt="Editar"></a>
                <a href="remover?id=<%= categList.get(i).getPk_id() %>"><img src="../../Imagens/lixeira-delete.png" alt="Remover"></a>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <td colspan="6">Nenhuma categoria encontrada.</td>
        <%
            }
        %>
    </table>
</body>
</html>