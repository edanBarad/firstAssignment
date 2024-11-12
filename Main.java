import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();            //Start timer (to print in the end run time)
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();                         //Read input number
        Q_A(number);                                            //Call Q_A with the input number
        Q_B(number);                                            //Call Q_B with the input number
        Q_C(number);                                            //Call Q_C with the input number
        Q_D(number);                                            //Call Q_D with the input number
        long endTime = System.currentTimeMillis();              //Stop timer
        long runTime = endTime - startTime;                     //Calculate and final time
        System.out.println((runTime / 1000.0) + " seconds");    //Print run time in seconds
        scanner.close();                                        //End use of Scanner
        System.out.println("321482481");                        //Print I.D
    }
    //In this function we will find two prime numbers that sum to the input number:
    static void Q_A(int number){
        boolean pairFound = false;  //Set Boolean variable "pairFound" to false
        for (int i = 2; i <= number && !pairFound; i++) {   //Outer loop i from 2 to number (inclusive) and pairFound is false:
            for (int j = 2; j <= number; j++) {             //Inner loop j from 2 to number (inclusive):
                if (isPrime(i) && isPrime(j)) {             //If i and j are prime
                    if (i+j == number) {                    //The sum of i and j equals the input number:
                        System.out.println(number + " = " + i + " + " + j); //Print the pair (i + j = num)
                        pairFound = true;                                   //Set pairFound to true (to exit outer loop)
                        break;                                              //Break inner loop
                    }
                }
            }
        }
    }
    //In this function we will find two prime numbers such that one subtracted from the other equals the input number:
    static void Q_B(int number){
        boolean pairFound = false;  //Set Boolean variable pairFound to false
        int i = number + 1;         //Set counter i to first number bigger than our number
        do {
            for (int j = 2; j <= number; j++) { //For loop j from 2 to number (inclusive):
                if (isPrime(i) && isPrime(j)) { //If i and j are prime numbers
                    if (i-j == number) {        //And thier difference equal to the input number
                        System.out.println(number + " = " + i + " - " + j); //Print the pair
                        pairFound = true;                                   //Set pairFound to true (to exit outer loop)
                        break;                                              //Break inner loop
                    }
                }
            }
            i++;                //If pair not found increment i
        }while (!pairFound);    //While pairFound is false do that again
    }
    //Int this function we will count and print the number of prime numbers up to the input number:
    static void Q_C(int number){
        int count = 0;                      //Set count to 0
        for (int i = 2; i <= number; i++) { //For loop i from 2 to number (inclusive):
            if (isPrime(i)) {               //If i is a prime number
                count++;                    //increment count
            }
        }
        System.out.println(count + " prime numbers in [2," + number + ")"); //Print the count
    }
    //In this function we will display the prime decomposition of the input number:
    static void Q_D(int number){
        ArrayList<Integer> decom = new ArrayList<>();   //Set decom list of Integer
        int i = 2, result = number;                     //Set i = 2 and result to the original input number so we can modify it
        while (true) {                                  //While true:
            if (isPrime(i)) {                           //if i is prime
                if (result % i == 0) {                  //if result is divisible by i
                    decom.add(i);                       //add i to our ArrayList
                    result /= i;                        //modify our result
                }
                else{i++;}                              //Else increment i
        }
        if ((result%i != 0)&&result * mult(decom) == number){   //If we reached the lowest number to modify with division
            decom.add(result);                                  //add last result to the list
            break;}                                             //break the loop
        }
        System.out.print(number + " = " + decom.get(0));        //print beginning of decomposition
        i = 1;                                                  //start from second cell
        do{
            System.out.print(" * " + decom.get(i));             //continue printing decomposition
            i++;                                                //increment index counter
        }while (i < decom.size());                              //while index is still in range
        System.out.println();                                   //Add extra line for space
    }
    //This function will calculate the multiplication of an integer list
    static int mult(ArrayList<Integer> numbers){
        int sum = 1;                //set sum to 1
        for (int i: numbers){       //multiply 1 by every cell in the list
            sum *= i;
        }
        return sum;                 //return sum
    }
    //This function will check if a number is prime
    static boolean isPrime(int number) {
        for (int i = 2; i < number - 1; i++) {  //for loop from 2 to number-1 (all numbers prime numebrs aren't divisible)
            if (number % i == 0) {              //if input number is divisible by i
                return false;                   //number is not a prime number
            }
        }
        return true;                            //if reached here so number is prime
    }
}