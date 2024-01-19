package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnGenericMotionListener;
import android.view.View.OnKeyListener;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.AbstractInput;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Input.Orientation;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Pool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.fontbox.cmap.CMap;
import sfs2x.client.entities.invitation.InvitationReply;

public class DefaultAndroidInput extends AbstractInput implements AndroidInput {
    public boolean accelerometerAvailable;
    public SensorEventListener accelerometerListener;
    public final float[] accelerometerValues;
    public final Application app;
    public int[] button = new int[20];
    public boolean compassAvailable;
    public SensorEventListener compassListener;
    public final AndroidApplicationConfiguration config;
    public final Context context;
    public long currentEventTimeStamp;
    public int[] deltaX = new int[20];
    public int[] deltaY = new int[20];
    public final ArrayList<OnGenericMotionListener> genericMotionListeners;
    public SensorEventListener gyroscopeListener;
    public final float[] gyroscopeValues;
    public boolean[] justPressedButtons = new boolean[20];
    public boolean justTouched;
    public ArrayList<KeyEvent> keyEvents = new ArrayList<>();
    public ArrayList<OnKeyListener> keyListeners = new ArrayList<>();
    public final float[] magneticFieldValues;
    public SensorManager manager;
    public final AndroidMouseHandler mouseHandler;
    public final Orientation nativeOrientation;
    public float[] pressure = new float[20];
    public InputAdapter processor;
    public int[] realId = new int[20];
    public boolean requestFocus;
    public boolean rotationVectorAvailable;
    public SensorEventListener rotationVectorListener;
    public final float[] rotationVectorValues;
    public int sleepTime;
    public ArrayList<TouchEvent> touchEvents = new ArrayList<>();
    public final AndroidTouchHandler touchHandler;
    public int[] touchX = new int[20];
    public int[] touchY = new int[20];
    public boolean[] touched = new boolean[20];
    public Pool<KeyEvent> usedKeyEvents = new Pool<KeyEvent>(this, 16, 1000) {
        public Object newObject() {
            return new KeyEvent();
        }
    };
    public Pool<TouchEvent> usedTouchEvents = new Pool<TouchEvent>(this, 16, 1000) {
        public Object newObject() {
            return new TouchEvent();
        }
    };
    public final Vibrator vibrator;

    public static class KeyEvent {
        public char keyChar;
        public int keyCode;
        public long timeStamp;
        public int type;
    }

    public class SensorListener implements SensorEventListener {
        public SensorListener() {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                DefaultAndroidInput defaultAndroidInput = DefaultAndroidInput.this;
                if (defaultAndroidInput.nativeOrientation == Orientation.Portrait) {
                    float[] fArr = sensorEvent.values;
                    float[] fArr2 = defaultAndroidInput.accelerometerValues;
                    System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
                } else {
                    float[] fArr3 = defaultAndroidInput.accelerometerValues;
                    float[] fArr4 = sensorEvent.values;
                    fArr3[0] = fArr4[1];
                    fArr3[1] = -fArr4[0];
                    fArr3[2] = fArr4[2];
                }
            }
            if (sensorEvent.sensor.getType() == 2) {
                float[] fArr5 = sensorEvent.values;
                float[] fArr6 = DefaultAndroidInput.this.magneticFieldValues;
                System.arraycopy(fArr5, 0, fArr6, 0, fArr6.length);
            }
            if (sensorEvent.sensor.getType() == 4) {
                DefaultAndroidInput defaultAndroidInput2 = DefaultAndroidInput.this;
                if (defaultAndroidInput2.nativeOrientation == Orientation.Portrait) {
                    float[] fArr7 = sensorEvent.values;
                    float[] fArr8 = defaultAndroidInput2.gyroscopeValues;
                    System.arraycopy(fArr7, 0, fArr8, 0, fArr8.length);
                } else {
                    float[] fArr9 = defaultAndroidInput2.gyroscopeValues;
                    float[] fArr10 = sensorEvent.values;
                    fArr9[0] = fArr10[1];
                    fArr9[1] = -fArr10[0];
                    fArr9[2] = fArr10[2];
                }
            }
            if (sensorEvent.sensor.getType() == 11) {
                DefaultAndroidInput defaultAndroidInput3 = DefaultAndroidInput.this;
                if (defaultAndroidInput3.nativeOrientation == Orientation.Portrait) {
                    float[] fArr11 = sensorEvent.values;
                    float[] fArr12 = defaultAndroidInput3.rotationVectorValues;
                    System.arraycopy(fArr11, 0, fArr12, 0, fArr12.length);
                    return;
                }
                float[] fArr13 = defaultAndroidInput3.rotationVectorValues;
                float[] fArr14 = sensorEvent.values;
                fArr13[0] = fArr14[1];
                fArr13[1] = -fArr14[0];
                fArr13[2] = fArr14[2];
            }
        }
    }

    public static class TouchEvent {
        public int button;
        public int pointer;
        public int scrollAmountX;
        public int scrollAmountY;
        public long timeStamp;
        public int type;
        public int x;
        public int y;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0101, code lost:
        r0 = 270;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultAndroidInput(com.badlogic.gdx.Application r6, android.content.Context r7, java.lang.Object r8, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration r9) {
        /*
            r5 = this;
            r5.<init>()
            com.badlogic.gdx.backends.android.DefaultAndroidInput$1 r0 = new com.badlogic.gdx.backends.android.DefaultAndroidInput$1
            r1 = 16
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.<init>(r5, r1, r2)
            r5.usedKeyEvents = r0
            com.badlogic.gdx.backends.android.DefaultAndroidInput$2 r0 = new com.badlogic.gdx.backends.android.DefaultAndroidInput$2
            r0.<init>(r5, r1, r2)
            r5.usedTouchEvents = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.keyListeners = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.keyEvents = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.touchEvents = r0
            r0 = 20
            int[] r1 = new int[r0]
            r5.touchX = r1
            int[] r1 = new int[r0]
            r5.touchY = r1
            int[] r1 = new int[r0]
            r5.deltaX = r1
            int[] r1 = new int[r0]
            r5.deltaY = r1
            boolean[] r1 = new boolean[r0]
            r5.touched = r1
            int[] r1 = new int[r0]
            r5.button = r1
            int[] r1 = new int[r0]
            r5.realId = r1
            float[] r1 = new float[r0]
            r5.pressure = r1
            boolean[] r0 = new boolean[r0]
            r5.justPressedButtons = r0
            r0 = 0
            r5.accelerometerAvailable = r0
            r1 = 3
            float[] r2 = new float[r1]
            r5.accelerometerValues = r2
            float[] r2 = new float[r1]
            r5.gyroscopeValues = r2
            r5.sleepTime = r0
            r5.compassAvailable = r0
            r5.rotationVectorAvailable = r0
            float[] r2 = new float[r1]
            r5.magneticFieldValues = r2
            float[] r2 = new float[r1]
            r5.rotationVectorValues = r2
            r5.justTouched = r0
            r2 = 0
            r5.currentEventTimeStamp = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5.genericMotionListeners = r2
            r2 = 1
            r5.requestFocus = r2
            boolean r3 = r8 instanceof android.view.View
            if (r3 == 0) goto L_0x0092
            android.view.View r8 = (android.view.View) r8
            r8.setOnKeyListener(r5)
            r8.setOnTouchListener(r5)
            r8.setFocusable(r2)
            r8.setFocusableInTouchMode(r2)
            r8.requestFocus()
            r8.setOnGenericMotionListener(r5)
        L_0x0092:
            r5.config = r9
            com.badlogic.gdx.backends.android.AndroidMouseHandler r8 = new com.badlogic.gdx.backends.android.AndroidMouseHandler
            r8.<init>()
            r5.mouseHandler = r8
            r8 = 0
        L_0x009c:
            int[] r3 = r5.realId
            int r4 = r3.length
            if (r8 >= r4) goto L_0x00a7
            r4 = -1
            r3[r8] = r4
            int r8 = r8 + 1
            goto L_0x009c
        L_0x00a7:
            android.os.Handler r8 = new android.os.Handler
            r8.<init>()
            r5.app = r6
            r5.context = r7
            int r6 = r9.touchSleepTime
            r5.sleepTime = r6
            com.badlogic.gdx.backends.android.AndroidTouchHandler r6 = new com.badlogic.gdx.backends.android.AndroidTouchHandler
            r6.<init>()
            r5.touchHandler = r6
            android.content.pm.PackageManager r6 = r7.getPackageManager()
            java.lang.String r8 = "android.hardware.touchscreen.multitouch"
            r6.hasSystemFeature(r8)
            java.lang.String r6 = "vibrator"
            java.lang.Object r6 = r7.getSystemService(r6)
            android.os.Vibrator r6 = (android.os.Vibrator) r6
            r5.vibrator = r6
            android.content.Context r6 = r5.context
            boolean r7 = r6 instanceof android.app.Activity
            if (r7 == 0) goto L_0x00e3
            android.app.Activity r6 = (android.app.Activity) r6
            android.view.WindowManager r6 = r6.getWindowManager()
            android.view.Display r6 = r6.getDefaultDisplay()
            int r6 = r6.getRotation()
            goto L_0x00f3
        L_0x00e3:
            java.lang.String r7 = "window"
            java.lang.Object r6 = r6.getSystemService(r7)
            android.view.WindowManager r6 = (android.view.WindowManager) r6
            android.view.Display r6 = r6.getDefaultDisplay()
            int r6 = r6.getRotation()
        L_0x00f3:
            r7 = 90
            r8 = 180(0xb4, float:2.52E-43)
            r9 = 270(0x10e, float:3.78E-43)
            if (r6 == r2) goto L_0x0107
            r2 = 2
            if (r6 == r2) goto L_0x0104
            if (r6 == r1) goto L_0x0101
            goto L_0x0109
        L_0x0101:
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x0109
        L_0x0104:
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x0109
        L_0x0107:
            r0 = 90
        L_0x0109:
            com.badlogic.gdx.Application r6 = r5.app
            com.badlogic.gdx.Graphics r6 = r6.getGraphics()
            com.badlogic.gdx.backends.android.AndroidGraphics r6 = (com.badlogic.gdx.backends.android.AndroidGraphics) r6
            if (r6 == 0) goto L_0x0147
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            com.badlogic.gdx.backends.android.AndroidApplicationBase r6 = r6.app
            android.view.WindowManager r6 = r6.getWindowManager()
            android.view.Display r6 = r6.getDefaultDisplay()
            r6.getMetrics(r1)
            int r6 = r1.widthPixels
            int r1 = r1.heightPixels
            if (r0 == 0) goto L_0x012d
            if (r0 != r8) goto L_0x012f
        L_0x012d:
            if (r6 >= r1) goto L_0x013b
        L_0x012f:
            if (r0 == r7) goto L_0x0133
            if (r0 != r9) goto L_0x0136
        L_0x0133:
            if (r6 > r1) goto L_0x0136
            goto L_0x013b
        L_0x0136:
            com.badlogic.gdx.Input$Orientation r6 = com.badlogic.gdx.Input.Orientation.Portrait
            r5.nativeOrientation = r6
            goto L_0x013f
        L_0x013b:
            com.badlogic.gdx.Input$Orientation r6 = com.badlogic.gdx.Input.Orientation.Landscape
            r5.nativeOrientation = r6
        L_0x013f:
            r6 = 255(0xff, float:3.57E-43)
            com.badlogic.gdx.utils.IntSet r7 = r5.keysToCatch
            r7.add(r6)
            return
        L_0x0147:
            r6 = 0
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.DefaultAndroidInput.<init>(com.badlogic.gdx.Application, android.content.Context, java.lang.Object, com.badlogic.gdx.backends.android.AndroidApplicationConfiguration):void");
    }

    public int getFreePointerIndex() {
        int length = this.realId.length;
        for (int i = 0; i < length; i++) {
            if (this.realId[i] == -1) {
                return i;
            }
        }
        float[] fArr = this.pressure;
        float[] fArr2 = new float[(fArr.length + 2)];
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
        this.pressure = fArr2;
        this.realId = resize(this.realId);
        this.touchX = resize(this.touchX);
        this.touchY = resize(this.touchY);
        this.deltaX = resize(this.deltaX);
        this.deltaY = resize(this.deltaY);
        boolean[] zArr = this.touched;
        boolean[] zArr2 = new boolean[(zArr.length + 2)];
        System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
        this.touched = zArr2;
        this.button = resize(this.button);
        return length;
    }

    public int lookUpPointerIndex(int i) {
        int length = this.realId.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.realId[i2] == i) {
                return i2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(i3 + ":" + this.realId[i3] + CMap.SPACE);
        }
        Application application = k.app;
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Pointer ID lookup failed: ", i, ", ");
        outline74.append(sb.toString());
        application.log("AndroidInput", outline74.toString());
        return -1;
    }

    public boolean onGenericMotion(View view, MotionEvent motionEvent) {
        boolean z;
        MotionEvent motionEvent2 = motionEvent;
        AndroidMouseHandler androidMouseHandler = this.mouseHandler;
        if (androidMouseHandler != null) {
            if ((motionEvent.getSource() & 2) == 0) {
                z = false;
            } else {
                int action = motionEvent.getAction() & InvitationReply.EXPIRED;
                long nanoTime = System.nanoTime();
                synchronized (this) {
                    if (action == 7) {
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();
                        if (!(x == androidMouseHandler.deltaX && y == androidMouseHandler.deltaY)) {
                            androidMouseHandler.postTouchEvent(this, 4, x, y, 0, 0, nanoTime);
                            androidMouseHandler.deltaX = x;
                            androidMouseHandler.deltaY = y;
                        }
                    } else if (action == 8) {
                        int i = (int) (-Math.signum(motionEvent2.getAxisValue(9)));
                        androidMouseHandler.postTouchEvent(this, 3, 0, 0, (int) (-Math.signum(motionEvent2.getAxisValue(10))), i, nanoTime);
                    }
                }
                ((AndroidGraphics) k.app.getGraphics()).requestRendering();
                z = true;
            }
            if (z) {
                return true;
            }
            int size = this.genericMotionListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.genericMotionListeners.get(i2).onGenericMotion(view, motionEvent2)) {
                    return true;
                }
            }
            return false;
        }
        throw null;
    }

    public boolean onKey(View view, int i, android.view.KeyEvent keyEvent) {
        int size = this.keyListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.keyListeners.get(i2).onKey(view, i, keyEvent)) {
                return true;
            }
        }
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() > 0) {
            return isCatchKey(i);
        }
        synchronized (this) {
            if (keyEvent.getKeyCode() == 0 && keyEvent.getAction() == 2) {
                String characters = keyEvent.getCharacters();
                for (int i3 = 0; i3 < characters.length(); i3++) {
                    KeyEvent keyEvent2 = (KeyEvent) this.usedKeyEvents.obtain();
                    keyEvent2.timeStamp = System.nanoTime();
                    keyEvent2.keyCode = 0;
                    keyEvent2.keyChar = characters.charAt(i3);
                    keyEvent2.type = 2;
                    this.keyEvents.add(keyEvent2);
                }
                return false;
            }
            char unicodeChar = (char) keyEvent.getUnicodeChar();
            if (i == 67) {
                unicodeChar = 8;
            }
            if (keyEvent.getKeyCode() >= 0) {
                if (keyEvent.getKeyCode() <= 255) {
                    int action = keyEvent.getAction();
                    if (action == 0) {
                        KeyEvent keyEvent3 = (KeyEvent) this.usedKeyEvents.obtain();
                        keyEvent3.timeStamp = System.nanoTime();
                        keyEvent3.keyChar = 0;
                        keyEvent3.keyCode = keyEvent.getKeyCode();
                        keyEvent3.type = 0;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            keyEvent3.keyCode = InvitationReply.EXPIRED;
                            i = InvitationReply.EXPIRED;
                        }
                        this.keyEvents.add(keyEvent3);
                        if (!this.pressedKeys[keyEvent3.keyCode]) {
                            this.pressedKeyCount++;
                            this.pressedKeys[keyEvent3.keyCode] = true;
                        }
                    } else if (action == 1) {
                        long nanoTime = System.nanoTime();
                        KeyEvent keyEvent4 = (KeyEvent) this.usedKeyEvents.obtain();
                        keyEvent4.timeStamp = nanoTime;
                        keyEvent4.keyChar = 0;
                        keyEvent4.keyCode = keyEvent.getKeyCode();
                        keyEvent4.type = 1;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            keyEvent4.keyCode = InvitationReply.EXPIRED;
                            i = InvitationReply.EXPIRED;
                        }
                        this.keyEvents.add(keyEvent4);
                        KeyEvent keyEvent5 = (KeyEvent) this.usedKeyEvents.obtain();
                        keyEvent5.timeStamp = nanoTime;
                        keyEvent5.keyChar = unicodeChar;
                        keyEvent5.keyCode = 0;
                        keyEvent5.type = 2;
                        this.keyEvents.add(keyEvent5);
                        if (i == 255) {
                            if (this.pressedKeys[255]) {
                                this.pressedKeyCount--;
                                this.pressedKeys[255] = false;
                            }
                        } else if (this.pressedKeys[keyEvent.getKeyCode()]) {
                            this.pressedKeyCount--;
                            this.pressedKeys[keyEvent.getKeyCode()] = false;
                        }
                    }
                    ((AndroidGraphics) this.app.getGraphics()).requestRendering();
                    return isCatchKey(i);
                }
            }
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r12v0 */
    /* JADX WARNING: type inference failed for: r1v12, types: [boolean[]] */
    /* JADX WARNING: type inference failed for: r12v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: type inference failed for: r12v3, types: [int] */
    /* JADX WARNING: type inference failed for: r12v4, types: [int] */
    /* JADX WARNING: type inference failed for: r12v5 */
    /* JADX WARNING: type inference failed for: r12v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r12v5
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int, ?[boolean, int, float, short, byte, char]]
      uses: [boolean, ?[int, byte, short, char], int]
      mth insns count: 225
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0175 A[Catch:{ all -> 0x01b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0189 A[Catch:{ all -> 0x01b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a4 A[Catch:{ all -> 0x01b4 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r22, android.view.MotionEvent r23) {
        /*
            r21 = this;
            r10 = r21
            r0 = r22
            r11 = r23
            boolean r1 = r10.requestFocus
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0016
            r0.setFocusableInTouchMode(r13)
            r22.requestFocus()
            r10.requestFocus = r12
        L_0x0016:
            com.badlogic.gdx.backends.android.AndroidTouchHandler r0 = r10.touchHandler
            if (r0 == 0) goto L_0x01ce
            int r1 = r23.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r2 = r23.getAction()
            r3 = 65280(0xff00, float:9.1477E-41)
            r2 = r2 & r3
            r3 = 8
            int r14 = r2 >> 8
            int r2 = r11.getPointerId(r14)
            long r15 = java.lang.System.nanoTime()
            monitor-enter(r21)
            r17 = 0
            r8 = -1
            r9 = 20
            switch(r1) {
                case 0: goto L_0x0138;
                case 1: goto L_0x00e7;
                case 2: goto L_0x0068;
                case 3: goto L_0x003f;
                case 4: goto L_0x00e7;
                case 5: goto L_0x0138;
                case 6: goto L_0x00e7;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x01b6
        L_0x003f:
            r0 = 0
        L_0x0040:
            int[] r1 = r10.realId     // Catch:{ all -> 0x01b4 }
            int r1 = r1.length     // Catch:{ all -> 0x01b4 }
            if (r0 >= r1) goto L_0x01b6
            int[] r1 = r10.realId     // Catch:{ all -> 0x01b4 }
            r1[r0] = r8     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.touchX     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.touchY     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.deltaX     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.deltaY     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            boolean[] r1 = r10.touched     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.button     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            float[] r1 = r10.pressure     // Catch:{ all -> 0x01b4 }
            r1[r0] = r17     // Catch:{ all -> 0x01b4 }
            int r0 = r0 + 1
            goto L_0x0040
        L_0x0068:
            int r14 = r23.getPointerCount()     // Catch:{ all -> 0x01b4 }
        L_0x006c:
            if (r12 >= r14) goto L_0x01b6
            int r1 = r11.getPointerId(r12)     // Catch:{ all -> 0x01b4 }
            float r2 = r11.getX(r12)     // Catch:{ all -> 0x01b4 }
            int r7 = (int) r2     // Catch:{ all -> 0x01b4 }
            float r2 = r11.getY(r12)     // Catch:{ all -> 0x01b4 }
            int r6 = (int) r2     // Catch:{ all -> 0x01b4 }
            int r5 = r10.lookUpPointerIndex(r1)     // Catch:{ all -> 0x01b4 }
            if (r5 != r8) goto L_0x0084
            r13 = -1
            goto L_0x00e0
        L_0x0084:
            if (r5 < r9) goto L_0x0088
            goto L_0x01b6
        L_0x0088:
            int[] r1 = r10.button     // Catch:{ all -> 0x01b4 }
            r4 = r1[r5]     // Catch:{ all -> 0x01b4 }
            if (r4 == r8) goto L_0x00a6
            r3 = 2
            r1 = r0
            r2 = r21
            r17 = r4
            r4 = r7
            r18 = r5
            r5 = r6
            r19 = r6
            r6 = r18
            r20 = r7
            r7 = r17
            r13 = -1
            r8 = r15
            r1.postTouchEvent(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01b4 }
            goto L_0x00bc
        L_0x00a6:
            r18 = r5
            r19 = r6
            r20 = r7
            r13 = -1
            r3 = 4
            r7 = 0
            r1 = r0
            r2 = r21
            r4 = r20
            r5 = r19
            r6 = r18
            r8 = r15
            r1.postTouchEvent(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01b4 }
        L_0x00bc:
            int[] r1 = r10.deltaX     // Catch:{ all -> 0x01b4 }
            int[] r2 = r10.touchX     // Catch:{ all -> 0x01b4 }
            r2 = r2[r18]     // Catch:{ all -> 0x01b4 }
            int r7 = r20 - r2
            r1[r18] = r7     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.deltaY     // Catch:{ all -> 0x01b4 }
            int[] r2 = r10.touchY     // Catch:{ all -> 0x01b4 }
            r2 = r2[r18]     // Catch:{ all -> 0x01b4 }
            int r6 = r19 - r2
            r1[r18] = r6     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.touchX     // Catch:{ all -> 0x01b4 }
            r1[r18] = r20     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.touchY     // Catch:{ all -> 0x01b4 }
            r1[r18] = r19     // Catch:{ all -> 0x01b4 }
            float[] r1 = r10.pressure     // Catch:{ all -> 0x01b4 }
            float r2 = r11.getPressure(r12)     // Catch:{ all -> 0x01b4 }
            r1[r18] = r2     // Catch:{ all -> 0x01b4 }
        L_0x00e0:
            int r12 = r12 + 1
            r8 = -1
            r9 = 20
            r13 = 1
            goto L_0x006c
        L_0x00e7:
            r13 = -1
            int r8 = r10.lookUpPointerIndex(r2)     // Catch:{ all -> 0x01b4 }
            if (r8 != r13) goto L_0x00f0
            goto L_0x01b6
        L_0x00f0:
            r1 = 20
            if (r8 < r1) goto L_0x00f6
            goto L_0x01b6
        L_0x00f6:
            int[] r1 = r10.realId     // Catch:{ all -> 0x01b4 }
            r1[r8] = r13     // Catch:{ all -> 0x01b4 }
            float r1 = r11.getX(r14)     // Catch:{ all -> 0x01b4 }
            int r9 = (int) r1     // Catch:{ all -> 0x01b4 }
            float r1 = r11.getY(r14)     // Catch:{ all -> 0x01b4 }
            int r11 = (int) r1     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.button     // Catch:{ all -> 0x01b4 }
            r7 = r1[r8]     // Catch:{ all -> 0x01b4 }
            if (r7 == r13) goto L_0x0118
            r3 = 1
            r1 = r0
            r2 = r21
            r4 = r9
            r5 = r11
            r6 = r8
            r0 = r8
            r13 = r9
            r8 = r15
            r1.postTouchEvent(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01b4 }
            goto L_0x011a
        L_0x0118:
            r0 = r8
            r13 = r9
        L_0x011a:
            int[] r1 = r10.touchX     // Catch:{ all -> 0x01b4 }
            r1[r0] = r13     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.touchY     // Catch:{ all -> 0x01b4 }
            r1[r0] = r11     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.deltaX     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.deltaY     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            boolean[] r1 = r10.touched     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.button     // Catch:{ all -> 0x01b4 }
            r1[r0] = r12     // Catch:{ all -> 0x01b4 }
            float[] r1 = r10.pressure     // Catch:{ all -> 0x01b4 }
            r1[r0] = r17     // Catch:{ all -> 0x01b4 }
            goto L_0x01b6
        L_0x0138:
            r1 = 20
            r13 = -1
            int r8 = r21.getFreePointerIndex()     // Catch:{ all -> 0x01b4 }
            if (r8 < r1) goto L_0x0143
            goto L_0x01b6
        L_0x0143:
            int[] r1 = r10.realId     // Catch:{ all -> 0x01b4 }
            r1[r8] = r2     // Catch:{ all -> 0x01b4 }
            float r1 = r11.getX(r14)     // Catch:{ all -> 0x01b4 }
            int r9 = (int) r1     // Catch:{ all -> 0x01b4 }
            float r1 = r11.getY(r14)     // Catch:{ all -> 0x01b4 }
            int r7 = (int) r1     // Catch:{ all -> 0x01b4 }
            int r1 = r23.getButtonState()     // Catch:{ all -> 0x01b4 }
            r2 = 4
            r4 = 2
            if (r1 == 0) goto L_0x0172
            r5 = 1
            if (r1 != r5) goto L_0x015d
            goto L_0x0172
        L_0x015d:
            if (r1 != r4) goto L_0x0161
            r6 = 1
            goto L_0x0173
        L_0x0161:
            if (r1 != r2) goto L_0x0165
            r6 = 2
            goto L_0x0173
        L_0x0165:
            if (r1 != r3) goto L_0x016a
            r1 = 3
            r6 = 3
            goto L_0x0173
        L_0x016a:
            r3 = 16
            if (r1 != r3) goto L_0x0170
            r6 = 4
            goto L_0x0173
        L_0x0170:
            r6 = -1
            goto L_0x0173
        L_0x0172:
            r6 = 0
        L_0x0173:
            if (r6 == r13) goto L_0x0189
            r3 = 0
            r1 = r0
            r2 = r21
            r4 = r9
            r5 = r7
            r0 = r6
            r6 = r8
            r17 = r7
            r7 = r0
            r18 = r8
            r19 = r9
            r8 = r15
            r1.postTouchEvent(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x01b4 }
            goto L_0x0190
        L_0x0189:
            r0 = r6
            r17 = r7
            r18 = r8
            r19 = r9
        L_0x0190:
            int[] r1 = r10.touchX     // Catch:{ all -> 0x01b4 }
            r1[r18] = r19     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.touchY     // Catch:{ all -> 0x01b4 }
            r1[r18] = r17     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.deltaX     // Catch:{ all -> 0x01b4 }
            r1[r18] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.deltaY     // Catch:{ all -> 0x01b4 }
            r1[r18] = r12     // Catch:{ all -> 0x01b4 }
            boolean[] r1 = r10.touched     // Catch:{ all -> 0x01b4 }
            if (r0 == r13) goto L_0x01a5
            r12 = 1
        L_0x01a5:
            r1[r18] = r12     // Catch:{ all -> 0x01b4 }
            int[] r1 = r10.button     // Catch:{ all -> 0x01b4 }
            r1[r18] = r0     // Catch:{ all -> 0x01b4 }
            float[] r0 = r10.pressure     // Catch:{ all -> 0x01b4 }
            float r1 = r11.getPressure(r14)     // Catch:{ all -> 0x01b4 }
            r0[r18] = r1     // Catch:{ all -> 0x01b4 }
            goto L_0x01b6
        L_0x01b4:
            r0 = move-exception
            goto L_0x01cc
        L_0x01b6:
            monitor-exit(r21)     // Catch:{ all -> 0x01b4 }
            com.badlogic.gdx.Application r0 = co.hyperverge.hypersnapsdk.c.k.app
            com.badlogic.gdx.Graphics r0 = r0.getGraphics()
            com.badlogic.gdx.backends.android.AndroidGraphics r0 = (com.badlogic.gdx.backends.android.AndroidGraphics) r0
            r0.requestRendering()
            int r0 = r10.sleepTime
            if (r0 == 0) goto L_0x01ca
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x01ca }
        L_0x01ca:
            r0 = 1
            return r0
        L_0x01cc:
            monitor-exit(r21)     // Catch:{ all -> 0x01b4 }
            throw r0
        L_0x01ce:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.DefaultAndroidInput.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void processEvents() {
        synchronized (this) {
            if (this.justTouched) {
                this.justTouched = false;
                for (int i = 0; i < this.justPressedButtons.length; i++) {
                    this.justPressedButtons[i] = false;
                }
            }
            if (this.keyJustPressed) {
                this.keyJustPressed = false;
                for (int i2 = 0; i2 < this.justPressedKeys.length; i2++) {
                    this.justPressedKeys[i2] = false;
                }
            }
            if (this.processor != null) {
                InputAdapter inputAdapter = this.processor;
                int size = this.keyEvents.size();
                for (int i3 = 0; i3 < size; i3++) {
                    KeyEvent keyEvent = this.keyEvents.get(i3);
                    this.currentEventTimeStamp = keyEvent.timeStamp;
                    int i4 = keyEvent.type;
                    if (i4 == 0) {
                        inputAdapter.keyDown(keyEvent.keyCode);
                        this.keyJustPressed = true;
                        this.justPressedKeys[keyEvent.keyCode] = true;
                    } else if (i4 == 1) {
                        inputAdapter.keyUp(keyEvent.keyCode);
                    } else if (i4 == 2) {
                        inputAdapter.keyTyped(keyEvent.keyChar);
                    }
                    this.usedKeyEvents.free(keyEvent);
                }
                int size2 = this.touchEvents.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    TouchEvent touchEvent = this.touchEvents.get(i5);
                    this.currentEventTimeStamp = touchEvent.timeStamp;
                    int i6 = touchEvent.type;
                    if (i6 == 0) {
                        inputAdapter.touchDown(touchEvent.x, touchEvent.y, touchEvent.pointer, touchEvent.button);
                        this.justTouched = true;
                        this.justPressedButtons[touchEvent.button] = true;
                    } else if (i6 == 1) {
                        inputAdapter.touchUp(touchEvent.x, touchEvent.y, touchEvent.pointer, touchEvent.button);
                    } else if (i6 == 2) {
                        inputAdapter.touchDragged(touchEvent.x, touchEvent.y, touchEvent.pointer);
                    } else if (i6 == 3) {
                        inputAdapter.scrolled((float) touchEvent.scrollAmountX, (float) touchEvent.scrollAmountY);
                    } else if (i6 == 4) {
                        inputAdapter.mouseMoved(touchEvent.x, touchEvent.y);
                    }
                    this.usedTouchEvents.free(touchEvent);
                }
            } else {
                int size3 = this.touchEvents.size();
                for (int i7 = 0; i7 < size3; i7++) {
                    TouchEvent touchEvent2 = this.touchEvents.get(i7);
                    if (touchEvent2.type == 0) {
                        this.justTouched = true;
                    }
                    this.usedTouchEvents.free(touchEvent2);
                }
                int size4 = this.keyEvents.size();
                for (int i8 = 0; i8 < size4; i8++) {
                    this.usedKeyEvents.free(this.keyEvents.get(i8));
                }
            }
            if (this.touchEvents.isEmpty()) {
                for (int i9 = 0; i9 < this.deltaX.length; i9++) {
                    this.deltaX[0] = 0;
                    this.deltaY[0] = 0;
                }
            }
            this.keyEvents.clear();
            this.touchEvents.clear();
        }
    }

    public void registerSensorListeners() {
        if (this.config.useAccelerometer) {
            SensorManager sensorManager = (SensorManager) this.context.getSystemService("sensor");
            this.manager = sensorManager;
            if (sensorManager.getSensorList(1).isEmpty()) {
                this.accelerometerAvailable = false;
            } else {
                SensorListener sensorListener = new SensorListener();
                this.accelerometerListener = sensorListener;
                this.accelerometerAvailable = this.manager.registerListener(sensorListener, this.manager.getSensorList(1).get(0), this.config.sensorDelay);
            }
        } else {
            this.accelerometerAvailable = false;
        }
        if (this.config.useGyroscope) {
            SensorManager sensorManager2 = (SensorManager) this.context.getSystemService("sensor");
            this.manager = sensorManager2;
            if (!sensorManager2.getSensorList(4).isEmpty()) {
                SensorListener sensorListener2 = new SensorListener();
                this.gyroscopeListener = sensorListener2;
                this.manager.registerListener(sensorListener2, this.manager.getSensorList(4).get(0), this.config.sensorDelay);
            }
        }
        this.rotationVectorAvailable = false;
        if (this.config.useRotationVectorSensor) {
            if (this.manager == null) {
                this.manager = (SensorManager) this.context.getSystemService("sensor");
            }
            List<Sensor> sensorList = this.manager.getSensorList(11);
            if (!sensorList.isEmpty()) {
                this.rotationVectorListener = new SensorListener();
                Iterator<Sensor> it = sensorList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Sensor next = it.next();
                    if (next.getVendor().equals("Google Inc.") && next.getVersion() == 3) {
                        this.rotationVectorAvailable = this.manager.registerListener(this.rotationVectorListener, next, this.config.sensorDelay);
                        break;
                    }
                }
                if (!this.rotationVectorAvailable) {
                    this.rotationVectorAvailable = this.manager.registerListener(this.rotationVectorListener, sensorList.get(0), this.config.sensorDelay);
                }
            }
        }
        if (!this.config.useCompass || this.rotationVectorAvailable) {
            this.compassAvailable = false;
        } else {
            if (this.manager == null) {
                this.manager = (SensorManager) this.context.getSystemService("sensor");
            }
            Sensor defaultSensor = this.manager.getDefaultSensor(2);
            if (defaultSensor != null) {
                boolean z = this.accelerometerAvailable;
                this.compassAvailable = z;
                if (z) {
                    SensorListener sensorListener3 = new SensorListener();
                    this.compassListener = sensorListener3;
                    this.compassAvailable = this.manager.registerListener(sensorListener3, defaultSensor, this.config.sensorDelay);
                }
            } else {
                this.compassAvailable = false;
            }
        }
        k.app.log("AndroidInput", "sensor listener setup");
    }

    public final int[] resize(int[] iArr) {
        int[] iArr2 = new int[(iArr.length + 2)];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public void unregisterSensorListeners() {
        SensorManager sensorManager = this.manager;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.accelerometerListener;
            if (sensorEventListener != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.accelerometerListener = null;
            }
            SensorEventListener sensorEventListener2 = this.gyroscopeListener;
            if (sensorEventListener2 != null) {
                this.manager.unregisterListener(sensorEventListener2);
                this.gyroscopeListener = null;
            }
            SensorEventListener sensorEventListener3 = this.rotationVectorListener;
            if (sensorEventListener3 != null) {
                this.manager.unregisterListener(sensorEventListener3);
                this.rotationVectorListener = null;
            }
            SensorEventListener sensorEventListener4 = this.compassListener;
            if (sensorEventListener4 != null) {
                this.manager.unregisterListener(sensorEventListener4);
                this.compassListener = null;
            }
            this.manager = null;
        }
        k.app.log("AndroidInput", "sensor listener tear down");
    }
}
