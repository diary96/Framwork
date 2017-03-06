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
import s6.quizz.modele.NiveauQuestion;

/**
 *
 * @author lenovo
 */
public class NiveauQuestionDaoTest {
    
    public NiveauQuestionDaoTest() {
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
     * Test of save method, of class NiveauQuestionDao.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        int id = NiveauQuestionDao.currval();
        NiveauQuestion a = new NiveauQuestion(id,5,"Test");
        NiveauQuestionDao.save(a);
    
        
        NiveauQuestion verifier = NiveauQuestionDao.findById(id);
       
        NiveauQuestionDao.delete(a);
        
        assertEquals(a.getIdNiveau(), verifier.getIdNiveau());
        assertEquals(a.getRankNiveau(), verifier.getRankNiveau());
        assertEquals(a.getNomNiveau(), verifier.getNomNiveau());
    }

    /**
     * Test of update method, of class NiveauQuestionDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        int id=NiveauQuestionDao.currval();
        NiveauQuestion a = new NiveauQuestion(id,5,"Test");
        NiveauQuestionDao.save(a);
        a = new NiveauQuestion(id,5,"seconde");
        NiveauQuestionDao.update(a);
        
        NiveauQuestion verifier = NiveauQuestionDao.findById(id);
        
        NiveauQuestionDao.delete(a);
        
        assertEquals(a.getIdNiveau(), verifier.getIdNiveau());
        assertEquals(a.getRankNiveau(), verifier.getRankNiveau());
        assertEquals(a.getNomNiveau(), verifier.getNomNiveau());
    }

    /**
     * Test of delete method, of class NiveauQuestionDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id=NiveauQuestionDao.currval();
        NiveauQuestion a = new NiveauQuestion(id,5,"Test");
        NiveauQuestionDao.save(a);
        NiveauQuestionDao.delete(a);
        assertEquals(NiveauQuestionDao.findById(id), null);
    }

    /**
     * Test of findAll method, of class NiveauQuestionDao.
     */
    @Test
    public void testFindAll() throws Exception {
         System.out.println("findAll");
        ArrayList<NiveauQuestion> expResult = NiveauQuestionDao.findAll();
        
        int id=NiveauQuestionDao.currval();
        NiveauQuestion a = new NiveauQuestion(id,5,"Test");
        NiveauQuestionDao.save(a);
        
        ArrayList<NiveauQuestion> result = NiveauQuestionDao.findAll();
        
        NiveauQuestionDao.delete(a);
        
        assertEquals(expResult.size()+1, result.size());
    }

    /**
     * Test of findById method, of class NiveauQuestionDao.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        
        int id=NiveauQuestionDao.currval();
        
        NiveauQuestion a = new NiveauQuestion(id,5,"Test");
        NiveauQuestionDao.save(a);
        NiveauQuestion verifier = NiveauQuestionDao.findById(id);
        NiveauQuestionDao.delete(a);
        
        assertEquals(a.getIdNiveau(), verifier.getIdNiveau());
        assertEquals(a.getRankNiveau(), verifier.getRankNiveau());
        assertEquals(a.getNomNiveau(), verifier.getNomNiveau());
    }
    
}
