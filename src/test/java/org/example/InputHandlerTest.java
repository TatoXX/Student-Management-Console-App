package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputHandlerTest {
    @Test
    void testEmptyString() {
        assertFalse(InputHandler.isValidName(""));
    }

    @Test
    void testOnlySpaces() {
        assertFalse(InputHandler.isValidName("   "));
    }

    @Test
    void testSingleCharacter() {
        assertFalse(InputHandler.isValidName("A"));
    }

    @Test
    void testNameWithNumbers() {
        assertFalse(InputHandler.isValidName("John123"));
    }

    @Test
    void testNameWithSpecialCharacters() {
        assertFalse(InputHandler.isValidName("John@Smith"));
    }

    @Test
    void testVeryLongName() {
        String longName = "A".repeat(51);
        assertFalse(InputHandler.isValidName(longName));
    }

    @Test
    void testNameWithMultipleSpaces() {
        assertFalse(InputHandler.isValidName("John    Smith"));
    }

    @Test
    void testNameStartingWithLowercase() {
        assertFalse(InputHandler.isValidName("john"));
    }

    @Test
    void testValidSimpleName() {
        assertTrue(InputHandler.isValidName("John"));
    }

    @Test
    void testValidFullName() {
        assertTrue(InputHandler.isValidName("John Smith"));
    }

    @Test
    void testValidNameWithHyphen() {
        assertTrue(InputHandler.isValidName("Mary-Jane"));
    }

    @Test
    void testValidNameWithApostrophe() {
        assertTrue(InputHandler.isValidName("O'Connor"));
    }



    // EMAIL
    @Test
    public void testValidEmails() {
        assertTrue(InputHandler.isValidEmail("user@example.com"));
        assertTrue(InputHandler.isValidEmail("john.doe+tag@sub.domain.co"));
        assertTrue(InputHandler.isValidEmail("a_b.c-d@domain.org"));
    }

    @Test
    public void testInvalidEmails() {
        assertFalse(InputHandler.isValidEmail("user@@domain.com"));      // multiple @
        assertFalse(InputHandler.isValidEmail("user@"));                // missing domain
        assertFalse(InputHandler.isValidEmail("@domain.com"));          // missing username
        assertFalse(InputHandler.isValidEmail("user name@domain.com")); // space in username
        assertFalse(InputHandler.isValidEmail("user@domain"));          // no extension
        assertFalse(InputHandler.isValidEmail(""));                     // empty string
        assertFalse(InputHandler.isValidEmail("user@.com"));            // domain starts with dot
        assertFalse(InputHandler.isValidEmail("user@domain."));         // domain ends with dot

        // Very long email (>254 chars)
        String localPart = "a".repeat(100);
        String domainPart = "b".repeat(150) + ".com";
        String longEmail = localPart + "@" + domainPart;
        assertFalse(InputHandler.isValidEmail(longEmail));
    }


    @Test
    public void testNullEmail() {
        assertFalse(InputHandler.isValidEmail(null));
    }

    //AGE


        @Test
        public void testIsValidAge() {
            assertTrue(InputHandler.isValidAge(15));
            assertTrue(InputHandler.isValidAge(50));
            assertTrue(InputHandler.isValidAge(100));

            assertFalse(InputHandler.isValidAge(14));
            assertFalse(InputHandler.isValidAge(101));
            assertFalse(InputHandler.isValidAge(-5));
            assertFalse(InputHandler.isValidAge(0));
            assertFalse(InputHandler.isValidAge(999999));
        }

        //Course

        @Test
        public void testIsValidCourse() {
            assertTrue(InputHandler.isValidCourse("CS"));
            assertTrue(InputHandler.isValidCourse("Computer Science"));
            assertTrue(InputHandler.isValidCourse("A".repeat(50)));

            assertFalse(InputHandler.isValidCourse(null));
            assertFalse(InputHandler.isValidCourse(""));
            assertFalse(InputHandler.isValidCourse(" "));
            assertFalse(InputHandler.isValidCourse("A"));           // too short
            assertFalse(InputHandler.isValidCourse("A".repeat(51))); // too long
        }
    }


