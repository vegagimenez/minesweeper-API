package ar.com.jmvg.challenges.minesweeper.api.exception;

import java.util.List;

import org.apache.http.HttpStatus;

/**
 * Class to have some quick implementation to throw Exceptions in APi's process
 * */
public class MinesweeperAPIExceptionHelper {

	private static final String DEFAULT_ERR_MSG_INVALID_FIELDS = "Invalid arguments exception in fields:";
	
	public static MinesweeperAPIException forbiddenException() {
		return new MinesweeperAPIException("You are not allowed not do this operation.", HttpStatus.SC_FORBIDDEN);
	}
	public static MinesweeperAPIException notFoundException() {
		return new MinesweeperAPIException("Not found.", HttpStatus.SC_NOT_FOUND);
	}
	public static MinesweeperAPIException notFoundException(String data) {
		return new MinesweeperAPIException("Entity with Id:" + data + " not found.", HttpStatus.SC_NOT_FOUND);
	}
	public static MinesweeperAPIException alreadyExistsException() {
		return new MinesweeperAPIException("Entity already exists.", HttpStatus.SC_PRECONDITION_FAILED);
	}
	public static MinesweeperAPIException notAcceptedException() {
		return new MinesweeperAPIException("Not accepted.", HttpStatus.SC_NOT_ACCEPTABLE);
	}
	public static MinesweeperAPIException invalidArgumentsException(List<String> invalidFields) {
		return MinesweeperAPIExceptionHelper.invalidArgumentsException(invalidFields.toString(), null);
	}
	public static MinesweeperAPIException invalidArgumentsException(String invalidField, String customMsg) {
		StringBuffer sb = (null == customMsg)?new StringBuffer(DEFAULT_ERR_MSG_INVALID_FIELDS):new StringBuffer(customMsg);
		sb.append(invalidField.toString());	
		return new MinesweeperAPIException(sb.toString(), HttpStatus.SC_BAD_REQUEST);
	}
	public static MinesweeperAPIException invalidArgumentsException() {
		return new MinesweeperAPIException("Invalid arguments.", HttpStatus.SC_BAD_REQUEST);
	}
	public static MinesweeperAPIException defaultException(String message, Throwable cause) {
		return new MinesweeperAPIException(message, HttpStatus.SC_INTERNAL_SERVER_ERROR, cause);
	}
	public static MinesweeperAPIException internalServerErrorException() {
		return new MinesweeperAPIException("Unexpected exception, please contact our support administration.", HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}
}
