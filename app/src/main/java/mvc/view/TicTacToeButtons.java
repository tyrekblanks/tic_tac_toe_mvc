package mvc.view;

import mvc.model.TicTacToeBoard;
import mvc.model.TicTacToePiece;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeButtons extends JPanel
{
   private TicTacToeBoard board;
   private TicTacToeButton []buttons;

   public TicTacToeButtons(TicTacToeBoard board, ActionListener buttonClickListener)
   {
      this.board = board;
      int boardSize = this.board.getSize();
      int numButtons = boardSize * boardSize;

      this.buttons = new TicTacToeButton[numButtons];
      
      for (int i = 0; i < boardSize; i++)
      {
         for (int j = 0; j < boardSize; j++)
         {
            buttons[i*boardSize + j] = new TicTacToeButton(i, j);
            buttons[i*boardSize + j].addActionListener(buttonClickListener);
         }
      }

      // position the buttons in a grid
      this.setLayout(new GridLayout(this.board.getSize(), this.board.getSize()));

      for (int i = 0; i < numButtons; i++)
      {
         this.add(buttons[i]);
      }
   }

   public void showBoard()
   {
      int numButtons = this.buttons.length;
      for (int i = 0; i < numButtons; i++)
      {
         int row = i / this.board.getSize();
         int col = i % this.board.getSize();
         TicTacToePiece piece = this.board.getTicTacToePiece(row, col);
         if (piece != null)
         {
            this.buttons[i].setText(piece.toString());
            this.buttons[i].setEnabled(false);
         }
      }
   }
  
   public void disableAll()
   {
      for (int i = 0; i < this.buttons.length; i++)
      {
         this.buttons[i].setEnabled(false);
      }
   }
}
