import java.util.*;
import java.io.*;

public class ReadName {

	static int count;

	String filename = "studentDatabase.csv";
	ReadName student;
	List<String> possibleNameList = new ArrayList<>();

	// vars found
	String cNumber;
	String lastName;
	String firstName;
	String major;

	boolean found = false;


	public ReadName(String name, String num){
		name = name.toLowerCase();
		num = num.toLowerCase();
		num = num.replace("c", "");
		this.lastName = lastName;
		this.firstName = firstName;
		this.major = major;


		try {
			File file = new File(filename);
			Scanner input = new Scanner(file);

			input.nextLine(); // ignore first line
			while (input.hasNext()){
				count++;
				String data = input.nextLine(); // gets a whole line
				String[] values = data.split(",");
				//System.out.println(data); // console log

				if (num.length() <= 8) {
					// find c number
					for (int i = 0; i < values.length; i++) {
						if (values[0].toLowerCase().equals(num)) {
							cNumber = values[0];
							lastName = values[1];
							firstName = values[2];
							major = values[3];
							//System.out.println(values[0] + " FOund!");
							this.displayMe();
							count = 0;
							found = true;
							return; // takes first match
							//break; // takes last match

						} // end if
					} // end for
				} // end if

					// find last name key
					for (int i = 0; i < values.length; i++) {
						if (values[1].toLowerCase().equals(name)) {
							cNumber = values[0];
							lastName = values[1];
							firstName = values[2];
							major = values[3];
							//System.out.println(values[0] + " FOund!");
							this.displayMe();
							count = 0;
							//return; // takes first match
							possibleNameList.add(this.firstName);
							//System.out.println(possibleNameList);
							//System.out.println(possibleList.get(0));
							//System.out.println(possibleList.get(1));
							//return; // takes last match
							break; // takes last match
						} // end if

					} // end for


			} // end while

			// if more than one name match found
			if (possibleNameList.size() > 1) {
				System.out.println(possibleNameList + "FOUND!");
				String nameChosen = NameBox.display("Students Found","Which " + lastName + " are you?", possibleNameList);
				this.firstName = nameChosen;
				//System.out.println(nameChosen);
				//System.out.println(lastName);












			} // end if
			return;




		} catch (IOException e){
				System.out.println("Rusty:\tI coudn't read the file!");
				System.out.println("Rusty:\t" + e.getMessage());

		} // end try
		System.out.println("\nSuccessful Scan\nRusty:\tI scanned " + count + " entries!\n");
		count = 0;
		// call confirm box (modal)
		boolean result = ConfirmBox.display("New Student!","Would you like to register?");
/*
				if (student.lastName == null) {
						System.out.println("Rusty:\tI couldn't find you!");
						// call confirm box (modal)
						boolean result = ConfirmBox.display("Student not found!","Please register from the main window! THank you!");
				}

*/

	} // end constructor



/*
	public static void main(String[] args){

		// query student last name
		ReadFile student = new ReadFile("Washington");

		//student.displayMe();


	} // end main
*/


	// output student to console
	public void displayMe(){
		System.out.println("\nRusty:\t I found ..");
		System.out.println(this.lastName);
		System.out.println(this.firstName);
		System.out.println(this.major);
	} // end display









} // end readFile