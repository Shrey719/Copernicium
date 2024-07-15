package com.Copernicium.ontop;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.Field;

@Mod(modid = main.MODID, name = main.NAME, version = main.VERSION)
public class main
{
    public static final String MODID = "copernicium";
    public static final String NAME = "Copernicium";
    public static final String VERSION = "1.0.0-alpha";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        changeWindowTitle();
    }

    public void changeWindowTitle() {
        try {
            Class<?> displayClass = Class.forName("net.minecraft.client.Minecraft").forName("display");
            Field titleField = displayClass.getDeclaredField("title");
            titleField.setAccessible(true);
            titleField.set(null, "Copernicium");
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
