import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Scanner;


public class TicTacToeHashMap  {

//stores the winning strings as Key and true as Value
	HashMap WinMap;
	
	
   TicTacToeHashMap() {
   // TODO Instantiate/fill your HashMap ... pay attention to initial capacity and load values
	   WinMap = new HashMap(19683);

   }


// TODO This method uses reflect to investigate the objects inside the HashMap
// You should be able to update this with your information and determine 
// Information about capacity (different than size()) and what is stored in the cells


   private int capacity() throws NoSuchFieldException, IllegalAccessException {
      Field tableField = HashMap.class.getDeclaredField("table");
      tableField.setAccessible(true);
      Object[] table = (Object[]) tableField.get(WinMap);
      return table == null ? 0 : table.length;   
   }

   

	
	
   // TODO using the same code to get the table of entries as in the capacity method,
   // create a method that will evaluate the table as directed in the assignment.
   // note - if an entry is not null, then it has a value, it may have more than one value
   // see if you can determine how many values it has.  Using the debugger will assist.


   public static void main(String[] args) throws java.io.FileNotFoundException,
                                              NoSuchFieldException, 
                                              IllegalAccessException {

      TicTacToeHashMap m = new TicTacToeHashMap();
      Scanner file = openWords(args[0]);
  // TODO read in and store the strings in your hashmap, then close the file
  // TODO print out the capacity using the capcity() method
  // TODO print out the other analytical statistics as required in the assignment
 
   }
}