import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

abstract class Board extends JFrame implements ActionListener {

	private JButton buttons[][];
	private JLabel lblHashCode;
	private JLabel lblWinTitle;

	private String boardString = "";
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: constructor that calls super and sets up the GUI
	 * @param title: the name of the board
	 */
	public Board(String title) {
		super(title);
		setupFrame();
	}
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: set up the label that for the index of the board in the hash code
	 * @param hashcode: the index of the board
	 */
	public void setHashCodeLabel(int hashcode) {
		lblHashCode.setText("" + hashcode);
	}
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: sets the label that dictates if the board is a winner
	 * @param result: whether or not the board is a winner
	 */
	public void setWinnerLabel(String result) {
		lblWinTitle.setText(result);
	}
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: sets the label that dictates if the board is a winner, calling the other overloaded method... for some reason...
	 * @param result: whether or not the board is a winner
	 */
	public void setWinnerLabel(boolean result) {
		if (result)
			setWinnerLabel("Winner");
		else
			setWinnerLabel("Loser");
	}
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: required method because of abstract method, but not used
	 * @param e: unused ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: sets up the first panel
	 */
	JPanel setupPanelOne() {
		JPanel panel = new JPanel();
		JLabel lblHCTitle = new JLabel("Hash Code");
		;
		lblHashCode = new JLabel("" + myHashCode());
		lblWinTitle = new JLabel(""); // Will say either Winner or Loser
		setWinnerLabel(TicTacToe.isWin(boardString));
		panel.setLayout(new FlowLayout());
		panel.add(lblHCTitle);
		panel.add(lblHashCode);
		panel.add(lblWinTitle);
		return panel;
	}
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: sets up the first panel
	 */
	private JPanel setupPanelTwo() {
		JButton b;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(TicTacToe.ROWS, TicTacToe.COLS));
		buttons = new JButton[TicTacToe.ROWS][TicTacToe.COLS];

		int count = 1;

		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = randomXO();
				b = new JButton("" + ch);
				boardString += ch;
				b.setActionCommand("" + r + ", " + c);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) e.getSource();
						btn.setText("" + cycleValue(btn.getText().charAt(0)));
						resetBoardString();
						setHashCodeLabel(myHashCode());
						setWinnerLabel(isWin());

					}
				});
				panel.add(b);
				buttons[r][c] = b;
			}

		return panel;
	}
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: switch through the possible TicTacToe characters(x, o,  )
	 * @param ch: character from the board string
	 * @return: the altered char
	 */
	private static char cycleValue(char ch) {
		switch (ch) {
		case 'x':
			return 'o';
		case 'o':
			return ' ';
		default:
			return 'x';
		}
	}
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: sets up the frame
	 */
	private void setupFrame() {
		JPanel panel2 = new JPanel();

		// Setup Frame
		super.setSize(250, 200);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Setup Panels
		panel2 = setupPanelTwo(); // panelOne displays a value that requires panelTwo to be ready
		super.add(setupPanelOne());
		super.add(panel2);

		super.setVisible(true);
	}

	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: gets a random TicTacToe character 
	 * @return: a usable char (x, o,  )
	 */
	private char randomXO() {
		int rnd = (int) (Math.random() * TicTacToe.CHAR_POSSIBILITIES);
		switch (rnd) {
		case 1:
			return 'x';
		case 2:
			return 'o';
		default:
			return ' ';
		}
	}
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: abstract method for the other classes - method for arranging possible values
	 * @return: the index for the array
	 */
	abstract int myHashCode();
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: abstract method for the other classes - determining if a board string is a winner
	 * @param s: string to be evaluated whether or not it is a winner
	 * @return: if the string is a winner board
	 */
	abstract boolean isWin(String s);
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: abstract method for the other classess - determining if a board string is a winner
	 * @return: if the board is a winner
	 */
	abstract boolean isWin();
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: returns the value at a position on the board
	 * @param row: the row to look at
	 * @param col: the column to look at
	 * @return: the char at that index
	 */
	public char charAt(int row, int col) {
		String value = buttons[row][col].getText();
		if (value.length() > 0)
			return value.charAt(0);
		else
			return '*';
	}
   
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: returns the value at a position in the board string
	 * @param s: the boardstring of the board
	 * @param row: the row to look at
	 * @param col: the column to look at
	 * @return: the char at that index
	 */
   public char charAt(String s, int row, int col) {
     int pos = row * TicTacToe.COLS + col;
     if (s.length() >= pos)
       return s.charAt(pos);
     else
       return '*';   
   }

   
   /**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: sets the board with a string
	 * @param s: string of nums or TicTacToe letters to set the board
	 */
	public void show(String s) {
		int pos = 0;
		String letter;
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = s.charAt(pos);
				switch (ch) {
				case '1':
					letter = "x";
					break;
				case '2':
					letter = "o";
					break;
				case '0':
					letter = " ";
					break;
				default:
					letter = "" + ch;
				}
				buttons[r][c].setText(letter);
				pos++;
			}
	}

	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: clear the board
	 */
	public void resetBoardString() {
    boardString = "";
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				boardString += buttons[r][c].getText();
			}
	}
	
	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: sets the boardstring and then show it
	 * @param s: string to set
	 */
	public void setBoardString(String s) {
		boardString = s;
		show(s);
	}

	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: getter for the boardstring
	 * @return: the board's boardstring
	 */
	public String getBoardString() {
		return boardString;
	}

	
	/**
	 * @author Aidan-S
	 * date: March 30th, 2018
	 * method: display a random tictactoe board
	 */
	public void displayRandomString() {
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = randomXO();
				boardString += ch;
				buttons[r][c].setText("" + ch);
			}
		setHashCodeLabel(myHashCode());
		setWinnerLabel(isWin());
	}

}