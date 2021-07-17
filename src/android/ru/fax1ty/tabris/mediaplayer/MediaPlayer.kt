package ru.fax1ty.tabris.mediaplayer

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import java.io.File

class MediaPlayer(url: String, loop: Boolean) {

    var mediaPlayer: MediaPlayer? = MediaPlayer().apply {
        setAudioAttributes(AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build())
        val soundUrl = if (url.contains("http", true)) Uri.parse(url) else Uri.fromFile(File(url))
        this.setDataSource(soundUrl.toString())
        this.prepareAsync()
        isLooping = loop
    }

    fun play() {
        if (!mediaPlayer!!.isPlaying) mediaPlayer?.start()
    }

    fun pause() {
        if (mediaPlayer!!.isPlaying) mediaPlayer?.pause()
    }

    fun stop() {
        if (mediaPlayer!!.isPlaying) mediaPlayer?.stop()
    }

    fun seekTo(position: Int) {
        mediaPlayer?.seekTo(position)
    }

    fun getDuration() = mediaPlayer?.duration

    fun isPlaying() = mediaPlayer?.isPlaying

    fun isLooping() = mediaPlayer?.isLooping

    fun setIsLooping(loop: Boolean) {
        mediaPlayer?.isLooping = loop
    }

    fun getCurrentPosition() = mediaPlayer?.currentPosition
}