/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.servicios;

import co.edu.usa.grupo1ciclo4.modelo.Categoria;
import co.edu.usa.grupo1ciclo4.repositorios.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juvinao
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public List<Categoria> getAll() {
        return repo.getAll();
    }

    public Categoria save(Categoria cat) {
        return repo.save(cat);
    }

    public void delete(ObjectId id) {
        Optional<Categoria> oc = repo.getById(id);
        if (oc.isPresent()) {
            repo.delete(oc.get());
        }
    }

    public Categoria update(Categoria cat) {
        Optional<Categoria> oc = repo.getById(cat.getId());
        if (oc.isPresent()) {
            if (cat.getNombre() != null && cat.getNombre().length() > 0) {
                oc.get().setNombre(cat.getNombre());
            }
            return repo.save(oc.get());
        }
        return cat;
    }

}
