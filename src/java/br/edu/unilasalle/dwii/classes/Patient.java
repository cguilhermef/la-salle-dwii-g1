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
public class Patient extends User {
  
  private String address;
  private Date birthday;

  public Patient(String address, Date birthday, long id, String name, boolean active) {
    super(id, name, active);
    this.address = address;
    this.birthday = birthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  
  
}
