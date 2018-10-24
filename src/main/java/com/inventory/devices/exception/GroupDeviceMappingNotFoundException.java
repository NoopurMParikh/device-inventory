package com.inventory.devices.exception;

public class GroupDeviceMappingNotFoundException extends RuntimeException{

	static final long serialVersionUID = -7034895490745766898L;

	public GroupDeviceMappingNotFoundException(String message) {
        super(message);
    }
	
	public GroupDeviceMappingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
