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
        primes[1] = 3;
    }
    
    public int[] generatePrimes(int n){        
        for(int i = 5, j = 2; j < n; i+=2){
            if(isPrime(i, j)){
                primes[j] = i;
                j++;
            }
        }
        
        return primes;
    }
    
    public boolean isPrime(int candidate, int n){
        for(int i = 0; i < n-1; i++){
            if(primes[i] <= Math.sqrt(candidate)){
                if(candidate % primes[i] == 0){
                    return false;
                }
            }
            else{
                return true;
            }
        }
        
        return true;
    }
    
}
