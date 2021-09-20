import java.util.*;
import java.lang.*;
import java.util.Scanner;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner sc = new Scanner(System.in);
       int type = sc.nextInt(), n = sc.nextInt();
       int b = 0, s = 0, l = 0;
       switch (type){
           case 1: while(b <= n){
                        s++;
                        b+= s * s;
                        if(b <= n){
                             l++;
                        }
                    }
                    break;
           case 2: s = 1;
                    while(b <= n){
                        b += s * s;
                        s+=2;
                        if(b <= n){
                          l++;
                        }  
                    }
                    break;
       }
       System.out.println(l);  
	}
}