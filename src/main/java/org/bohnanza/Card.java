package org.bohnanza;

public class Card {
    private final BeanType beanType;

    public Card(BeanType beanType) {
        this.beanType = beanType;
    }

    public BeanType getBeanType() {
        return beanType;
    }
}