<%@ page import="java.util.List" %>
<%@ page import="model.Plan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username == null) {
            response.sendRedirect("/HTMLS/edenLogin.jsp");
        }
    }

//    lista recebida pela classe controller
    List<Plan> planList = (List<Plan>) request.getAttribute("planList");
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
            <a href="categ">Categoria</a>
            <a href="edenAreaRestritaPrimeiros.jsp" id="indiceColor">Plano</a>
            <a href="atvPlan">Ativar Plano</a>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>Id plano</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Dias de duração</th>
            <th class="icons">Editar | Remover</th>
        </tr>
        <%

            // Verificando se a lista não é nula ou vazia
            if (planList != null && !planList.isEmpty()) {
                for (int i = 0; i < planList.size(); i++) {

                    int id =planList.get(i).getId_plan();
                    String nome=planList.get(i).getName();
                    String descricao=planList.get(i).getDescription();
                    double preco=planList.get(i).getPrice();
                    int dias =planList.get(i).getDuration_days();
        %>
        <tr>
            <td><%=id%></td> <!-- id_plano -->
            <td><%=nome%></td> <!-- Nome -->
            <td><%=descricao%></td> <!-- Descrição -->
            <td><%=preco%></td> <!-- Preço -->
            <td><%=dias%></td> <!-- Duração dias -->
            <td class="icons">
                <button id="edit" class="edit-btn"><img src="../../imagens/lapis-edicao.png" alt="Editar"></button>
                <button id="rmv" class="remove-btn"><img src="../../imagens/lixeira-delete.png" alt="Remover"></button>

                <%-- POP UP DE EDITAR --%>
                <div class="popup">
                    <form class="popdentro" method="post" action="/html/areaRestrita/editarPlano">
                        <h2>Editar Plano</h2>
                        <h4>ID do plano </h4>
                        <input type="number" value="<%=id%>" name="id_plan" readonly>
                        <h4>Nome do plano </h4>
                        <input type="text" value="<%=nome%>" name="name" required>
                        <h4>Descrição do plano </h4>
                        <input type="text" value="<%=descricao%>" name="description" required>
                        <h4>Preço do plano </h4>
                        <input type="number" value="<%=preco%>" name="price" required>
                        <h4>Dias de duração do plano </h4>
                        <input type="number" value="<%=dias%>" name="duration" required>
                        <input type="number" value="<%=id%>" readonly hidden="hidden" name="id_plano" id="id-plano" required>
                        <div class="boxButton">
                            <button>Alterar</button>
                            <button type="button" class="closeAdd">Cancelar</button>
                        </div>
                    </form>
                </div>

                <%-- POP UP DO DELETAR --%>
                <div class="popupRmv">
                    <form class="popdentroRmv" method="post" action="/html/areaRestrita/rmvPlano">
                        <h3>Você tem certeza disso?</h3>
                        <div class="opcaoRmv">
                            <button type="submit" class="sim">Sim</button>
                            <input type="number" value="<%=id%>" readonly hidden="hidden" name="id_plan" id="id_plan" required>
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
        <td colspan="6">Nenhum plano encontrado.</td>
        <%
            }
        %>
    </table>


    <!-- Parte Principal -->
    <div class="partePrincipal">
        <button id="addAdmin" class="add-btn">Adicionar</button>
        <!-- adicionar administrador -->
        <div class="popup">
            <form class="popdentro" action="/html/areaRestrita/addPlano" method="post">
                <h2>Adicione um Plano </h2>
                <br>
                <h4>Nome do Plano</h4>
                <input type="text" placeholder="Nome" name="name" required>
                <br>
                <h4>Descrição do Plano</h4>
                <input type="text" placeholder="Descrição" name="description" required>
                <br>
                <h4>Preço do Plano</h4>
                <input type="number" placeholder="Preço" name="price" required>
                <br>
                <h4>Dias de duração do Plano</h4>
                <input type="number" placeholder="Duração dias" name="duration" required>
                <div class="boxButton">
                    <button>Adicionar</button>
                    <button type="button" class="closeAdd">Cancelar</button>
                </div>
            </form>
        </div>
        <div>
            <button class="title-btn">Adicionar, remover ou excluir plano</button>
        </div>
    </div>

    <script src="../../javaScript/app.js"></script>

</body>
</html>