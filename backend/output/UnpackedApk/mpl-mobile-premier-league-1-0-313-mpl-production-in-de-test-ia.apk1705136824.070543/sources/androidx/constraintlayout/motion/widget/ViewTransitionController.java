package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition.Animate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;
import androidx.constraintlayout.widget.SharedValues.SharedValuesListener;
import java.util.ArrayList;
import java.util.HashSet;

public class ViewTransitionController {
    public String TAG = "ViewTransitionController";
    public ArrayList<Animate> animations;
    public final MotionLayout mMotionLayout;
    public HashSet<View> mRelatedViews;
    public ArrayList<Animate> removeList = new ArrayList<>();
    public ArrayList<ViewTransition> viewTransitions = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    public final void listenForSharedVariable(ViewTransition viewTransition, boolean z) {
        int i = viewTransition.mSharedValueID;
        int i2 = viewTransition.mSharedValueTarget;
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i3 = viewTransition.mSharedValueID;
        AnonymousClass1 r0 = new SharedValuesListener(this, viewTransition, i, z, i2) {
        };
        sharedValues.addListener(i3, r0);
    }
}
