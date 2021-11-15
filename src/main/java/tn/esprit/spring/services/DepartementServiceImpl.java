package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

public class DepartementServiceImpl implements IDepartementService {

	@Autowired
	DepartementRepository departementRepository;
	
	private static final Logger L = LogManager.getLogger(DepartementServiceImpl.class);
	
	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> deps = null; 
		try {
	
		
			L.info("In Method retrieveAllDepartements: ");
			deps = (List<Departement>) departementRepository.findAll();  
			for (Departement dep : deps) {
				L.debug("Departements in database :"+dep.toString());
			} 
			L.info("Out of  Method retrieveAllDepartements with success: ");
		}catch (Exception e) {
			L.error("Error in retrieveAllDepartements:"+e.getMessage());
		}

		return deps;
	}

	@Override
	public Departement addDepartement(Departement d) {
		Departement dep =null;
		try{
		L.info("In Method addDepartement: ");
		dep= departementRepository.save(d); 
		L.info("Out of Method addDepartement: ");
		 }
		catch(Exception e) {
			L.error("Error in addDepartement:"+e.getMessage());
		}
		return dep;
	}

	@Override
	public void deleteDepartement(String id) {
		try{
			L.info("In Method deleteDepartement: ");

		departementRepository.deleteById(Integer.parseInt(id)); 
		L.info("Out of Method deleteDepartement: ");

		}
		catch(Exception e){
			L.error("Error in deleteDepartement :"+e.getMessage());
		}
	}

	@Override
	public Departement updateDepartement(Departement u) {
		Departement dep =null;
		try{
			L.info("In Method updateDepartement: ");
			dep= departementRepository.save(u); 
		L.info("Out of Method updateDepartement: ");
		}
		catch(Exception e){
			L.error("Error in updateDepartement:"+e.getMessage());
		}
		return dep; 
	}

	@Override
	public Departement retrieveDepartement(String id) {
		Departement d=new Departement();
		Optional<Departement> dep;
		try{
			L.info("In Method retrieveDepartement: ");
			dep =  departementRepository.findById(Integer.parseInt(id)); 
			if(dep.isPresent()){
				d = dep.get();
			}
		L.info("Out of Method retrieveDepartement: ");

		}
		catch(Exception e){
			L.error("Error in retrieveDepartement:"+e.getMessage());
		}
		return d; 
	}

}
