import java.util.Arrays;

public class TicTacToe {
  public final static int ROWS = 3;
  public final static int COLS = 3;
  public final static int POSSIBILITIES = (int) Math.pow(3,9);
  public final static int CHAR_POSSIBILITIES = 3; // x, o or space
  
  /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: counts the number of a certain char in an array
	 * @param ch: character being searched for
	 * 		  b: char array being searched
	 * @return: number of that char
	 */
  private static int numChars(char[][] b, char ch) {
  int total = 0;
    for (int r = 0; r < ROWS; r++)
      for (int c = 0; c < COLS; c++)
        if (ch == b[r][c]) 
        total++;
    return total;
  }
  
  
  /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the given array is a valid tic tac toe board
	 * @param board: array that is being evaluated
	 * @return: whether or not the board is valid
	 */
  public static boolean valid(char[][] board) {
  // Ensure there are at least 3 xs and 2 os, or 3 os and 2 xs
  // Make sure there are at least one more x or one more o
    int numX = numChars(board, 'x');
    int numO = numChars(board, 'o');
    if (! (numX > 2 || numO > 2)) return false;
    if ((numX == numO + 1) || (numO == numX + 1)) return true;
    return false;
  }
  
  
  /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: converts char array into a string
	 * @param b: array being converted
	 * @return: string that represents the array
	 */
   public static String boardToString(char[][] b) {
     String result = "";
     for (int r = 0; r < ROWS; r++) {
       for (int c = 0; c < COLS; c++) 
         result += b[r][c];
       }
     return result;
   }
   
   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: converts string into a char array
	 * @param board: string being converted
	 * @return: array that represents the string
	 */
    public static char[][] stringToBoard(String board) {
      char[][] b = new char[ROWS][COLS];
     int index = 0;
     for (int r = 0; r < ROWS; r++) {
       for (int c = 0; c < COLS; c++) 
         b[r][c] = whichLetter(board.charAt(index++));
       }
     return b;
   }

   
    
    /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: converts the char into X, o, or " " if its 0-2
	 * @param ch: char being turned into a X, o, or " "
	 * @return: the new char
	 */
   public static char whichLetter(char ch) {
      switch (ch) {
         case '1' : return 'x';
         case '2' : return 'o';
         case '0'  : return ' ';
         default: return ch;
       }
   }
     
   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: making board from string while also turning nums in the board into x/o/" " chars
	 * @param s: string of chars to be put into board
	 * @return: char array made from s
	 */
   public static char[][] makeBoard(String s) {
   char[][] b = new char[ROWS][COLS];
   int ch = 0;
   for (int r = 0; r < ROWS; r++)
     for (int c = 0; c < COLS; c++){         
       b[r][c] = whichLetter(s.charAt(ch));
       ch++;
     }
   return b;
   }
   
   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: Add 1 to the last char, adjusting all the rest of the characters as necessary
	 * @param s: a 9 character string, composed of 0s, 1s, and 2s
	 * @return: new, adjusted string
	 */
      private static String addOne(String s) {
    	  boolean carry = false;
    	  char ch[] = s.toCharArray();
    	  ch[ch.length-1] =  (char)((int)(ch[ch.length-1])+1);
    	  for (int n = ch.length-1; n >=0; n--) {
    		  if (carry) ch[n] = (char)((int)(ch[n])+1);
    		  if (ch[n] == '3') {
    			  carry = true;
    			  ch[n] = '0';
    		  }
    		  else
    			  carry = false;      
    	  }
    	  return new String(ch);
      }
   
      
      /**
  	 * @author Aidan-S
  	 * date: March 30th, 2018
  	 * method: fills an array with 3 strings of 9, representing the 3 possible tictactoe chars
  	 * param: none
  	 * @return: array of {000000000, 111111111, 222222222}
  	 */
   public static String[] fillValues() {
      String strBoard = "000000000";
      String[] values = new String[POSSIBILITIES];
      int index = 0;
      values[index++] = strBoard;
      while (!strBoard.equals("222222222") ) {
         strBoard = addOne(strBoard);
         values[index++] = strBoard;
      }
      return values;
   }
   
   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the board has a diagonal win
	 * @param b: board to examine
	 * @return: whether or not there is a diagonal win
	 */
   private static boolean diagonalWin(char[][] board) {
   
     if ((board[0][0] == 'x' && board[1][1] == 'x' && board[2][2] == 'x') || 
         (board[0][0] == 'o' && board[1][1] == 'o' && board[2][2] == 'o')) {
         return true;
         }
     else
       if ((board[0][2] == 'x' && board[1][1] == 'x' && board[2][0] == 'x') ||
           (board[0][2] == 'o' && board[1][1] == 'o' && board[2][0] == 'o')) {
           return true;
        }
     return false;
   }
   
   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the board has a row win
	 * @param b: board to examine
	 * @return: whether or not there is a row win
	 */
   private static boolean rowWin(char[][] board) {
      char ch;
      for (int r = 0; r < ROWS; r++) {
        ch = board[r][0];
        for (int c = 0; c < COLS; c++) 
          if (ch != board[r][c]) return false;
        } 
        return true;
      } 
   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the board has a column win
	 * @param b: board to examine
	 * @return: whether or not there is a column win
	 */
   private static boolean colWin(char[][] board) {
      char ch;
      for (int c = 0; c < COLS; c++) {
        ch = board[0][c];
        for (int r = 0; r < ROWS; r++) 
          if (ch != board[r][c]) return false;
        } 
        return true;
      } 

   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the board is a winner by calling the other winning methods
	 * @param b: board to examine
	 * @return: whether or not this is a winning board
	 */
   public static boolean isWin(char[][]b) {
     return valid(b) && (rowWin(b) || colWin(b) || diagonalWin(b));
     }
     
   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: determines if the string is a winning board by calling the other winning methods
	 * @param s: string to examine
	 * @return: whether or not this is a winning string
	 */
   public static boolean isWin(String s) {
     char[][] b = stringToBoard(s);
     return isWin(b);
     }
}
