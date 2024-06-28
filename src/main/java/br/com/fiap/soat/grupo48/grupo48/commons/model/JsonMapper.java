package br.com.fiap.soat.grupo48.grupo48.commons.model;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonMapper {

  public String toJson() {
    try {
      return new ObjectMapper().writeValueAsString(this);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
