package pieces;

import chess.Moves;
import chess.MovesFactoryImpl;

import java.util.ArrayList;

public class King extends Piece {
    public static Type Class = Type.KING;

    protected King(Color color) {
        super(color, Class);
    }

    public static King createPiece(Color color) {
        return new King(color);
    }

    @Override
    public ArrayList<String> getPossibleMoves() {
        Moves movesFactory = new MovesFactoryImpl(this);
        return movesFactory.possibleMoves();
    }
}