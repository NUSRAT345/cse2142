import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String students;
	public static String names[];

	public static void read() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			students = reader.readLine();
			names = students.split(", ");
		} catch (Exception e) {

		}
	}

	public static void write(String update) {
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter("students.txt", false));
			write.flush();
			write.write(update);
			write.close();
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {

//		Check arguments
		if(args.length == 0){
			System.out.println("Invalid");
		}
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");
			read();
			for(String name : names) {
				System.out.println(name);
			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			read();
			Random random = new Random();
			int index = random.nextInt(names.length);
			System.out.println(names[index]);
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")) {
			System.out.println("Loading data ...");
			read();
			String newname = args[0].substring(1);
			Date date = new Date();
			String dateformate = "dd/mm/yyyy-hh:mm:ss a";
			DateFormat dateFormat = new SimpleDateFormat(dateformate);
			String finaldate = dateFormat.format(date);
			write(students + ", " + newname + "\nList last updated on " + finaldate);
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");
			read();
			boolean done = false;
			String newname = args[0].substring(1);
			for(int idx = 0; idx<names.length && !done; idx++) {
				if(names[idx].equals(newname)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");
			read();
			char characters[] = students.toCharArray();
			int count = 1;
			for(char character : characters) {
				if(character ==' ') {
					count++;
				}
			}
			System.out.println(count +" word(s) found " );
			System.out.println("Data Loaded.");				
		}
	}
}