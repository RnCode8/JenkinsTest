import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;

class TestLeftPadUtils {

    @Tag("specification")
    @Test
    void NullStringReturnsNull() {
        assertNull(LeftPadUtils.leftPad(null, 5, "*"));
    }

    @Tag("specification")
    @Test
    void EmptyStringWithPositiveSize() {
        assertEquals("   ", LeftPadUtils.leftPad("", 3, " "));
    }

    @Tag("specification")
    @Test
    void SizeLessThanStringLengthReturnsOriginal() {
        assertEquals("hello", LeftPadUtils.leftPad("hello", 3, "*"));
    }

    @Tag("specification")
    @Test
    void SizeEqualToStringLengthReturnsOriginal() {
        assertEquals("hi", LeftPadUtils.leftPad("hi", 2, "*"));
    }

    @Tag("specification")
    @Test
    void PadWithSingleCharacter() {
        assertEquals("***hi", LeftPadUtils.leftPad("hi", 5, "*"));
    }

    @Tag("specification")
    @Test
    void PadWithMultipleCharactersExact() {
        assertEquals("**hi", LeftPadUtils.leftPad("hi", 4, "**"));
    }

    @Tag("specification")
    @Test
    void PadWithMultipleCharactersPartial() {
        assertEquals("*hi", LeftPadUtils.leftPad("hi", 3, "**"));
    }

    @Tag("specification")
    @Test
    void PadRepeatsPatternWhenNeeded() {
        assertEquals("ababhi", LeftPadUtils.leftPad("hi", 6, "ab"));
    }

    @Tag("specification")
    @Test
    void NullPadStringDefaultsSpaces() {
        assertEquals("  hi", LeftPadUtils.leftPad("hi", 4, null));
    }

    @Tag("specification")
    @Test
    void EmptyPadStringDefaultsSpaces() { assertEquals("  hi", LeftPadUtils.leftPad("hi", 4, "")); }

    @Tag("structural")
    @Test
    void PadsEqualsPadLengthBranch() { assertEquals("xyzhi", LeftPadUtils.leftPad("hi", 5, "xyz")); }

    @Tag("structural")
    @Test
    void PadsLessThanPadLengthBranch() { assertEquals("xyhi", LeftPadUtils.leftPad("hi", 4, "xyz")); }

    @Tag("structural")
    @Test
    void PadsGreaterThanPadLengthLoopBranch() { assertEquals("xyhi", LeftPadUtils.leftPad("hi", 4, "xy")); }

    @Tag("structural")
    @Test
    void PadsZeroOrNegativeBranch() { assertEquals("hi", LeftPadUtils.leftPad("hi", 1, "*")); }
}

