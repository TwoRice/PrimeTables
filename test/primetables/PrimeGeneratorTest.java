/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
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
        int[] expResult = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int n = expResult.length;
        PrimeGenerator instance = new PrimeGenerator(n);
        int[] result = instance.generatePrimes(n);
        
        System.out.println("generatePrimes_Small");
        
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Tests the primes are generated correctly up to a maximum of 1000000 generations
     */
    @Test
    public void testGeneratePrimes_Large(){
        int n = 1000000;
        PrimeGenerator instance = new PrimeGenerator(n);
        int[] expResult = readPrimesFromFile(n);
        int[] result = instance.generatePrimes(n);
        
        System.out.println("generatePrime_Large");
        
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testIsPrime() {
        int[] primes = {2, 3, 5, 7}; 
        PrimeGenerator instance = new PrimeGenerator(primes.length);
        int testNo = 11;
        boolean expResult = true;
        boolean result = instance.isPrime(testNo, 3);
        
        System.out.println("isPrime");
        
        assertEquals(expResult, result);
    }
    
    /**
     * Reads up to a million primes from a selection of files 
     */
    private int[] readPrimesFromFile(int n){
        //Rounds n to the nearest power of 10
        double digits = Math.ceil(Math.log10(n));
        int fileNo = (int) Math.pow(10, digits);
        
        if(fileNo < 100){
            fileNo = 100;
        }
        else if(fileNo > 1000000){
            fileNo = 1000000;
        }
        
        //Sets size of prime array to a max of 1 million
        if(n > fileNo){
            n = fileNo;
        }
        int[] primes = new int[n];
                
        try{
            Scanner scanner = new Scanner(new File("primeFiles/P-" + fileNo + ".txt"));
            for(int i = 0; i < n; i++){
                primes[i] = Integer.valueOf(scanner.nextLine().split(", ")[1]);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Couldn't find file");
            e.printStackTrace();
        }
        
       return primes; 
    }
    
}
