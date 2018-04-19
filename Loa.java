import java.util.Scanner;
public class Loa {

	// The size of the board
	private static int [][] Board;
	private static int size;
	private static int player;
  private static boolean endgame;
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
			testMode();
		}

		if(mode==1){
			SPM();
		}

		if(mode==2){
			//MPM();
		}

	}

	public static void SPM(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a board size between 4 and 16");
		int params = new Integer(scanner.nextInt());

		 while ((params<4) || (params>16)){

		    System.out.println("Invalid size, choose a board size between 4 and 16");
		    params = new Integer(scanner.nextInt());

		 }

		 System.out.println("To you want to play as white or black?");
		 System.out.println("Enter 1/2");
		 player = new Integer(scanner.nextInt());
		 boolean OT = false;

		 while(OT = false){

			 if(player==1){

				 OT = true;
			 }else if (player==2){

				 OT = true;
			 }else{

				 System.out.println("Invalid input: Enter 1 or 2");
				 player = new Integer(scanner.nextInt());
			 }
		 }

		String Board_Display[] = new String[params+1];
		int Board[][] = new int [params][params];

    //standardize and initiate board numbers
    for (int h = 0; h < params; h++) {

      for (int i = 0; i < params; i++) {

        if(((h==0)&&(i==0)) || ((h==params-1)&&(i==0)) || ((h==0)&&(i==params-1)) || ((h==params-1)&&(i==params-1))){

          Board[h][i]= EMPTY;

        }else if((h==0) || (h==params-1)){

          Board[h][i] = BLACK;

        }else if((i==0) || (i==params-1)){

          Board[h][i] = WHITE;

        }
      }
    } // end of board initialization

    System.out.println(" ");

    //display initial board
    for (int k = 0; k < params+1 ; k++) {

       for (int p = 0; p < params+1; p++) {

          if ((k==0)&&(p==0)){

            Board_Display[k] = " ";

          }else if(k==0){

            Board_Display[k] = Board_Display[k] + " "+ alph[p-1];

          }

          if(k>0){

            Board_Display[k] = String.valueOf(alph[params - k])+ " ";

            for(int j = 0;j < params;j++){

              switch (Board[params-k][j]){

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
    }// end of display initialization


    System.out.println(" ");

		String move;

    while(endgame != true){

			System.out.println("Make your move");
			Scanner scannerTM = new Scanner(System.in);
			move = new String(scannerTM.nextLine());

      if(move.length()!=4){

        System.out.println("Your input is too short");
        System.exit(0);

      }

			char[] letters = move.toCharArray();

      char cQ= letters[0];
      char cU = letters[1];
      char cI = letters[2];
      char cT = letters[3];

      int fromRow = (int) letters[0]-65;
      int fromCol= (int) letters[1]-65;
      int toRow = (int) letters[2]-65;
      int toCol = (int) letters[3]-65;

      if(testQUIT(cQ,cU,cI,cT)==true){


        System.out.println("Player has left the game...");
        System.exit(0);

      }else {

          if(testMove1(player,fromRow,fromCol,toRow,toCol, Board)==true){

						//Board[params-fromRow-1][fromCol]
            if((player==2)&&(Board[params-fromRow-1][fromCol]==2)){

              Board[params-toRow-1][toCol] = 2;
              Board[params-fromRow-1][fromCol] = 0;

            }else{

            	System.out.println(" ");
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
            System.out.println(" ");
  				}
        }
      }
    }

























	public static void testMode(){

    int testplayer = 2;
    int size = 8;
    String Board_Display[] = new String[size+1];
    int Board[][] = new int [size][size];
    String input = "NQ";
    boolean endgame = false;

    //standardize and initiate board numbers
    for (int h = 0; h < size; h++) {

      for (int i = 0; i < size; i++) {

        if(((h==0)&&(i==0)) || ((h==size-1)&&(i==0)) || ((h==0)&&(i==size-1)) || ((h==size-1)&&(i==size-1))){

          Board[h][i]= EMPTY;

        }else if((h==0) || (h==size-1)){

          Board[h][i] = BLACK;

        }else if((i==0) || (i==size-1)){

          Board[h][i] = WHITE;

        }
      }
    } // end of board initialization

    System.out.println(" ");

    //display initial board
    for (int k = 0; k < size+1 ; k++) {

       for (int p = 0; p < size+1; p++) {

          if ((k==0)&&(p==0)){

            Board_Display[k] = " ";

          }else if(k==0){

            Board_Display[k] = Board_Display[k] + " "+ alph[p-1];

          }

          if(k>0){

            Board_Display[k] = String.valueOf(alph[size - k])+ " ";

            for(int j = 0;j < size;j++){

              switch (Board[size-k][j]){

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
    }// end of display initialization


    System.out.println(" ");

    while(endgame != true){

			System.out.println("Make your move");
			Scanner scannerTM = new Scanner(System.in);
			input = new String(scannerTM.nextLine());

      if(input.length()!=4){

        System.out.println("ERROR: invalid move");
        System.exit(0);

      }

			char[] letters = input.toCharArray();

      char cQ= letters[0];
      char cU = letters[1];
      char cI = letters[2];
      char cT = letters[3];

      int fromRow = (int) letters[0]-65;
      int fromCol= (int) letters[1]-65;
      int toRow = (int) letters[2]-65;
      int toCol = (int) letters[3]-65;

      if(testQUIT(cQ,cU,cI,cT)==true){


        System.out.println("player quit");
        System.exit(0);

      }else {

          if(testMove0(player,fromRow,fromCol,toRow,toCol, Board)==true){

            if(Board[size-fromRow-1][fromCol]==player){

              Board[size-toRow-1][toCol] = 2;
              Board[size-fromRow-1][fromCol] = 0;

            }else{

              Board[size-toRow-1][toCol] = 1;
              Board[size-fromRow-1][fromCol] = 0;
            }

            System.out.println(" ");

            for (int k = 0; k < size+1; k++) {

        			 for (int p = 0; p < size+1; p++) {

                  if ((k==0)&&(p==0)){

                    Board_Display[k] = " ";

                  }else if(k==0){

                    Board_Display[k] = Board_Display[k] + " "+ alph[p-1];

                  }

                  if(k>0){

                    Board_Display[k] = String.valueOf(alph[size - k])+ " ";

                    for(int j=0;j<size;j++){

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
            System.out.println(" ");
  				}
        }
      }
    }


  public static boolean testQUIT( char cQ, char cU, char cI, char cT) {

    if((cQ=='Q')&&(cU=='U')&&(cI=='I')&&(cT=='T')){

      return true;

    }else{

      return false;
    }

  }

  public static boolean testMove0(int player, int fromRow, int fromCol, int toRow, int toCol ,int Board[][]) {

    int size = 8;
    int testplayer = 2;


		if(fromCol>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
			return false;
		}

	  if(fromRow>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;
		}

		if(toCol>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;
		}

		if(toRow>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;
		}

    if((fromRow==toRow)&&(fromCol==toCol)){

      System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;

    }

    if((fromRow==toRow)&&(fromCol==toCol)){

      System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;
    }

    if(fromCol==toCol){

      if(fromRow<toRow){

        for(int k = fromRow; k < size; k++){

          if(Board[fromRow][k]!=0){

            if(Board[fromRow][k]==testplayer){

              System.out.println("Jumped");

            }else{

              System.out.println("ERROR: invalid move");
              System.exit(0);
              return false;
            }
          }
        }

    }else{

      for(int k = fromCol; k < size; k++){

        if(Board[k][fromCol]!=0){

          if(Board[k][fromCol]==testplayer){

              System.out.println("Jumped");

            }else{

              System.out.println("ERROR: invalid move");
              System.exit(0);
              return false;
            }
          }
        }
      }
    }
		return true;  }

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
		return Board[row][col];
	}

	/*
	 * Make a move. Check that the move is valid. If not, return false. If
	 * valid, modify the board thSystem.out.println("Make your move");
		Scanner scanner = new Scanner(System.in);
    String move = new String(scanner.nextLine());at the piece has moved from (fromRow, fromCol)
	 * to (toRow, toCol).
	 */

	 public static boolean testMove1(int player, int fromRow, int fromCol, int toRow, int toCol ,int Board[][]) {

	 	int size = 8;
	 	int testplayer = 2;


	 	if(fromCol>size-1){

	 		System.out.println("Your starting coordinates have values that exceed the limit of coloumns on the board");
	 		return false;
	 	}

	 	if(fromRow>size-1){

	 		System.out.println("Your starting coordinates have values that exceed the limit of rows on the board");
	 		return false;
	 	}

	 	if(toCol>size-1){

	 		System.out.println("Your destination coordinates have values that exceed the limit of coloumns on the board");
	 		return false;
	 	}

	 	if(toRow>size-1){

	 		System.out.println("Your destination coordinates have values that exceed the limit of rows on the board");
	 		return false;
	 	}

	 	if((fromRow==toRow)&&(fromCol==toCol)){

	 		System.out.println("You cannot move to the same spot");
	 		return false;

	 	}

	 	if(fromCol==toCol){

	 		if(fromRow<toRow){

	 			for(int k = fromRow; k < size; k++){

	 				if(Board[fromRow][k]!=0){

	 					if(Board[fromRow][k]==testplayer){

	 						System.out.println("Jumped");

	 					}else{

	 						System.out.println("You cannot jump over an enemy piece");
	 						System.exit(0);
	 						return false;
	 					}
	 				}
	 			}

	 	}else{

	 		for(int k = fromCol; k < size; k++){

	 			if(Board[k][fromCol]!=0){

	 				if(Board[k][fromCol]==player){

	 						System.out.println("Jumped");

	 					}else{

	 						System.out.println("You cannot jump over an enemy piece");
	 						System.exit(0);
	 						return false;
	 					}
	 				}
	 			}
	 		}
	 	}
	 	return true;  }

	/*
	 * Return the size of the board.
	 */

	public static int getSize() {
		return size;
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
