import javax.swing.ImageIcon;

public class King extends Piece{
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whiteKing.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackKing.png");

  public King(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };
}
