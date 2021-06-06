import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        var input = sc.next();
        double a;
        double b;
        double c;
        double r;

        switch(input){
            case "triangle":
                a = sc.nextDouble();
                b = sc.nextDouble();
                c = sc.nextDouble();
                var p = (a + b + c) / 2;
                var area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println(area);
                break;
            case "rectangle":
                a = sc.nextDouble();
                b = sc.nextDouble();
                System.out.println(a * b);
                break;
            case "circle":
                r = sc.nextDouble();
                System.out.println(Math.pow(r, 2)*3.14);
                break;



        }
    }
}