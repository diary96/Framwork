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
import s6.quizz.modele.Question;

/**
 *
 * @author lenovo
 */
public class QuestionDaoTest {
    
    public QuestionDaoTest() {
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
     * Test of save method, of class QuestionDao.
     */
    @Test
    public void testSave() throws Exception {
       System.out.println("save");
        int id = QuestionDao.currval();
        Question a = new Question(id,1,2,"test");
        QuestionDao.save(a);
    
        
        Question verifier = QuestionDao.findById(id);
       
        QuestionDao.delete(a);
        
        assertEquals(a.getIdQuestion(), verifier.getIdQuestion());
        assertEquals(a.getCategorie().getIdCategorie(), verifier.getCategorie().getIdCategorie());
        assertEquals(a.getNiveau().getIdNiveau(), verifier.getNiveau().getIdNiveau());
    }

    /**
     * Test of update method, of class QuestionDao.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        int id=QuestionDao.currval();
        Question a = new Question(id,1,2,"test");
        QuestionDao.save(a);
        a = new Question(id,2,3,"seconde");
        QuestionDao.update(a);
        
        Question verifier = QuestionDao.findById(id);
        
        QuestionDao.delete(a);
        
        assertEquals(a.getIdQuestion(), verifier.getIdQuestion());
        assertEquals(a.getCategorie().getIdCategorie(), verifier.getCategorie().getIdCategorie());
        assertEquals(a.getNiveau().getIdNiveau(), verifier.getNiveau().getIdNiveau());
    }

    /**
     * Test of delete method, of class QuestionDao.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        int id=QuestionDao.currval();
        Question a = new Question(id,1,2,"test");
        QuestionDao.save(a);
        QuestionDao.delete(a);
        assertEquals(QuestionDao.findById(id), null);
    }

    /**
     * Test of findAll method, of class QuestionDao.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        ArrayList<Question> expResult = QuestionDao.findAll();
        
        int id=QuestionDao.currval();
        
        Question a = new Question(id,1,2,"test");
        QuestionDao.save(a);
        
        ArrayList<Question> result = QuestionDao.findAll();
        
        QuestionDao.delete(a);
        
        assertEquals(expResult.size()+1, result.size());
    }

    /**
     * Test of findById method, of class QuestionDao.
     */
    @Test
    public void testFindById() throws Exception {
         System.out.println("findById");
        
        int id=QuestionDao.currval();
        
        Question a = new Question(id,1,2,"test");
        QuestionDao.save(a);
        Question verifier = QuestionDao.findById(id);
        QuestionDao.delete(a);
        
        assertEquals(a.getIdQuestion(), verifier.getIdQuestion());
        assertEquals(a.getCategorie().getIdCategorie(), verifier.getCategorie().getIdCategorie());
        assertEquals(a.getNiveau().getIdNiveau(), verifier.getNiveau().getIdNiveau());
    }
    
}
