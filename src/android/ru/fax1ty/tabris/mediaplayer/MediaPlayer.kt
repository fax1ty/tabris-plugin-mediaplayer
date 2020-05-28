package ru.fax1ty.tabris.mediaplayer

import android.app.Activity
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri

class MediaPlayer(activity: Activity, url: String, private val loop: Boolean, private val autoPlay: Boolean) {

    var mediaPlayer = MediaPlayer.create(activity.applicationContext, Uri.parse(url)).apply {
        setAudioAttributes(AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build())
        isLooping = loop
        if (autoPlay) start()
    }

    fun play() {
        if (!mediaPlayer.isPlaying) mediaPlayer.start()
    }

    fun pause() {
        if (mediaPlayer.isPlaying) mediaPlayer.pause()
    }

    fun stop() {
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
    }

    fun seekTo(position: Int) {
        mediaPlayer.seekTo(position)
    }

    fun getDuration() = mediaPlayer.duration

    fun isPlaying() = mediaPlayer.isPlaying

    fun isLooping() = mediaPlayer.isLooping

    fun setIsLooping(loop: Boolean) {
        mediaPlayer.isLooping = loop
    }

    fun getCurrentPosition() = mediaPlayer.currentPosition
}