package controller;

import model.Time;

import java.util.Comparator;

class ControllerComparadorDeTimes implements Comparator<Time> {

    public int compare(Time time1, Time time2) {
        if (time1.getPontoCampeonato() < time2.getPontoCampeonato()) return -1;
        else if (time1.getPontoCampeonato() > time2.getPontoCampeonato()) return +1;
        else return 0;
    }
}