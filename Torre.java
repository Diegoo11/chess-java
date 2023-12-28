import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Torre extends Piece {
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whiteTorre.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackTorre.png");

  public Torre(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };

  public ArrayList<Piece> getPosiblePositions(Piece[][] board) {
    ArrayList<Piece> positions = new ArrayList<Piece>();

    int x = this.getPositionX();
    int y = this.getPositionY();

    for (int i = x-1; i >= 0; i--) {
      Piece position = board[i][y];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }
    for(int i=x+1; i< board.length; i++){
      Piece position = board[i][y];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }

    for(int j=y-1; y>=0; j--){
      Piece position = board[x][j];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }
    for(int j=y+1; y< board.length; j--){
      Piece position = board[x][j];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }
    return positions;
  };
}