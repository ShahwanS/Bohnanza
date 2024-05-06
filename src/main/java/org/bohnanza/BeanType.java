package org.bohnanza;

public enum BeanType {
    SOY_BEAN("Soy Bean"),
    GREEN_BEAN("Green Bean"),
    RED_BEAN("Red Bean"),
    CHILI_BEAN("Chili Bean"),
    STINK_BEAN("Stink Bean"),
    WAX_BEAN("Wax Bean"),
    BLUE_BEAN("Blue Bean"),
    COFFEE_BEAN("Coffee Bean"),
    BLACK_EYED_BEAN("Black-eyed Bean"),
    SOY_BEAN_PLUS("Soy Bean+");

    private final String displayName;

    BeanType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}