import java.awt.Color;

import javax.swing.*;


public class Piece extends JButton {
  private int positionX;
  private int positionY;
  private int team;

  public Piece(int positionX, int positionY, ImageIcon icon, int team) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.team = team;

    // super.setIcon(icon);
    setIcon(icon);
  };
  

  public int[][] searchPositions(int[][] board) {
    return new int[10][10];
  };

  public int[] getPositions() {
    int[] positions = {positionX, positionY};
    return positions;
  };
  public int getPositionX() {
    return positionX;
  };
  public int getPositionY() {
    return positionY;
  };
  public void setPositionX(int x) {
    positionX = x;
  };
  public void setPositionY(int y) {
    positionY = y;
  };
  public int getTeam() {
    return team;
  };
  public void isPosible() {
    setBackground(Color.ORANGE);
  }
}