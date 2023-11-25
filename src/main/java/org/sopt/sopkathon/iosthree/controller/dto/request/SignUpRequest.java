package org.sopt.sopkathon.iosthree.controller.dto.request;

public record SignUpRequest(String iosId){
	public static SignUpRequest of (String iosId){
		return new SignUpRequest(iosId);
	}
}
