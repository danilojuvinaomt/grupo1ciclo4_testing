/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.repositorios;

import co.edu.usa.grupo1ciclo4.crud.CrudCategoriaRepository;
import co.edu.usa.grupo1ciclo4.modelo.Categoria;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juvinao
 */
@Repository
public class CategoriaRepository {

    @Autowired
    private CrudCategoriaRepository repo;

    public List<Categoria> getAll() {
        return repo.findAll();
    }

    public Optional<Categoria> getById(ObjectId id) {
        return repo.getById(id);
    }

    public Categoria save(Categoria cat) {
        return repo.save(cat);
    }

    public void delete(Categoria cat) {
        repo.delete(cat);
    }

}
