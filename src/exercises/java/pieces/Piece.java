package pieces;

import java.util.Objects;

public class Piece {
    public enum Color {WHITE, BLACK}
    public enum Type {PAWN, KNIGHT, ROOK, BISHOP, QUEEN, KING, NO_PIECE}
    private Color color;
    private final Type type;
    private final char representation;
    public float strength = 0;
    public static char PAWN_REPRESENTATION, ROOK_REPRESENTATION, KNIGHT_REPRESENTATION, BISHOP_REPRESENTATION, QUEEN_REPRESENTATION, KING_REPRESENTATION, NO_PIECE_REPRESENTATION;
    public static float PAWN_STRENGTH, ROOK_STRENGTH, KNIGHT_STRENGTH, BISHOP_STRENGTH, QUEEN_STRENGTH, KING__STRENGTH, NO_PIECE_STRENGTH = 0;

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;

        if (color == Color.WHITE) {
            this.representation = switch (type) {
                case PAWN -> PAWN_REPRESENTATION = 'p';
                case ROOK -> ROOK_REPRESENTATION = 'r';
                case KNIGHT -> KNIGHT_REPRESENTATION = 'n';
                case BISHOP -> BISHOP_REPRESENTATION = 'b';
                case QUEEN -> QUEEN_REPRESENTATION = 'q';
                case KING -> KING_REPRESENTATION = 'k';
                case NO_PIECE -> NO_PIECE_REPRESENTATION = '.';
            };
        } else {
            this.representation = switch (type) {
                case PAWN -> PAWN_REPRESENTATION = 'P';
                case ROOK -> ROOK_REPRESENTATION = 'R';
                case KNIGHT -> KNIGHT_REPRESENTATION = 'N';
                case BISHOP -> BISHOP_REPRESENTATION = 'B';
                case QUEEN -> QUEEN_REPRESENTATION = 'Q';
                case KING -> KING_REPRESENTATION = 'K';
                case NO_PIECE -> NO_PIECE_REPRESENTATION = '.';
            };
        }

        this.strength = switch (type){
            case PAWN -> PAWN_STRENGTH = 1F;
            case ROOK -> ROOK_STRENGTH = 5F;
            case KNIGHT -> KNIGHT_STRENGTH = 2.5F;
            case BISHOP -> BISHOP_STRENGTH = 3F;
            case QUEEN -> QUEEN_STRENGTH = 9F;
            case KING -> KING__STRENGTH = 0F;
            case NO_PIECE -> NO_PIECE_STRENGTH = 0F;
        };
    }

    private Piece() {
        this.representation = '.';
        this.type = Type.NO_PIECE;
    }

    public static Piece createWhitePiece(Type type) {
        return switch (type) {
            case PAWN -> new Piece(Color.WHITE, Type.PAWN);
            case ROOK -> new Piece(Color.WHITE, Type.ROOK);
            case KNIGHT -> new Piece(Color.WHITE, Type.KNIGHT);
            case BISHOP -> new Piece(Color.WHITE, Type.BISHOP);
            case QUEEN -> new Piece(Color.WHITE, Type.QUEEN);
            case KING -> new Piece(Color.WHITE, Type.KING);
            case NO_PIECE -> null;
        };
    }

    public static Piece createBlackPiece(Type type) {
        return switch (type) {
            case PAWN -> new Piece(Color.BLACK, Type.PAWN);
            case ROOK -> new Piece(Color.BLACK, Type.ROOK);
            case KNIGHT -> new Piece(Color.BLACK, Type.KNIGHT);
            case BISHOP -> new Piece(Color.BLACK, Type.BISHOP);
            case QUEEN -> new Piece(Color.BLACK, Type.QUEEN);
            case KING -> new Piece(Color.BLACK, Type.KING);
            case NO_PIECE -> null;
        };
    }

    public static Piece noPiece() {
        return new Piece();
    }

    public boolean isBlack() {
        return Objects.equals(color.name().toLowerCase(), "black");
    }

    public boolean isWhite() {
        return Objects.equals(color.name().toLowerCase(), "white");
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return representation;
    }
    public float getStrength(Piece piece) {
        return piece.strength;
    }
}
