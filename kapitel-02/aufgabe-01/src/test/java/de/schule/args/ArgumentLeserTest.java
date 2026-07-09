package de.schule.args;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ArgumentLeserTest {

    @Test
    void liestErstesArgument() {
        String[] args = {"kunde", "rechnung", "2024"};
        assertEquals("kunde", ArgumentLeser.leseArgument(args, 0));
    }

    @Test
    void liestMittleresArgument() {
        String[] args = {"kunde", "rechnung", "2024"};
        assertEquals("rechnung", ArgumentLeser.leseArgument(args, 1));
    }

    @Test
    void liestLetztesArgument() {
        String[] args = {"kunde", "rechnung", "2024"};
        assertEquals("2024", ArgumentLeser.leseArgument(args, 2));
    }

    @Test
    void gibtNullBeiZuGrossemIndex() {
        String[] args = {"kunde", "rechnung"};
        assertNull(ArgumentLeser.leseArgument(args, 5));
    }

    @Test
    void gibtNullBeiNegativemIndex() {
        String[] args = {"kunde", "rechnung"};
        assertNull(ArgumentLeser.leseArgument(args, -1));
    }

    @Test
    void gibtNullBeiLeeremArray() {
        String[] args = {};
        assertNull(ArgumentLeser.leseArgument(args, 0));
    }

    @Test
    void gibtNullBeiNullArray() {
        assertNull(ArgumentLeser.leseArgument(null, 0));
    }

    @Test
    void liestEinzigesArgument() {
        String[] args = {"start"};
        assertEquals("start", ArgumentLeser.leseArgument(args, 0));
    }
}
