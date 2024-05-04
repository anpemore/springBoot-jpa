function eliminarpersona(id){
     swal({
        title: "Esta seguro de eliminar?",
        text: "Al eliminar, no podrás recuperar este archivo "+id,
        icon: "error",
        buttons: true,
        dangerMode: true,
      })
      .then((OK) => {
        if (OK) {
            $.ajax({
                url:"/web/jpa/delete/"+id,
                success: function(res){
                    console.log(res);
                }
            })

            swal("El archivo fue eliminado con Exito", {
            icon: "success",
          }).then((ok)=>{
              if(ok){
                 location.href="/web/jpa/ventana";
              }
          });
        } 
      });
      
}

let elementos = document.getElementsByTagName('td');
let  arreglo=[];
let j=0;
for(let i=0;i<elementos.length-1;i++){
   
    if(j<elementos.length){
       arreglo[i]=elementos[j].innerHTML;     
    }

   j=j+6;
 }   

console.log(arreglo);


$('#buscar').autocomplete({
    source:arreglo
});

$('.menu').menu();


let tabla=document.getElementsByTagName('td');
console.log(tabla);


function buscar(){
     let valor=document.querySelector('#buscar');
     console.log(valor.value);
     let tabla=document.getElementById('buscar').style.borderRadius="10px";
}

const busca=document.querySelector('#buscar');

busca.addEventListener('click',()=>{
    console.log("se preciono en buscar");
});

$("#demo-form").submit(function () {
  if($("#telefono").val().length < 1) {
    alert("El teléfono es obligatorio");
    return false;
  }

  if(isNaN($("#telefono").val())) {
    alert("El teléfono solo debe contener números");
    return false;
  }

  if($("#telefono").val().length < 10) {
    alert("El teléfono debe tener 10 caracteres. Ej. 3214568526");
    return false;
  }
  return false;
});



