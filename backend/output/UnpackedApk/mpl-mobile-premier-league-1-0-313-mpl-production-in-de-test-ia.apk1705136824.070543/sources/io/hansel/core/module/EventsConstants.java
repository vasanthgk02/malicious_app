package io.hansel.core.module;

public enum EventsConstants {
    APPLICATION_DID_MOVE_TO_FOREGROUND,
    APPLICATION_DID_MOVE_TO_BACKGROUND,
    ACTIVITY_NEW_ADDED,
    ACTIVITY_OLD_ADDED,
    ACTIVITY_PAUSED,
    ACTIVITY_RESUMED,
    ACTIVITY_ROTATED,
    HANDLE_ON_BACK_PRESSED,
    ON_SET_SCREEN,
    ON_UNSET_SCREEN,
    PUSH_DATA,
    HANDLE_PUSH_DATA,
    HANSEL_PUSH_DATA,
    SET_CODE_CONFIG,
    REGISTER_CONFIG_SOURCE,
    HANDLE_DEEP_CONFIGS,
    DEVICE_IN_TESTGROUP,
    CLEAR_TTL,
    PRE_INIT_SDK_API,
    PRE_INIT_SDK_API_CODE_MODULE,
    INIT_LIBRARIES,
    CODE_PATCH_NEW_PRIMARY,
    VISUALISER_PATCH_NEW_PRIMARY,
    REAPPLY_VISUALIZER_CHANGES,
    GET_EXPERIENCE_LIST,
    SET_EXPERIENCE_LIST,
    SET_RESPONSE_FROM_SERVER_SDK,
    SET_REQUEST_EXTRAS_FOR_SERVER_SDK,
    GET_REQUEST_EXTRAS_FOR_SERVER_SDK,
    SAVE_VENDOR_LIMITS,
    FIRE_BRANCH_TRACKER_EVENT,
    FIRE_PROMPT_EVENT,
    FIRE_PROMPT_SHOW_EVENT,
    FIRE_PROMPT_ACTION,
    AEP_GET_DATA,
    AEP_ADD_EVENTS,
    AEP_TRACK_EVENTS,
    AEP_LOCALIZATION,
    AEP_DIL,
    AEP_TG_AUTHENTICATE,
    USER_ID_CHANGED,
    CRITERIA_FILTER_RESET,
    DIL_SEG_CHANGED,
    FILTER_CHANGED,
    FILTERS_CLEARED,
    SDK_VERSION_UPDATED,
    RE_EVALUATE_JOURNEYS,
    GET_JOURNEY_LIST,
    SET_JOURNEY_LIST,
    REGISTER_TRACKER_SOURCE,
    HANSEL_DATA_STORE_EVENT_APP_START,
    HANSEL_DATA_STORE_EVENT_INIT_MESSAGE,
    REGISTER_IPA_SOURCE,
    GET_DATA_JOURNS,
    JOURNS_FINISH,
    INSERT_IPA,
    DISMISS_PROMPT,
    EVALUATE_EVENT,
    DISPLAY_PROMPTS,
    GET_TOP_ACTIVITY,
    GET_CURRENT_SCREEN_NAME,
    GET_EID_VIEW,
    ANCHOR_POINT_VISIBLE,
    CONFIGS_SYNCED,
    IMAGE_DOWNLOADED,
    DEBUG_CONFIG,
    REGISTER_GET_DATA_STATUS_LISTENER,
    GET_DATA_EVAL_STARTED,
    GET_DATA_EVAL_FINISHED,
    GET_CONFIG_VALUE_FOR_CONFIG_NAME,
    GET_DATA_FLAGS_DATA,
    FIRE_PENDING_NUDGE_EVENTS,
    LOG_EVENT_INTERNAL,
    FIRE_APP_LOAD_EVENT,
    SAVE_BRANCH_TRACKER_TTL,
    GET_DEFAULT_BRANCH_TRACKER_TTL,
    GET_PROMPT_SHOW_EVENT_MAP,
    GET_PROMPT_DISMISS_EVENT_MAP
}