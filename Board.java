//Class modelling game board

public class Board{

  //Constants for dimensions
  public static final int rows = 3;
  public static final int cols = 3;

  //Package access
  Cell[][] cells; //board of Cells
  int currentRow, currentCol;

  //Board constructor
  public Board(){
    cells = new Cell[rows][cols];
    for(int row = 0; row < rows; ++row){
      for(int col = 0; col < cols; ++col){
        cells[row][col] = new Cell(row, col); //allocate array element
      }
    }
  }

  //Initialise game board contents
  public void init(){
    for(int row = 0; row < rows; ++row){
      for(int col = 0; col < cols; ++col){
        cells[row][col].clear(); //clear cell content
      }
    }
  }

  //Return true if a draw
  public boolean isDraw(){
    for(int row = 0; row < rows; ++row){
      for(int col = 0; col < cols; ++col){
         if(cells[row][col].content == Filler.Empty){
           return false; //not true if empty cell found, exit
         }
      }
    }
    return true; //no empty cells
  }

  //Return true if current player wins after a move
  public boolean hasWon(Filler theFiller){
    return(
      cells[currentRow][0].content == theFiller  //3 in row
        && cells[currentRow][1].content == theFiller
        && cells[currentRow][2].content == theFiller
      || cells[0][currentCol].content == theFiller //3 in column
        && cells[1][currentCol].content == theFiller
        && cells[2][currentCol].content == theFiller
      || currentRow == currentCol                // 3 in \ diagonal
        && cells[0][0].content == theFiller
        && cells[1][1].content == theFiller
        && cells[2][2].content == theFiller
      || currentRow + currentCol == 2           // 3 in / diagonal
        && cells[0][2].content == theFiller
        && cells[1][1].content == theFiller
        && cells[2][0].content == theFiller);
  }

  //Paint board
  public void paint(){
    for(int row = 0; row < rows; ++row){
      for(int col = 0; col < cols; ++col){
        cells[row][col].paint(); //paint each cell
        if(col < (cols - 1)){
          System.out.print("|");
        }
      }
      System.out.println();
      if(row < (rows - 1)){
        System.out.println("-----------");
      }
    }
  }
}
