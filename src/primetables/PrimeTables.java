/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetables;

import java.util.Scanner;

public class PrimeTables {

    public static void main(String[] args) {        
        System.out.println("Enter no of generations: ");
        int n = getIntegerInput();
        simpleMenu(n);
    }
    
    public static void printPrimeTable(int n){
        PrimeGenerator p = new PrimeGenerator(n);
        int [] primes = p.generatePrimes(n);
        long largestPrime = (long) primes[n-1] * primes[n-1];
        int maxNoOfDigits = (int) Math.ceil(Math.log10(largestPrime));
                
        //This prints the first row of the prime table
        System.out.print("|");
        //Prints a blank for the first element in the table
        System.out.format("%" + maxNoOfDigits*2 + "s", "");
        for(int i = 0; i < primes.length; i++){
            System.out.print("|");
            System.out.format("% " + maxNoOfDigits*2 + "d", primes[i]);
        }
        
        for(int i = 0; i < primes.length; i++){
            long[] primeTableRow = generatePrimeTableRow(primes, i);
            System.out.println("");
            prettyPrintTableRow(primeTableRow, maxNoOfDigits);
        }
    }
    
    public static long[] generatePrimeTableRow(int[] primes, int rowNo){
        long[] primeTableRow = new long[primes.length+1];
        primeTableRow[0] = primes[rowNo];
        
        for(int i = 1; i < primeTableRow.length; i++){
            primeTableRow[i] = (long) primes[i-1] * primes[rowNo];
        }
           
        return primeTableRow;
    }
    
    public static void prettyPrintTableRow(long[] primeTableRow, int spaces){        
        for(int i = 0; i < primeTableRow.length; i++){
                System.out.print("|");
                System.out.format("% " + spaces*2 + "d", primeTableRow[i]);
        }        
    }
    
    public static void simpleMenu(int n){
        int selection = 0;
        
        while (selection != 1 && selection != 2){
            System.out.println("1. Generate Primes");
            System.out.println("2. Generate Prime Multiplication Table");
            System.out.println("Enter Selection : ");
            selection = getIntegerInput();
            
            switch(selection){
                case 1:
                    PrimeGenerator p = new PrimeGenerator(n);
                    int [] primes = p.generatePrimes(n);
                    for(int i = 0; i < primes.length; i++){
                        System.out.println(primes[i]);
                    }
                    break;
                case 2:
                    printPrimeTable(n);
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        }
    }
    
    public static int getIntegerInput(){
        Scanner scanner = new Scanner(System.in);
        int n;
        
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Please only enter an integer value: ");
        }
        n= scanner.nextInt();
        
        return n;
    }
    
}
