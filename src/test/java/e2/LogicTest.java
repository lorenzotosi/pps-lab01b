package e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logic;
    public static final int BOARD_SIZE = 5;
    private Piece pawn;
    private Piece knight;

    @BeforeEach
    void setUp() {
        this.pawn = new PieceImpl(0,0);
        this.knight = new PieceImpl(2,1);
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
        assertFalse(logic.hasKnight(6,6));
    }

    @Test
    public void testWrongPawnPosition() {
        assertFalse(logic.hasPawn(6,6));
    }

    @Test
    public void testHit() {
        assertTrue(logic.hit(0,0));
    }

    @Test
    public void testNoHit() {
        assertFalse(logic.hit(1,1));
    }

}
