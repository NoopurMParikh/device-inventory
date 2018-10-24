package com.inventory.devices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="deviceGroupBean")
@Table(name = "device_group_mapping")
public class GroupDeviceMappingBean extends GenericBean{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "device_id", nullable = false)
	private DeviceBean device;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "device_group_id", nullable = false)
	private DeviceGroupBean deviceGroup;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DeviceBean getDevice() {
		return device;
	}

	public void setDevice(DeviceBean device) {
		this.device = device;
	}

	public DeviceGroupBean getDeviceGroup() {
		return deviceGroup;
	}

	public void setDeviceGroup(DeviceGroupBean deviceGroup) {
		this.deviceGroup = deviceGroup;
	}
}
