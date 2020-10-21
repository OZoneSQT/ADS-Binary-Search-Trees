package util;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class StackInterfaceTest {

    private StackInterface<String> stackInterface;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange
        stackInterface = new StackLIFO<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stackIsEmptyTrue(){
        // Assert
        assertTrue(stackInterface.isEmpty());
    }

    @Test
    void stackIsEmptyFalse(){
        // Act
        stackInterface.push("Alpha");
        // Assert
        assertFalse(stackInterface.isEmpty());
    }

    @Test
    void pushOne() {
        // Act
        stackInterface.push("Alpha");
        // Assert
        assertEquals(1, stackInterface.size());
    }

    @Test
    void pushMore() {
        // Act
        stackInterface.push("Alpha");
        stackInterface.push("Beta");
        stackInterface.push("Charlie");
        stackInterface.push("Delta");
        stackInterface.push("Echo");
        // Assert
        assertEquals(5, stackInterface.size());
    }

    @Test
    void pushIllegalArgumentException() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");
        // Act
        stackInterface.push(null);
    }

    @Test
    void popZeroIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Stack is empty");
        // Act
        stackInterface.pop();
    }

    @Test
    void popOne() {
        // Act
        stackInterface.push("Alpha");
        stackInterface.push("Beta");
        // Assert - First in, first out
        assertEquals("Beta", stackInterface.pop());
    }

    @Test
    void popMore() {
        // Act
        stackInterface.push("Alpha");
        stackInterface.push("Beta");
        stackInterface.push("Charlie");
        stackInterface.push("Delta");
        stackInterface.push("Echo");

        // Assert - Last in, first out
        assertEquals("Echo", stackInterface.pop());
        assertEquals("Delta", stackInterface.pop());
        assertEquals("Charlie", stackInterface.pop());
        assertEquals("Beta", stackInterface.pop());
        assertEquals("Alpha", stackInterface.pop());
    }

    @Test
    void peekStackOne(){
        // Act
        stackInterface.push("Alpha");
        // Assert - First in, first out
        assertEquals("Alpha", stackInterface.peek());
    }

    @Test
    void peekStackMore(){
        // Act
        stackInterface.push("Alpha");
        stackInterface.push("Beta");
        // Assert - First in, first out
        assertEquals("Beta", stackInterface.peek());
    }

    @Test
    void peekEmptyStackIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Stack is empty");
        // Act
        stackInterface.peek();
    }

    @Test
    void sizeZeroTrue() {
        // Act

        // Assert
        assertEquals(0, stackInterface.size());
    }

    @Test
    void sizeZeroFalse() {
        // Act
        stackInterface.push("Alpha");
        // Assert
        assertFalse(equals(0 == stackInterface.size()));
    }

    @Test
    void sizeOne() {
        // Act
        stackInterface.push("Alpha");
        // Assert
        assertEquals(1, stackInterface.size());
    }

    @Test
    void isEmptyTrue() {
        // Act

        // Assert
        assertTrue(stackInterface.isEmpty() == true);
    }

    @Test
    void isEmptyFalse() {
        // Act
        stackInterface.push("Alpha");
        // Assert
        assertTrue(stackInterface.isEmpty() == false);
    }
}