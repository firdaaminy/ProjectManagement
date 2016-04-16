/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.kelompok2.projectmanagement.data;

import id.kelompok2.projectmanagement.employees.Person;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
/**
 *
 * @author Adam
 */

@Entity
public class Database {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectManagementPU");
    private EntityManager em = emf.createEntityManager();
    
    public void saveUser(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }
}
