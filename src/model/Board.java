package model;

import java.util.List;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 *         <p>
 *         Create a chessboard.
 */
public class Board {
    private final ChessPiece[][] board = new ChessPiece[8][8];

    /**
     * @param pieces list of pieces to put on board.
     */
    public Board numberOfPiecesToPlace(List<ChessPiece> pieces) {
        pieces.forEach(this::placePiece);
        return this;
    }

    /**
     * @param chessPiece a piece to put on board.
     */
    private Board placePiece(ChessPiece chessPiece) {
        this.validate(chessPiece);
        board[this.getColumn(chessPiece.pieceLocation())][getRow(chessPiece.pieceLocation())] = chessPiece;
        return this;
    }

    private int getColumn(PieceLocation pieceLocation) {
        return this.getColumn(pieceLocation.column());
    }

    private int getRow(PieceLocation pieceLocation) {
        return this.getRow(pieceLocation.row());
    }

    private int getColumn(char column) {
        return column - 65;
    }

    private int getRow(char row) {
        return row - 49;
    }

    /**
     * @param pieceLocation location of a target square
     * @return a piece or a null.
     */
    public ChessPiece targetLocation(PieceLocation pieceLocation) {
        return this.targetLocation(pieceLocation.column(), pieceLocation.row());
    }

    /**
     * @param column column of the target square
     * @param row    row of the target square
     * @return a piece or a null.
     */
    private ChessPiece targetLocation(char column, char row) {
        return board[this.getColumn(column)][this.getRow(row)];
    }

    private void validate(ChessPiece piece) {
        if (this.board[this.getColumn(piece.pieceLocation())][getRow(piece.pieceLocation())] != null) {
            throw new IllegalArgumentException("Can not place a piece there. The place's already occupied.");
        }
    }

}
