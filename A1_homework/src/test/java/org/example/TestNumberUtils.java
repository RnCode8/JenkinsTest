package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;


/* Partitions (Understand the Requirements is in readme.md)
 * Individual (str, open, tag)
 * - Null
 * - Empty str
 * - str = 1
 * - str > 1
 * - Interaction:
 * - Invalid digits
 * - Leading zeros
 *
 * Combination of input
 * - Both are null
 * - One is null one is str
 * - Both are empty str
 * - One is empty str one is a str
 * - Both are strs
 * - One is invalid str (open / close)
 *
 * Output Partitions
 * - Sum
 * - Carry creates the extra digit like 9+1 = 10
 * - Leading zeros are removed
 * - Empty result
 * */


class TestNumberUtils {

    @Tag("specification")
    @Test
    void SingleDigitNoCarry() {
        assertEquals(List.of(7),
                NumberUtils.add(new ArrayList<>(List.of(3)), new ArrayList<>(List.of(4))));
    }

    @Tag("specification")
    @Test
    void SingleDigitWithCarry() {
        assertEquals(List.of(1, 2),
                NumberUtils.add(new ArrayList<>(List.of(7)), new ArrayList<>(List.of(5))));
    }

    @Tag("specification")
    @Test
    void SameLengthCarryLeastSignificant() {
        assertEquals(List.of(1, 0, 2),
                NumberUtils.add(new ArrayList<>(List.of(9, 9)), new ArrayList<>(List.of(0, 3))));
    }

    @Tag("specification")
    @Test
    void SameLengthCarryMiddle() {
        assertEquals(List.of(2, 0, 2),
                NumberUtils.add(new ArrayList<>(List.of(1, 9, 1)), new ArrayList<>(List.of(0, 1, 1))));
    }

    @Tag("specification")
    @Test
    void DifferentLengthNoCarry() {
        assertEquals(List.of(1, 3, 4),
                NumberUtils.add(new ArrayList<>(List.of(1, 2, 3)), new ArrayList<>(List.of(1, 1))));
    }

    @Tag("specification")
    @Test
    void DifferentLengthManyCarries() {
        assertEquals(List.of(1, 0, 0, 0),
                NumberUtils.add(new ArrayList<>(List.of(9, 9, 9)), new ArrayList<>(List.of(1))));
    }

    @Tag("specification")
    @Test
    void LeadingZerosRemoved() {
        assertEquals(List.of(1, 2),
                NumberUtils.add(new ArrayList<>(List.of(0, 1)), new ArrayList<>(List.of(1, 1))));
    }

    @Tag("structural")
    @Test
    void NullInputsReturnNull() {
        assertNull(NumberUtils.add(null, null));
        assertNull(NumberUtils.add(new ArrayList<>(List.of(1)), null));
        assertNull(NumberUtils.add(null, new ArrayList<>(List.of(1))));
    }

    @Tag("structural")
    @Test
    void LeftEmptyReturnsRight() {
        assertEquals(List.of(2, 5),
                NumberUtils.add(new ArrayList<>(), new ArrayList<>(List.of(2, 5))));
    }

    @Tag("structural")
    @Test
    void RightEmptyReturnsLeft() {
        assertEquals(List.of(8, 7),
                NumberUtils.add(new ArrayList<>(List.of(8, 7)), new ArrayList<>()));
    }

    @Tag("structural")
    @Test
    void FinalCarryBranchExecuted() {
        assertEquals(List.of(1, 0),
                NumberUtils.add(new ArrayList<>(List.of(9)), new ArrayList<>(List.of(1))));
    }

    @Tag("structural")
    @Test
    void NegativeDigitLeftThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberUtils.add(new ArrayList<>(List.of(-1)), new ArrayList<>(List.of(1))));
    }

    @Tag("structural")
    @Test
    void NegativeDigitRightThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberUtils.add(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(-1))));
    }

    @Tag("structural")
    @Test
    void InvalidDigitInsideLeftListThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberUtils.add(new ArrayList<>(List.of(1, 11, 1)), new ArrayList<>(List.of(1))));
    }

    @Tag("structural")
    @Test
    void InvalidDigitInsideRightListThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberUtils.add(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(1, 11, 1))));
    }

    @Tag("structural")
    @Test
    void InputListsAreReversedAsSideEff() {
        List<Integer> left = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> right = new ArrayList<>(List.of(4, 5, 6));
        NumberUtils.add(left, right);
        assertEquals(List.of(3, 2, 1), left);
        assertEquals(List.of(6, 5, 4), right);
    }

    @Tag("structural")
    @Test
    void BothNonNull() {
        assertEquals(List.of(2),
                NumberUtils.add(new ArrayList<>(List.of(1)), new ArrayList<>(List.of(1))));
    }

    @Tag("structural")
    @Test
    void LeftShorterThanRightZeroPadding() {
        assertEquals(List.of(1,0,5),
                NumberUtils.add(
                        new ArrayList<>(List.of(5)), new ArrayList<>(List.of(1,0,0))));
    }

    @Tag("structural")
    @Test
    void RightShorterThanLeftZeroPadding() {
        assertEquals(List.of(1,0,5),
                NumberUtils.add(
                        new ArrayList<>(List.of(1,0,0)), new ArrayList<>(List.of(5))));
    }

    @Tag("structural")
    @Test
    void LeftDigitGreaterThanThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> NumberUtils.add(
                        new ArrayList<>(List.of(10)), new ArrayList<>(List.of(1))));
    }

    @Tag("structural")
    @Test
    void NoFinalCarryBranch() {
        assertEquals(List.of(5),
                NumberUtils.add(new ArrayList<>(List.of(2)), new ArrayList<>(List.of(3))));
    }

    @Tag("structural")
    @Test
    void MultipleLeadingZerosAreRemoved() {
        assertEquals(List.of(7),
                NumberUtils.add(new ArrayList<>(List.of(0,0,3)), new ArrayList<>(List.of(0,0,4))));
    }

}