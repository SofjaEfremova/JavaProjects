import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @org.junit.jupiter.api.Test
    void setSecretValue() {
        Model model = new Model();
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        for (int i = 0; i <= 100; i++ ) {
            model.setSecretValue();
            int secretValue = model.getSecretValue();

            assertTrue(secretValue > GlobalConstants.PRIMARY_MIN_BARRIER);
            assertTrue(secretValue < GlobalConstants.PRIMARY_MAX_BARRIER);
        }
    }

    @org.junit.jupiter.api.Test
    void checkValue() {
        Model model = new Model();
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setSecretValue();
        int secretValue = model.getSecretValue();
        List<Integer> expectedWay = new ArrayList<Integer>();

        expectedWay.add(secretValue + 1);
        assertTrue(model.checkValue(secretValue + 1));
        assertEquals(secretValue + 1, model.getMaxBarrier());

        expectedWay.add(secretValue - 1);
        assertTrue(model.checkValue(secretValue - 1));
        assertEquals(secretValue - 1, model.getMinBarrier());

        expectedWay.add(secretValue);
        assertFalse(model.checkValue(secretValue));

        assertEquals(expectedWay, model.getYourWay());
    }

    @org.junit.jupiter.api.Test
    void setPrimaryBarrier() {
        Model model = new Model();
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        assertEquals(GlobalConstants.PRIMARY_MIN_BARRIER, model.getMinBarrier());
        assertEquals(GlobalConstants.PRIMARY_MAX_BARRIER, model.getMaxBarrier());
    }

    @org.junit.jupiter.api.Test
    void getSecretValue() {
        Model model = new Model();
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setSecretValue();
        int secretValue = model.getSecretValue();

        assertTrue(secretValue > GlobalConstants.PRIMARY_MIN_BARRIER);
        assertTrue(secretValue < GlobalConstants.PRIMARY_MAX_BARRIER);
    }

    @org.junit.jupiter.api.Test
    void getMinBarrier() {
        Model model = new Model();
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        assertEquals(GlobalConstants.PRIMARY_MIN_BARRIER, model.getMinBarrier());
    }

    @org.junit.jupiter.api.Test
    void getMaxBarrier() {
        Model model = new Model();
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        assertEquals(GlobalConstants.PRIMARY_MAX_BARRIER, model.getMaxBarrier());
    }

    @org.junit.jupiter.api.Test
    void getYourWay() {
        Model model = new Model();
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setSecretValue();
        int secretValue = model.getSecretValue();
        List<Integer> expectedWay = new ArrayList<Integer>();

        expectedWay.add(secretValue + 1);
        assertTrue(model.checkValue(secretValue + 1));
        assertEquals(secretValue + 1, model.getMaxBarrier());

        expectedWay.add(secretValue - 1);
        assertTrue(model.checkValue(secretValue - 1));
        assertEquals(secretValue - 1, model.getMinBarrier());

        expectedWay.add(secretValue);
        assertFalse(model.checkValue(secretValue));

        assertEquals(expectedWay, model.getYourWay());
    }
}