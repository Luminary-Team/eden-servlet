<%@ page import="java.util.List" %>
<%@ page import="model.AtvPlan" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession ses = request.getSession(false); // false significa que não criará uma nova sessão se não houver uma
    if (session != null) {
        String username = (String) session.getAttribute("nomeAdmin");
        if (username == null) {
            response.sendRedirect("/HTMLS/index.jsp");
        }
    }

//    Lista recebida da classe controller
    List<AtvPlan> atvPlansList = (List<AtvPlan>) request.getAttribute("atvPlansList");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Admins</title>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../../css/edenAreaRestritaPrimeiros_headerTopo.css">
    <link rel="stylesheet" href="../../css/edenHeader.css">
    <link rel="stylesheet" href="../../css/edenAsideAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../../css/edenTabelas.css">
    <link rel="icon" href="../../imagens/logoEden.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
            <a href="plan">Plano</a>
            <a href="edenAreaRestritaPrimeiros.jsp" id="indiceColor">Ativar Plano</a>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>Id plano</th>
            <th>Nome produto</th>
            <th>Nome usuário</th>
            <th>Nome plano</th>
            <th>Data ativação</th>
            <th>Data desativação</th>
            <th>Status</th>
            <th>Alterar status</th>
        </tr>
        <%

            // Verificando se a lista não é nula ou vazia
            if (atvPlansList != null && !atvPlansList.isEmpty()) {
                for (int i = 0; i < atvPlansList.size(); i++) {

                    int id_atv = atvPlansList.get(i).getId_act();
                    String nameProduct = atvPlansList.get(i).getName_product();
                    String nameUser = atvPlansList.get(i).getName_user();
                    String namePlan = atvPlansList.get(i).getName_plan();
                    String dataON = atvPlansList.get(i).getOn_date();
                    String dataOFF = atvPlansList.get(i).getOff_date();
                    boolean status = atvPlansList.get(i).isStatus();

        %>
        <tr class="linha">
            <td><%=id_atv%></td> <!-- id_planoAtivo -->
            <td><%=nameProduct%></td> <!-- Nome produto -->
            <td><%=nameUser%></td> <!-- Nome usuário -->
            <td><%=namePlan%></td> <!-- Nome do plano -->
            <td><%=dataON%></td> <!-- Data_ativa -->
            <td><%=dataOFF%></td> <!-- Data que será desativado -->
            <td><%=status%></td> <!-- Status - true = ativo e false = desativado -->
            <td class="icons">
                <button id="edit" class="edit-btn"><img src="../../imagens/lapis-edicao.png" alt="Editar"></button>
                <%-- POP UP DE EDITAR --%>
                <div class="popup">
                    <form class="popdentro" method="post" action="/html/areaRestrita/alterarPlan">
                        <h2>Editar Status do Plano</h2>
                        <br>
                        <h4>ID plano</h4>
                        <input type="number" value="<%=id_atv%>" name="id" readonly>
                        <br>
                        <h4>Status do plano</h4>
                        <select name="status" type="text" required="required" value="<%=status%>">
                            <option value="true">True</option>
                            <option value="false">False</option>
                        </select>
                        <input type="number" value="<%=id_atv%>" readonly hidden="hidden" name="id_plano" id="id-plano" required>
                        <br><br>
                        <div class="boxButton">
                            <button>Alterar</button>
                            <button type="button" class="closeAdd">Cancelar</button>
                        </div>
                    </form>
                </div>
            </td>
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

    <div class="partePrincipal">
        <div>
            <button class="title-btn-status">Alterar status do produto</button>
        </div>
    </div>

<script src="../../javaScript/appAtvPlan.js"></script>

</body>
</html>