package net.redpandaz.lab.jalgo.impl.commons;

import net.redpandaz.lab.jalgo.trifle.TrifleStrings;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    @Test
    void shouldBeIterator() {
        String expect = TrifleStrings.String();
        String[] expected = {expect, null};
        Iterator<String> it = new ArrayIterator<>(expected, 1);
        while (it.hasNext()) {
            assertEquals(expect, it.next());
        }
    }

}