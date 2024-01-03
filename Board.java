import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Board extends JFrame {
  private Piece[][] board = new Piece[8][8];
  private Turno turno = new Turno();

  private Piece finishBtn = null;
  private ArrayList<Piece> posiblePositions;

  public Board() {
    newGame();
  }

  private class ListenerBtn implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Piece startBtn = (Piece) e.getSource();

      if (finishBtn == null) {
        if (startBtn instanceof VoidCel) return;
        if (startBtn.getTeam() != turno.getTurno()) return;
        startBtn.select();
        
        posiblePositions = startBtn.getPosiblePositions(board);
        paintPositions(posiblePositions);

        finishBtn = startBtn;
      } else {
        removeBoard();

        if (posiblePositions.contains(startBtn) && !finishBtn.equals(startBtn)) {
          changePositions(board, finishBtn, startBtn, posiblePositions);
          turno.played();
        }

        reFill();

        finishBtn.defaultColor();

        posiblePositions = null;
        finishBtn = null;

        revalidate();
      }
    }
  }

  public static void main(String[] args) {
    new Board();
  };

  public void removeBoard() {
    for (int i = 0; i < 8; i += 1) {
      for (int j = 0; j < 8; j += 1) {
        board[i][j].defaultColor();
        remove(board[i][j]);
      }
    }
  }

  public void reFill() {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) { 
        add(board[i][j]);
      }
    }
  }

  public void changePositions(Piece[][] board, Piece p1, Piece p2, ArrayList<Piece> posiblePositions) {
    board[p1.getPositionX()][p1.getPositionY()] = new VoidCel(p1.getPositionX(), p1.getPositionY());
    board[p1.getPositionX()][p1.getPositionY()].addActionListener(new ListenerBtn());
    p1.setPositions(p2.getPositionX(), p2.getPositionY());
    board[p2.getPositionX()][p2.getPositionY()] = p1;
  }

  public void paintPositions(ArrayList<Piece> positions) {
    for (Piece position : positions) {
      position.isPosible();
    }
  }

  public void newGame() {
    for (int i = 0; i < 8; i++) {
      if(i == 0) {
        board[i][0] = new Torre(i, 0, 0);
        add(board[i][0]);

        board[i][1] = new Horse(i, 1, 0);
        add(board[i][1]);

        board[i][2] = new Alfil(i, 2, 0);
        add(board[i][2]);

        board[i][3] = new Queen(i, 3, 0);
        add(board[i][3]);

        board[i][4] = new King(i, 4, 0);
        add(board[i][4]);

        board[i][5] = new Horse(i, 5, 0);
        add(board[i][5]);

        board[i][6] = new Alfil(i, 6, 0);
        add(board[i][6]);

        board[i][7] = new Torre(i, 7, 0);
        add(board[i][7]);
      }
      if(i == 1)
        for (int j = 0; j < 8; j++) {
          board[i][j] = new Peon(i, j, 0);
          add(board[i][j]);
        }
      
      if(i > 1 && i < 6)
        for (int j = 0; j < 8; j++) {
          board[i][j] = new VoidCel(i, j);
          add(board[i][j]);
        }
      
      if(i == 6)
        for (int j = 0; j < 8; j++) {
          board[i][j] = new Peon(i, j, 1);
          add(board[i][j]);
        }
      if(i == 7) {
        board[i][0] = new Torre(i, 0, 1);
        add(board[i][0]);

        board[i][1] = new Horse(i, 1, 1);
        add(board[i][1]);

        board[i][2] = new Alfil(i, 2, 1);
        add(board[i][2]);

        board[i][3] = new Queen(i, 3, 1);
        add(board[i][3]);

        board[i][4] = new King(i, 4, 1);
        add(board[i][4]);

        board[i][5] = new Horse(i, 5, 1);
        add(board[i][5]);

        board[i][6] = new Alfil(i, 6, 1);
        add(board[i][6]);

        board[i][7] = new Torre(i, 7, 1);
        add(board[i][7]);
      }

      for(int j = 0; j < 8; j++) board[i][j].addActionListener(new ListenerBtn());
    }
    setTitle("Game-Chess");
    setSize(800, 800);
    setLayout(new GridLayout(8, 8));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  };
  
}