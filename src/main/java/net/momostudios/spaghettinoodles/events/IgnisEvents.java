//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.IgnisEffect;

@EventBusSubscriber
public class IgnisEvents {
    public IgnisEvents() {
    }

    public static boolean hasEffect(LivingEntity entity) {
        Iterator var1 = entity.getActivePotionEffects().iterator();

        EffectInstance effect;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            effect = (EffectInstance)var1.next();
        } while(!(effect.getPotion() instanceof IgnisEffect));

        return true;
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (hasEffect(event.player) && (double)event.player.world.getBiome(event.player.getPosition()).getTemperature() < 0.4D) {
            event.player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 2, 0, false, false));
            event.player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 2, 0, false, false));
        }

    }
}
