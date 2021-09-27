package net.momostudios.spaghettinoodles.events;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.momostudios.spaghettinoodles.effects.CauculusEffect;
import net.momostudios.spaghettinoodles.effects.FluctusEffect;

import java.util.Iterator;

public class FluctusEvents
{
    public static boolean hasEffect(LivingEntity entity)
    {
        for (EffectInstance effect : entity.getActivePotionEffects())
        {
            if (effect.getPotion() instanceof FluctusEffect)
                return true;
        }
        return false;
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
