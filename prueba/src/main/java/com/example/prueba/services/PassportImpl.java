package com.example.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.prueba.models.Passport;
import com.example.prueba.repository.PassportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportImpl implements PasaporteService {
  
  @Autowired
  private PassportRepository passportRepository;

  @Override
  public ArrayList<Passport> getIdentifications() {
    return (ArrayList<Passport>) passportRepository.findAll();
  }

  @Override
  public Optional<Passport> getIdentificationById(Long id) {
    return passportRepository.findById(id);
  }

  @Override
  public Passport saveIdentification(Passport passport) {
    return passportRepository.save(passport);
  }

  @Override
  public Passport findPassportByUserId(Long id) {
    return passportRepository.findPassportByUserId(id);
  }

}
