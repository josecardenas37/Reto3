/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutoria.domingo.interfaces.InterfaceOrtesis;
import tutoria.domingo.modelo.Mensaje;
import tutoria.domingo.modelo.Cabanas;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioCabanas {
     @Autowired
    private InterfaceOrtesis crud;
    

    public List<Cabanas> getAll(){
        return (List<Cabanas>) crud.findAll();       
    }
    
    public Optional <Cabanas> getLacabana(int id){
        return crud.findById(id);
    }
    
    public Cabanas save(Cabanas cabanas){
        return crud.save(cabanas);
    }
      public void delete(Cabanas cabanas){
        crud.delete(cabanas);
    }
    
    
}
