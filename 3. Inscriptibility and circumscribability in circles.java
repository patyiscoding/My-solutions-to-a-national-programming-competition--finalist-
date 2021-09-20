import java.util.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import static java.lang.Math.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		double length1, length2, length3, length4, length5, diagonal1, diagonal2, diagonal3;
        Scanner sc = new Scanner(System.in);
        double[] array = new double[8];
        for(int i=0; i<array.length; i++){
            array[i] = sc.nextDouble();
        }
        length1 = sqrt(Math.pow((array[2] - array[0]), 2) + Math.pow((array[3] - array[1]), 2));
        length2 = sqrt(Math.pow((array[4] - array[2]), 2) + Math.pow((array[5] - array[3]), 2));
        length3 = sqrt(Math.pow((array[6] - array[4]), 2) + Math.pow((array[7] - array[5]), 2));
        length4 = sqrt(Math.pow((array[0] - array[6]), 2) + Math.pow((array[1] - array[7]), 2));
        length5 = (length1 * length3) + (length2 * length4);
        diagonal1 = sqrt(Math.pow((array[0] - array[4]), 2) + Math.pow((array[1] - array[5]), 2));
        diagonal2 = sqrt(Math.pow((array[2] - array[6]), 2) + Math.pow((array[3] - array[7]), 2));
        diagonal3 = diagonal1 * diagonal2;
        DecimalFormat df = new DecimalFormat("#.##");
        double p = Double.parseDouble(df.format(diagonal3));
        if(length1 + length3 == length2 + length4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
        if(p == length5){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
		
	}
}