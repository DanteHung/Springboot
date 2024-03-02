package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbforum.controller.RedisOperaton;
import com.vtxlab.bootcamp.bootcampsbforum.model.User2;
import com.vtxlab.bootcamp.bootcampsbforum.service.RedisService;

@RestController
@RequestMapping(value = "/redis/api/v1")
public class RedisController implements RedisOperaton {

  @Autowired
  private RedisService redisService;

  @Override
  public User2 createUser2(String key, User2 user)
      throws JsonProcessingException {
    return redisService.createUser2(key, user);
  }

}
