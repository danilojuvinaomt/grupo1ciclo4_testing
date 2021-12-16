/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.repositorios;

import co.edu.usa.grupo1ciclo4.crud.CrudViviendaRepository;
import co.edu.usa.grupo1ciclo4.modelo.Vivienda;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juvinao
 */
@Repository
public class ViviendaRepository {

    @Autowired
    private CrudViviendaRepository repo;

    public List<Vivienda> getAll() {
        return repo.findAll();
    }

    public Optional<Vivienda> getById(Integer id) {
        return repo.getById(id);
    }

    public List<Vivienda> getMinimoPrecioyCuartos(Double precio, Integer cuartos) {
        return repo.getMinimoPrecioyCuartos(precio, cuartos);
    }

    public Vivienda save(Vivienda vivienda) {
        return repo.save(vivienda);
    }
    
    public void delete(Vivienda vivienda){
        repo.delete(vivienda);
    }

}
