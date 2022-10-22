import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String [] arrayLine = str.split(" ");
        if (arrayLine.length > 3) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                return;
            }

        }// Обработка длинны
        System.out.println(calculate(str));
    }
    public static String calculate(String str){
        MapNumeric map = new MapNumeric();
        String[] arrayLine = str.split(" ");
        String necessaryAnswer = "";
        String operand = arrayLine[1];
        if (map.trueOrFalseArabNum(arrayLine[0],arrayLine[2])){
            int a = Integer.parseInt(MapNumeric.romanToArabic(arrayLine[0]));
            int b = Integer.parseInt(MapNumeric.romanToArabic(arrayLine[2]));
            switch (operand){
                case "+": necessaryAnswer = String.valueOf(a+b);break;
                case "-": necessaryAnswer = String.valueOf(a-b); break;
                case "*": necessaryAnswer = String.valueOf(a*b); break;
                case "/": necessaryAnswer = String.valueOf(a/b); break;
                default: try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *) твой операнд \n↓ ");
                    return necessaryAnswer;}
            }
            if (map.trueOrFalseTwoNumberInOneSystem(arrayLine[0],arrayLine[2])){
                if (Integer.parseInt(necessaryAnswer)>=1){
                    necessaryAnswer = MapNumeric.transferToRome(necessaryAnswer);
                }else {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("в римской системе нет отрицательных чисел и используются целочисленные значения");
                        return necessaryAnswer = "";
                    }
                }
            }
        }else {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Используются одновременно разные системы счисления");
                return necessaryAnswer;}
        }

    return necessaryAnswer;}
}
