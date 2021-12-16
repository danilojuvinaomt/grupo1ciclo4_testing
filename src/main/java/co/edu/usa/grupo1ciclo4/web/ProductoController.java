/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.web;

import co.edu.usa.grupo1ciclo4.modelo.Producto;
import co.edu.usa.grupo1ciclo4.servicios.ProductoService;
import java.util.List;
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
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/all")
    public List<Producto> getAll() {
        return service.getAll();
    }

    @PostMapping("/new")
    public ResponseEntity<Producto> save(@RequestBody Producto prod) {
        return new ResponseEntity(service.save(prod), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Producto> update(@RequestBody Producto prod) {
        return new ResponseEntity(service.update(prod), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
