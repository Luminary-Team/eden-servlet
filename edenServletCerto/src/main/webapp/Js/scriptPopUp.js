// Script Pop-UP Área Restrita
// variavéis
var popup = document.getElementById("pop-up");
var button = document.getElementById("openPop-Up"); // botão que abre o pop-up
var span = document.getElementsByClassName("closePop-Up")[0]; // botão que fecha o pop-up

// Quando o botão é clicado, o pop-up aparece
button.onclick = function() {
  popup.style.display = "flex";
}

// Quando clicar no botão de fechar ele desaparece
span.onclick = function() {
  popup.style.display = "none";
}