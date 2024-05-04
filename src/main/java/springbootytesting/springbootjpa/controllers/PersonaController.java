package springbootytesting.springbootjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springbootytesting.springbootjpa.models.Persona;
import springbootytesting.springbootjpa.services.PersonaService;

@Controller
@RequestMapping("/web/jpa")
public class PersonaController {
  
    @Autowired
    PersonaService servicio;
    

    // @Autowired
    // PagingPersonaService paginaServicio;

 
    
    @GetMapping("/ventana")
    public String ventana(Model model){
        
        List<Persona> persomaList=(List<Persona>) servicio.listarPersona();         
        model.addAttribute("titulo", "Listado de Personas");
        model.addAttribute("lista", persomaList);
        
        persomaList.forEach(persona->{
             System.out.println(persona);
        });

        return "ventana";
    }
 
    @GetMapping("/post")
    public List<Persona> post(){
        
        List<Persona> persomaList=(List<Persona>) servicio.listarPersona();         
       
        return persomaList;
    }


    @GetMapping("/vista-save")
    public String vistaGuardarPersona(Model model){
            Persona persona=new Persona();
          
          
            model.addAttribute("persona", persona);           
            return "vista-save";                   
    } 

    @PostMapping("/guardar")
    public String vistaSave(@ModelAttribute("persona") Persona persona){
            
            System.out.println("valores llegados  "+persona);
            servicio.savePersona(persona);     
            return "redirect:/web/jpa/guardar";                   
            
    } 


    @GetMapping("/vista-Editar/{id}")
    public String formularioEditarPersona (@PathVariable Long id,Model model){
        // System.out.println("Valor entregado a por el boton para buscar"+id);
         model.addAttribute("persona",servicio.obtenerPersona(id));
         
         return "vista-editar";              
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarPersona(@PathVariable Long id,@ModelAttribute("Persona") Persona persona,Model model ){
           Persona editarPersona=servicio.obtenerPersona(id);
           editarPersona.setName(persona.getName());
           editarPersona.setLastname(persona.getLastname());
           editarPersona.setId(id);
           editarPersona.setSexo(persona.getSexo());
           editarPersona.setEdad(persona.getEdad());

           servicio.editarPersona(editarPersona);
        
          return "redirect:/web/jpa/index";                   
    } 

    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable Long id,Model model){
        servicio.deletePersona(id);
        return "redirect:/web/jpa/index";
    }

    @GetMapping("/index")
    public String BuscarName(Model model){

        
         model.addAttribute("name", "perro vieja");

         return "index";
         
          
    }

    @GetMapping("/mapa")
    public String mapa(Model model){
        String titulo="Hola Mapa";
        model.addAttribute("mapa", titulo);
        return "mapa";
    }
    
}
