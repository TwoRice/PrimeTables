package primetables;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Scanner;

public class PrimeTables {

    public static void main(String[] args) {        
        System.out.println("Enter no of generations: ");
        int n = getIntegerInput();
        try{
            simpleMenu(n);
        }
        catch(IOException e){
            System.out.println("Unable to write to console");
            e.printStackTrace();
        }
    }
    
    public static void printPrimeTable(int n) throws IOException{
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
    
    public static void prettyPrintTableRow(long[] primeTableRow, int spaces) throws IOException{        
        OutputStream out = new BufferedOutputStream(System.out);
        
        for(int i = 0; i < primeTableRow.length; i++){
                out.write(("|" + (String.format("% " + spaces*2 + "d", primeTableRow[i]))).getBytes());
        }        
    }
    
    public static void simpleMenu(int n) throws IOException{
        int selection = 0;
        
        while (selection != 1 && selection != 2){
            System.out.println("1. Generate Primes");
            System.out.println("2. Generate Prime Multiplication Table");
            System.out.println("Enter Selection : ");
            selection = getIntegerInput();
            
            switch(selection){
                case 1:
                    PrimeGenerator p = new PrimeGenerator(n);
                    OutputStream out = new BufferedOutputStream(System.out);
                    int [] primes = p.generatePrimes(n);
                    for(int i = 0; i < primes.length; i++){
                        out.write((primes[i] + "\n").getBytes());
                    }
                    break;
                case 2:
                    printPrimeTable(n);
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;
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
