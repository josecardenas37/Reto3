/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutoria.domingo.servicios;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutoria.domingo.modelo.Cabanas;
import tutoria.domingo.repositorio.RepositorioCabanas;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosCabanas {
     @Autowired
    private RepositorioCabanas metodosCrud;
    
    public List<Cabanas> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Cabanas> getLacabana(int idLacabana){
        return metodosCrud.getLacabana(idLacabana);
    }
    
    public Cabanas save(Cabanas lacabana){
        if(lacabana.getId()==null){
            return metodosCrud.save(lacabana);
        }else{
            Optional<Cabanas> evt=metodosCrud.getLacabana(lacabana.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(lacabana);
            }else{
                return lacabana;
            }
        }
    }
    public Cabanas update(Cabanas cabanas){
        if(cabanas.getId()!=null){
            Optional<Cabanas> e=metodosCrud.getLacabana(cabanas.getId());
            if(!e.isEmpty()){
                if(cabanas.getName()!=null){
                    e.get().setName(cabanas.getName());
                }
                if(cabanas.getBrand()!=null){
                    e.get().setBrand(cabanas.getBrand());
                }
                if(cabanas.getRooms()!=null){
                    e.get().setRooms(cabanas.getRooms());
                }
                if(cabanas.getDescription()!=null){
                    e.get().setDescription(cabanas.getDescription());
                }
                if(cabanas.getCategory()!=null){
                    e.get().setCategory(cabanas.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabanas;
            }
        }else{
            return cabanas;
        }
    }


    public boolean deleteCabanas(int cabinId) {
        Boolean aBoolean = getLacabana(cabinId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
