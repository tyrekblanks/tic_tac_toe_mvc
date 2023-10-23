package mvc.controller;

import mvc.ControllerInterface;

import mvc.view.TicTacToeGUI;
import mvc.model.TicTacToeBoard;
import mvc.model.TicTacToePiece;
import mvc.model.AutoPlayer;

public class GameControllerTwoPlayer implements ControllerInterface
{
   TicTacToeBoard board;
   AutoPlayer autoPlayer;
   TicTacToeGUI view;
   TicTacToePiece currentPiece;

   public GameControllerTwoPlayer(TicTacToeBoard board)
   {
      this.board = board;
      this.view = new TicTacToeGUI(this, board);
      this.currentPiece = TicTacToePiece.X;
   }

   public void userPressed(int row, int col)
   {
      board.placeTicTacToePiece(row, col, currentPiece);
      // switch the current piece
      if (currentPiece == TicTacToePiece.X)
      {
         currentPiece = TicTacToePiece.O;
      }
      else
      {
         currentPiece = TicTacToePiece.X;
      }
   }
}
