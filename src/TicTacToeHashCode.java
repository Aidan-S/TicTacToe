import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

 boolean [] winners;  // True if the hash string that maps to this index is a winner, false otherwise
    
  TicTacToeHashCode(String s) {
   super(s);
  // TODO Instantiate/fill winners array.  
  }
  
  // TODO - write the myHashCode function.  It must create a unique hashcode for all of the 
  //   possible values the game board (3 ^ 9) and it MUST use the super.charAt(row, col) function
  @Override
    public int myHashCode() {
	  int powerOfThree[][] = new int[][]{{1, 3, 9}, {27, 81, 243}, {729, 2187, 6561}};
	  int sum = 0;
	  for(int r = 0; r < TicTacToe.ROWS; r++) {
		  for(int c = 0; c < TicTacToe.ROWS; c++) {
			  if(super.charAt(r, c) == 'O')
				  sum += powerOfThree[r][c];
			  else
				  sum += 2 * powerOfThree[r][c]; 
		  }  
	  }
      return sum;
   }
   
    public boolean isWin(String s) {
    	
    	
    	
    return true;
    }
  
    
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
      TicTacToeHashCode board = new TicTacToeHashCode ("Tic Tac Toe");
      while (true) {
      
       //TODO this line no longer works
       //  String currentBoard = board.boardValues[(int)(Math.random()* board.boardValues.length)];
         
         board.displayRandomString();
         board.setHashCode(board.myHashCode());
         // TODO Update this line to call your isWin method.
         board.setWinner(TicTacToe.isWin(currentBoard));
         
         Thread.sleep(4000);      
      }
   }
 } 