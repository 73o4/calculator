public class Difference {

    private int firstNumber, secondNumber;

    public Difference (int firstNumber, int secondNumber) {
        this.secondNumber = secondNumber;
        this.firstNumber = firstNumber;
    }

    public void resultOfDifference () {
        System.out.println(firstNumber - secondNumber);
    }
    public int resultOfDifferenceInt () {
        return (firstNumber - secondNumber);
    }

}
