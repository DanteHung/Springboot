package com.vtxlab.bootcamp.bootcampsbforum.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.annotation.UserIdCheck;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.request.UserIdDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.response.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

// SOAP API -> XML (Spring)
// REST / RESTFUL -> JSON (Spring)

@Validated // 1
public interface GovOperation {

  @Operation(summary = "Get User by User id",
      description = "This endpoint is to ...",
      parameters = {
          @Parameter(name = "id", description = "User id", required = true)})
  @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(
      responseCode = "200",
      content = {@Content(schema = @Schema(implementation = ApiResponse.class),
          mediaType = "application/json")}),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404",
          content = {@Content(schema = @Schema())}),
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500",
          content = {@Content(schema = @Schema())})})
  @GetMapping(value = "/user") // request param
  @ResponseStatus(value = HttpStatus.OK) // 200
  ApiResponse<UserPostDTO> getUserPostDTO(
      @UserIdCheck @RequestParam(value = "id") UserIdDTO userIdDTO); // 2

  @GetMapping(value = "/comments") // request param
  UserPostDTO getUserCommentDTO(@RequestParam(value = "id") int userId);

  // get all users
  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.OK) // 200
  ApiResponse<List<UserPostDTO>> getUserPostDTOs();

}
