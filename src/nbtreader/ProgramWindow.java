// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProgramWindow.java

package nbtreader;

import nbtreader.itempane.IconDisplay;
import nbtreader.playerlist.PlayerList;
import nbtreader.playerlist.PlayerListItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ProgramWindow
        implements ActionListener
{

    public static void main(String args[])
            throws Exception
    {
        System.out.println("Copyright 2010 Patrik Swedman\nTag class from Minecraft Wiki.");
        new ProgramWindow();
    }

    private ProgramWindow()
    {
        this.frame = new JFrame("Swedmans InvCheck alpha 4");
        this.frame.setDefaultCloseOperation(3);

        File dir = new File("players" + File.separator);

        if (!dir.isDirectory())
        {
            JComponent error = new JComponent()
            {
                public void paint(Graphics g)
                {
                    g.setColor(Color.black);
                    g.fillRect(0, 0, getSize().width, getSize().height);

                    g.setColor(Color.red);
                    FontMetrics fm = g.getFontMetrics();

                    String s1 = "Put this program in";
                    String s2 = "server world folder!";
                    g.drawString(s1, getSize().width / 2 - fm.stringWidth(s1) / 2, getSize().height / 2 - fm.getDescent());
                    g.drawString(s2, getSize().width / 2 - fm.stringWidth(s2) / 2, getSize().height / 2 + fm.getHeight() - fm.getDescent());
                }
            };
            error.setPreferredSize(new Dimension(774, 262));
            this.frame.add(error);

            this.frame.pack();
            this.frame.setVisible(true);
            this.frame.setLocationRelativeTo(null);
        }
        else
        {
            final _cls1Num i = new _cls1Num();
            final _cls1Num max = new _cls1Num();
            JComponent info = new JComponent()
            {
                public void paint(Graphics g)
                {
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, getSize().width, getSize().height);

                    g.setColor(Color.BLACK);
                    FontMetrics fm = g.getFontMetrics();

                    String s1 = "Please wait while the program is loading";
                    String s2 = "This may take a few minutes the first time you launch InvCheck";

                    String pro = "Loading " + i.value + " out of " + max.value + " (" + (int)(i.value / max.value * 100.0D) + "%)";

                    g.drawString(s1, getSize().width / 2 - fm.stringWidth(s1) / 2, getSize().height / 2 - fm.getHeight() - fm.getDescent());
                    g.drawString(s2, getSize().width / 2 - fm.stringWidth(s2) / 2, getSize().height / 2 - fm.getDescent());
                    g.drawString(pro, getSize().width / 2 - fm.stringWidth(pro) / 2, getSize().height / 2 + fm.getHeight() - fm.getDescent());
                }
            };
            info.setPreferredSize(new Dimension(774, 262));
            this.frame.add(info);

            this.frame.pack();
            this.frame.setVisible(true);
            this.frame.setLocationRelativeTo(null);

            this.pane = new JPanel(new BorderLayout());

            max.value = dir.listFiles().length;

            PlayerList playerlist = new PlayerList(this);

            for (File f : dir.listFiles())
            {
                String name = f.getName().replace(".dat", "");

                playerlist.add(new PlayerListItem(name, new IconDisplay(f)));
                i.value += 1;
                info.repaint();
            }

            JComponent instruction = new JComponent()
            {
                public void paint(Graphics g)
                {
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, getSize().width, getSize().height);

                    g.setColor(Color.BLACK);
                    FontMetrics fm = g.getFontMetrics();

                    String s1 = "Select a player from the menu to the left";
                    String s2 = "←";

                    g.drawString(s1, getSize().width / 2 - fm.stringWidth(s1) / 2, getSize().height / 2 - fm.getHeight() - fm.getDescent());
                    g.drawString(s2, getSize().width / 2 - fm.stringWidth(s2) / 2, getSize().height / 2 - fm.getDescent());
                }
            };
            instruction.setPreferredSize(new Dimension(774, 262));
            this.pane.add(instruction, "East");
            this.iconpane = instruction;

            JScrollPane scroll = new JScrollPane(playerlist);
            scroll.setVerticalScrollBarPolicy(22);
            scroll.setHorizontalScrollBarPolicy(31);
            scroll.getVerticalScrollBar().setUnitIncrement(16);

            JButton button = new JButton("Refresh");
            button.addActionListener(this);

            JPanel menu = new JPanel(new BorderLayout());
            menu.add(scroll, "Center");
            menu.add(button, "South");

            this.pane.add(menu, "Center");

            this.frame.remove(info);
            this.frame.add(this.pane);

            this.frame.pack();
        }
    }


    public void setItem(IconDisplay icn)
    {
        pane.remove(iconpane);
        iconpane = icn;
        pane.add(icn, "East");
        pane.validate();
        pane.repaint();
    }

    public JComponent getItem()
    {
        return iconpane;
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public void actionPerformed(ActionEvent e)
    {
        getFrame().dispose();
        new ProgramWindow();
    }

    private JFrame frame;
    private JComponent iconpane;
    private JPanel pane;
}