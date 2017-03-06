/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s6.quizz.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import s6.quizz.modele.Joueur;

/**
 *
 * @author lenovo
 */
public class JoueurDaoTest {
    
    public JoueurDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class JoueurDao.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
       int id = JoueurDao.currval();
        Joueur a = new Joueur(id,"test","16-04-1999","test@test.com","Test");
        JoueurDao.save(a);
    
        
        Joueur verifier = JoueurDao.findById(id);
       
        JoueurDao.delete(a);
        
        assertEquals(a.getIdJoueur(), verifier.getIdJoueur());
        assertEquals(a.getNomJoueur(), verifier.getNomJoueur());
        assertEquals(a.getNaissanceJoueur(), verifier.getNaissanceJoueur());
        assertEquals(a.getEmailJoueur(), verifier.getEmailJoueur());
        assertEquals(a.getMotDePasseJoueur(), verifier.getMotDePasseJoueur());
    }

    /**
     * Test of update method, of class JoueurDao.
     */
    @Test
    public void testUpdate() throws Exception {
         System.out.println("update");
        int id=JoueurDao.currval();
        Joueur a = new Joueur(id,"test","16-04-1999","test@test.com","Test");
        JoueurDao.save(a);
        a = new Joueur(id,"seconde","16-04-1999","seconde@test.com","seconde");
        JoueurDao.update(a);
        
        Joueur verif = JoueurDao.findById(id);
        
        JoueurDao.delete(a);
        
        assertEquals(a.getIdJoueur(), verif.getIdJoueur());
        assertEquals(a.getNomJoueur(), verif.getNomJoueur());
        assertEquals(a.getNaissanceJoueur(), verif.getNaissanceJoueur());
        assertEquals(a.getEmailJoueur(), verif.getEmailJoueur());
        assertEquals(a.getMotDePasseJoueur(), verif.getMotDePasseJoueur());
    }

    /**
     * Test of delete method, of class JoueurDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id=JoueurDao.currval();
        Joueur a = new Joueur(id,"test","16-04-1999","test@test.com","Test");
        JoueurDao.save(a);
        JoueurDao.delete(a);
        assertEquals(JoueurDao.findById(id), null);
    }

    /**
     * Test of findAll method, of class JoueurDao.
     */
    @Test
    public void testFindAll() throws Exception {
         System.out.println("findAll");
        ArrayList<Joueur> expResult = JoueurDao.findAll();
        
        int id=JoueurDao.currval();
        Joueur a = new Joueur(id,"test","16-04-1999","test@test.com","Test");
        JoueurDao.save(a);
        
        ArrayList<Joueur> result = JoueurDao.findAll();
        
        JoueurDao.delete(a);
        
        assertEquals(expResult.size()+1, result.size());
    }

    /**
     * Test of findById method, of class JoueurDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id=JoueurDao.currval();
        Joueur a = new Joueur(id,"test","16-04-1999","test@test.com","Test");
        JoueurDao.save(a);
        Joueur verif = JoueurDao.findById(id);
        JoueurDao.delete(a);
        assertEquals(a.getIdJoueur(), verif.getIdJoueur());
        assertEquals(a.getNomJoueur(), verif.getNomJoueur());
        assertEquals(a.getNaissanceJoueur(), verif.getNaissanceJoueur());
        assertEquals(a.getEmailJoueur(), verif.getEmailJoueur());
        assertEquals(a.getMotDePasseJoueur(), verif.getMotDePasseJoueur());
    }
    
}
