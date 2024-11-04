$(".edit-btn").click(function (){
    this.parentElement.children[1].style.display = "flex";
})

$(".closeAdd").click(function (){
    this.parentElement.parentElement.parentElement.style.display = "none";
})