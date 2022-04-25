package com.example.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba.models.Passport;

public interface PasaporteService {
  
  public ArrayList<Passport> getIdentifications();
  public Optional<Passport> getIdentificationById(Long id);
  public Passport saveIdentification(Passport passport);

	public Passport findPassportByUserId(Long id);
}
