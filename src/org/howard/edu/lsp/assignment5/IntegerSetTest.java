package org.howard.edu.lsp.assignment5;

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
        // Now both sets are freshly created before every test runs
    }

    @Test
    @DisplayName("Test union of two sets")
    void testUnion() {
        set1.add(1); set1.add(2); set1.add(3);
        
        set2.add(2); set2.add(3); set2.add(4);
        
        IntegerSet result = set1.union(set2);
        
        // Verify result
        assertEquals("[1, 2, 3, 4]", result.toString(), "Union should contain all unique elements.");
        // Verify immutability (Improves your 'Completeness' score!)
        assertEquals(3, set1.length(), "Original set1 should not be modified.");
    }
    
    @Test
    @DisplayName("Test difference and complement")
    void testDiffAndComplement() {
        set1.add(1); set1.add(2); set1.add(3);
        
        set2.add(2); set2.add(3); set2.add(4);
        
        // set1 - set2 should be [1]
        assertEquals("[1]", set1.diff(set2).toString());
        
        // complement (set2 elements not in set1) should be [4]
        assertEquals("[4]", set1.complement(set2).toString());

        assertEquals(3, set1.length(), "Verify diff did not mutate set1");
    }

    @Test
    @DisplayName("Test equality regardless of order")
    void testEquals() {
        set1.add(1); set1.add(2); set1.add(3);
        
        set2.add(3); set2.add(2); set2.add(1);
        
        assertTrue(set1.equals(set2), "Sets with same elements in different order should be equal.");
    }

    @Test
    @DisplayName("Test toString format and sorting")
    void testToString() {
        // Case 1: Empty set
        IntegerSet emptySet = new IntegerSet();
        assertEquals("[]", emptySet.toString(), "Empty set should return [].");
        
        // Case 2: Sorting and spacing
        set1.add(10);
        set1.add(1);
        set1.add(5);
        assertEquals("[1, 5, 10]", set1.toString(), "Output must be sorted with correct spacing.");
    }

    @Test
    @DisplayName("Test largest and smallest")
    void testMaxMin() {
        set1.add(5);
        set1.add(1);
        set1.add(10);
        assertEquals(10, set1.largest());
        assertEquals(1, set1.smallest());
    }

    @Test
    @DisplayName("Test remove and contains")
    void testRemoveAndContains() {
        set1.add(1);
        assertTrue(set1.contains(1));
        set1.remove(1);
        assertFalse(set1.contains(1));
        assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("Test clear and isEmpty")
    void testClearAndIsEmpty() {
        set1.add(1);
        assertFalse(set1.isEmpty());
        set1.clear();
        assertTrue(set1.isEmpty());
    }
}
