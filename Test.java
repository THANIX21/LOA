import java.util.Scanner;

public class Test{

  public static final int INVALID = -1;
	public static final int EMPTY = 0;
	public static final int WHITE = 1;
	public static final int BLACK = 2;
  private static char[] alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

  public static void main(String[]args){

    String input = "NQ";
    boolean endgame = false;

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

      int fromCol = (int) letters[0]-65;
      int fromRow = (int) letters[1]-65;
      int toCol = (int) letters[2]-65;
      int toRow = (int) letters[3]-65;

      if(testQUIT(cQ,cU,cI,cT)==true){


        System.out.println("player quit");
        System.exit(0);

      }else {

          if(testMove(1,fromRow,fromCol,toRow,toCol)==true){

            int size = 8;

            String Board_Display[] = new String[size+1];
            int Board[][] = new int [size][size];


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


  				}else{

  					System.out.println("ERROR: invalid move");
            System.exit(0);

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

  public static boolean testMove(int player, int fromRow, int fromCol, int toRow, int toCol) {

    int size = 8;

		while(fromCol>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
			return false;
		}

		while(fromRow>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;
		}

		while(toCol>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;
		}

		while(toRow>size-1){

			System.out.println("ERROR: invalid move");
      System.exit(0);
      return false;
		}

		return true;
	}
}
