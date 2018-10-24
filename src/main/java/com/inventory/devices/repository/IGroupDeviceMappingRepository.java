package com.inventory.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.devices.model.GroupDeviceMappingBean;

public interface IGroupDeviceMappingRepository extends JpaRepository<GroupDeviceMappingBean, Long>{

	
	@Query(value = "SELECT * FROM device_group_mapping u WHERE u.device_id = :deviceId and u.device_group_id = :deviceGroupId",  nativeQuery = true)
	GroupDeviceMappingBean findMappingByDeviceIdAndDeviceGroupId(@Param("deviceId") long deviceId, @Param("deviceGroupId") long deviceGroupId);
}
