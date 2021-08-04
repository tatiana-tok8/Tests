import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Circle {
	Point center;
	public double r; // радиус
	
	public Circle(Point cen, double a) {
		center = cen;
        r = a;
    }  

	public int IsInCircle(Point p) {
		int flag = 0;
		if ((p.x-this.center.x)*(p.x-this.center.x) + (p.y-this.center.y)*(p.y-this.center.y) == r*r) {
			flag = 0;
		} else if ((p.x-this.center.x)*(p.x-this.center.x) + (p.y-this.center.y)*(p.y-this.center.y) < r*r) {
			flag = 1;
		} else if ((p.x-this.center.x)*(p.x-this.center.x) + (p.y-this.center.y)*(p.y-this.center.y) > r*r) {
			flag = 2;
		}
		return flag;
	}
	
	public static int[] readFromFile(File file) {
		ArrayList<Integer> intArrayList = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            intArrayList.add(Integer.valueOf(line));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    int[] nums = new int[intArrayList.size()];
        for(int i = 0; i< intArrayList.size(); i++) {
     	   nums[i] = intArrayList.get(i);
     	}
	    return nums;
		}
	
	public static void main(String[] args) {
		int[] CenrerArr = readFromFile(new File(args[0]));
		int[] Points = readFromFile(new File(args[1]));
		
		Point center = new Point(CenrerArr[0], CenrerArr[1]);
		Circle o1 = new Circle(center, CenrerArr[2]);
		
			for(int i = 0; i < Points.length; i=i+2) {
					Point a = new Point(Points[i], Points[i+1]);
					System.out.println(o1.IsInCircle(a));
		     	}
	}
}


