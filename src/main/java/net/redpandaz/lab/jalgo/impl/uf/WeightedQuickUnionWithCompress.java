package net.redpandaz.lab.jalgo.impl.uf;

public class WeightedQuickUnionWithCompress extends WeightedQuickUnion {
    public WeightedQuickUnionWithCompress(int total) {
        super(total);
    }

    @Override
    public int find(int p) {
        int root = p;
        while (root != field.getId(root)) root = field.getId(root);
        while (p != root) {
            int n = field.getId(p);
            field.setID(p, root);
            p = n;
        }
        return root;
    }
}
