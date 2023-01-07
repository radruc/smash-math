import java.util.Random;

import static java.lang.Math.random;

public class Dzialanie {
    String dzialanie;
    int wynik;
    Dzialanie() {
        Random rnd = new Random(Gra.start);
        int a = rnd.nextInt(1,50);
        int b = rnd.nextInt(1,50);
        int c = rnd.nextInt(4);
        if (c == 0) {
         dzialanie = a + "+" + b;
         wynik = a + b;
        } else if (c == 1) {
            if(a>b) {
                dzialanie = a + "-" + b;
                wynik = a - b;
            } else {
                dzialanie = b + "-" + a;
                wynik = b - a;
            }
        } else if (c == 2) {
                a = rnd.nextInt(2,10);
                b = rnd.nextInt(2,10);
                dzialanie = a + "*" + b;
                wynik = a * b;
        } else {
            a = rnd.nextInt(2,10);
            b = rnd.nextInt(2,10);
            wynik = (a * b)/b;
            a = a * b;
            dzialanie = a + "/" + b;
            }
        }
    }

