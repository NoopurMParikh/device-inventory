package com.inventory.devices.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.devices.model.GroupDeviceMappingBean;
import com.inventory.devices.service.GroupDeviceMappingService;

@RestController
@RequestMapping("/inventory/mapping")
@CrossOrigin
public class GroupDeviceMappingController {
	
	@Autowired
	private GroupDeviceMappingService groupDeviceMappingService;
	
	@ApiOperation(value="Add a device to a group")
	@RequestMapping(value="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public GroupDeviceMappingBean createMapping(@RequestBody GroupDeviceMappingBean blog) {
		return this.groupDeviceMappingService.addDeviceToGroup(blog);
	}
	
	@ApiOperation(value="View specific deviceGroup entry")
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GroupDeviceMappingBean retrieveDeviceGroupMapping(@PathVariable long deviceId, @PathVariable long deviceGroupId) {
		return this.groupDeviceMappingService.getMapping(deviceId, deviceGroupId);
	}
	
	@ApiOperation(value="Delete a device from group")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteDevice(@PathVariable long id) {
		this.groupDeviceMappingService.deleteDeviceFromGroup(id);
		return ResponseEntity.ok().build();
	}
}
