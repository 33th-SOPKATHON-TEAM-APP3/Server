package org.sopt.sopkathon.iosthree.controller;

import org.sopt.sopkathon.iosthree.common.ApiResponse;
import org.sopt.sopkathon.iosthree.controller.dto.request.SignUpRequest;
import org.sopt.sopkathon.iosthree.domain.SignUpResponse;
import org.sopt.sopkathon.iosthree.exception.Success;
import org.sopt.sopkathon.iosthree.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
	private final UserService userService;

	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<SignUpResponse> signUp(@RequestBody SignUpRequest request){
		log.info(request.iosId());
		return userService.signUp(request);
	}
}
