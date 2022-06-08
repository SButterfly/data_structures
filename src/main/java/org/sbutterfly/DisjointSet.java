package org.sbutterfly;

/**
 * DisjoinSet is a classic data structure to union numbers in groups.
 */
public class DisjointSet {

    private final int[] set;

    public DisjointSet(int n) {
        this.set = new int[n];
        for (int i = 0; i < n;i++) {
            this.set[i] = i;
        }
    }

    public int getGroup(int i) {
        if (this.set[i] != i) {
            this.set[i] = getGroup(this.set[i]);
        }
        return this.set[i];
    }

    public void unit(int x, int y) {
        int a = getGroup(x);
        int b = getGroup(y);

        if (a != b) {
            this.set[a] = b;
        }
    }
}
