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
        PrimeGenerator p = new PrimeGenerator(n);
        int [] primes = p.generatePrimes(n);
        int maxNoOfDigits = (int) Math.ceil(Math.log10(primes[n-1] * primes[n-1]));
                
        //This prints the first row of the prime table
        System.out.print("|");
        //Prints a blank for the first element in the table
        System.out.format("%" + maxNoOfDigits*2 + "s", "");
        for(int i = 0; i < primes.length; i++){
            System.out.print("|");
            System.out.format("% " + maxNoOfDigits*2 + "d", primes[i]);
        }
        
        for(int i = 0; i < primes.length; i++){
            int[] primeTableRow = generatePrimeTableRow(primes, i);
            System.out.println("");
            prettyPrintTableRow(primeTableRow, maxNoOfDigits);
        }

    }
    
    public static int[] generatePrimeTableRow(int[] primes, int rowNo){
        int[] primeTableRow = new int[primes.length+1];
        primeTableRow[0] = primes[rowNo];
        
        for(int i = 1; i < primeTableRow.length; i++){
            primeTableRow[i] = primes[i-1] * primes[rowNo];
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
