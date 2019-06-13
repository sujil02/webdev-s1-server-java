package com.example.webdevs1serverjava.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Module;
import com.example.webdevs1serverjava.models.Widget;
import com.example.webdevs1serverjava.repositories.CourseRepository;
import com.example.webdevs1serverjava.repositories.ModuleRepository;
import com.example.webdevs1serverjava.services.CourseService;
import com.example.webdevs1serverjava.services.ModuleService;


@RestController
@CrossOrigin("*")
public class ModuleController {
    @Autowired
    ModuleRepository repository;
    @Autowired
	private ModuleService moduleService;

    @GetMapping("/api/courses/{courseId}/modules")
    public Iterable<Module> findAllModules(@PathVariable("courseId") Integer cid) {
    	return moduleService.findAllModules(cid);
        
    }
    @GetMapping("/api/courses/{courseId}/modules/{moduleId}")
	public Module findModuleById(@PathVariable("courseId") Integer cid,@PathVariable("moduleId") Integer mid) {
    	return moduleService.findByModuleId(cid,mid);
		
	}
    
	@PostMapping("/api/courses/{courseId}/modules")
	public Iterable<Module> createModule(@PathVariable("courseId") Integer cid,@RequestBody Module module) {
		return moduleService.createModule(cid,module);
	}
	@PutMapping("/api/courses/{courseId}/modules")
	public Iterable<Module> updateModule(@PathVariable("courseId") Integer cid,@RequestBody Module module) {
		return moduleService.updateModule(cid,module);
	}
	
	@DeleteMapping("/api/courses/{courseId}/modules/{moduleId}")
	public Iterable<Module> deleteModule(@PathVariable("courseId") Integer cid,@PathVariable("moduleId") Integer mid) {
		return moduleService.deleteModule(cid,mid);
	}
}