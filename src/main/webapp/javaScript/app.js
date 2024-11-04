$(".add-btn").click(function (){
    this.parentElement.children[1].style.display = "flex";
})

$(".closeAdd").click(function (){
    this.parentElement.parentElement.parentElement.style.display = "none";
})

$(".remove-btn").click(function (){
    this.parentElement.children[3].style.display = "flex";
})

$(".nao").click(function (){
    this.parentElement.parentElement.parentElement.style.display = "none";
})

$(".edit-btn").click(function (){
    this.parentElement.children[2].style.display = "flex";
})

$(".close").click(function (){
    this.parentElement.parentElement.style.display = "none";
})