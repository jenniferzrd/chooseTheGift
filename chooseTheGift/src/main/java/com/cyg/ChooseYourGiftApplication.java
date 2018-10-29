package com.cyg;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cyg.dao.ProjectRepo;
import com.cyg.dao.UserRepo;
import com.cyg.models.Project;
import com.cyg.models.User;

@SpringBootApplication
//public class ChooseYourGiftApplication {
public class ChooseYourGiftApplication implements CommandLineRunner {

	@Autowired
	UserRepo userRepository;
	
	@Autowired
	ProjectRepo projectRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ChooseYourGiftApplication.class, args);
	}
	
	@Override
    public void run(String... arg0) throws Exception {
    	showData();
    }

    @Transactional
    private void showData(){
    	
    	List<User> user = userRepository.findAll();
        List<Project> project = projectRepository.findAll();
         
        System.out.println("===================User:==================");
        user.forEach(System.out::println);
        
        System.out.println("===================Project:==================");
        project.forEach(System.out::println);
}
}
