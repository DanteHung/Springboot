package com.vtxlab.bootcamp.bootcampsbforum.infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String toLowerCase() {
    return this.name().toLowerCase(); // https or http
  }
}
