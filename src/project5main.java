import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class project5main {
	
public static void main(String[] args)throws FileNotFoundException {
		
		
		Scanner reader = new Scanner(new File(args[0]));
		reader.useLocale(Locale.US);
		PrintStream writer = new PrintStream(new File(args[1]));
		ArrayList<String> types = new ArrayList<>();
		
		
	     while (reader.hasNext( "[A-Za-z]+")) {
	    	 
			types.add(reader.next());
		}
	     int taskCount = types.size();
	     
	     reader.nextLine();
	     
		int[] machineA = new int[taskCount];
		int[] machineB = new int[taskCount];
		int[] startingTimes = new int[taskCount];
		int[] endingTimes = new int[taskCount];
		int[] profits = new int[taskCount];
		ArrayList<Task> tasks =  new ArrayList<>(taskCount);
		
		
		for (int i = 0; i < taskCount; i++) {
			machineA[i] = reader.nextInt();
			
		}
		reader.nextLine();
		for (int i = 0; i < taskCount; i++) {
			machineB[i] = reader.nextInt();
			
		}
		reader.nextLine();
		for (int i = 0; i < taskCount; i++) {
			profits[i] = reader.nextInt();
		}
		reader.nextLine();
		for (int i = 0; i < taskCount; i++) {
			startingTimes[i] = reader.nextInt();
		}
		
		
		for (int i = 0; i < taskCount; i++) {
			if (types.get(i).equals("l")) {
				endingTimes[i] = startingTimes[i] + machineB[i];
			}else if (types.get(i).equals("s")) {
				endingTimes[i] = startingTimes[i] + machineA[i];
			}
			tasks.add(new Task(startingTimes[i], endingTimes[i], profits[i]));
		}
		
		tasks.sort(new TaskComparator());
		int[] maxProfit = new int[taskCount];
		int tmp;
		maxProfit[0] = tasks.get(0).getProfit();
		for (int i = 1; i < taskCount; i++) {
			tmp = 0;
			maxProfit[i] = tasks.get(i).getProfit();
			int j = i-1;
			while (j>=0) {
				if (tasks.get(j).getEndTime() <= tasks.get(i).getStartTime()) {
					tmp = maxProfit[j];
					break;
				}
				j--;
			}
			maxProfit[i] = Math.max(maxProfit[i-1], tmp+tasks.get(i).getProfit());
		}
		writer.print(maxProfit[taskCount-1]);
}
}

class TaskComparator implements Comparator<Task>{
	public int compare(Task t1, Task t2) {
		return t1.getEndTime()-t2.getEndTime();
	}
	
}