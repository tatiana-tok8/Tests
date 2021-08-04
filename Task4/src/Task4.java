
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Task4 {
	
	public static int ArMean(int[] arr) {
    	int mean = arr[0];
        for (int i = 1; i < arr.length; i++) 
        {
        	mean = mean + arr[i];
        }
        mean = mean/arr.length;
        return mean;
    }
	
	static int CountSteps(int[] arr) {
		int steps = 0;
		int mean = ArMean(arr);
		//System.out.println("Arithmetic mean: " + mean);
		for (int i = 0; i < arr.length; i++)
		{
			while (arr[i]!=mean) {
				if (arr[i]>mean) {
					arr[i]--;
					steps++;
				} else if (arr[i]<mean) {
					arr[i]++;
					steps++;
				}
			}
		}
		return steps;
	}
	public static void main(String[] args) {
		String path = args[0];
        ArrayList<Integer> intArrayList = new ArrayList<>();
       // File file = new File("C:\\Users\\Tania\\eclipse-workspace\\Task4\\file.txt");
        File file = new File(path);
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
		try {
			System.out.println(CountSteps(nums));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
