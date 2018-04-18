import java.util.Scanner;
public class Loa {

	// The size of the board
	private static int [][] Board;
	private static int size;
	private static int player;

	// The pieces
	public static final int INVALID = -1;
	public static final int EMPTY = 0;
	public static final int WHITE = 1;
	public static final int BLACK = 2;

	// The board
	private static String[] Board_Display;
	private static char[] alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public static void main(String[]args){

		size = Integer.parseInt(args[0]);
		int mode = Integer.parseInt(args[1]);

		if(args.length<2){

			System.out.println("ERROR: too few arguments");
			System.exit(0);

		}
		if((size<4) || (size>16)){

			System.out.println("ERROR: illegal size");
			System.exit(0);

		}
		if((mode<0)||(mode>2)) {

			System.out.println("ERROR: illegal mode");
			System.exit(0);

		}

		if(mode==0){



		}

		if(mode==1){



		}

		if(mode==2){



		}

	}

int size = 8;
/*System.out.println("Choose a board size between 4 and 16");
		Scanner scanner = new Scanner(System.in);
    int params = new Integer(scanner.nextInt());

		size = params;

     while ((params<4) || (params>16)){

       System.out.println("Invalid size, choose a board size between 4 and 16");
       params = new Integer(scanner.nextInt());

     }

    String Board_Display[] = new String[params+1];
    int Board[][] = new int [params][params];


    for (int h = 0; h < params; h++) {

			for (int i = 0; i < params; i++) {

        if(((h==0)&&(i==0)) || ((h==params-

      System.out.println(" ");1)&&(i==0)) || ((h==0)&&(i==params-1)) || ((h==params-1)&&(i==params-1))){

          Board[h][i]= EMPTY;

        }else if((h==0) || (h==params-1)){

          Board[h][i] = BLACK;

        }else if((i==0) || (i==params-1)){

          Board[h][i] = WHITE;

        }
      }
    }

		System.out.println(" ");

    for (int k = 0; k < params+1; k++) {

			 for (int p = 0; p < params+1; p++) {

          if ((k==0)&&(p==0)){

            Board_Display[k] = " ";

          }else if(k==0){

            Board_Display[k] = Board_Display[k] + " "+ alph[p-1];

          }

          if(k>0){

            Board_Display[k] = String.valueOf(alph[params - k])+ " ";

            for(int j=0;j<params;j++){

              switch (Board[k-1][j]){

                case EMPTY : Board_Display[k] = Board_Display[k] + ". ";
                         break;
                case WHITE : Board_Display[k] = Board_Display[k] + "W ";
                         break;
                case BLACK : Board_Display[k] = Board_Display[k] + "B ";
                         break;

              }
            }
          }
        }

      System.out.println(Board_Display[k]);

    }
		moveInput();
*/



	public static void moveInput(){

		boolean valid;
		valid = false;

		while(valid == false){

			System.out.println(" ");
			System.out.println("Make your move");
			Scanner scannerMI = new Scanner(System.in);
			String move = new String(scannerMI.nextLine());
			move = move.toUpperCase();
			char[] letters = move.toCharArray();

			//if

			if(move.length()!=4){

				valid = false;
				System.out.println("Invalid number of coordinates");

			}else{

				int fromCol = (int) letters[0]-65;
				int fromRow = (int) letters[1]-65;
				int toCol = (int) letters[2]-65;
				int toRow = (int) letters[3]-65;

				if(makeMove(1,fromRow,fromCol,toRow,toCol)==true){

					valid = true;
					System.out.println("Valid");

				}else{

					valid = false;
					System.out.println("Invalid");

				}
			}
		}
  }

	/*
	 * Function that returns the piece currently on the board at the specified
	 * row and column.
	 */

	public static int getPiece(int row, int col) {
		if ((row < 0) || (row >= size)) {
			return INVALID;
		}
		if ((col < 0) || (col >= size)) {
			return INVALID;
		}
		return board[row][col];
	}

	/*
	 * Make a move. Check that the move is valid. If not, return false. If
	 * valid, modify the board thSystem.out.println("Make your move");
		Scanner scanner = new Scanner(System.in);
    String move = new String(scanner.nextLine());at the piece has moved from (fromRow, fromCol)
	 * to (toRow, toCol).
	 */

	public static boolean testMove(int player, int fromRow, int fromCol, int toRow, int toCol) {


		while(fromCol>size){

			System.out.println("Your starting vertical coodirnate is too large.");
			return false;

		}

		while(fromRow>size){

			System.out.println("Your starting horizontal coodirnate is too large.");
			return false;

		}

		while(toCol>size){

			System.out.println("Your target vertical coodirnate is too large.");
			return false;

		}

		while(toRow>size){

			System.out.println("Your target horizontal coodirnate is too large.");
			return false;

		}

		return true;
	}

	/*
	 * Return the size of the board.
	 */

	public static int getSize() {
		return size;
	}

	/*
	 * Check if the given move is valid.  This entails checking that:
	 *
	 * - the player is valid
	 *
	 * - (fromRow, fromCol) is a valid coordinate
	 *
	 * - (toRow, toCol) is a valid coordinate
	 *
	 * - the from square contains a marker that belongs to the player
	 *
	 * - check that we are moving a "legal" number of squares
	 */

	public static boolean isValidMove(int player, int fromRow, int fromCol, int toRow, int toCol) {
		/*--------------------------------------------
		 * FILL IN THE CODE FOR CHECKING A MOVE
		 *-------------------------------------------*/
		return false;
	}

	/*
	 * Count the number of markers (non-empty squares) in the specified row.
	 */



	public static int rowCount(int row) {
		/*--------------------------------------------
		 * FILL IN THE CODE FOR COUNTING THE MARKER IN A ROW
		 *-------------------------------------------*/
		return 0;
	}

	/*
	 * Count the number of markers (non-empty squares) in the specified column.
	 */
	public static int colCount(int col) {
		/*--------------------------------------------
		 * FILL IN THE CODE FOR COUNTING THE MARKER IN A COLUMN
		 *-------------------------------------------*/
		return 0;
	}

	/*
	 * Count the number of markers (non-empty squares) in the diagonal that runs
	 * from the north-east corner to the south-west corner of the board, and
	 * that passes through the specified row and column.
	 */
	public static int diagNortheastCount(int row, int col) {
		/*--------------------------------------------
		 * FILL IN THE CODE FOR COUNTING THE MARKER IN A DIAGONAL
		 *-------------------------------------------*/
		return 0;
	}

	/*
	 * Count the number of markers (non-empty squares) in the diagonal that runs
	 * from the north-west corner to the south-east corner of the board, and
	 * that passes through the specified row and column.
	 */
	public static int diagNorthwestCount(int row, int col) {
		/*--------------------------------------------
		 * FILL IN THE CODE FOR COUNTING THE MARKER IN A DIAGONAL
		 *-------------------------------------------*/
		return 0;
	}

	/*public static boolean hasWon(int player) {
		return Util.isConnected(board, player);
	}*/

}
