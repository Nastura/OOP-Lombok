package ru.netology;

/* current radio station number - номер текущей радиостанции
   sound volume - громкость звука.
   get the current radio station number;
 */
public class Radio {
    private int currentRadioStationNumber;
    private int soundVolume;

    public void setCurrentRadioStationNumber(int newcurrentRadioStationNumber) {
        if ((newcurrentRadioStationNumber > 9) | (newcurrentRadioStationNumber < 0)) {
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
        if (target >= 10) {
            target = 0;
        }
        setCurrentRadioStationNumber(target);
    }

    public void prevRadiostation() {
        int target = currentRadioStationNumber - 1;
        if (target < 0) {
            target = 9;
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

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

}
