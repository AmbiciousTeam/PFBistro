package br.com.ambiciousteam.pfbistro.exceptions;

@SuppressWarnings("serial")
public class MsgErrorException extends Exception {

	private String msgUser;

	public MsgErrorException(String msgReturnUser) {
		super(msgReturnUser);
		this.msgUser = msgReturnUser;
	}

	public String getMessage() {
		return msgUser;
	}
}
