package group;

public class FunctionApproximation {

    public static void main(String[] args) {
        double a = 0.1, b = 1.0, x, er1, er2, y1, y2, y3, eps = 0.00000001;
        int nsum = 10, k_dot; // кількість рядків у таблиці

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("\t\t\t    Обчислення функції y = cos x");
        System.out.print("Введіть кількість кроків: ");
        k_dot = scanner.nextInt();


        Tab pr = new Tab("     X    ", "    Y     ", "    Y1    ", "    Y2    ", "    er1   ", "    er2   ");

        double h; // крок по Х
        h = (b - a) / k_dot;

        // клас "розрахунок" методи ra1(x) ra2(x) ra3(x)
        Digit dig = new Digit(nsum, eps);
        for (x = a; x <= b; x = x + h) {
            y1 = dig.ra1(x);
            y2 = dig.ra2(x);
            y3 = dig.ra3(x);
            er1 = Math.abs((y1 - y2) / y1) * 100;
            er2 = Math.abs((y1 - y3) / y1) * 100;
            pr.print(x, y1, y2, y3, er1, er2);
        }
        pr.close();
    }
}

// Tab - клас для друку таблиці
class Tab {
    private String n1, n2, n3, n4, n5, n6;
    private String br0 = "+------------";
    String br;

    public Tab(String z1, String z2, String z3, String z4, String z5, String z6) {
        n1 = z1;
        n2 = z2;
        n3 = z3;
        n4 = z4;
        n5 = z5;
        n6 = z6;
        br = "";
        for (int i = 1; i <= 6; i++)
            br = br + br0;
        br = br + "+";
        System.out.println(br);
        System.out.print("| " + n1 + " ");
        System.out.print("| " + n2 + " ");
        System.out.print("| " + n3 + " ");
        System.out.print("| " + n4 + " ");
        System.out.print("| " + n5 + " ");
        System.out.println("| " + n6 + " |");
        System.out.println(br);
    }

    public void print(double p1, double p2, double p3, double p4, double p5, double p6) {
        System.out.printf("|    %.2f    ", p1);
        System.out.printf("|  %.6f  ", p2);
        System.out.printf("|  %.6f  ", p3);
        System.out.printf("|  %.6f  ", p4);
        System.out.printf("| %10.4e ", p5);
        System.out.printf("| %10.4e |\n", p6);
    }

    public void close() {
        System.out.println(br);
    }
}

// Digit - клас для розрахунків Y(x) різними методами
class Digit {
    private int nsum;
    private double eps;

    public Digit(int nsum, double eps) {
        this.nsum = nsum;
        this.eps = eps;
    }

    public double ra1(double x) {

        return Math.cos(x);
    }

    public double ra2(double x) {
        double sum = 1.0;
        double term = 1.0;

        for (int i = 1; i <= nsum; i++) {
            term *= -x * x / (2.0 * i * (2.0 * i - 1));
            sum += term;
        }

        return sum;
    }

    public double ra3(double x) {
        double sum = 1.0;
        double term = 1.0;
        int i = 1;

        while (Math.abs(term) > eps) {
            term *= -x * x / (2.0 * i * (2.0 * i - 1));
            sum += term;
            i++;
        }

        return sum;
    }
}
