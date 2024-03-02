package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class TestExceptionController {
  
  @GetMapping("/test/npe")
  public String testNPE() {
    String s = null;
    return s.concat("hello");
  }

}
