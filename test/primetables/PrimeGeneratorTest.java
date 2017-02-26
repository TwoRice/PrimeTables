/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Big Cheesy B
 */
public class PrimeGeneratorTest {
    
    public PrimeGeneratorTest() {
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

    @Test
    public void testGeneratePrimes_Small() {
        int startIndex = 4;
        int endIndex = 10;
        int[] expResult = {11, 13, 17, 19, 23, 29};
        int[] result = Arrays.copyOfRange(PrimeGenerator.generatePrimes(endIndex), startIndex, endIndex);
        
        System.out.println("generatePrimes");
        
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testIsPrime() {
        int testNo = 11;
        int[] primes = {3, 5, 7};
        boolean expResult = true;
        boolean result = PrimeGenerator.isPrime(primes, testNo);
        
        System.out.println("isPrime");
        
        assertEquals(expResult, result);
    }
    
}
