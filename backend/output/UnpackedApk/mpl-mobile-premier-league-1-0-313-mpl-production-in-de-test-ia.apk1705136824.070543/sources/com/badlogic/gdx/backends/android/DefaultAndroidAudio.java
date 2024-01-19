package com.badlogic.gdx.backends.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.Builder;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultAndroidAudio implements AndroidAudio {
    public final AudioManager manager;
    public final List<AndroidMusic> musics = new ArrayList();
    public final SoundPool soundPool;

    public DefaultAndroidAudio(Context context, AndroidApplicationConfiguration androidApplicationConfiguration) {
        if (!androidApplicationConfiguration.disableAudio) {
            this.soundPool = new Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(androidApplicationConfiguration.maxSimultaneousSounds).build();
            this.manager = (AudioManager) context.getSystemService("audio");
            if (context instanceof Activity) {
                ((Activity) context).setVolumeControlStream(3);
                return;
            }
            return;
        }
        this.soundPool = null;
        this.manager = null;
    }

    public void dispose() {
        if (this.soundPool != null) {
            synchronized (this.musics) {
                Iterator it = new ArrayList(this.musics).iterator();
                while (it.hasNext()) {
                    ((AndroidMusic) it.next()).dispose();
                }
            }
            this.soundPool.release();
        }
    }

    public Sound newSound(FileHandle fileHandle) {
        SoundPool soundPool2 = this.soundPool;
        if (soundPool2 != null) {
            AndroidFileHandle androidFileHandle = (AndroidFileHandle) fileHandle;
            if (androidFileHandle.type == FileType.Internal) {
                try {
                    AssetFileDescriptor assetFileDescriptor = androidFileHandle.getAssetFileDescriptor();
                    AndroidSound androidSound = new AndroidSound(this.soundPool, this.manager, this.soundPool.load(assetFileDescriptor, 1));
                    assetFileDescriptor.close();
                    return androidSound;
                } catch (IOException e2) {
                    throw new GdxRuntimeException("Error loading audio file: " + fileHandle + "\nNote: Internal audio files must be placed in the assets directory.", e2);
                }
            } else {
                try {
                    return new AndroidSound(soundPool2, this.manager, soundPool2.load(androidFileHandle.file().getPath(), 1));
                } catch (Exception e3) {
                    throw new GdxRuntimeException("Error loading audio file: " + fileHandle, e3);
                }
            }
        } else {
            throw new GdxRuntimeException((String) "Android audio is not enabled by the application config.");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002d A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0048 A[Catch:{ Exception -> 0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pause() {
        /*
            r5 = this;
            android.media.SoundPool r0 = r5.soundPool
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.util.List<com.badlogic.gdx.backends.android.AndroidMusic> r0 = r5.musics
            monitor-enter(r0)
            java.util.List<com.badlogic.gdx.backends.android.AndroidMusic> r1 = r5.musics     // Catch:{ all -> 0x0052 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0052 }
        L_0x000e:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0052 }
            com.badlogic.gdx.backends.android.AndroidMusic r2 = (com.badlogic.gdx.backends.android.AndroidMusic) r2     // Catch:{ all -> 0x0052 }
            android.media.MediaPlayer r3 = r2.player     // Catch:{ all -> 0x0052 }
            r4 = 0
            if (r3 != 0) goto L_0x0021
        L_0x001f:
            r3 = 0
            goto L_0x002b
        L_0x0021:
            boolean r3 = r3.isPlaying()     // Catch:{ Exception -> 0x0026 }
            goto L_0x002b
        L_0x0026:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0052 }
            goto L_0x001f
        L_0x002b:
            if (r3 == 0) goto L_0x0048
            android.media.MediaPlayer r3 = r2.player     // Catch:{ all -> 0x0052 }
            if (r3 != 0) goto L_0x0032
            goto L_0x0044
        L_0x0032:
            boolean r3 = r3.isPlaying()     // Catch:{ Exception -> 0x003e }
            if (r3 == 0) goto L_0x0042
            android.media.MediaPlayer r3 = r2.player     // Catch:{ Exception -> 0x003e }
            r3.pause()     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x0052 }
        L_0x0042:
            r2.wasPlaying = r4     // Catch:{ all -> 0x0052 }
        L_0x0044:
            r3 = 1
            r2.wasPlaying = r3     // Catch:{ all -> 0x0052 }
            goto L_0x000e
        L_0x0048:
            r2.wasPlaying = r4     // Catch:{ all -> 0x0052 }
            goto L_0x000e
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            android.media.SoundPool r0 = r5.soundPool
            r0.autoPause()
            return
        L_0x0052:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0052 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.DefaultAndroidAudio.pause():void");
    }

    public void resume() {
        if (this.soundPool != null) {
            synchronized (this.musics) {
                for (int i = 0; i < this.musics.size(); i++) {
                    if (this.musics.get(i).wasPlaying) {
                        AndroidMusic androidMusic = this.musics.get(i);
                        MediaPlayer mediaPlayer = androidMusic.player;
                        if (mediaPlayer == null) {
                            continue;
                        } else {
                            try {
                                if (mediaPlayer.isPlaying()) {
                                    continue;
                                } else {
                                    try {
                                        if (!androidMusic.isPrepared) {
                                            androidMusic.player.prepare();
                                            androidMusic.isPrepared = true;
                                        }
                                        androidMusic.player.start();
                                    } catch (IllegalStateException e2) {
                                        e2.printStackTrace();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }
                }
            }
            this.soundPool.autoResume();
        }
    }
}
