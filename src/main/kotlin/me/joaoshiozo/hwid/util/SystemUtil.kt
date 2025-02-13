package me.joaoshiozo.hwid.util

import net.minecraft.client.Minecraft
import org.apache.commons.codec.digest.DigestUtils

object SystemUtil {

    val systemInfo: String
        get() =
            DigestUtils.sha512Hex(
                DigestUtils.sha512Hex(
                    System.getenv("os")
                            + System.getProperty("os.name")
                            + System.getProperty("os.arch")
                            + System.getProperty("user.name")
                            + System.getenv("SystemRoot")
                            + System.getenv("HOMEDRIVE")
                            + System.getenv("PROCESSOR_LEVEL")
                            + System.getenv("PROCESSOR_REVISION")
                            + System.getenv("PROCESSOR_IDENTIFIER")
                            + System.getenv("PROCESSOR_ARCHITECTURE")
                            + System.getenv("PROCESSOR_ARCHITEW6432")
                            + System.getenv("NUMBER_OF_PROCESSORS")
                )
            ) + Minecraft.getMinecraft().session.getUsername()
}
