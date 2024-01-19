package com.twitter.sdk.android.tweetui.internal;

import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import sfs2x.client.entities.invitation.InvitationReply;

public class SpanClickHandler {
    public HighlightedClickableSpan highlightedClickableSpan;
    public Layout layout = null;
    public float left;
    public float top;
    public final View view;

    public SpanClickHandler(View view2, Layout layout2) {
        this.view = view2;
    }

    public static boolean lambda$enableClicksOnSpans$0(SpanClickHandler spanClickHandler, View view2, MotionEvent motionEvent) {
        TextView textView = (TextView) view2;
        Layout layout2 = textView.getLayout();
        if (layout2 == null) {
            return false;
        }
        spanClickHandler.layout = layout2;
        spanClickHandler.left = (float) (textView.getScrollX() + textView.getTotalPaddingLeft());
        spanClickHandler.top = (float) (textView.getScrollY() + textView.getTotalPaddingTop());
        CharSequence text = spanClickHandler.layout.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return false;
        }
        int action = motionEvent.getAction() & InvitationReply.EXPIRED;
        int x = (int) (motionEvent.getX() - spanClickHandler.left);
        int y = (int) (motionEvent.getY() - spanClickHandler.top);
        if (x < 0 || x >= spanClickHandler.layout.getWidth() || y < 0 || y >= spanClickHandler.layout.getHeight()) {
            spanClickHandler.deselectSpan();
            return false;
        }
        int lineForVertical = spanClickHandler.layout.getLineForVertical(y);
        float f2 = (float) x;
        if (f2 < spanClickHandler.layout.getLineLeft(lineForVertical) || f2 > spanClickHandler.layout.getLineRight(lineForVertical)) {
            spanClickHandler.deselectSpan();
            return false;
        }
        if (action == 0) {
            int offsetForHorizontal = spanClickHandler.layout.getOffsetForHorizontal(lineForVertical, f2);
            HighlightedClickableSpan[] highlightedClickableSpanArr = (HighlightedClickableSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, HighlightedClickableSpan.class);
            if (highlightedClickableSpanArr.length <= 0) {
                return false;
            }
            HighlightedClickableSpan highlightedClickableSpan2 = highlightedClickableSpanArr[0];
            highlightedClickableSpan2.select(true);
            spanClickHandler.highlightedClickableSpan = highlightedClickableSpan2;
            spanClickHandler.invalidate();
        } else if (action != 1) {
            return false;
        } else {
            HighlightedClickableSpan highlightedClickableSpan3 = spanClickHandler.highlightedClickableSpan;
            if (highlightedClickableSpan3 == null) {
                return false;
            }
            highlightedClickableSpan3.onClick(spanClickHandler.view);
            spanClickHandler.deselectSpan();
        }
        return true;
    }

    public final void deselectSpan() {
        HighlightedClickableSpan highlightedClickableSpan2 = this.highlightedClickableSpan;
        if (highlightedClickableSpan2 != null && highlightedClickableSpan2.isSelected()) {
            highlightedClickableSpan2.select(false);
            this.highlightedClickableSpan = null;
            invalidate();
        }
    }

    public final void invalidate() {
        View view2 = this.view;
        float f2 = this.left;
        view2.invalidate((int) f2, (int) this.top, this.layout.getWidth() + ((int) f2), this.layout.getHeight() + ((int) this.top));
    }
}
