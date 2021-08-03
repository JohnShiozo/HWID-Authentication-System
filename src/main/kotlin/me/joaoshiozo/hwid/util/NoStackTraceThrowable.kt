package me.joaoshiozo.hwid.util

import java.lang.RuntimeException

class NoStackTraceThrowable(msg: String?) : RuntimeException(msg) {
    override fun toString(): String {
        return ""
    }

    @Synchronized
    override fun fillInStackTrace(): Throwable {
        return this
    }

    init {
        stackTrace = arrayOfNulls(0)
    }
}
