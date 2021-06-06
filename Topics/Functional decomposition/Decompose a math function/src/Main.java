import java.util.Scanner;

class MultipleFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        System.out.println(f(x));
    }

    public static double f(double x) {
        //call your implemented methods here.
        if (x <= 0) {
            return f1(x);
        } else if (x > 0 && x < 1) {
            return f2(x);
        } else {
            return f3(x);
        }
    }

    //implement your methods here
    public static double f1(double f1){
        return Math.pow(f1, 2) + 1;
    }

    public static double f2 (double f2){
        return 1 / Math.pow(f2, 2);
    }


    public static double f3 (double f3){
        return Math.pow(f3, 2) - 1;
    }
}