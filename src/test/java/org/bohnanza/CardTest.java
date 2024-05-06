package org.bohnanza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card;

    @BeforeEach
    void setUp() {
       // Card example
        card = new Card("Green Bean", BeanType.GREEN_BEAN, 5, "green_bean.jpg", "Useful in many dishes.");
    }

    @Test
    void getName() {
        assertEquals("Green Bean", card.getName(), "The name should be 'Green Bean'");
    }

    @Test
    void getBeanType() {
        assertEquals(BeanType.GREEN_BEAN, card.getBeanType(), "The bean type should be GREEN_BEAN");
    }

    @Test
    void getValue() {
        assertEquals(5, card.getValue(), "The value should be 5.");
    }

    @Test
    void getImage() {
        assertEquals("green_bean.jpg", card.getImage(), "The image should be 'green_bean.jpg'");
    }

    @Test
    void getDescription() {
        assertEquals("Useful in many dishes.", card.getDescription(), "The description should be 'Useful in many dishes.'");
    }

    @Test
    void setName() {
        card.setName("Red Bean");
        assertEquals("Red Bean", card.getName(), "After setting, the name should be 'Red Bean'");
    }

    @Test
    void setBeanType() {
        card.setBeanType(BeanType.RED_BEAN);
        assertEquals(BeanType.RED_BEAN, card.getBeanType(), "After setting, the bean type should be RED_BEAN");
    }

    @Test
    void setValue() {
        card.setValue(10);
        assertEquals(10, card.getValue(), "After setting, the value should be 10.");
    }

    @Test
    void setImage() {
        card.setImage("red_bean.jpg");
        assertEquals("red_bean.jpg", card.getImage(), "After setting, the image should be 'red_bean.jpg'");
    }

    @Test
    void setDescription() {
        card.setDescription("Great for chili.");
        assertEquals("Great for chili.", card.getDescription(), "After setting, the description should be 'Great for chili.'");
    }
}
