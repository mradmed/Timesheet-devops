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
import tn.esprit.spring.entities.Entreprise;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntrepriseServiceImplTest {
	
	@Autowired
	IEntrepriseService es;
	
	@Test
	@Order(1)
	public void testRetrieveAllEntreprises(){
		List<Entreprise> listUsers = es.retrieveAllEntreprise();
		Assertions.assertEquals(1,listUsers.size());
	}
	
	@Test
	@Order(2)
	public void testAddEntreprise() {
		
		
		Entreprise ent = new Entreprise("Obs solutions", "Bozos");
		Entreprise entAdded = es.addEntreprise(ent);
		Assertions.assertEquals(ent.getName(),entAdded.getName());
	}
	
	@Test
	@Order(3)
	public void testUpdateEntreprise() {
		
		Entreprise u = new Entreprise(1,"Obs Solutions update","Bozos updated");
		Entreprise entrepriseUpdated = es.updateEntreprise(u);
		Assertions.assertEquals(u.getName(), entrepriseUpdated.getName());

	}
	
	@Test
	@Order(4)
	public void testRetrieveEntreprise(){
		Entreprise entRet= es.retrieveEntreprise("1");
		Assertions.assertEquals(1,entRet.getId());
	}
	
	
	@Test
	@Order(5)
	public void testDeleteEntreprise(){
		
		es.deleteEntreprise("1");
		Assertions.assertNull(es.retrieveEntreprise("1"));
	}
	
	

}
