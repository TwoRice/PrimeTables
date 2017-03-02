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
        int rowNo = 1;
        long[] expResult = {3, 6, 9, 15};
        long[] result = PrimeTables.generatePrimeTableRow(primes, rowNo);
        
        System.out.println("generatePrimeTable");

        assertArrayEquals(expResult, result);
    }   
}
