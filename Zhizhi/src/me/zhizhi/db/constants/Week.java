package me.zhizhi.db.constants;

public enum Week {

    Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5);

    private int value;

    Week(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
