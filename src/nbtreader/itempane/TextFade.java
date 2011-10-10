package nbtreader.itempane;

import java.util.Iterator;
import java.util.Vector;
import javax.swing.JComponent;

public class TextFade implements Runnable {

   private static TextFade instance = null;
   private float alpha = 1.0F;
   private Vector<JComponent> update = new Vector();


   public static float getAlpha(JComponent com) {
      if(instance == null) {
         instance = new TextFade();
         (new Thread(instance)).start();
      }

      if(instance.alpha <= 0.0F) {
         return 0.0F;
      } else {
         if(!instance.update.contains(com)) {
            instance.update.add(com);
         }

         return instance.alpha;
      }
   }

   public void run() {
      try {
         Thread.sleep(2000L);

         while(this.alpha > 0.0F) {
            this.alpha -= 0.05F;
            Iterator ex = this.update.iterator();

            while(ex.hasNext()) {
               JComponent i$1 = (JComponent)ex.next();
               i$1.repaint();
            }

            Thread.sleep(50L);
         }

         this.update.clear();
      } catch (InterruptedException var4) {
         this.alpha = 0.0F;
         Iterator i$ = this.update.iterator();

         while(i$.hasNext()) {
            JComponent c = (JComponent)i$.next();
            c.repaint();
         }

         this.update.clear();
      }

   }

}
