//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.CauculusEffect;
import net.momostudios.spaghettinoodles.register.ForbiddenIDs;

@EventBusSubscriber
public class CauculusEvents {
    public CauculusEvents() {
    }

    public static boolean hasEffect(LivingEntity entity) {
        Iterator var1 = entity.getActivePotionEffects().iterator();

        EffectInstance effect;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            effect = (EffectInstance)var1.next();
        } while(!(effect.getPotion() instanceof CauculusEffect));

        return true;
    }

    @SubscribeEvent
    public static void noBow(RightClickItem event) {
        if (hasEffect((LivingEntity)event.getEntity()) && ForbiddenIDs.containsBow(event.getItemStack().getItem().getRegistryName())) {
            event.setCanceled(true);
        }

    }
}
