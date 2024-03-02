package com.vtxlab.bootcamp.bootcampsbforum.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;

public interface RedisOperaton {

  @PostMapping(value = "/user2")
  User2 createUser2(@RequestParam String key, @RequestBody User2 user)
      throws JsonProcessingException;

}
