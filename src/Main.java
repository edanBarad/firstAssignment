import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Q_A(number);
        Q_B(number);
        Q_C(number);
        Q_D(number);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println((elapsedTime / 1000.0) + " seconds");
        scanner.close();
        System.out.println("321482481");
    }

    static void Q_A(int number){
        boolean pairFound = false;
        for (int i = 2; i <= number && !pairFound; i++) {
            for (int j = 2; j <= number; j++) {
                if (isPrime(i) && isPrime(j)) {
                    if (i+j == number) {
                        System.out.println(number + " = " + i + " + " + j);
                        pairFound = true;
                        break;
                    }
                }
            }
        }
    }

    static void Q_B(int number){
        boolean pairFound = false;
        int i = number + 1;
        do {
            for (int j = 2; j <= number; j++) {
                if (isPrime(i) && isPrime(j)) {
                    if (i-j == number) {
                        System.out.println(number + " = " + i + " - " + j);
                        pairFound = true;
                        break;
                    }
                }
            }
            i++;
        }while (!pairFound);
    }

    static void Q_C(int number){
        int count = 0;
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println(count + " prime numbers in [2," + number + ")");
    }

    static void Q_D(int number){
        ArrayList<Integer> decom = new ArrayList<>();
        int i = 2, result = number;
        do {
            if (isPrime(i)) {
                if (result % i == 0) {
                    decom.add(i);
                    result /= i;
                }
                else{i++;}
        }
        if ((result%i != 0)&&result * mult(decom) == number){
            decom.add(result);
            break;}
        }while (true);
        System.out.print(number + " = " + decom.get(0));
        i = 1;
        do{
            System.out.print(" * " + decom.get(i));
            i++;
        }while (i < decom.size());
        System.out.println();   //Add extra line for space
    }

    static int mult(ArrayList<Integer> numbers){
        int sum = 1;
        for (int i: numbers){
            sum *= i;
        }
        return sum;
    }

    static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}