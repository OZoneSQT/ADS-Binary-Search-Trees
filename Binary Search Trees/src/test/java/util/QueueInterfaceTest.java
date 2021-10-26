package util;

/*
 * Copyright (c) $originalComment.match("Copyright \(c\) (\d+)", 1, "-")$today.year.
 *
 * OZ1SQT, Michel S. E. Sommer
 * https://Seahawk.dk
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Rule;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;
import org.junit.rules.ExpectedException;
import tree.util.QueueFIFO;
import tree.util.QueueInterface;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
class QueueInterfaceTest {
    private QueueInterface<String> myQueueInterface;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @BeforeEach
    void setUp() {
        // Arrange
        myQueueInterface = new QueueFIFO<>(5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void queueIsEmptyTrue(){
        // Assert
        assertTrue(myQueueInterface.isEmpty());
    }

    @Test
    void queueIsEmptyFalse(){
        // Act
        myQueueInterface.enqueue("Alpha");
        // Assert
        assertFalse(myQueueInterface.isEmpty());
    }

    @Test
    void enqueueOne() {
        // Act
        myQueueInterface.enqueue("Alpha");
        // Assert
        assertTrue(myQueueInterface.contains("Alpha"));
        assertEquals(1, myQueueInterface.size());
    }

    @Test
    void enqueueMore() {
        // Act
        myQueueInterface.enqueue("Alpha");
        myQueueInterface.enqueue("Beta");
        myQueueInterface.enqueue("Charlie");
        myQueueInterface.enqueue("Delta");
        myQueueInterface.enqueue("Echo");
        // Assert
        assertTrue(myQueueInterface.contains("Alpha"));
        assertTrue(myQueueInterface.contains("Beta"));
        assertTrue(myQueueInterface.contains("Charlie"));
        assertTrue(myQueueInterface.contains("Delta"));
        assertTrue(myQueueInterface.contains("Echo"));
        assertEquals(5, myQueueInterface.size());
    }

    @Test
    void enqueueIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Queue is full");
        // Act
        myQueueInterface.enqueue("Alpha");
        myQueueInterface.enqueue("Beta");
        myQueueInterface.enqueue("Charlie");
        myQueueInterface.enqueue("Delta");
        myQueueInterface.enqueue("Echo");
        myQueueInterface.enqueue("Golf");
    }

    @Test
    void enqueueIllegalArgumentException() {
        // Assert
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null is not allowed");
        // Act
        myQueueInterface.enqueue(null);
    }

    @Test
    void dequeueZeroIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Queue is empty");
        // Act
        myQueueInterface.dequeue();
    }

    @Test
    void dequeueOne() {
        // Act
        myQueueInterface.enqueue("Alpha");
        myQueueInterface.enqueue("Beta");
        myQueueInterface.dequeue();
        // Assert - First in, first out
        assertFalse(myQueueInterface.contains("Alpha"));
        assertTrue(myQueueInterface.contains("Beta"));
        assertEquals(1, myQueueInterface.size());
    }

    @Test
    void dequeueMore() {
        // Act
        myQueueInterface.enqueue("Alpha");
        myQueueInterface.enqueue("Beta");
        myQueueInterface.enqueue("Charlie");
        myQueueInterface.enqueue("Delta");
        myQueueInterface.enqueue("Echo");

        for (int i = 0; i < 4 ; i++) {
            myQueueInterface.dequeue();
        }

        // Assert - First in, first out
        assertFalse(myQueueInterface.contains("Alpha"));
        assertFalse(myQueueInterface.contains("Beta"));
        assertFalse(myQueueInterface.contains("Charlie"));
        assertFalse(myQueueInterface.contains("Delta"));
        assertTrue(myQueueInterface.contains("Echo"));
        assertEquals(1, myQueueInterface.size());
    }

    @Test
    void first() {
        // Act
        myQueueInterface.enqueue("Alpha");
        // Assert
        assertTrue(myQueueInterface.dequeue() == "Alpha");
    }

    @Test
    void firstIllegalStateException() {
        // Assert
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Queue is empty");
        // Act
        myQueueInterface.first();
    }

    @Test
    void sizeZeroTrue() {
        // Act

        // Assert
        assertEquals(0, myQueueInterface.size());
    }

    @Test
    void sizeZeroFalse() {
        // Act
        myQueueInterface.enqueue("Alpha");
        // Assert
        assertFalse(equals(0 == myQueueInterface.size()));
    }

    @Test
    void sizeOne() {
        // Act
        myQueueInterface.enqueue("Alpha");
        // Assert
        assertEquals(1, myQueueInterface.size());
    }

    @Test
    void isEmptyTrue() {
        // Act

        // Assert
        assertTrue(myQueueInterface.isEmpty() == true);
    }

    @Test
    void isEmptyFalse() {
        // Act
        myQueueInterface.enqueue("Alpha");
        // Assert
        assertTrue(myQueueInterface.isEmpty() == false);
    }

    @Test
    void indexOf() {
        // Act
        myQueueInterface.enqueue("Alpha");
        myQueueInterface.enqueue("Beta");
        // Assert
        assertFalse(myQueueInterface.indexOf("Beta") == 0);
        assertTrue(myQueueInterface.indexOf("Beta") == 1 );
        myQueueInterface.dequeue();
        assertTrue(myQueueInterface.indexOf("Beta") == 0 );
    }

    @Test
    void containsFull() {
        // Act
        myQueueInterface.enqueue("Alpha");
        myQueueInterface.enqueue("Beta");
        myQueueInterface.enqueue("Charlie");
        myQueueInterface.enqueue("Delta");
        myQueueInterface.enqueue("Echo");
        // Assert
        assertTrue(myQueueInterface.contains("Echo"));
        assertFalse(myQueueInterface.contains("Golf"));
    }

    @Test
    void containsMore() {
        // Act
        myQueueInterface.enqueue("Alpha");
        myQueueInterface.enqueue("Beta");
        myQueueInterface.enqueue("Charlie");
        myQueueInterface.enqueue("Delta");
        myQueueInterface.enqueue("Echo");
        // Assert
        assertTrue(myQueueInterface.contains("Alpha"));
        assertTrue(myQueueInterface.contains("Beta"));
        assertTrue(myQueueInterface.contains("Charlie"));
        assertTrue(myQueueInterface.contains("Delta"));
        assertTrue(myQueueInterface.contains("Echo"));
        assertFalse(myQueueInterface.contains("Golf"));
        // Act
        for (int i = 0; i < 5; i++) {
            myQueueInterface.dequeue();
        }
        myQueueInterface.enqueue("Golf");
        myQueueInterface.enqueue("Hotel");
        myQueueInterface.enqueue("India");
        myQueueInterface.enqueue("Juliett");
        myQueueInterface.enqueue("Kilo");
        // Assert
        assertTrue(myQueueInterface.contains("Golf"));
        assertTrue(myQueueInterface.contains("Hotel"));
        assertTrue(myQueueInterface.contains("India"));
        assertTrue(myQueueInterface.contains("Juliett"));
        assertTrue(myQueueInterface.contains("Kilo"));
        assertFalse(myQueueInterface.contains("Lima"));
    }

}