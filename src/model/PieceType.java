package model;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 *         Type of a piece.
 */
public enum PieceType {

    KNIGHT("N"),
    PAWN("P");

    private final String letter;

    PieceType(String letter) {
        this.letter = letter;
    }

    public static PieceType getTypeOfPiece(char pieceType) {
        switch (pieceType) {
            case 'N':
                return PieceType.KNIGHT;
            case 'P':
                return PieceType.PAWN;
            default:
                throw new IllegalArgumentException("Illegal piece type (must be knight or pawn): " + pieceType);
        }
    }

    @Override
    public String toString() {
        return this.letter;
    }
}
