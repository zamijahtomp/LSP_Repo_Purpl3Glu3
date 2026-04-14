package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test clear() and length()")
    void testClearAndLength() {
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length());
        set1.clear();
        assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("Test equals() with order and mismatch")
    void testEquals() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(1);
        assertTrue(set1.equals(set2), "Sets should be equal regardless of order.");
        
        set2.add(3);
        assertFalse(set1.equals(set2), "Sets with different elements should not be equal.");
    }

    @Test
    @DisplayName("Test contains() present and absent")
    void testContains() {
        set1.add(5);
        assertTrue(set1.contains(5));
        assertFalse(set1.contains(10));
    }

    @Test
    @DisplayName("Test largest() normal and exception")
    void testLargest() throws IntegerSetException {
        set1.add(1); set1.add(10); set1.add(5);
        assertEquals(10, set1.largest());
        
        IntegerSet emptySet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> emptySet.largest());
    }

    @Test
    @DisplayName("Test smallest() normal and exception")
    void testSmallest() throws IntegerSetException {
        set1.add(1); set1.add(10); set1.add(5);
        assertEquals(1, set1.smallest());
        
        IntegerSet emptySet = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> emptySet.smallest());
    }

    @Test
    @DisplayName("Test add() normal and duplicate")
    void testAdd() {
        set1.add(1);
        assertEquals(1, set1.length());
        set1.add(1); // Duplicate
        assertEquals(1, set1.length(), "Duplicate add should not increase size.");
    }

    @Test
    @DisplayName("Test remove() normal and missing")
    void testRemove() {
        set1.add(1);
        set1.remove(1);
        assertEquals(0, set1.length());
        set1.remove(99); // Should not crash
        assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("Test union() normal and empty set")
    void testUnion() {
        set1.add(1); set2.add(2);
        IntegerSet result = set1.union(set2);
        assertTrue(result.contains(1) && result.contains(2));
        
        IntegerSet emptySet = new IntegerSet();
        IntegerSet result2 = set1.union(emptySet);
        assertEquals(1, result2.length());
    }

    @Test
    @DisplayName("Test intersect() normal and no overlap")
    void testIntersect() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        assertEquals("[2]", set1.intersect(set2).toString());
        
        set1.clear(); set1.add(10);
        assertEquals("[]", set1.intersect(set2).toString(), "No overlap should return empty set.");
    }

    @Test
    @DisplayName("Test diff() normal and identical sets")
    void testDiff() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        assertEquals("[1]", set1.diff(set2).toString());
        
        IntegerSet set3 = new IntegerSet();
        set3.add(1); set3.add(2);
        assertEquals("[]", set1.diff(set3).toString(), "Difference of identical sets should be empty.");
    }

    @Test
    @DisplayName("Test complement() normal and disjoint")
    void testComplement() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        assertEquals("[3]", set1.complement(set2).toString());
        
        set1.clear(); set1.add(10); // Disjoint
        assertEquals("[2, 3]", set1.complement(set2).toString());
    }

    @Test
    @DisplayName("Test isEmpty() empty and non-empty")
    void testIsEmpty() {
        assertTrue(set1.isEmpty());
        set1.add(1);
        assertFalse(set1.isEmpty());
    }

    @Test
    @DisplayName("Test toString() normal and empty")
    void testToString() {
        assertEquals("[]", set1.toString());
        set1.add(3); set1.add(1); set1.add(2);
        assertEquals("[1, 2, 3]", set1.toString());
    }

    @Test
    @DisplayName("Test exception handling explicitly")
    void testExceptionHandling() {
        // Double check both exceptions for the dedicated rubric category
        assertThrows(IntegerSetException.class, () -> set1.largest());
        assertThrows(IntegerSetException.class, () -> set1.smallest());
    }
    
    @Test
    @DisplayName("Test length() consistency")
    void testLengthConsistency() {
        set1.add(1); set1.add(2); set1.add(3);
        assertEquals(3, set1.length());
        set1.remove(1);
        assertEquals(2, set1.length());
    }
}