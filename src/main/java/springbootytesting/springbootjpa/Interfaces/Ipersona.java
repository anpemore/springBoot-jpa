package springbootytesting.springbootjpa.Interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import springbootytesting.springbootjpa.models.Persona;

public interface Ipersona {
    List<Persona> listarPersona();
       Persona obtenerPersona(Long id);
       Persona editarPersona(Persona persona);
       Persona savePersona(Persona persona);
       void deletePersona(Long id);

       public ResponseEntity<Persona> search();
}
