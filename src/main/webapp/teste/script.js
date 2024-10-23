// Obtém o modal
var modal = document.getElementById("popup");

// Botão que abre o modal
var btn = document.getElementById("openPopup");

// Elemento <span> que fecha o modal
var span = document.getElementsByClassName("close")[0];

// Quando o botão é clicado, o modal aparece
btn.onclick = function() {
  modal.style.display = "flex";
}

// Quando o botão de fechar (X) é clicado, o modal desaparece
span.onclick = function() {
  modal.style.display = "none";
}

// Quando o usuário clica fora do modal, ele também desaparece
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
