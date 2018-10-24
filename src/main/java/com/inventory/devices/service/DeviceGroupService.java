package com.inventory.devices.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.devices.exception.DeviceGroupNotFoundException;
import com.inventory.devices.model.DeviceGroupBean;
import com.inventory.devices.repository.IDeviceGroupRepository;

@Service("deviceGroupService")
public class DeviceGroupService {

	private final Logger logger = LoggerFactory.getLogger(DeviceService.class);
	
	@Autowired
	private IDeviceGroupRepository deviceGroupRepository;
	
	public DeviceGroupBean createGroupEntry(DeviceGroupBean deviceGroup) {
		logger.debug("creating a DeviceGroup entry");
		return this.deviceGroupRepository.save(deviceGroup);
	}
	
	public List<DeviceGroupBean> retrieveAllGroupEntry() {
		logger.debug("retrieve all DeviceGroup entry");
		return this.deviceGroupRepository.findAll();
	}
	
	public DeviceGroupBean getGroupEntryById(long id) {
		logger.debug(String.format("retrieve a DeviceGroup entry with id[%s]", id));
		return deviceGroupRepository.findById(id).get();
//				 .orElseThrow(() -> new DeviceGroupNotFoundException("Blog Entry not found with Id:" + id));
	}
	
	public DeviceGroupBean updateGroupEntry(DeviceGroupBean deviceGroup){
		logger.debug(String.format("update a DeviceGroup entry with id[%s]", deviceGroup.getId()));
		
		DeviceGroupBean deviceGroupDB = getGroupEntryById(deviceGroup.getId());
		deviceGroupDB.setDescription(deviceGroup.getDescription());
		deviceGroupDB.setName(deviceGroup.getName());
		
		return this.deviceGroupRepository.save(deviceGroupDB);
	}

	public void deleteGroupEntry(long id) {
		logger.debug(String.format("delete a DeviceGroup entry with id[%s]", id));
		this.deviceGroupRepository.deleteById(id);
	}
}
