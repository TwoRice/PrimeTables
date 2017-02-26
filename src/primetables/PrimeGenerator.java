/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;


public class PrimeGenerator {

    public static int[] generatePrimes(int n){
        int[] primes = new int[n+1];
        primes[0] = 1; primes[1] = 2; primes[2] = 3;
        
        for(int i = 5, j = 3; j <= n; i+=2){
            if(isPrime(i)){
                primes[j] = i;
                j++;
            }
        }
        
        return primes;
    }
    
    public static boolean isPrime(int candidate){
        return false;
    }
    
}
