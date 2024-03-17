package org.ugra.uzh;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import org.ugra.uzh.UzhBody;

/* loaded from: Uzh.jar:org/ugra/uzh/UzhCanvas.class */
public class UzhCanvas extends Canvas implements Runnable {

    /* renamed from: a */
    private long f6a;

    /* renamed from: a */
    private Thread f7a;

    /* renamed from: a */
    private UzhWorld f8a;

    /* renamed from: a */
    private ByteArrayOutputStream f9a;

    /* renamed from: a */
    private byte f10a = 1;

    /* renamed from: a */
    private int f11a = -1;

    /* renamed from: b */
    private int f12b = 0;

    /* renamed from: a */
    private String f13a = "";

    /* renamed from: a */
    private Font f14a;

    /* renamed from: a */
    private Image f15a;

    /* renamed from: a */
    private Graphics f16a;

    /* renamed from: c */
    private int f17c;

    /* renamed from: d */
    private int f18d;

    /* renamed from: e */
    private int f19e;

    /* renamed from: f */
    private int f20f;

    /* renamed from: g */
    private int f21g;

    public UzhCanvas(long j) {
        this.f6a = j;
        int width = getWidth();
        int height = getHeight();
        this.f14a = Font.getDefaultFont();
        if (!isDoubleBuffered()) {
            this.f15a = Image.createImage(width, height);
            this.f16a = this.f15a.getGraphics();
            this.f16a.setFont(this.f14a);
        }
        int stringWidth = this.f14a.stringWidth("999");
        this.f17c = Math.min((((width - 2) - 2) - stringWidth) / 40, (height - 2) / 30);
        this.f18d = Math.min(((width - (this.f17c * 40)) - 2) / 2, (((width - (this.f17c * 40)) - 2) - 2) - stringWidth);
        this.f19e = ((height - (this.f17c * 30)) - 2) / 2;
        this.f20f = 40 * this.f17c;
        this.f21g = 30 * this.f17c;
    }

    public void paint(Graphics graphics) {
        if (this.f15a != null) {
            m3a(this.f16a);
            graphics.drawImage(this.f15a, 0, 0, 20);
            return;
        }
        graphics.setFont(this.f14a);
        m3a(graphics);
    }

    /* renamed from: a */
    private void m3a(Graphics graphics) {
        UzhBody.Segment segment;
        graphics.setColor(255, 255, 255);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        if (this.f8a == null) {
            m1b(graphics);
            return;
        }
        int width = getWidth();
        graphics.setColor(0, 0, 0);
        graphics.fillRect(this.f18d, this.f19e, 2 + this.f20f, 1);
        graphics.fillRect(this.f18d, this.f19e, 1, 2 + this.f21g);
        graphics.fillRect(this.f18d + 1 + this.f20f, this.f19e, 1, 2 + this.f21g);
        graphics.fillRect(this.f18d, this.f19e + 1 + this.f21g, 2 + this.f20f, 1);
        graphics.setColor(0, 255, 0);
        UzhBody.Segment tailSegment = this.f8a.getBody().getTailSegment();
        do {
            switch (tailSegment.direction) {
                case Point.f0UP /* -2 */:
                    m2a(graphics, tailSegment.head.f1x, (byte) ((tailSegment.head.f2y - tailSegment.length) + 1), (byte) 1, tailSegment.length);
                    break;
                case Point.LEFT /* -1 */:
                    m2a(graphics, tailSegment.head.f1x, tailSegment.head.f2y, tailSegment.length, (byte) 1);
                    break;
                case 0:
                default:
                    throw new RuntimeException("Invalid direction");
                case Point.RIGHT /* 1 */:
                    m2a(graphics, (byte) ((tailSegment.head.f1x - tailSegment.length) + 1), tailSegment.head.f2y, tailSegment.length, (byte) 1);
                    break;
                case Point.DOWN /* 2 */:
                    m2a(graphics, tailSegment.head.f1x, tailSegment.head.f2y, (byte) 1, tailSegment.length);
                    break;
            }
            segment = tailSegment.next;
            tailSegment = segment;
        } while (segment != null);
        graphics.setColor(244, 193, 0);
        Point fruit = this.f8a.getFruit();
        m2a(graphics, fruit.f1x, fruit.f2y, (byte) 1, (byte) 1);
        graphics.setColor(0, 0, 0);
        graphics.drawString(String.valueOf(this.f8a.getEatenFruits()), width - 1, this.f19e, 24);
    }

    /* renamed from: a */
    private void m2a(Graphics graphics, byte b, byte b2, byte b3, byte b4) {
        graphics.fillRect(this.f18d + 1 + (b * this.f17c), this.f19e + 1 + (((30 - b4) - b2) * this.f17c), b3 * this.f17c, b4 * this.f17c);
    }

    /* renamed from: b */
    private void m1b(Graphics graphics) {
        int i;
        int width = getWidth();
        int height = getHeight();
        int height2 = this.f14a.getHeight();
        graphics.setColor(0, 0, 0);
        int i2 = width / 2;
        int i3 = height / 3;
        graphics.drawString("High score:", i2, i3, 17);
        int i4 = i3 + height2;
        graphics.drawString(String.valueOf(this.f12b), i2, i4, 17);
        int i5 = i4 + height2 + (height2 / 2);
        if (this.f11a >= 0) {
            graphics.drawString("Last score:", i2, i5, 17);
            i = i5 + height2;
            graphics.drawString(String.valueOf(this.f11a), i2, i, 17);
        } else {
            i = i5 + height2;
        }
        int i6 = i + height2 + (height2 / 2);
        String str = this.f13a != null ? this.f13a : "Fetching results...";
        String str2 = str;
        if (str.equals("")) {
            return;
        }
        int i7 = 0;
        int indexOf = str2.indexOf(10);
        while (true) {
            int i8 = indexOf;
            if (i8 == -1) {
                graphics.drawString(str2.substring(i7), i2, i6, 17);
                return;
            }
            graphics.drawString(str2.substring(i7, i8), i2, i6, 17);
            i6 += height2;
            i7 = i8 + 1;
            indexOf = str2.indexOf(10, i7);
        }
    }

    protected void keyPressed(int i) {
        switch (i) {
            case -4:
            case 5:
            case 54:
                this.f10a = (byte) 1;
                break;
            case -3:
            case Point.DOWN /* 2 */:
            case 52:
                this.f10a = (byte) -1;
                break;
            case Point.f0UP /* -2 */:
            case 6:
            case 56:
                this.f10a = (byte) 2;
                break;
            case Point.LEFT /* -1 */:
            case Point.RIGHT /* 1 */:
            case 50:
                this.f10a = (byte) -2;
                break;
        }
        if (this.f7a == null && this.f7a == null) {
            this.f8a = new UzhWorld(this.f6a, this.f10a);
            this.f9a = new ByteArrayOutputStream();
            this.f9a.write(this.f10a);
            this.f13a = null;
            this.f7a = new Thread(this);
            this.f7a.start();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            repaint();
            while (true) {
                try {
                    Thread.sleep(this.f8a.getStepDelay());
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
                if (isShown()) {
                    byte b = this.f10a;
                    byte b2 = this.f8a.getBody().getHeadSegment().direction;
                    if (b == Point.invertDirection(b2)) {
                        b = b2;
                    }
                    this.f9a.write(b);
                    if (!this.f8a.advance(b) || this.f8a.getEatenFruits() >= 10) {
                        break;
                    }
                    repaint();
                }
            }
            this.f11a = this.f8a.getEatenFruits();
            this.f12b = Math.max(this.f12b, this.f11a);
            m4a();
        } catch (Throwable th) {
            m4a();
            throw th;
        }
    }

    /* renamed from: a */
    private void m4a() {
        this.f8a = null;
        this.f13a = "Fetching...";
        repaint();
        try {
            HttpConnection open = Connector.open(new StringBuffer().append("http://q.2024.ugractf.ru:9276/scores/?secret=").append(this.f6a).toString());
            open.setRequestMethod("POST");
            open.setRequestProperty("Content-Type", "application/octet-stream");
            OutputStream openOutputStream = open.openOutputStream();
            openOutputStream.write(this.f9a.toByteArray());
            openOutputStream.close();
            int responseCode = open.getResponseCode();
            if (responseCode != 200) {
                this.f13a = new StringBuffer().append("Error ").append(responseCode).append(": ").append(open.getResponseMessage()).toString();
            } else {
                InputStream openInputStream = open.openInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[128];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                openInputStream.close();
                this.f13a = byteArrayOutputStream.toString();
            }
            open.close();
        } catch (IOException e) {
            this.f13a = e.toString();
        }
        repaint();
        this.f7a = null;
    }
}