package me.joaoshiozo.hwid.util

import me.joaoshiozo.hwid.manager.HWIDManager

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import java.util.ArrayList

object URLReader {
    /**
     * Opens and reads the URL.
     */
    fun readURL(): List<String> {
        val s: MutableList<String> = ArrayList()
        try {
            val url = URL(HWIDManager.pastebinURL)
            val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
            var hwid: String
            while (bufferedReader.readLine().also { hwid = it } != null) {
                s.add(hwid)
            }
        } catch (e: Exception) {
            /**
             * Optional logging below.
             */

            //FMLLog.log.info(e);
        }
        return s
    }
}
