<%@ page import="java.util.List" %>
<%@ page import="model.Categ" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username == null) {
            response.sendRedirect("/../../index.jsp");
        }
    }

//    Lista recebida da classe controller
    List<Categ> categList = (List<Categ>) request.getAttribute("categList");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenAreaRestritaPrimeiros_headerTopo.css">
    <link rel="stylesheet" href="../../css/edenHeader.css">
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
            <a href="arts">Artigo</a>
            <a href="edenAreaRestritaPrimeiros.jsp" id="indiceColor">Categoria</a>
            <a href="plan">Plano</a>
            <a href="atvPlan">Ativar Plano</a>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>Id categoria</th>
            <th>Categoria</th>
            <th>Descrição</th>
            <th class="icons">Editar | Remover</th>
        </tr>
        <%

            // Verificando se a lista não é nula ou vazia
            if ( categList != null && !categList.isEmpty()) {
                for (int i = 0; i < categList.size(); i++) {

                    int id = categList.get(i).getPk_id();
                    String categoria = categList.get(i).getCategory();
                    String descricao = categList.get(i).getDesciption();
        %>
        <tr>
            <td><%=id%></td> <!-- pk_id -->
            <td><%=categoria%></td> <!-- categoria -->
            <td><%=descricao%></td> <!-- descrição -->
            <td class="icons">
                <button id="edit" class="edit-btn"><img src="../../imagens/lapis-edicao.png" alt="Editar"></button>
                <button id="rmv" class="remove-btn"><img src="../../imagens/lixeira-delete.png" alt="Remover"></button>

                <%-- POP UP DE EDITAR --%>
                <div class="popup">
                    <form class="popdentro" method="post" action="/jsp/areaRestrita/editarCateg">
                        <h2>Editar categoria</h2>
                        <h4>ID da categoria </h4>
                        <input type="number" value="<%=id%>" name="id_categ" readonly>
                        <h4>Nome da categoria </h4>
                        <input type="text" value="<%=categoria%>" name="category" required>
                        <h4>Descrição da categoria </h4>
                        <input type="text" value="<%=descricao%>" name="description" required>
                        <input type="number" value="<%=id%>" readonly hidden="hidden" name="id_categ" id="id-categ" required>
                        <div class="boxButton">
                            <button>Alterar</button>
                            <button type="button" class="closeAdd">Cancelar</button>
                        </div>
                    </form>
                </div>

                <%-- POP UP DO DELETAR --%>
                <div class="popupRmv">
                    <form class="popdentroRmv" method="post" action="/jsp/areaRestrita/rmvCateg">
                        <h3>Você tem certeza disso?</h3>
                        <div class="opcaoRmv">
                            <button type="submit" class="sim">Sim</button>
                            <input type="number" value="<%=id%>" readonly hidden="hidden" name="id_categ" id="id_categ" required>
                            <button type="button" class="nao">Cancelar</button>
                        </div>
                    </form>
                </div>

        </tr>

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


    <!-- Parte Principal -->
    <div class="partePrincipal">
        <button id="addAdmin" class="add-btn">Adicionar</button>
        <!-- adicionar administrador -->
        <div class="popup">
            <form class="popdentro" action="/jsp/areaRestrita/addCateg" method="post">
                <h2>Adicione uma categotia </h2>
                <br>
                <h4>Nome da categoria </h4>
                <input type="text" placeholder="Categoria" name="category" required>
                <br>
                <h4>Descrição da categoria </h4>
                <input type="text" placeholder="Descrição" name="description" required>
                <div class="boxButton">
                    <button>Adicionar</button>
                    <button type="button" class="closeAdd">Cancelar</button>
                </div>
            </form>
        </div>

        <h1 class="title-table">Gerenciar categorias</h1>
    </div>

    <script src="../../javaScript/app.js"></script>

</body>
</html>