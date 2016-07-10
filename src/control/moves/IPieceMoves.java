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
 *         A IPieceMoves defines how a piece moves.
 *         It checks placed chess piece with valid cells where this piece can move.
 */

interface IPieceMoves extends BiFunction<Board, ChessPiece, Set<PieceLocation>> {
}
