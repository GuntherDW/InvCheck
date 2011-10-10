package nbtreader.itempane;

import nbtreader.Tag;

import javax.swing.*;
import java.awt.*;

public class IconPane extends JPanel {

    boolean error = false;
    private Item selected;


    public IconPane(Tag[] inventory, int width) {
        super(new GridLayout(inventory.length / width, width));

        for(int i = 0; i < inventory.length; ++i) {
            Tag t = inventory[i];
            if(t != null) {
                short id = ((Short)t.findTagByName("id").getValue()).shortValue();
                byte count = ((Byte)t.findTagByName("Count").getValue()).byteValue();
                short dmg  = ((Short)t.findTagByName("Damage").getValue()).shortValue();
                // Item item =
                // item.setDamage(dmg);
                this.add(new Item(this, id, dmg, count));
            } else {
                this.add(new Item(this, (short)0, (short) 0, (byte)0));
            }
        }

    }


    public void paint(Graphics g) {
        if(this.error) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getSize().width, this.getSize().height);
            g.setColor(Color.RED);
            g.drawString("Error loading file!", this.getSize().height, 0);
        } else {
            super.paint(g);
            g.setColor(Color.BLACK);
            g.drawRect(0, 0, this.getSize().width - 1, this.getSize().height - 1);
            float ap = TextFade.getAlpha(this);
            if(ap > 0.0F) {
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(Color.RED);
                Composite old = null;
                if(ap < 1.0F) {
                    old = g2.getComposite();
                    g2.setComposite(AlphaComposite.getInstance(3, ap));
                }

                String str = this.getToolTipText();
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(str, this.getSize().width / 2 - fm.stringWidth(str) / 2, this.getSize().height / 2 + fm.getHeight() / 2 - fm.getDescent());
                if(ap < 1.0F) {
                    g2.setComposite(old);
                }
            }
        }

    }

    public Item getSelected() {
        return this.selected;
    }

    public void setSelected(Item selected) {
        this.selected = selected;
    }
}
