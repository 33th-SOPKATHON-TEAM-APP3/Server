package org.sopt.sopkathon.iosthree.exception.model;

import org.sopt.sopkathon.iosthree.exception.Error;

public class NotFoundException extends CustomException {
	public NotFoundException(Error error, String message) {
		super(error, message);
	}
}