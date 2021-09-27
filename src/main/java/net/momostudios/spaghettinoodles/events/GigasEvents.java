//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.FluctusEffect;
import net.momostudios.spaghettinoodles.effects.GigasEffect;
import net.momostudios.spaghettinoodles.register.ForbiddenIDs;

@EventBusSubscriber
public class GigasEvents {
    public GigasEvents() {
    }

    public static boolean hasEffect(LivingEntity entity)
    {
        for (EffectInstance effect : entity.getActivePotionEffects())
        {
            if (effect.getPotion() instanceof GigasEffect)
                return true;
        }
        return false;
    }

    @SubscribeEvent
    public static void onHurt(RightClickItem event) {
        if (hasEffect((LivingEntity)event.getEntity()) && event.getItemStack().getItem() instanceof ShieldItem) {
            event.setCanceled(true);
        }

    }

    @SubscribeEvent
    public static void breakStone(HarvestCheck event) {
        BlockState state = event.getTargetBlock();
        if (state.isSolid() && state.getHarvestLevel() <= 1 && state.getMaterial() == Material.ROCK && event.getPlayer().getHeldItemMainhand() == ItemStack.EMPTY) {
            event.setCanHarvest(true);
        }

    }

    @SubscribeEvent
    public static void mineStone(BreakSpeed event) {
        BlockState state = event.getState();
        if (state.isSolid() && state.getHarvestLevel() <= 1 && state.getMaterial() == Material.ROCK && event.getPlayer().getHeldItemMainhand() == ItemStack.EMPTY) {
            event.setNewSpeed(event.getOriginalSpeed() * 2.5F);
        }

    }

    @SubscribeEvent
    public static void noShieldOrBow(RightClickItem event) {
        if (hasEffect((LivingEntity)event.getEntity()) && (ForbiddenIDs.containsShield(event.getItemStack().getItem().getRegistryName()) || ForbiddenIDs.containsBow(event.getItemStack().getItem().getRegistryName()))) {
            event.setCanceled(true);
        }

    }

    @SubscribeEvent
    public static void increaseHunger(TickEvent.PlayerTickEvent event)
    {
        PlayerEntity player = event.player;
        if (hasEffect(player))
        {
            float amount = player.serializeNBT().getFloat("foodExhaustionLevel") - player.getPersistentData().getFloat("lastExhaustion");

            if (player.serializeNBT().getFloat("foodExhaustionLevel") > player.getPersistentData().getFloat("lastExhaustion"))
                player.getFoodStats().addExhaustion(amount * 0.1f);

            player.getPersistentData().putFloat("lastExhaustion", player.serializeNBT().getFloat("foodExhaustionLevel"));
        }
    }
}
