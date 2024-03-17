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

public class UzhCanvas extends Canvas implements Runnable {
   private long a;
   private Thread a;
   private UzhWorld a;
   private ByteArrayOutputStream a;
   private byte a = 1;
   private int a = -1;
   private int b = 0;
   private String a = "";
   private Font a;
   private Image a;
   private Graphics a;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;

   public UzhCanvas(long var1) {
      this.a = var1;
      int var6 = this.getWidth();
      int var2 = this.getHeight();
      this.a = Font.getDefaultFont();
      if (!this.isDoubleBuffered()) {
         this.a = Image.createImage(var6, var2);
         this.a = this.a.getGraphics();
         this.a.setFont(this.a);
      }

      int var3 = this.a.stringWidth("999");
      int var4 = (var6 - 2 - 2 - var3) / 40;
      int var5 = (var2 - 2) / 30;
      this.c = Math.min(var4, var5);
      var4 = (var6 - this.c * 40 - 2) / 2;
      var6 = var6 - this.c * 40 - 2 - 2 - var3;
      this.d = Math.min(var4, var6);
      this.e = (var2 - this.c * 30 - 2) / 2;
      this.f = 40 * this.c;
      this.g = 30 * this.c;
   }

   public void paint(Graphics var1) {
      if (this.a != null) {
         this.a(this.a);
         var1.drawImage(this.a, 0, 0, 20);
      } else {
         var1.setFont(this.a);
         this.a(var1);
      }
   }

   private void a(Graphics var1) {
      var1.setColor(255, 255, 255);
      var1.fillRect(0, 0, this.getWidth(), this.getHeight());
      if (this.a != null) {
         UzhCanvas var10000 = this;
         var1 = var1;
         UzhCanvas var4 = this;
         int var2 = var10000.getWidth();
         var1.setColor(0, 0, 0);
         var1.fillRect(var4.d, var4.e, 2 + var4.f, 1);
         var1.fillRect(var4.d, var4.e, 1, 2 + var4.g);
         var1.fillRect(var4.d + 1 + var4.f, var4.e, 1, 2 + var4.g);
         var1.fillRect(var4.d, var4.e + 1 + var4.g, 2 + var4.f, 1);
         var1.setColor(0, 255, 0);
         UzhBody$Segment var3 = var4.a.getBody().getTailSegment();

         do {
            switch(var3.direction) {
            case -2:
               var4.a(var1, var3.head.x, (byte)(var3.head.y - var3.length + 1), (byte)1, var3.length);
               break;
            case -1:
               var4.a(var1, var3.head.x, var3.head.y, var3.length, (byte)1);
               break;
            case 0:
            default:
               throw new RuntimeException("Invalid direction");
            case 1:
               var4.a(var1, (byte)(var3.head.x - var3.length + 1), var3.head.y, var3.length, (byte)1);
               break;
            case 2:
               var4.a(var1, var3.head.x, var3.head.y, (byte)1, var3.length);
            }
         } while((var3 = var3.next) != null);

         var1.setColor(244, 193, 0);
         Point var5 = var4.a.getFruit();
         var4.a(var1, var5.x, var5.y, (byte)1, (byte)1);
         var1.setColor(0, 0, 0);
         var1.drawString(String.valueOf(var4.a.getEatenFruits()), var2 - 1, var4.e, 24);
      } else {
         this.b(var1);
      }
   }

   private void a(Graphics var1, byte var2, byte var3, byte var4, byte var5) {
      var1.fillRect(this.d + 1 + var2 * this.c, this.e + 1 + (30 - var5 - var3) * this.c, var4 * this.c, var5 * this.c);
   }

   private void b(Graphics var1) {
      int var2 = this.getWidth();
      int var3 = this.getHeight();
      int var4 = this.a.getHeight();
      var1.setColor(0, 0, 0);
      var2 /= 2;
      var3 /= 3;
      var1.drawString("High score:", var2, var3, 17);
      var3 += var4;
      var1.drawString(String.valueOf(this.b), var2, var3, 17);
      var3 += var4 + var4 / 2;
      if (this.a >= 0) {
         var1.drawString("Last score:", var2, var3, 17);
         var3 += var4;
         var1.drawString(String.valueOf(this.a), var2, var3, 17);
      } else {
         var3 += var4;
      }

      var3 += var4 + var4 / 2;
      String var7;
      if (!(var7 = this.a != null ? this.a : "Fetching results...").equals("")) {
         int var5 = 0;

         for(int var6 = var7.indexOf(10); var6 != -1; var6 = var7.indexOf(10, var5)) {
            var1.drawString(var7.substring(var5, var6), var2, var3, 17);
            var3 += var4;
            var5 = var6 + 1;
         }

         var1.drawString(var7.substring(var5), var2, var3, 17);
      }

   }

   protected void keyPressed(int var1) {
      switch(var1) {
      case -4:
      case 5:
      case 54:
         this.a = 1;
         break;
      case -3:
      case 2:
      case 52:
         this.a = -1;
         break;
      case -2:
      case 6:
      case 56:
         this.a = 2;
         break;
      case -1:
      case 1:
      case 50:
         this.a = -2;
      }

      if (this.a == null && this.a == null) {
         this.a = new UzhWorld(this.a, this.a);
         this.a = new ByteArrayOutputStream();
         this.a.write(this.a);
         this.a = null;
         this.a = new Thread(this);
         this.a.start();
      }

   }

   public void run() {
      try {
         this.repaint();

         while(true) {
            try {
               Thread.sleep((long)this.a.getStepDelay());
            } catch (InterruptedException var5) {
               System.err.println(var5);
            }

            if (this.isShown()) {
               byte var1 = this.a;
               byte var2 = this.a.getBody().getHeadSegment().direction;
               if (var1 == Point.invertDirection(var2)) {
                  var1 = var2;
               }

               this.a.write(var1);
               if (!this.a.advance(var1) || this.a.getEatenFruits() >= 10) {
                  this.a = this.a.getEatenFruits();
                  this.b = Math.max(this.b, this.a);
                  return;
               }

               this.repaint();
            }
         }
      } finally {
         this.a();
      }
   }

   private void a() {
      this.a = null;
      this.a = "Fetching...";
      this.repaint();

      try {
         HttpConnection var1 = (HttpConnection)Connector.open("http://q.2024.ugractf.ru:9276/scores/?secret=" + this.a);

         try {
            var1.setRequestMethod("POST");
            var1.setRequestProperty("Content-Type", "application/octet-stream");
            OutputStream var2;
            (var2 = var1.openOutputStream()).write(this.a.toByteArray());
            var2.close();
            int var10;
            if ((var10 = var1.getResponseCode()) != 200) {
               this.a = "Error " + var10 + ": " + var1.getResponseMessage();
            } else {
               InputStream var11 = var1.openInputStream();
               ByteArrayOutputStream var3 = new ByteArrayOutputStream();
               byte[] var4 = new byte[128];

               int var5;
               while((var5 = var11.read(var4)) != -1) {
                  var3.write(var4, 0, var5);
               }

               var11.close();
               this.a = var3.toString();
            }
         } finally {
            var1.close();
         }
      } catch (IOException var9) {
         this.a = var9.toString();
      }

      this.repaint();
      this.a = null;
   }
}
