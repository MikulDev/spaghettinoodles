//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.PickaxeItem;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.SaxumEffect;

@EventBusSubscriber
public class SaxumEvents {
    public SaxumEvents() {
    }

    public static boolean hasEffect(LivingEntity entity) {
        Iterator var1 = entity.getActivePotionEffects().iterator();

        EffectInstance effect;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            effect = (EffectInstance)var1.next();
        } while(!(effect.getPotion() instanceof SaxumEffect));

        return true;
    }

    @SubscribeEvent
    public static void saxumDamage(LivingHurtEvent event) {
        if (hasEffect(event.getEntityLiving()) && event.getSource().getImmediateSource() instanceof LivingEntity && ((LivingEntity)event.getSource().getImmediateSource()).getHeldItemMainhand().getItem() instanceof PickaxeItem) {
            event.getEntityLiving().setHealth(event.getEntityLiving().getHealth() - 2.0F);
        }

    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if (hasEffect(player)) {
            if (player.ticksExisted % 5 == 0) {
                player.extinguish();
            }

            if (player.getPosY() > 40.0D && player.getPersistentData().getInt("size") != 1) {
                if (!player.world.isRemote && player.world.getServer() != null) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "scale set pehkui:height 0.75 @s");
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "scale set pehkui:width 0.75 @s");
                }

                player.getPersistentData().putInt("size", 1);
            } else if (player.getPosY() <= 40.0D && player.getPersistentData().getInt("size") != 2) {
                if (!player.world.isRemote && player.world.getServer() != null) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "scale set pehkui:height 2.0 @s");
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "scale set pehkui:width 2.0 @s");
                }

                player.getPersistentData().putInt("size", 2);
            }
        }

    }
}
