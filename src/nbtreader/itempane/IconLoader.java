package nbtreader.itempane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IconLoader {

    private static Map<String, BufferedImage> cache = new HashMap<String, BufferedImage>();
    private static Map<Integer, BufferedImage> extracache = new HashMap<Integer, BufferedImage>();
    public static final Set<Integer> usesData = new HashSet<Integer>();
    static {
        usesData.add(6);
        usesData.add(17);
        usesData.add(35);
        usesData.add(351);
    }
    /*     static {
            usesData.add(BlockID.CHEST);
            usesData.add(BlockID.SAPLING);
            usesData.add(BlockID.WATER);
            usesData.add(BlockID.STATIONARY_WATER);
            usesData.add(BlockID.LAVA);
            usesData.add(BlockID.STATIONARY_LAVA);
            usesData.add(BlockID.LOG);
            usesData.add(BlockID.LEAVES);
            usesData.add(BlockID.DISPENSER);
            usesData.add(BlockID.NOTE_BLOCK);
            usesData.add(BlockID.BED);
            usesData.add(BlockID.POWERED_RAIL);
            usesData.add(BlockID.DETECTOR_RAIL);
            usesData.add(BlockID.PISTON_STICKY_BASE);
            usesData.add(BlockID.LONG_GRASS);
            usesData.add(BlockID.PISTON_BASE);
            usesData.add(BlockID.PISTON_EXTENSION);
            usesData.add(BlockID.CLOTH);
            usesData.add(BlockID.DOUBLE_STEP);
            usesData.add(BlockID.STEP);
            usesData.add(BlockID.TORCH);
            usesData.add(BlockID.WOODEN_STAIRS);
            usesData.add(BlockID.REDSTONE_WIRE);
            usesData.add(BlockID.CROPS);
            usesData.add(BlockID.SOIL);
            usesData.add(BlockID.FURNACE);
            usesData.add(BlockID.BURNING_FURNACE);
            usesData.add(BlockID.SIGN_POST);
            usesData.add(BlockID.WOODEN_DOOR);
            usesData.add(BlockID.LADDER);
            usesData.add(BlockID.MINECART_TRACKS);
            usesData.add(BlockID.COBBLESTONE_STAIRS);
            usesData.add(BlockID.WALL_SIGN);
            usesData.add(BlockID.LEVER);
            usesData.add(BlockID.STONE_PRESSURE_PLATE);
            usesData.add(BlockID.IRON_DOOR);
            usesData.add(BlockID.WOODEN_PRESSURE_PLATE);
            usesData.add(BlockID.REDSTONE_TORCH_OFF);
            usesData.add(BlockID.REDSTONE_TORCH_ON);
            usesData.add(BlockID.STONE_BUTTON);
            usesData.add(BlockID.SNOW);
            usesData.add(BlockID.CACTUS);
            usesData.add(BlockID.PUMPKIN);
            usesData.add(BlockID.JACKOLANTERN);
            usesData.add(BlockID.CAKE_BLOCK);
            usesData.add(BlockID.REDSTONE_REPEATER_OFF);
            usesData.add(BlockID.REDSTONE_REPEATER_ON);
            usesData.add(BlockID.TRAP_DOOR);
            usesData.add(BlockID.SILVERFISH_BLOCK);
            usesData.add(BlockID.STONE_BRICK);
            usesData.add(BlockID.RED_MUSHROOM_CAP);
            usesData.add(BlockID.BROWN_MUSHROOM_CAP);
            usesData.add(BlockID.PUMPKIN_STEM);
            usesData.add(BlockID.MELON_STEM);
            usesData.add(BlockID.VINE);
            usesData.add(BlockID.FENCE_GATE);
            usesData.add(BlockID.BRICK_STAIRS);
            usesData.add(BlockID.STONE_BRICK_STAIRS);
        } */

    public static String programLocation() {
        try {
            return (new File(IconLoader.class.getProtectionDomain().getCodeSource().getLocation().toURI())).getParentFile().getAbsolutePath();
        } catch (URISyntaxException var1) {
            var1.printStackTrace();
            return ".";
        }
    }

    public static BufferedImage getIcon(int id, short dat) {
        String lookup = "";
        NumberFormat nf = NumberFormat.getInstance();
        // say we need 3 digits
        nf.setMinimumIntegerDigits(2);
        try {
            lookup = id+"";
            if(usesData.contains(id)) {
                lookup+="-"+nf.format(Integer.valueOf(dat));
                // System.out.println("looking for "+lookup+".png");
            }

            BufferedImage dir = (BufferedImage)cache.get(lookup);
            if(dir != null && dir.getHeight((ImageObserver)null) > 0 && dir.getWidth((ImageObserver)null) > 0) {
                return dir;
            }
        } catch (IndexOutOfBoundsException var7) {
            ;
        }

        File dir1 = new File(programLocation() + File.separator + "cache" + File.separator);
        if(!dir1.exists() && dir1.mkdir()) {
            System.err.println("FAILED TO MAKE DIR!!!");
        }
        
        if(lookup.equals("")) return null;
        System.out.println("Opening " + programLocation() + File.separator + "cache" + File.separator + lookup + ".png");
        File file = new File(programLocation() + File.separator + "cache" + File.separator + lookup + ".png");
        BufferedImage img;
        if(file.exists()) {
            img = getImageFromFile(file);
            if(img != null) {
                cache.put(lookup, img);
                return img;
            }
        }

        img = getImageFromInternet(id);
        BufferedImage error;
        if(img != null && img.getWidth((ImageObserver)null) > 0 && img.getHeight((ImageObserver)null) > 0) {
            cache.put(lookup, img);

            try {
                error = new BufferedImage(16, 16, 6);
                Graphics2D g1 = error.createGraphics();
                g1.drawImage(img, 0, 0, (ImageObserver)null);
                g1.dispose();
                System.out.println(file);
                ImageIO.write(error, "png", file);
            } catch (IOException var6) {
                var6.printStackTrace();
            }

            return img;
        } else {
            error = new BufferedImage(16, 16, 6);
            Graphics g = error.getGraphics();
            g.setColor(Color.red);
            g.drawString("" + id, 0, 16);
            g.dispose();
            cache.put(lookup, error);
            return error;
        }
    }

    public static BufferedImage getIcon(int id) {
        return getIcon(id, (byte)0);
    }

    private static BufferedImage getImageFromFile(File f) {
        try {
            BufferedImage ex = ImageIO.read(f);
            if(ex.getWidth() > 0 && ex.getHeight() > 0) {
                return ex;
            }
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        return null;
    }

    private static BufferedImage getImageFromInternet(int id) {
        try {
            URL ex = new URL("http://minecraft-ids.grahamedgecombe.com/img/" + id + ".png");
            BufferedImage img = ImageIO.read(ex);
            BufferedImage small = new BufferedImage(16, 16, 6);
            small.getGraphics().drawImage(img, 0, 0, 16, 16, (ImageObserver)null);
            if(small != null && small.getWidth() > 0 && small.getHeight() > 0) {
                return small;
            }

            System.err.println("IMG: " + img + " - SMALL: " + small);
        } catch (Exception var4) {
            System.out.println("No iamge with id " + id);
        }

        return null;
    }

}
