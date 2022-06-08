package org.sbutterfly;

/**
 * DisjoinSet is a classic data structure to union numbers in groups.
 */
public class DisjointSet {

    private final int[] set;
    private final int[] rank;

    public DisjointSet(int n) {
        this.set = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n;i++) {
            this.set[i] = i;
            this.rank[i] = 1;
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
            if (this.rank[a] == this.rank[b]) {
                this.set[a] = b;
                this.rank[b]++;
            } else if (this.rank[a] > this.rank[b]) {
                this.set[b] = a;
            } else {
                this.set[a] = b;
            }
        }
    }
}
