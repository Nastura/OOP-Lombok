package ru.netology;
/* current radio station number - номер текущей радиостанции
   sound volume - громкость звука.
   get the current radio station number; */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    private int sizeRadioStation = 10;
    // размер радиостанций
    private int maxRadioStation = 9;
    private int minRadioStation = 0;
    private int currentRadioStationNumber = minRadioStation;
    private int soundVolume;

    public Radio(int sizeRadioStation) {
        if (sizeRadioStation < 0) {
            sizeRadioStation = this.sizeRadioStation;
        }
        this.sizeRadioStation = minRadioStation + sizeRadioStation;
        this.maxRadioStation = this.sizeRadioStation - 1;
    }

    public void setCurrentRadioStationNumber(int newcurrentRadioStationNumber) {
        if ((newcurrentRadioStationNumber > this.maxRadioStation) | (newcurrentRadioStationNumber < this.minRadioStation)) {
            currentRadioStationNumber = 0;
            return;
        }
        currentRadioStationNumber = newcurrentRadioStationNumber;
    }

    public void setSoundVolume(int newSoundVolume) {
        if (newSoundVolume >= 100) {
            soundVolume = 100;
            return;
        }
        if (newSoundVolume <= 0) {
            soundVolume = 0;
            return;
        }
        soundVolume = newSoundVolume;

    }

    public void nextRadiostation() {
        int target = currentRadioStationNumber + 1;
        if (target > maxRadioStation) {
            target = minRadioStation;
        }
        setCurrentRadioStationNumber(target);
    }

    public void prevRadiostation() {
        int target = currentRadioStationNumber - 1;
        if (target < minRadioStation) {
            target = maxRadioStation;
        }
        setCurrentRadioStationNumber(target);
    }

    public void nextVolume() {
        int target = soundVolume + 1;
        setSoundVolume(target);
    }

    public void prevVolume() {
        int target = soundVolume - 1;
        setSoundVolume(target);
    }
}


