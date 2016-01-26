import.java.util.Scanner; //For inputs

//Main game class

public class GameMain{
  private Board board; //game board
  private GameState currentState; //current game state
  private Filler currentPlayer; //current player

  private static Scanner int = new Scanner(System.in); //input Scanner

  //Game constructor
  public GameMain() {
    board = new Board(); //allocate game board

    //Initialise game board and current states
    initGame();

    //Play game once
    do{
      playerMove(currentPlayer); //update content
      board.paint();
      updateGame(currentPlayer); //update currentState

      //Print messages if game over
      if(currentState == GameState.CrossWon){
        System.out.println("X won!");
      }
      else if (currentState == GameState.NoughtWon){
        System.out.println("O won!");
      }
      else if (currentState == GameState.Draw){
        System.out.println("It's a draw!");
      }

      //Switch player
      currentPlayer = (currentPlayer == Filler.Cross) ? Filler.Nought : Filler.Cross;
    } while(currentState == GameState.Playing); //Repeat turns until game over
  }

  //Initialise game board contents and current states
  public void initGame(){
    board.init(); //clear board contents
    currentPlayer = Filler.Cross; //Cross players first
    currentState = GameState.Playing; //ready to play
  }

  //Player with theFiller makes move, input validated, updated cell, row, column
  public void playerMove(Filler theFiller){
    boolean validInput = false; //for validating input
    do {
      if(theFiller == Filler.Cross){
        System.out.print("Player X enter your move (row[1-3] column[1-3]) : ");
      }
      else{
        System.out.print("Player O enter your move (row[1-3] column[1-3]) : ");
      }

      int row = int.nextInt() - 1; //take in row input
      int col = int.nextInt() - 1; //take in col input
      if(row >= 0 && row < Board.rows && col >= 0 && col < Board.cols
      && board.cells[row][col].content == Filler.Empty){ //check input valid
        board.cells[row][col].content = theFiller; //set cell
        board.currentRow = row; //change current row
        board.currentCol = col; //change current col
        validInput = true;
      }
      else { //invalid input
        System.out.println("A move at (" + (row+1) + "," + (col+1) + ") isn't valid, Try again :");
      }
    } while(!validInput); //repeat until input valid
  }

  //Update currentState after player has moved
  public void updateGame(Filler theFiller){
    if(board.hasWon(theSeed)){ //check for win
      currentState = (theFiller == Filler.Cross) ? GameState.CrossWon : GameState.NoughtWon;
    }
    else if (board.isDraw()){ //check for draw
      currentState = GameState.Draw;
    }
    //Otherwise, no change to current state - still playing
  }

  //Main method
  public static void main(String[] args){
    new GameMain(); //construct game
  }
}
