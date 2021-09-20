import java.util.*;
import java.lang.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main
{

    public static int row, col, questions, mines;
    public static boolean success = false, inconclusive = false, error = false, switch1 = false;
    public static List<Point> vertices = new ArrayList<>();
    public static char[][] table;
    public static Comparator<Point> comp = (Point o1, Point o2) -> new Integer(o1.x).compareTo(o2.x);
    public static char[][] mineArray;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        table = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                table[i][k] = sc.next().charAt(0);
            }
        }

        areMines(table);
        if (success == true) {
//            System.out.println("mines");
            for (int i = 0; i < vertices.size(); i++) {
                int value = vertices.get(i).x;
                int value2 = vertices.get(i).y;
                System.out.println(value + " " + value2);
            }
        } else if (inconclusive == true) {
            System.out.println("INCONCLUSIVE");
        } else if (error == true) {
            System.out.println("ERROR");
        }
    }

    public static void areMines(char[][] table) {
        mineArray = new char[table.length][];
        for (int i = 0; i < table.length; i++) { // copying array for marking bombs
            char[] aMatrix = table[i];
            int aLength = aMatrix.length;
            mineArray[i] = new char[aLength];
            System.arraycopy(aMatrix, 0, mineArray[i], 0, aLength);
        }
        //ERROR
        isError(table);
        if (error == true) {
            return;
        }
        //CORRECT
        for (int i = 0; i < row; i++) { //if questions and number are equal then replace it with B
            for (int k = 0; k < col; k++) {
                around(i, k);

                if (Character.isDigit(mineArray[i][k]) && (Character.getNumericValue(mineArray[i][k]) == (questions + mines))) {
                    switch1 = true;
//                    System.out.println();
//                    System.out.println("i " + i);
//                    System.out.println("k " + k);

                    around(i, k);
                    switch1 = false;
                }
            }
        }

//        for (char[] row2 : mineArray) {
//            String out = Arrays.toString(row2).replaceAll(",", "");
//            out = out.replace("[", "").replace("]", "").replace(" ", "");
//            System.out.println(out);
//        }
//        System.out.println();
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (Character.isDigit(mineArray[i][k])) {
                    around(i, k);

                    int a = Character.getNumericValue(mineArray[i][k]);
                    
                    if(a < mines){
                        error = true;
                        return;
                    }
                    
                    if(a != mines){
                       inconclusive = true;
                       return;
                    }
//                    int b = Character.getNumericValue(table[i][k]);
//                    if (b > questions + mines) {
//
//                        error = true;
//                        return;
//                    }
//                    if (a < mines) {
//                        inconclusive = true;
//                        return;
//                    }
                }
            }
        }

        // Collections.sort(vertices, comp);
        success = true;
//        return;
        //ERROR
//        for (int i = 0; i < row; i++) {
//            for (int k = 0; k < col; k++) {
//                around(i, k);
//                if (table[i][k] < question) {
//                    error = true;
//                    return;
//                }
//            }
//        }

    }

    public static void around(int i, int k) {
        questions = 0;
        mines = 0;
        if (i - 1 >= 0 && k - 1 >= 0) { //-1 -1
            questions += question(i - 1, k - 1);
            mines += mines(i - 1, k - 1);
        }
        if (i - 1 >= 0) { //0 -1
            questions += question(i - 1, k);
            mines += mines(i - 1, k);
        }

        if (i - 1 >= 0 && k + 1 < col) { //1 -1
            questions += question(i - 1, k + 1);
            mines += mines(i - 1, k + 1);
        }

        if (k - 1 >= 0) { //-1 0
            questions += question(i, k - 1);
            mines += mines(i, k - 1);
        }

        if (k + 1 < col) { //1 0
            questions += question(i, k + 1);
            mines += mines(i, k + 1);
        }

        if (k - 1 >= 0 && i + 1 < row) { //-1 1
            questions += question(i + 1, k - 1);
            mines += mines(i + 1, k - 1);
        }

        if (i + 1 < row) { //0 1
            questions += question(i + 1, k);
            mines += mines(i + 1, k);
        }

        if (k + 1 < col && i + 1 < row) {
            questions += question(i + 1, k + 1);
            mines += mines(i + 1, k + 1);
        }
    }

    public static int question(int i, int k) {
        if (mineArray[i][k] == '?') {
            if (switch1 == true) {
//                    System.out.println();
                Point point = new Point(i, k);
                mineArray[i][k] = 'B';
                boolean add = true;
                for (Point points : vertices) {
                    if (points.equals(point)) {//if the same point exists
                        add = false;
                    }
                }
                if (add == true) {
                    vertices.add(point);
                }

                switch1 = false;
            }
            return 1;
        } else {
            return 0;
        }
    }

    public static int mines(int i, int k) {
        if (mineArray[i][k] == 'B') {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean questionsRemaining(char[][] mineArray) {
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                around(i, k);
            }
        }
        if (questions == 0) {

        }
        return false;
    }

    public static void isError(char[][] table) {
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (Character.isDigit(table[i][k])) {
                    around(i, k);
                    int b = Character.getNumericValue(table[i][k]);
                    if (b > questions) {
                        error = true;
                    }
                }
            }
        }
    }
}