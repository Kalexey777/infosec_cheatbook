package org.ugra.uzh;

import java.util.Random;

public class UzhWorld {
   public static final byte CELLS_X = 40;
   public static final byte CELLS_Y = 30;
   public static final int FRUIT_STEP_DELAY_SCALE = 1000;
   public static final int FRUIT_STEP_DELAY_K = 3000;
   private Random a;
   private UzhBody a;
   private Point a;
   private boolean a = false;
   private int a = 400;
   private int b = 0;

   public UzhWorld(long var1, byte var3) {
      this.a = new Random(var1);
      Point var4 = new Point((byte)20, (byte)15);
      this.a = new UzhBody(var4, var3, (byte)5);
      this.a();
   }

   public UzhBody getBody() {
      return this.a;
   }

   public Point getFruit() {
      return this.a;
   }

   public int getStepDelay() {
      return this.a;
   }

   public int getEatenFruits() {
      return this.b;
   }

   public boolean advance(byte var1) {
      this.a.advanceHead(var1);
      if (this.a) {
         this.a = false;
      } else {
         this.a.shrinkTail();
      }

      Point var2 = this.a.getHeadSegment().head;
      if (!this.a.headIntersects() && var2.x >= 0 && var2.y >= 0 && var2.x < 40 && var2.y < 30) {
         if (this.a.equals(this.a.getHeadSegment().head)) {
            this.a = true;
            this.a();
            this.a = this.a * 1000 / 3000;
            ++this.b;
         }

         return true;
      } else {
         return false;
      }
   }

   private void a() {
      do {
         this.a = new Point((byte)(Math.abs(this.a.nextInt()) % 40), (byte)(Math.abs(this.a.nextInt()) % 30));
      } while(this.a.pointIntersects(this.a));

   }
}
