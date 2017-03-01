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
        int maxNoOfDigits = (int) Math.ceil(Math.log10(primes[n-1] * primes[n-1]));
                
        for(int i = 0; i < primes.length; i++){
            int[] primeTableRow = generatePrimeTableRow(primes, i);
            System.out.println("");
            prettyPrintTableRow(primeTableRow, maxNoOfDigits);
        }

    }
    
    public static int[] generatePrimeTableRow(int[] primes, int rowNo){
        int[] primeTableRow = new int[primes.length];
        
        for(int i = 0; i < primes.length; i++){
            primeTableRow[i] = primes[i] * primes[rowNo];
        }
           
        return primeTableRow;
    }
    
    public static void prettyPrintTableRow(int[] primeTableRow, int spaces){        
        for(int i = 0; i < primeTableRow.length; i++){
                System.out.print("|");
                System.out.format("% " + spaces*2 + "d", primeTableRow[i]);
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
