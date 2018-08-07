package com.yit.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yit.dao.RightRepository;
import com.yit.dao.RoleRepository;
import com.yit.dao.UserRepository;
import com.yit.entities.GwRight;
import com.yit.entities.GwRole;
import com.yit.entities.GwUser;
import org.springframework.data.domain.Page;

import org.springframework.data.repository.query.Param;





@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private RightRepository rightRepo;
	
	
	
	
	
	
	
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserController(UserRepository userRepo, RoleRepository roleRepo, RightRepository rightRepo) {
		super();
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.rightRepo = rightRepo;
	}
	
	
	
	@GetMapping("/allUsers")
	public List<GwUser> getAllUsers(){
		List<GwUser> users = this.userRepo.findAll();
		return users;
	}
	@GetMapping("/allRoles")
	public List<GwRole> getAllRoles(){
		List<GwRole> roles = this.roleRepo.findAll();
		return roles;
	}
	
	
	
	@RequestMapping("/allRights")
	public List<GwRight> getAllRihts(){
		List<GwRight> rights = this.rightRepo.findAll();
		return rights;
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public Page<GwUser> chercher(@RequestParam(name="mc", defaultValue="") String mc, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="2") int size){
		return userRepo.chercher("%"+mc+"%",PageRequest.of(page, size));	
	}
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public Optional<GwUser> getUser(@PathVariable Long id){
		return userRepo.findById(id);
	}
	@RequestMapping(value="/role/{id}", method=RequestMethod.GET)
	public Optional<GwRole> getRole(@PathVariable Long id){
		return roleRepo.findById(id);
	}
	@RequestMapping(value="/right/{id}", method=RequestMethod.GET)
	public Optional<GwRight> getRight(@PathVariable Long id){
		return rightRepo.findById(id);
	}
	@PostMapping(value="/addUser")
	public GwUser saveUser(@RequestBody GwUser u){
		return userRepo.save(u);
	}
	@PostMapping(value="/role")
	public GwRole saveSubject(@RequestBody GwRole r){
		return roleRepo.save(r);
	}
	@PostMapping(value="/right")
	public GwRight saveFiliere(@RequestBody GwRight right){
		return rightRepo.save(right);
	}

}
