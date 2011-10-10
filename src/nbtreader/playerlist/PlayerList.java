package nbtreader.playerlist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JComponent;
import nbtreader.ProgramWindow;
import nbtreader.StringComparator;
import nbtreader.playerlist.PlayerListItem;

public class PlayerList extends JComponent implements MouseListener, KeyListener {

   private final ProgramWindow pw;
   private final ArrayList<PlayerListItem> items = new ArrayList();
   private boolean sizefix = false;
   private StringComparator cmp = new StringComparator();


   public PlayerList(ProgramWindow pw) {
      this.pw = pw;
      this.addMouseListener(this);
      pw.getFrame().addKeyListener(this);
   }

   public void add(PlayerListItem item) {
      this.items.add(item);
      Collections.sort(this.items);
   }

   public void paint(Graphics graphics) {
      Graphics2D g = (Graphics2D)graphics;
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, this.getSize().width, this.getSize().height);
      int heigth = this.getSize().height / this.items.size();
      int width = this.getSize().width;
      FontMetrics fm = g.getFontMetrics();
      g.setColor(Color.BLACK);

      int w;
      for(w = 0; w < this.items.size(); ++w) {
         PlayerListItem i$ = (PlayerListItem)this.items.get(w);
         if(i$.getPane().equals(this.pw.getItem())) {
            g.setColor(Color.CYAN);
            g.fillRect(0, w * heigth, width, heigth);
            g.setColor(Color.BLACK);
            g.drawString(i$.getName(), 0, w * heigth + heigth - fm.getDescent());
         } else {
            g.drawString(i$.getName(), 0, w * heigth + heigth - fm.getDescent());
         }
      }

      if(!this.sizefix) {
         w = 0;
         Iterator var9 = this.items.iterator();

         while(var9.hasNext()) {
            PlayerListItem item = (PlayerListItem)var9.next();
            if(fm.stringWidth(item.getName()) > w) {
               w = fm.stringWidth(item.getName());
            }
         }

         this.sizefix(w, fm.getHeight() * this.items.size());
      }

   }

   private void sizefix(int width, int heigth) {
      this.sizefix = true;
      this.setPreferredSize(new Dimension(width, heigth));
      Point location = this.pw.getFrame().getLocationOnScreen();
      location.x -= width;
      this.pw.getFrame().setLocation(location);
      Dimension d = this.pw.getFrame().getSize();
      this.pw.getFrame().setSize(d.width + width, d.height);
   }

   public void mouseClicked(MouseEvent e) {
      if(e.getButton() == 1) {
         int id = (int)((double)e.getY() / (double)this.getSize().height * (double)this.items.size());

         try {
            this.pw.setItem(((PlayerListItem)this.items.get(id)).getPane());
         } catch (IndexOutOfBoundsException var4) {
            ;
         }
      }

   }

   public void keyPressed(KeyEvent e) {
      int key = e.getKeyCode();
      int oldid;
      if(key == 40) {
         oldid = this.getId(this.pw.getItem());
         if(oldid == -1) {
            return;
         }

         if(oldid + 1 < this.items.size()) {
            this.pw.setItem(((PlayerListItem)this.items.get(oldid + 1)).getPane());
         }
      } else if(key == 38) {
         oldid = this.getId(this.pw.getItem());
         if(oldid == -1) {
            return;
         }

         if(oldid - 1 >= 0) {
            this.pw.setItem(((PlayerListItem)this.items.get(oldid - 1)).getPane());
         }
      }

   }

   private int getId(JComponent c) {
      for(int i = 0; i < this.items.size(); ++i) {
         if(((PlayerListItem)this.items.get(i)).getPane().equals(c)) {
            return i;
         }
      }

      return -1;
   }

   public void mousePressed(MouseEvent e) {}

   public void mouseReleased(MouseEvent e) {}

   public void mouseEntered(MouseEvent e) {}

   public void mouseExited(MouseEvent e) {}

   public void keyReleased(KeyEvent e) {}

   public void keyTyped(KeyEvent e) {}
}
