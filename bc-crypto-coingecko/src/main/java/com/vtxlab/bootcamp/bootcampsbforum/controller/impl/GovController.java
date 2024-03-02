package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserIdDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import com.vtxlab.bootcamp.bootcampsbforum.service.impl.ForumDatabaseHolder;

@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private ForumDatabaseService forumDatabaseService;

  @Override
  public ApiResponse<List<UserPostDTO>> getUserPostDTOs() {

    List<User> users = userService.getUsers(); // call JPH -> DTO user list

    // clear DB
    // forumDatabaseService.deleteAllUsers();

    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> userEntities =
        users.stream() //
            .map(e -> com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity.builder() //
                // .jphId(e.getId())
                .name(e.getName()) //
                .username(e.getUsername()) //
                .website(e.getWebsite()) //
                .addrLat(e.getAddress().getGeo().getLat()) //
                .addrLng(e.getAddress().getGeo().getLng()) //
                .email(e.getEmail()) //
                .phone(e.getPhone()) //
                .street(e.getAddress().getStreet()) //
                .city(e.getAddress().getCity()) //
                .suite(e.getAddress().getSuite()) //
                .zipcode(e.getAddress().getZipcode()) //
                .cName(e.getCompany().getName()) //
                .ccatchPhrase(e.getCompany().getCatchPhrase()) //
                .cBusinessService(e.getCompany().getBs()) //
                .build())
            .collect(Collectors.toList());

    System.out.println("userEntities=" + userEntities);

    // Save to DB
    forumDatabaseService.saveAllUsers(userEntities);

    // Convert User DTO ->
    List<UserPostDTO> userPostDTOs = users.stream() //
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e, posts);
        }).collect(Collectors.toList());

    return ApiResponse.<List<UserPostDTO>>builder() //
        .status(Syscode.OK) //
        .data(userPostDTOs) //
        .build();
  }

  @Override
  public ApiResponse<UserPostDTO> getUserPostDTO(UserIdDTO userIdDTO) {

    UserPostDTO userPostDTO = userService.getUsers().stream() //
        .filter(e -> e.getId() == Integer.valueOf(userIdDTO.getUserId())) //
        .map(e -> {
          List<Post> posts = postService.getPosts();
          return GovMapper.map(e, posts);
        }).findFirst() //
        .orElseThrow(() -> new RuntimeException());

    return ApiResponse.<UserPostDTO>builder() //
        .status(Syscode.OK).data(userPostDTO) //
        .build();
    // return ResponseEntity.noContent().build(); // http status 204
  }

  @Override
  public UserPostDTO getUserCommentDTO(int userId) {
    return null;
  }


}
