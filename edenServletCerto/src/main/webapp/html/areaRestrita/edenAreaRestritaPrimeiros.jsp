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
    <link rel="stylesheet" href="../../CSS's/edenAreaRestritaPrimeiros.css">
    <link rel="stylesheet" href="../../CSS's/edenHeader.css">
    <link rel="stylesheet" href="../../CSS's/edenAsideAreaRestritaPrimeiros.css">
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
            <a href="categ">Categoria</a>
            <a href="plan">Plano</a>
        </div>
    </div>

    <!-- Parte Principal -->
    <div class="partePrincipal">
        <img src="../../Imagens/Cadeado.png" alt="" id="cadeado">
        <div class="seguranca">
            <h1>Segurança</h1>
            <p>
                Acesso exclusivo para usuários autorizados. Ao realizar o login com suas credenciais, poderá visualizar informações confidenciais. Aqui, você poderá consultar dados, baixar documentos e realizar ajustes na sua conta. Todas as atividades são protegidas por criptografia. Em caso de problemas, contate o suporte.
            </p>
        </div>
        <img src="../../Imagens/roboEden.png" alt="" id="robo">
    </div>
</body>
</html>