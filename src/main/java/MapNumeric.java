import java.io.IOException;
import java.util.*;

public class MapNumeric {
    static private HashMap<String, String> mapRomeNumeric = new HashMap<>();
    static HashMap<String, String> mapArabNumeric = new HashMap<>();

    public MapNumeric() {
        mapRomeNumeric.put("I", "1");
        mapRomeNumeric.put("II", "2");
        mapRomeNumeric.put("III", "3");
        mapRomeNumeric.put("IV", "4");
        mapRomeNumeric.put("V", "5");
        mapRomeNumeric.put("VI", "6");
        mapRomeNumeric.put("VII", "7");
        mapRomeNumeric.put("VIII", "8");
        mapRomeNumeric.put("IX", "9");
        mapRomeNumeric.put("X", "10");
        mapArabNumeric.put("1", "I");
        mapArabNumeric.put("2", "II");
        mapArabNumeric.put("3", "III");
        mapArabNumeric.put("4", "IV");
        mapArabNumeric.put("5", "V");
        mapArabNumeric.put("6", "VI");
        mapArabNumeric.put("7", "VII");
        mapArabNumeric.put("8", "VIII");
        mapArabNumeric.put("9", "IX");
        mapArabNumeric.put("10", "X");
        mapArabNumeric.put("20", "XX");
        mapArabNumeric.put("30", "XXX");
        mapArabNumeric.put("40", "XL");
        mapArabNumeric.put("50", "L");
        mapArabNumeric.put("60", "LX");
        mapArabNumeric.put("70", "LXX");
        mapArabNumeric.put("80", "LXXX");
        mapArabNumeric.put("90", "XC");
        mapArabNumeric.put("100", "C");
    }

    public static String arabicToRoman(String str) {
        Set<String> keys = mapArabNumeric.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String it = iter.next();
            if (str.equalsIgnoreCase(it)) {
                str = mapArabNumeric.get(it);
                break;
            }
        }
        return str;
    } // Работает если создать обект этого класса в мейне, превращает из 10->X

    public static String romanToArabic(String str) {
        Set<String> keys = mapRomeNumeric.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String it = iter.next();
            if (str.equalsIgnoreCase(it)) {
                str = mapRomeNumeric.get(it);
                break;
            }
        }
        return str;
    }// Работает если создать обект этого класса в мейне, превращает из X->10

    public boolean trueOrFalseArabNum(String str1, String str2) {
        boolean isTrue = false;
        Set<String> keyMap = mapRomeNumeric.keySet();
        List<String> valuesMap = new ArrayList<>(mapRomeNumeric.values());
        if (keyMap.contains(str1) && keyMap.contains(str2)) {
            isTrue = true;
        } else if (valuesMap.contains(str1) && valuesMap.contains(str2)) {
            isTrue = true;
        }
        return isTrue;
    } // проверка двоих чиселе на одну ринадлежность к одной системе исчисления
    public boolean trueOrFalseTwoNumberInOneSystem (String str1,String str2){
        boolean isTrue = false;
        Set<String> keyMap = mapRomeNumeric.keySet();
        if (keyMap.contains(str1)&& keyMap.contains(str2)){
            isTrue = true;
        }
    return isTrue;} //Нужен для того что-бы понять в какую систему счисления переводить проверка проводится на римских если возвращает false то методы для арбских символов

    public boolean noMoreTENRome(String str) {
        boolean isTrue = false;
        Set<String> keysMap = mapRomeNumeric.keySet();
        if (keysMap.contains(str)) {
            isTrue = true;
        }
        return isTrue;
    } // Проверяет римские

    public boolean noMoreTENArab(String str) {
        boolean isTrue = false;
        List<String> valuesMap = new ArrayList<>(mapRomeNumeric.values());
        if (valuesMap.contains(str)) {
            isTrue = true;
        }
        return isTrue;
    } // Проверяет арабские

    public static String transferToRome(String str) {

        int sum = Integer.parseInt(str);
        int postsum = sum % 10;
        int necSum = sum - postsum;
        if (necSum==0){
            str = arabicToRoman(String.valueOf(postsum));
        }else {
            str = arabicToRoman(String.valueOf(necSum)).concat(arabicToRoman(String.valueOf(postsum)));
        }

        return str;
    } // переводит число 78 -> LXXVIII
}
