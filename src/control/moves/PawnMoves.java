package control.moves;

import model.Board;
import model.ChessPiece;
import model.PieceLocation;

import java.util.HashSet;
import java.util.Set;
import java.util.function.UnaryOperator;


/**
 * Created by
 *
 * @author Andrew U.
 *         on 9/07/2016.
 */
class PawnMoves implements IPieceMoves {
    @Override
    public Set<PieceLocation> apply(Board board, ChessPiece piece) {
        switch (piece.pieceColour()) {
            case BLACK:
                return this.createBlackPawn(board, piece);
            case WHITE:
                return this.createWhitePawn(board, piece);
            default:
                throw new IllegalArgumentException("Illegal piece colour (must be black or white): " + piece.pieceColour());
        }
    }

    private Set<PieceLocation> createBlackPawn(Board board, ChessPiece piece) {
        Set<PieceLocation> res = new HashSet<>();
        boolean notOccupied = this.addPiece(res, board, piece.pieceLocation(), PieceLocation::bottom, false);
        if (notOccupied) {
            if (piece.pieceLocation().row() == '7') {
                this.addPiece(res, board, piece.pieceLocation(), position -> position.bottom().bottom(), false);
            }
        }
        this.addPiece(res, board, piece.pieceLocation(), PieceLocation::bottomLeft, true);
        this.addPiece(res, board, piece.pieceLocation(), PieceLocation::bottomRight, true);
        return res;
    }

    private Set<PieceLocation> createWhitePawn(Board board, ChessPiece piece) {
        Set<PieceLocation> res = new HashSet<>();
        boolean notOccupied = this.addPiece(res, board, piece.pieceLocation(), PieceLocation::top, false);
        if (notOccupied) {
            if (piece.pieceLocation().row() == '2') {
                this.addPiece(res, board, piece.pieceLocation(), position -> position.top().top(), false);
            }
        }
        this.addPiece(res, board, piece.pieceLocation(), PieceLocation::topLeft, true);
        this.addPiece(res, board, piece.pieceLocation(), PieceLocation::topRight, true);
        return res;
    }

    private boolean addPiece(Set<PieceLocation> set, Board board, PieceLocation currentLocation,
                             UnaryOperator<PieceLocation> nextLocation, boolean capture) {
        try {
            PieceLocation position = nextLocation.apply(currentLocation);
            if ((board.targetLocation(position) == null) != capture) {
                set.add(position);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
