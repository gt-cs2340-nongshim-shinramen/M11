package com.example.m6.model;

/**
 * tech level enum
 */
public enum TechLevel {
    PRE_AGRICULTURE(0),
    AGRICULTURE(1),
    MEDIEVAL(2),
    RENAISSANCE(3),
    EARLY_INDUSTRIAL(4),
    INDUSTRIAL(5),
    POST_INDUSTRIAL(6),
    HI_TECH(7);

    @SuppressWarnings({"FieldMayBeFinal", "CanBeFinal"})
    private int code;

    /**
     * tech level
     * @param num tech level
     */
    TechLevel(int num) {
        code = num;
    }

    /**
     * get the number
     * @return number of tech level
     */
    public int getNumber(){
        return code;
    }
}