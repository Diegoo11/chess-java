import java.util.ArrayList;

import javax.swing.*;

public class Peon extends Piece {
  private static ImageIcon whiteIcon = new ImageIcon("./assets/whitePeon.png");
  private static ImageIcon blackIcon = new ImageIcon("./assets/blackPeon.png");
  private boolean firstMove = true;

  public Peon(int positionX, int positionY, int team) {
    super(positionX, positionY, team == 0 ? whiteIcon : blackIcon, team);
  };

  public ArrayList<Piece> getPosiblePositions(Piece[][] board) {
    ArrayList<Piece> positions = new ArrayList<Piece>();
    for (int i = 1; i <= (firstMove ? 2:1); i += 1) {
      System.out.println(getPositionX() + " " + getPositionY() + " " + i);
      if (getPositionX() + i < 0 || getPositionX() + i > 7) {
        continue;
      }
      Piece position = board[getPositionX() + i][getPositionY()];
      if (position instanceof VoidCel) {
        positions.add(position);
      }
    }
    if (getPositionX() + 1 >= 0 && getPositionX() + 1 <= 7
        && getPositionY() - 1 >= 0 && getPositionY() + 1 <= 7) {
      Piece position = board[getPositionX() + 1][getPositionY() + 1];

      if (!(position instanceof VoidCel) && position.getTeam() != getTeam()) {
        positions.add(position);
      }

      position = board[getPositionX() + 1][getPositionY() - 1];
      if (!(position instanceof VoidCel) && position.getTeam() != getTeam()) {
        positions.add(position);
      }
    }
    firstMove = false;
    return positions;
  };
}
