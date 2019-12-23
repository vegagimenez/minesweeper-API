package ar.com.jmvg.challenges.minesweeper.api.exception;

public class MinesweeperAPIException extends Exception {

	private static final long serialVersionUID = 5343185991398327154L;
	
	private String errorMessage;
	private int errorCode;
	
	public MinesweeperAPIException() {
		super();
	}

	public MinesweeperAPIException(String errorMessage, int errorCode) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public MinesweeperAPIException(String errorMessage, int errorCode, Throwable cause) {
		super(errorMessage, cause);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return this.errorCode;
	}
}