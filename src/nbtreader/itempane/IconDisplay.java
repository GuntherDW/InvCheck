package nbtreader.itempane;

import nbtreader.Tag;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IconDisplay extends JPanel {

    boolean error;


    public IconDisplay(File nbt) {
        super(new BorderLayout(3, 3));

        Tag file = null;
        try {
            BufferedInputStream list = new BufferedInputStream(new FileInputStream(nbt));
            try{
                file = Tag.readFrom(list);} catch(Exception ex) {
                System.out.println("Error in file "+nbt.getName());
            }
            list.close();
        } catch (IOException var12) {
            this.error = true;
            return;
        }

        if(file!=null) {
            Tag[] var13 = (Tag[])((Tag[])file.findTagByName("Inventory").getValue());
            Tag[] inventory = new Tag[36];
            Tag[] crafting = new Tag[4];
            Tag[] armor = new Tag[4];
            Tag[] invp = var13;
            int armorp = var13.length;

            for(int craftp = 0; craftp < armorp; ++craftp) {
                Tag splitter = invp[craftp];
                byte slot = ((Byte)splitter.findTagByName("Slot").getValue()).byteValue();
                if(slot >= 0 && slot <= 9) {
                    inventory[slot + 26] = splitter;
                } else if(slot >= 10 && slot <= 35) {
                    inventory[slot - 10] = splitter;
                } else if(slot >= 80 && slot <= 83) {
                    crafting[slot - 80] = splitter;
                } else if(slot >= 100 && slot <= 103) {
                    armor[slot - 100] = splitter;
                } else {
                    System.out.println("CORRUPTED ITEM FROM " + nbt.getName().replace(".dat", "") + ": ");
                    splitter.print();
                }
            }

            IconPane var14 = new IconPane(inventory, 9);
            IconPane var15 = new IconPane(armor, 1);
            IconPane var16 = new IconPane(crafting, 2);
            var14.setToolTipText("Inventory");
            var15.setToolTipText("Armor");
            var16.setToolTipText("Crafting");
            this.add(var14, "Center");
            this.add(var15, "West");
            JPanel var17 = new JPanel(new GridLayout(2, 1));
            var17.add(var16);
            this.add(var17, "East");
        } else {
            this.error = true;
            return;
        }
    }
}
