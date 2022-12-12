package org.campus02.rec;

public class DemoMapsApp {

    public static void main(String[] args) {

        Ort graz = new Ort("Graz"); // STRG+D
        Ort wien = new Ort("Wien");
        Ort marburg = new Ort("Marburg");
        Ort linz = new Ort("Linz");

        graz.addNachbar(marburg);
        graz.addNachbar(wien);
        wien.addNachbar(linz);
        linz.addNachbar(graz);
        marburg.addNachbar(graz);
        wien.addNachbar(graz);
        linz.addNachbar(wien);

        System.out.println("hasCircle(graz) = " + hasCircle(graz));

        System.out.println("graz.countHops(graz, linz) = " + graz.countHops(graz, linz));
        System.out.println("graz.countHops(graz, marburg) = " + graz.countHops(graz, marburg));
        System.out.println("graz.countHops(wien, marburg) = " + wien.countHops(wien, marburg));
    }

    public static boolean hasCircle(Ort o) {
        return hasCircle(o, o, null);
    }

    public static boolean hasCircle(Ort start, Ort current, Ort previous) {

        for (Ort n : current.getNachbarn()) {
            if (n == previous) {
                return false;
            }

            if (n == start) {
                // Ich bin hier wieder am Startknoten
                return true;
            }
            else {
                /*boolean result = hasCircle(start, n, current);
                if (result)
                    return true;
                */
                if (hasCircle(start, n, current))
                    return true;
            }
        }
        return false;
    }
}
