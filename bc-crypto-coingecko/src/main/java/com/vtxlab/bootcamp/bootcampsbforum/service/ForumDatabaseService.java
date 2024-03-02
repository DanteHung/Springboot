package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;

public interface ForumDatabaseService {

  List<UserEntity> saveAllUsers(List<UserEntity> users);

  void deleteAllUsers();

}
