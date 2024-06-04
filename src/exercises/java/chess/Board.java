package chess;

import pieces.Piece;
import util.StringUtil;

import java.util.ArrayList;
import java.util.Objects;

public class Board {
    int piecesWhite;
    int piecesBlack;
    private final ArrayList<Piece> pieces = new ArrayList<>();
    public final StringBuilder piecesOnTheBoard = new StringBuilder();
    public int index = 0;
    double strengthWhite = 0;
    double strengthBlack = 0;
    Piece[][] board;

    public void initialize() {
        createBoard();
        addPiecesOfRank(Piece.Color.WHITE);
        addPiecesPawnOfRank(Piece.Color.WHITE);
        addPiecesPawnOfRank(Piece.Color.BLACK);
        addPiecesOfRank(Piece.Color.BLACK);
    }

    public void createBoard() {
        board = new Piece[8][8];
        addPiecesBlank();
    }

    private void addPiecesOfRank(Piece.Color color) {
        int auxWhite = 0;
        int auxBlack = 0;
        Piece.Type[] types = {Piece.Type.ROOK, Piece.Type.KNIGHT, Piece.Type.BISHOP, Piece.Type.QUEEN, Piece.Type.KING, Piece.Type.BISHOP, Piece.Type.KNIGHT, Piece.Type.ROOK};
        for (Piece.Type type : types) {
            if (Objects.equals(color, Piece.Color.WHITE)) {
                Piece piece = Piece.createWhitePiece(type);
                addPiece(piece,auxWhite,1);
            } else {
                Piece piece = Piece.createBlackPiece(type);
                addPiece(piece, auxBlack,8);
            }
            auxWhite++;
            auxBlack++;
        }
    }

    private void addPiecesPawnOfRank(Piece.Color color) {
        for (int z = 0; z < 8; z++) {
            if (Objects.equals(color, Piece.Color.WHITE)) {
                addPiece(Piece.createWhitePiece(Piece.Type.PAWN),z,2);
            } else {
                addPiece(Piece.createBlackPiece(Piece.Type.PAWN), z, 7);
            }
        }
    }

    public void addPiece(Piece piece, int file, int rank) {
        int aux = rank - 1;

        pieces.add(piece);
        board[file][aux] = piece;
        alterPrint(piece, file, rank);

        if (piece.getType() == Piece.Type.PAWN){
            alterPawnForceSameColumn(file, aux);
        }

        calculateStrength();
    }

    private void addPiecesBlank() {
        Piece blank = Piece.noPiece();
        for (int x = 0; x < 8; x++) {
            for (int z = 0; z < 8; z++) {
                piecesOnTheBoard.append(blank.getRepresentation());
                board[z][x] = blank;
            }
            piecesOnTheBoard.append(StringUtil.NEWLINE);
            index++;
        }
    }

    public void addPiece(Piece piece, char files, int rank) {
        int file = transformPosition(files);
        int aux = rank - 1;

        pieces.add(piece);
        board[file][aux] = piece;
        alterPrint(piece, file, rank);

        if (piece.getType() == Piece.Type.PAWN){
            alterPawnForceSameColumn(file, aux);
        }
        calculateStrength();
    }

    void calculateStrength(){
        double auxWhiteStrength = 0;
        double auxBlackStrength = 0;

        for (int x = 0; x < 8; x++) {
            for (int z = 0; z < 8; z++) {
                Piece auxPIece = board[z][x];
                if (auxPIece.getType() != Piece.Type.NO_PIECE){
                    if (auxPIece.isWhite()) {
                        auxWhiteStrength += auxPIece.getPoints();
                    }
                    else {
                        auxBlackStrength += auxPIece.getPoints();
                    }
                }
            }
        }
        strengthWhite = auxWhiteStrength;
        strengthBlack = auxBlackStrength;
    }

    void alterPawnForceSameColumn(int column, int rank) {
        boolean sameColumnPawn = false;
        for (int i = 0; i < 8; i++) {
            if (i != rank && board[column][i].getRepresentation() == board[column][rank].getRepresentation()) {
                sameColumnPawn = true;
                Piece auxPiece = board[column][i];
                if (auxPiece.getPoints() == 1) {
                    auxPiece.setPoints(0.5);
                }
            }
        }
        if (sameColumnPawn) {
            Piece auxPiece = board[column][rank];
            if (auxPiece.getPoints() == 1) {
                auxPiece.setPoints(0.5);
            }
        }
    }

    public void alterPrint(Piece piece, int files, int rank){
        int lines = 8-rank;
        int positionPiece = (lines*8) + files + lines;

        piecesOnTheBoard.setCharAt(positionPiece, piece.getRepresentation());
    }

    int transformPosition(char file){
        int num = 0;
        switch (file) {
            case 'a' -> num = 0;
            case 'b' -> num = 1;
            case 'c' -> num = 2;
            case 'd' -> num = 3;
            case 'e' -> num = 4;
            case 'f' -> num = 5;
            case 'g' -> num = 6;
            case 'h' -> num = 7;
        }
        return num;
    }

    public String print(){
        return piecesOnTheBoard.toString();
    }

    int pieceCount(){
        return pieces.size();
    }

    double getStrengthBlackPiece(){
        return strengthBlack;
    }
    double getStrengthWhitePiece(){
        return strengthWhite;
    }

    String getRank(int rank) {
        StringBuilder rankPiece = new StringBuilder();
        for (int x = 0; x < 8; x++) {
            Piece auxPIece = board[x][rank-1];
            rankPiece.append(auxPIece.getRepresentation());
        }
        return rankPiece.toString();
    }
    int getPiecesWhite(){
        for (int x = 0; x < 8; x++) {
            for (int z = 0; z < 8; z++) {
                Piece auxPIece = board[z][x];
                if (auxPIece.getType() != Piece.Type.NO_PIECE){
                    if (auxPIece.isWhite()) {
                        piecesWhite ++;
                    }
                }
            }
        }
        return piecesWhite;
    }

    int getPiecesBlack(){
        for (int x = 0; x < 8; x++) {
            for (int z = 0; z < 8; z++) {
                Piece auxPIece = board[z][x];
                if (auxPIece.getType() != Piece.Type.NO_PIECE){
                    if (auxPIece.isBlack()) {
                        piecesBlack ++;
                    }
                }
            }
        }
        return piecesBlack;
    }

    char getPiece(char files, int rank){
        int file = transformPosition(files);
        Piece piece = board[file][rank-1];
        return piece.getRepresentation();
    }
}