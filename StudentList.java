import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String students;
	public static String names[];

	public static Constant constant = new Constant();

	public static void read() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(constant.FileNmae)));
			students = reader.readLine();
			names = students.split(constant.split);
		} catch (Exception e) {

		}
	}

	public static void write(String update) {
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter(constant.FileNmae, false));
			write.flush();
			write.write(update);
			write.close();
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) {

//		Check arguments
		if(args.length == 0){
			System.out.println(constant.Error);
		}
		else if(args[0].equals(constant.showNames)) {
			System.out.println(constant.dataLoad);
			read();
			for(String name : names) {
				System.out.println(name);
			}
			System.out.println(constant.dataLoaded);
		}
		else if(args[0].equals(constant.randomName)) {
			System.out.println(constant.dataLoad);
			read();
			Random random = new Random();
			int index = random.nextInt(names.length);
			System.out.println(names[index]);
			System.out.println(constant.dataLoaded);
		}
		else if(args[0].contains(constant.addName)) {
			System.out.println(constant.dataLoad);
			read();
			String newname = args[0].substring(1);
			Date date = new Date();
			String dateformate = constant.dateFormat;
			DateFormat dateFormat = new SimpleDateFormat(dateformate);
			String finaldate = dateFormat.format(date);
			write(students + constant.split + newname + constant.lastUpdate + finaldate);
			System.out.println(constant.dataLoaded);
		}
		else if(args[0].contains(constant.query)) {
			System.out.println(constant.dataLoad);
			read();
			boolean done = false;
			String newname = args[0].substring(1);
			for(int idx = 0; idx<names.length && !done; idx++) {
				if(names[idx].equals(newname)) {
					System.out.println(constant.Found);
						done=true;
				}
			}
			System.out.println(constant.dataLoaded);
		}
		else if(args[0].contains(constant.countWords)) {
			System.out.println(constant.dataLoad);
			read();
			char characters[] = students.toCharArray();
			int count = 1;
			for(char character : characters) {
				if(character ==' ') {
					count++;
				}
			}
			System.out.println(count + constant.wordsFound );
			System.out.println(constant.dataLoaded);
		}
	}
}