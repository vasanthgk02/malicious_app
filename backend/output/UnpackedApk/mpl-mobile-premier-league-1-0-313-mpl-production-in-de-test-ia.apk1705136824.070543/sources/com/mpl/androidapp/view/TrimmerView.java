package com.mpl.androidapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.WindowUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002OPB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u0018J\u0012\u00104\u001a\u0002012\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020\u0011H\u0002J\u0006\u00108\u001a\u00020\u0011J\u0006\u00109\u001a\u00020\u0011J\u0010\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000201H\u0014J(\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0014J\u0012\u0010C\u001a\u00020D2\b\u0010;\u001a\u0004\u0018\u00010<H\u0017J\u0010\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020DH\u0016J\u000e\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020\u0011J\u000e\u0010I\u001a\u0002012\u0006\u0010.\u001a\u00020/J\u000e\u0010J\u001a\u0002012\u0006\u0010\u0016\u001a\u00020KJ\u0010\u0010L\u001a\u0002012\u0006\u0010M\u001a\u00020\u0011H\u0002J\u0010\u0010N\u001a\u0002012\u0006\u0010M\u001a\u00020\u0011H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/mpl/androidapp/view/TrimmerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_positionChangeSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/mpl/androidapp/view/TrimmerView$Position;", "borderPaint", "Landroid/graphics/Paint;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "currentLeftThumbPosition", "", "currentRightThumbPosition", "currentTouchArea", "Lcom/mpl/androidapp/view/TrimmerView$TouchArea;", "cursorPaint", "cursorPositionInPercentage", "defaultMinDuration", "", "endPositionOfPreview", "getEndPositionOfPreview", "()J", "setEndPositionOfPreview", "(J)V", "extraThumbTouchableArea", "leftIcon", "Landroid/graphics/drawable/Drawable;", "minGapPercentage", "positionChangeSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getPositionChangeSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "setPositionChangeSharedFlow", "(Lkotlinx/coroutines/flow/SharedFlow;)V", "rightIcon", "startPositionOfPreview", "getStartPositionOfPreview", "setStartPositionOfPreview", "thumbnailsLoadJob", "Lkotlinx/coroutines/Job;", "url", "", "addThumbNails", "", "calculateMinAndMaxTimeForPreview", "endPosition", "draw", "canvas", "Landroid/graphics/Canvas;", "getCursorPosition", "getEndPositionInPercentage", "getStartPositionInPercentage", "handleMoveAction", "event", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "", "setEnabled", "enabled", "setMinGapPercentage", "percentage", "setThumbNailUrl", "updateCursorPosition", "", "updateLeftThumbPosition", "newPosition", "updateRightThumbPosition", "Position", "TouchArea", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrimmerView.kt */
public final class TrimmerView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    public MutableSharedFlow<Position> _positionChangeSharedFlow;
    public final Paint borderPaint;
    public CoroutineScope coroutineScope;
    public float currentLeftThumbPosition;
    public float currentRightThumbPosition;
    public TouchArea currentTouchArea;
    public final Paint cursorPaint;
    public float cursorPositionInPercentage;
    public final long defaultMinDuration;
    public long endPositionOfPreview;
    public final float extraThumbTouchableArea;
    public Drawable leftIcon;
    public float minGapPercentage;
    public SharedFlow<? extends Position> positionChangeSharedFlow;
    public Drawable rightIcon;
    public long startPositionOfPreview;
    public Job thumbnailsLoadJob;
    public String url;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/view/TrimmerView$Position;", "", "()V", "None", "OnEndPositionUpdated", "OnStartPositionUpdated", "Lcom/mpl/androidapp/view/TrimmerView$Position$None;", "Lcom/mpl/androidapp/view/TrimmerView$Position$OnStartPositionUpdated;", "Lcom/mpl/androidapp/view/TrimmerView$Position$OnEndPositionUpdated;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TrimmerView.kt */
    public static abstract class Position {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/mpl/androidapp/view/TrimmerView$Position$None;", "Lcom/mpl/androidapp/view/TrimmerView$Position;", "()V", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: TrimmerView.kt */
        public static final class None extends Position {
            public static final None INSTANCE = new None();

            public None() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/view/TrimmerView$Position$OnEndPositionUpdated;", "Lcom/mpl/androidapp/view/TrimmerView$Position;", "positionInPercentage", "", "(F)V", "getPositionInPercentage", "()F", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: TrimmerView.kt */
        public static final class OnEndPositionUpdated extends Position {
            public final float positionInPercentage;

            public OnEndPositionUpdated(float f2) {
                super(null);
                this.positionInPercentage = f2;
            }

            public final float getPositionInPercentage() {
                return this.positionInPercentage;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/view/TrimmerView$Position$OnStartPositionUpdated;", "Lcom/mpl/androidapp/view/TrimmerView$Position;", "positionInPercentage", "", "(F)V", "getPositionInPercentage", "()F", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: TrimmerView.kt */
        public static final class OnStartPositionUpdated extends Position {
            public final float positionInPercentage;

            public OnStartPositionUpdated(float f2) {
                super(null);
                this.positionInPercentage = f2;
            }

            public final float getPositionInPercentage() {
                return this.positionInPercentage;
            }
        }

        public Position() {
        }

        public /* synthetic */ Position(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/view/TrimmerView$TouchArea;", "", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "MIDDLE", "NONE", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TrimmerView.kt */
    public enum TouchArea {
        LEFT,
        RIGHT,
        MIDDLE,
        NONE
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TrimmerView(Context context) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, null, 0, 6, null);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TrimmerView(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ TrimmerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final float getCursorPosition() {
        return ((((this.currentRightThumbPosition - ((float) this.rightIcon.getIntrinsicWidth())) - (this.currentLeftThumbPosition + ((float) this.leftIcon.getIntrinsicWidth()))) * this.cursorPositionInPercentage) / 100.0f) + this.currentLeftThumbPosition + ((float) this.leftIcon.getIntrinsicWidth());
    }

    private final void handleMoveAction(MotionEvent motionEvent) {
        MLogger.d(TrimmerViewKt.TAG, Intrinsics.stringPlus("handleMoveAction : ", this.currentTouchArea));
        TouchArea touchArea = this.currentTouchArea;
        if (touchArea == TouchArea.LEFT) {
            updateLeftThumbPosition(motionEvent.getX());
        } else if (touchArea == TouchArea.RIGHT) {
            updateRightThumbPosition(motionEvent.getX());
        }
    }

    private final void updateLeftThumbPosition(float f2) {
        MLogger.d(TrimmerViewKt.TAG, "updateLeftThumbPosition");
        if (f2 > 0.0f && this.currentRightThumbPosition - f2 > (this.minGapPercentage * ((float) getWidth())) / 100.0f) {
            this.currentLeftThumbPosition = f2;
            MLogger.d(TrimmerViewKt.TAG, "updateLeftThumbPosition invalidate");
            TypeUtilsKt.launch$default(this.coroutineScope, null, null, new TrimmerView$updateLeftThumbPosition$1(this, null), 3, null);
            invalidate();
        }
    }

    private final void updateRightThumbPosition(float f2) {
        MLogger.d(TrimmerViewKt.TAG, "updateRightThumbPosition");
        if (f2 < ((float) getWidth()) && f2 - this.currentLeftThumbPosition > (this.minGapPercentage * ((float) getWidth())) / 100.0f) {
            this.currentRightThumbPosition = f2;
            MLogger.d(TrimmerViewKt.TAG, "updateRightThumbPosition invalidate");
            TypeUtilsKt.launch$default(this.coroutineScope, null, null, new TrimmerView$updateRightThumbPosition$1(this, null), 3, null);
            invalidate();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void addThumbNails() {
        boolean z;
        MLogger.d(TrimmerViewKt.TAG, Intrinsics.stringPlus("addThumbNails -> ChildCount : ", Integer.valueOf(getChildCount())));
        if (getHeight() != 0 && getWidth() != 0) {
            String str = this.url;
            if (str != null) {
                if (!(str.length() == 0)) {
                    z = true;
                    if (z && getChildCount() <= 0) {
                        int height = (getHeight() * 3) / 4;
                        int width = (getWidth() / height) + 1;
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        mediaMetadataRetriever.setDataSource(getContext(), Uri.parse(this.url));
                        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        Intrinsics.checkNotNullExpressionValue(extractMetadata, "metaDataRetriever.extrac…er.METADATA_KEY_DURATION)");
                        long parseLong = (Long.parseLong(extractMetadata) * 1000) / ((long) width);
                        MLogger.d(TrimmerViewKt.TAG, Intrinsics.stringPlus("onSizeChanged -> totalFullThumbNails : ", Integer.valueOf(width)));
                        CoroutineScope CoroutineScope = TypeUtilsKt.CoroutineScope(Dispatchers.IO.plus(new TrimmerView$addThumbNails$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
                        TrimmerView$addThumbNails$1 trimmerView$addThumbNails$1 = new TrimmerView$addThumbNails$1(width, this, mediaMetadataRetriever, parseLong, height, null);
                        this.thumbnailsLoadJob = TypeUtilsKt.launch$default(CoroutineScope, null, null, trimmerView$addThumbNails$1, 3, null);
                        return;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
    }

    public final void calculateMinAndMaxTimeForPreview(long j) {
        long j2 = this.defaultMinDuration;
        if (j <= j2) {
            this.endPositionOfPreview = j;
            return;
        }
        this.startPositionOfPreview = j - j2;
        this.endPositionOfPreview = j;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            Drawable drawable = this.leftIcon;
            float f2 = this.currentLeftThumbPosition;
            drawable.setBounds((int) f2, 0, (int) (f2 + ((float) drawable.getIntrinsicWidth())), getHeight());
            drawable.draw(canvas);
            Drawable drawable2 = this.rightIcon;
            drawable2.setBounds((int) (this.currentRightThumbPosition - ((float) drawable2.getIntrinsicWidth())), 0, (int) this.currentRightThumbPosition, getHeight());
            drawable2.draw(canvas);
            canvas.drawLine(this.currentLeftThumbPosition, 0.0f, this.currentRightThumbPosition, 0.0f, this.borderPaint);
            canvas.drawLine(this.currentLeftThumbPosition, (float) getHeight(), this.currentRightThumbPosition, (float) getHeight(), this.borderPaint);
            canvas.drawLine(getCursorPosition(), this.borderPaint.getStrokeWidth(), getCursorPosition(), ((float) getHeight()) - this.borderPaint.getStrokeWidth(), this.cursorPaint);
        }
    }

    public final float getEndPositionInPercentage() {
        return (this.currentRightThumbPosition / ((float) getWidth())) * 100.0f;
    }

    public final long getEndPositionOfPreview() {
        return this.endPositionOfPreview;
    }

    public final SharedFlow<Position> getPositionChangeSharedFlow() {
        return this.positionChangeSharedFlow;
    }

    public final float getStartPositionInPercentage() {
        return (this.currentLeftThumbPosition / ((float) getWidth())) * 100.0f;
    }

    public final long getStartPositionOfPreview() {
        return this.startPositionOfPreview;
    }

    public void onDetachedFromWindow() {
        CoroutineScope coroutineScope2 = this.coroutineScope;
        Job job = (Job) coroutineScope2.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.cancel(null);
            Job job2 = this.thumbnailsLoadJob;
            if (job2 != null) {
                TypeUtilsKt.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            super.onDetachedFromWindow();
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope2).toString());
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.currentLeftThumbPosition = 0.0f;
        this.currentRightThumbPosition = (float) i;
        addThumbNails();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchArea touchArea;
        if (motionEvent != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("onTouchEvent : ");
            outline73.append(motionEvent.getAction());
            outline73.append(", X -> ");
            outline73.append(motionEvent.getX());
            outline73.append(", LeftArea : ");
            outline73.append(this.currentLeftThumbPosition + this.extraThumbTouchableArea);
            outline73.append(", RightArea : ");
            outline73.append(this.currentRightThumbPosition - this.extraThumbTouchableArea);
            MLogger.d(TrimmerViewKt.TAG, outline73.toString());
            if (isEnabled()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    if (motionEvent.getX() < this.currentLeftThumbPosition + ((float) this.leftIcon.getIntrinsicWidth()) + this.extraThumbTouchableArea) {
                        touchArea = TouchArea.LEFT;
                    } else if (motionEvent.getX() > (this.currentRightThumbPosition - ((float) this.rightIcon.getIntrinsicWidth())) - this.extraThumbTouchableArea) {
                        touchArea = TouchArea.RIGHT;
                    } else {
                        touchArea = TouchArea.MIDDLE;
                    }
                    this.currentTouchArea = touchArea;
                    return true;
                } else if (action == 1) {
                    this.currentTouchArea = TouchArea.NONE;
                } else if (action == 2) {
                    handleMoveAction(motionEvent);
                    return true;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        MLogger.d(TrimmerViewKt.TAG, Intrinsics.stringPlus("setEnabled : ", Boolean.valueOf(z)));
        setAlpha(z ? 1.0f : 0.3f);
    }

    public final void setEndPositionOfPreview(long j) {
        this.endPositionOfPreview = j;
    }

    public final void setMinGapPercentage(float f2) {
        MLogger.d(TrimmerViewKt.TAG, Intrinsics.stringPlus("setMinGapPercentage : ", Float.valueOf(f2)));
        this.minGapPercentage = f2;
    }

    public final void setPositionChangeSharedFlow(SharedFlow<? extends Position> sharedFlow) {
        Intrinsics.checkNotNullParameter(sharedFlow, "<set-?>");
        this.positionChangeSharedFlow = sharedFlow;
    }

    public final void setStartPositionOfPreview(long j) {
        this.startPositionOfPreview = j;
    }

    public final void setThumbNailUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        MLogger.d(TrimmerViewKt.TAG, Intrinsics.stringPlus("setThumbNailUrl -> Url : ", str));
        this.url = str;
        addThumbNails();
    }

    public final void updateCursorPosition(double d2) {
        boolean z = true;
        MLogger.d(TrimmerViewKt.TAG, Intrinsics.stringPlus("updateCursorPosition : ", Double.valueOf(d2)));
        if (0.0d > d2 || d2 > 100.0d) {
            z = false;
        }
        if (z) {
            this.cursorPositionInPercentage = (float) d2;
            invalidate();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TrimmerView(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_trimmer_left_thumb, null);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(resources, R…immer_left_thumb, null)!!");
        this.leftIcon = drawable;
        Drawable drawable2 = getResources().getDrawable(R.drawable.ic_trimmer_right_thumb, null);
        Intrinsics.checkNotNull(drawable2);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(resources, R…mmer_right_thumb, null)!!");
        this.rightIcon = drawable2;
        this.borderPaint = new Paint();
        this.cursorPaint = new Paint();
        this.extraThumbTouchableArea = (float) WindowUtil.dpToPx(16.0f, context);
        this.minGapPercentage = 16.666666f;
        this.currentTouchArea = TouchArea.NONE;
        this.coroutineScope = TypeUtilsKt.CoroutineScope(Dispatchers.getMain());
        MutableSharedFlow<Position> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7);
        this._positionChangeSharedFlow = MutableSharedFlow$default;
        this.positionChangeSharedFlow = new ReadonlySharedFlow(MutableSharedFlow$default, null);
        this.defaultMinDuration = 30000;
        MLogger.d(TrimmerViewKt.TAG, "Init");
        setEnabled(false);
        this.borderPaint.setColor(Color.parseColor("#E91051"));
        this.borderPaint.setStyle(Style.STROKE);
        this.borderPaint.setStrokeWidth((float) WindowUtil.dpToPx(6.0f, context));
        this.cursorPaint.setColor(ContextCompat.getColor(context, R.color.white));
        this.cursorPaint.setStyle(Style.STROKE);
        this.cursorPaint.setStrokeCap(Cap.ROUND);
        this.cursorPaint.setStrokeWidth((float) WindowUtil.dpToPx(4.0f, context));
        this._$_findViewCache = new LinkedHashMap();
    }
}
