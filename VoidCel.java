import java.io.Serializable;
import java.util.ArrayList;

public class VoidCel extends Piece implements Serializable{
  public VoidCel(int positionX, int positionY) {
    super(positionX, positionY, null, -1);
  };

  public ArrayList<Piece> getPosiblePositions(Piece[][] board) {
    return new ArrayList<Piece>();
  };
  public String toString(){
    return "Vacio "+super.toString();
  }
}
