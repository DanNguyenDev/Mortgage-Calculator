package com.codingwithdaniel.practice;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        // Create your constant variables

        final int PERCENTAGE = 100;
        final int YEARS = 12;

        // Enter the range for the loan

        System.out.print("Principal ($1K - $1M): ");

        // Declare the Scanner of the code and read in the input

        Scanner scanner = new Scanner(System.in);
        double principal = scanner.nextDouble();

        // Make a while loop if the input is invalid

        while(principal < 1000 || principal > 1_000_000)
        {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextDouble();
        }

        // Read input for the annual interest rate

        System.out.print("Annual Interest Rate: ");
        double interest_rate = scanner.nextDouble();

        // Create a while loop if the input validation is not valid

        while(interest_rate <= 0 || interest_rate > 30)
        {
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
            System.out.print("Annual interest rate: ");
            interest_rate = scanner.nextDouble();
        }

        // Read input for the period or the amount of years

        System.out.print("Period (Years): ");
        double period = scanner.nextDouble();

        // Create a while loop if the input validation is invalid

        while(period < 1 || period > 30)
        {
            System.out.println("Enter a value between 1 and 30");
            System.out.print("Period (Years): ");
            period = scanner.nextDouble();
        }

        // Calculate the annual percentage value to a valid value

        double monthly_rate = interest_rate / YEARS / PERCENTAGE;
        double monthly_payments = period * YEARS;

        // Create the formula to calculate for the mortgage

        double mortgage = principal * ((monthly_rate * Math.pow(1 + monthly_rate, monthly_payments))
                / (Math.pow(1 + monthly_rate, monthly_payments) - 1));

        // Format the mortgage into currency values and display the mortgage calculated

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);



      }
    }
