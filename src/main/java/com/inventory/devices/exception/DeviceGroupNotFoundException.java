package com.inventory.devices.exception;

public class DeviceGroupNotFoundException extends RuntimeException {

	static final long serialVersionUID = -7034897190745766898L;

	public DeviceGroupNotFoundException(String message) {
        super(message);
    }
	
	public DeviceGroupNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
