package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//A TorpedoStore unit tesztelése
/*
Hasznos metódusok teszteléshez:
Megfigyelés:
    int getTorpedoCount()
    boolean isEmpty()
Irányítás:
    boolean fire(int numberOfTorpedos)
    TorpedoStore(int numberOfTorpedos, double failureRate)
*/
// Milyen teszteket szeretnék: 
class TorpedoStoreTest {
    private TorpedoStore store;

    @BeforeEach
    void setup(){
        store = new TorpedoStore(53);
    }

    @Test
    void fire_Success() {
        // Arrange
        //TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void ctor_number_of_torpedoes(){
        int amount = store.getTorpedoCount();

        assertEquals(amount, 53);
    }

    @Test
    void fire_invalid_call_value_under(){
        String err="";
        try{
            boolean result1 = store.fire(-1);
        }catch(IllegalArgumentException ia){
            err = ia.getMessage();
        }
        
        assertEquals(err, "numberOfTorpedos");
    }

    @Test
    void fire_invalid_call_value_over(){
        String err="";
        try{
            boolean result2 = store.fire(54);
        }catch(IllegalArgumentException ia){
            err = ia.getMessage();
        }

        assertEquals(err, "numberOfTorpedos");
    }

    @Test
    void fire_counter_decrease(){
        store.fire(53);

        boolean result = store.isEmpty();

        assertEquals(result, true);
    }

    @Test
    void fire_failure(){
        store = new TorpedoStore(1, 1);

        boolean result = store.fire(1);

        assertEquals(result, false);
    }
}
