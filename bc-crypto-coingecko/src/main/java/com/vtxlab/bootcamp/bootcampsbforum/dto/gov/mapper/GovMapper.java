package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.User;

// @Component // Bean -> Spring Context
public class GovMapper {

  // instance variable

  // @Autowired
  // private ObjectMapper objectMapper;

  public static UserEntity map(UserPostRequestDTO dto) {
    UserEntity userEntity = UserEntity.builder() //
        .name(dto.getName()) //
        .username(dto.getUsername()) //
        .email(dto.getEmail()) //
        .phone(dto.getPhone()) //
        .website(dto.getWebsite()) //
        .street(dto.getStreet()) //
        .suite(dto.getSuite()) //
        .city(dto.getCity()) //
        .zipcode(dto.getZipcode()) //
        .addrLat(dto.getAddrLat()) //
        .addrLng(dto.getAddrLong()) //
        .cName(dto.getCompanyName()) //
        .ccatchPhrase(dto.getCompanyCatchPhrase()) //
        .cBusinessService(dto.getCompanyBusService()) //
        .build();

    List<PostEntity> postEntities = dto.getPosts().stream() //
        .map(e -> {
          PostEntity postEntity = PostEntity.builder() //
              .title(e.getTitle()) //
              .body(e.getBody()) //
              .build();
          postEntity.setUser(userEntity); // ManyToOne relationship -> FK
          return postEntity;
        }).collect(Collectors.toList());

    userEntity.setPosts(postEntities);
    return userEntity;
  }

  public static UserPostDTO map(User user, List<Post> posts) {

    List<PostDTO> postDTOs = posts.stream() //
        .filter(p -> p.getUserId() == user.getId()) //
        .map(p -> {
          return PostDTO.builder() //
              .id(p.getId()) //
              .title(p.getTitle()) //
              .build(); //
        }).collect(Collectors.toList());

    return UserPostDTO.builder() //
        .id(user.getId()) //
        .username(user.getUsername()).email(user.getEmail()) //
        .phone(user.getPhone()) //
        .postDTOs(postDTOs) //
        .build();
  }

}
