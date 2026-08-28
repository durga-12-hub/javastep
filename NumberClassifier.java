public class NumberClassifier {

    public static void classifyNumber(int number) {
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {
        // Test cases from sample output
        classifyNumber(15);  // Output: Positive
        classifyNumber(-4);  // Output: Negative
        classifyNumber(0);   // Output: Zero
    }
}