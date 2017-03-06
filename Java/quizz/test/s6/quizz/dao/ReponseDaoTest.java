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
import s6.quizz.modele.Reponse;

/**
 *
 * @author lenovo
 */
public class ReponseDaoTest {
    
    public ReponseDaoTest() {
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
     * Test of save method, of class ReponseDao.
     */
    @Test
    public void testSave() throws Exception {
         System.out.println("save");
        int id = ReponseDao.currval();
        Reponse a = new Reponse(id,1,"tes",0);
        ReponseDao.save(a);
    
        
        Reponse verifier = ReponseDao.findById(id);
       
        ReponseDao.delete(a);
        
        assertEquals(a.getIdReponse(), verifier.getIdReponse());
        assertEquals(a.getQuestion().getIdQuestion(), verifier.getQuestion().getIdQuestion());
        assertEquals(a.getReponse(), verifier.getReponse());
        assertEquals(a.getIfVrai(), verifier.getIfVrai());
    }

    /**
     * Test of update method, of class ReponseDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        int id=ReponseDao.currval();
        Reponse a = new Reponse(id,1,"tes",0);
        ReponseDao.save(a);
        a = new  Reponse(id,2,"seconde",1);
        ReponseDao.update(a);
        
        Reponse verifier = ReponseDao.findById(id);
        
        ReponseDao.delete(a);
        
        assertEquals(a.getIdReponse(), verifier.getIdReponse());
        assertEquals(a.getQuestion().getIdQuestion(), verifier.getQuestion().getIdQuestion());
        assertEquals(a.getReponse(), verifier.getReponse());
        assertEquals(a.getIfVrai(), verifier.getIfVrai());
        
    }

    /**
     * Test of delete method, of class ReponseDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id=ReponseDao.currval();
        Reponse a = new Reponse(id,1,"tes",0);
        ReponseDao.save(a);
        ReponseDao.delete(a);
        assertEquals(ReponseDao.findById(id), null);
    }

    /**
     * Test of findAll method, of class ReponseDao.
     */
    @Test
    public void testFindAll() throws Exception {
       System.out.println("findAll");
        ArrayList<Reponse> expResult = ReponseDao.findAll();
        
        int id=ReponseDao.currval();
        
        Reponse a = new Reponse(id,1,"tes",0);
        ReponseDao.save(a);
        
        ArrayList<Reponse> result = ReponseDao.findAll();
        
        ReponseDao.delete(a);
        
        assertEquals(expResult.size()+1, result.size());
    }

    /**
     * Test of findById method, of class ReponseDao.
     */
    @Test
    public void testFindById() throws Exception {
       System.out.println("findById");
        
        int id=ReponseDao.currval();
        
        Reponse a = new Reponse(id,1,"tes",0);
        ReponseDao.save(a);
        Reponse verifier = ReponseDao.findById(id);
        ReponseDao.delete(a);
        
        assertEquals(a.getIdReponse(), verifier.getIdReponse());
        assertEquals(a.getQuestion().getIdQuestion(), verifier.getQuestion().getIdQuestion());
        assertEquals(a.getReponse(), verifier.getReponse());
        assertEquals(a.getIfVrai(), verifier.getIfVrai());
        
    }
    
}
