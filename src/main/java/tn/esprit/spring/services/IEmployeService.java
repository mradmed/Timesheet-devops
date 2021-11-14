package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {
	List<Employe> retrieveAllEmploye(); 
	Employe addEmploye(Employe u);
	void deleteEmploye(String id);
	Employe updateEmploye (Employe u);
	Employe retrieveEmploye(String id);
}
