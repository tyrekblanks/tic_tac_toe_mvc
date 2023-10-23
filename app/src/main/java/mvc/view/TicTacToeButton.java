package mvc.view;
import javax.swing.*;

public class TicTacToeButton extends JButton
{
   protected int row;
   protected int col;

   public TicTacToeButton(int row, int col)
   {
      this.row = row;
      this.col = col;
   }
   public int getRow(){return this.row;}
   public int getCol(){return this.col;}
}
