package me.joaoshiozo.hwid.manager

import me.joaoshiozo.hwid.util.DisplayUtil.Display
import me.joaoshiozo.hwid.util.SystemUtil
import me.joaoshiozo.hwid.util.NoStackTraceThrowable
import me.joaoshiozo.hwid.util.URLReader
import java.util.ArrayList

object HWIDManager {

    /**
     * Your pastebin URL goes inside the empty string below.
     * It should be a raw pastebin link, for example: pastebin.com/raw/pasteid
     */

    const val pastebinURL = ""

    var hwids: List<String> = ArrayList()
    
    @JvmStatic
    fun hwidCheck() {
        hwids = URLReader.readURL()
        val isHwidPresent = hwids.contains(SystemUtil.systemInfo)
        if (!isHwidPresent) {
            Display()
            throw NoStackTraceThrowable("")
        }
    }
}
