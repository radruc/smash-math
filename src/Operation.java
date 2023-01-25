public class Operation {
    String operation;
    int result;

    Operation() {
        int a = Game.rnd.nextInt(1, 50);
        int b = Game.rnd.nextInt(1, 50);
        int c = Game.rnd.nextInt(4);
        if (c == 0) {
            operation = a + "+" + b;
            result = a + b;
        } else if (c == 1) {
            do {
                if (a > b) {
                    operation = a + "-" + b;
                    result = a - b;
                } else {
                    operation = b + "-" + a;
                    result = b - a;
                }
            } while (a == b);
        } else if (c == 2) {
            a = Game.rnd.nextInt(2, 10);
            b = Game.rnd.nextInt(2, 10);
            operation = a + "*" + b;
            result = a * b;
        } else {
            a = Game.rnd.nextInt(2, 10);
            b = Game.rnd.nextInt(2, 10);
            result = (a * b) / b;
            a = a * b;
            operation = a + "/" + b;
        }
    }//koniec konstruktora

    public String getOperation() {
        String operation = this.operation;
        return operation;
    }

    public int getResult() {
        return result;
    }

}//koniec klasy Operation

