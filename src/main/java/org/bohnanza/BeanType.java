package org.bohnanza;

public enum BeanType {
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

    private final String name;
    private final int[] harvestValues;

    BeanType(String name, int[] harvestValues) {
        this.name = name;
        this.harvestValues = harvestValues;
    }

    public String getName() {
        return name;
    }

    public int[] getHarvestValues() {
        return harvestValues;
    }
}