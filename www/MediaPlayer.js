class MediaPlayer extends tabris.NativeObject {
  constructor(properties) {
    super(properties);
  }

  get _nativeType() {
    return 'ru.fax1ty.tabris.mediaplayer.MediaPlayer';
  }

  play() {
    this._nativeCall('play');
  }

  pause() {
    this._nativeCall('pause');
  }

  stop() {
    this._nativeCall('stop');
  }

  seekTo(position) {
    if (typeof position != 'number') throw new Error('To call this method you must to pass number argument "position", but you passed ' + position);
    else this._nativeCall('seekTo', { position: position });
  }

  getDuration() {
    return this._nativeCall('getDuration');
  }

  isPlaying() {
    return this._nativeCall('isPlaying');
  }

  isLooping() {
    return this._nativeCall('isLooping');
  }

  setIsLooping(loop) {
    if (typeof loop != 'boolean') throw new Error('To call this method you must to pass boolean argument "loop", but you passed ' + loop);
    this._nativeCall('setIsLooping', { loop: loop });
  }

  getCurrentPosition() {
    return this._nativeCall('getCurrentPosition');
  }

  _trigger(name, event) {
    return super._trigger(name, event);
  }

  _listen(name, listening) {
    if (['error', 'ready', 'complete'].includes(name)) {
      this._nativeListen(name, listening);
    } else {
      super._listen(name, listening);
    }
  }
}

tabris.NativeObject.defineEvents(MediaPlayer.prototype, {
  error: { native: true },
  ready: { native: true },
  complete: { native: true }
});

tabris.NativeObject.defineProperties(MediaPlayer.prototype, {
  'url': {
    type: 'string',
    default: ''
  },
  'loop': {
    type: 'boolean',
    default: false
  },
});

module.exports = MediaPlayer;