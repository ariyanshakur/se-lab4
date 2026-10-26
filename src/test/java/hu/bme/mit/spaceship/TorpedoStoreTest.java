
package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        boolean result = store.fire(1);

        assertTrue(result);
        assertEquals(4, store.getTorpedoCount());
    }

    @Test
    void fire_Failure() {
        TorpedoStore store = new TorpedoStore(5, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void fire_AllTorpedoes() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertTrue(store.fire(5));

        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_ZeroTorpedoes() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(0));
    }

    @Test
    void fire_TooManyTorpedoes() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(6));
    }

    @Test
    void fire_NegativeTorpedoes() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertThrows(IllegalArgumentException.class,
                () -> store.fire(-1));
    }

    @Test
    void store_InitiallyEmpty() {
        TorpedoStore store = new TorpedoStore(0, 0.0);

        assertTrue(store.isEmpty());
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void store_InitiallyNotEmpty() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        assertFalse(store.isEmpty());
        assertEquals(5, store.getTorpedoCount());
    }
}
