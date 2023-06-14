package io.redstudioragnarok.valkyrie.handlers;

import io.redstudioragnarok.valkyrie.config.ValkyrieConfig;
import io.redstudioragnarok.valkyrie.utils.ModReference;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

import static io.redstudioragnarok.valkyrie.Valkyrie.mc;

public class DebugHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onDebugList(RenderGameOverlayEvent.Text event) {
        if (mc.gameSettings.showDebugInfo) {
            ArrayList<String> debugScreenLeft = event.getLeft();

            debugScreenLeft.remove(4);
            debugScreenLeft.add(4, "T: " + mc.world.getDebugLoadedEntities());

            if (!debugScreenLeft.get(debugScreenLeft.size() - 1).equals(""))
                debugScreenLeft.add("");

            debugScreenLeft.add(String.format("%s<Valkyrie>%s Valkyrie version is %s.", TextFormatting.RED, TextFormatting.RESET, ModReference.VERSION));
            debugScreenLeft.add("");
            if (ValkyrieConfig.clouds.enabled)
                debugScreenLeft.add(String.format("%s<Valkyrie>%s Clouds are enabled, render distance: %s, height: %s, layers: %s,  wireframe is %s", TextFormatting.RED, TextFormatting.RESET, ValkyrieConfig.clouds.renderDistance, ValkyrieConfig.clouds.height, ValkyrieConfig.clouds.layers, ValkyrieConfig.debug.wireframeClouds ? "on" : "off"));
            else
                debugScreenLeft.add(String.format("%s<Valkyrie>%s Clouds are disabled", TextFormatting.RED, TextFormatting.RESET));
        }
    }
}
