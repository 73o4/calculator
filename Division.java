public class Division {
    private int firstNumber, secondNumber;

    public Division (int firstNumber, int secondNumber) {
        this.secondNumber = secondNumber;
        this.firstNumber = firstNumber;
    }

    public void resultOfDivision () {
        System.out.println((double) firstNumber / secondNumber);
    }

    public double resultOfDivisionDouble () {
        return (double) firstNumber / secondNumber;
    }
}
