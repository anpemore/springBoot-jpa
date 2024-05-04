function mostrarMensaje(){
    let nombre=document.getElementById('nombre').value;

    document.getElementById('mensaje').style.display="block";   
    let myMensaje;
    if(nombre==""){
        
       myMensaje=document.getElementById('mensaje').innerHTML="El Campo Nombre NO Debe Estar Vacio";
       document.getElementById('mensaje').style.color="red";
       document.getElementById('mensaje').style.fontSize="10px";
       document.getElementById('labelnombre').style.color="red";
       document.getElementById('nombre').style.borderColor="red";
    }

    // mensaje.innerHtml="nombre esta vacio";
    console.log(myMensaje);

}

let nombre=document.getElementById('nombre');
nombre.addEventListener('click',()=>{
    document.getElementById('mensaje').style.display="none";
    document.getElementById('nombre').style.borderColor="";
    document.getElementById('labelnombre').style.color="";
});

function onSubmit(token) {
    document.getElementById("demo-form").submit();
    console.log(token);
  }

//   function onClick(e) {
//     alert("procedimiento aqui"+e.preventDefault());
//     e.preventDefault();
//     grecaptcha.ready(function() {
//       grecaptcha.execute('6LeNcbIpAAAAAHq1LOOk2hwuBls3zvEjdEdKp8xz', {action: 'submit'}).then(function(token) {
//           alert("entro")
//       });
//     });

//     alert("ni mierda");
//   }




