public class ZweiteAufgabe {
    /* Beim Gesellschaftsspiel "Die Böse Sieben" sitzen die Teilnehmer im Kreis und zählen reihum.
    Jede Zahl, welche durch 7 teilbar ist oder die 7 als Ziffer enthält, muss übersprungen werden.
    Schreibe ein Programm, welches für eine beliebige Zahl angibt, ob die nächste übersprungen werden muss oder nicht. */
    public static boolean seibenEnthaelt (int zahl) {
        boolean ueberspringen = false;
        while (zahl > 16) {
            if (zahl%10 == 7) {
                ueberspringen = true;
            }
            zahl /= 10;
        }
        return ueberspringen;
    }
    public static void boeseSieben (int zahl) {
        zahl += 1;
        if (zahl%7 == 0 || seibenEnthaelt(zahl)) {
            System.out.println("Die nächste Zahl muss übersprungen werden!");
        } else {
            System.out.println("Die nächste Zahl muss NICHT übersprungen werden!");
        }
    }

    public static void main (String[] args) {
        boeseSieben(1692);


    }

}
