package com.yit;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yit.dao.RightRepository;
import com.yit.dao.RoleRepository;
import com.yit.dao.UserRepository;
import com.yit.entities.GwRight;
import com.yit.entities.GwRole;
import com.yit.entities.GwUser;

@SpringBootApplication
public class GatewayApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private RightRepository rightRepo;
	
	@Override
	public void run(String... args) throws Exception {
			
		userRepo.deleteAll();
		roleRepo.deleteAll();
		rightRepo.deleteAll();
		GwRole role1 = new GwRole("Adminstrator", "principal Adminstrator of data");
		GwRole role2 = new GwRole("Master Data", "Verify ant commit Requests");
		GwRole role3 = new GwRole("CRM", "Viewer of data");
		
		
		Set<GwRole> listRoles = new HashSet<>();
		
		listRoles.add(role1);listRoles.add(role2);listRoles.add(role3);
		
		roleRepo.saveAll(listRoles);
		
		GwRight right1 = new GwRight("R1", "Right 1", "viewer update delete", role3);
		GwRight right2 = new GwRight("R2", "Right 1", "viewer update", role2);
		GwRight right3 = new GwRight("R4", "Right 1", "viewer", role1);
		
		
	
		
		
	
		Set<GwRight> listRihts = new HashSet<>();
		
		listRihts.add(right1);listRihts.add(right2);listRihts.add(right3);
		rightRepo.saveAll(listRihts);
//		for(GwRight r : listRihts) {
//			rightRepo.save(r);
//		}
		
		
		rightRepo.saveAll(listRihts);
		
		
		GwUser user1= new GwUser("Hiyane", "Youssef", "yhiyane", "youssef.hiyane@gmail.com", new Date(), true);
		GwUser user2= new GwUser("Uzumaki", "Naruto", "uzunaruto", "naruto@gmail.com", new Date(), true);
		GwUser user3= new GwUser("Uchiha", "Sasuki", "uchisasuki", "sasuki@gmail.com", new Date(), true);
		GwUser user4= new GwUser("zaraki", "Kenpatchi", "zakenpatchi", "zakari@gmail.com", new Date(), true);
		GwUser user5= new GwUser("Nakawaza", "Asta", "nakasta", "asta@gmail.com", new Date(), true);
		
		Set<GwUser> listUsers = new HashSet<>();
		listUsers.add(user1);listUsers.add(user2);listUsers.add(user3);listUsers.add(user4);listUsers.add(user5);
		
		userRepo.saveAll(listUsers);
		
		
		//Set<GwRole> listRoleshollow = new HashSet<>();
		user1.setRoles(listRoles);
		user2.setRoles(listRoles);
		user3.setRoles(listRoles);
		user4.setRoles(listRoles);
		user5.setRoles(listRoles);
		
		role1.setRights(listRihts);
		role2.setRights(listRihts);
		role3.setRights(listRihts);
		
		rightRepo.saveAll(listRihts);
		roleRepo.saveAll(listRoles);
		userRepo.saveAll(listUsers);
	}
}
