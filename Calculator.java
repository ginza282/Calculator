package Calculator.Calculator;

import Calculator.Calculator.ActionService;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Input: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Что-то пошло не так, попробуйте еще раз");

                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        scanner.close();
    }

    private static void startCalc() {
        System.out.println("Добро пожаловать в Калькулятор, он работает только с арабскими и римскими цифрами от 1 до 10.");
        System.out.println("Выполняет следующие операции с двумя числами:");
        System.out.println("Сложение(a + b), Вычитание(a - b), Умножение(a * b), Деление(a / b)");
        System.out.println("Если Вы хотите покинуть программу, введите 'exit'");
    }

    private static void exitCalc() {

        System.out.println("До скорых встреч!");

    }
}
