package org.example;

public class PosterManager {
    private PosterDTO[] items = new PosterDTO[0];
    private int count;

    public PosterManager() {
        this.count = 5;
    }

    public PosterManager(int count) {
        this.count = count;
    }

    public void add(PosterDTO newItem) {
        PosterDTO[] tmp = new PosterDTO[items.length + 1];
        int i = 0;
        for (PosterDTO item : items) {
            tmp[i] = item;
            i++;
        }
        tmp[items.length] = newItem;
        items = tmp;
    }

    public PosterDTO[] findAll() {
        return items;
    }

    public PosterDTO[] findLast() {
        PosterDTO[] lastPosters = new PosterDTO[Math.min(items.length, count)];
        for (int i = 0; i < lastPosters.length; i++) {
            lastPosters[i] = items[items.length - 1 - i];
        }

        return lastPosters;
    }
}
