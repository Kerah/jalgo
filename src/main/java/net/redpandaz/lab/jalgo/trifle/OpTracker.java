package net.redpandaz.lab.jalgo.trifle;

import net.redpandaz.lab.jalgo.api.Tracker;

public class OpTracker implements Tracker {
    private int iterates;
    private int compares;
    private int moves;
    private int allocates;

    public Tracker incIterates() {
        iterates++;
        return this;
    }

    public Tracker incCompares() {
        compares++;
        return this;
    }
    public Tracker incMoves() {
        moves++;
        return this;
    }
    public Tracker incAllocates() {
        allocates++;
        return this;
    }

    public Tracker addIterates(int value) {
        iterates+= value;
        return this;
    }

    public Tracker addCompares(int value) {
        compares += value;
        return this;
    }
    public Tracker addMoves(int value) {
        moves += value;
        return this;
    }
    public Tracker addAllocates(int value) {
        allocates += value;
        return this;
    }

    public int getIterates() {
        return iterates;
    }

    public int getCompares() {
        return compares;
    }

    public int getMoves() {
        return moves;
    }

    public int getAllocates() {
        return allocates;
    }

    public int total() {
        return allocates + moves + compares + iterates;
    }
}
