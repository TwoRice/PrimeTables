/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

import java.util.Scanner;

public class PrimeTables {

    public static void main(String[] args) {
        int n = getInputN();
        int [] primes = PrimeGenerator.generatePrimes(n);
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
        
        int maxNoOfDigits = (int) Math.ceil(Math.log10(primeTable[primeTable[0].length-1][primeTable[0].length-1]));
        
        System.out.print("|");
        System.out.format("%" + maxNoOfDigits*2 + "s", "");
        
        for(int i = 0; i < primeTable[0].length-1; i++){
            System.out.print("|");
            System.out.format("% " + maxNoOfDigits*2 + "d", primeTable[i+1][0]);
        }
                
        for(int i = 1; i < primeTable[0].length; i++){
            System.out.println();
            for(int j = 0; j < primeTable[0].length; j++){
                System.out.print("|");
                System.out.format("% " + maxNoOfDigits*2 + "d", primeTable[i][j]);
            }        
        }
    }
    
    public static int getInputN(){
        Scanner scanner = new Scanner(System.in);
        int n;
        
        System.out.println("Enter no of generations: ");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Please only enter an integer value: ");
        }
        n= scanner.nextInt();
        
        return n;
    }
    
}
