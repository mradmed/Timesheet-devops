package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	EmployeRepository employeRepository;
	
	private static final Logger L = LogManager.getLogger(EmployeServiceImpl.class);
	
	@Override
	public List<Employe> retrieveAllEmploye() {
		List<Employe> emps = null; 
		try {
	
			L.info("In Method retrieveAllEmploye: ");
			emps = (List<Employe>) employeRepository.findAll();  
			for (Employe emp : emps) {
				L.debug("Employes in database :"+emp.toString());	
			} 
			L.info("Out of  Method retrieveAllEmploye with success: ");
		}catch (Exception e) {
			L.error(e.getMessage());
		}

		return emps;
		
		
		
	}

	@Override
	public Employe addEmploye(Employe u) {
		Employe e= null;
		try{
			L.info("In Method addEmploye: ");
			e = employeRepository.save(u);
			L.info("Out of  Method addEmploye: ");
		}
		catch(Exception exc){
			L.error("Error in addEmploye:"+exc.getMessage());
		}
		return e;
	}

	@Override
	public void deleteEmploye(String id) {
		try{
			L.info("In Method deleteEmploye: ");
		
		employeRepository.deleteById(Integer.parseInt(id)); 
		L.info("Out of Method deleteEmploye: ");
		
		
		}
		catch(Exception e){
			L.error("Error in deleteEmploye :"+e.getMessage());
		}
		
	}

	@Override
	public Employe updateEmploye(Employe u) {
		Employe empUp  =null;
		try{
			L.info("In Method updateEmploye: ");
		
			empUp= employeRepository.save(u); 
		
		L.info("Out of Method updateEmploye: ");
		}
		catch(Exception e){
			L.error("Error in updateUser:"+e.getMessage());
		}
		return empUp; 
	}

	@Override
	public Employe retrieveEmploye(String id) {
		Employe empRet=null;
		try{
			L.info("In Method retrieveEmploye: ");
		empRet =  employeRepository.findById(Integer.parseInt(id)).get(); 
		L.info("Out of Method retrieveEmploye: ");
		}
		catch(Exception e){
			L.error("Error in retrieveEmploye:"+e.getMessage());
		}
		return empRet; 
	}

}
