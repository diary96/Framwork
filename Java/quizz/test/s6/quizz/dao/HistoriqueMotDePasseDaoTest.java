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
import s6.quizz.modele.HistoriqueMotDePasse;

/**
 *
 * @author lenovo
 */
public class HistoriqueMotDePasseDaoTest {
    
    public HistoriqueMotDePasseDaoTest() {
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
     * Test of save method, of class HistoriqueMotDePasseDao.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
       int id = HistoriqueMotDePasseDao.currval();
        HistoriqueMotDePasse a = new HistoriqueMotDePasse(id,1,"test","06-03-2017");
        HistoriqueMotDePasseDao.save(a);
    
        
        HistoriqueMotDePasse verifier = HistoriqueMotDePasseDao.findById(id);
       
        HistoriqueMotDePasseDao.delete(a);
        
        assertEquals(a.getIdHistorique(), verifier.getIdHistorique());
        assertEquals(a.getJoueur().getIdJoueur(), verifier.getJoueur().getIdJoueur());
        assertEquals(a.getMotDePasseHistorique(), verifier.getMotDePasseHistorique());
        assertEquals(a.getDateAjoutHistorique(), verifier.getDateAjoutHistorique());
    }

    /**
     * Test of update method, of class HistoriqueMotDePasseDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        int id=HistoriqueMotDePasseDao.currval();
        HistoriqueMotDePasse a = new HistoriqueMotDePasse(id,1,"test","06-03-2017");
        HistoriqueMotDePasseDao.save(a);
        a = new HistoriqueMotDePasse(id,1,"seconde","06-03-2017");
        HistoriqueMotDePasseDao.update(a);
        
        HistoriqueMotDePasse verif = HistoriqueMotDePasseDao.findById(id);
        
        HistoriqueMotDePasseDao.delete(a);
        
        assertEquals(a.getIdHistorique(), verif.getIdHistorique());
        assertEquals(a.getJoueur().getIdJoueur(), verif.getJoueur().getIdJoueur());
        assertEquals(a.getMotDePasseHistorique(), verif.getMotDePasseHistorique());
        assertEquals(a.getDateAjoutHistorique(), verif.getDateAjoutHistorique());
    }

    /**
     * Test of delete method, of class HistoriqueMotDePasseDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id=HistoriqueMotDePasseDao.currval();
        HistoriqueMotDePasse a = new HistoriqueMotDePasse(id,1,"test","06-03-2017");
        HistoriqueMotDePasseDao.save(a);
        
        HistoriqueMotDePasseDao.delete(a);
        
        assertEquals(HistoriqueMotDePasseDao.findById(id), null);
    }

    /**
     * Test of findAll method, of class HistoriqueMotDePasseDao.
     */
    @Test
    public void testFindAll() throws Exception {
       System.out.println("findAll");
        ArrayList<HistoriqueMotDePasse> expResult = HistoriqueMotDePasseDao.findAll();
        
        int id=HistoriqueMotDePasseDao.currval();
        HistoriqueMotDePasse a = new HistoriqueMotDePasse(id,1,"test","06-03-2017");
        HistoriqueMotDePasseDao.save(a);
        
        ArrayList<HistoriqueMotDePasse> result = HistoriqueMotDePasseDao.findAll();
        
        HistoriqueMotDePasseDao.delete(a);
        
        assertEquals(expResult.size()+1, result.size());
    }

    /**
     * Test of findById method, of class HistoriqueMotDePasseDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        int id=CategorieDao.currval();
        HistoriqueMotDePasse a = new HistoriqueMotDePasse(id,1,"test","06-03-2017");
        HistoriqueMotDePasseDao.save(a);
        
        HistoriqueMotDePasse verif = HistoriqueMotDePasseDao.findById(id);
        
        HistoriqueMotDePasseDao.delete(a);
        
        assertEquals(a.getIdHistorique(), verif.getIdHistorique());
        assertEquals(a.getJoueur().getIdJoueur(), verif.getJoueur().getIdJoueur());
        assertEquals(a.getMotDePasseHistorique(), verif.getMotDePasseHistorique());
        assertEquals(a.getDateAjoutHistorique(), verif.getDateAjoutHistorique());
        
    }
    
}
