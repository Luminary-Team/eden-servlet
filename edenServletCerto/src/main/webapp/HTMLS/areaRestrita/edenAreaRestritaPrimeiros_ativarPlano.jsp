<%@ page import="java.util.List" %>
<%@ page import="model.AtvPlan" %>
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

    List<AtvPlan> atvPlansList = (List<AtvPlan>) request.getAttribute("atvPlansList");

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
            <a href="atvPlan" id="indiceColor">Ativar Plano</a>
            <a href="categ">Categoria</a>
            <a href="plan">Plano</a>
        </div>
    </div>

    <!-- Tabela -->
    <table>
        <tr>
            <th>ID_ACT</th>
            <th>ID_PRODUTO</th>
            <th>ID_USER</th>
            <th>ID_PLANO</th>
            <th>ATIVADO_DATA</th>
            <th>DESATIVADO_DATA</th>
            <th>STATUS</th>
            <th class="icons">EDITAR | REMOVER</th>
        </tr>
        <%

            // Verificando se a lista não é nula ou vazia
            if (atvPlansList != null && !atvPlansList.isEmpty()) {
                for (int i = 0; i < atvPlansList.size(); i++) {

                    int id_atv = atvPlansList.get(i).getId_act();
                    int id_prod = atvPlansList.get(i).getProduct_id();
                    int id_user = atvPlansList.get(i).getUser_id();
                    int id_plano = atvPlansList.get(i).getPlan_id();
                    String dataON = atvPlansList.get(i).getOn_date();
                    String dataOFF = atvPlansList.get(i).getOff_date();
                    boolean status = atvPlansList.get(i).isStatus();

        %>
        <tr>
            <td><%=id_atv%></td>
            <td><%=id_prod%></td>
            <td><%=id_user%></td>
            <td><%=id_plano%></td>
            <td><%=dataON%></td>
            <td><%=dataOFF%></td>
            <td><%=status%></td>
            <td class="icons">
                <a href="editar?id=<%=id_atv%>"><img src="../../Imagens/lapis-edicao.png" alt="Editar"></a>
                <a href="remover?id=<%=id_atv%>"><img src="../../Imagens/lixeira-delete.png" alt="Remover"></a>
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

</body>
</html>