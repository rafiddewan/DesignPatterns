import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProfTest {

    Prof prof;
    Student student;
    TA ta;
    ArrayList<ProfListener> profListeners;

    @BeforeEach
    void setUp() {
        prof  = new Prof("Schram");
        student = new Student("Rafid");
        ta = new TA("Moe");
    }

    @Test
    void testSetName() {
        prof.setName("Babak");
        assertEquals("Babak", prof.getName());
    }

    @Test
    void addProfListener() {
        prof.addProfListener(ta);
        profListeners = prof.getProfListeners();
        assertNotNull(profListeners);
        prof.addProfListener(student);
        profListeners = prof.getProfListeners();
        assertEquals(2, profListeners.size());
    }

    @Test
    void removeProfListener() {
        prof.addProfListener(ta);
        prof.addProfListener(student);
        assertTrue(prof.removeProfListener(1));
        assertTrue(prof.removeProfListener(0));
        assertFalse(prof.removeProfListener(0));
    }

}