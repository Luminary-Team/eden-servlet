<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Admin" %>
<%
    HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username == null) {
            response.sendRedirect("/HTMLS/index.jsp");
        }
    }

    // Lista recebida da classe controller

    List<Admin> adminList = (List<Admin>) request.getAttribute("adminList");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="../../javaScript/app.js" defer></script>
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
            <a href="edenAreaRestritaPrimeiros.jsp" id="indiceColor">Admin</a>
            <a href="arts">Artigo</a>
            <a href="categ">Categoria</a>
            <a href="plan">Plano</a>
            <a href="atvPlan">Ativar Plano</a>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>Id admin</th>
            <th>Nome Completo</th>
            <th>E-mail</th>
            <th>Senha</th>
            <th>Editar | Remover</th>
        </tr>
        <%
            // Verificando se a lista não é nula ou vazia
            if (adminList != null && !adminList.isEmpty()) {
                for (int i = 0; i < adminList.size(); i++) {

                int id = adminList.get(i).getId_admin();
                String nome=adminList.get(i).getNomeCompleto();
                String email =adminList.get(i).getEmail();
                String senha=adminList.get(i).getSenha();
        %>
        <tr>
            <td><%= id %></td> <!-- id_admin -->
            <td><%= nome%></td> <!-- Nome completo -->
            <td><%= email %></td> <!-- Email -->
            <td>********</td> <!-- Senha com asteristicos para não mostrá-la-->

            <td class="icons">
                <button id="edit" class="edit-btn"><img src="../../imagens/lapis-edicao.png" alt="Editar"></button>
                <button id="rmv" class="remove-btn"><img src="../../imagens/lixeira-delete.png" alt="Remover"></button>

                <%-- POP UP DE EDITAR --%>
                <div class="popup">
                    <form class="popdentro" method="post" action="/jsp/arqsJsp/areaRestrita/editarAdmin">
                        <h2>Editar administrador</h2>
                         <h4>ID do administrador</h4>
                        <input type="number" value="<%=id%>" name="id-admin" readonly>
                        <h4>Nome do administrador</h4>
                        <input type="text" value="<%=nome%>" name="nome" required>
                        <h4>E-mail do administrador</h4>
                        <input type="email" value="<%=email%>" name="email" required>
                        <h4>Senha do administrador</h4>
                        <input type="password" value="<%=senha%>" name="senha" required>
                        <input type="number" value="<%=adminList.get(i).getId_admin()%>" readonly hidden="hidden" name="id-admin" required>
                        <div class="boxButton">
                            <button>Alterar</button>
                            <button type="button" class="closeAdd">Cancelar</button>
                        </div>
                    </form>
                </div>

                <%-- POP UP DO DELETAR --%>
                <div class="popupRmv">
                    <form class="popdentroRmv" method="post" action="/jsp/arqsJsp/administrador/rmvAdmin">
                        <h3>Você tem certeza disso?</h3>
                        <div class="opcaoRmv">
                            <button type="submit" class="sim">Sim</button>
                            <input type="number" value="<%=adminList.get(i).getId_admin()%>" readonly hidden="hidden" name="id-admin" required>
                            <button type="button" class="nao">Cancelar</button>
                        </div>
                    </form>
                </div>
            </td>
        </tr>
        <%
            }
        } else {
        %>
        <td colspan="6">Nenhum administrador encontrado.</td>
        <%
            }
        %>
    </table>

    <%-- Botão de adicionar --%>
    <div class="partePrincipal">
        <button id="addAdmin" class="add-btn">Adicionar</button>
        <!-- adicionar administrador -->
        <div class="popup">
            <form class="popdentro" action="/jsp/arqsJsp/administrador/addAdmin" method="post">
                <h2>Adicione um administrador </h2>
                <br>
                <h4>Nome completo</h4>
                <input type="text" placeholder="Nome completo" name="nomeCompleto" required>
                <br>
                <h4>E-mail</h4>
                <input type="text" placeholder="E-mail" name="email" required>
                <br>
                <h4>Senha de 8 digitos e caracteres especiais</h4>
                <input type="password" placeholder="Senha" name="pass" required>
                <br>
                <div class="boxButton">
                    <button>Adicionar</button>
                    <button type="button" class="closeAdd">Cancelar</button>
                </div>
            </form>
        </div>
        <div>
            <button class="title-btn">Gerenciar administradores</button>
        </div>
    </div>

</body>
</html>
