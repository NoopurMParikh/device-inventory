package com.inventory.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.devices.model.DeviceBean;

public interface IDeviceRepository extends JpaRepository<DeviceBean, Long>{

}
