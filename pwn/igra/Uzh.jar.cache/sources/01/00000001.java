package org.ugra.uzh;

/* loaded from: Uzh.jar:org/ugra/uzh/UzhBody.class */
public class UzhBody {

    /* renamed from: a */
    private Segment f3a;

    /* renamed from: b */
    private Segment f4b;

    /* renamed from: a */
    private byte f5a;

    /* loaded from: Uzh.jar:org/ugra/uzh/UzhBody$Segment.class */
    public class Segment {
        public Point head;
        public byte direction;
        public byte length;
        public Segment next;

        public Segment(UzhBody uzhBody, Point point, byte b, byte b2) {
            this.head = point;
            this.direction = b;
            this.length = b2;
        }

        public Segment(UzhBody uzhBody, Point point, byte b) {
            this(uzhBody, point, b, (byte) 1);
        }

        public Point getTail() {
            Point point = new Point(this.head);
            point.m5a((byte) (-this.direction), this.length);
            return point;
        }

        public boolean intersects(Point point) {
            switch (this.direction) {
                case Point.f0UP /* -2 */:
                    return point.f1x == this.head.f1x && point.f2y <= this.head.f2y && point.f2y >= this.head.f2y - this.length;
                case Point.LEFT /* -1 */:
                    return point.f2y == this.head.f2y && point.f1x >= this.head.f1x && point.f1x <= this.head.f1x + this.length;
                case 0:
                default:
                    throw new RuntimeException("Invalid direction");
                case Point.RIGHT /* 1 */:
                    return point.f2y == this.head.f2y && point.f1x <= this.head.f1x && point.f1x >= this.head.f1x - this.length;
                case Point.DOWN /* 2 */:
                    return point.f1x == this.head.f1x && point.f2y >= this.head.f2y && point.f2y <= this.head.f2y + this.length;
            }
        }

        public String toString() {
            return new StringBuffer().append("{head=").append(this.head.toString()).append("; direction=").append(Point.directionToString(this.direction)).append("; length=").append(String.valueOf((int) this.length)).append("}").toString();
        }
    }

    public UzhBody(Point point, byte b) {
        this(point, b, (byte) 1);
    }

    public UzhBody(Point point, byte b, byte b2) {
        this.f5a = (byte) 1;
        Segment segment = new Segment(this, point, b, b2);
        this.f4b = segment;
        this.f3a = segment;
    }

    public Segment getHeadSegment() {
        return this.f3a;
    }

    public Segment getTailSegment() {
        return this.f4b;
    }

    public byte getSegmentsCount() {
        return this.f5a;
    }

    public void advanceHead(byte b) {
        if (b == this.f3a.direction) {
            this.f3a.head.m5a(b, (byte) 1);
            Segment segment = this.f3a;
            segment.length = (byte) (segment.length + 1);
            return;
        }
        Point point = new Point(this.f3a.head);
        point.m5a(b, (byte) 1);
        Segment segment2 = new Segment(this, point, b);
        this.f3a.next = segment2;
        this.f3a = segment2;
        this.f5a = (byte) (this.f5a + 1);
    }

    public void shrinkTail() {
        if (this.f4b.length == 1) {
            this.f4b = this.f4b.next;
            this.f5a = (byte) (this.f5a - 1);
            return;
        }
        Segment segment = this.f4b;
        segment.length = (byte) (segment.length - 1);
    }

    public boolean headIntersects() {
        Point point = this.f3a.head;
        Segment segment = this.f4b;
        byte b = 0;
        while (true) {
            byte b2 = b;
            if (b2 >= this.f5a - 3) {
                return false;
            }
            if (segment.intersects(point)) {
                return true;
            }
            segment = segment.next;
            b = (byte) (b2 + 1);
        }
    }

    public boolean pointIntersects(Point point) {
        Segment segment = this.f4b;
        while (!segment.intersects(point)) {
            Segment segment2 = segment.next;
            segment = segment2;
            if (segment2 == null) {
                return false;
            }
        }
        return true;
    }
}