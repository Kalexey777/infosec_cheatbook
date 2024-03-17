ackage org.ugra.uzh;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public class UzhStartupForm extends Form implements CommandListener {
   private UzhMIDlet a;
   private Command a;
   private TextField a;

   public UzhStartupForm(UzhMIDlet var1) {
      super("Uzh");
      this.a = var1;
      this.a = new Command("Start", 4, 1);
      this.addCommand(this.a);
      this.a = new TextField("Secret code", "", 6, 2);
      this.append(this.a);
      this.setCommandListener(this);
   }

   public void commandAction(Command var1, Displayable var2) {
      if (var1 == this.a) {
         String var3;
         if ((var3 = this.a.getString()).length() != 6) {
            return;
         }

         this.a.startGame(Long.parseLong(var3));
      }

   }
}
