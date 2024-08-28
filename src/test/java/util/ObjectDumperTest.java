package util;

import junit.framework.TestCase;
import pieces.*;
import chess.*;

import static util.ObjectDumper.dumper;

public class ObjectDumperTest extends TestCase {
    Board board = new Board();

    public void testClass() throws IllegalAccessException {
        board.createBoard();
        Piece blackKing = King.create(Piece.Color.BLACK, board);
        board.addPiece(blackKing, 'b', 6);
        Piece blackRook = Rook.create(Piece.Color.BLACK, board);
        board.addPiece(blackRook, 'b', 5);
        Piece whiteKing = King.create(Piece.Color.WHITE, board);
        board.addPiece(whiteKing, 'a', 1);

        String stringDumpBoard = dumper(board);
        assertEquals(stringBoard(board), stringDumpBoard);

        String stringDumpPiece = dumper(whiteKing);
        assertEquals(stringPiece(whiteKing), stringDumpPiece);
    }

    public String stringPiece(Piece piece) {
        StringBuilder builder = new StringBuilder();
        builder.append("Class King:\n").append(
                "\t[PRIVATE, FINAL] Board - board: " + board.toString() + "\n" +
                        "\t[PRIVATE, FINAL] Color - color: WHITE\n" +
                        "\t[PRIVATE, FINAL] Type - type: KING\n" +
                        "\t[PRIVATE] double - points: 0.0\n" +
                        "\t[PRIVATE, FINAL] char - representation: k\n" +
                        "\t[PROTECTED] int - column: 0\n" +
                        "\t[PROTECTED] int - rank: 1");
        return builder.toString();
    }

    public String stringBoard(Board board) {
        StringBuilder builder = new StringBuilder();
        builder.append("Class Board:\n").append(
                "\t[PUBLIC] Array 2D of Piece - board:\n" +
                        "\t\tClass King:\n" +
                        "\t\t\t[PRIVATE, FINAL] Board - board: " + board + "\n" +
                        "\t\t\t[PRIVATE, FINAL] Color - color: WHITE\n" +
                        "\t\t\t[PRIVATE, FINAL] Type - type: KING\n" +
                        "\t\t\t[PRIVATE] double - points: 0.0\n" +
                        "\t\t\t[PRIVATE, FINAL] char - representation: k\n" +
                        "\t\t\t[PROTECTED] int - column: 0\n" +
                        "\t\t\t[PROTECTED] int - rank: 1;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tClass Rook:\n" +
                        "\t\t\t[PRIVATE, FINAL] Board - board: " + board + "\n" +
                        "\t\t\t[PRIVATE, FINAL] Color - color: BLACK\n" +
                        "\t\t\t[PRIVATE, FINAL] Type - type: ROOK\n" +
                        "\t\t\t[PRIVATE] double - points: 5.0\n" +
                        "\t\t\t[PRIVATE, FINAL] char - representation: R\n" +
                        "\t\t\t[PROTECTED] int - column: 1\n" +
                        "\t\t\t[PROTECTED] int - rank: 5;\n" +
                        "\t\tClass King:\n" +
                        "\t\t\t[PRIVATE, FINAL] Board - board: " + board + "\n" +
                        "\t\t\t[PRIVATE, FINAL] Color - color: BLACK\n" +
                        "\t\t\t[PRIVATE, FINAL] Type - type: KING\n" +
                        "\t\t\t[PRIVATE] double - points: 0.0\n" +
                        "\t\t\t[PRIVATE, FINAL] char - representation: K\n" +
                        "\t\t\t[PROTECTED] int - column: 1\n" +
                        "\t\t\t[PROTECTED] int - rank: 6;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t\tnull;\n" +
                        "\t[PUBLIC] int - piecesWhite: 1\n" +
                        "\t[PUBLIC] int - piecesBlack: 2\n" +
                        "\t[PROTECTED] ArrayList - pieces: \n" +
                        "\t\tClass King:\n" +
                        "\t\t\t[PRIVATE, FINAL] Board - board: " + board + "\n" +
                        "\t\t\t[PRIVATE, FINAL] Color - color: BLACK\n" +
                        "\t\t\t[PRIVATE, FINAL] Type - type: KING\n" +
                        "\t\t\t[PRIVATE] double - points: 0.0\n" +
                        "\t\t\t[PRIVATE, FINAL] char - representation: K\n" +
                        "\t\t\t[PROTECTED] int - column: 1\n" +
                        "\t\t\t[PROTECTED] int - rank: 6\n" +
                        "\t\tClass Rook:\n" +
                        "\t\t\t[PRIVATE, FINAL] Board - board: " + board + "\n" +
                        "\t\t\t[PRIVATE, FINAL] Color - color: BLACK\n" +
                        "\t\t\t[PRIVATE, FINAL] Type - type: ROOK\n" +
                        "\t\t\t[PRIVATE] double - points: 5.0\n" +
                        "\t\t\t[PRIVATE, FINAL] char - representation: R\n" +
                        "\t\t\t[PROTECTED] int - column: 1\n" +
                        "\t\t\t[PROTECTED] int - rank: 5\n" +
                        "\t\tClass King:\n" +
                        "\t\t\t[PRIVATE, FINAL] Board - board: " + board + "\n" +
                        "\t\t\t[PRIVATE, FINAL] Color - color: WHITE\n" +
                        "\t\t\t[PRIVATE, FINAL] Type - type: KING\n" +
                        "\t\t\t[PRIVATE] double - points: 0.0\n" +
                        "\t\t\t[PRIVATE, FINAL] char - representation: k\n" +
                        "\t\t\t[PROTECTED] int - column: 0\n" +
                        "\t\t\t[PROTECTED] int - rank: 1\n" +
                        "\t[PUBLIC] StringBuilder - piecesOnTheBoard: \n" +
                        "\t\t........\n" +
                        "\t\t........\n" +
                        "\t\t.K......\n" +
                        "\t\t.R......\n" +
                        "\t\t........\n" +
                        "\t\t........\n" +
                        "\t\t........\n" +
                        "\t\tk.......\n" +
                        "\t[PUBLIC] String - filename: " + board.filename + "\n" +
                        "\t[PUBLIC] File - file: " + board.file);
        return builder.toString();
    }

    public void testObjectDumper() throws IllegalAccessException {
        StringBuilder builderExpected = new StringBuilder();
        builderExpected.append("Class ObjectDumper:\n" +
                "\t[PUBLIC] Array 1D of int - testArray1: {1, 2, 3} \n" +
                "\t[PUBLIC] Array 1D of String - testArrayString:\n" +
                "\t\ttest1;\ttest2;\ttest3;\n" +
                "\t[] Array 2D of float - testArray2:\n" +
                "\t\t1.0;\t1.0\n" +
                "\t\t2.0;\t2.0;\n" +
                "\t[] Array 2D of Float - testArrayFloat:\n" +
                "\t\t11.0\n" +
                "\t\t22.0;\n" +
                "\t[] Array 3D of String - testArray3:\n" +
                "\t\tTest1.1;\tTest1.2\n" +
                "\t\tTest2.1;\n" +
                "\t[] Array 4D of String - testArray4:\n" +
                "\t\tTest1;\ttest1.2\n" +
                "\t\ttest2.2\n" +
                "\t\tteste\n" +
                "\t\ttest123;\tteste\n" +
                "\t\ttest5432;\n" +
                "\t[] Map - map: {map3=3, map2=2, map1=1}\n" +
                "\t[] StringBuffer - buffer: \n" +
                "\t\ttestBuffer");

        String stringObjectDumper = dumper(new ObjectDumper());
        assertEquals(builderExpected.toString(), stringObjectDumper);
    }
}
