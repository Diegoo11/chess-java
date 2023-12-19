import javax.swing.ImageIcon;

public class Queen extends Piece{
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whiteQueen.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackQueen.png");

  public Queen(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };
}