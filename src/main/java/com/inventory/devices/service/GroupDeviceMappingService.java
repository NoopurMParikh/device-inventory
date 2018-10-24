package com.inventory.devices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.devices.model.GroupDeviceMappingBean;
import com.inventory.devices.repository.IGroupDeviceMappingRepository;

@Service("groupDeviceMappingService")
public class GroupDeviceMappingService {

private final Logger logger = LoggerFactory.getLogger(DeviceService.class);
	
	@Autowired
	private IGroupDeviceMappingRepository GroupDeviceMappingRepository;
	
	public GroupDeviceMappingBean addDeviceToGroup(GroupDeviceMappingBean deviceGroup) {
		logger.debug("creating a GroupDeviceMapping entry");
		return this.GroupDeviceMappingRepository.save(deviceGroup);
	}
	
	public GroupDeviceMappingBean getMapping(long deviceId, long deviceGroupId) {
		logger.debug(String.format("fetch a Device-Grp entry with deviceId[%s] deviceGroupId[%s]", deviceId, deviceGroupId ));
		return this.GroupDeviceMappingRepository.findMappingByDeviceIdAndDeviceGroupId(deviceId, deviceGroupId);
	}
	
	public void deleteDeviceFromGroup(long id) {
		logger.debug(String.format("delete a Device-Grp mapping from group with id[%s]", id));
		this.GroupDeviceMappingRepository.deleteById(id);
	}
}
