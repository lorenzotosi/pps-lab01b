package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logic;
    private Piece pawn;
    private Piece knight;
    public static final int BOARD_SIZE = 5;
    public static final int OUT_OF_BOARD_SIZE = BOARD_SIZE+1;
    public static final int INITIAL_PAWN_POSITION = 0;
    public static final int INITIAL_KNIGHT_ROW_POSITION = 2;
    public static final int INITIAL_KNIGHT_COL_POSITION = 1;

    @BeforeEach
    void setUp() {
        this.pawn = new PieceImpl(INITIAL_PAWN_POSITION, INITIAL_PAWN_POSITION);
        this.knight = new PieceImpl(INITIAL_KNIGHT_ROW_POSITION, INITIAL_KNIGHT_COL_POSITION);
        this.logic = new LogicsImpl(pawn, knight, BOARD_SIZE);
    }

    @Test
    public void test() {
        assert(true);
        // TODO: Add your test logic here
        // You can generate random inputs and assert the expected output
        // For example:
        // int result = Logic.someMethod(5, 10);
        // assertEquals(expectedResult, result);
    }

    @Test
    public void testWrongKnightPosition() {
        assertFalse(logic.hasKnight(OUT_OF_BOARD_SIZE, OUT_OF_BOARD_SIZE));
    }

    @Test
    public void testWrongPawnPosition() {
        assertFalse(logic.hasPawn(OUT_OF_BOARD_SIZE, OUT_OF_BOARD_SIZE));
    }

    @Test
    public void testPawnPosition() {
        assertTrue(logic.hasPawn(INITIAL_PAWN_POSITION, INITIAL_PAWN_POSITION));
    }

    @Test
    public void testHit() {
        assertTrue(logic.hit(0,0));
    }

    @Test
    public void testNoHit() {
        assertFalse(logic.hit(1,1));
    }

    @Test
    public void testMoveAndHit() {
        assertAll(() -> assertFalse(logic.hit(knight.getX()-1, knight.getY()+2)),
                () -> assertFalse(logic.hit(knight.getX()+1, knight.getY()-2)),
                () -> assertTrue(logic.hit(pawn.getX(), pawn.getY())));
    }

}
