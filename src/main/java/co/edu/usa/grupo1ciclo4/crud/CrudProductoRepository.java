/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.crud;

import co.edu.usa.grupo1ciclo4.modelo.Producto;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author juvinao
 */
public interface CrudProductoRepository extends MongoRepository<Producto, Integer> {

    @Query("{id: ?0}")
    public Optional<Producto> getById(Integer id);

}
