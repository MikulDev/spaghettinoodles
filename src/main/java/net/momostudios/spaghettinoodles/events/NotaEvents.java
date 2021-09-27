//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.NotaEffect;

@EventBusSubscriber
public class NotaEvents {
    public NotaEvents() {
    }

    public static boolean hasEffect(LivingEntity entity) {
        Iterator var1 = entity.getActivePotionEffects().iterator();

        EffectInstance effect;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            effect = (EffectInstance)var1.next();
        } while(!(effect.getPotion() instanceof NotaEffect));

        return true;
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (hasEffect(event.player)) {
            if (event.player.world.getDayTime() % 24000L < 12000L) {
                event.player.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 2, 0));
                if (event.player.getPersistentData().getInt("time") != 0) {
                    event.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(14.0D);
                    event.player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1D);
                    event.player.getPersistentData().putInt("time", 0);
                }
            } else if (event.player.getPersistentData().getInt("time") != 1) {
                event.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(26.0D);
                event.player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.125D);
                event.player.getPersistentData().putInt("time", 1);
            }
        } else if (event.player.getPersistentData().getInt("time") != -1) {
            event.player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
            event.player.getPersistentData().putInt("time", -1);
        }

    }
}
