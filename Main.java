import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static boolean[] primes;                                         //Global array of prime numbers I'll be using throughout the assignment
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();                                     //Read input number
        if (number % 2 == 0) {                                              //Check if input number is even
            long startTime = System.currentTimeMillis();                    //Start timer (to print in the end run time)
            primes = getPrimes(number);                                     //Set prime numbers all the way to the given number
            Q_A(number);                                                    //Call Q_A with the input number
            Q_B(number);                                                    //Call Q_B with the input number
            Q_C(number);                                                    //Call Q_C with the input number
            Q_D(number);                                                    //Call Q_D with the input number
            long endTime = System.currentTimeMillis();                      //Stop timer
            long runTime = endTime - startTime;                             //Calculate and final time
            System.out.println("e) " + (runTime / 1000.0) + " seconds");    //Print run time in seconds
            System.out.println("f) ID: 321482481");                         //Print I.D
        } else {                                                            //If number is odd
            System.out.println("ERROR!\nEnter an even number!");            //Display error message
        }
        scanner.close();                                                    //End use of Scanner
    }

    /*In this function we will find two prime numbers that sum to the input number:
    *Pseudocode for Q_A:
    *FOR i FROM 2 TO length of primes array:
    *   IF i is a prime number
    *       FOR j FROM 2 TO number
    *           IF j is a prime number
    *                IF i + j = number
    *                    PRINT "a) " + number + " = " + i + " + " + j
    *                    EXIT FUNCTION */

    static void Q_A(int number) {
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {                                                            //I'm in a prime number
                for (int j = 2; j < primes.length; j++) {                               //Start looking through other prime numbers
                    if (primes[j]) {                                                    //I have 2 prime numebrs
                        if (i + j == number) {                                          //If they add up to num
                            System.out.println("a) " + number + " = " + i + " + " + j); //Print the pair (i + j = num)
                            return;
                        }
                    }
                }
            }
        }
    }



    /*In this function we will find two prime numbers such that one subtracted from the other equals the input number:
     *Pseudocode for Q_B:
     *Boolean pairFound = false
     *Set counter i = number + 1
     *DO:
     *  FOR j FROM 2 TO number:
     *      IF i is a prime number AND j is a prime number
     *          IF i - j = number:
     *              PRINT "b) " + number + " = " + i + " - " + j
     *              pairFound = true
     *              Exit inner FOR loop
     *  i++
     *WHILE pairFound = false*/
    static void Q_B(int number) {
        boolean pairFound = false;                                                  //Set Boolean variable pairFound to false
        int i = number + 1;                                                         //Set counter i to first number bigger than our number
        do {
            for (int j = 2; j <= primes.length; j++) {                              //For loop j from 2 to number (inclusive):
                if (isPrime(i) && primes[j]) {                                      //If i and j are prime numbers
                    if (i - j == number) {                                          //And thier difference equal to the input number
                        System.out.println("b) " + number + " = " + i + " - " + j); //Print the pair
                        pairFound = true;                                           //Set pairFound to true (to exit outer loop)
                        break;                                                      //Break inner loop
                    }
                }
            }
            i++;                                                                    //If pair not found increment i
        } while (!pairFound);                                                       //While pairFound is false do that again
    }

    /*In this function we will count and print the number of prime numbers up to the input number:
    *Pseudocode for Q_C:
    *count = 0
    *FOR each number in primes array:
    *   IF number is prime:
    *       count++
    *PRINT "c) " + count + " prime numbers in [2," + number + ")"*/
    static void Q_C(int number) {
        int count = 0;                                                              //Set count to 0
        for (boolean prime : primes) {                                              //Run through numbers up to number
            if (prime) {                                                            //If it's a prime number
                count++;                                                            //count++
            }
        }
        System.out.println("c) " + count + " prime numbers in [2," + number + ")"); //Print the count
    }

    /*In this function we will display the prime decomposition of the input number:
    *Pseudocode for Q_D:
    *empty list<int> decom
    *i = 2 and result = number
    *WHILE result > 1:
    *   IF i is a prime number:
    *       WHILE result is divisible by i:
    *           Add i to decom
    *           Divide result by i
    *   i++
    *PRINT "d) " + number + " = " + decom[0]
    *FOR j FROM 1 TO size of decom - 1:
    *   PRINT " * " + decom[j]
    *PRINT a newline*/
    static void Q_D(int number) {
        ArrayList<Integer> decom = new ArrayList<>();                       //Set decom list of Integer
        int i = 2, result = number;                                         //Set i = 2 and result to the original input number so we can modify it
        while (result > 1) {                                                //Continue until result is 1
            if (isPrime(i)) {                                               //if i is prime
                while (result % i == 0) {                                   //while result is divisible by i
                    decom.add(i);                                           //add i to our ArrayList
                    result /= i;                                            //modify our result
                }
            }
            i++;                                                            //Increment i
        }
        System.out.print("d) " + number + " = " + decom.get(0));            //Print beginning of decomposition
        for (int j = 1; j < decom.size(); j++) {                            //keep printing our list from the second element
            System.out.print(" * " + decom.get(j));                         //print with "*" between numbers
        }
        System.out.println();                                               //Add extra line for space
    }

    /*This function will calculate the multiplication of an integer list
    *Pseudocode for mult:
    *sum = 1
    *FOR each i in the list numbers:
    *   sum *= i
    *RETURN sum*/
    static int mult(ArrayList<Integer> numbers) {
        int sum = 1;                                                        //set sum to 1
        for (int i : numbers) {                                             //multiply 1 by every cell in the list
            sum *= i;
        }
        return sum;                                                         //return sum
    }

    /*This function returns an array of T for prime numbers and F for non-prime numbers all the way to num-1
    *Pseudocode for getPrimes:
    *int[] primes [num]
    *FOR i FROM 2 TO num - 1:
    *   IF i is a prime number:
    *       Set primes[i] to true
    *RETURN primes*/
    static boolean[] getPrimes(int num) {
        boolean[] primes = new boolean[num];
        for (int i = 2; i < num; i++) {
            if (isPrime(i)) {
                primes[i] = true;
            }
        }
        return primes;
    }

    /*This function will check if a number is prime
    *Pseudocode for isPrime:
    *FOR i FROM 2 TO square root of number:
    *   IF number is divisible by i:
    *       RETURN false
    *RETURN true*/
    static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {                      //for loop from 2 to number-1 (all numbers prime numebrs aren't divisible)
            if (number % i == 0) {                                          //if input number is divisible by i
                return false;                                               //number is not a prime number
            }
        }
        return true;                                                        //if reached here so number is prime
    }
}