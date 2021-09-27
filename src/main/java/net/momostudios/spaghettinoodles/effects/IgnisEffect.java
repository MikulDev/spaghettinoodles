//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.effects;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class IgnisEffect extends Effect {
    public IgnisEffect() {
        super(EffectType.NEUTRAL, -1);
    }

    public String getName() {
        return "effect.ignis";
    }

    public boolean isInstant() {
        return false;
    }

    public boolean shouldRenderInvText(EffectInstance effect) {
        return false;
    }

    public boolean shouldRender(EffectInstance effect) {
        return false;
    }

    public boolean shouldRenderHUD(EffectInstance effect) {
        return false;
    }
}
