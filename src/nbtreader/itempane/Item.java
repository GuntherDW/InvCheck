package nbtreader.itempane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Item extends JComponent implements MouseListener {

    short id;
    byte count;
    short damage;
    BufferedImage img;
    IconPane parent;
    boolean hover = false;
    private boolean selected;


    public Item(IconPane parent, short id, short dmg, byte count) {
        this.parent = parent;
        this.count = count;
        this.damage = dmg;
        
        this.setItem(id, dmg);
        this.setPreferredSize(new Dimension(64, 64));
        this.addMouseListener(this);
    }

    public void setDamage(short dmg) {
        this.damage = dmg;
    }

    public short getDamage() {
        return this.damage;
    }

    public void setItem(short id, short dmg) {
            this.id = id;
            if(id > 0) {
                if(dmg!=0) {
                    System.out.println("Looking for "+dmg);
                }
                this.img = IconLoader.getIcon(id, dmg);
            }

        }

    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;
        if(this.id > 0) {
            int prop = Math.min(this.getSize().width / this.img.getWidth(), this.getSize().height / this.img.getHeight());
            g.drawImage(this.img, 0, 0, prop * 16, prop * 16, this);
            Font f = new Font("SansSerif", 0, 8 * prop);
            g.setFont(f);
            FontMetrics fm = g.getFontMetrics();
            String sid = "" + this.id;
            /* if(IconLoader.usesData.contains((int)this.id)) {
                sid += ":"+this.damage;
            } */
            int width = fm.stringWidth(sid);
            int height = fm.getHeight();
            g.setColor(Color.BLACK);
            g.drawString(sid, 16 * prop - width, 16 * prop - height);
            String scount = "" + this.count;
            width = fm.stringWidth(scount);
            g.setColor(Color.YELLOW);
            g.drawString(scount, 16 * prop - width, 16 * prop);
        }

        if(this.selected) {
            g.setColor(this.hover?Color.ORANGE:Color.RED);
            g.drawRect(0, 0, this.getSize().width - 1, this.getSize().height - 1);
            g.drawRect(1, 1, this.getSize().width - 3, this.getSize().height - 3);
        } else if(this.hover) {
            g.setColor(Color.YELLOW);
            g.drawRect(0, 0, this.getSize().width - 1, this.getSize().height - 1);
            g.drawRect(1, 1, this.getSize().width - 3, this.getSize().height - 3);
        }

    }

    private void deselect() {
        this.selected = false;
        if(this == this.parent.getSelected()) {
            this.parent.setSelected((Item)null);
        }

        this.repaint();
    }

    private void select() {
        Item sel = this.parent.getSelected();
        if(sel != null) {
            sel.deselect();
            sel.repaint();
        }
        if(this.id!=0) {
            System.out.println("ItemID : "+this.id);
            System.out.println("ItemDMG: "+this.damage);
            System.out.println("ItemAm : "+this.count);
        } else {
            System.out.println("ItemID : 0");
        }
        this.parent.setSelected(this);
        this.selected = true;
        this.repaint();
    }

    public void mouseClicked(MouseEvent e) {
        if(this.selected) {
            this.deselect();
        } else {
            this.select();
        }

    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        this.hover = true;
        this.repaint();
    }

    public void mouseExited(MouseEvent e) {
        this.hover = false;
        this.repaint();
    }
}
