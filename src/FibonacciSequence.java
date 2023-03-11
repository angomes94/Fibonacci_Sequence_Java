import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class FibonacciSequence {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the minimum value for the random number generator: ");
        int minimum = scanner.nextInt();
        
        System.out.print("Enter the maximum value for the random number generator: ");
        int maximum = scanner.nextInt();
        int maximumValueForSequence = generateRandomNumber(minimum, maximum);
        int[] fibonacciSequence = generateFibonacciSequence(maximumValueForSequence);
        int oddNumbersCount = countOddNumbers(fibonacciSequence);
        
        System.out.println("The maximum random value generated is " + maximumValueForSequence + ".");
        System.out.println("The Fibonacci sequence up to " + maximumValueForSequence + " is " + Arrays.toString(fibonacciSequence) + ".");
        System.out.println("There are " + oddNumbersCount + " odd numbers in the Fibonacci sequence.");
        
        scanner.close();
    }
    
    public static int generateRandomNumber(int minimum, int maximum) {
        Random random = new Random();
        int range = maximum - minimum + 1;
        return random.nextInt(range) + minimum;
    }
    
    public static int[] generateFibonacciSequence(int maximum) {
        int[] sequence = {0, 1};
        while (sequence[sequence.length - 1] < maximum) {
            int nextNumber = sequence[sequence.length - 1] + sequence[sequence.length - 2];
            int[] newSequence = new int[sequence.length + 1];
            for (int i = 0; i < sequence.length; i++) {
                newSequence[i] = sequence[i];
            }
            newSequence[sequence.length] = nextNumber;
            sequence = newSequence;
        }
        return Arrays.copyOf(sequence, sequence.length - 1);
    }
    
    public static int countOddNumbers(int[] sequence) {
        int count = 0;
        for (int number : sequence) {
            if (number % 2 != 0) {
                count++;
            }
        }
        return count;
    }
    
}
