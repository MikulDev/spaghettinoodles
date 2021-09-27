//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.register;

import net.minecraft.util.ResourceLocation;

public class ForbiddenIDs {
    public static String MINECRAFT = "minecraft:";
    public static String SPARTAN_WEAPONS = "spartanweaponry:";
    public static String SPARTAN_SHIELDS = "spartanshields:";
    private static String[] bows = new String[]{"bow", "crossbow"};
    private static String[] spartan_bows = new String[]
            {
                    "longbow_wood", "heavy_crossbow_wood",
                    "longbow_leather", "heavy_crossbow_leather",
                    "longbow_iron", "heavy_crossbow_iron",
                    "longbow_gold", "heavy_crossbow_gold",
                    "longbow_diamond", "heavy_crossbow_diamond",
                    "longbow_netherite", "heavy_crossbow_netherite",
                    "longbow_copper", "heavy_crossbow_copper",
                    "longbow_bronze", "heavy_crossbow_bronze",
                    "longbow_silver", "heavy_crossbow_silver",
                    "longbow_lead", "heavy_crossbow_lead",
                    "longbow_tin", "heavy_crossbow_tin",
                    "longbow_electrum", "heavy_crossbow_electrum",
                    "longbow_invar", "heavy_crossbow_invar",
                    "longbow_steel", "heavy_crossbow_steel",
                    "longbow_nickel", "heavy_crossbow_nickel",
                    "longbow_platinum", "heavy_crossbow_platinum"
            };
    private static String[] shields = new String[]{"shield"};
    public static String[] spartan_shields = new String[]
            {
                    "shield_basic_wood",
                    "shield_basic_stone",
                    "shield_basic_iron",
                    "shield_basic_gold",
                    "shield_basic_diamond",
                    "shield_basic_netherite",
                    "shield_basic_obsidian",
                    "shield_basic_copper",
                    "shield_basic_tin",
                    "shield_basic_bronze",
                    "shield_basic_steel",
                    "shield_basic_silver",
                    "shield_basic_lead",
                    "shield_basic_nickel",
                    "shield_basic_invar",
                    "shield_basic_constantan",
                    "shield_basic_platinum",
                    "shield_basic_electrum",
                    "shield_tower_wood",
                    "shield_tower_stone",
                    "shield_tower_iron",
                    "shield_tower_gold",
                    "shield_tower_diamond",
                    "shield_tower_netherite",
                    "shield_tower_obsidian",
                    "shield_tower_copper",
                    "shield_tower_tin",
                    "shield_tower_bronze",
                    "shield_tower_steel",
                    "shield_tower_silver",
                    "shield_tower_lead",
                    "shield_tower_nickel",
                    "shield_tower_invar",
                    "shield_tower_constantan",
                    "shield_tower_platinum",
                    "shield_tower_electrum",
                    "shield_botania_manasteel",
                    "shield_botania_terrasteel",
                    "shield_botania_elementium",
                    "shield_mekanism_osmium",
                    "shield_mekanism_lapis_lazuli",
                    "shield_mekanism_refined_glowstone",
                    "shield_mekanism_refined_obsidian",
                    "shield_mekanism_powered_basic",
                    "shield_mekanism_powered_basic",
                    "shield_mekanism_powered_advanced",
                    "shield_mekanism_powered_advanced",
                    "shield_mekanism_powered_elite",
                    "shield_mekanism_powered_elite",
                    "shield_mekanism_powered_ultimate",
                    "shield_mekanism_powered_ultimate"
            };

    public ForbiddenIDs() {
    }

    public static boolean containsBow(ResourceLocation id) {
        String[] var1 = bows;
        int var2 = var1.length;

        int var3;
        String bow;
        for(var3 = 0; var3 < var2; ++var3) {
            bow = var1[var3];
            if ((MINECRAFT + bow).equals(id.toString())) {
                return true;
            }
        }

        var1 = spartan_bows;
        var2 = var1.length;

        for(var3 = 0; var3 < var2; ++var3) {
            bow = var1[var3];
            if ((SPARTAN_WEAPONS + bow).equals(id.toString())) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsShield(ResourceLocation id) {
        String[] var1 = shields;
        int var2 = var1.length;

        int var3;
        String shield;
        for(var3 = 0; var3 < var2; ++var3) {
            shield = var1[var3];
            if ((MINECRAFT + shield).equals(id.toString())) {
                return true;
            }
        }

        var1 = spartan_shields;
        var2 = var1.length;

        for(var3 = 0; var3 < var2; ++var3) {
            shield = var1[var3];
            if ((SPARTAN_SHIELDS + shield).equals(id.toString())) {
                return true;
            }
        }

        return false;
    }
}
