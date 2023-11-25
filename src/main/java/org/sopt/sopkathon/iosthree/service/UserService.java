package org.sopt.sopkathon.iosthree.service;

import java.util.Optional;

import org.sopt.sopkathon.iosthree.common.ApiResponse;
import org.sopt.sopkathon.iosthree.controller.dto.request.SignUpRequest;
import org.sopt.sopkathon.iosthree.domain.SignUpResponse;
import org.sopt.sopkathon.iosthree.domain.User;
import org.sopt.sopkathon.iosthree.exception.Success;
import org.sopt.sopkathon.iosthree.infrastructure.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	private final UserJpaRepository userJpaRepository;

	@Transactional
	public ApiResponse<SignUpResponse> signUp(SignUpRequest request){
		Optional<User> user = userJpaRepository.findByIosId(request.iosId());
		if (user.isPresent()){
			return	ApiResponse.success(Success.SIGNUP_SUCCESS, SignUpResponse.of(user.get().getId(), user.get()
				.getIsAnswered()));
		}
		if (user.isEmpty()){	//새로운 유저 생성
			User newUser = User.builder()
				.iosId(request.iosId())
				.isAnswered(false)
				.build();
			userJpaRepository.save(newUser);
			return ApiResponse.success(Success.SIGNUP_SUCCESS, SignUpResponse.of(newUser.getId(),newUser.getIsAnswered()));
		}
		System.out.println(user);
		return login(user.get());
	}

	@Transactional(readOnly = true)
	public ApiResponse<SignUpResponse> login(User user){
		return ApiResponse.success(Success.LOGIN_SUCCESS, SignUpResponse.of(
			user.getId(),
			user.getIsAnswered())
		);
	}
}
