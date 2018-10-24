# device-inventory
Java Spring Boot 2 Test Project


Instructions to run the test
1. Open mysql client.
2. create a database "deviceinventory";
3. Change username & password in application.properties.
4. Run the Java application from eclipse as(Import project in eclipse) :
	a. Open 'LaunchApplication.java'.
	b. Run as 'Java Application'.
	c. Project starts.
5. Run the Angular application from VS Code:
	a. ng serve -o	

#sample for device create and update
{
  "hostname": "",
  "id": 0,
  "ipAddress": ""
}

#update
{
  "hostname": "facebook dev",
  "id": 1,
  "ipAddress": "11.22.333.44"
}


#sample input for group creation: inventory/group/create
{
  "description": "chomu GRP desc",
  "deviceList": [{}],
  "id": 0,
  "name": "chomu grp"
}

#sample input for group update: inventory/group/update
{
  "description": "chomu2 GRP desc",
  "deviceList": [{}],
  "id": 0,
  "name": "chomu2 grp"
}

#sample request to create group-device mapping:
{
  "deprecated": "",
  "device": {
		"hostname": "",
		"id": 6,
		"ipAddress": ""
  },
  "deviceGroup": {
		"description": "",
		"deviceList": [{}],
		"id": 15,
		"name": ""
  },
  "id": 0
}

select (select group_name from device_group where id = map.device_group_id) grp_name,
  (select hostname from device where id = map.device_id)
   from device_group_mapping map;
   
   SELECT * FROM device_group_mapping u WHERE u.device_id = 6 and u.device_group_id = 15
