package control.moves;

import model.Board;
import model.ChessPiece;
import model.PieceLocation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 */

class KnightMoves implements IPieceMoves {

    @Override
    public Set<PieceLocation> apply(Board board, ChessPiece chessPiece) {
        Set<PieceLocation> result = new HashSet<>();
        Function<UnaryOperator<PieceLocation>, Set<PieceLocation>> functionMove = this.functionMove(board, chessPiece);
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.top().topRight()));
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.top().topLeft()));
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.right().topRight()));
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.right().bottomRight()));
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.bottom().bottomRight()));
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.bottom().bottomLeft()));
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.left().topLeft()));
        result.addAll(functionMove.apply(pieceLocation -> pieceLocation.left().bottomLeft()));
        return result;
    }

    private Function<UnaryOperator<PieceLocation>, Set<PieceLocation>> functionMove(Board board, ChessPiece chessPiece) {
        return nextMove -> this.knightMove(board, chessPiece, nextMove);
    }

    /**
     * Gets all possible moves for particular piece.
     *
     * @param board      current chess board.
     * @param chessPiece piece which we're moving.
     * @param nextMove   function to receive next available square.
     * @return a set of all valid moves for a piece.
     */
    private Set<PieceLocation> knightMove(Board board, ChessPiece chessPiece, UnaryOperator<PieceLocation> nextMove) {
        PieceLocation targetPosition;
        try {
            targetPosition = nextMove.apply(chessPiece.pieceLocation());
        } catch (IllegalArgumentException e) {
            return Collections.emptySet();
        }
        Set<PieceLocation> result = new HashSet<>();
        this.knightCaptureMove(result, board, chessPiece, targetPosition);

        return result;
    }

    /**
     * Gets a valid move if field unoccupied, occupied by a piece of different colour
     *
     * @param result        location set where to add squares if we can move piece there.
     * @param board         current chess board.
     * @param chessPiece    piece which we're moving.
     * @param pieceLocation location where we move the piece.
     * @return if we can move piece on that square, than add this location to result.
     */
    private boolean knightCaptureMove(Set<PieceLocation> result, Board board, ChessPiece chessPiece, PieceLocation pieceLocation) {
        ChessPiece pieceAtCurrentLocation = board.targetLocation(pieceLocation);
        if (pieceAtCurrentLocation == null) {
            result.add(pieceLocation);
            return true;
        } else if (chessPiece.pieceColour() != pieceAtCurrentLocation.pieceColour()) {
            result.add(pieceLocation);
            return false;
        } else {
            return false;
        }
    }
}
