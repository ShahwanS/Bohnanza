package org.bohnanza;

public class Card {
    private String name;
    private BeanType beanType;
    private int value;
    private String image;
    private String description;

    public Card(String name, BeanType beanType, int value, String image, String description) {
        this.name = name;
        this.beanType = beanType;
        this.value = value;
        this.image = image;
        this.description = description;
    }

    // Getters and setters for attributes

    public String getName() {
        return name;
    }

    public BeanType getBeanType() {
        return beanType;
    }

    public int getValue() {
        return value;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeanType(BeanType beanType) {
        this.beanType = beanType;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}