package org.bohnanza.model;

public enum BeanType {
    // Enum constants with name and corresponding harvest values
    GARDEN_BEAN("Garden Bean", new int[]{2, 3, 4, 6}),
    RED_BEAN("Red Bean", new int[]{2, 3, 4, 5}),
    BLACK_EYED_BEAN("Black-eyed Bean", new int[]{4, 5, 6, 7}),
    SOY_BEAN("Soy Bean", new int[]{2, 4, 6, 7}),
    GREEN_BEAN("Green Bean", new int[]{3, 5, 7, 8}),
    STINK_BEAN("Stink Bean", new int[]{3, 5, 7, 8}),
    CHILI_BEAN("Chili Bean", new int[]{3, 6, 8, 9}),
    BLUE_BEAN("Blue Bean", new int[]{4, 6, 8, 10}),
    WAX_BEAN("Wax Bean", new int[]{4, 7, 9, 11}),
    COFFEE_BEAN("Coffee Bean", new int[]{4, 7, 10, 12});

    // Name of the bean type
    private final String name;
    // Harvest values for the bean type
    private final int[] harvestValues;

    // Constructor to initialize the name and harvest values
    BeanType(String name, int[] harvestValues) {
        this.name = name;
        this.harvestValues = harvestValues;
    }

    // Returns the name of the bean type
    public String getName() {
        return name;
    }

    // Returns the harvest values for the bean type
    public int[] getHarvestValues() {
        return harvestValues;
    }
}
