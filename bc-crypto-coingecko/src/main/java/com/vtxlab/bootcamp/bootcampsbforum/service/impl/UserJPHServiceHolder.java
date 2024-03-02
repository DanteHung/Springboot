package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class UserJPHServiceHolder implements UserService {

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.users}")
  private String usersUri;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getUsers() throws RestClientException {
    // RestTemplate restTemplate = new RestTemplate();
    // call API
    // 1. invoke jsonplaceholder.typicode.com/users
    // 2. deserialization (From JSON String to Java Object)
    String url = BcUtil.getUrl(Scheme.HTTPS, domain, usersUri);

    User[] users = restTemplate.getForObject(url, User[].class);

    // array -> list
    return Arrays.stream(users) //
        .collect(Collectors.toList());
  }

  @Override
  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> getUsersByEmailOrPhoneOrderByEmailDesc(
      String email, String phone) {
    return userRepository.findByEmailOrPhoneOrderByEmailDesc(email, phone);
  }

  @Override
  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> getUsersByLatLngGtrThan(
      String latitude, String longitude) {
    return userRepository.findUsersByLatitudeLongitudeGtrThan(latitude,
        longitude);
  }

  @Override
  public UserEntity save(UserPostRequestDTO dto) {
    // dto -> entity
    UserEntity userEntity = GovMapper.map(dto);
    return userRepository.save(userEntity);
  }



}
