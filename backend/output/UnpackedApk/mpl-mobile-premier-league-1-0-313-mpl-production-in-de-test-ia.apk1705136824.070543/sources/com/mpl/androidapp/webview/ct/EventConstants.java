package com.mpl.androidapp.webview.ct;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants;", "", "()V", "GameConnectionLost", "WebFlowGeneralEventName", "WebGameEndToEndFlow", "WebViewSessionApiInitiation", "WebViewSessionApiStatus", "WebViewTransition", "ZltGameLoading", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EventConstants.kt */
public final class EventConstants {
    public static final EventConstants INSTANCE = new EventConstants();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants$GameConnectionLost;", "", "()V", "EVENT_NAME", "", "PROPERTY_BATTLE_ID", "PROPERTY_GAME_ID", "PROPERTY_GAME_NAME", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventConstants.kt */
    public static final class GameConnectionLost {
        public static final String EVENT_NAME = "USER_CONNECTION_LOST";
        public static final GameConnectionLost INSTANCE = new GameConnectionLost();
        public static final String PROPERTY_BATTLE_ID = "BattleId";
        public static final String PROPERTY_GAME_ID = "gameId";
        public static final String PROPERTY_GAME_NAME = "Game name";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants$WebFlowGeneralEventName;", "", "()V", "EVENT_NAME", "", "PROPERTY_GAME_ID", "PROPERTY_IS_GAME_CALLBACK", "PROPERTY_IS_IT_EXCEPTION", "PROPERTY_LOG_MESSAGE", "PROPERTY_PLATFORM", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventConstants.kt */
    public static final class WebFlowGeneralEventName {
        public static final String EVENT_NAME = "Web Flow Games";
        public static final WebFlowGeneralEventName INSTANCE = new WebFlowGeneralEventName();
        public static final String PROPERTY_GAME_ID = "Game ID";
        public static final String PROPERTY_IS_GAME_CALLBACK = "Is callback from game";
        public static final String PROPERTY_IS_IT_EXCEPTION = "Is it an exception";
        public static final String PROPERTY_LOG_MESSAGE = "Log message";
        public static final String PROPERTY_PLATFORM = "platform";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants$WebGameEndToEndFlow;", "", "()V", "EVENT_NAME", "", "PROPERTY_ASSET_ALREADY_DOWNLOADED", "PROPERTY_ASSET_DOWNLOAD_FAILURE", "PROPERTY_ASSET_DOWNLOAD_INITIATED", "PROPERTY_ASSET_DOWNLOAD_SUCCESSFUL", "PROPERTY_ERROR_MESSAGE", "PROPERTY_GAME_API_FAILURE", "PROPERTY_GAME_API_INITIATED", "PROPERTY_GAME_API_SUCCESSFUL", "PROPERTY_GAME_ID", "PROPERTY_GAME_TILE_CLICKED", "PROPERTY_PLATFORM", "PROPERTY_WEB_GAME_LOADER_STARTED", "PROPERTY_WEB_GAME_LOAD_INITIATED", "PROPERTY_WEB_GAME_LOAD_SUCCESSFUL", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventConstants.kt */
    public static final class WebGameEndToEndFlow {
        public static final String EVENT_NAME = "Web Game End To End Flow";
        public static final WebGameEndToEndFlow INSTANCE = new WebGameEndToEndFlow();
        public static final String PROPERTY_ASSET_ALREADY_DOWNLOADED = "asset already downloaded";
        public static final String PROPERTY_ASSET_DOWNLOAD_FAILURE = "asset download failure";
        public static final String PROPERTY_ASSET_DOWNLOAD_INITIATED = "asset download initiated";
        public static final String PROPERTY_ASSET_DOWNLOAD_SUCCESSFUL = "asset download successful";
        public static final String PROPERTY_ERROR_MESSAGE = "error message";
        public static final String PROPERTY_GAME_API_FAILURE = "game api failure";
        public static final String PROPERTY_GAME_API_INITIATED = "game api initiated";
        public static final String PROPERTY_GAME_API_SUCCESSFUL = "game api successful";
        public static final String PROPERTY_GAME_ID = "gameId";
        public static final String PROPERTY_GAME_TILE_CLICKED = "game tile clicked";
        public static final String PROPERTY_PLATFORM = "platform";
        public static final String PROPERTY_WEB_GAME_LOADER_STARTED = "web game loader started";
        public static final String PROPERTY_WEB_GAME_LOAD_INITIATED = "web game load initiated";
        public static final String PROPERTY_WEB_GAME_LOAD_SUCCESSFUL = "web game load successful";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants$WebViewSessionApiInitiation;", "", "()V", "EVENT_NAME", "", "PROPERTY_GAME_ID", "PROPERTY_PLATFORM", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventConstants.kt */
    public static final class WebViewSessionApiInitiation {
        public static final String EVENT_NAME = "Web View Session Initiated";
        public static final WebViewSessionApiInitiation INSTANCE = new WebViewSessionApiInitiation();
        public static final String PROPERTY_GAME_ID = "Game Id";
        public static final String PROPERTY_PLATFORM = "Platform";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants$WebViewSessionApiStatus;", "", "()V", "EVENT_NAME", "", "PROPERTY_FAILURE_MESSAGE", "PROPERTY_GAME_ID", "PROPERTY_IS_SUCCESS", "PROPERTY_PLATFORM", "PROPERTY_SESSION_URL_VALID", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventConstants.kt */
    public static final class WebViewSessionApiStatus {
        public static final String EVENT_NAME = "Web View Session Status";
        public static final WebViewSessionApiStatus INSTANCE = new WebViewSessionApiStatus();
        public static final String PROPERTY_FAILURE_MESSAGE = "failure message";
        public static final String PROPERTY_GAME_ID = "Game Id";
        public static final String PROPERTY_IS_SUCCESS = "Is success";
        public static final String PROPERTY_PLATFORM = "Platform";
        public static final String PROPERTY_SESSION_URL_VALID = "isSessionUrlValid";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants$WebViewTransition;", "", "()V", "EVENT_NAME", "", "PROPERTY_GAME_ID", "PROPERTY_PLATFORM", "PROPERTY_SESSION_API_DURATION", "PROPERTY_TILE_CLICK_DURATION", "PROPERTY_WEB_LOAD_DURATION", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventConstants.kt */
    public static final class WebViewTransition {
        public static final String EVENT_NAME = "Web View Transition";
        public static final WebViewTransition INSTANCE = new WebViewTransition();
        public static final String PROPERTY_GAME_ID = "Game Id";
        public static final String PROPERTY_PLATFORM = "Platform";
        public static final String PROPERTY_SESSION_API_DURATION = "Session api duration";
        public static final String PROPERTY_TILE_CLICK_DURATION = "Tile click duration";
        public static final String PROPERTY_WEB_LOAD_DURATION = "Web load duration";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mpl/androidapp/webview/ct/EventConstants$ZltGameLoading;", "", "()V", "EVENT_NAME", "", "PROPERTY_GAME_ID", "PROPERTY_GAME_NAME", "PROPERTY_PLATFORM", "PROPERTY_TIME_TAKEN", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EventConstants.kt */
    public static final class ZltGameLoading {
        public static final String EVENT_NAME = "ZLT Game Loading";
        public static final ZltGameLoading INSTANCE = new ZltGameLoading();
        public static final String PROPERTY_GAME_ID = "Game Id";
        public static final String PROPERTY_GAME_NAME = "Game Name";
        public static final String PROPERTY_PLATFORM = "Platform";
        public static final String PROPERTY_TIME_TAKEN = "Time Taken";
    }
}
