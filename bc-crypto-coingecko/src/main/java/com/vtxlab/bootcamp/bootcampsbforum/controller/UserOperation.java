package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {

  @GetMapping(value = "/users")
  List<User> getUsers();


  @GetMapping(value = "/users/email/{email}/phone/{phone}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByEmailOrPhone(
      @PathVariable String email, @PathVariable String phone);

  @GetMapping(value = "/users/lat/{lat}/lng/{lng}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByLatLngGtrThan(
      @PathVariable(value = "lat") String latitude,
      @PathVariable(value = "lng") String longitude);


  @PostMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<UserEntity> saveUserAndPosts(@RequestBody UserPostRequestDTO dto);

}
