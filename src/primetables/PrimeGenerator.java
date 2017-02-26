/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

import java.util.Arrays;


public class PrimeGenerator {

    public static int[] generatePrimes(int n){
        int[] primes = new int[n];
        primes[0] = 2; primes[1] = 3;
        
        for(int i = 5, j = 2; j < n; i+=2){
            if(isPrime(Arrays.copyOfRange(primes, 1, j), i)){
                primes[j] = i;
                j++;
            }
        }
        
        return primes;
    }
    
    public static boolean isPrime(int[] primes, int candidate){
        for(int i = 0; i < primes.length; i++){
            if(candidate / primes[i] >= 3){
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
