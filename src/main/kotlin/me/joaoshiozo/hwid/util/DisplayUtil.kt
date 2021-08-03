package me.joaoshiozo.hwid.util

import javax.swing.*
import java.awt.*
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection

object DisplayUtil {
    @JvmStatic
    fun Display() {
        val frame = Frame()
        frame.setVisible(false)
        throw NoStackTraceThrowable("Verification was unsuccessful!")
    }

    /**
     * The frame if the HWID check was unsuccessful.
     */
    class Frame : JFrame() {
        companion object {
            /**
             * The convenience function to automatically copy the HWID to clipboard.
             */
            fun copyToClipboard() {
                val selection = StringSelection(SystemUtil.systemInfo)
                val clipboard: Clipboard = Toolkit.getDefaultToolkit().getSystemClipboard()
                clipboard.setContents(selection, selection)
            }
        }

        init {
            this.setTitle("Verification failed.")
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE)
            this.setLocationRelativeTo(null)
            copyToClipboard()
            val message = """
                Sorry, you are not on the HWID list.
                HWID: ${SystemUtil.systemInfo}
                (Copied to clipboard.)
                """.trimIndent()
            JOptionPane.showMessageDialog(
                this,
                message,
                "Could not verify your HWID successfully.",
                JOptionPane.PLAIN_MESSAGE,
                UIManager.getIcon("OptionPane.errorIcon")
            )
        }
    }
}
