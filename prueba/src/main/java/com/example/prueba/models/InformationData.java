package com.example.prueba.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "datos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class InformationData  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "fist_name")
  private String firstName;

  @Column(name = "second_surname")
  private String secondName;

  @Column(name = "first_surname")
  private String firstSurname;

  @Column(name = "second_name")
  private String secondSurname;

  private String city;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
  @JsonIgnore
  @JoinColumn(name = "id_passport")
  private Passport passport;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
  @JsonIgnore
  @JoinColumn(name = "id_identification")
  private IdentificationCard identificationCard;
}
