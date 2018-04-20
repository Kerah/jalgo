package net.redpandaz.lab.jalgo.impl.uf;

public class Field {
    private int[] id;
    private int count;

    public Field(int count) {
        this.count = count;
        id = new int[count];
        for (int i = 0; i < count; i++)
            id[i] = i;
    }

    public int getId(int index) {
        return id[index];
    }

    public int setID(int index, int value) {
        return id[index] = value;
    }

    public int getCount() {
        return count;
    }

    public void modCount(int mod) {
        count-=mod;
    }
}
