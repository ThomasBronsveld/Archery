package nl.hva.ict.se.ads;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Place all your own tests for Archer in this class. Tests in any other class will be ignored!
 */
public class ExtendedArcherTest extends ArcherTest {

    /**
     * This test is to make sure an id once set cannot be changed.
     */
    @Test
    public void checkIdChange() throws Exception {
        List<Archer> archers = Archer.generateArchers(5);
        assertThrows(Exception.class, () -> {
            archers.get(4).setId(3);
        });
        System.out.println(archers.get(0).toString());
    }

    @Test
    public void stringFormatTest(){

    }
}
