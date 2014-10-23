package me.zhizhi.db.constants;

public enum Lessions {

    Morning1(1), Morning2(2), Afternoon1(3), Afternoon2(4), Night(5);

    private int value;

    Lessions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
