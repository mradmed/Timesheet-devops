package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;


	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
		
			L.info("In Method retrieveAllUsers: ");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				L.debug("Users in database :"+user.toString());
			} 
			L.info("Out of  Method retrieveAllUsers with success: ");
		}catch (Exception e) {
			L.error("Error in retrieveAllUsers:"+e.getMessage());
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		User u_saved =null;
		try{
		L.info("In Method addUser: ");
		u_saved= userRepository.save(u); 
		L.info("Out of Method addUser: ");
		 }
		catch(Exception e) {
			L.error("Error in AddUser:"+e.getMessage());
		}
		return u_saved;
	}

	@Override 
	public User updateUser(User u) { 
		User u_saved =null;
		try{
			L.info("In Method updateUser: ");
			u_saved= userRepository.save(u); 
		L.info("Out of Method updateUser: ");
		}
		catch(Exception e){
			L.error("Error in updateUser:"+e.getMessage());
		}
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		try{
			L.info("In Method deleteUser: ");

		userRepository.deleteById(Long.parseLong(id)); 
		L.info("Out of Method deleteUser: ");

		}
		catch(Exception e){
			L.error("Error in deleteUser :"+e.getMessage());
		}
	}
	

	@Override
	public User retrieveUser(String id) {
		User u=null;
		Optional<User> user;
		try{

			L.info("In Method retrieveUser: ");
			user =  userRepository.findById(Long.parseLong(id)); 
			if(user.isPresent()){
				u = user.get();
			}
		L.info("Out of Method retrieveUser: ");

		}
		catch(Exception e){
			L.error("Error in retrieveUser:"+e.getMessage());
		}
		return u; 
	}

}
