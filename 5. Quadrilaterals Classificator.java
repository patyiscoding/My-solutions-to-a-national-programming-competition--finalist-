import static java.lang.Math.sqrt;
import java.util.Locale;
import java.util.Scanner;
class Main
{
     public static void main(String[] args) {
        double a, b, c, d, d1, d2;
        String result = "";
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double[] array = new double[8];
        for(int i=0; i<array.length; i++){
            array[i] = sc.nextDouble();
        }
        a = sqrt(Math.pow((array[2] - array[0]), 2) + Math.pow((array[3] - array[1]), 2));
        b = sqrt(Math.pow((array[4] - array[2]), 2) + Math.pow((array[5] - array[3]), 2));
        c = sqrt(Math.pow((array[6] - array[4]), 2) + Math.pow((array[7] - array[5]), 2));
        d = sqrt(Math.pow((array[0] - array[6]), 2) + Math.pow((array[1] - array[7]), 2));
        d1 = sqrt(Math.pow((array[0] - array[4]), 2) + Math.pow((array[1] - array[5]), 2));
        d2 = sqrt(Math.pow((array[2] - array[6]), 2) + Math.pow((array[3] - array[7]), 2));
        if(a == b && a == c && a == d && d1 == d2){
            result = "SQUARE";
        }else if(a == c && b == d && a != b && d1 == d2){
            result = "RECTANGLE";
        }else if(a == b && a == c && a == d && d1 != d2){
            result = "RHOMBUS";
        }else if(a == c && b == d && a != b && d1 != d2){
            result = "PARALLELOGRAM";
        }else if((((array[2] - array[0]) / (array[3] - array[1])) == ((array[6] - array[4]) / (array[7] - array[5]))) || (((array[5] - array[3]) / (array[4] - array[2])) == ((array[7] - array [1]) / (array[6] - array[0])))){
            result = "TRAPEZIUM";
        }else if(((a == d && b == c) || (a == b && c == d)) && d1 != d2) {
            result = "DELTOID";
        }else{
            result = "OTHER";
        }
        System.out.println(result);
    }
}