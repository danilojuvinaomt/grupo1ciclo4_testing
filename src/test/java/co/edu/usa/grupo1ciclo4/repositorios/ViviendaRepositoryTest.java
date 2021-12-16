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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author juvinao
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ViviendaRepositoryTest {
    
    @Autowired
    private ViviendaRepository repo;
    
    @Autowired
    private CrudViviendaRepository crudrepo;
    
    @Test
    @Order(1)
    public void testQueryInicial(){
        System.out.println("testQueryInicial");
        crudrepo.deleteAll();
        
        List<Vivienda> vs = repo.getAll();
        Assertions.assertEquals(0, vs.size());
    }
    
    @Test
    @Order(2)
    public void testSave(){
        System.out.println("Testing testSave method");
        Vivienda v1 = new Vivienda(1, "Casa hermosa", "Calle x Carrera y", 3, 1250000d);
        repo.save(v1);
        Vivienda v2 = new Vivienda(2, "Casa en la colina", "Ruta X", 2, 1800000d);
        repo.save(v2);
        Vivienda v3 = new Vivienda(3, "Casa campestre", "Sector X, via a z ciudad", 5, 3850000d);
        repo.save(v3);
        Vivienda v4 = new Vivienda(4, "Casa Z", "Av 123", 2, 850000d);
        repo.save(v4);
        Vivienda v5 = new Vivienda(5, "Casa ABC", "Diagonal 100 Av Z", 1, 730000d);
        repo.save(v5);
        
        List<Vivienda> vs = repo.getAll();
        Assertions.assertEquals(5, vs.size());
    }
    
    @Test
    @Order(3)
    public void testGetById(){
        Optional<Vivienda> v1 = repo.getById(1);
        //las siguientes dos lineas hacen lo mismo
        Assertions.assertTrue(v1.isPresent());
        Assertions.assertEquals(true, v1.isPresent());
        
    }
    
    @Test
    @Order(4)
    public void testDosParametros(){
        List<Vivienda> vs = repo.getMinimoPrecioyCuartos(1000000d, 2);
        Assertions.assertEquals(2, vs.size());
        if (vs.size()!=2){
            Assertions.fail("La consulta debio retornar 2 documentos. pero llegaron "+vs.size());
        }
    }
    
}
