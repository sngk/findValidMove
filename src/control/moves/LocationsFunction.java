package control.moves;

import model.Board;
import model.ChessPiece;
import model.PieceLocation;

import java.util.Set;
import java.util.function.BiFunction;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 *         <p>
 *         Checks placed chess piece with valid cells where this piece can move.
 */
public class LocationsFunction implements BiFunction<Board, ChessPiece, Set<PieceLocation>> {
    private static final IPieceMoves knightMoves = new KnightMoves();
    private static final IPieceMoves pawnMoves = new PawnMoves();

    @Override
    public Set<PieceLocation> apply(Board board, ChessPiece chessPiece) {
        switch (chessPiece.pieceType()) {
            case KNIGHT:
                return knightMoves.apply(board, chessPiece);
            case PAWN:
                return pawnMoves.apply(board, chessPiece);
            default:
                throw new IllegalArgumentException("Illegal piece type (must be knight or pawn): " + chessPiece.pieceType());
        }
    }
}
