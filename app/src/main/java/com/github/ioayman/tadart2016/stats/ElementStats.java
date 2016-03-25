package com.github.ioayman.tadart2016.stats;

/**
 * [3/25/16:20:51]
 *
 * @author @IOAyman
 */
public class ElementStats {
    private int hits;
    private int imageNumber;

    public ElementStats(int hits, int imageNumber) {
        this.hits = hits;
        this.imageNumber = imageNumber;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }
}
