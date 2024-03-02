package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

public interface UserService {

  List<User> getUsers();

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> getUsersByEmailOrPhoneOrderByEmailDesc(
      String email, String phone);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> getUsersByLatLngGtrThan(
      String latitude, String longitude);

  UserEntity save(UserPostRequestDTO dto);

}
