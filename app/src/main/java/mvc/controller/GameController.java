package mvc.controller;

import mvc.ControllerInterface;

import mvc.view.TicTacToeGUI;
import mvc.model.TicTacToeBoard;
import mvc.model.TicTacToePiece;
import mvc.model.AutoPlayer;

public class GameController implements ControllerInterface
{
   TicTacToeBoard board;
   AutoPlayer autoPlayer;
   TicTacToeGUI view;
   TicTacToePiece userPiece;

   public GameController(TicTacToeBoard board, AutoPlayer autoPlayer)
   {
      this.board = board;
      this.autoPlayer = autoPlayer;
      switch (autoPlayer.getPiece())
      {
         case X:
            this.userPiece = TicTacToePiece.O;
            break;
         default:
            this.userPiece = TicTacToePiece.X;
      }

      this.view = new TicTacToeGUI(this, board);
   }

   public void userPressed(int row, int col)
   {
      board.placeTicTacToePiece(row, col, userPiece);
      if (!board.isGameOver())
      {
          autoPlayer.makeNextMove(this.board);
      }
   }
}
