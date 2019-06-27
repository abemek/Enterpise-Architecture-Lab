package edu.mum.main;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "context/applicationContext.xml");

        UserService userService = (UserService) ctx.getBean("userServiceImpl");

      User user = new User();
      user.setFirstName("Abenezer");
      user.setLastName("Mekonnen");
      user.setRating(5);
      user.isAdmin();
      user.setVersion(11);
      user.setEmail("abenmum@gmail.com");

      userService.save(user);

      User usr = userService.findByEmail("abenmum@gmail.com");

      System.out.println("************** USER **************");
      System.out.println("User Name: " + usr.getFirstName() + " " + user.getLastName());

      usr.setLastName("Dame");
      User newUser = userService.update(usr);

        System.out.println("************** USER **************");
        System.out.println("User Name: " + newUser.getFirstName() + " " + newUser.getLastName());

        userService.clear();

//        usr.setLastName("Mekonnen...");
//        User newUser2 = userService.update(usr);


  }  
  
 }