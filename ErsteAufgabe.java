public class ErsteAufgabe {

    // 1. Spalte die einzelnen Ziffern mittels Division und Modulo-Operation ab und addiere sie, um die Quersumme zu bestimmen.
    public static int qsBerechnen(int zahl) {
        int summe = 0;
        while (zahl != 0) {
            summe += zahl%10;
            zahl /= 10;
        }
        return summe;
    }


    // 2. Gib alle Zahlen von 0 - 1000 aus, welche die Quersumme 15 haben.
    public static void qsBerechnenInterval (int untergrenze, int obergrenze, int qs) {
        for (int i = untergrenze; i <= obergrenze; i++) {
            if (qsBerechnen(i) == qs) {
                System.out.print(i+" ");
            }
        }
        System.out.println(" ");
    }


    // 3. Gib alle Zahlen von 0 - 1000 aus, deren Quersumme ein Vielfaches von 7 ist.
    public static void qsBerechnenVielfach (int untergrenze, int obergrenze, int vf) {
        for (int i = untergrenze; i <= obergrenze; i++) {
            if (qsBerechnen(i) % vf == 0) {
                System.out.print(i+" ");
            }
        }
        System.out.println(" ");
    }


    /* 4. Welche Quersumme der Zahlen von 0 - 1000 kommt am häufigsten vor?
    (Tipp: Überlegt Euch, wie viel verschiedene Quersummen vorkommen können, erstellt ein Array dieser Größe und speichert dort die Anzahl der Vorkomnisse) */
    public static void haufigsteQs (int untergrenze, int obergrenze) {
        int maxQs = 0;
        for (int i = untergrenze; i <= obergrenze; i++) {
            if (qsBerechnen(i) > maxQs) {
                maxQs = qsBerechnen(i);
            }
        }

        int[] qsArr = new int[maxQs];
        int[] qsHaeufigkeitArr = new int[maxQs];
        for (int i = 0; i < qsArr.length; i++) {
            qsArr[i] = i+1;
            for (int j = untergrenze; j <= obergrenze; j++) {
                if (qsBerechnen(j) == qsArr[i]) {
                    qsHaeufigkeitArr[i]++;
                }
            }
        }

        int qsMAX = qsHaeufigkeitArr[0];
        for (int i = 0; i < qsHaeufigkeitArr.length; i++) {
            if (qsHaeufigkeitArr[i] > qsMAX) {
                qsMAX = qsHaeufigkeitArr[i];
            }
        }
        System.out.println(qsMAX);
    }

    /* 5. Die iterierte Quersumme wird auch Ziffernwurzel genannt (Abk. zw) Beispiel:
            47 --> 4 + 7 = 11 --> 1 + 1 = 2, also zw(47)=2
    Schreibt ein Programm, welches die Ziffernwurzel für eine beliebige Zahl bestimmt.*/
    public static void zifferwurzel (int zahl) {
        int qs = qsBerechnen(zahl);
        if (qs%10 != 0) {
            qs = qsBerechnen(qs);
        }
        System.out.println(qs);
    }

    /*** 6. Das Querprodukt ist wie folgt definiert: 68 = 6 * 8 = 48. Es gibt Zahlen, bei denen die Summe aus Quersumme und
    Querprodukt wieder die Zahl selbst ergibt Beispiel: 79 = 7 + 9 + 7*9 = 79.
    Gibt es weitere Zahlen zwischen 0 und 1000 mit dieser Eigenschaft? Wenn ja, welche? */
    public static int qpBerechnen(int zahl) { // Querproduktrechner
        int produkt = 1;
        while (zahl != 0) {
            produkt *= zahl%10;
            zahl /= 10;
        }
        return produkt;
    }

    public static void teufelskreis (int untergrenze, int obergrenze) {
        for (int i = untergrenze; i < obergrenze; i++) {
            int summe = qsBerechnen(i) + qpBerechnen(i);
            if (summe == i) {
                System.out.print(i+" ");
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(qsBerechnen(125));
        qsBerechnenInterval(0, 1000, 15);
        qsBerechnenVielfach(0, 1000, 7);
        haufigsteQs(0, 1000);
        zifferwurzel(47);
        System.out.println(qpBerechnen(68));
        teufelskreis(0, 1000);

    }
}
