package ru.fax1ty.tabris.mediaplayer

import com.eclipsesource.tabris.android.ActivityScope
import com.eclipsesource.tabris.android.ObjectHandler
import com.eclipsesource.tabris.android.internal.ktx.getBooleanOrNull
import com.eclipsesource.tabris.android.internal.ktx.getStringOrNull
import com.eclipsesource.v8.V8Object

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class MediaPlayerHandler(private val scope: ActivityScope) : ObjectHandler<MediaPlayer> {

    override val type = "ru.fax1ty.tabris.mediaplayer.MediaPlayer"


    override fun create(id: String, properties: V8Object) = MediaPlayer(properties.getStringOrNull("url")
            ?: "", properties.getBooleanOrNull("loop")
            ?: false)

    override fun call(mediaPlayer: MediaPlayer, method: String, properties: V8Object): Any? = when (method) {
        "play" -> mediaPlayer.play()
        "pause" -> mediaPlayer.pause()
        "stop" -> mediaPlayer.stop()
        "seekTo" -> mediaPlayer.seekTo(properties.getInteger("position"))

        "getDuration" -> mediaPlayer.getDuration()
        "isPlaying" -> mediaPlayer.isPlaying()
        "isLooping" -> mediaPlayer.isLooping()
        "setIsLooping" -> mediaPlayer.setIsLooping(properties.getBoolean("loop"))
        "getCurrentPosition" -> mediaPlayer.getCurrentPosition()

        else -> null
    }

    override fun listen(id: String, mediaPlayer: MediaPlayer, event: String, listen: Boolean) {
        super.listen(id, mediaPlayer, event, listen)
        when (event) {
            "error" -> if (listen) {
                mediaPlayer.mediaPlayer?.setOnErrorListener(MediaPlayerErrorListener(mediaPlayer, scope))
            } else {
                mediaPlayer.mediaPlayer?.setOnErrorListener(null)
            }
            "ready" -> if (listen) {
                mediaPlayer.mediaPlayer?.setOnPreparedListener(MediaPlayerReadyListener(mediaPlayer, scope))
            } else {
                mediaPlayer.mediaPlayer?.setOnPreparedListener(null)
            }
            "complete" -> if (listen) {
                mediaPlayer.mediaPlayer?.setOnCompletionListener(MediaPlayerCompleteListener(mediaPlayer, scope))
            } else {
                mediaPlayer.mediaPlayer?.setOnCompletionListener(null)
            }
        }
    }

    override fun destroy(mediaPlayer: MediaPlayer) {
        super.destroy(mediaPlayer)
        mediaPlayer.mediaPlayer?.release()
        mediaPlayer.mediaPlayer = null
    }

}