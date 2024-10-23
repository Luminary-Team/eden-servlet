<%@ page import="java.util.List" %>
<%@ page import="model.Artgs" %>
<%@ page import="controller.artigos.Artigos" %>
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
            response.sendRedirect("/html/edenLogin.jsp");
            System.out.println("Usuario que nao é admin esta querendo invadir o site");
        }
    }

    List<Artgs> artgsList = (List<Artgs>) request.getAttribute("artsList");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenAreaRestritaPrimeiros_top.css">
    <link rel="stylesheet" href="../../css/edenHeader.css">
    <link rel="stylesheet" href="../../css/edenAsideAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../../css/tabelas.css">
    <link rel="icon" href="../../imagens/logoEden.png">
</head>
<body>
    <!-- Nav-Bar -->
    <header class="main-header">
        <a href="edenAreaAdmins.jsp"><img src="../../imagens/logoEden.png" alt="" id="edenLogo"></a>

        <nav>
            <ul>
                <a href="edenAreaRestritaPrimeiros.jsp"><li>Área Administrativa Eden</li></a>
            </ul>
        </nav>
        <%= session.getAttribute("nomeAdmin")%>
        <img src="../../imagens/cadeado-navbar.png" alt="" id="cadeado_navbar">
    </header>

    <!-- Parte Fixa -->
    <div class="indice">
        <div class="background">
            <a href="admins">Admin</a>
            <a href="arts" id="indiceColor">Artigo</a>
            <a href="atvPlan">Ativar Plano</a>
            <a href="categ">Categoria</a>
            <a href="plan">Plano</a>
        </div>
    </div>

    <!-- Parte Principal -->
    <div class="partePrincipal">
        <div class="top">
            <button id="openPop-Up">Adicionar artigo</button>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>ID_NOTICIA</th>
            <th>MANCHETE</th>
            <th>URL_NOTICIA</th>
            <th>FONTE</th>
            <th class="icons">EDITAR | REMOVER</th>
        </tr>
        <%

            // Verificando se a lista não é nula ou vazia
            if (artgsList != null && !artgsList.isEmpty()) {
                for (int i = 0; i < artgsList.size(); i++) {


                    int id = artgsList.get(i).getId_article();
                    String artigo = artgsList.get(i).getHeadline();
                    String url = artgsList.get(i).getNews_url();
                    String fonte = artgsList.get(i).getSource();
        %>
        <tr>
            <td><%=id%></td> <!-- id_artigo -->
            <td><%=artigo%></td> <!-- Artigs -->
            <td><%=url%></td> <!-- url_noticia -->
            <td><%=fonte%></td> <!-- fonte -->
            <td class="icons">
                <a href="editar?id=<%= id %>"><img src="../../imagens/lapis-edicao.png" alt="Editar"></a>
                <a href="remover?id=<%= id %>"><img src="../../imagens/lixeira-delete.png" alt="Remover"></a>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <td colspan="6">Nenhum artigo encontrado.</td>
        <%
            }
        %>
    </table>

</body>
</html>