package Tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class task1 {
    public static void main(String[] args) {
    	String path = args[0];
        ArrayList<Double> doubleArrayList = new ArrayList<>();
        //File file = new File("C:\\Users\\Tania\\eclipse-workspace\\Tests\\file.txt");
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                doubleArrayList.add(Double.valueOf(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Double[] array = new Double[doubleArrayList.size()];
        doubleArrayList.toArray(array);
        for(int i = 0; i< array.length; i++) {
        	   System.out.println(array[i]);
        	}
        System.out.printf("Percentile 90: %.2f%n", percentile(doubleArrayList, 90));
        System.out.printf("Mediane: %.2f%n", percentile(doubleArrayList, 50));
        System.out.println("Minimum: " + minimum(array));
        System.out.println("Maximum: " + maximum(array));
        System.out.println("Arithmetic mean: " + ArMean(array));
    }

    public static double percentile(List<Double> latencies, double percentile) {
        Collections.sort(latencies);
        int index = (int) Math.ceil(percentile / 100.0 * latencies.size());
        return latencies.get(index - 1);
    }
    
    public static double maximum(Double[] arr) {
    	double max = arr[0];
	        for (int i = 0; i < arr.length; i++) 
	        {
	            if (max < arr[i])
	            {
	                max = arr[i];
	            }
	        }
        return max;
    }
    
    public static double minimum(Double[] arr) {
    	double min = arr[0];
	        for (int i = 0; i < arr.length; i++) 
	        {
	            if (min > arr[i])
	            {
	                min = arr[i];
	            }
	        }
        return min;
    }

    public static double ArMean(Double[] arr) {
    	double mean = arr[0];
        for (int i = 1; i < arr.length; i++) 
        {
        	mean = mean + arr[i];
        }
        mean = mean/arr.length;
        return mean;
    }
}
