package com.harmyFounder.harmyWorld.models.enums;

public enum TaskStatus {
    NO_STATUS(0),
    NEXT_UP(1),
    IN_PROGRESS(2),
    COMPLETED(3);

    private final int index;

    public int getIndex() {
        return index;
    }

    TaskStatus(int index) {
        this.index = index;
    }
}
