import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	boolean[] winners; // True if the hash string that maps to this index is a winner, false otherwise

	TicTacToeHashCode(String s) {
		super(s);
		Scanner file = openWords("TicTacToeWinners.txt");
		winners = new boolean[19683];
		String str;
		while(file.hasNextLine()) {
			str = file.nextLine();
			winners[getNum(str.split("(?!^)"))] = true;
		}
		for (int i = 0; i < winners.length; i++) { 
			if(winners[i] != true)
				winners[i] = false;
		}
		
	}
	
	public int getNum(String[] vals) {
		int i = 0;
		int sum = 0;
		int powerOfThree[] = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561};
		
		while(i < vals.length) {
			if(vals[i].equals("o")) {
				sum += 2 * powerOfThree[i];
			}else if(vals[i].equals("x")) {
				sum +=  powerOfThree[i];
			}
			
			i++;
		}
		
		return sum;
	}
	
	@Override
    public int myHashCode() {
	  int powerOfThree[][] = new int[][]{{1, 3, 9}, {27, 81, 243}, {729, 2187, 6561}};
	  int sum = 0;
	  for(int r = 0; r < TicTacToe.ROWS; r++) {
		  for(int c = 0; c < TicTacToe.ROWS; c++) {
			  if(super.charAt(r, c) == 'x')
				  sum += powerOfThree[r][c];
			  else
				  sum += 2 * powerOfThree[r][c]; 
		  }  
	  }
      return sum;
   }

	@Override
	public boolean isWin(String s) {
		if(winners[getNum(s.split("(?!^)"))]) {
			return true;
		}else {
			return false;
		}
    }
    
	@Override
	public boolean isWin() {
    if(isWin(this.getBoardString()))
    	return true;
    else
		return false;
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
		TicTacToeHashCode board = new TicTacToeHashCode("Tic Tac Toe");
		
		board.setBoardString("x ox ox  ");
		
		System.out.println(board.isWin());
//		while (true) {
//		   board.displayRandomString();
//		   board.setWinnerLabel(board.isWin(board.getBoardString()));
//		   Thread.sleep(4000);
//		 }
		 
		 
	}

}