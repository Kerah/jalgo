package net.redpandaz.lab.jalgo.trifle;

import net.redpandaz.lab.jalgo.api.Tracker;

// dev/null collector
public class DNTracker implements Tracker {

    @Override
    public Tracker incAllocates() {
        return this;
    }

    @Override
    public Tracker incMoves() {
        return this;
    }

    @Override
    public Tracker incCompares() {
        return this;
    }

    @Override
    public Tracker incIterates() {
        return this;
    }

    @Override
    public Tracker addAllocates(int value) {
        return this;
    }

    @Override
    public Tracker addMoves(int value) {
        return this;
    }

    @Override
    public Tracker addCompares(int value) {
        return this;
    }

    @Override
    public Tracker addIterates(int value) {
        return this;
    }
}
