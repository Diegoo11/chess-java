import javax.swing.ImageIcon;

public class Alfil extends Piece{
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whiteAlfil.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackAlfil.png");

  public Alfil(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };
}