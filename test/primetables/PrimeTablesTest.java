/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

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
public class PrimeTablesTest {
    
    public PrimeTablesTest() {
    }
    

    @Test
    public void testGeneratePrimeTable() {
        int[] primes = {2, 3, 5};
        int[][] expResult = {{0,2,3,5}, 
                            {2,4,6,10},
                            {3,6,9,15},
                            {5,10,15,25}
        };
        int[][] result = PrimeTables.generatePrimeTable(primes);
        
        System.out.println("generatePrimeTable");

        assertArrayEquals(expResult, result);
    }

    
}
