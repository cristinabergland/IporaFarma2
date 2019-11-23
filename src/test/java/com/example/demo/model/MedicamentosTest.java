/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristina
 */
public class MedicamentosTest {
    
    public MedicamentosTest() {
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
     * Test of getId method, of class Medicamentos.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Medicamentos instance = new Medicamentos();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Medicamentos.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Medicamentos instance = new Medicamentos();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Medicamentos.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Medicamentos instance = new Medicamentos();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Medicamentos.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Medicamentos instance = new Medicamentos();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPreco method, of class Medicamentos.
     */
    @Test
    public void testGetPreco() {
        System.out.println("getPreco");
        Medicamentos instance = new Medicamentos();
        double expResult = 0.0;
        double result = instance.getPreco();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPreco method, of class Medicamentos.
     */
    @Test
    public void testSetPreco() {
        System.out.println("setPreco");
        double preco = 0.0;
        Medicamentos instance = new Medicamentos();
        instance.setPreco(preco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantidade method, of class Medicamentos.
     */
    @Test
    public void testGetQuantidade() {
        System.out.println("getQuantidade");
        Medicamentos instance = new Medicamentos();
        Long expResult = null;
        Long result = instance.getQuantidade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantidade method, of class Medicamentos.
     */
    @Test
    public void testSetQuantidade() {
        System.out.println("setQuantidade");
        Long quantidade = null;
        Medicamentos instance = new Medicamentos();
        instance.setQuantidade(quantidade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSexo method, of class Medicamentos.
     */
    @Test
    public void testGetSexo() {
        System.out.println("getSexo");
        Medicamentos instance = new Medicamentos();
        String expResult = "";
      //  String result = instance.getSexo();
      //  assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSexo method, of class Medicamentos.
     */
    @Test
    public void testSetSexo() {
        System.out.println("setSexo");
        String sexo = "";
        Medicamentos instance = new Medicamentos();
       // instance.setSexo(sexo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrincipioAtivo method, of class Medicamentos.
     */
    @Test
    public void testGetPrincipioAtivo() {
        System.out.println("getPrincipioAtivo");
        Medicamentos instance = new Medicamentos();
        String expResult = "";
        String result = instance.getPrincipioAtivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrincipioAtivo method, of class Medicamentos.
     */
    @Test
    public void testSetPrincipioAtivo() {
        System.out.println("setPrincipioAtivo");
        String principioAtivo = "";
        Medicamentos instance = new Medicamentos();
        instance.setPrincipioAtivo(principioAtivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConcentracao method, of class Medicamentos.
     */
    @Test
    public void testGetConcentracao() {
        System.out.println("getConcentracao");
        Medicamentos instance = new Medicamentos();
        String expResult = "";
        String result = instance.getConcentracao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConcentracao method, of class Medicamentos.
     */
    @Test
    public void testSetConcentracao() {
        System.out.println("setConcentracao");
        String concentracao = "";
        Medicamentos instance = new Medicamentos();
        instance.setConcentracao(concentracao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormaFarmaceutica method, of class Medicamentos.
     */
    @Test
    public void testGetFormaFarmaceutica() {
        System.out.println("getFormaFarmaceutica");
        Medicamentos instance = new Medicamentos();
        String expResult = "";
        String result = instance.getFormaFarmaceutica();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormaFarmaceutica method, of class Medicamentos.
     */
    @Test
    public void testSetFormaFarmaceutica() {
        System.out.println("setFormaFarmaceutica");
        String formaFarmaceutica = "";
        Medicamentos instance = new Medicamentos();
        instance.setFormaFarmaceutica(formaFarmaceutica);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistroAnvisa method, of class Medicamentos.
     */
    @Test
    public void testGetRegistroAnvisa() {
        System.out.println("getRegistroAnvisa");
        Medicamentos instance = new Medicamentos();
        int expResult = 0;
        int result = instance.getRegistroAnvisa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistroAnvisa method, of class Medicamentos.
     */
    @Test
    public void testSetRegistroAnvisa() {
        System.out.println("setRegistroAnvisa");
        int registroAnvisa = 0;
        Medicamentos instance = new Medicamentos();
        instance.setRegistroAnvisa(registroAnvisa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDetentorRegistro method, of class Medicamentos.
     */
    @Test
    public void testGetDetentorRegistro() {
        System.out.println("getDetentorRegistro");
        Medicamentos instance = new Medicamentos();
        String expResult = "";
        String result = instance.getDetentorRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDetentorRegistro method, of class Medicamentos.
     */
    @Test
    public void testSetDetentorRegistro() {
        System.out.println("setDetentorRegistro");
        String detentorRegistro = "";
        Medicamentos instance = new Medicamentos();
        instance.setDetentorRegistro(detentorRegistro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagens method, of class Medicamentos.
     */
    @Test
    public void testGetImagens() {
        System.out.println("getImagens");
        Medicamentos instance = new Medicamentos();
        List<Imagem> expResult = null;
        List<Imagem> result = instance.getImagens();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImagens method, of class Medicamentos.
     */
    @Test
    public void testSetImagens() {
        System.out.println("setImagens");
        List<Imagem> imagens = null;
        Medicamentos instance = new Medicamentos();
        instance.setImagens(imagens);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCategoria method, of class Medicamentos.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Medicamentos instance = new Medicamentos();
        List<Categoria> expResult = null;
        List<Categoria> result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoria method, of class Medicamentos.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        List<Categoria> categoria = null;
        Medicamentos instance = new Medicamentos();
        instance.setCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFarmacia method, of class Medicamentos.
     */
    @Test
    public void testGetFarmacia() {
        System.out.println("getFarmacia");
        Medicamentos instance = new Medicamentos();
        Farmacia expResult = null;
        Farmacia result = instance.getFarmacia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFarmacia method, of class Medicamentos.
     */
    @Test
    public void testSetFarmacia() {
        System.out.println("setFarmacia");
        Farmacia farmacia = null;
        Medicamentos instance = new Medicamentos();
        instance.setFarmacia(farmacia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAtivo method, of class Medicamentos.
     */
    @Test
    public void testGetAtivo() {
        System.out.println("getAtivo");
        Medicamentos instance = new Medicamentos();
        int expResult = 0;
      //  int result = instance.getAtivo();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtivo method, of class Medicamentos.
     */
    @Test
    public void testSetAtivo() {
        System.out.println("setAtivo");
        int ativo = 0;
        Medicamentos instance = new Medicamentos();
       // instance.setAtivo(ativo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Medicamentos.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Medicamentos instance = new Medicamentos();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Medicamentos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Medicamentos instance = new Medicamentos();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
