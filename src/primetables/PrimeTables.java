/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

/**
 *
 * @author Big Cheesy B
 */
public class PrimeTables {

    public static void main(String[] args) {
        int [] primes = PrimeGenerator.generatePrimes(100);
        String[][] primeTable = generatePrimeTable(primes);
    }
    
    public static String[][] generatePrimeTable(int[] primes){
        String[][] primeTable = new String[primes.length+1][primes.length+1];
        
        return primeTable;
    }
    
}
