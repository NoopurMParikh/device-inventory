package com.inventory.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.devices.model.DeviceGroupBean;

public interface IDeviceGroupRepository extends JpaRepository<DeviceGroupBean, Long> {

}
