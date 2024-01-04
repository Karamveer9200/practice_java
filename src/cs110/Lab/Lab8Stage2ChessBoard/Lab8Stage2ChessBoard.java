package cs110.Lab.Lab8Stage2ChessBoard;

import java.util.Scanner;

public class Lab8Stage2ChessBoard {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String dispPlayerTurn = "player %s your move ";
        String player = "Black";
        ChessBoard board = new ChessBoard();

        board.setInitialPositions();
        do {
            board.displayBoard();

            System.out.println(String.format(dispPlayerTurn, player));

            System.out.print("From <[a-h]> : ");
           // String fromPos = sc.next();
            char fromCol = sc.next().charAt(0);
            System.out.print("     <[1-8]> : ");
            int fromRow = sc.nextInt();

            System.out.print("To   <[a-h]> : ");
            //String toPos = sc.next();
            char toCol = sc.next().charAt(0);
            System.out.print("     <[1-8]> : ");
            int toRow = sc.nextInt();

            board.setPiece(fromCol, fromRow, toCol, toRow);

            // player switching
            if (player.equals("Black")) {
                player = "White";
            } else {
                player = "Black";
            }
        } while (true);
        //board.setPiece(ChessPieces.PAWN_BLACK.indicator(), 'e', 2);
        //System.out.println(board.getPiece('e', 3));

    }
}
