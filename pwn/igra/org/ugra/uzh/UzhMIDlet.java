package org.ugra.uzh;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class UzhMIDlet extends MIDlet {
   private Display a;

   public void startApp() {
      this.a = Display.getDisplay(this);
      UzhStartupForm var1 = new UzhStartupForm(this);
      this.a.setCurrent(var1);
   }

   public void pauseApp() {
   }

   public void destroyApp(boolean var1) {
   }

   public void startGame(long var1) {
      UzhCanvas var3 = new UzhCanvas(var1);
      this.a.setCurrent(var3);
   }
}
