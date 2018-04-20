package net.redpandaz.lab.jalgo.impl.uf;
// 1.5.12
public class QuickUnionWithCompress extends QuickUnion {
    QuickUnionWithCompress(int total) {
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
