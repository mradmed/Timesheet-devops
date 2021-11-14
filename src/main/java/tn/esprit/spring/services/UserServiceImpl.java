package tn.esprit.spring.services;

import java.util.List;

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

	// TODO Logger à ajouter  
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			
			// TODO Log à ajouter en début de la méthode 
			L.info("In Method retrieveAllUsers: ");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				L.debug("Users in database :"+user.toString());
				// TODO Log à ajouter pour affiher chaque user dans les logs   
			} 
			L.info("Out of  Method retrieveAllUsers with success: ");
			// TODO Log à ajouter à la fin de la méthode 
		}catch (Exception e) {
			L.error("Error in retrieveAllUsers:"+e.getMessage());
			// TODO Log à ajouter pour gérer les erreurs 
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		User u_saved =null;
		try{
		L.info("In Method addUser: ");
		u_saved= userRepository.save(u); 
		L.info("Out of Method addUser: ");
		// TODO Log à ajouter à la fin de la méthode 
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
		// TODO Log à ajouter en début de la méthode 
		u_saved= userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
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
		// TODO Log à ajouter en début de la méthode 
		userRepository.deleteById(Long.parseLong(id)); 
		L.info("Out of Method deleteUser: ");
		
		// TODO Log à ajouter à la fin de la méthode 
		}
		catch(Exception e){
			L.error("Error in deleteUser :"+e.getMessage());
		}
	}
	

	@Override
	public User retrieveUser(String id) {
		User u=null;
		try{
		// TODO Log à ajouter en début de la méthode 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
			L.info("In Method retrieveUser: ");
		u =  userRepository.findById(Long.parseLong(id)).get(); 
		L.info("Out of Method retrieveUser: ");
		// TODO Log à ajouter à la fin de la méthode 
		}
		catch(Exception e){
			L.error("Error in retrieveUser:"+e.getMessage());
		}
		return u; 
	}

}
