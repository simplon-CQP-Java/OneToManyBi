package com.formation.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.formation.entities.Phone;
import com.formation.entities.Student;

public class Test {

    public static void main(String[] args) {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("BasePU");

	EntityManager em = emf.createEntityManager();

	EntityTransaction tx = em.getTransaction();

	// Création des instances

	tx.begin();

	List<Phone> phoneNumbers = new ArrayList<Phone>();

	Student student = new Student();
	student.setStudentName("Karin");
	student.setStudentPhoneNumbers(phoneNumbers);

	Phone phone1 = new Phone();
	phone1.setPhoneType("house");
	phone1.setPhoneNumber("32354353");
	Phone phone2 = new Phone();
	phone2.setPhoneType("mobile");
	phone2.setPhoneNumber("9889343423");

	phoneNumbers.add(phone1);
	phoneNumbers.add(phone2);

	em.persist(student);
	em.persist(phone1);
	em.persist(phone2);
	tx.commit();

	// interaction avec jpa-hibernate
	// donnée persiste

	// envoie à la base

	System.out.println(student.getStudentName());

	for (Phone p : student.getStudentPhoneNumbers()) {
	    System.out.println("Phone number: " + p.getPhoneNumber());
	}

	System.out.println("OK...!");

    }

}
