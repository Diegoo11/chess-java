import javax.swing.*;

public class Peon extends Piece {
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whitePeon.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackPeon.png");

  public Peon(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };
}
