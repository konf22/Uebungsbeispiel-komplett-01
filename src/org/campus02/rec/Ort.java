package org.campus02.rec;

import java.util.ArrayList;

public class Ort {
    private String name;
    private ArrayList<Ort> nachbarn;// = new ArrayList<>();

    // ALT+Einfg
    public Ort(String name) {
        this.name = name;
        nachbarn = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Ort{" +
                "name='" + name + '\''+    '}';
    }

    /*
    FEHLER, da ArrayList hier übernommen wird
    public Ort(String name, ArrayList<Ort> nachbarn) {
        this.name = name;
        this.nachbarn = nachbarn;
    }*/

    public void addNachbar(Ort o) {
        nachbarn.add(o);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ort> getNachbarn() {
        return nachbarn;
    }

    public int countHops(Ort start, Ort goal) {
        ArrayList <Ort> hops = new ArrayList<>(); // Arraylist dient zum Speichern des Wegs
        return countHops(start, goal, hops);
    }

    private int countHops(Ort start, Ort goal, ArrayList<Ort> hops) {
        if (hops.contains(this))
        {
            // Eigener Knoten bereits in Liste, somit Abbruch
            return -1;
        }
        hops.add(this); // sich selbst in den Weg als Hop aufnehmen

        for (Ort n : getNachbarn()) {
            if (n == goal) {
                // Ziel wurde gefunden, der Weg steht nun in der Liste
                return hops.size();
            }

            int count = n.countHops(start, goal, hops);
            if (count > 0)
                return count;
        }
        hops.remove(this); // sich selbst wieder aus dem Weg herausnehmen
        return -1;
    }


}
