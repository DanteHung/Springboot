package com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Post {

  private int userId;
  private int id;
  private String title;
  private String body;

}
