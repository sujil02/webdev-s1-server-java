package com.example.webdevs1serverjava.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevs1serverjava.models.Course;
import com.example.webdevs1serverjava.models.Module;
import com.example.webdevs1serverjava.repositories.ModuleRepository;


@RestController
@CrossOrigin("*")
public class ModuleService {


	@Autowired
	ModuleRepository moduleRepository;


	@Autowired
	CourseService courseService;

	public Iterable<Module> findAllModules(Integer cid) {
		Iterable<Module> m =  courseService.findCourseById(cid).getModules();
		return m;
	}




	public Module findByModuleId(Integer cid, Integer mid) {
		return moduleRepository.findById(mid).get();
		
	}




	public Iterable<Module> createModule(Integer cid, Module module) {
		if(module.getTitle().equals("")) {
			module.setTitle("New Module");
		}
		Course course = courseService.findCourseById(cid);
		if(course!=null) {
			module.setParentCourse(course);
			moduleRepository.save(module);
			return findAllModules(cid);
		}
		return null;
	}




	public Iterable<Module> deleteModule(Integer cid, Integer mid) {
		Module module = this.findByModuleId(cid,mid);
		if(module!=null) {
			moduleRepository.delete(module);
		}
		return findAllModules(cid);
	}




	public Iterable<Module> updateModule(Integer cid, Module newModule) {
		Module module = this.findByModuleId(cid,newModule.getId());
		if(module!=null) {
			module.setTitle(newModule.getTitle());
			moduleRepository.save(module);
		}
		return findAllModules(cid);
	}


}