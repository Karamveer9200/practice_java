package cs110.Lab.Lab8Stage2ChessBoard;

enum ChessPieces {

    PAWN_WHITE("♙"),
    KING_WHITE("♔"),
    QUEEN_WHITE("♕"),
    ROOK_WHITE("♖"),
    KNIGHT_WHITE("♘"),
    BISHOP_WHITE("♗"),
    PAWN_BLACK("♟"),
    KING_BLACK("♚"),
    QUEEN_BLACK("♛"),
    ROOK_BLACK("♜"),
    KNIGHT_BLACK("♞"),
    BISHOP_BLACK("♝");

    private final String indicator;
    ChessPieces(String indicator) {
        this.indicator = indicator;

    }

    // to return the indicator
    public  String indicator() {
        return indicator;
    }
}
