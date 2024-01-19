package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import java.util.HashMap;

public class DesignTool {
    public static final HashMap<Pair<Integer, Integer>, String> allAttributes = new HashMap<>();
    public static final HashMap<String, String> allMargins = new HashMap<>();
    public final MotionLayout mMotionLayout;

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = allAttributes;
        Integer valueOf = Integer.valueOf(4);
        hashMap.put(Pair.create(valueOf, valueOf), "layout_constraintBottom_toBottomOf");
        HashMap<Pair<Integer, Integer>, String> hashMap2 = allAttributes;
        Integer valueOf2 = Integer.valueOf(3);
        hashMap2.put(Pair.create(valueOf, valueOf2), "layout_constraintBottom_toTopOf");
        allAttributes.put(Pair.create(valueOf2, valueOf), "layout_constraintTop_toBottomOf");
        allAttributes.put(Pair.create(valueOf2, valueOf2), "layout_constraintTop_toTopOf");
        HashMap<Pair<Integer, Integer>, String> hashMap3 = allAttributes;
        Integer valueOf3 = Integer.valueOf(6);
        hashMap3.put(Pair.create(valueOf3, valueOf3), "layout_constraintStart_toStartOf");
        HashMap<Pair<Integer, Integer>, String> hashMap4 = allAttributes;
        Integer valueOf4 = Integer.valueOf(7);
        hashMap4.put(Pair.create(valueOf3, valueOf4), "layout_constraintStart_toEndOf");
        allAttributes.put(Pair.create(valueOf4, valueOf3), "layout_constraintEnd_toStartOf");
        allAttributes.put(Pair.create(valueOf4, valueOf4), "layout_constraintEnd_toEndOf");
        HashMap<Pair<Integer, Integer>, String> hashMap5 = allAttributes;
        Integer valueOf5 = Integer.valueOf(1);
        hashMap5.put(Pair.create(valueOf5, valueOf5), "layout_constraintLeft_toLeftOf");
        HashMap<Pair<Integer, Integer>, String> hashMap6 = allAttributes;
        Integer valueOf6 = Integer.valueOf(2);
        hashMap6.put(Pair.create(valueOf5, valueOf6), "layout_constraintLeft_toRightOf");
        allAttributes.put(Pair.create(valueOf6, valueOf6), "layout_constraintRight_toRightOf");
        allAttributes.put(Pair.create(valueOf6, valueOf5), "layout_constraintRight_toLeftOf");
        HashMap<Pair<Integer, Integer>, String> hashMap7 = allAttributes;
        Integer valueOf7 = Integer.valueOf(5);
        hashMap7.put(Pair.create(valueOf7, valueOf7), "layout_constraintBaseline_toBaselineOf");
        allMargins.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        allMargins.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        allMargins.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        allMargins.put("layout_constraintTop_toTopOf", "layout_marginTop");
        allMargins.put("layout_constraintStart_toStartOf", "layout_marginStart");
        allMargins.put("layout_constraintStart_toEndOf", "layout_marginStart");
        allMargins.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        allMargins.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        allMargins.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        allMargins.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        allMargins.put("layout_constraintRight_toRightOf", "layout_marginRight");
        allMargins.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }
}
