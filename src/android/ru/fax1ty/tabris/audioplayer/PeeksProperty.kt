package ru.fax1ty.tabris.audioplayer

import com.eclipsesource.tabris.android.ActivityScope
import com.eclipsesource.tabris.android.V8ArrayProperty
import com.semantive.waveformandroid.waveform.soundfile.CheapSoundFile

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class PeeksProperty(private val scope: ActivityScope) : V8ArrayProperty<AudioPlayer>("position") {
    override fun get(audioPlayer: AudioPlayer): Any? {
        return CheapSoundFile.create(Utils.getURL(scope.context)) { true }.frameGains
    }


}