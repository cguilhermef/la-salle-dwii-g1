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
public class User {
  
  private long id;
  private String name;
  private boolean active;

  public User(long id, String name, boolean status) {
    this.id = id;
    this.name = name;
    this.active = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  
}
