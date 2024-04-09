public class Fraction {
    
    private int numerator = 0;
    private int denominator = 0;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction reduce() {
        int gcd = gcd(this.numerator, this.denominator);
        return new Fraction(this.numerator/gcd, this.denominator/gcd);
    } 

    @Override
    public String toString() {
        return numerator + (denominator != 1 ? "/" + denominator: "");
    }  

    // static

    public static Fraction sum(Fraction f1, Fraction f2) {
        int common_denominator = lcm(f1.denominator,f2.denominator);
        return new Fraction(f1.numerator*(common_denominator/f1.denominator) + f2.numerator*(common_denominator/f2.denominator),common_denominator);
    }

    public static Fraction minus(Fraction f1, Fraction f2) {
        int common_denominator = lcm(f1.denominator,f2.denominator);
        return new Fraction(f1.numerator*(common_denominator/f1.denominator) - f2.numerator*(common_denominator/f2.denominator),common_denominator);
    }

    public static Fraction multiplication(Fraction f1, Fraction f2) {
        return new Fraction(f1.numerator*f2.numerator,f1.denominator*f2.denominator);
    }

    public static Fraction division(Fraction f1, Fraction f2) {
        return new Fraction(f1.numerator*f2.denominator,f1.denominator*f2.numerator);
    }

    public static Fraction exponential(Fraction f1, int exp) {
        Fraction res = null;
        if (exp >= 0) {
            res = new Fraction((int)Math.pow(f1.numerator,exp), (int)Math.pow(f1.denominator,exp));
        } else {
            res = new Fraction((int)Math.pow(f1.denominator,-exp), (int)Math.pow(f1.numerator,-exp));
        }
        return res;
    }

    // private

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Setters && Getters && ...

    public void invert() {
        numerator = -numerator;
    }

    public boolean isValid() {
        return denominator != 0;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

}
