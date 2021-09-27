//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.BrutumEffect;

@EventBusSubscriber
public class BrutumEvents {
    public BrutumEvents() {
    }

    public static boolean hasEffect(LivingEntity entity) {
        Iterator var1 = entity.getActivePotionEffects().iterator();

        EffectInstance effect;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            effect = (EffectInstance)var1.next();
        } while(!(effect.getPotion() instanceof BrutumEffect));

        return true;
    }

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof PlayerEntity && hasEffect((LivingEntity)event.getEntity())) {
            PlayerEntity player = (PlayerEntity)event.getEntity();
            if (event.getSource().getImmediateSource() instanceof ArrowEntity) {
                player.setHealth(player.getHealth() - 2.0F);
            }
        }

    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
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
