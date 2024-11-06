<%@ page import="java.util.List" %>
<%@ page import="model.Artgs" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username == null) {
            response.sendRedirect("/jsp/areaRestrita/index.jsp");
        }
    }

    // Lista recebida pela classe controller

    List<Artgs> artgsList = (List<Artgs>) request.getAttribute("artsList");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenHeader.css">
    <link rel="stylesheet" href="../../css/edenAreaRestritaPrimeiros_headerTopo.css">
    <link rel="stylesheet" href="../../css/edenAsideAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../../css/edenTabelas.css">
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
    <div class="nomeAdmin" style="position: fixed; float: right; right: 4%; top: 2.5%; z-index: 1000"><%= session.getAttribute("nomeAdmin")%></div>

    <!-- Parte Fixa -->
    <div class="indice">
        <div class="background">
            <a href="admins">Admin</a>
            <a href="edenAreaRestritaPrimeiros.jsp" id="indiceColor" >Artigo</a>
            <a href="categ">Categoria</a>
            <a href="plan">Plano</a>
            <a href="atvPlan">Ativar Plano</a>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>Id notícia</th>
            <th>Manchete</th>
            <th>Url da notícia</th>
            <th>Fonte</th>
            <th class="icons">Editar | Remover</th>
        </tr>
        <%

            // Verificando se a lista não é nula ou vazia
            if (artgsList != null && !artgsList.isEmpty()) {
                for (int i = 0; i < artgsList.size(); i++) {

                    int id = artgsList.get(i).getId_article();
                    String artigo = artgsList.get(i).getHeadline();
                    String url = artgsList.get(i).getNews_url();
                    String font = artgsList.get(i).getSource();
        %>
        <tr>
            <td><%=id%></td> <!-- id_artigo -->
            <td><%=artigo%></td> <!-- Artigs -->
            <td><%=url%></td> <!-- url_noticia -->
            <td><%=font%></td> <!-- fonte -->
            <td class="icons">
                <button id="edit" class="edit-btn"><img src="../../imagens/lapis-edicao.png" alt="Editar"></button>
                <button id="rmv" class="remove-btn"><img src="../../imagens/lixeira-delete.png" alt="Remover"></button>

                <%-- POP UP DE EDITAR --%>
                <div class="popup">
                    <form class="popdentro" method="post" action="/jsp/areaRestrita/editarArtigos">
                        <h2>Editar artigo</h2>
                        <h4>ID do artigo </h4>
                        <input type="number" value="<%=id%>" name="id_article" readonly>
                        <h4>Nome do artigo </h4>
                        <input type="text" value="<%=artigo%>" name="headline" required>
                        <h4>URL do artigo </h4>
                        <input type="text" value="<%=url%>" name="news_url" required>
                        <h4>Fonte do artigo </h4>
                        <input type="text" value="<%=font%>" name="source" required>
                        <input type="number" value="<%=id%>" readonly hidden="hidden" name="id-admin" id="id-article" required>
                        <div class="boxButton">
                            <button>Alterar</button>
                            <button type="button" class="closeAdd">Cancelar</button>
                        </div>
                    </form>
                </div>

                <%-- POP UP DO DELETAR --%>
                <div class="popupRmv">
                    <form class="popdentroRmv" method="post" action="/jsp/areaRestrita/rmvArtigos">
                        <h3>Você tem certeza disso?</h3>
                        <div class="opcaoRmv">
                            <button type="submit" class="sim">Sim</button>
                            <input type="number" value="<%=artgsList.get(i).getId_article()%>" readonly hidden="hidden" name="id_article" id="id_article" required>
                            <button type="button" class="nao">Cancelar</button>
                        </div>
                    </form>
                </div>

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


    <!-- Parte Principal -->
    <div class="partePrincipal">
        <button id="addAdmin" class="add-btn">Adicionar</button>
        <!-- adicionar artigo -->
        <div class="popup">
            <form class="popdentro" action="/jsp/areaRestrita/addArtigo" method="post">
                <h2>Adicione um Artigo</h2>
                <br>
                <h4>Nome da manchete</h4>
                <input type="text" placeholder="Manchete" name="headline" required>
                <br>
                    <h4>Url do artigo</h4>
                <input type="text" placeholder="URL" name="news_url" required>
                <br>
                    <h4>Fonte do antigo</h4>
                <input type="text" placeholder="fonte" name="source" required>
                <br>
                <div class="boxButton">
                    <button>Adicionar</button>
                    <button type="button" class="closeAdd">Cancelar</button>
                </div>
            </form>
        </div>

        <h1 class="title-table">Gerenciar artigos</h1>
    </div>

<script src="../../javaScript/app.js"></script>

</body>
</html>