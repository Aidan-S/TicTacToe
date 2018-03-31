import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TTT_HC extends Board{

final int SIZE = 19683;
	
	boolean[] winners; // True if the hash string that maps to this index is a winner, false otherwise

	TTT_HC(String s) {
		super(s);
		Scanner file = openWords("TicTacToeWinners.txt");
		winners = new boolean[SIZE];
		String str;
		while(file.hasNextLine()) {
			str = file.nextLine();
			winners[getNum(str.split("(?!^)"))] = true;
		}
		
		
	}
	
	public int getNum(String[] vals) {
		
		
		return 0;
	}
	
	
	public int tttCode() {
	  
		
		
		
		
      return 0;
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
	
	
	
	public static void main(String[] args) throws InterruptedException {
		TTT_HC board = new TTT_HC("Tic Tac Toe");
		
		Scanner file = openWords("TTT_Tests.txt");
		String str;
		while(file.hasNextLine()) {
			str = file.nextLine();


		}
		
		
//		while (true) {   
//			board.displayRandomString();
//			board.setWinnerLabel(board.isWin(board.getBoardString()));
//			Thread.sleep(4000);
//		}
		 
		 
	}


}
