
import java.util.ArrayList;

public class Task1 {
	public static void NewCirc(ArrayList<Integer> CircArr, int n) {
		int c = 1;
		for (int i = 0; i < n; i++) 
        {
			CircArr.add(c);
			c ++;
        }
	}
	
	public static void PrintList(ArrayList<Integer> CircArr) {
		for (int i = 0; i < CircArr.size(); i++) 
        {
			System.out.println(CircArr.get(i));
        }
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> CircArr = new ArrayList<Integer>();
		ArrayList<Integer> Path = new ArrayList<Integer>();
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		int q = m*n;
		NewCirc(CircArr, n);
		//PrintList(CircArr);
		int path = 0;
		int flag = 0;
		while (flag != 1) {
		for (int j = 0; j < q; j=j+m-1) 
		    {
				if (j > CircArr.size()) {
					NewCirc(CircArr, n);
				} 
				if (j == CircArr.size()) {
					flag = 1;
					break;
				}
				path = CircArr.get(j);
				Path.add(path);
			}
		}
		PrintList(Path);
	}
}
