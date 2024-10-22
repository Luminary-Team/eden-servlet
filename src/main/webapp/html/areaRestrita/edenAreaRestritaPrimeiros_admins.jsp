<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Admin" %>
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

    List<Admin> adminList = (List<Admin>) request.getAttribute("adminList");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
    <div class="nomeCadeado">
        <a href="">
            <%=session.getAttribute("nomeAdmin")%>
            <img src="../../imagens/cadeado-navbar.png" alt="" id="cadeado_navbar">
        </a>
    </div>
</header>

<!-- Parte Fixa -->
<div class="indice">
    <div class="background">
        <a href="admins" id="indiceColor">Admin</a>
        <a href="arts">Artigo</a>
        <a href="atvPlan">Ativar Plano</a>
        <a href="categ">Categoria</a>
        <a href="plan">Plano</a>
    </div>
</div>

<!-- Parte Principal -->
<div class="partePrincipal">
    <div class="top">
        <button id="openPop-Up"><a href="../arqsJsp/administrador/adicionarAdmin.jsp">Adicionar administrador</a></button>
    </div>
</div>

<!-- Tabela -->
<table>
    <tr id="cabecalho">
        <th>ID_ADMIN</th>
        <th>NOME COMPLETO</th>
        <th>EMAIL</th>
        <th>SENHA</th>
        <th class="icons">EDITAR | REMOVER</th>
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
        <td><%= senha %></td> <!-- Senha -->

        <td class="icons">
                <button id="edit" class="edit-btn"><img src="../../imagens/lapis-edicao.png" alt="Editar"></button>
                <button id="rmv" class="remove-btn"><img src="../../imagens/lixeira-delete.png" alt="Remover"></button>

            <%-- POP UP DE EDITAR  --%>
            <div class="popup">
                <form class="popdentro" method="post" action="/html/arqsJsp/areaRestrita/editarAdmin">
                    <input type="number" value="<%=id%>" name="id-admin" readonly>
                    <input type="text" value="<%=nome%>" name="nome" required>
                    <input type="email" value="<%=email%>" name="email" required>
                    <input type="password" value="<%=senha%>" name="senha" required>
                    <input type="number" value="<%=adminList.get(i).getId_admin()%>" readonly hidden="hidden" name="id-admin" id="id-admin" required>
                    <button>Alterar</button>
                    <button type="button" class="close">X</button>
                    <%-- Arrumar a posição do X e o design do form --%>
                </form>
            </div>

            <%-- POP UP DO DELETAR --%>
            <div class="popupRmv">
                <form class="popdentroRmv" method="post" action="/html/arqsJsp/administrador/rmvAdmin">
                    <h3>Você tem certeza disso?</h3>
                    <div class="opcaoRmv">
                        <button type="submit" class="sim">SIM</button>
                        <input type="number" value="<%=adminList.get(i).getId_admin()%>" readonly hidden="hidden" name="id-admin" id="id-admin" required>
                        <button type="button" class="nao">NÃO</button>
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

<script src="../../javaScript/app.js"></script>
</body>
</html>
