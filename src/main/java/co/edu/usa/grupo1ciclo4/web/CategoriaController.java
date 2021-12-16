/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.web;

import co.edu.usa.grupo1ciclo4.modelo.Categoria;
import co.edu.usa.grupo1ciclo4.servicios.CategoriaService;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juvinao
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/all")
    public List<Categoria> getAll() {
        return service.getAll();
    }

    @PostMapping("/new")
    public ResponseEntity<Categoria> save(@RequestBody Categoria cat) {
        return new ResponseEntity(service.save(cat), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Categoria> update(@RequestBody Categoria cat) {
        return new ResponseEntity(service.update(cat), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") ObjectId id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
