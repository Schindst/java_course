import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int NumPoints = 0;
        for(Point currPt : s.getPoints()) {
            NumPoints = NumPoints + 1;
        }
        return NumPoints;
    }

    public double getAverageLength(Shape s) {
        double length = getPerimeter(s);
        int numpoints = getNumPoints(s);
        double avgLength = length / numpoints;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        double largestside = 0.0;
        double prevDist = 0.0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            prevPt = currPt;
            if(currDist > prevDist){
                largestside = currDist;
            }
            prevDist = currDist;
        }
        return largestside;
    }

    public double getLargestX(Shape s) {
        double largestx = 0.0;
        double prevx = 0.0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()) {
            double currx= prevPt.getX();
            prevPt = currPt;
            if(currx > prevx){
                largestx = currx;
            }
            prevx = currx;
        }
        return largestx;
    }

    public double getLargestPerimeterMultipleFiles() {
        double prevperim = 0.0;
        double largestperim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double curperim = getPerimeter(s);
            if (curperim > prevperim) {
                largestperim = curperim;
            }
            prevperim = curperim;
        }
        return largestperim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double prevperim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double curperim = getPerimeter(s);
            if (curperim > prevperim) {
                temp = f;
            }
            prevperim = curperim;
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numpoints = getNumPoints(s);
        System.out.println("Number of points = " + numpoints);
        double avglength = getAverageLength(s);
        System.out.println("Average side length = " + avglength);
        double largestside = getLargestSide(s);
        System.out.println("Largest side = " + largestside);
        double largestx = getLargestX(s);
        System.out.println("Largest x = " + largestx);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestperim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter = " + largestperim);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("File with largest perim = " + file);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
