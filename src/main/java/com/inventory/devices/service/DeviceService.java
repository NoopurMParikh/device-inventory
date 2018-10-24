package com.inventory.devices.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.devices.exception.DeviceNotFoundException;
import com.inventory.devices.model.DeviceBean;
import com.inventory.devices.repository.IDeviceRepository;

@Service("deviceService")
public class DeviceService {

	private final Logger logger = LoggerFactory.getLogger(DeviceService.class);
	
	@Autowired
	private IDeviceRepository deviceRepository;
	
	public DeviceBean createDeviceEntry(DeviceBean device) {
		logger.debug("creating a device entry");
		return this.deviceRepository.save(device);
	}
	
	public List<DeviceBean> retrieveAllDeviceEntry() {
		logger.debug("retrieve all Device entry");
		return this.deviceRepository.findAll();
	}
	
	public DeviceBean getDeviceEntryById(long id) {
		logger.debug(String.format("retrieve a Device entry with id[%s]", id));
		return deviceRepository.findById(id).get();
//				 .orElseThrow(() -> new DeviceNotFoundException("Blog Entry not found with Id:" + id));
	}
	
	public DeviceBean updateDeviceEntry(DeviceBean device){
		logger.debug(String.format("update a Device entry with id[%s]", device.getId()));
		
		DeviceBean deviceDB = getDeviceEntryById(device.getId());
		deviceDB.setHostname(device.getHostname());
		deviceDB.setIpAddress(device.getIpAddress());
		
		return this.deviceRepository.save(deviceDB);
	}

	public void deleteDeviceEntry(long id) {
		logger.debug(String.format("delete a Device entry with id[%s]", id));
		this.deviceRepository.deleteById(id);
	}
}
