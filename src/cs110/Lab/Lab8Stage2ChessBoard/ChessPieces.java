package cs110.Lab.Lab8Stage2ChessBoard;

enum ChessPieces {

    PAWN_WHITE("p(W)"),
    KING_WHITE("K(W)"),
    QUEEN_WHITE("Q(W)"),
    ROOK_WHITE("R(W)"),
    KNIGHT_WHITE("K(W)"),
    BISHOP_WHITE("B(W)"),
    PAWN_BLACK("p(B)"),
    KING_BLACK("K(B)"),
    QUEEN_BLACK("Q(B)"),
    ROOK_BLACK("R(B)"),
    KNIGHT_BLACK("K(B)"),
    BISHOP_BLACK("B(B)");

    private String indicator;
    ChessPieces(String indicator) {
        this.indicator = indicator;

    }

    // to return the indicator
    public  String indicator() {
        return indicator;
    }
}
