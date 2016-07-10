package model;

import java.util.Map;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 *         Location of a particualr piece.
 */
public class PieceLocation {
    private final char column;
    private final char row;

    private PieceLocation(char column, char row) {
        this.column = column;
        this.row = row;

        if (column < 'A' || column > 'H') {
            throw new IllegalArgumentException("Wrong column: " + column);
        }
        if (row < '1' || row > '8') {
            throw new IllegalArgumentException("Wrong row: " + row);
        }
    }

    public static PieceLocation getPieceLocation(Map.Entry<Character, Character> pieceLocation) {
        return new PieceLocation(pieceLocation.getKey(), pieceLocation.getValue());
    }

    private static PieceLocation getPieceLocation(char column, char row) {
        return new PieceLocation(column, row);
    }

    char column() {
        return this.column;
    }

    public char row() {
        return this.row;
    }

    public PieceLocation top() {
        return PieceLocation.getPieceLocation(column, (char) (row + 1));
    }

    public PieceLocation topRight() {
        return PieceLocation.getPieceLocation((char) (column + 1), (char) (row + 1));
    }

    public PieceLocation right() {
        return PieceLocation.getPieceLocation((char) (column + 1), row);
    }

    public PieceLocation bottomRight() {
        return PieceLocation.getPieceLocation((char) (column + 1), (char) (row - 1));
    }

    public PieceLocation bottom() {
        return PieceLocation.getPieceLocation(column, (char) (row - 1));
    }

    public PieceLocation bottomLeft() {
        return PieceLocation.getPieceLocation((char) (column - 1), (char) (row - 1));
    }

    public PieceLocation left() {
        return PieceLocation.getPieceLocation((char) (column - 1), row);
    }

    public PieceLocation topLeft() {
        return PieceLocation.getPieceLocation((char) (column - 1), (char) (row + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PieceLocation that = (PieceLocation) o;

        return column == that.column && row == that.row;

    }

    @Override
    public int hashCode() {
        int result = (int) column;
        result = 31 * result + (int) row;
        return result;
    }

    @Override
    public String toString() {
        return (this.column + "" + this.row).toLowerCase();
    }
}
