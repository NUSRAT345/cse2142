import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String students;
	public static String names[];

	public static Constant constant = new Constant();

	//Reading the text from student.txt

	public static void read() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(constant.FileNmae)));
			students = reader.readLine();
			names = students.split(constant.split);
		} catch (Exception e) {

		}
	}
   	//Writing the update text

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

		//Check arguments

		if(args.length == 0){
			//Invalid input formate

			System.out.println(constant.Error);
		}
		//Display all student names

		else if(args[0].equals(constant.showNames)) {
			System.out.println(constant.dataLoad);
			read();
			for(String name : names) {
				System.out.println(name);
			}
			System.out.println(constant.dataLoaded);
		}
		//Display a random student

		else if(args[0].equals(constant.randomName)) {
			System.out.println(constant.dataLoad);
			read();
			Random random = new Random();
			System.out.println(names[random.nextInt(names.length)]);
			System.out.println(constant.dataLoaded);
		}
		//Add a new name

		else if(args[0].contains(constant.addName)) {
			System.out.println(constant.dataLoad);
			read();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat(constant.dateFormat);
			write(students + constant.split + args[0].substring(1) + constant.lastUpdate + dateFormat.format(date));
			System.out.println(constant.dataLoaded);
		}
		//Searching student name

		else if(args[0].contains(constant.query)) {
			System.out.println(constant.dataLoad);
			read();
			for(int idx = 0; idx<names.length; idx++) {
				if(names[idx].equals(args[0].substring(1))) {
					System.out.println(constant.Found);
					break;
				}
			}
			System.out.println(constant.dataLoaded);
		}
		//count the student name

		else if(args[0].contains(constant.countWords)) {
			System.out.println(constant.dataLoad);
			read();
			System.out.println(names.length + constant.wordsFound );
			System.out.println(constant.dataLoaded);
		}
		else {
			//invalid input formate
			
			System.out.println(constant.Error);
		}
	}
}