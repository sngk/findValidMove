package model;

/**
 * Created by
 * @author Andrew U.
 *         on 9/07/2016.
 *         Create a chess piece with a particular colour, type and location.
 */
public class ChessPiece {
    private final PieceColour pieceColour;
    private final PieceLocation pieceLocation;
    private final PieceType pieceType;

    public ChessPiece (PieceColour pieceColour, PieceType pieceType, PieceLocation pieceLocation) {
        this.validatePawnLocation(pieceType,pieceLocation);
        this.pieceColour = pieceColour;
        this.pieceType = pieceType;
        this.pieceLocation = pieceLocation;
    }

    public PieceColour pieceColour () {
        return this.pieceColour;
    }
    public PieceLocation pieceLocation () {
        return this.pieceLocation;
    }
    public PieceType pieceType () {
        return this.pieceType;
    }

    private void validatePawnLocation( PieceType pieceType, PieceLocation pieceLocation) {
        if (pieceType == PieceType.PAWN  && (pieceLocation.row() < '2'
                || pieceLocation.row() > '7' )) {
            throw new IllegalArgumentException("Pawns may not be placed on the 1st or last rows.");
        }
    }
    @Override
    public String toString() {
        return this.pieceColour + " " + this.pieceType + " on " + this.pieceLocation;
    }
}
