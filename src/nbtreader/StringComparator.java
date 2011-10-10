package nbtreader;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {

   public int compare(String o1, String o2) {
      return o1.compareToIgnoreCase(o2);
   }
}
