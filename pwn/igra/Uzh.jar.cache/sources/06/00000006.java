package org.ugra.uzh;

import java.util.Random;

/* loaded from: Uzh.jar:org/ugra/uzh/UzhWorld.class */
public class UzhWorld {
    public static final byte CELLS_X = 40;
    public static final byte CELLS_Y = 30;
    public static final int FRUIT_STEP_DELAY_SCALE = 1000;
    public static final int FRUIT_STEP_DELAY_K = 3000;

    /* renamed from: a */
    private Random f26a;

    /* renamed from: a */
    private UzhBody f27a;

    /* renamed from: a */
    private Point f28a;

    /* renamed from: a */
    private boolean f29a = false;

    /* renamed from: a */
    private int f30a = 400;

    /* renamed from: b */
    private int f31b = 0;

    public UzhWorld(long j, byte b) {
        this.f26a = new Random(j);
        this.f27a = new UzhBody(new Point((byte) 20, (byte) 15), b, (byte) 5);
        m0a();
    }

    public UzhBody getBody() {
        return this.f27a;
    }

    public Point getFruit() {
        return this.f28a;
    }

    public int getStepDelay() {
        return this.f30a;
    }

    public int getEatenFruits() {
        return this.f31b;
    }

    public boolean advance(byte b) {
        this.f27a.advanceHead(b);
        if (this.f29a) {
            this.f29a = false;
        } else {
            this.f27a.shrinkTail();
        }
        Point point = this.f27a.getHeadSegment().head;
        if (this.f27a.headIntersects() || point.f1x < 0 || point.f2y < 0 || point.f1x >= 40 || point.f2y >= 30) {
            return false;
        }
        if (this.f28a.equals(this.f27a.getHeadSegment().head)) {
            this.f29a = true;
            m0a();
            this.f30a = (this.f30a * FRUIT_STEP_DELAY_SCALE) / FRUIT_STEP_DELAY_K;
            this.f31b++;
            return true;
        }
        return true;
    }

    /* renamed from: a */
    private void m0a() {
        do {
            this.f28a = new Point((byte) (Math.abs(this.f26a.nextInt()) % 40), (byte) (Math.abs(this.f26a.nextInt()) % 30));
        } while (this.f27a.pointIntersects(this.f28a));
    }
}