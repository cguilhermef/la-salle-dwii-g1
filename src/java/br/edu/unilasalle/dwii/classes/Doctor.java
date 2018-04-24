/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unilasalle.dwii.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author ChristianGuilherme
 */
public class Doctor extends User {
  
  private Collection<MedicalExpertise> expertises;

  public Doctor(long id, String name, boolean active) {
    super(id, name, active);
  }

  public Collection<MedicalExpertise> getExpertises() {
    return expertises;
  }

  public void setExpertises(Collection<MedicalExpertise> expertises) {
    this.expertises = expertises;
  }
}
