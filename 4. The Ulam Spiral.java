import java.util.Arrays;
import java.util.Scanner;

class Main
{
    enum Direction{
            RIGHT, UP, LEFT, DOWN;
    }
       
    private static String[][] genUlam(int n){
        int count = 1, count2 = 1;
        while(count2 < n){
            count+=2;
            count2 = count * count;
        }
        return genUlam(count, 1, n);
    }
    
    private static String[][] genUlam(int n, int i, int input2){
		String[][] spiral = new String[n][n];
                Direction dir = Direction.RIGHT;
		int j = i;
		int y = n / 2;
		int x = (n % 2 == 0) ? y - 1 : y;
		while(j <= ((n * n) - 1 + i)){
                        if(j <= input2){
                            spiral[y][x] = String.valueOf(j);
                            spiral[y][x] = isPrime(j) ? "#" : ".";
                        }else{
                            spiral[y][x]  = "";
                        }
                        
			switch(dir){
			case RIGHT: if(x <= (n - 1) && spiral[y - 1][x] == null && j > i) dir = Direction.UP; break;
			case UP: if(spiral[y][x - 1] == null) dir = Direction.LEFT; break;
			case LEFT: if(x == 0 || spiral[y + 1][x] == null) dir = Direction.DOWN; break;
			case DOWN: if(spiral[y][x + 1] == null) dir = Direction.RIGHT; break;
			}
 
			switch(dir){
				case RIGHT:	x++; break;
				case UP: 	y--; break;
				case LEFT:	x--; break;
				case DOWN:	y++; break;
			}
			j++;
		}
		return spiral;
    }
    
    public static boolean isPrime(int a){
		   if(a == 2) return true;
		   if(a <= 1 || a % 2 == 0) return false;
		   long max = (long)Math.sqrt(a);
		   for(long n = 3; n <= max; n += 2){
		      if(a % n == 0) return false;
		   }
		   return true;
		}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if(input != 1){
            String[][] ulam = genUlam(input);
        
            for(String[] row : ulam){
                if(row != null){
                    String out = Arrays.toString(row).replaceAll(",", "");
                    out = out.replace("[", "").replace("]", "").replace(" ", "");
                    if (out.length()>0){
                        System.out.println(out);
                    }
                }
            }
        }else{
            System.out.println(".");
        }
    } 
}