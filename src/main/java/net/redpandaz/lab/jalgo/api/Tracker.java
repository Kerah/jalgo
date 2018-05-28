package net.redpandaz.lab.jalgo.api;

public interface Tracker {
    Tracker incAllocates();
    Tracker incMoves();
    Tracker incCompares();
    Tracker incIterates();

    Tracker addAllocates(int value);
    Tracker addMoves(int value);
    Tracker addCompares(int value);
    Tracker addIterates(int value);
}
