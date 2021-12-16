/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.servicios;

import co.edu.usa.grupo1ciclo4.modelo.Vivienda;
import co.edu.usa.grupo1ciclo4.repositorios.ViviendaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author juvinao
 */
@Service
public class ViviendaService {

    @Autowired
    private ViviendaRepository repo;

    public List<Vivienda> getAll() {
        return repo.getAll();
    }

    public Vivienda save(Vivienda vivienda) {
        return repo.save(vivienda);
    }

    public void delete(Integer id) {
        Optional<Vivienda> ov = repo.getById(id);
        if (ov.isPresent()) {
            repo.delete(ov.get());
        }
    }

    public Vivienda update(Vivienda vivienda) {
        Optional<Vivienda> ov = repo.getById(vivienda.getId());
        if (ov.isPresent()) {
            Vivienda act = ov.get();
            //validacion para no actualizar datos nulos o vacios
            if (vivienda.getDescripcion() != null && vivienda.getDescripcion().length() > 0) {
                act.setDescripcion(vivienda.getDescripcion());
            }
            act.setDireccion(vivienda.getDireccion());
            act.setNumeroCuartos(vivienda.getNumeroCuartos());
            if (vivienda.getPrecio() != null && vivienda.getPrecio() > 0) {
                act.setPrecio(vivienda.getPrecio());
            }
            return repo.save(act);
        }
        return vivienda;
    }

}
