package nbtreader.playerlist;

import nbtreader.itempane.IconDisplay;

public class PlayerListItem implements Comparable<PlayerListItem> {

   private String name;
   private IconDisplay pane;


   public PlayerListItem(String name, IconDisplay pane) {
      this.name = name;
      this.pane = pane;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public IconDisplay getPane() {
      return this.pane;
   }

   public void setPane(IconDisplay pane) {
      this.pane = pane;
   }

   public int compareTo(PlayerListItem o) {
      return this.name.compareToIgnoreCase(o.getName());
   }
}
