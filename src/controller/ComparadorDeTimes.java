package controller;

import model.Time;

import java.util.Comparator;

class ComparadorDeTimes implements Comparator<Time> {

    public int compare(Time o1, Time o2) {
        if (o1.getPontoCampeonato() < o2.getPontoCampeonato()) return -1;
        else if (o1.getPontoCampeonato() > o2.getPontoCampeonato()) return +1;
        else return 0;
    }
}