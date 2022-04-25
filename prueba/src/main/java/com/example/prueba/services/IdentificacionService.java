package com.example.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba.models.IdentificationCard;

public interface IdentificacionService {
  
  public ArrayList<IdentificationCard> getIdentifications();
  public Optional<IdentificationCard> getIdentificationById(Long id);
  public IdentificationCard saveIdentification(IdentificationCard identificationCard);

  public IdentificationCard findIdentificationByUserId(Long id);
}
