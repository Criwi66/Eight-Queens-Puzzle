/**
 * Represents the eight queens puzzle and checks if a solution is correct
 * @author Criwi66
 *
 */
public class QueensPuzzle {

	public static void main(String[] args) {
		
		printBoard(getExampleSolution());
	}
	/**
	 * 
	 * @return a possible solution for the queens problem
	 */
	public static boolean[][] getExampleSolution() {
		boolean[][] board = new boolean[8][8];
		

		board[0][7] = true;     // true represents a queen
		board[1][3] = true;
		board[2][0] = true;
		board[3][2] = true;
		board[4][5] = true;
		board[5][1] = true;
		board[6][6] = true;
		board[7][4] = true;
		return board;
	}
	/**
	 * 
	 * @param 2 dimensional boolean array. true represents a queen false a empty field.
	 */
	public static void printBoard(boolean[][] board) {
		
		for(int i = 0; board.length > i; i++) {
			
			System.out.print("+-+-+-+-+-+-+-+-+\n"); // separator line
			
			for(int j = 0; board.length > j; j++) {
				
				if(board[i][j] == false) {          
					System.out.print("| ");
				}
				else {
					System.out.print("|Q| ");      
				}
				if(board.length-1 == j) {          
					System.out.print("\n");
				}
			}
		}
		System.out.print("+-+-+-+-+-+-+-+-+");    
	}
	/**
	 * 
	 * @param 2 dimensional boolean array. true represents a queen false, a empty field.
	 */
	public static void checkBoard(boolean[][] board) {
		
		
		if(board == null) {      
			throw new IllegalArgumentException("Board can't be null");
		}
		for(int i = 0; board.length > i; i++) {  
			if(board[i] == null) {
				throw new IllegalArgumentException("Field on board can't be null");
			}
		}
		
		if(board.length != 8) {   
			throw new IllegalArgumentException("Row must be exactly 8");
		}
		for(int i = 0; board.length > i; i++) { 
			if(board[i].length != 8) {
				throw new IllegalArgumentException("Column must be exactly 8");
			}
		}
	}
	/**
	 * 
	 * @param board = 2 dimensional boolean array. true represents a queen, false a empty field.
	 * @param row, col = the exact field you want to have checked.
	 * @return true if the queen can get captured from a another queen.
	 */
	public static boolean canCapture(boolean[][] board, int row, int col) {
//////////////////////////////////////////////////////////////////////////////// Check if there is another queen on the row	
			int rowChecker = 0;
			
			if(board[row][col]) {
				rowChecker = -1;
			}
			else {
				rowChecker = 0;
			}
			
			for(int y = 0; board.length > y; y++){	
			if(board[row][y]) {
				rowChecker += 1;    
				
			}
		}
			if(rowChecker > 0) {  
				return true;        
	   }
//////////////////////////////////////////////////////////////////////////////// Check if there is another queen on the column
			int colChecker = 0;
			
			if(board[row][col]) {
				colChecker = -1;
			}
			else {
				colChecker = 0;
			}
			for(int y = 0; board.length > y; y++) {
				if(board[y][col]) {  
					colChecker += 1;
				}
			}
			if(colChecker > 0) {  
				return true;
			}
//////////////////////////////////////////////////////////////////////////////// Check if there is another queen on the diagonal (left)
			int diagonalCheckerLeft = 0;
			
			if(board[row][col]) {
				diagonalCheckerLeft = -1;
			}
			else {
				diagonalCheckerLeft = 0;
			}
			int x = row;
			int z = col;                                   
			                                             
			while(x != 7 && z != 7) {                     
				   x += 1;                                
				   z += 1;
				   
				   if(board[x][z]) {
					   diagonalCheckerLeft += 1;
				   }
			}
                                                                  
			x = row;
			z = col;                                     
			                                             
			while(x != 0 && z != 0) {                      
				   x -= 1;                                   
				   z -= 1;                                     
				   
				   if(board[x][z]) {
					   diagonalCheckerLeft += 1;
				   }
			}

			if(diagonalCheckerLeft > 0) {    
				return true;
			}
//////////////////////////////////////////////////////////////////////////////// Check if there is another queen on the diagonal (right)
			int diagonalCheckerRight = 0;
			
			if(board[row][col]) {
				diagonalCheckerRight = -1;
			}
			else {
				diagonalCheckerRight = 0;
			}
			x = row;
			z = col;                                         
			                                            
			while(x != 7 && z != 0) {                  
				   x += 1;
				   z -= 1;
				   
				   if(board[x][z]) {
					   diagonalCheckerRight += 1;
				   }
			}
			
			x = row;
			z = col;                                      
			                                            
			while(x != 0 && z != 7) {                    
				   x -= 1;                            
				   z += 1;                            
				   
				   if(board[x][z]) {
					   diagonalCheckerRight += 1;
				   }
			}

			
			if(diagonalCheckerRight > 0) { 
				return true;
			}
			
			return false;  
	}
	/**
	 * 
	 * @param board = 2 dimensional boolean array. true represents a queen, false a empty field.
	 * @return true if the given board is a valid solution for the eight queens puzzle.
	 */
	public static boolean isSolution(boolean[][] board) {
		
		checkBoard(board);   
		
		int queenCount = 0;  
		
		for(int i = 0; board.length > i; i++) {
			for(int j = 0; board.length > j; j++) {
				
				if(board[i][j] == true) {
					queenCount += 1;     
					if(canCapture(board, i, j)) {  
						return false;
					}
				}
				
			}
		}
		if(queenCount != 8) {   // Checking if there are 8 queens on the board
			return false;
		}
		return true;    
	}
} 