package cs110.Lab.Lab8Stage2ChessBoard;

class ChessBoard {
    private final int rows = 8;
    private final int columns = 8;
    private final char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private final String[][] pieceAt = new String[rows][columns];

    public void setPiece(char fromChar, int fromRow, char toChar, int toRow) {

        this.pieceAt[rows - toRow][charToNum(toChar)] = this.pieceAt[rows - fromRow][charToNum(fromChar)];
        this.pieceAt[rows - fromRow][charToNum(fromChar)] = " \u2b29";
    }

    public String getPiece(char columnChar, int row) {

        return pieceAt[rows - row][charToNum(columnChar)];
    }

    // converting alphabetical columns to numeric
    int charToNum(char columnChar) {
        int column = 0;

        columnChar = Character.toLowerCase(columnChar);
        // converting alphabetical column to numeric
        int i = 0;
        for (char ch : chars) {
            if (columnChar == ch) {
                column = ((int) columnChar + i) - ((int) columnChar);
            }
            i++;
        }
        return column;
    }

    public void setInitialPositions() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pieceAt[i][j] = " \u2b29";
            }
        }
        // All pawns in row 2 and 7
        for (int i = 0; i < rows; i++) {
            pieceAt[1][i] = ChessPieces.PAWN_BLACK.indicator();
            pieceAt[6][i] = ChessPieces.PAWN_WHITE.indicator();
        }

        // All the remaining pieces
        pieceAt[0][0] = ChessPieces.ROOK_BLACK.indicator();
        pieceAt[0][7] = ChessPieces.ROOK_BLACK.indicator();
        pieceAt[7][0] = ChessPieces.ROOK_WHITE.indicator();
        pieceAt[7][7] = ChessPieces.ROOK_WHITE.indicator();

        pieceAt[0][1] = ChessPieces.KNIGHT_BLACK.indicator();
        pieceAt[7][1] = ChessPieces.KNIGHT_WHITE.indicator();
        pieceAt[0][6] = ChessPieces.KNIGHT_BLACK.indicator();
        pieceAt[7][6] = ChessPieces.KNIGHT_WHITE.indicator();

        pieceAt[0][2] = ChessPieces.BISHOP_BLACK.indicator();
        pieceAt[7][2] = ChessPieces.BISHOP_WHITE.indicator();
        pieceAt[0][5] = ChessPieces.BISHOP_BLACK.indicator();
        pieceAt[7][5] = ChessPieces.BISHOP_WHITE.indicator();


        pieceAt[0][4] = ChessPieces.KING_BLACK.indicator();
        pieceAt[7][4] = ChessPieces.KING_WHITE.indicator();

        pieceAt[0][3] = ChessPieces.QUEEN_BLACK.indicator();
        pieceAt[7][3] = ChessPieces.QUEEN_WHITE.indicator();

    }

    // to display the complete board
    public void displayBoard() {
        System.out.println(" ");
//        System.out.print(" ");
//        for (char ch: chars) {
//            System.out.print("  " + ch);
//        }
//        System.out.println(" ");
        for (int i = 0; i < rows; i++) {
            System.out.print((rows - i) +"  ");
            for (int j = 0; j < columns; j++) {
                System.out.print(pieceAt[i][j] + " ");
            }
            System.out.print(" " + (rows - i));
            System.out.println(" ");
        }

        for (char ch: chars) {
            System.out.print("  " + ch);
        }
        System.out.println(" ");
    }
}