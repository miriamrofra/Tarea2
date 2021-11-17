/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentabancaria;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miria
 */
public class CuentaBancariaTest {

    private CuentaBancaria c1;
    private CuentaBancaria c2;
    private CuentaBancaria negativo;

    public CuentaBancariaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        c1 = new CuentaBancaria(12345, 50);
        c2 = new CuentaBancaria(67890, 0);
        negativo = new CuentaBancaria(111, -400);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Withdraw method, of class CuentaBancaria.
     */
    @Test
    public void testWithdraw() {

        System.out.println("Withdraw");
        int x = 550;
        try {
            c1.Withdraw(x);
            int result = c1.getBalance();
            assertEquals(-500, result);
        } catch (Exception ex) {
            Logger.getLogger(CuentaBancariaTest.class.getName()).log(Level.SEVERE, null, ex);
            //fail("The test case is a prototype.");
        }
    }

    @Test
    public void testWithdrawfail() {
        System.out.println("Withdraw");
        int x = 200;
        try {
            negativo.Withdraw(x);

            fail("Debe saltar excepcion.");
        } catch (Exception e) {

            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), "No puedes retirar saldo");

        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Deposit method, of class CuentaBancaria.
     */
    @Test
    public void testDeposit() {
        System.out.println("Deposit");
        int x = 100;
        c2.Deposit(x);
        int result = c2.getBalance();
        assertEquals(100, result);
    }

    /**
     * Test of getBalance method, of class CuentaBancaria.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        int result = c1.getBalance();
        assertEquals(50, result);
    }

    @Test
    public void test0014() {

        System.out.println("Test 0014");

        try {
            c1.Withdraw(200); // -150
        } catch (Exception ex) {
            Logger.getLogger(CuentaBancariaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            c2.Withdraw(350); // -350
        } catch (Exception ex) {
            Logger.getLogger(CuentaBancariaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        c1.Deposit(100); // -50
        try {
            c2.Withdraw(200);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "No puedes retirar saldo");

        }

        try {
            c2.Withdraw(150); // -500
        } catch (Exception ex) {
            Logger.getLogger(CuentaBancariaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            c1.Withdraw(200); //-250
        } catch (Exception ex) {
            Logger.getLogger(CuentaBancariaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        c2.Deposit(50); //-450

        try {
            c2.Withdraw(100);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "No puedes retirar saldo");

        }

        assertEquals(c1.getBalance(), -250);
        assertEquals(c2.getBalance(), -450);

    }

}
