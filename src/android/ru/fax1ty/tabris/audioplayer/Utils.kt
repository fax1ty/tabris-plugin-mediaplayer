package ru.fax1ty.tabris.audioplayer

import android.content.Context

object Utils {
    fun setIsPlaying(ctx: Context, isPlaying: Boolean) {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        prefs.edit().putBoolean("isPlaying", isPlaying).apply()
    }

    fun getIsPlaying(ctx: Context): Boolean {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        return prefs.getBoolean("isPlaying", false)
    }

    fun setAutoPlay(ctx: Context, autoPlay: Boolean) {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        prefs.edit().putBoolean("autoPlay", autoPlay).apply()
    }

    fun getAutoPlay(ctx: Context): Boolean {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        return prefs.getBoolean("autoPlay", false)
    }

    fun setLoop(ctx: Context, loop: Boolean) {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        prefs.edit().putBoolean("loop", loop).apply()
    }

    fun getLoop(ctx: Context): Boolean {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        return prefs.getBoolean("loop", false)
    }

    fun setURL(ctx: Context, url: String) {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("url", url).apply()
    }

    fun getURL(ctx: Context): String? {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        return prefs.getString("url", "")
    }

    fun setPosition(ctx: Context, position: Int) {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        prefs.edit().putInt("position", position).apply()
    }

    fun getPosition(ctx: Context): Int {
        val prefs = ctx.getSharedPreferences("prefs", Context.MODE_PRIVATE)
        return prefs.getInt("position", 0)
    }
}