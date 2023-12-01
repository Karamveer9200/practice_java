package cs110.Lab.Lab8Stage2ChessBoard;

class ChessBoard {
    private final int eight = 8;
    private char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    private String[][] positions = new String[eight][eight];

    public void setPiece(char fromChar, int fromRow, char toChar, int toRow) {

        this.positions[eight - toRow][charToNum(toChar)] = this.positions[eight - fromRow][charToNum(fromChar)];
        this.positions[eight - fromRow][charToNum(fromChar)] = " -  ";
    }

    public String getPiece(char columnChar, int row) {

        return positions[eight - row][charToNum(columnChar)];
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
        for (int i = 0; i < eight; i++) {
            for (int j = 0; j < eight; j++) {
                positions[i][j] = " -  ";
            }
        }
        // All pawns in row 2 and 7
        for (int i = 0; i < eight; i++) {
            positions[1][i] = ChessPieces.PAWN_BLACK.indicator();
            positions[6][i] = ChessPieces.PAWN_WHITE.indicator();
        }

        // All the remaining pieces
        positions[0][0] = ChessPieces.ROOK_BLACK.indicator();
        positions[0][7] = ChessPieces.ROOK_BLACK.indicator();
        positions[7][0] = ChessPieces.ROOK_WHITE.indicator();
        positions[7][7] = ChessPieces.ROOK_WHITE.indicator();

        positions[0][1] = ChessPieces.KNIGHT_BLACK.indicator();
        positions[7][1] = ChessPieces.KNIGHT_WHITE.indicator();
        positions[0][6] = ChessPieces.KNIGHT_BLACK.indicator();
        positions[7][6] = ChessPieces.KNIGHT_WHITE.indicator();

        positions[0][2] = ChessPieces.BISHOP_BLACK.indicator();
        positions[7][2] = ChessPieces.BISHOP_WHITE.indicator();
        positions[0][5] = ChessPieces.BISHOP_BLACK.indicator();
        positions[7][5] = ChessPieces.BISHOP_WHITE.indicator();


        positions[0][4] = ChessPieces.KING_BLACK.indicator();
        positions[7][4] = ChessPieces.KING_WHITE.indicator();

        positions[0][3] = ChessPieces.QUEEN_BLACK.indicator();
        positions[7][3] = ChessPieces.QUEEN_WHITE.indicator();

    }

    // to display the complete board
    public void displayBoard() {
        System.out.println(" ");
        for (char ch: chars) {
            System.out.print("    " + ch);
        }
        System.out.println(" ");
        for (int i = 0; i < eight; i++) {
            System.out.print((eight - i) +"  ");
            for (int j = 0; j < eight; j++) {
                System.out.print(positions[i][j] + " ");
            }
            System.out.print((eight - i) +"  ");
            System.out.println(" ");
        }
        for (char ch: chars) {
            System.out.print("    " + ch);
        }
        System.out.println(" ");
    }
}