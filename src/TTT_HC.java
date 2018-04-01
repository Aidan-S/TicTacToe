import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TTT_HC extends Board{

final int SIZE = 13000;
	
	tictactoeNode[] winners; // True if the hash string that maps to this index is a winner, false otherwise
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: constructor to set up the hashmap by reading in the tictactoe string text files and then chaining any collisions
	 * @param s: string for the title
	 * @return: none
	 */
	TTT_HC(String s) {
		super(s);
		Scanner file = openWords("TicTacToeWinners.txt");
		winners = new tictactoeNode[SIZE];
		String str;
		int pos;
		tictactoeNode t;
		tictactoeNode k;
		while(file.hasNextLine()) {
			str = file.nextLine();
			pos = getNum(str.split("(?!^)"));
			t = new tictactoeNode(null, str, true);
			if(winners[pos] == null) {
				winners[pos] = t;
			}else{
				if(winners[pos].getNext() == null) {
					winners[pos].setNext(t);
				}else{
					k = winners[pos].getNext();
					while(k.getNext() != null) {
					k = k.getNext();
					}
					k.setNext(t);
				}
			}
		}
		
		for(int i = 0; i < winners.length; i++) {
			if(winners[i] == null) {
				winners[i] = new tictactoeNode(null, null, false); 
			}
		}
		
			
	}
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determine the index in the hash map from an array of string values
	 * @param vals: string array of tictactoe values
	 * @return: the index of this particular board
	 */
	public int getNum(String[] vals) {
		int sum = 0;
		int mult2[] = new int[]{1, 9, 25, 49, 81, 121, 169, 225, 289};
		int mult3[] = new int[]{1, 27, 125, 343, 729, 1331, 2197, 3375, 4913};
		for(int i = 0; i < vals.length; i++) {
			if(vals[i].equals("x")) {
				sum += mult3[i];
			}else if(vals[i].equals("o")) {
				sum += mult2[i] + 1;
			}
		}
		
		
		return sum;
	}
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determine the index in the hash map of the board
	 * param: none
	 * @return: the index of this board
	 */
	public int tttCode() {
		int mult2[][] = new int[][]{{1, 9, 25}, {49, 81, 121}, {169, 225, 289}};
		int mult3[][] = new int[][]{{1, 27, 125}, {343, 729, 1331}, {2197, 3375, 4913}};
		  int sum = 0;
		  for(int r = 0; r < TicTacToe.ROWS; r++) {
			  for(int c = 0; c < TicTacToe.ROWS; c++) {
				  if(super.charAt(r, c) == 'x') {
					  sum += mult3[r][c];
			  }else{ 
					  if(super.charAt(r, c) == 'o') {
						  sum += mult2[r][c]; 
					  }
			      }
			  }  
		  }
	      return sum;
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
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: main method that reads the tester file and tests if each line is a winning board
	 * @param args: string arguments array
	 * return: none
	 * @throws java.lang.InterruptedException if something interrupts the GUI 
	 */
	public static void main(String[] args) throws InterruptedException {
		TTT_HC board = new TTT_HC("Tic Tac Toe");
		

		
		for(int i = 0; i < board.winners.length; i++) {
			System.out.println(board.winners[i]);
		}
		

		 
		 
	}

	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: required to extend board
	 * @return: integer index of board in theory, but it isnt used
	 */
	@Override
	int myHashCode() {	
		return 0;
	}

	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the board is a winner by searching the winner array
	 * @param s: string to examine if its a winner
	 * @return: whether or not this is a winning board
	 */
	@Override
	public boolean isWin(String s) {
		if(winners[getNum(s.split("(?!^)"))].getValue()) {
			return true;
		}else {
			return false;
		}
    }

	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the board is a winner by searching the winner array
	 * param: none
	 * @return: whether or not this is a winning board
	 */
	@Override
	public boolean isWin() {
    if(isWin(this.getBoardString()))
    	return true;
    else
		return false;
    }


}
