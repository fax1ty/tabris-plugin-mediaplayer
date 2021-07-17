import { NativeObject } from 'tabris';

declare global {
    class MediaPlayer extends NativeObject {
        play(): void;
        pause(): void;
        stop(): void;
        seekTo(position: number): void;
        getDuration(): number;
        isPlaying(): boolean;
        isLooping(): boolean;
        setIsLooping(loop: boolean): void;
        getCurrentPosition(): number;

        constructor(values: { url: string, loop?: boolean });
    }
}