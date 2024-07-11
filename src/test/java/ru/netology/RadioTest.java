package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.Main;
import ru.netology.Radio;


public class RadioTest {
    // Тест 1. Получить максимальную радиостанцию
    @Test
    public void getMaximumRadioStation() {
        Radio test = new Radio(50);
        test.setCurrentRadioStationNumber(25);
        Assertions.assertEquals(49, test.getMaxRadioStation());
    }
    // Тест 2. Получить минимальную радиостанцию
    @Test
    public void getMinimumRadioStation() {
        Radio test = new Radio(-6);
        Assertions.assertEquals(0, test.getMinRadioStation());
    }
    // Тест 3. Получить размер станции
    @Test
    public void getSizeRadioStation() {
        Radio test = new Radio(2);
        Assertions.assertEquals(2, test.getSizeRadioStation());
    }

    // Тест 4. Установить любой номер радиостанции
    @Test
    public void setTheRadioStationNumber() {
        Radio service = new Radio(50);
        service.setCurrentRadioStationNumber(5);
        Assertions.assertEquals(5, service.getCurrentRadioStationNumber());
    }

    // Тест 5. Установить номер радиостанции выше лимита
    @Test
    public void setTheRadioStationNumberAboveTheLimit() {
        Radio service = new Radio();
        service.setCurrentRadioStationNumber(10);
        Assertions.assertEquals(0, service.getCurrentRadioStationNumber());
    }

    // Тест 6. Увеличить радиостанцию с 8 / на следующую.
    // Тест 7. Увеличить радиостанцию с 9 на следующую.
    // Тест 8. Увеличить радиостанцию с 0 на следующую.
    @ParameterizedTest
    @CsvSource({
            "8, 9",
            "9, 0",
            "0, 1"
    })
    public void increaseRadioStationFrom8(int stantion, int expected) {
        Radio service = new Radio();
        service.setCurrentRadioStationNumber(stantion);
        service.nextRadiostation(); // Вызываем тестируемый метод
        int actual = service.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    // Тест 9. Уменьшить номер радиостанции с 1;
    // Тест 10. Уменьшить номер радиостанции с 0;
    // Тест 11. Уменьшить номер радиостанции с -1;
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "0, 9",
            "-1, 9"
    })
    public void decreaseRadioStationFrom1(int setStation, int expected) {
        Radio service = new Radio();
        service.setCurrentRadioStationNumber(setStation);
        service.prevRadiostation(); // Вызываем тестируемый метод
        int actual = service.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    // Тест 12. Увеличить звук с 99
    // Тест 13. Увеличить звук со 100
    // Тест 14. Увеличить звук со 101
    @ParameterizedTest
    @CsvSource({
            "99, 100",
            "100, 100",
            "101, 100"
    })

    public void nextVolume99(int setVolume, int expected) {
        Radio servise = new Radio();
        servise.setSoundVolume(setVolume);
        servise.nextVolume();
        Assertions.assertEquals(expected, servise.getSoundVolume());
    }

    // Тест 15. Уменьшить звук с 1
    // Тест 16. Уменьшить звук с 0
    // Тест 17. Уменьшить звук с -1
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "0, 0",
            "-1, 0"
    })
    public void prevVolume1(int setVolume, int expected) {
        Radio servise = new Radio();
        servise.setSoundVolume(setVolume);
        servise.prevVolume();
        Assertions.assertEquals(expected, servise.getSoundVolume());
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>  Класс Main  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    // Тест 1.
    // Передаю Текст (параметр).В main сравниваю строки и преобразую текст в
    // целочисленный тип и возвращаю число.
    @Test
    public void stringToNumber() {
        Main service = new Main();
        int expected = 8;
        int actual = service.test("8");
        Assertions.assertEquals(expected, actual);
    }
    // Тест 2
    @Test
    public void stringToNumberEqual() {
        Main service = new Main();
        int expected = 9;
        int actual = service.test("9");
        Assertions.assertEquals(expected, actual);
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


}
