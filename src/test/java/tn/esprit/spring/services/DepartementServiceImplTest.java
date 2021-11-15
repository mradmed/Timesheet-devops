package tn.esprit.spring.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class DepartementServiceImplTest {

	@Autowired
	IDepartementService ds;
	@Autowired
	IEntrepriseService es;
	

	@Test
	@Order(1)
	public void testRetrieveAllDeps(){
		List<Departement> listDep = ds.retrieveAllDepartements();
		//Assertions.assertEquals(3,listDep.size());
	}
	
	@Test
	@Order(2)
	public void testAddDepartement() {
		
		
		Departement ent = new Departement("Info");
		Entreprise e = es.retrieveEntreprise("1");
		ent.setEntreprise(e);
		Departement entAdded = ds.addDepartement(ent);
		Assertions.assertEquals(ent.getName(),entAdded.getName());
	}
	
	@Test
	@Order(3)
	public void testUpdateDepartement() {
		
		Departement u = new Departement(1,"INFO Updated");
		Departement depUpdated = ds.updateDepartement(u);
		Assertions.assertEquals(u.getName(), depUpdated.getName());

	}
	
	@Test
	@Order(4)
	public void testRetrieveDepartement(){
		Departement depRet= ds.retrieveDepartement("1");
		Assertions.assertEquals(1,depRet.getId());
	}
	
//	@Test
//	@Order(5)
//	public void testDeleteDepartement(){
//		
//		ds.deleteDepartement("1");
//		Assertions.assertNull(ds.retrieveDepartement("1"));
//	}
//	
}
