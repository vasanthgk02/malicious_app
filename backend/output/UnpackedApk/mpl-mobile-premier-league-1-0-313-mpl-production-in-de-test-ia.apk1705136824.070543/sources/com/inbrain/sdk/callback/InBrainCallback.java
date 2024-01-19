package com.inbrain.sdk.callback;

import com.inbrain.sdk.model.Reward;
import java.util.List;

public interface InBrainCallback {
    boolean didReceiveInBrainRewards(List<Reward> list);

    void surveysClosed();

    void surveysClosedFromPage();
}
