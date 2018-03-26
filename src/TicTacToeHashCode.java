
//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	boolean[] winners; // True if the hash string that maps to this index is a winner, false otherwise

	TicTacToeHashCode(String s) {
		super(s);
    //TODO Instantiate winners array
		}

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

	@Override
	public boolean isWin(String s) {
		if(s.indexOf("winner") > -1) {
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
    
	public static void main(String[] args) throws InterruptedException {
		TicTacToeHashCode board = new TicTacToeHashCode("Tic Tac Toe");
		 while (true) {
		   board.displayRandomString();
		   Thread.sleep(4000);
		 }
	}

}