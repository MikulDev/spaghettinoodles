//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.momostudios.spaghettinoodles.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class JoinServerEvents {
    public JoinServerEvents() {
    }

    @SubscribeEvent
    public static void joinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)event.getEntity();
            if (!player.world.isRemote && player.world.getServer() != null) {
                if (ArborEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:arbor");
                }

                if (BrutumEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:brutum");
                }

                if (CauculusEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:cauculus");
                }

                if (GigasEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:gigas");
                }

                if (IgnisEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:ignis");
                }

                if (NixEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:nix");
                }

                if (NotaEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:nota");
                }

                if (SaxumEvents.hasEffect((PlayerEntity)event.getEntity())) {
                    player.world.getServer().getCommandManager().handleCommand(player.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "origin set @s origins:origin spaghetti_noodles:saxum");
                }
            }
        }

    }
}
