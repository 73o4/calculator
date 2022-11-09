import java.util.Scanner;
import java.util.Stack;


public class Start {
    public static void main(String[] args) {

        Scanner name;
        String customizerEnter = "";

        Stack<Character> partsOfFirstNumber = new Stack<Character>();
        Stack<Character> partsOfSecondNumber = new Stack<Character>();

        Sum sum;
        Difference difference;
        Division division;
        Multiplication multiplication;



        int sizeOfArray = 0;
        int firstNumber, secondNumber;
        int sign, result = 0;

        while (true) {
            name = new Scanner(System.in);
            customizerEnter = name.nextLine();

            if (customizerEnter.equals("stop"))
                break;

            sizeOfArray = customizerEnter.length();

            if (sizeOfArray < 3) {
                System.out.println("You made mistake. You have to change chars.");
                continue;
            }

            char[] arrayFromCustomizer = new char[sizeOfArray];
            customizerEnter.getChars(0, sizeOfArray, arrayFromCustomizer, 0);


            //если пользователь ввел билеберду
            if (!isItNumbers(arrayFromCustomizer, sizeOfArray)) {
                System.out.println("Next!");
                continue;
            } else if (!сheckIsThisSymbolThere1(arrayFromCustomizer, sizeOfArray)) {
                System.out.println("You forgot something.");
                continue;
            }


            //получили два числа в виде кучи
            partsOfFirstNumber.clear();
            partsOfSecondNumber.clear();

            for (int t = 0; t < sizeOfArray; t++) {
                if (Character.isDigit(arrayFromCustomizer[t])) {
                    if (!сheckIsThisSymbolThere1(arrayFromCustomizer, t + 1))
                        partsOfFirstNumber.push(arrayFromCustomizer[t]);
                    else if (сheckHowManyThisSymbolThere(arrayFromCustomizer, t) == 1)
                        partsOfSecondNumber.push(arrayFromCustomizer[t]);
                }
            }

            firstNumber = 0;
            secondNumber = 0;

            for (int t = 0; !partsOfFirstNumber.empty(); t++) {
                firstNumber += (int) (toNumber(partsOfFirstNumber.pop()) * Math.pow(10, t));
            }
            for (int t = 0; !partsOfSecondNumber.empty(); t++) {
                secondNumber += (int) (toNumber(partsOfSecondNumber.pop()) * Math.pow(10, t));
            }
            /*for (char element : arrayFromCustomizer) {
                    switch (element) {
                        case '-':
                            Difference difference = new Difference(firstNumber, secondNumber);
                            //difference.resultOfDifference();
                            result = difference.resultOfDifferenceInt();
                            break;
                        case '+':
                            Sum sum = new Sum(firstNumber, secondNumber);
                            //sum.resultOfSum();
                            result = sum.resultOfSumInt();
                            break;
                        case '*':
                            Multiplication multiplication = new Multiplication(firstNumber, secondNumber);
                            //multiplication.resultOfMultiplication();
                            result = multiplication.resultOfMultiplicationInt();
                            break;
                        case '/':
                            Division division = new Division(firstNumber, secondNumber);
                            //division.resultOfDivision();
                            result = (int) division.resultOfDivisionDouble();
                            break;
                    }
                }*/
            for (char element : arrayFromCustomizer) {
                if (element == '+') {
                    sum = new Sum(firstNumber, secondNumber);
                    //sum.resultOfSum();
                    result = sum.resultOfSumInt();
                    break;
                }
                else if (element == '-') {
                    difference = new Difference(firstNumber, secondNumber);
                    //difference.resultOfDifference();
                    result = difference.resultOfDifferenceInt();
                    break;
                }
                else if (element == '/') {
                    division = new Division(firstNumber, secondNumber);
                    //division.resultOfDivision();
                    result = (int) division.resultOfDivisionDouble();
                    break;
                }
                else if (element == '*') {
                    multiplication = new Multiplication(firstNumber, secondNumber);
                    //multiplication.resultOfMultiplication();
                    result = multiplication.resultOfMultiplicationInt();
                    break;
                }
            }

            //часть кода, отвечающая за несколько знаков
            sign = сheckHowManyThisSymbolThere(arrayFromCustomizer, arrayFromCustomizer.length);
            sign--;


            while (sign!=0) {
                int size = 0;
                int amountOfSymbols = 0;
                //убираем из массива все до второго знака
                while(amountOfSymbols != 2) { //лажа
                    if (arrayFromCustomizer[size+1] == '+')
                        amountOfSymbols++;
                    size++;
                    arrayFromCustomizer[size-1] = ' '  ;
                    }


                partsOfSecondNumber.clear();
                for (int t = size; сheckHowManyThisSymbolThere(arrayFromCustomizer, t) == 1; t++) {//и тут лажа
                    if (Character.isDigit(arrayFromCustomizer[t])) {
                        partsOfSecondNumber.push(arrayFromCustomizer[t]);
                    }
                }

                firstNumber = result;
                secondNumber = 0;

                for (int t = 0; !partsOfSecondNumber.empty(); t++) {
                    secondNumber += (int) (toNumber(partsOfSecondNumber.pop()) * Math.pow(10, t));
                }
                System.out.println(result + " " + secondNumber);
                for (int t = size; t < arrayFromCustomizer.length; t++) {
                    if (arrayFromCustomizer[t] == '+') {
                        sum = new Sum(firstNumber, secondNumber);
                        //sum.resultOfSum();
                        result = sum.resultOfSumInt();
                        break;
                    }
                    else if (arrayFromCustomizer[t] == '-') {
                        difference = new Difference(firstNumber, secondNumber);
                        //difference.resultOfDifference();
                        result = difference.resultOfDifferenceInt();
                        break;
                    }
                    else if (arrayFromCustomizer[t] == '/') {
                        division = new Division(firstNumber, secondNumber);
                        //division.resultOfDivision();
                        result = (int) division.resultOfDivisionDouble();
                        break;
                    }
                    else if (arrayFromCustomizer[t] == '*') {
                        multiplication = new Multiplication(firstNumber, secondNumber);
                        //multiplication.resultOfMultiplication();
                        result = multiplication.resultOfMultiplicationInt();
                        break;
                    }
                }
                sign--;
            }
            System.out.println(result);
        }
    }

    static public boolean isItNumbers (char[] arrayFromCustomizer, int size) {

        boolean allowChars = false;
        int amountOfGoodSymbols = 0;

        for (int i = 0; i < size ; i++) {
            switch (arrayFromCustomizer[i]) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                case '+':
                case '-':
                case '*':
                case '/':
                case ' ':
                    amountOfGoodSymbols++;
                    break;

                default:
                    return false;
            }
        }

        if (amountOfGoodSymbols == size) {allowChars = true;}

        return allowChars;
    }
    public static boolean сheckIsThisSymbolThere(char[] number, int size) {
        boolean isThisSymbolThere = false;
        char [] opers = {'+', '-', '/', '*', ' '};

        for (int t = 0; t<size; t++) {
            for (int i = 0; i< opers.length; i++) {
                if (number[t] == opers[i]) {
                    return true;
                }
            }
        }
        return isThisSymbolThere;
    }
    public static boolean сheckIsThisSymbolThere1(char[] number, int size) {
        boolean isThisSymbolThere = false;
        char [] opers = {'+', '-', '/', '*'};

        for (int t = 0; t<size; t++) {
            for (int i = 0; i< opers.length; i++) {
                if (number[t] == opers[i]) {
                    return true;
                }
            }
        }
        return isThisSymbolThere;
    }
    public static int сheckHowManyThisSymbolThere(char[] number, int size) {
        int isThisSymbolThere = 0;
        char [] opers = {'+', '-', '/', '*'};

        for (int t = 0; t < size; t++) {
            for (int i = 0; i < opers.length; i++) {
                if (number[t] == opers[i]) {
                    isThisSymbolThere++;
                }
            }
        }
        return isThisSymbolThere;
    }
    public static int toNumber(char element) {
        switch (element) {
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case '0':
                return 0;
        }
        return 0;
    }


}
