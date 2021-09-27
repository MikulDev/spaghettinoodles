//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.momostudios.spaghettinoodles.register.EffectInit;

@Mod("spaghetti_noodles")
public class SpaghettiNoodles {
    public static final String MOD_ID = "spaghetti_noodles";

    public SpaghettiNoodles() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EffectInit.EFFECTS.register(bus);
    }
}
