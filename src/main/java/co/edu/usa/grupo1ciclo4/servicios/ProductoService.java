/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.servicios;

import co.edu.usa.grupo1ciclo4.modelo.Producto;
import co.edu.usa.grupo1ciclo4.repositorios.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juvinao
 */
@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repo;

    public List<Producto> getAll(){
        return repo.getAll();
    }
    
    public Producto save(Producto prod){
        return repo.save(prod);
    }
    
    public void delete(Integer id){
        Optional<Producto> op = repo.getById(id);
        if (op.isPresent()){
            repo.delete(op.get());
        }
    }
    
    public Producto update(Producto prod){
        Optional<Producto> op = repo.getById(prod.getId());
        if (op.isPresent()){
            Producto pc = op.get();
            pc.setCantidad(prod.getCantidad());
            pc.setDescripcion(prod.getDescripcion());
            pc.setNombre(prod.getNombre());
            pc.setPrecio(prod.getPrecio());
            pc.setUrl(prod.getUrl());
            return repo.save(pc);
        }
        return prod;
    }
    
}
