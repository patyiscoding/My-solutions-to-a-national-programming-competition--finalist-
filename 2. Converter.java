import java.util.*;
import java.lang.*;
import java.util.Scanner;
class Main
{
	public static void main (String[] args) throws java.lang.Exception{
	   Scanner sc = new Scanner(System.in);
       int system = sc.nextInt();
       String input = sc.next();
       int system2 = sc.nextInt();
       if(input == input.toUpperCase() || input == input.toLowerCase()){
           try{
               System.out.println((Integer.toString(Integer.parseInt(input, system), system2)).toUpperCase());
           } catch (NumberFormatException e){
               System.out.println("NaN");
           }
       }else{
           System.out.println("NaN");
       }
	}
}