package me.zhizhi.db.constants;

public enum Cycle {

    Weekly(0), SingleWeekly(1), Biweekly(2);

    private int value;

    Cycle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
