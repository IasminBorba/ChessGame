package pieces;

public class KnightPiece extends Piece {
    public static Type Class = Type.KNIGHT;

    protected KnightPiece(Color color, Type type) {
        super(color, type);
    }

    public static KnightPiece create(Color color) {
        return new KnightPiece(color, Class);
    }

    @Override
    public boolean getPossibleMoves(Piece piece, int files, int rank){
        boolean permission = false;
        if (rank > 8){
            return false;
        }
//        int file = Board.transformPosition(files);
//        if (file == 9) {
//            return false;
//        }
//
//        permission = switch (piece.getType()){
//            case KING -> Game.newKingPosition(piece, file, rank);
//            case PAWN -> false;
//            case KNIGHT -> false;
//            case ROOK -> false;
//            case BISHOP -> false;
//            case QUEEN -> Game.newQueenPosition(piece, file, rank);
//            case NO_PIECE -> false;
//        };


        return permission;
    }
}