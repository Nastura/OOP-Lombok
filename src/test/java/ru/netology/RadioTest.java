package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.Main;
import ru.netology.Radio;


public class RadioTest {

    // Тест 1. Установить любой номер радиостанции
    @Test
    public void setTheRadioStationNumber() {
        Radio service = new Radio();
        service.setCurrentRadioStationNumber(5);
        int expected = 5;
        int actual = service.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    // Тест 2. Установить номер радиостанции выше лимита
    @Test
    public void setTheRadioStationNumberAboveTheLimit() {
        Radio service = new Radio();
        service.setCurrentRadioStationNumber(10);
        int expected = 0;
        int actual = service.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    // Тест 3. Увеличить радиостанцию с 8 / на следующую.
    // Тест 4. Увеличить радиостанцию с 9 на следующую.
    // Тест 5. Увеличить радиостанцию с 0 на следующую.
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

    // Тест 6. Уменьшить номер радиостанции с 1;
    // Тест 7. Уменьшить номер радиостанции с 0;
    // Тест 8. Уменьшить номер радиостанции с -1;
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

    // Тест 9. Увеличить звук с 99
    // Тест 10. Увеличить звук со 100
    // Тест 11. Увеличить звук со 101
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
        int actual = servise.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    // Тест 12. Уменьшить звук с 1
    // Тест 13. Уменьшить звук с 0
    // Тест 14. Уменьшить звук с -1
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
        int actual = servise.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }


    // Тест 15.  ---------------------MAIN покрытие .
    // Передаю Текст (параметр).
    // В Мэйн сравниваю строки и преобразую текст в целочисленный тип и возвращаю число.
    @Test
    public void stringToNumber() {
        Main service = new Main();
        int expected = 8;
        int actual = service.test("8");
        Assertions.assertEquals(expected, actual);
    }

    // Тест 16.  ---------------------MAIN покрытие .
    @Test
    public void stringToNumberEqual() {
        Main service = new Main();
        int expected = 9;
        int actual = service.test("9");
        Assertions.assertEquals(expected, actual);
    }

}
