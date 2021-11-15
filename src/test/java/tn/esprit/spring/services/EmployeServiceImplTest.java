package tn.esprit.spring.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {

	
	@Autowired
	IEmployeService es;
	
	@Test
	@Order(1)
	public void testRetrieveAllEmps(){
		List<Employe> listEmp = es.retrieveAllEmploye();
		//Assertions.assertEquals(3,listEmp.size());
	}
	
	@Test
	@Order(2)
	public void testAddEmploye() {
		
		
		Employe ent = new Employe("mrad","med","bla@gmail.com","blabla",true,Role.INGENIEUR);
		Employe entAdded = es.addEmploye(ent);
		Assertions.assertEquals(ent.getPrenom(),entAdded.getPrenom());
	}
	
	@Test
	@Order(3)
	public void testUpdateEmploye() {
		
		Employe u = new Employe(1,"mrad updated","med updated","bla@gmail.com","blabla",true,Role.INGENIEUR);
		Employe empUpdated = es.updateEmploye(u);
		Assertions.assertEquals(u.getNom(), empUpdated.getNom());

	}
	@Test
	@Order(4)
	public void testRetrieveEmploye(){
		Employe userRetrieved= es.retrieveEmploye("1");
		Assertions.assertEquals(1,userRetrieved.getId());
	}
	
//	@Test
//	@Order(5)
//	public void testDeleteEmploye(){
//		
//		es.deleteEmploye("1");
//		Assertions.assertNull(es.retrieveEmploye("1"));
//	}
//	
	
	
}
