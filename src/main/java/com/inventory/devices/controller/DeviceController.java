package com.inventory.devices.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.devices.model.DeviceBean;
import com.inventory.devices.service.DeviceService;

@RestController
@RequestMapping("/inventory/device")
@CrossOrigin
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	
	@ApiOperation(value="Create new device Entry")
	@RequestMapping(value="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeviceBean createDevice(@RequestBody DeviceBean blog) {
		return this.deviceService.createDeviceEntry(blog);
	}
	
	@ApiOperation(value="View all existing device entries")
	@RequestMapping(value="/viewall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeviceBean> retrieveAllDevices() {
		return this.deviceService.retrieveAllDeviceEntry();
	}
	
	@ApiOperation(value="View specific device entry")
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeviceBean retrieveDevice(@PathVariable long id) {
		return this.deviceService.getDeviceEntryById(id);
	}
	
	@ApiOperation(value="Update device Entry")
	@RequestMapping(value="/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeviceBean updateDevice(@RequestBody DeviceBean blog) {
		return this.deviceService.updateDeviceEntry(blog);
	}
	
	@ApiOperation(value="Delete device Entry")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteDevice(@PathVariable long id) {
		this.deviceService.deleteDeviceEntry(id);
		return ResponseEntity.ok().build();
	}
	
}
