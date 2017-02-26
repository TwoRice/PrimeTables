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
        int [] primes = PrimeGenerator.generatePrimes(3);
        int[][] primeTable = generatePrimeTable(primes);
        prettyPrintTable(primeTable);
    }
    
    public static int[][] generatePrimeTable(int[] primes){
        int[][] primeTable = new int[primes.length+1][primes.length+1];
        primeTable[0][0] = 1;
        
        for(int i = 0; i < primes.length; i++){
            primeTable[i+1][0] = primes[i];
            primeTable[0][i+1] = primes[i];
        }
        
        for(int i = 1; i <= primes.length; i++){
            for(int j = 1; j <= primes.length; j++){
                primeTable[i][j] = primes[i-1] * primes[j-1];
            }
        }
           
        return primeTable;
    }
    
    public static void prettyPrintTable(int[][] primeTable){
          
    }
    
}
