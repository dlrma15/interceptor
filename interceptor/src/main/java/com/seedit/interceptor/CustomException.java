package com.seedit.interceptor;

/*public static class BadParameter extends BaseException
{
    private static final long serialVersionUID = 3555714415375055302L;
    public BadParameter(String msg) {
        super(msg);
    }*/

public class CustomException extends RuntimeException{
	private String message = "사용자가 만든 에러입니다";

	public CustomException(String defaultMessage) {
		this.message = defaultMessage;
	}

	public String getMessage() {
		return message;
	}
}
