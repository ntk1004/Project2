package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.modol.BeanAPI;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.enity.BuildingEntity;
import com.javaweb.service.BuildingService;
@Service
public class Buildingserviceimpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	@Override
	public List<BeanAPI> findALl(String name,Long districtid,List<String> typeCode) {
		List <BuildingEntity> buildingEntities =  buildingRepository.findAll(name,districtid, typeCode);
		List<BeanAPI> bean = new ArrayList<>();
		for (BuildingEntity en : buildingEntities) {
			BeanAPI a = new BeanAPI();
			a.setName(en.getName());
			a.setNumberOfBasement(en.getNumberOfBasement());
			a.setAddress(en.getStreet()+" "+en.getWard());
			bean.add(a);
		}
		return bean;
	}
}