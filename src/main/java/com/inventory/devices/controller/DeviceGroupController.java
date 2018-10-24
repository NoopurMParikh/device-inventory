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

import com.inventory.devices.model.DeviceGroupBean;
import com.inventory.devices.service.DeviceGroupService;

@RestController
@RequestMapping("/inventory/group")
@CrossOrigin
public class DeviceGroupController {
	
	@Autowired
	private DeviceGroupService deviceServiceGroup;
	
	@ApiOperation(value="Create new deviceGroup Entry")
	@RequestMapping(value="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeviceGroupBean createGroup(@RequestBody DeviceGroupBean blog) {
		return this.deviceServiceGroup.createGroupEntry(blog);
	}
	
	@ApiOperation(value="View all existing deviceGroup entries")
	@RequestMapping(value="/viewall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeviceGroupBean> retrieveAllGroups() {
		return this.deviceServiceGroup.retrieveAllGroupEntry();
	}
	
	@ApiOperation(value="View specific deviceGroup entry")
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeviceGroupBean retrieveGroup(@PathVariable long id) {
		return this.deviceServiceGroup.getGroupEntryById(id);
	}
	
	@ApiOperation(value="Update deviceGroup Entry")
	@RequestMapping(value="/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public DeviceGroupBean updateGroup(@RequestBody DeviceGroupBean blog) {
		return this.deviceServiceGroup.updateGroupEntry(blog);
	}
	
	@ApiOperation(value="Delete deviceGroup Entry")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteGroup(@PathVariable long id) {
		this.deviceServiceGroup.deleteGroupEntry(id);
		return ResponseEntity.ok().build();
	}
}
