import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Board extends JFrame {
  private Piece[][] board = new Piece[8][8];
  private Piece finishBtn = null;

  public Board() {
    for (int i = 0; i < 8; i++) {
      if(i == 0) {
        board[i][0] = new Torre(i, 0, 0);
        add(board[i][0]);

        board[i][1] = new Alfil(i, 1, 0);
        add(board[i][1]);

        board[i][2] = new Horse(i, 2, 0);
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

        board[i][1] = new Alfil(i, 1, 1);
        add(board[i][1]);

        board[i][2] = new Horse(i, 2, 1);
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

  private class ListenerBtn implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Piece startBtn = (Piece) e.getSource();
      if(finishBtn == null) {
        if(startBtn instanceof VoidCel) return; // si es un VoidCel no hace nada (no se puede mover
        System.out.println("Clicked 1");
        finishBtn = startBtn; // primer click se almacena el peon
      } else { // direccion final
        System.out.println("Clicked 2");
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            remove(board[i][j]);
          }
        }

        board[finishBtn.getPositionX()][finishBtn.getPositionY()] = new VoidCel(finishBtn.getPositionX(), finishBtn.getPositionY());
        finishBtn.setPositionX(startBtn.getPositionX());
        finishBtn.setPositionY(startBtn.getPositionY());
        board[startBtn.getPositionX()][startBtn.getPositionY()] = finishBtn;

        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            add(board[i][j]);
          }
        }
  
        finishBtn = null;
        validate();
        revalidate();
        repaint();
      }
    }
  }

  public static void main(String[] args) {
    new Board();
  };
}