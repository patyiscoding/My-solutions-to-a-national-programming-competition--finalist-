import java.util.*;
import java.lang.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main
{
	
    public static String[][] I = new String[4][1];
    public static String[][] Ir = new String[1][4];
    public static String[][] J = new String[3][2];
    public static String[][] Jr1 = new String[2][3];
    public static String[][] Jr2 = new String[3][2];
    public static String[][] Jr3 = new String[2][3];
    public static String[][] L = new String[3][2];
    public static String[][] Lr1 = new String[2][3];
    public static String[][] Lr2 = new String[3][2];
    public static String[][] Lr3 = new String[2][3];
    public static String[][] O = new String[2][2];
    public static String[][] S = new String[2][3];
    public static String[][] Sr = new String[3][2];
    public static String[][] T = new String[2][3];
    public static String[][] Tr1 = new String[3][2];
    public static String[][] Tr2 = new String[2][3];
    public static String[][] Tr3 = new String[3][2];
    public static String[][] Z = new String[2][3];
    public static String[][] Zr = new String[3][2];
    public static String a1 = "", a2 = "", a3 = "", a4 = "";
    public static boolean b1 = false, b2 = false, b3 = false, b4 = false;
    public static int maxclear = 0;
    public static HashMap<String, String[][]> arraynames = new HashMap<>();
    public static Map<String[][], Integer> listofarrays = new HashMap<String[][], Integer>();
    public static Integer clear = 0;
    public static String[][] tableprim;

    public static void main(String[] args) {
        int result = 0;
        String[][] newArray = new String[20][10];
        String[][] piece;
        String var = "";
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        String[][] array = new String[20][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.next();
                if (j == 9) {
                    sc.nextLine();
                }
            }
        }

        String list = sc.nextLine();
        arraynames.put("I", I);
        arraynames.put("Ir", Ir);
        arraynames.put("J", J);
        arraynames.put("Jr1", Jr1);
        arraynames.put("Jr2", Jr2);
        arraynames.put("Jr3", Jr3);
        arraynames.put("L", L);
        arraynames.put("Lr1", Lr1);
        arraynames.put("Lr2", Lr2);
        arraynames.put("Lr3", Lr3);
        arraynames.put("O", O);
        arraynames.put("S", S);
        arraynames.put("Sr", Sr);
        arraynames.put("T", T);
        arraynames.put("Tr1", Tr1);
        arraynames.put("Tr2", Tr2);
        arraynames.put("Tr3", Tr3);
        arraynames.put("Z", Z);
        arraynames.put("Zr", Zr);

        for (String[] row : I) {
            Arrays.fill(row, "#");
        }
        for (String[] row : Ir) {
            Arrays.fill(row, "#");
        }
        J[0][0] = ".";
        J[0][1] = "#";
        J[1][0] = ".";
        J[1][1] = "#";
        J[2][0] = "#";
        J[2][1] = "#";

        Jr1[0][0] = "#";
        Jr1[0][1] = ".";
        Jr1[0][2] = ".";
        Jr1[1][0] = "#";
        Jr1[1][1] = "#";
        Jr1[1][2] = "#";

        Jr2[0][0] = "#";
        Jr2[0][1] = "#";
        Jr2[1][0] = "#";
        Jr2[1][1] = ".";
        Jr2[2][0] = "#";
        Jr2[2][1] = ".";

        Jr3[0][0] = "#";
        Jr3[0][1] = "#";
        Jr3[0][2] = "#";
        Jr3[1][0] = ".";
        Jr3[1][1] = ".";
        Jr3[1][2] = "#";

        L[0][0] = "#";
        L[0][1] = ".";
        L[1][0] = "#";
        L[1][1] = ".";
        L[2][0] = "#";
        L[2][1] = "#";

        Lr1[0][0] = "#";
        Lr1[0][1] = "#";
        Lr1[0][2] = "#";
        Lr1[1][0] = "#";
        Lr1[1][1] = ".";
        Lr1[1][2] = ".";

        Lr2[0][0] = "#";
        Lr2[0][1] = "#";
        Lr2[1][0] = ".";
        Lr2[1][1] = "#";
        Lr2[2][0] = ".";
        Lr2[2][1] = "#";

        Lr3[0][0] = ".";
        Lr3[0][1] = ".";
        Lr3[0][2] = "#";
        Lr3[1][0] = "#";
        Lr3[1][1] = "#";
        Lr3[1][2] = "#";

        S[0][0] = ".";
        S[0][1] = "#";
        S[0][2] = "#";
        S[1][0] = "#";
        S[1][1] = "#";
        S[1][2] = ".";

        Sr[0][0] = "#";
        Sr[0][1] = ".";
        Sr[1][0] = "#";
        Sr[1][1] = "#";
        Sr[2][0] = ".";
        Sr[2][1] = "#";

        T[0][0] = "#";
        T[0][1] = "#";
        T[0][2] = "#";
        T[1][0] = ".";
        T[1][1] = "#";
        T[1][2] = ".";

        Tr1[0][0] = ".";
        Tr1[0][1] = "#";
        Tr1[1][0] = "#";
        Tr1[1][1] = "#";
        Tr1[2][0] = ".";
        Tr1[2][1] = "#";

        Tr2[0][0] = ".";
        Tr2[0][1] = "#";
        Tr2[0][2] = ".";
        Tr2[1][0] = "#";
        Tr2[1][1] = "#";
        Tr2[1][2] = "#";

        Tr3[0][0] = "#";
        Tr3[0][1] = ".";
        Tr3[1][0] = "#";
        Tr3[1][1] = "#";
        Tr3[2][0] = "#";
        Tr3[2][1] = ".";

        Z[0][0] = "#";
        Z[0][1] = "#";
        Z[0][2] = ".";
        Z[1][0] = ".";
        Z[1][1] = "#";
        Z[1][2] = "#";

        Zr[0][0] = ".";
        Zr[0][1] = "#";
        Zr[1][0] = "#";
        Zr[1][1] = "#";
        Zr[2][0] = "#";
        Zr[2][1] = ".";

        for (String[] row : O) {
            Arrays.fill(row, "#");
        }

        for (char ch : list.toCharArray()) {
            var = String.valueOf(ch);
            newArray = howMany(var, array);
            listofarrays.clear();
            result += maxclear;
            maxclear = 0;
            for (int i = 0; i < newArray.length; i++) {
                String[] aMatrix = newArray[i];
                int aLength = aMatrix.length;
                array[i] = new String[aLength];
                System.arraycopy(aMatrix, 0, array[i], 0, aLength);
            }
//            System.out.println("FINAAAAAAL");
//            for (String[] row : newArray) {
//                String out = Arrays.toString(row).replaceAll(",", "");
//                out = out.replace("[", "").replace("]", "").replace(" ", "");
//                System.out.println(out);
//            }
        }
        System.out.println(result);
    }

    private static AbstractMap.SimpleEntry<Integer, String[][]> areClears(String[][] newArray) {
        int line = 0;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < newArray[i].length; j++) {
                if ((newArray[i][j]).equals("#")) {
                    line++;
                }
                if (line != 0 && line % 10 == 0) {
                    clear++;
                    for (int e = i; e > 1; e--) {
                        newArray[e] = newArray[e - 1];
                    }
                }
            }
            line = 0;
        }
        return new AbstractMap.SimpleEntry<>(clear, newArray);
    }

    private static String[][] howMany(String sign, String[][] array) {
        List<Integer> keylist = new ArrayList<>();
        List<Integer> scorelist = new ArrayList<>();
        String now = "";
        int x = 0, y = 0, count = 0, maxscore = 0, score = 0, tempheight = 0;
        boolean switch1 = false, switch2 = false, switch3 = false, down = false, flag = false, downflag = false, flaggo = false, flaggo2 = false, specialflag = true;
        String[][] copy = null;
        String[][] newArray = null;
        switch (sign) {
            case "I":
                a1 = "I";
                a2 = "Ir";
                b1 = true;
                b2 = true;
                break;
            case "J":
                a1 = "J";
                a2 = "Jr1";
                a3 = "Jr2";
                a4 = "Jr3";
                b1 = true;
                b2 = true;
                b3 = true;
                b4 = true;
                break;
            case "L":
                a1 = "L";
                a2 = "Lr1";
                a3 = "Lr2";
                a4 = "Lr3";
                b1 = true;
                b2 = true;
                b3 = true;
                b4 = true;
                break;
            case "O":
                a1 = "O";
                b1 = true;
                break;
            case "S":
                a1 = "S";
                a2 = "Sr";
                b1 = true;
                b2 = true;
                break;
            case "T":
                a1 = "T";
                a2 = "Tr1";
                a3 = "Tr2";
                a4 = "Tr3";
                b1 = true;
                b2 = true;
                b3 = true;
                b4 = true;
                break;
            case "Z":
                a1 = "Z";
                a2 = "Zr";
                b1 = true;
                b2 = true;
                break;
        }

        String[][] piece = arraynames.get(a1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < piece.length; i++) {
            list.add(piece[i].length);
        }
        int max = Collections.max(list);
        while (x <= 10 - max) {
            if (b1 == true) {
                piece = arraynames.get(a1);
                now = a1;
                if (x == 10 - max) {
                    b1 = false;
                    switch2 = true;
                    if (b2 == false) {
                        switch3 = true;
                    }
                }
            } else if (b2 == true) {
                piece = arraynames.get(a2);
                now = a2;
                list.clear();
                for (int i = 0; i < piece.length; i++) {
                    list.add(piece[i].length);
                }
                max = Collections.max(list);
                if (x == 10 - max) {
                    b2 = false;
                    switch2 = true;
                    if (b3 == false) {
                        switch3 = true;
                    }
                }
            } else if (b3 == true) {
                piece = arraynames.get(a3);
                now = a3;
                list.clear();
                for (int i = 0; i < piece.length; i++) {
                    list.add(piece[i].length);
                }
                max = Collections.max(list);
                if (x == 10 - max) {
                    b3 = false;
                    switch2 = true;
                    if (b4 == false) {
                        switch3 = true;
                    }
                }
            } else if (b4 == true) {
                piece = arraynames.get(a4);
                now = a4;
                list.clear();
                for (int i = 0; i < piece.length; i++) {
                    list.add(piece[i].length);
                }
                max = Collections.max(list);
                if (x == 10 - max) {
                    b4 = false;
                    switch2 = true;
                    switch3 = true;
                }
            }

            clear = 0;
            switch1 = false;
            y = 0;
            newArray = new String[array.length][];
            for (int i = 0; i < array.length; i++) {
                String[] aMatrix = array[i];
                int aLength = aMatrix.length;
                newArray[i] = new String[aLength];
                System.arraycopy(aMatrix, 0, newArray[i], 0, aLength);
            }
            clear = areClears(newArray).getKey();
            int move = piece.length - 1;
            while (switch1 == false) {
                copy = new String[piece.length][];
                for (int i = 0; i < piece.length; i++) {
                    String[] aMatrix = piece[i];
                    int aLength = aMatrix.length;
                    copy[i] = new String[aLength];
                    System.arraycopy(aMatrix, 0, copy[i], 0, aLength);
                }
                hi:
                for (int c = piece.length - 1; c < piece.length; c++) { // CHECKING ONLY LAST ROW OF A PIECE
                    for (int d = 0; d < piece[c].length; d++) {
//                        if (now.equals("T")) {
//                            System.out.println("ddddd " + d);
//                        }
                        if ((newArray[c + 1 + y][d + x]).equals(".") && specialflag == true) {
                            down = true;
//  System.out.println("count " + count);
//                            if (now.equals("Lr2")) {
//                            if (now.equals("T")) {
////                                System.out.println("1dd " + d);
////                                flag = true;
//                            }
//                                System.out.println("count " + count);
//                                System.out.println("hITHERE");
//                                System.out.println("flag? " + flag);
//                                System.out.println("DOWNflag? " + downflag);
//                                System.out.println("flaggo " + flaggo);
//                                System.out.println("DOWN? " + down);
////
//                                System.out.println();
//                                System.out.println("HIIIIa111");
//                                for (String[] row : newArray) {
//                                    String out = Arrays.toString(row).replaceAll(",", "");
//                                    out = out.replace("[", "").replace("]", "").replace(" ", "");
//                                    System.out.println(out);
//                                }
//                            }
                            if (now.equals("Lr2") && d == 0 && newArray[c + y][d + x].equals("#")) { // REPLACING IF # OVER . IN LR2
                                copy[c - 1][d] = newArray[c + y][d + x];
                                downflag = false;
                            }

                            if (now.equals("Jr2") && d == 1 && newArray[c + y][d + x].equals("#")) { // REPLACING IF # OVER . IN LR2
                                copy[c - 1][d] = newArray[c + y][d + x];
                                downflag = false;
                            }

                        } else if (((newArray[c + 1 + y][d + x]).equals("#") && (newArray[c + y][d + x]).equals(".")) || downflag == true) {
//                            if (now.equals("T")) {
//                                System.out.println("22222");
//                            }
//                            System.out.println("DOWN " + downflag);
                            if (now.equals("Lr1")) {
                                for (int j = d + 1; j < piece[c].length; j++) {
                                    if ((newArray[c + y][j + x]).equals(".")) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                            } else if (now.equals("Lr2")) {

                                for (int j = d + 1; j < piece[c].length; j++) {

                                    if ((newArray[c + 1 + y][j + x]).equals(".")) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        downflag = false;
                                        down = false;
                                        count = 0;
                                        break;
                                    }
                                }
                                if (flag == true) {
                                    count++;
                                }
                                if (flag == true && (count == 1 || count == 2)) {
                                    downflag = true;
                                }
                                if (count == 2) {
                                    flaggo = true;
//                                    System.out.println("heloooooooooo");
                                    downflag = false;
                                    specialflag = false;
                                    count = 0;
                                }
                            } else if (now.equals("Jr2")) {
                                if ((newArray[c + 1 + y][x]).equals(".")) {
                                    flag = true;

                                } else {
                                    flag = false;
                                    downflag = false;
                                    down = false;
                                    break;
                                }
                                if (flag == true) {
                                    count++;
                                }
                                if (flag == true && (count == 1 || count == 2)) {
                                    downflag = true;
                                }

                                if (count == 2) {
                                    flaggo2 = true;
                                    downflag = false;
                                    specialflag = false;
                                    count = 0;
                                }
                            } else if (now.equals("Jr3")) {
                                for (int j = d; j < piece[c].length - 1; j++) {
                                    if ((newArray[c + y][j + x]).equals(".")) {
                                        flag = true;
                                    } else {
                                        flag = false;
                                        break;
                                    }
                                }
                            } else if (now.equals("T")) {
//                                if (d != 1) {
//                                System.out.println("Ddd " + d);
//                                for (int j = d + 1; j < piece[c].length; j++) {
                                if ((newArray[c + y][d + x]).equals(".")) {
                                    flag = true;
//                                        System.out.println("j ok " + j);
                                } else {
                                    flag = false;
//                                        System.out.println("j break " + j);
//                                        System.out.println("j + x break " + (j + x));
//                                        System.out.println("break");
                                    break;
                                }
//                                }
//                                } else {
//                                    if ((newArray[c + 1 + y][d + x]).equals(".")) {
//                                        flag = true;
//                                    } else {
//                                        flag = false;
//                                        System.out.println("break");
//                                        break;
//                                    }
//                                }
//                                System.out.println("count " + count);
//                                System.out.println("hITHERE");
//                                System.out.println("flag? " + flag);
//                                System.out.println("DOWNflag? " + downflag);
//                                System.out.println("flaggo " + flaggo);
//                                System.out.println("DOWN? " + down);
//
//                                System.out.println();
//                                System.out.println("HIIIIIIIII");
//                                for (String[] row : newArray) {
//                                    String out = Arrays.toString(row).replaceAll(",", "");
//                                    out = out.replace("[", "").replace("]", "").replace(" ", "");
//                                    System.out.println(out);
//                                }
//
//                                System.out.println();
                            } else {
                                for (int j = d + 1; j < piece[c].length; j++) {
                                    if ((newArray[c + 1 + y][j + x]).equals(".")) {
                                        flag = true;
//                                        System.out.println("j ok " + j);
                                    } else {
                                        flag = false;
//                                        System.out.println("j break " + j);
//                                        System.out.println("break");
                                        break;
                                    }
                                }
                               
                            }
                            if (flag == true || d + 1 == piece[c].length || downflag == true) { // REPLACING
                                copy[c][d] = newArray[c + 1 + y][d + x];
                                if (flaggo == true) {
//                                     System.out.println("count " + count);
//                                System.out.println("hITHERE");
//                                System.out.println("flag? " + flag);
//                                System.out.println("DOWNflag? " + downflag);
//                                System.out.println("flaggo " + flaggo);
//                                System.out.println("DOWN? " + down);
//
//                                System.out.println();
//                                System.out.println("HIIIIIIIII");
//                                for (String[] row : newArray) {
//                                    String out = Arrays.toString(row).replaceAll(",", "");
//                                    out = out.replace("[", "").replace("]", "").replace(" ", "");
//                                    System.out.println(out);
//                                }
//
//                                System.out.println();
                                    copy[c - 1][d] = newArray[c + y][d + x]; // # WAS HERE PREVIOUSLY
                                    flaggo = false;
                                    downflag = false;
                                    break hi;
                                } else if (flaggo2 == true) {
                                    copy[c - 1][d] = newArray[c + y][d + x]; //CHECK IF EVERYTHING ALL RIGHT, HERE TOO :)
                                    flaggo2 = false;
                                    downflag = false;
                                    break hi;
                                }
                                down = true;
                            } else {
                                down = false;
                                break;
                            }
                        } else {
                            down = false;
                            break;
                        }

                    }
                }
                
                if (y + piece.length <= 20 && down == true) {
                    y++;
                    for (int c = 0; c < piece.length; c++) { //move piece one line down
                        for (int d = 0; d < piece[c].length; d++) {
                            newArray[y - 1][d + x] = ".";
                            newArray[c + y][d + x] = copy[c][d];

                        }
                    }
                    move++;
                }

                if ((y + piece.length == 20) || ((y + piece.length) <= 20 && down == false)) {
                    switch1 = true;
                    clear = areClears(newArray).getKey();
                    newArray = areClears(newArray).getValue();
//                    System.out.println();
//                    for (String[] row : newArray) {
//                        String out = Arrays.toString(row).replaceAll(",", "");
//                        out = out.replace("[", "").replace("]", "").replace(" ", "");
//                        System.out.println(out);
//                    }
//
//                    System.out.println();
                    listofarrays.put(newArray, clear);
                }
            }
            specialflag = true;
            x++;
            if (switch2 == true) {
//                System.out.println("changeee");
                x = 0;
                switch2 = false;
            }
            if (switch3 == true) {
                break;
            }
        }

        keylist.clear();
        for (Map.Entry<String[][], Integer> entry : listofarrays.entrySet()) {
            int value = entry.getValue();
            keylist.add(value);
            maxclear = Collections.max(keylist);
            score = AI(entry);
            scorelist.add(score);
        }

        maxscore = Collections.max(scorelist);

        for (Map.Entry<String[][], Integer> entry : listofarrays.entrySet()) {
            score = AI(entry);
            if (score == maxscore) {
                return entry.getKey();
            }
        }
        return newArray;
    }

    public static int AI(Map.Entry<String[][], Integer> entry) {
        int height = 0, hole = 0, bump = 0, score = 0, diff = 0, tempheight = 0;
        boolean flag3 = false, flag4 = false;
        List<Integer> bumplist = new ArrayList<>();

//        System.out.println();
//        for (String[] row : entry.getKey()) {
//            String out = Arrays.toString(row).replaceAll(",", "");
//            out = out.replace("[", "").replace("]", "").replace(" ", "");
//            System.out.println(out);
//        }
//
//        System.out.println();
        for (int i = 0; i < entry.getKey().length; i++) {
            for (int j = 0; j < entry.getKey()[i].length; j++) {
                if ((i != 19 && i != 18 && (entry.getKey()[i][j]).equals("#") && (entry.getKey()[i + 1][j]).equals(".") && (entry.getKey()[i + 2][j]).equals(".")) || (i != 19 && (entry.getKey()[i][j]).equals("#") && (entry.getKey()[i + 1][j]).equals("."))) {
                    if ((i != 19 && i != 18 && (entry.getKey()[i][j]).equals("#") && (entry.getKey()[i + 1][j]).equals(".") && (entry.getKey()[i + 2][j]).equals("."))) {
                        hole = hole + 2;
                    } else {
                        hole++;
                    }
                }
            }
        }
//        System.out.println("hri " + hole);
        for (int i = 0; i < 10; i++) {
            tempheight = 0;
            for (int k = 0; k < 20; k++) {
                if ((entry.getKey()[k][i]).equals("#") && flag3 == false) {
                    tempheight = (20 - k);

                    flag3 = true;
                }

                if (entry.getKey()[k][i].equals("#") && flag4 == false) {
                    bump = (20 - k);
                    flag4 = true;
                }
            }

            height += tempheight;
            bumplist.add(bump);
            flag3 = false;
            flag4 = false;
            bump = 0;
        }

        for (int m = 0; m < bumplist.size() - 1; m++) {
            diff = bumplist.get(m) - bumplist.get(m + 1);
            if (diff < 0) {
                diff = diff * (-1);
            }
            bump = bump + diff;
        }
//        System.out.println("h " + height);
//        System.out.println("c " + entry.getValue());
//        System.out.println("hole " + hole);
//        System.out.println("b " + bump);
//        System.out.println();
        score = (-510066 * height) + (760666 * entry.getValue()) + (-356630 * hole) + (-184483 * bump);
        return score;
    }
}