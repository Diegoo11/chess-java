import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Alfil extends Piece{
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whiteAlfil.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackAlfil.png");

  public Alfil(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };
  public ArrayList<Piece> getPosiblePositions(Piece[][] board) {
    ArrayList<Piece> positions = new ArrayList<Piece>();
    int x = this.getPositionX();
    int y = this.getPositionY();
    //izquierda-arriba
    for (int i=x-1, j=y-1; i>=0 || j>=0; i++, j++) {
      Piece position = board[i][j];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }
    //derecha-arriba
    for (int i=x+1, j=y-1; i>=0 || j<=board.length; i--, j++) {
      Piece position = board[i][j];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }
    //izquierda-abajo
    for(int i=x+1, j=y+1; i<=board.length || j>=0; i++, j--){
      Piece position = board[i][j];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }
    //derecha-abajo
    for(int i=x+1, j=y+1; i<=board.length || j<=board.length; i++, j++){
      Piece position = board[i][j];
      if(position instanceof VoidCel){
        positions.add(position);
      }else if(position.getTeam() != this.getTeam()){
        positions.add(position);
        break;
      }
    }
    return positions;
  }
  
}