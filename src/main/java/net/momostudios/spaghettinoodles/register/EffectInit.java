//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.register;

import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.momostudios.spaghettinoodles.effects.*;

@EventBusSubscriber
public class EffectInit {
    public static final DeferredRegister<Effect> EFFECTS;
    public static final RegistryObject<Effect> SAXUM_REGISTRY;
    public static final RegistryObject<Effect> BRUTUM_REGISTRY;
    public static final RegistryObject<Effect> NOTA_REGISTRY;
    public static final RegistryObject<Effect> CAUCULUS_REGISTRY;
    public static final RegistryObject<Effect> GIGAS_REGISTRY;
    public static final RegistryObject<Effect> ARBOR_REGISTRY;
    public static final RegistryObject<Effect> NIX_REGISTRY;
    public static final RegistryObject<Effect> IGNIS_REGISTRY;
    public static final RegistryObject<Effect> FLUCTUS_REGISTRY;
    public static final RegistryObject<Effect> SCINTILLA_REGISTRY;
    public static final RegistryObject<Effect> AQUA_REGISTRY;
    public static final RegistryObject<Effect> HUMANA_REGISTRY;
    public static final RegistryObject<Effect> LUPIS_REGISTRY;
    public static final RegistryObject<Effect> SIMIA_REGISTRY;

    public EffectInit() {
    }

    static {
        EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, "spaghetti_noodles");
        SAXUM_REGISTRY = EFFECTS.register("saxum", SaxumEffect::new);
        BRUTUM_REGISTRY = EFFECTS.register("brutum", BrutumEffect::new);
        NOTA_REGISTRY = EFFECTS.register("nota", NotaEffect::new);
        CAUCULUS_REGISTRY = EFFECTS.register("cauculus", CauculusEffect::new);
        GIGAS_REGISTRY = EFFECTS.register("gigas", GigasEffect::new);
        ARBOR_REGISTRY = EFFECTS.register("arbor", ArborEffect::new);
        NIX_REGISTRY = EFFECTS.register("nix", NixEffect::new);
        IGNIS_REGISTRY = EFFECTS.register("ignis", IgnisEffect::new);
        FLUCTUS_REGISTRY = EFFECTS.register("fluctus", FluctusEffect::new);
        SCINTILLA_REGISTRY = EFFECTS.register("scintilla", ScintillaEffect::new);
        AQUA_REGISTRY = EFFECTS.register("aqua", AquaEffect::new);
        HUMANA_REGISTRY = EFFECTS.register("humana", HumanaEffect::new);
        LUPIS_REGISTRY = EFFECTS.register("lupis", LupisEffect::new);
        SIMIA_REGISTRY = EFFECTS.register("simia", SimiaEffect::new);
    }
}
