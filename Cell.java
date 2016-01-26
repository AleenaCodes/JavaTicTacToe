//Class modelling each individual cell of game board

public class Cell {
  Filler content; //cell with content type : Filler
  //int row, col;

  //Cell constructor
  public Cell(int row, int col){
    this.row = row;
    this.col = col;
    clear(); //clear content
  }

  //Clear cell content (change to empty)
  public void clear(){
    content = Filler.Empty;
  }

  //Paint cell
  public void paint(){
    switch (content){
      case Cross  : System.out.print(" X "); break;
      case Nought : System.out.print(" O "); break;
      case Empty  : System.out.print("   "); break;
    }
  }
}
