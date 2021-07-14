package Tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class task3 {
	  public static void main(String[] args) {
		  Double[] newArray1 = readFromFile(new File("C:\\Users\\Tania\\eclipse-workspace\\Tests\\Cach1.txt"));
		  Double[] newArray2 = readFromFile(new File("C:\\Users\\Tania\\eclipse-workspace\\Tests\\Cach2.txt"));
		  Double[] newArray3 = readFromFile(new File("C:\\Users\\Tania\\eclipse-workspace\\Tests\\Cach3.txt"));
		  Double[] newArray4 = readFromFile(new File("C:\\Users\\Tania\\eclipse-workspace\\Tests\\Cach4.txt"));
		  Double[] newArray5 = readFromFile(new File("C:\\Users\\Tania\\eclipse-workspace\\Tests\\Cach5.txt"));
		  for (int i = 0; i < newArray1.length; i++) 
	        {
			  newArray1[i]=newArray1[i]+newArray2[i]+newArray3[i]+newArray4[i]+newArray5[i];
			  i++;
	        }
		  System.out.println(MaxIndex(newArray1));
	    }
	  
	  
public static int MaxIndex(Double[] arr) {
	 double max = arr[0];
	  int index = 0;
	  for (int i = 0; i < arr.length; i++) 
	        {
	            if (max < arr[i])
	            {
	                max = arr[i];
	                index = i;
	            }
	        }
	return index;
}

public static Double[] readFromFile(File file) {
	ArrayList<Double> doubleArrayList = new ArrayList<>();
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
    return array;
	}
}