document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.getElementById('loginForm');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');

    // Evento de submit do formulário
    loginForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevenir o comportamento padrão do formulário

        // Acessar valores do formulário
        const username = usernameInput.value;
        const password = passwordInput.value;

        // Salvar no localStorage
        localStorage.setItem('username', username);
        localStorage.setItem('password', password);

        // Simular autenticação (em uma aplicação real, deveria verificar esses dados no servidor)
        alert('Login realizado com sucesso!');

        // Redirecionar para a página da área de admins
        window.location.href = 'edenAreaAdmins.jsp';
    });

    // Capturar o evento também na fase de captura
    loginForm.addEventListener('click', function (event) {
        console.log('Evento capturado na fase de captura', event.target);
    }, true); // O terceiro parâmetro 'true' indica que o evento deve ser capturado na fase de captura
});
