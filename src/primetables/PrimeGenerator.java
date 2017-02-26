/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;


public class PrimeGenerator {

    private int[] primes;
    private int generations;
    
    public PrimeGenerator(int n){
        generations = n;
        primes = new int[generations+1];
        primes[0] = 1; primes[1] = 2; primes[2] = 3;   
    }
    
    public int[] generatePrimes(){
        return primes;
    }
    
    public boolean isPrime(){
        return false;
    }
    
}
