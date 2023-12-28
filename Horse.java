import javax.swing.ImageIcon;

public class Horse extends Piece{
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whiteHorse.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackHorse.png");

  public Horse(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };
  
  
}
