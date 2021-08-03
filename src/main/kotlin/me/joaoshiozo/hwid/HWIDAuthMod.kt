package me.joaoshiozo.hwid

import me.joaoshiozo.hwid.HWIDManager

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = HWIDAuthMod.MODID, name = HWIDAuthMod.NAME, version = HWIDAuthMod.version, clientSideOnly = true)
class HWIDAuthMod
{
    @SuppressWarnings("unused")
    @Mod.EventHandler
	fun preinit(event: FMLPreInitializationEvent) {
        HWIDManager.hwidCheck() // Does the HWID check.
	}

    companion object
    {
        const val MODID = "hwidauthmod"
        const val NAME = "HWID-Authentication-System"
        const val version = "1.0.0"

        fun getVersion(): String
        {
            return version
        }
    }
} 
