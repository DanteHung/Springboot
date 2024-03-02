package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.BcUtil;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.model.dto.jph.Post;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostService;

@Service
public class PostJPHServiceHolder implements PostService {

  @Value("${api.jsonplaceholder.domain}")
  private String domain;

  @Value("${api.jsonplaceholder.endpoints.posts}")
  private String postsUri;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Post> getPosts() {  // local method
    // RestTemplate restTemplate = new RestTemplate();
    String url = BcUtil.getUrl(Scheme.HTTPS, domain, postsUri);
    Post[] posts = restTemplate.getForObject(url, Post[].class); // 0.5s
    return Arrays.stream(posts) //
        .collect(Collectors.toList());
  }

}
