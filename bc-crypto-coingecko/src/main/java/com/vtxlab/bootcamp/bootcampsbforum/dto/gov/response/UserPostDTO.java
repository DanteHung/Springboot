package com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserPostDTO {
  
  private int id;
  private String username;
  private String email;
  private String phone;
  @JsonProperty(value = "posts")
  private List<PostDTO> postDTOs;

}
