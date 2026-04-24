package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class GradeCalculatorTest {
    private final GradeCalculator calc = new GradeCalculator();

    @Test
    void testAverage() {
        assertEquals(80.0, calc.average(70, 80, 90));
    }

    @Test
    void testLetterGrade() {
        assertEquals("A", calc.letterGrade(95.0));
        assertEquals("F", calc.letterGrade(50.0));
    }

    @Test
    void testIsPassing() {
        assertTrue(calc.isPassing(60.0));
        assertFalse(calc.isPassing(59.9));
    }

    @Test
    @DisplayName("Boundary Value Tests")
    void testBoundaries() {
        assertEquals("A", calc.letterGrade(90.0), "90 should be an A");
        assertEquals(100.0, calc.average(100, 100, 100));
    }

    @Test
    @DisplayName("Exception Tests")
    void testExceptions() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(-1, 50, 50));
        assertThrows(IllegalArgumentException.class, () -> calc.average(101, 50, 50));
    }
}