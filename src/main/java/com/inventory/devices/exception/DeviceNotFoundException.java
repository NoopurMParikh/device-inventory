package com.inventory.devices.exception;

public class DeviceNotFoundException extends RuntimeException {

	static final long serialVersionUID = -7034897190745766878L;

	public DeviceNotFoundException(String message) {
        super(message);
    }
	
	public DeviceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
