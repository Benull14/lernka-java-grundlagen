package de.schule.rechner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArgumentPrueferTest {

    @Test
    void genugArgumenteVorhanden() {
        String[] args = {"addiere", "3", "4"};
        assertTrue(ArgumentPruefer.hatGenugArgumente(args, 3));
    }

    @Test
    void mehrAlsBenoetigtIstAuchGenug() {
        String[] args = {"addiere", "3", "4", "5"};
        assertTrue(ArgumentPruefer.hatGenugArgumente(args, 3));
    }

    @Test
    void zuWenigArgumente() {
        String[] args = {"addiere", "3"};
        assertFalse(ArgumentPruefer.hatGenugArgumente(args, 3));
    }

    @Test
    void leeresArrayReichtNichtAus() {
        String[] args = {};
        assertFalse(ArgumentPruefer.hatGenugArgumente(args, 1));
    }

    @Test
    void leeresArrayReichtWennNullBenoetigt() {
        String[] args = {};
        assertTrue(ArgumentPruefer.hatGenugArgumente(args, 0));
    }

    @Test
    void genauEinArgumentBenoetigtUndVorhanden() {
        String[] args = {"nur-eins"};
        assertTrue(ArgumentPruefer.hatGenugArgumente(args, 1));
    }

    @Test
    void nullArrayGiltAlsKeineArgumente() {
        assertFalse(ArgumentPruefer.hatGenugArgumente(null, 2));
    }

    @Test
    void nullArrayReichtWennNullBenoetigt() {
        assertTrue(ArgumentPruefer.hatGenugArgumente(null, 0));
    }
}
