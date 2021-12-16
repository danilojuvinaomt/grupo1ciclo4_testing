/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.grupo1ciclo4.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author juvinao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "viviendas")
public class Vivienda {
    @Id
    private Integer id;
    private String descripcion;
    private String direccion;
    private Integer numeroCuartos;
    private Double precio;
    
}
