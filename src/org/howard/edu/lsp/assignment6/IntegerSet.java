package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet represents a mathematical set of integers.
 * It provides standard set operations like union, intersection, and difference.
 */
public class IntegerSet {
    // Internal storage for the set
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor.
     */
    public IntegerSet() {
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     * @return the length of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks if this set is equal to another IntegerSet.
     * Two sets are equal if they contain the same elements in any order.
     * @param b the other IntegerSet to compare.
     * @return true if sets are equal, false otherwise.
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) {
            return false;
        }
        return set.containsAll(b.set);
    }

    /**
     * Returns true if the set contains the specified value.
     * @param value the value to check for.
     * @return true if value exists in the set.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     * @return the maximum integer in the set.
     * @throws IllegalStateException if the set is empty.
     */
    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     * @return the minimum integer in the set.
     * @throws IllegalStateException if the set is empty.
     */
    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     * @param item the integer to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     * @param item the integer to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new IntegerSet representing the union of this set and intSetb.
     * @param intSetb the set to union with.
     * @return a new IntegerSet containing elements of both sets.
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        for (int item : intSetb.set) {
            result.add(item);
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements common to both sets.
     * @param intSetb the set to intersect with.
     * @return a new IntegerSet with the intersection.
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        result.set.retainAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in this set but not in intSetb.
     * @param intSetb the set to subtract.
     * @return a new IntegerSet with the difference (A - B).
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        result.set.removeAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in intSetb but not in this set.
     * @param intSetb the set to compare against.
     * @return a new IntegerSet with the complement (B - A).
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int item : intSetb.set) {
            if (!this.set.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Checks if the set is empty.
     * @return true if set has no elements.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3]
     * @return formatted string.
     */
    @Override
    public String toString() {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList.toString();
    }
}