public class Sum {
    private int firstNumber, secondNumber;

    public Sum (int firstNumber, int secondNumber) {
        this.secondNumber = secondNumber;
        this.firstNumber = firstNumber;
    }

    public void resultOfSum () {
        System.out.println( firstNumber + secondNumber);
    }
    public int resultOfSumInt () { return firstNumber + secondNumber;}

}


