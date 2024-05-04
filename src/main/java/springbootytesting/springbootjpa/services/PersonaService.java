package springbootytesting.springbootjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import springbootytesting.springbootjpa.Interfaces.Ipersona;

import springbootytesting.springbootjpa.models.Persona;
import springbootytesting.springbootjpa.repositorys.PersonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements Ipersona{
   
    @Autowired
    PersonaRepository repository; 

   
    @Override
    public Persona savePersona(Persona persona) {        
        repository.save(persona);
        return persona;
    }

    @Override
    public List<Persona> listarPersona() {
      
        return (List<Persona>) repository.findAll();
    }

    @Override
    public void deletePersona(Long id) {
        if (id!=null) {
           repository.deleteById(id);
        }
        
    }

    @Override
    public Persona obtenerPersona(Long id) {
       if (id!=null) {
        return repository.findById(id).get();
       }
          
       return null;
    }

    @Override
    public Persona editarPersona(Persona persona) {
          if (persona!=null) {
             return repository.save(persona);
          }
           return null;
    
    }
  

    public List<Persona> findByLastname(String apellido){
        List<Persona> listaApellidos= repository.findByLastname(apellido);
        return listaApellidos;   
    }
   
    public List<Object[]> findByName(String name){
        List<Object[]> listaNombre= repository.findByName(name);
        return listaNombre;   
    }

    @Override
    public ResponseEntity<Persona> search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    


}