package ru.netology;
// Передаю Текст (параметр).
// В Мэйн сравниваю строки и преобразую текст в целочисленный тип и возвращаю число.

public class Main {
    public int test(String number) {
        String typeString = "9";

        if (number.equals(typeString)) {
            int notEqual = Integer.parseInt(typeString);
            return notEqual;
        }
        int equal = Integer.parseInt(number);
        return equal;
    }
}
