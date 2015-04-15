/*
* @Author: Eric Phung
* @Date:   2015-04-13 23:02:29
* @Last Modified by:   Eric Phung
* @Last Modified time: 2015-04-13 23:15:22
*/

import java.io.*;
public class WriteFile{


	public WriteFile(String cNumber,String lastName,String firstName,String major){
		try {
		    FileWriter outFile = new FileWriter("studentDatabase.csv", true);
		    PrintWriter output = new PrintWriter(outFile);

		    // newline csv dialect
		    output.print("\n");

		    output.print(cNumber);
		    output.print(",");

		    output.print(lastName);
		    output.print(",");

		    output.print(firstName);
		    output.print(",");

		    output.print(major);


		    output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} // end try
	} // end constructor



/*
		public static void main(String[] args){
			new WriteFile("01234567","Doe","John","WhatEver Tech");
	} // end main

*/


} // end class def