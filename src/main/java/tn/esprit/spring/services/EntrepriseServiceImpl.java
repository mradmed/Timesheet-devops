package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	private static final Logger L = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	
	
	@Override
	public List<Entreprise> retrieveAllEntreprise() {
		List<Entreprise> emps = null; 
		try {
	
			L.info("In Method retrieveAllEntreprise: ");
			emps = (List<Entreprise>) entrepriseRepository.findAll();  
			for (Entreprise emp : emps) {
				L.debug("Entreprise in database :"+emp.toString());	
			} 
			L.info("Out of  Method retrieveAllEntreprise with success: ");
		}catch (Exception e) {
			L.error(e.getMessage());
		}

		return emps;
	}

	@Override
	public void deleteEntreprise(String id) {
		try{
			L.info("In Method deleteEntreprise: ");
		
		entrepriseRepository.deleteById(Integer.parseInt(id)); 
		L.info("Out of Method deleteEntreprise: ");

		}
		catch(Exception e){
			L.error("Error in deleteEntreprise :"+e.getMessage());
		}
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise u) {
		Entreprise empUp  =null;
		try{
			L.info("In Method updateEntreprise: ");
		
			empUp= entrepriseRepository.save(u); 
		
		L.info("Out of Method updateEntreprise: ");
		}
		catch(Exception e){
			L.error("Error in updateEntreprise:"+e.getMessage());
		}
		return empUp; 
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		Entreprise empRet=null;
		try{
			L.info("In Method retrieveEntreprise: ");
		empRet =  entrepriseRepository.findById(Integer.parseInt(id)).get(); 
		L.info("Out of Method retrieveEntreprise: ");
		}
		catch(Exception e){
			L.error("Error in retrieveEmploye:"+e.getMessage());
		}
		return empRet; 
	}


	@Override
	public Entreprise addEntreprise(Entreprise u) {
		Entreprise e= null;
		try{
			L.info("In Method addEntreprise: ");
			e = entrepriseRepository.save(u);
			L.info("Out of  Method addEntreprise: ");
		}
		catch(Exception exc){
			L.error("Error in addEntreprise:"+exc.getMessage());
		}
		return e;
	}


}
