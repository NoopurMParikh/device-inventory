package com.inventory.devices.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="deviceGroupBean")
@Table(name = "device_group", uniqueConstraints={
		@UniqueConstraint(columnNames = "group_name")
})
public class DeviceGroupBean extends GenericBean {
	
	static final long serialVersionUID = 0L;
	
	public DeviceGroupBean () {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "group_name")
	private String name;
	
	@Column(name = "group_desc")
	private String description;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "deviceGroup")
	private List<GroupDeviceMappingBean> deviceList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<GroupDeviceMappingBean> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<GroupDeviceMappingBean> deviceList) {
		this.deviceList = deviceList;
	}
	
	
}
