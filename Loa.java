import java.util.Scanner;

public class Loa {

	// The size of the board
	private static int [][] Board;
	private static int size;
	private static int player;
	private static char turn = 'B';
	// The pieces
	public static final int INVALID = -1;
	public static final int EMPTY = 0;
	public static final int WHITE = 1;
	public static final int BLACK = 2;

	// The board
	private static String[] Board_Display;
	private static char[] alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	//first turn to BLACK


	public static void main(String[]args){//main method for base instructions on program

		size = Integer.parseInt(args[0]);
		int mode = Integer.parseInt(args[1]);

		if(args.length<2){// see if both the argusments have been supplied

			System.out.println("ERROR: too few arguments");
			System.exit(0);

		}
		if((size<4) || (size>16)){ // determine if size is between 4 and 16

			System.out.println("ERROR: illegal size");
			System.exit(0);

		}
		if((mode<0)||(mode>2)) { //check to see if mode that was initialized is correct

			System.out.println("ERROR: illegal mode");
			System.exit(0);

		}

		if(mode==0){ //initialize testMode
			testMode();
		}

		if(mode==1){ //initialize Single Player Mode
			player = 2;
			SPM();
		}

		if(mode==2){ //initialize Multi Player Mode
			//MPM();
		}

	}//end main method


	public static void turn(){ //method to regulate turns

		if(turn=='B'){
			player = 1;
			turn = 'W';
		}else if(turn == 'W'){
			turn = 'W';
		  player = 2;
			turn = 'B';
		}
	}// end

	public static void SPM(){ // Single Player Mode start

		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a board size between 4 and 16");
		int params = new Integer(scanner.nextInt()); //Receive parameters for the size of the board

		 while ((params<4) || (params>16)){

		    System.out.println("Invalid size, choose a board size between 4 and 16");
		    params = new Integer(scanner.nextInt()); //retake parameters if they were not in range
//make move after validation
		 }

		 System.out.println("To you want to play as white or black?");
		 System.out.println("Enter 1/2");
		 int player = Integer.parseInt(scanner.nextLine()); //determine player number
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

              switch (Board[params-k][j]){ //display int array of current board

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

    while(hasWon(player) != true){

			System.out.println("Make your move");
			Scanner scannerTM = new Scanner(System.in);
			move = new String(scannerTM.nextLine()); //receieve coordinates for movement

      while(move.length()!=4){

        System.out.println("Your input is too short");
				move = new String(scannerTM.nextLine()); //check if coordinates are all given

      }turn = 'B';

			char[] letters = move.toCharArray(); //store coordinates in char array to be able to split their values for movement on board

      char cQ = letters[0]; //test
      char cU = letters[1]; //if user
      char cI = letters[2]; //has
      char cT = letters[3]; //entered quit

      int fromRow = (int) letters[0]-65;
      int fromCol= (int) letters[1]-65;
      int toRow = (int) letters[2]-65;
      int toCol = (int) letters[3]-65;

      if(testQUIT(cQ,cU,cI,cT)==true){ //quit checking function


        System.out.println("Player has left the game...");
        System.exit(0);

      }else {

          if(testMove1(player,fromRow,fromCol,toRow,toCol, Board)==true){

							if(turn=='B'){

								if((player==2)&&(Board[params-fromRow-1][fromCol]==2)){ //make move after validation

		              Board[params-toRow-1][toCol] = 2;
		              Board[params-fromRow-1][fromCol] = 0;
									turn();

		            }else{

		            	System.out.println("You must move a black piece"); // make sure each user can only move its own piees
									move = new String(scannerTM.nextLine());
		            }
							}

							if(turn=='W'){
								if((player==1)&&(Board[params-fromRow-1][fromCol]==1)){ //make move after validation

	              	Board[params-toRow-1][toCol] = 1;
	              	Board[params-fromRow-1][fromCol] = 0;
									turn();

	            	}else{

	            		System.out.println("You must move a white piece piece");
									move = new String(scannerTM.nextLine());
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
            System.out.println(" ");

						if(hasWon(BLACK)==true){

							System.out.println("WINNER: black");
						}
						if(hasWon(WHITE)==true){

							System.out.println("WINNER: white");
  				}
        }
      }// singleplayer mode end
		}



	public static void testMode(){

    int testplayer = 2;
    int size = 8;
    String Board_Display[] = new String[size+1];
    int Board[][] = new int [size][size];
    String input = "NQ";
    boolean endgame = false;

    //standardize and initiate board
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

    while(endgame != true){// ranges and situations are check and results are returned to the method that calls this one as a boolean


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
    // ranges and situations are check and results are returned to the method that calls this one as a boolean
  int fromCol= (int) letters[1]-65;
      int toRow = (int) letters[2]-65;
      int toCol = (int) letters[3]-65;

      if(testQUIT(cQ,cU,cI,cT)==true){


        System.out.println("player quit");
        System.exit(0);

      }else {

          if(testMove0(testplayer,fromRow,fromCol,toRow,toCol, Board)==true){

						boolean go = false;

						while(go==false){

							if(Board[size-fromRow-1][fromCol]==2){

		              Board[size-toRow-1][toCol] = 2;
		              Board[size-fromRow-1][fromCol] = 0;
									go = true;

		            }else	if(Board[size-fromRow-1][fromCol]==1){

		              Board[size-toRow-1][toCol] = 1;
		              Board[size-fromRow-1][fromCol] = 0;
									go = true;

		            }else{

		            	System.out.println("ERROR: invalid move");
									System.exit(0);;
		            }
							}
						}
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

						if(hasWon(BLACK)==true){

							System.out.println("WINNER: black");
						}
						if(hasWon(WHITE)==true){

							System.out.println("WINNER: white");
						}
  				}
        }




  public static boolean testQUIT( char cQ, char cU, char cI, char cT) { //quitCheck

    if((cQ=='Q')&&(cU=='U')&&(cI=='I')&&(cT=='T')){

      return true;

    }else{

      return false;
    }

  }

  public static boolean testMove0(int player, int fromRow, int fromCol, int toRow, int toCol ,int Board[][]) { // ranges and situations are check and results are returned to the method that calls this one as a boolean

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

              //

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

            	return true;

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

	public static int getPiece(int row, int col) { // get piece's position from board at spesific point
		if ((row < 0) || (row >= size)) {
			return INVALID;
		}
		if ((col < 0) || (col >= size)) {
			return INVALID;
		}
		return Board[row][col];
	}

	 public static boolean testMove1(int player, int fromRow, int fromCol, int toRow, int toCol ,int Board[][]) { // ranges and situations are check and results are returned to the method that calls this one as a boolean

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

	 						return true;

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

	 						return true;

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

	public static int getSize() {
		return size;
	}



	public static int rowCount(int row) {
     int inRow = 0;

		 	for(int k = 0; k < size; k++){

         if( (getPiece(row,k) == BLACK) || (getPiece(row,k) == WHITE) ){

            inRow = inRow + 1;

         }
     }
  return inRow;
 }

	public static int colCount(int col) {
		return 0;
	}
	public static int diagNortheastCount(int row, int col) {
		return 0;
	}

	public static int diagNorthwestCount(int row, int col) {

		return 0;
	}

	public static boolean hasWon(int player) {
		return Util.isConnected(Board, player);
	}
}
