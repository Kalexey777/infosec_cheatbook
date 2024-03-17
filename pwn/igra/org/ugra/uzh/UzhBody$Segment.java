package org.ugra.uzh;

public class UzhBody$Segment {
   public Point head;
   public byte direction;
   public byte length;
   public UzhBody$Segment next;

   public UzhBody$Segment(UzhBody var1, Point var2, byte var3, byte var4) {
      this.head = var2;
      this.direction = var3;
      this.length = var4;
   }

   public UzhBody$Segment(UzhBody var1, Point var2, byte var3) {
      this(var1, var2, var3, (byte)1);
   }

   public Point getTail() {
      Point var1;
      (var1 = new Point(this.head)).a((byte)(-this.direction), this.length);
      return var1;
   }

   public boolean intersects(Point var1) {
      switch(this.direction) {
      case -2:
         if (var1.x == this.head.x && var1.y <= this.head.y && var1.y >= this.head.y - this.length) {
            return true;
         }

         return false;
      case -1:
         if (var1.y == this.head.y && var1.x >= this.head.x && var1.x <= this.head.x + this.length) {
            return true;
         }

         return false;
      case 0:
      default:
         throw new RuntimeException("Invalid direction");
      case 1:
         if (var1.y == this.head.y && var1.x <= this.head.x && var1.x >= this.head.x - this.length) {
            return true;
         }

         return false;
      case 2:
         return var1.x == this.head.x && var1.y >= this.head.y && var1.y <= this.head.y + this.length;
      }
   }

   public String toString() {
      return "{head=" + this.head.toString() + "; direction=" + Point.directionToString(this.direction) + "; length=" + this.length + "}";
   }
}
