public class Dzialanie {
    String dzialanie;
    int wynik;

    Dzialanie() {
        dzialanie = "";
        wynik = 0;

        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            int c = (int) (Math.random() * 4);
            if (c == 0) {

                dzialanie = a + "+" + b;
                wynik = a + b;
            } else if (c == 1) {
                dzialanie = a + "-" + b;
                wynik = a - b;
            } else if (c == 2) {
                a = (int)(Math.random() * 10);
                b = (int)(Math.random() * 10);
                dzialanie = a + "*" + b;
                wynik = a * b;
            } else if (c == 3) {
                a = (int)(Math.random() * 100);
                b = (int)(Math.random() * 10);
                if (a%b != 0 ){
                    do {
                        b = (int) (Math.random() * 10);
                    } while (a%b != 0);
                }
                dzialanie = a + "/" + b;
                wynik = a / b;
            }
        }
    }
}
