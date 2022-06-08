package org.sbutterfly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DisjointSetTest {

    @Test
    void simple() {
        var set = new DisjointSet(2);
        Assertions.assertEquals(0, set.getGroup(0));
        Assertions.assertEquals(1, set.getGroup(1));

        set.unit(0, 1);
        Assertions.assertEquals(1, set.getGroup(0));
        Assertions.assertEquals(1, set.getGroup(1));
    }

    @Test
    void testChain() {
        var set = new DisjointSet(5);

        set.unit(0, 1);
        set.unit(1, 2);
        set.unit(3, 4);
        set.unit(3, 2);
        Assertions.assertEquals(2, set.getGroup(0));
        Assertions.assertEquals(2, set.getGroup(1));
        Assertions.assertEquals(2, set.getGroup(2));
        Assertions.assertEquals(2, set.getGroup(3));
        Assertions.assertEquals(2, set.getGroup(4));
    }
}
