import java.util.*;
import java.lang.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

class Main
{
 public static Map<Integer, Point2D.Double[]> points = new HashMap<Integer, Point2D.Double[]>();
    public static List<Double> unlengths = new ArrayList<>();
    public static List<Double> unangles = new ArrayList<>();
    public static int unvertices;
    public static int unsides;
    public static boolean clockwise = true;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        sc.useLocale(Locale.US);
        unvertices = sc.nextInt();
        Point2D.Double[] unpoints = new Point2D.Double[unvertices];
        for (int i = 0; i < unvertices; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Point2D.Double point = new Point2D.Double(x, y);
            unpoints[i] = point;
        }
        
        int available = sc.nextInt();
        for (int j = 1; j < available + 1; j++) {
            Point2D.Double[] avpoints = new Point2D.Double[unvertices];
            for (int i = 0; i < unvertices; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                Point2D.Double point = new Point2D.Double(x, y);
                avpoints[i] = point;
            }
            points.put(j, avpoints);
        }
        
        for (int i = 0; i < unpoints.length; i++) {
            double edge = 0;
            if (i != unpoints.length - 1) {
                edge = (unpoints[i + 1].getX() - unpoints[i].getX()) * (unpoints[i + 1].getY() + unpoints[i].getY());
                sum += edge;
            } else {
                edge = (unpoints[0].getX() - unpoints[i].getX()) * (unpoints[0].getY() + unpoints[i].getY());
                sum += edge;
            }
        }
        
        if (sum < 0) {
            clockwise = false;
        }
        
//        System.out.println(clockwise);
        for (int i = 0; i < unpoints.length; i++) {
            if (i != unpoints.length - 1 && i != unpoints.length - 2) {
                unangles.add(getAngle(unpoints[i], unpoints[i + 1], unpoints[i + 2]));
                unlengths.add(calLength(unpoints[i], unpoints[i + 1]));
            } else if (i == unpoints.length - 2) {
                unangles.add(getAngle(unpoints[i], unpoints[i + 1], unpoints[0]));
                unlengths.add(calLength(unpoints[i], unpoints[i + 1]));
            } else if (i == unpoints.length - 1) {
                unangles.add(getAngle(unpoints[i], unpoints[0], unpoints[1]));
                unlengths.add(calLength(unpoints[i], unpoints[0]));
            }
        }
        
        unsides = unlengths.size();
//        System.out.println("unLENGTHS" + unlengths);
//        System.out.println("unangles" + unangles);
        for (Map.Entry<Integer, Point2D.Double[]> entry : points.entrySet()) {
            if (Polygon(entry.getValue()) == true) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
    
    public static double calLength(Point2D.Double a, Point2D.Double b) {
        double distance = Math.round(a.distance(b) * 10.0) / 10.0;
        return distance;
    }

    //        double xDiff = p2.getX() - p1.getX();
//        double yDiff = p2.getY() - p1.getY();
//        double angle = Math.toDegrees(Math.atan2(yDiff, xDiff));
// * @param A1 First point first line
// * @param A2 Second point first line
// * @param B1 First point second line
// * @param B2 Second point second line
//        double angle1 = Math.atan2(p2.y - p1.y, p1.x - p2.x);
//        double angle2 = Math.atan2(p3.y - p2.y, p2.x - p3.x);
//        double angle = Math.toDegrees(angle1 - angle2);
    //A = A2-A1
//B = B2-B1
    public static double getAngle(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3) {
//        double vAx = p1.x - p2.x;
//        double vAy = p2.y - p1.y;
//        double vBx = p2.x - p3.x;
//        double vBy = p3.y - p2.y;
        double vAx = p1.x - p2.x;
        double vAy = p2.y - p1.y;
        double vBx = p2.x - p3.x;
        double vBy = p3.y - p2.y;
        double aLength = Math.sqrt(vAx * vAx + vAy * vAy);
        vAx /= aLength;
        vAy /= aLength;
        double bLength = Math.sqrt(vBx * vBx + vBy * vBy);
        vBx /= bLength;
        vBy /= bLength;
        double dot = (vAx * vBx) + (vAy * vBy);
        double angle = Math.toDegrees(Math.acos(dot));
        if (angle < 180 && angle > 0) {
            angle = 180 - angle;
        } else {
            angle = angle - 180;
        }
        if (angle < 0) {
            angle = -angle;
        }
        angle = Math.round(angle * 1.0) / 1.0;
        return angle;
    }
    
    public static double getAngle2(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        double result = 0.0;
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);
        double cosB = (ac * ac) - (ab * ab) - (bc * bc);
        cosB /= (2 * ab * bc);
        result = (Math.acos(cosB) * 180 / Math.PI);
        return result;
    }
//unangles[153.43, 135.0, 71.57]
//unangles[153.43494882292202, 135.0, 71.56505117707799]

    public static boolean Polygon(Point2D.Double[] array) {
        List<Double> avlengths = new ArrayList<>();
        List<Double> avangles = new ArrayList<>();
        boolean flag = false;
        boolean pclockwise = true;
        double sum = 0;
        
        for (int i = 0; i < array.length; i++) {
            double edge = 0;
            if (i != array.length - 1) {
                edge = (array[i + 1].getX() - array[i].getX()) * (array[i + 1].getY() + array[i].getY());
                sum += edge;
            } else {
                edge = (array[0].getX() - array[i].getX()) * (array[0].getY() + array[i].getY());
                sum += edge;
            }
        }
        
        if (sum < 0) {
            pclockwise = false;
        }
        
        if (clockwise != pclockwise) {
//            System.out.println("aaaa");
            for (int i = 0; i < array.length / 2; i++) {
                Point2D.Double temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
        }
        
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1 && i != array.length - 2) {
                avangles.add(getAngle(array[i], array[i + 1], array[i + 2]));
                avlengths.add(calLength(array[i], array[i + 1]));
            } else if (i == array.length - 2) {
                avangles.add(getAngle(array[i], array[i + 1], array[0]));
                avlengths.add(calLength(array[i], array[i + 1]));
            } else if (i == array.length - 1) {
                avangles.add(getAngle(array[i], array[0], array[1]));
                avlengths.add(calLength(array[i], array[0]));
            }
        }
//        System.out.println();
//        System.out.println("avLENGTHS" + avlengths);
//        System.out.println("AVangles" + avangles);
//        System.out.println();
        
        for (int i = 0; i < unvertices * 2; i++) {
            Collections.rotate(avlengths, 1);
            Collections.rotate(avangles, 1);
                if (unangles.equals(avangles) && unlengths.equals(avlengths)) {
                    flag = true;
                    break;
                }
        }
        
        int sides = avlengths.size();
        if (unsides != sides) {
            flag = false;
        }
        if (flag == false) {
            return false;
        }

//        for (int i = 0; i < array.length; i++) {
//            if (i != array.length - 1 && i != array.length - 2) {
//                avangles.add(getAngle(array[i], array[i + 1], array[i + 2]));
//            } else if (i == array.length - 2) {
//                avangles.add(getAngle(array[i], array[i + 1], array[0]));
//            } else if (i == array.length - 1) {
//                avangles.add(getAngle(array[i], array[0], array[1]));
//            }
//        }
//        for (int i = 0; i < unvertices * 2; i++) {
//            Collections.rotate(avangles, 1);
//            if (unangles.equals(avangles)) {
//                flag2 = true;
//                break;
//            }
//        }
//        if (flag2 == false) {
//            return false;
//        }
//return flag2 != false
        return true;
    }
}