import javax.swing.ImageIcon;

public class Torre extends Piece{
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whiteTorre.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackTorre.png");

  public Torre(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };
}