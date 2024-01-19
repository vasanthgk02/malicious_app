package androidx.core.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import androidx.core.view.ViewCompat.AccessibilityViewProperty;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    public static final AccessibilityDelegate DEFAULT_DELEGATE = new AccessibilityDelegate();
    public final AccessibilityDelegate mBridge;
    public final AccessibilityDelegate mOriginalDelegate;

    public static final class AccessibilityDelegateAdapter extends AccessibilityDelegate {
        public final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.mCompat = accessibilityDelegateCompat;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.mProvider;
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            boolean z;
            int i;
            View view2 = view;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
            boolean isScreenReaderFocusable = ViewCompat.isScreenReaderFocusable(view);
            if (VERSION.SDK_INT >= 28) {
                accessibilityNodeInfoCompat.mInfo.setScreenReaderFocusable(isScreenReaderFocusable);
            } else {
                accessibilityNodeInfoCompat.setBooleanProperty(1, isScreenReaderFocusable);
            }
            Boolean bool = (Boolean) new AccessibilityViewProperty<Boolean>(R$id.tag_accessibility_heading, Boolean.class, 28) {
                public Object frameworkGet(View view) {
                    return Boolean.valueOf(view.isAccessibilityHeading());
                }

                public void frameworkSet(View view, Object obj) {
                    view.setAccessibilityHeading(((Boolean) obj).booleanValue());
                }

                public boolean shouldUpdate(Object obj, Object obj2) {
                    return !booleanNullToFalseEquals((Boolean) obj, (Boolean) obj2);
                }
            }.get(view2);
            if (bool == null) {
                z = false;
            } else {
                z = bool.booleanValue();
            }
            if (VERSION.SDK_INT >= 28) {
                accessibilityNodeInfoCompat.mInfo.setHeading(z);
            } else {
                accessibilityNodeInfoCompat.setBooleanProperty(2, z);
            }
            CharSequence accessibilityPaneTitle = ViewCompat.getAccessibilityPaneTitle(view);
            if (VERSION.SDK_INT >= 28) {
                accessibilityNodeInfoCompat.mInfo.setPaneTitle(accessibilityPaneTitle);
            } else {
                accessibilityNodeInfoCompat.mInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", accessibilityPaneTitle);
            }
            accessibilityNodeInfoCompat.setStateDescription((CharSequence) new AccessibilityViewProperty<CharSequence>(R$id.tag_state_description, CharSequence.class, 64, 30) {
                public boolean shouldUpdate(Object obj, Object obj2) {
                    return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                }

                public CharSequence frameworkGet(View view) {
                    return view.getStateDescription();
                }

                public void frameworkSet(View view, CharSequence charSequence) {
                    view.setStateDescription(charSequence);
                }
            }.get(view2));
            this.mCompat.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
            CharSequence text = accessibilityNodeInfo.getText();
            if (VERSION.SDK_INT < 26) {
                accessibilityNodeInfoCompat.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                accessibilityNodeInfoCompat.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                accessibilityNodeInfoCompat.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                accessibilityNodeInfoCompat.mInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view2.getTag(R$id.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                        if (((WeakReference) sparseArray.valueAt(i2)).get() == null) {
                            arrayList.add(Integer.valueOf(i2));
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        sparseArray.remove(((Integer) arrayList.get(i3)).intValue());
                    }
                }
                ClickableSpan[] clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(text);
                if (clickableSpans != null && clickableSpans.length > 0) {
                    accessibilityNodeInfoCompat.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R$id.accessibility_action_clickable_span);
                    SparseArray sparseArray2 = (SparseArray) view2.getTag(R$id.tag_accessibility_clickable_spans);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view2.setTag(R$id.tag_accessibility_clickable_spans, sparseArray2);
                    }
                    for (int i4 = 0; i4 < clickableSpans.length; i4++) {
                        ClickableSpan clickableSpan = clickableSpans[i4];
                        int i5 = 0;
                        while (true) {
                            if (i5 >= sparseArray2.size()) {
                                i = AccessibilityNodeInfoCompat.sClickableSpanId;
                                AccessibilityNodeInfoCompat.sClickableSpanId = i + 1;
                                break;
                            } else if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i5)).get())) {
                                i = sparseArray2.keyAt(i5);
                                break;
                            } else {
                                i5++;
                            }
                        }
                        sparseArray2.put(i, new WeakReference(clickableSpans[i4]));
                        ClickableSpan clickableSpan2 = clickableSpans[i4];
                        Spanned spanned = (Spanned) text;
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        accessibilityNodeInfoCompat.extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
                    }
                }
            }
            List list = (List) view2.getTag(R$id.tag_accessibility_actions);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (int i6 = 0; i6 < list.size(); i6++) {
                accessibilityNodeInfoCompat.addAction((AccessibilityActionCompat) list.get(i6));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.mCompat.performAccessibilityAction(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.mCompat.sendAccessibilityEvent(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.mCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public AccessibilityDelegateCompat() {
        this.mOriginalDelegate = DEFAULT_DELEGATE;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performAccessibilityAction(android.view.View r6, int r7, android.os.Bundle r8) {
        /*
            r5 = this;
            int r0 = androidx.core.R$id.tag_accessibility_actions
            java.lang.Object r0 = r6.getTag(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x000e
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x000e:
            r1 = 0
            r2 = 0
        L_0x0010:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x0046
            java.lang.Object r3 = r0.get(r2)
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r3 = (androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat) r3
            int r4 = r3.getId()
            if (r4 != r7) goto L_0x0043
            androidx.core.view.accessibility.AccessibilityViewCommand r0 = r3.mCommand
            if (r0 == 0) goto L_0x0046
            r0 = 0
            java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r2 = r3.mViewCommandArgumentClass
            if (r2 == 0) goto L_0x003c
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x003c }
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch:{ Exception -> 0x003c }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x003c }
            java.lang.Object r2 = r2.newInstance(r4)     // Catch:{ Exception -> 0x003c }
            androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments r2 = (androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments) r2     // Catch:{ Exception -> 0x003c }
            r2.mBundle = r8     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            r0 = r2
        L_0x003c:
            androidx.core.view.accessibility.AccessibilityViewCommand r2 = r3.mCommand
            boolean r0 = r2.perform(r6, r0)
            goto L_0x0047
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 != 0) goto L_0x004f
            android.view.View$AccessibilityDelegate r0 = r5.mOriginalDelegate
            boolean r0 = r0.performAccessibilityAction(r6, r7, r8)
        L_0x004f:
            if (r0 != 0) goto L_0x009e
            int r2 = androidx.core.R$id.accessibility_action_clickable_span
            if (r7 != r2) goto L_0x009e
            r7 = -1
            java.lang.String r0 = "ACCESSIBILITY_CLICKABLE_SPAN_ID"
            int r7 = r8.getInt(r0, r7)
            int r8 = androidx.core.R$id.tag_accessibility_clickable_spans
            java.lang.Object r8 = r6.getTag(r8)
            android.util.SparseArray r8 = (android.util.SparseArray) r8
            r0 = 1
            if (r8 == 0) goto L_0x009d
            java.lang.Object r7 = r8.get(r7)
            java.lang.ref.WeakReference r7 = (java.lang.ref.WeakReference) r7
            if (r7 == 0) goto L_0x009d
            java.lang.Object r7 = r7.get()
            android.text.style.ClickableSpan r7 = (android.text.style.ClickableSpan) r7
            if (r7 == 0) goto L_0x0096
            android.view.accessibility.AccessibilityNodeInfo r8 = r6.createAccessibilityNodeInfo()
            java.lang.CharSequence r8 = r8.getText()
            android.text.style.ClickableSpan[] r8 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.getClickableSpans(r8)
            r2 = 0
        L_0x0084:
            if (r8 == 0) goto L_0x0096
            int r3 = r8.length
            if (r2 >= r3) goto L_0x0096
            r3 = r8[r2]
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0093
            r8 = 1
            goto L_0x0097
        L_0x0093:
            int r2 = r2 + 1
            goto L_0x0084
        L_0x0096:
            r8 = 0
        L_0x0097:
            if (r8 == 0) goto L_0x009d
            r7.onClick(r6)
            r1 = 1
        L_0x009d:
            r0 = r1
        L_0x009e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.AccessibilityDelegateCompat.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public AccessibilityDelegateCompat(AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
