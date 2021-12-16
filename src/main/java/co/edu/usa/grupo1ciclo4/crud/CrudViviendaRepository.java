/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.crud;

import co.edu.usa.grupo1ciclo4.modelo.Vivienda;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author juvinao
 */
public interface CrudViviendaRepository extends MongoRepository<Vivienda, Integer> {
    
    @Query("{id: ?0}")
    public Optional<Vivienda> getById(Integer id);
    
    @Query("{numeroCuartos: {$gte: ?0}}")
    public List<Vivienda> getMinimoCuartos(Integer cantidadCuartos);
    
    @Query("{$and : [{precio: {$lte: ?0}},{numeroCuartos: {$lte: ?1}}] }")
    public List<Vivienda> getMinimoPrecioyCuartos(Double precio, Integer cantidadCuartos);
    
}
