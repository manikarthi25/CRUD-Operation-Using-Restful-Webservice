package com.manikarthi25.restfullservice.demo.exception;

import java.util.Date;

public class ErrorMessage {

	private Date timeSatmp;
	private String errorMessage;

	public ErrorMessage() {
	}

	public ErrorMessage(Date timeSatmp, String errorMessage) {
		this.timeSatmp = timeSatmp;
		this.errorMessage = errorMessage;
	}

	public Date getTimeSatmp() {
		return timeSatmp;
	}

	public void setTimeSatmp(Date timeSatmp) {
		this.timeSatmp = timeSatmp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
