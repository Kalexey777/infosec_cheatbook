package org.ugra.uzh;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/* loaded from: Uzh.jar:org/ugra/uzh/UzhMIDlet.class */
public class UzhMIDlet extends MIDlet {

    /* renamed from: a */
    private Display f22a;

    public void startApp() {
        this.f22a = Display.getDisplay(this);
        this.f22a.setCurrent(new UzhStartupForm(this));
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean z) {
    }

    public void startGame(long j) {
        this.f22a.setCurrent(new UzhCanvas(j));
    }
}