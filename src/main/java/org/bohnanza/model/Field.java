package org.bohnanza.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Card> beans;

    public Field() {
        this.beans = new ArrayList<>();
    }

    public void plantBean(Card card) {
        beans.add(card);
    }

    public List<Card> harvest() {
        List<Card> harvested = new ArrayList<>(beans);
        beans.clear();
        return harvested;
    }

    public int getBeanCount() {
        return beans.size();
    }

    public boolean isCompatible(Card card) {
        return beans.isEmpty() || beans.get(0).getBeanType() == card.getBeanType();
    }

    public List<Card> getBeans() {
        return beans;
    }
}