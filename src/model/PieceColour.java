package model;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 *         Colours of chess pieces.
 */
public enum PieceColour {
    BLACK ("Black"),
    WHITE ("White");

    private final String letter;

    PieceColour (String letter) {
        this.letter = letter;
    }
    public static PieceColour valueOf(char pieceColour) {
        switch (pieceColour){
            case 'B':
                return PieceColour.BLACK;
            case 'W':
                return PieceColour.WHITE;
            default:
                throw new IllegalArgumentException("Illegal piece colour (must be black or white): "+pieceColour);
        }
    }
    @Override
    public String toString() {
        return this.letter;
    }
}
