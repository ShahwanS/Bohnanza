package org.bohnanza.model;

public class Card {
    private final BeanType beanType;

    public Card(BeanType beanType) {
        this.beanType = beanType;
    }

    public BeanType getBeanType() {
        return beanType;
    }
}