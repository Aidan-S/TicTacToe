import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Scanner;

public class TicTacToeHashMap  {

// TODO Define a hash map to store the winning strings as Key and true as Value
<<<<<<< HEAD
	HashMap map;

=======
	HashMap WinMap;
	
>>>>>>> branch 'master' of https://github.com/Aidan-S/TicTacToe
   TicTacToeHashMap() {
   // TODO Instantiate/fill your HashMap ... pay attention to initial capacity and load values
<<<<<<< HEAD
	   map = new HashMap(19683, 1);
=======
	   WinMap = new HashMap(19683);
>>>>>>> branch 'master' of https://github.com/Aidan-S/TicTacToe
   }

// TODO This method uses reflect to investigate the objects inside the HashMap
// You should be able to update this with your information and determine 
// Information about capacity (different than size()) and what is stored in the cells

   private int capacity() throws NoSuchFieldException, IllegalAccessException {
      Field tableField = HashMap.class.getDeclaredField("table");
      tableField.setAccessible(true);
<<<<<<< HEAD
      Object[] table = (Object[]) tableField.get(map);
=======
      Object[] table = (Object[]) tableField.get(WinMap);
>>>>>>> branch 'master' of https://github.com/Aidan-S/TicTacToe
      return table == null ? 0 : table.length;   
   }
   
   /**
	 * @author Aidan-S
	 * date: March 23th, 2018
	 * method: create a scanner that I can use to read in Prof. Kelly's files
	 * @param fname: the name of the file to read
	 * @param out: the file to print to
	 * @return: the scanner for the given file
	 */
	public static Scanner openWords(String fname) {
		File file = new File(fname);
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("This isnt there");
			return null;
		}
		return input;	
	}
   
   
   
   // TODO using the same code to get the table of entries as in the capacity method,
   // create a method that will evaluate the table as directed in the assignment.
   // note - if an entry is not null, then it has a value, it may have more than one value
   // see if you can determine how many values it has.  Using the debugger will assist.

   
   public static Scanner openWords(String fname) {
		File file = new File(fname);
		Scanner input = null;
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException ex) {
			System.out.println("This isnt there");
			return null;
		}
		return input;	
	}
   
   
   
   public static void main(String[] args) throws java.io.FileNotFoundException,
                                              NoSuchFieldException, 
                                              IllegalAccessException {

<<<<<<< HEAD
      

=======
      TicTacToeHashMap m = new TicTacToeHashMap();
      Scanner file = openWords(args[0]);
>>>>>>> branch 'master' of https://github.com/Aidan-S/TicTacToe
  // TODO read in and store the strings in your hashmap, then close the file
<<<<<<< HEAD

      Scanner file = openWords(args[0]);
      TicTacToeHashMap m = new TicTacToeHashMap(); 
=======
>>>>>>> branch 'master' of https://github.com/Aidan-S/TicTacToe
      
      
  // TODO print out the capacity using the capcity() method
  // TODO print out the other analytical statistics as required in the assignment
  
   }

}