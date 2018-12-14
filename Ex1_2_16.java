import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;

public class Ex1_2_16{
    private long numerator;
    private long denominator;
    
    public Rational(int numerator, int denominator){
        if(denominator < 0){
            numerator = (-1) * numerator;
            denominator = (-1) * denominator;
        }
        long cd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / cd;
        this.denominator = denominator / cd;
    }
    
    public long getnumerator(){
        return numerator;
    }
    
    public long getdenominator(){
        return denominator;
    }
    
    public Rational plus(Rational b){
        long num = b.getnumerator();
        long den = b.getdenominator();
        long add_num = num * denominator + numerator * den;
        long add_den = den * denominator;
        long cd = gcd(Math.abs(add_num), Math.abs(add_den));
        this.numerator = add_num / cd;
        this.denominator = add_den / cd;
        return this;
    }
    
    public Rational minus(Rational b){
        long num = b.getnumerator();
        long den = b.getdenominator();
        long sub_num = numerator * den - num * denominator;
        long sub_den = den * denominator;
        long cd = gcd(Math.abs(sub_num), Math.abs(sub_den));
        this.numerator = sub_num / cd;
        this.denominator = sub_den / cd;
        return this;
    }
    
    public Rational times(Rational b){
        long num = b.getnumerator();
        long den = b.getdenominator();
        long mul_num = numerator * num;
        long mul_den = den * denominator;
        long cd = gcd(Math.abs(mul_num), Math.abs(mul_den));
        this.numerator = mul_num / cd;
        this.denominator = mul_den / cd;
        return this;
    }
    
    public Rational divides(Rational b){
        long num = b.getnumerator();
        long den = b.getdenominator();
        long div_num = numerator * den;
        long div_den = num * denominator;
        long cd = gcd(Math.abs(div_num), Math.abs(div_den));
        this.numerator = div_num / cd;
        this.denominator = div_den / cd;
        return this;
    }
    
    public boolean equals(Rational that){
        if(this == that)
            return true;
        if(that == null)
            return false;
        return this.numerator == that.getnumerator() && this.denominator == that.getdenominator();
    }
    
    public String toString(){
        if(denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    private long gcd(long x, long y){
        if(y == 0)
            return x;
        long temp = x % y;
        return gcd(y, temp);
    }
    
    
    public static void main(String[] args)
    {
        Rational rat1 = new Rational(10, 30);
        Rational rat2 = new Rational(2, 5);
        StdOut.printf("plus: %s\n", rat1.plus(rat2).toString());
        StdOut.printf("minus: %s\n", rat1.minus(rat2).toString());  
        StdOut.printf("times: %s\n", rat1.times(rat2).toString());
        StdOut.printf("divides: %s\n", rat1.divides(rat2).toString());
        StdOut.printf("equals?: %s\n", rat1.equals(rat2));
    }
}