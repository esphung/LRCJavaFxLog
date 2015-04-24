/*
* @Author: Eric Phung
* @Date:   2015-04-24 01:26:04
* @Last Modified by:   home
* @Last Modified time: 2015-04-24 03:22:07
*/

import java.io.*;
import java.lang.*;
import javafx.collections.*;
import java.util.*;

public class SerialList implements Serializable {

			// static vars
			static final long serialVersionUID = 42L;
			public static List<String> strList = new ArrayList<>();
			public static SerialList mySerialList;

			// instance vars
			ObservableList<String> list;

			// constructors
			public SerialList(){
				//this.loadSerialList();
			} // end null
			public SerialList(ObservableList<String> list){
				for (int i = 0; i <= list.size()-1; i++) {
					strList.add(list.get(i));

				} // end for str copy

				//this.saveSerialList();

			} // end overload

/*
    	public static void main(String[] args) {
    	// import list
			ObservableList<String> myObList = FXCollections.observableArrayList(
				"Judy Carpenter",
				"John Doe",
				"Robert Deniro"
				);

			// create new instance of serial object and pass observable list
    	SerialList serialInfo = new SerialList(myObList);


    	// save serial object
    	//serialInfo.saveSerialList();


    	// load serial object
    	serialInfo.loadSerialList();


    	System.out.print(serialInfo.strList); // print out debug list
    	//System.out.print(strList); // print out debug list

    } // end main
*/


	public void saveSerialList(){
		//SerialList mySerialList = new SerialList();
		try {
			FileOutputStream fo = new FileOutputStream("SavedListInfo.txt");
			ObjectOutputStream obOut = new ObjectOutputStream(fo);
			obOut.writeObject(this.strList);
		} catch (Exception e){
			System.out.println(e.getMessage());
		} // end try
		this.strList.clear();
	} // end saveSerialList

    public void loadSerialList(){
    	//SerialList mySerialList;
    	try {
    		FileInputStream fIn = new FileInputStream("SavedListInfo.txt");
    		ObjectInputStream obIn = new ObjectInputStream(fIn);
    		this.strList = (List)obIn.readObject();
    		//this.strList = mySerialList.strList;
        //System.out.println(this.strList);
    	}catch (Exception e){
    		System.out.println(e.getMessage());
    	} // end try
    	//return mySerialList.strList;
    } // end loadSerialList




} // end class definition