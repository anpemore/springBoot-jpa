package springbootytesting.springbootjpa.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springbootytesting.springbootjpa.models.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    List<Persona> findByLastname(String lastname);
     List<Object[]> findByName(String name);
     
     @Query("select p from Persona p where p.name=?1 ")
     List<Persona> buscarPorName(String name); 
}
