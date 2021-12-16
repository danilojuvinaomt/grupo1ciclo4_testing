/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.repositorios;

import co.edu.usa.grupo1ciclo4.crud.CrudProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.grupo1ciclo4.modelo.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author juvinao
 */
@Repository
public class ProductoRepository {
    
    @Autowired
    private CrudProductoRepository repo;
    
    public List<Producto> getAll(){
        return repo.findAll();
    }
    
    public Optional<Producto> getById(Integer id){
        return repo.getById(id);
    }
    
    public Producto save(Producto producto){
        return repo.save(producto);
    }
    
    public void delete(Producto producto){
        repo.delete(producto);
    }
    
}
