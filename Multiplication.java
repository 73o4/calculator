public class Multiplication {
    private int firstNumber, secondNumber;

    public Multiplication (int firstNumber, int secondNumber) {
        this.secondNumber = secondNumber;
        this.firstNumber = firstNumber;
    }

    public void resultOfMultiplication () {
        System.out.println( firstNumber * secondNumber);
    }

    public int resultOfMultiplicationInt () {
        return firstNumber * secondNumber;
    }
}