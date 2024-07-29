package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.modol.BeanAPI;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.enity.BuildingEntity;
@Repository
public class BuildingEntityimpl implements BuildingRepository{
	static final String  DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "30102004";
	public List<BuildingEntity> findAll (String name){
		List <BuildingEntity> list = new ArrayList<>();
		String sql = "select * from building where numberOfbasement >=2";
		try ( Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); 
			Statement sttm = conn.createStatement();
			ResultSet rs = sttm.executeQuery(sql);){
			while (rs.next()) {
			BuildingEntity a = new BuildingEntity();
				a.setName(rs.getString("name"));
				a.setStreet(rs.getString("street"));
				a.setWard(rs.getString("ward"));
				a.setNumberOfBasement(rs.getInt("numberOfbasement"));
				list.add(a);
		} 
		}catch (Exception e) {
		
		}
	return list;
		} 
}