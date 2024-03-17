package org.ugra.uzh;

public class Point {
   public static final byte LEFT = -1;
   public static final byte RIGHT = 1;
   public static final byte UP = -2;
   public static final byte DOWN = 2;
   public byte x;
   public byte y;

   public Point(byte var1, byte var2) {
      this.x = var1;
      this.y = var2;
   }

   public Point(Point var1) {
      this.x = var1.x;
      this.y = var1.y;
   }

   final void a(byte var1, byte var2) {
      switch(var1) {
      case -2:
         this.y += var2;
         return;
      case -1:
         this.x -= var2;
         return;
      case 0:
      default:
         throw new RuntimeException("Invalid direction");
      case 1:
         this.x += var2;
         return;
      case 2:
         this.y -= var2;
      }
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof Point)) {
         return false;
      } else {
         Point var2 = (Point)var1;
         return this.x == var2.x && this.y == var2.y;
      }
   }

   public String toString() {
      return "(" + String.valueOf(this.x) + ", " + this.y + ")";
   }

   public static String directionToString(byte var0) {
      switch(var0) {
      case -2:
         return "UP";
      case -1:
         return "LEFT";
      case 0:
      default:
         throw new RuntimeException("Invalid direction");
      case 1:
         return "RIGHT";
      case 2:
         return "DOWN";
      }
   }

   public static byte invertDirection(byte var0) {
      return (byte)(-var0);
   }
}
