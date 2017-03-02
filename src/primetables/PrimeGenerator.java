/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

import java.util.Arrays;


public class PrimeGenerator {

    int[] primes;
    int n;
    
    public PrimeGenerator(int n){
        this.n = n;
        primes = new int[n];
        primes[0] = 2;
    }
    
    public int[] generatePrimes(int n){        
        //Calculates the approximate value for the nth prime. Used as an upper limit for the sieve
        double dMax = (n*Math.log(n)) + (n*Math.log(Math.log(n)));
        int max = (int) Math.ceil(dMax);
        //The above algorithm only works for n >= 6.
        if(n < 6){
            max = 12;
        }
        int root = (int) Math.sqrt(max);
        int count = 1;
        boolean[] isPrime = new boolean[max-2];
                
        for(int i = 0; i < max-2; i++){
            isPrime[i] = true;
        }
                        
        for(int i = 3; i <= root; i++){
            if(isPrime[i-2]){
                for(int j = 2*i; j <= max-2; j+= i){
                    isPrime[j-2] = false;
                }
            }
        }
        
        for(int i = 1; i < max-2; i+=2){
            if(isPrime[i] && count < n){
                primes[count] = i+2;
                count++;
            }
        }

        return primes;
    }
    
//    public boolean isPrime(int candidate, int n){
//        
//        
//        return true;
//    }
    
}
