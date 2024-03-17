package org.ugra.uzh;

public class UzhBody {
   private UzhBody$Segment a;
   private UzhBody$Segment b;
   private byte a;

   public UzhBody(Point var1, byte var2) {
      this(var1, var2, (byte)1);
   }

   public UzhBody(Point var1, byte var2, byte var3) {
      this.a = 1;
      this.a = this.b = new UzhBody$Segment(this, var1, var2, var3);
   }

   public UzhBody$Segment getHeadSegment() {
      return this.a;
   }

   public UzhBody$Segment getTailSegment() {
      return this.b;
   }

   public byte getSegmentsCount() {
      return this.a;
   }

   public void advanceHead(byte var1) {
      if (var1 == this.a.direction) {
         this.a.head.a(var1, (byte)1);
         ++this.a.length;
      } else {
         Point var2;
         (var2 = new Point(this.a.head)).a(var1, (byte)1);
         UzhBody$Segment var3 = new UzhBody$Segment(this, var2, var1);
         this.a.next = var3;
         this.a = var3;
         ++this.a;
      }
   }

   public void shrinkTail() {
      if (this.b.length == 1) {
         this.b = this.b.next;
         --this.a;
      } else {
         --this.b.length;
      }
   }

   public boolean headIntersects() {
      Point var1 = this.a.head;
      UzhBody$Segment var2 = this.b;

      for(byte var3 = 0; var3 < this.a - 3; ++var3) {
         if (var2.intersects(var1)) {
            return true;
         }

         var2 = var2.next;
      }

      return false;
   }

   public boolean pointIntersects(Point var1) {
      UzhBody$Segment var2 = this.b;

      while(!var2.intersects(var1)) {
         if ((var2 = var2.next) == null) {
            return false;
         }
      }

      return true;
   }
}
