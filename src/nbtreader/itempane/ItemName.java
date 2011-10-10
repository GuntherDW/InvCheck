package nbtreader.itempane;

import java.util.HashMap;

public class ItemName {

   private static HashMap<Integer, String> names;


   private static void setUpHash() {
      names = new HashMap();
      names.put(Integer.valueOf(0), "Air");
      names.put(Integer.valueOf(1), "Rock");
      names.put(Integer.valueOf(2), "Grass");
      names.put(Integer.valueOf(3), "Dirt");
      names.put(Integer.valueOf(4), "Cobblestone");
      names.put(Integer.valueOf(5), "Wood");
      names.put(Integer.valueOf(6), "Sapling");
      names.put(Integer.valueOf(7), "Adminium");
      names.put(Integer.valueOf(8), "Water");
      names.put(Integer.valueOf(9), "Still water");
      names.put(Integer.valueOf(10), "Lava");
      names.put(Integer.valueOf(11), "Still lava");
      names.put(Integer.valueOf(12), "Sand");
      names.put(Integer.valueOf(13), "Gravel");
      names.put(Integer.valueOf(14), "Gold ore");
      names.put(Integer.valueOf(15), "Iron ore");
      names.put(Integer.valueOf(16), "Coal ore");
      names.put(Integer.valueOf(17), "Tree");
      names.put(Integer.valueOf(18), "Leaves");
      names.put(Integer.valueOf(19), "Sponge");
      names.put(Integer.valueOf(20), "Glass");
      names.put(Integer.valueOf(35), "Cloth");
      names.put(Integer.valueOf(37), "Yellow Flower");
      names.put(Integer.valueOf(38), "Red Flower");
      names.put(Integer.valueOf(39), "Brown Mushroom");
      names.put(Integer.valueOf(40), "Red mushroom");
      names.put(Integer.valueOf(41), "Gold Block");
      names.put(Integer.valueOf(42), "Iron Block");
      names.put(Integer.valueOf(43), "Double Stair");
      names.put(Integer.valueOf(44), "Stair");
      names.put(Integer.valueOf(45), "Brick");
      names.put(Integer.valueOf(46), "TNT");
      names.put(Integer.valueOf(47), "Bookshelf");
      names.put(Integer.valueOf(48), "Mossy Cobblestone");
      names.put(Integer.valueOf(49), "Obsidian");
      names.put(Integer.valueOf(50), "Torch");
      names.put(Integer.valueOf(51), "Fire");
      names.put(Integer.valueOf(52), "Mob Spawner");
      names.put(Integer.valueOf(53), "Wood Stairs");
      names.put(Integer.valueOf(54), "Chest");
      names.put(Integer.valueOf(55), "Redstone Dust");
      names.put(Integer.valueOf(56), "Diamond Ore");
      names.put(Integer.valueOf(57), "Diamond Block");
      names.put(Integer.valueOf(58), "Workbench");
      names.put(Integer.valueOf(59), "Crop");
      names.put(Integer.valueOf(60), "Farmland");
      names.put(Integer.valueOf(61), "Furnance");
      names.put(Integer.valueOf(62), "Burning Furnance");
      names.put(Integer.valueOf(63), "Sign Block");
      names.put(Integer.valueOf(64), "Wood Door");
      names.put(Integer.valueOf(65), "Ladder");
      names.put(Integer.valueOf(66), "Rails");
      names.put(Integer.valueOf(67), "Stone Stairs");
      names.put(Integer.valueOf(68), "Sign Block Top");
      names.put(Integer.valueOf(69), "Lever");
      names.put(Integer.valueOf(70), "Rock Plate");
      names.put(Integer.valueOf(71), "Iron Door");
      names.put(Integer.valueOf(72), "Wood Plate");
      names.put(Integer.valueOf(73), "Redstone ore");
      names.put(Integer.valueOf(74), "Redstone ore (glowing)");
      names.put(Integer.valueOf(75), "Redstone Torch (off)");
      names.put(Integer.valueOf(76), "Redstone Torch (on)");
      names.put(Integer.valueOf(77), "Button");
      names.put(Integer.valueOf(78), "Snow");
      names.put(Integer.valueOf(79), "Ice");
      names.put(Integer.valueOf(80), "Snow Block");
      names.put(Integer.valueOf(81), "Cactus");
      names.put(Integer.valueOf(82), "Clay Block");
      names.put(Integer.valueOf(83), "Reed");
      names.put(Integer.valueOf(84), "Jukebox");
      names.put(Integer.valueOf(85), "Fence");
      names.put(Integer.valueOf(256), "Iron Spade");
      names.put(Integer.valueOf(257), "Iron Pickaxe");
      names.put(Integer.valueOf(258), "Iron Axe");
      names.put(Integer.valueOf(259), "Steel and Flint");
      names.put(Integer.valueOf(260), "Apple");
      names.put(Integer.valueOf(261), "Bow");
      names.put(Integer.valueOf(262), "Arrow");
      names.put(Integer.valueOf(263), "Coal");
      names.put(Integer.valueOf(264), "Diamond");
      names.put(Integer.valueOf(265), "Iron Ingot");
      names.put(Integer.valueOf(266), "Gold Ingot");
      names.put(Integer.valueOf(267), "Iron Sword");
      names.put(Integer.valueOf(268), "Wooden Sword");
      names.put(Integer.valueOf(269), "Wooden Spade");
      names.put(Integer.valueOf(270), "Wooden Pickaxe");
      names.put(Integer.valueOf(271), "Wooden Axe");
      names.put(Integer.valueOf(272), "Stone Sword");
      names.put(Integer.valueOf(273), "Stone Spade");
      names.put(Integer.valueOf(274), "Stone Pickaxe");
      names.put(Integer.valueOf(275), "Stone Axe");
      names.put(Integer.valueOf(276), "Diamond Sword");
      names.put(Integer.valueOf(277), "Diamond Spade");
      names.put(Integer.valueOf(278), "Diamond Pickaxe");
      names.put(Integer.valueOf(279), "Diamond Axe");
      names.put(Integer.valueOf(280), "Stick");
      names.put(Integer.valueOf(281), "Bowl");
      names.put(Integer.valueOf(282), "Mushroom Soup");
      names.put(Integer.valueOf(283), "Gold Sword");
      names.put(Integer.valueOf(284), "Gold Spade");
      names.put(Integer.valueOf(285), "Gold Pickaxe");
      names.put(Integer.valueOf(286), "Gold Axe");
      names.put(Integer.valueOf(287), "String");
      names.put(Integer.valueOf(288), "Feather");
      names.put(Integer.valueOf(289), "Gunpowder");
      names.put(Integer.valueOf(290), "Wooden Hoe");
      names.put(Integer.valueOf(291), "Stone Hoe");
      names.put(Integer.valueOf(292), "Iron Hoe");
      names.put(Integer.valueOf(293), "Diamond Hoe");
      names.put(Integer.valueOf(294), "Gold Hoe");
      names.put(Integer.valueOf(295), "Seeds");
      names.put(Integer.valueOf(296), "Wheat");
      names.put(Integer.valueOf(297), "Bread");
      names.put(Integer.valueOf(298), "Leather Helmet");
      names.put(Integer.valueOf(299), "Leather Chestplate");
      names.put(Integer.valueOf(300), "Leather Pants");
      names.put(Integer.valueOf(301), "Leather Boots");
      names.put(Integer.valueOf(302), "Chainmail Helmet");
      names.put(Integer.valueOf(303), "Chainmail Chestplate");
      names.put(Integer.valueOf(304), "Chainmail Pants");
      names.put(Integer.valueOf(305), "Chainmail Boots");
      names.put(Integer.valueOf(306), "Iron Helmet");
      names.put(Integer.valueOf(307), "Iron Chestplate");
      names.put(Integer.valueOf(308), "Iron Pants");
      names.put(Integer.valueOf(309), "Iron Boots");
      names.put(Integer.valueOf(310), "Diamond Helmet");
      names.put(Integer.valueOf(311), "Diamond Chestplate");
      names.put(Integer.valueOf(312), "Diamond Pants");
      names.put(Integer.valueOf(313), "Diamond Boots");
      names.put(Integer.valueOf(314), "Gold Helmet");
      names.put(Integer.valueOf(315), "Gold Chestplate");
      names.put(Integer.valueOf(316), "Gold Pants");
      names.put(Integer.valueOf(317), "Gold Boots");
      names.put(Integer.valueOf(318), "Flint");
      names.put(Integer.valueOf(319), "Pork");
      names.put(Integer.valueOf(320), "Grilled Pork");
      names.put(Integer.valueOf(321), "Painting");
      names.put(Integer.valueOf(322), "Golden Apple");
      names.put(Integer.valueOf(323), "Sign");
      names.put(Integer.valueOf(324), "Wooden Door");
      names.put(Integer.valueOf(325), "Bucket");
      names.put(Integer.valueOf(326), "Water Bucket");
      names.put(Integer.valueOf(327), "Lava Bucket");
      names.put(Integer.valueOf(328), "Mine Cart");
      names.put(Integer.valueOf(329), "Saddle");
      names.put(Integer.valueOf(330), "Iron Door");
      names.put(Integer.valueOf(331), "Redstone");
      names.put(Integer.valueOf(332), "Snowball");
      names.put(Integer.valueOf(333), "Boat");
      names.put(Integer.valueOf(334), "Leather");
      names.put(Integer.valueOf(335), "Milk Bucket");
      names.put(Integer.valueOf(336), "Clay Brick");
      names.put(Integer.valueOf(337), "Clay Balls");
      names.put(Integer.valueOf(338), "Reed");
      names.put(Integer.valueOf(339), "Paper");
      names.put(Integer.valueOf(340), "Book");
      names.put(Integer.valueOf(341), "Slime Ball");
      names.put(Integer.valueOf(342), "Storage Mine Cart");
      names.put(Integer.valueOf(343), "Powered Mine Cart");
      names.put(Integer.valueOf(344), "Egg");
      names.put(Integer.valueOf(345), "Compass");
      names.put(Integer.valueOf(346), "Fishing Rod");
      names.put(Integer.valueOf(2556), "Gold Record");
      names.put(Integer.valueOf(2557), "Green Record");
   }

   public static String getName(int id) {
      if(names == null) {
         setUpHash();
      }

      String ret = (String)names.get(Integer.valueOf(id));
      return ret != null?ret:"unknown";
   }
}