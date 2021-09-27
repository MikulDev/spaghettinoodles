//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.CauculusEffect;
import net.momostudios.spaghettinoodles.effects.FluctusEffect;
import net.momostudios.spaghettinoodles.register.ForbiddenIDs;

@EventBusSubscriber
public class CauculusEvents {
    public CauculusEvents() {
    }

    public static boolean hasEffect(LivingEntity entity)
    {
        for (EffectInstance effect : entity.getActivePotionEffects())
        {
            if (effect.getPotion() instanceof CauculusEffect)
                return true;
        }
        return false;
    }

    @SubscribeEvent
    public static void noBow(RightClickItem event) {
        if (hasEffect((LivingEntity)event.getEntity()) && ForbiddenIDs.containsBow(event.getItemStack().getItem().getRegistryName())) {
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
