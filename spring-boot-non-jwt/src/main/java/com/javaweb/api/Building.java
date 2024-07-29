package com.javaweb.api;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import customexception.FielRequiredException;
import com.javaweb.controlleradvice.ControllerAdvisor;
import com.javaweb.modol.BeanAPI;
import com.javaweb.modol.ErrorResonseDTO;
import com.javaweb.service.BuildingService;

@RestController
public class Building {
	@Autowired
	private BuildingService buildingservice;
@GetMapping("/api/building/")
	public List<BeanAPI> requestMethodName(@RequestParam (value="name") String name )  {
		List<BeanAPI> li = buildingservice.findALl(name);

		return li;
	}
   
    

    @DeleteMapping("/api/building/{ID}/{name}")
    public void delectparam (@PathVariable Integer ID,
    		                 @PathVariable String name,
    		                 @RequestParam (value="sweet", required = false) String weet) {
    	System.out.println(ID+" "+name+" "+weet);
    }
}
