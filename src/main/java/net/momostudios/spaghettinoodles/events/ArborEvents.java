//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import java.util.Iterator;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.momostudios.spaghettinoodles.effects.ArborEffect;

@EventBusSubscriber
public class ArborEvents {
    public ArborEvents() {
    }

    public static boolean hasEffect(LivingEntity entity) {
        Iterator var1 = entity.getActivePotionEffects().iterator();

        EffectInstance effect;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            effect = (EffectInstance)var1.next();
        } while(!(effect.getPotion() instanceof ArborEffect));

        return true;
    }

    public static boolean touchingIce(PlayerEntity player) {
        World world = player.world;
        BlockPos pos = player.getPosition();
        BlockPos pos1 = player.getPosition().up();
        boolean touchingLower = world.getBlockState(pos.north()).getBlock() == Blocks.ICE || world.getBlockState(pos.south()).getBlock() == Blocks.ICE || world.getBlockState(pos.east()).getBlock() == Blocks.ICE || world.getBlockState(pos.west()).getBlock() == Blocks.ICE || world.getBlockState(pos.up()).getBlock() == Blocks.ICE || world.getBlockState(pos.down()).getBlock() == Blocks.ICE;
        boolean touchingUpper = world.getBlockState(pos1.north()).getBlock() == Blocks.ICE || world.getBlockState(pos1.south()).getBlock() == Blocks.ICE || world.getBlockState(pos1.east()).getBlock() == Blocks.ICE || world.getBlockState(pos1.west()).getBlock() == Blocks.ICE || world.getBlockState(pos1.up()).getBlock() == Blocks.ICE || world.getBlockState(pos1.down()).getBlock() == Blocks.ICE;
        return touchingLower || touchingUpper && player.getHeight() > 1.0F;
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if (hasEffect(event.player) && touchingIce(event.player) && event.player.ticksExisted % 10 == 0) {
            event.player.attackEntityFrom(DamageSource.GENERIC, 1.0F);
        }

    }

    @SubscribeEvent
    public static void onBowHit(LivingHurtEvent event) {
        if (event.getSource().getImmediateSource() instanceof ArrowEntity && event.getSource().getTrueSource() instanceof PlayerEntity && hasEffect((PlayerEntity)event.getSource().getTrueSource())) {
            event.setAmount(event.getAmount() * 0.75F);
        }

    }
}
