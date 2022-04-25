package com.example.prueba.repository;

import com.example.prueba.models.IdentificationCard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationRepository extends CrudRepository<IdentificationCard, Long> {
  
  @Query("select c from IdentificationCard c join fetch c.infDataDos a where a.id=?1")
	public IdentificationCard findIdentificationByUserId(Long id);


}
