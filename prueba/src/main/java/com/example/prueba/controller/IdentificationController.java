package com.example.prueba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.prueba.models.IdentificationCard;
import com.example.prueba.services.IdentificacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IdentificationController {
  
  @Autowired
  private IdentificacionService methods;

  @GetMapping("/cdi")
  public ArrayList<IdentificationCard> obtenerNota(){
      return (ArrayList<IdentificationCard>) methods.getIdentifications();
  }

  @GetMapping("/cdi/{id}")
  public ResponseEntity<?> findIdentificationByUserId(@PathVariable Long id) {

    IdentificationCard identificationCard = null;
    Map<String, Object> response = new HashMap<>(); 

    try {
      identificationCard = methods.findIdentificationByUserId(id);

    } catch(DataAccessException e) {
      response.put("mensaje", "Error en base de datos!!!");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    if(identificationCard == null){
      response.put("mensaje", "No existe");

      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<IdentificationCard>(identificationCard, HttpStatus.OK);
  }

}
