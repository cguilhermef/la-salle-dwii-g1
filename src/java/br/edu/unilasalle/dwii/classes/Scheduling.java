/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unilasalle.dwii.classes;

import java.util.Date;

/**
 *
 * @author ChristianGuilherme
 */
public class Scheduling {
  
  private long id;
  private Doctor doctor;
  private Patient patient;
  private Date date;
  private boolean active;

  public Scheduling(long id, Doctor doctor, Patient patient, Date date, boolean active) {
    this.id = id;
    this.doctor = doctor;
    this.patient = patient;
    this.date = date;
    this.active = active;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
  
  
  
}
