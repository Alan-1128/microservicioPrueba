package com.example.prueba.repository;

import com.example.prueba.models.Passport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Long>{
  
  @Query("select c from Passport c join fetch c.infData a where a.id=?1")
	public Passport findPassportByUserId(Long id);
  
}
