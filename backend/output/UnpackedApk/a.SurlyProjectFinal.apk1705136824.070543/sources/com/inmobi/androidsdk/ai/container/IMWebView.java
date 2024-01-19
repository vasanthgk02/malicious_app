package com.inmobi.androidsdk.ai.container;

import a.SurlyProjectFinal.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.androidsdk.ai.controller.JSAssetController;
import com.inmobi.androidsdk.ai.controller.JSController.Dimensions;
import com.inmobi.androidsdk.ai.controller.JSController.ExpandProperties;
import com.inmobi.androidsdk.ai.controller.JSController.PlayerProperties;
import com.inmobi.androidsdk.ai.controller.JSUtilityController;
import com.inmobi.androidsdk.ai.controller.util.AVPlayer;
import com.inmobi.androidsdk.ai.controller.util.AVPlayerListener;
import com.inmobi.androidsdk.impl.AdUnit;
import com.inmobi.androidsdk.impl.AdUnit.AdActionNames;
import com.inmobi.androidsdk.impl.Constants;
import com.inmobi.androidsdk.impl.Constants.playerState;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.jar.JarFile;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class IMWebView extends WebView implements Serializable {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$inmobi$androidsdk$impl$Constants$playerState = null;
    private static final String AD_PATH = "AD_PATH";
    private static final String AUDIO_PLAYER_REF = "aplayerref";
    private static final String AUDIO_VOLUME = "vol";
    private static final int BACKGROUND_ID = 435;
    private static final String CURRENT_FILE = "_mraid_current";
    public static final String DIMENSIONS = "expand_dimensions";
    private static final String ERROR_ACTION = "action";
    private static final String ERROR_MESSAGE = "message";
    private static final String ERR_AUDIO_STATE = "Cannot play audio.Ad is not in an expanded state";
    private static final String ERR_HIDDEN_PLAYER_LIMIT = "Player Error. Exceeding permissible limit for saved play instances";
    private static final String ERR_INVALID_PID = "Invalid property ID";
    private static final String ERR_INVALID_STATE = "Invalid player state";
    private static final String ERR_INVALID_URL = "Request must specify a valid URL";
    private static final String ERR_SHOW_FAILED = "Show failed. There is already a video playing";
    private static final String ERR_VIDEO_STATE = "Cannot play video.Ad is not in an expanded state";
    private static final int ERR_VOLUME = -1;
    public static final String EXPAND_PROPERTIES = "expand_properties";
    public static final String EXPAND_URL = "expand_url";
    private static final int HIDDEN_PLAYER_LIMIT = 5;
    protected static final int IMWEBVIEW_INTERSTITIAL_ID = 117;
    protected static final int INT_BACKGROUND_ID = 224;
    protected static final int INT_CLOSE_BUTTON = 225;
    private static final int INVALID_DIMENSION = -99999;
    private static final int MESSAGE_AUDIO_VIDEO_COMPLETED = 1010;
    private static final int MESSAGE_CLOSE = 1001;
    private static final int MESSAGE_CLOSE_BUTTON_INTERSTITIAL = 1011;
    private static final int MESSAGE_CLOSE_VIDEO = 1014;
    private static final int MESSAGE_EXPAND = 1004;
    private static final int MESSAGE_HIDE = 1002;
    private static final int MESSAGE_HIDE_PLAYERS = 1026;
    private static final int MESSAGE_HIDE_VIDEO = 1015;
    private static final int MESSAGE_IMBROWSERACTIVITY_DISMISS_SCREEN = 1025;
    private static final int MESSAGE_MUTE_AUDIO = 1021;
    private static final int MESSAGE_MUTE_VIDEO = 1017;
    private static final int MESSAGE_OPEN = 1006;
    private static final int MESSAGE_OPEN_URL = 1027;
    private static final int MESSAGE_PAUSE_AUDIO = 1012;
    private static final int MESSAGE_PAUSE_VIDEO = 1013;
    private static final int MESSAGE_PLAY_AUDIO = 1008;
    private static final int MESSAGE_PLAY_VIDEO = 1007;
    private static final int MESSAGE_RAISE_ERROR = 1009;
    private static final int MESSAGE_SEEK_AUDIO = 1024;
    private static final int MESSAGE_SEEK_VIDEO = 1020;
    private static final int MESSAGE_SEND_EXPAND_CLOSE = 1005;
    private static final int MESSAGE_SET_AUDIOVOLUME = 1023;
    private static final int MESSAGE_SET_VIDEOVOLUME = 1019;
    private static final int MESSAGE_SHOW = 1003;
    private static final int MESSAGE_SHOW_VIDEO = 1016;
    private static final int MESSAGE_UNMUTE_AUDIO = 1022;
    private static final int MESSAGE_UNMUTE_VIDEO = 1018;
    private static final String MRAID = "(function(){var c=window.mraid={};c.STATES={LOADING:\"loading\",DEFAULT:\"default\",RESIZED:\"resized\",EXPANDED:\"expanded\",HIDDEN:\"hidden\"};var d=c.EVENTS={READY:\"ready\",ERROR:\"error\",STATECHANGE:\"stateChange\",VIEWABLECHANGE:\"viewableChange\",ORIENTATIONCHANGE:\"orientationChange\"},i={width:0,height:0},g={width:0,height:0},f={},h={width:0,height:0,useCustomClose:!1,isModal:!0,lockOrientation:!1,orientation:\"\"},l=function(a){this.event=a;this.count=0;var b={};this.add=function(a){var c=\"\"+a;b[c]||(b[c]=a,this.count++)};this.remove=function(a){a=\"\"+a;return b[a]?(b[a]=null,delete b[a],this.count--,!0):!1};this.removeAll=function(){for(var a in b)this.remove(b[a])};this.broadcast=function(a){for(var c in b)b[c].apply({},a)};this.toString=function(){var c=[a,\":\"],d;for(d in b)c.push(\"|\",d,\"|\");return c.join(\"\")}};mraidview.addEventListener(d.READY,function(){e(d.READY)});mraidview.addEventListener(d.STATECHANGE,function(a){e(d.STATECHANGE,a)});mraidview.addEventListener(d.VIEWABLECHANGE,function(a){e(d.VIEWABLECHANGE,a)});mraidview.addEventListener(\"error\",function(a,b){e(d.ERROR,a,b)});mraidview.addEventListener(d.ORIENTATIONCHANGE,function(a){e(d.ORIENTATIONCHANGE,a)});var k=function(a){var b=function(){};b.prototype=a;return new b},e=function(){for(var a=Array(arguments.length),b=0;b<arguments.length;b++)a[b]=arguments[b];b=a.shift();try{f[b]&&f[b].broadcast(a)}catch(c){}},j=function(a){for(var b=0,c=a.length-1;b<a.length&&\" \"==a[b];)b++;for(;c>b&&\" \"==a[c];)c-=1;return a.substring(b,c+1)};c.addEventListener=function(a,b){try{!a||!b?e(d.ERROR,\"Both event and listener are required.\",\"addEventListener\"):d.ERROR==a||d.READY==a||d.STATECHANGE==a||d.VIEWABLECHANGE==a||d.ORIENTATIONCHANGE==a?(f[a]||(f[a]=new l(a)),f[a].add(b)):mraidview.addEventListener(a,b)}catch(c){mraidview.log(c)}};c.useCustomClose=function(a){h.useCustomClose=a;mraidview.useCustomClose(a)};c.close=function(){mraidview.close()};c.getExpandProperties=function(){return h};c.setExpandProperties=function(a){h=a;h.isModal=!0;mraidview.setExpandProperties(h)};c.expand=function(a){mraidview.expand(a)};c.getMaxSize=function(){return k(g)};c.getSize=function(){return k(i)};c.getState=function(){return mraidview.getState()};c.getOrientation=function(){return mraidview.getOrientation()};c.isViewable=function(){return mraidview.isViewable()};c.open=function(a){a?mraidview.open(a):e(d.ERROR,\"URL is required.\",\"open\")};c.removeEventListener=function(a,b){try{if(a){if(b)if(f[a])f[a].remove(b);else{mraidview.removeEventListener(a,b);return}else f[a]&&f[a].removeAll();f[a]&&0==f[a].count&&(f[a]=null,delete f[a])}else e(d.ERROR,\"Must specify an event.\",\"removeEventListener\")}catch(c){mraidview.log(\"removeEventListener\"+c)}};c.resize=function(a,b){null==a||null==b||isNaN(a)||isNaN(b)||0>a||0>b?e(d.ERROR,\"Requested size must be numeric values between 0 and maxSize.\",\"resize\"):a>g.width||b>g.height?e(d.ERROR,\"Request (\"+a+\" x \"+b+\") exceeds maximum allowable size of (\"+g.width+\" x \"+g.height+\")\",\"resize\"):a==i.width&&b==i.height?e(d.ERROR,\"Requested size equals current size.\",\"resize\"):mraidview.resize(a,b)};c.log=function(a){a?mraidview.log(a):e(d.ERROR,\"message is required.\",\"log\")};c.getVersion=function(){return\"1.0\"};c.getInMobiAIVersion=function(){return 1.1};c.getPlacementType=function(){return mraidview.getPlacementType()};c.asyncPing=function(a){a?mraidview.asyncPing(a):e(d.ERROR,\"URL is required.\",\"asyncPing\")};c.makeCall=function(a){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must provide a number to call.\",\"makeCall\"):mraidview.makeCall(a)};c.sendMail=function(a,b,c){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must specify a recipient.\",\"sendMail\"):mraidview.sendMail(a,b,c)};c.sendSMS=function(a,b){!a||\"string\"!=typeof a||0==j(a).length?e(d.ERROR,\"Request must specify a recipient.\",\"sendSMS\"):mraidview.sendSMS(a,b)};c.playAudio=function(a,b){\"undefined\"==typeof b||null==b?\"string\"==typeof a?mraidview.playAudio(a,null):\"object\"==typeof a?mraidview.playAudio(null,a):mraidview.playAudio(null,null):mraidview.playAudio(a,b)};c.playVideo=function(a,b){\"undefined\"==typeof b||null==b?\"string\"==typeof a?mraidview.playVideo(a,null):\"object\"==typeof a?mraidview.playVideo(null,a):mraidview.playVideo(null,null):mraidview.playVideo(a,b)};c.pauseAudio=function(a){mraidview.pauseAudio(a)};c.muteAudio=function(a){mraidview.muteAudio(a)};c.unMuteAudio=function(a){mraidview.unMuteAudio(a)};c.isAudioMuted=function(a){return mraidview.isAudioMuted(a)};c.setAudioVolume=function(a){var b=a.volume;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid volume\",\"setAudioVolume\"):0>b||100<b?e(d.ERROR,\"Request must specify a valid volume value in the range 0..100\",\"setAudioVolume\"):mraidview.setAudioVolume(a,b)};c.getAudioVolume=function(a){return mraidview.getAudioVolume(a)};c.pauseVideo=function(a){mraidview.pauseVideo(a)};c.closeVideo=function(a){mraidview.closeVideo(a)};c.hideVideo=function(a){mraidview.hideVideo(a)};c.showVideo=function(a){mraidview.showVideo(a)};c.muteVideo=function(a){mraidview.muteVideo(a)};c.unMuteVideo=function(a){mraidview.unMuteVideo(a)};c.isVideoMuted=function(a){return mraidview.isVideoMuted(a)};c.setVideoVolume=function(a){var b=a.volume;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid volume\",\"setVideoVolume\"):0>b||100<b?e(d.ERROR,\"Request must specify a valid volume value in the range 0..100\",\"setVideoVolume\"):mraidview.setVideoVolume(a,b)};c.getVideoVolume=function(a){return mraidview.getVideoVolume(a)};c.seekAudio=function(a){var b=a.time;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid time\",\"seekAudio\"):0!=b?e(d.ERROR,\"Cannot seek audio other than 0\",\"seekAudio\"):mraidview.seekAudio(a,b)};c.seekVideo=function(a){var b=a.time;\"undefined\"==typeof b||null==b?e(d.ERROR,\"Request must specify a valid time\",\"seekVideo\"):0!=b?e(d.ERROR,\"Cannot seek video other than 0\",\"seekVideo\"):mraidview.seekVideo(a,b)}})();";
    private static final String MRAID_BRIDGE = "(function(){var c=window.mraidview={},f={},g=[],j=!1;c.fireReadyEvent=function(){var b=f.ready;if(null!=b)for(var a=0;a<b.length;a++)b[a]();return\"OK\"};c.fireStateChangeEvent=function(b){var a=f.stateChange;if(null!=a)for(var d=0;d<a.length;d++)a[d](b);return\"OK\"};c.fireViewableChangeEvent=function(b){var a=f.viewableChange;if(null!=a)for(var d=0;d<a.length;d++)a[d](b);return\"OK\"};c.fireErrorEvent=function(b,a){var d=f.error;if(null!=d)for(var c=0;c<d.length;c++)d[c](b,a);return\"OK\"};c.fireOrientationChangeEvent=function(b){var a=f.orientationChange;if(null!=a)for(var c=0;c<a.length;c++)a[c](b);return\"OK\"};c.fireMediaTrackingEvent=function(b,a){var c={};c.name=b;var e=\"inmobi_media_\"+b;\"undefined\"!=typeof a&&null!=a&&\"\"!=a&&(e=e+\"_\"+a);e=f[e];if(null!=e)for(var h=0;h<e.length;h++)e[h](c);return\"OK\"};c.fireMediaErrorEvent=function(b,a){var c={name:\"error\"};c.code=a;var e=\"inmobi_media_\"+c.name;\"undefined\"!=typeof b&&null!=b&&\"\"!=b&&(e=e+\"_\"+b);e=f[e];if(null!=e)for(var h=0;h<e.length;h++)e[h](c);return\"OK\"};c.fireMediaTimeUpdateEvent=function(b,a,c){var e={name:\"timeupdate\",target:{}};e.target.currentTime=a;e.target.duration=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&null!=b&&\"\"!=b&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.fireMediaCloseEvent=function(b,a,c){var e={name:\"close\"};e.viaUserInteraction=a;e.target={};e.target.currentTime=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&null!=b&&\"\"!=b&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.fireMediaVolumeChangeEvent=function(b,a,c){var e={name:\"volumechange\",target:{}};e.target.volume=a;e.target.muted=c;a=\"inmobi_media_\"+e.name;\"undefined\"!=typeof b&&null!=b&&\"\"!=b&&(a=a+\"_\"+b);b=f[a];if(null!=b)for(a=0;a<b.length;a++)b[a](e);return\"OK\"};c.showAlert=function(b){utilityController.showAlert(b)};c.zeroPad=function(b){var a=\"\";10>b&&(a+=\"0\");return a+b};c.addEventListener=function(b,a){var c=f[b];null==c&&(f[b]=[],c=f[b]);for(var e in c)if(a==e)return;c.push(a)};c.removeEventListener=function(b){try{var a=f[b];null!=a&&delete a}catch(d){c.log(d)}};c.useCustomClose=function(b){try{displayController.useCustomClose(b)}catch(a){c.showAlert(\"use CustomClose: \"+a)}};c.close=function(){try{displayController.close()}catch(b){c.showAlert(\"close: \"+b)}};c.stackCommands=function(b,a){j?g.push(b):(eval(b),a&&(j=!0))};c.executeStack=function(){for(j=!1;0<g.length;){var b=g.shift();eval(b)}};c.emptyStack=function(){for(;0<g.length;)g.shift()};c.expand=function(b){try{displayController.expand(b)}catch(a){c.showAlert(\"executeNativeExpand: \"+a+\", URL = \"+b)}};c.setExpandProperties=function(b){try{b?this.props=b:b=null,displayController.setExpandProperties(c.stringify(b))}catch(a){c.showAlert(\"executeNativesetExpandProperties: \"+a+\", props = \"+b)}};c.open=function(b){try{displayController.open(b)}catch(a){c.showAlert(\"open: \"+a)}};c.resize=function(b,a){try{displayController.resize(b,a)}catch(d){c.showAlert(\"resize: \"+d)}};c.getState=function(){try{return\"\"+displayController.getState()}catch(b){c.showAlert(\"getState: \"+b)}};c.getOrientation=function(){try{return\"\"+displayController.getOrientation()}catch(b){c.showAlert(\"getOrientation: \"+b)}};c.isViewable=function(){try{return displayController.isViewable()}catch(b){c.showAlert(\"isViewable: \"+b)}};c.log=function(b){try{utilityController.log(b)}catch(a){c.showAlert(\"log: \"+a)}};c.getPlacementType=function(){return displayController.getPlacementType()};c.asyncPing=function(b){try{utilityController.asyncPing(b)}catch(a){c.showAlert(\"asyncPing: \"+a)}};c.close=function(){try{displayController.close()}catch(b){c.showAlert(\"close: \"+b)}};c.makeCall=function(b){try{utilityController.makeCall(b)}catch(a){c.showAlert(\"makeCall: \"+a)}};c.sendMail=function(b,a,d){try{utilityController.sendMail(b,a,d)}catch(e){c.showAlert(\"sendMail: \"+e)}};c.sendSMS=function(b,a){try{utilityController.sendSMS(b,a)}catch(d){c.showAlert(\"sendSMS: \"+d)}};c.pauseAudio=function(b){try{var a=getPID(b);utilityController.pauseAudio(a)}catch(d){c.showAlert(\"pauseAudio: \"+d)}};c.muteAudio=function(b){try{var a=getPID(b);utilityController.muteAudio(a)}catch(d){c.showAlert(\"muteAudio: \"+d)}};c.unMuteAudio=function(b){try{var a=getPID(b);utilityController.unMuteAudio(a)}catch(d){c.showAlert(\"unMuteAudio: \"+d)}};c.isAudioMuted=function(b){try{var a=getPID(b);return utilityController.isAudioMuted(a)}catch(d){c.showAlert(\"isAudioMuted: \"+d)}};c.setAudioVolume=function(b,a){try{var d=getPID(b);utilityController.setAudioVolume(d,a)}catch(e){c.showAlert(\"setAudioVolume: \"+e)}};c.getAudioVolume=function(b){try{var a=getPID(b);return utilityController.getAudioVolume(a)}catch(d){c.showAlert(\"getAudioVolume: \"+d)}};c.seekAudio=function(b,a){try{var d=getPID(b);utilityController.seekAudio(d,a)}catch(e){c.showAlert(\"seekAudio: \"+e)}};c.playAudio=function(b,a){var d=!0,e=!1,h=\"normal\",f=\"normal\",g=!0,k=\"\",l=getPID(a);null!=b&&(k=b);null!=a&&(\"undefined\"!=typeof a.autoplay&&!1===a.autoplay&&(d=!1),\"undefined\"!=typeof a.loop&&!0===a.loop&&(e=!0),\"undefined\"!=typeof a.startStyle&&null!=a.startStyle&&(h=a.startStyle),\"undefined\"!=typeof a.stopStyle&&null!=a.stopStyle&&(f=a.stopStyle),\"fullscreen\"==h&&(g=!0));try{utilityController.playAudio(k,d,g,e,h,f,l)}catch(m){c.showAlert(\"playAudio: \"+m)}};c.pauseVideo=function(b){try{var a=getPID(b);utilityController.pauseVideo(a)}catch(d){c.showAlert(\"pauseVideo: \"+d)}};c.closeVideo=function(b){try{var a=getPID(b);utilityController.closeVideo(a)}catch(d){c.showAlert(\"closeVideo: \"+d)}};c.hideVideo=function(b){try{var a=getPID(b);utilityController.hideVideo(a)}catch(d){c.showAlert(\"hideVideo: \"+d)}};c.showVideo=function(b){try{var a=getPID(b);utilityController.showVideo(a)}catch(d){c.showAlert(\"showVideo: \"+d)}};c.muteVideo=function(b){try{var a=getPID(b);utilityController.muteVideo(a)}catch(d){c.showAlert(\"muteVideo: \"+d)}};c.unMuteVideo=function(b){try{var a=getPID(b);utilityController.unMuteVideo(a)}catch(d){c.showAlert(\"unMuteVideo: \"+d)}};c.seekVideo=function(b,a){try{var d=getPID(b);utilityController.seekVideo(d,a)}catch(e){c.showAlert(\"seekVideo: \"+e)}};c.isVideoMuted=function(b){try{var a=getPID(b);return utilityController.isVideoMuted(a)}catch(d){c.showAlert(\"isVideoMuted: \"+d)}};c.setVideoVolume=function(b,a){try{var d=getPID(b);utilityController.setVideoVolume(d,a)}catch(e){c.showAlert(\"setVideoVolume: \"+e)}};c.getVideoVolume=function(b){try{var a=getPID(b);return utilityController.getVideoVolume(a)}catch(d){c.showAlert(\"getVideoVolume: \"+d)}};c.playVideo=function(b,a){var d=!1,e=!0,f=!0,g=!1,j=-99999,k=-99999,l=-99999,m=-99999,n=\"normal\",o=\"exit\",p=\"\",q=getPID(a);null!=b&&(p=b);if(null!=a){\"undefined\"!=typeof a.audio&&\"muted\"==a.audio&&(d=!0);\"undefined\"!=typeof a.autoplay&&!1===a.autoplay&&(e=!1);\"undefined\"!=typeof a.controls&&!1===a.controls&&(f=!1);\"undefined\"!=typeof a.loop&&!0===a.loop&&(g=!0);if(\"undefined\"!=typeof a.inline&&null!=a.inline&&(j=a.inline.left,k=a.inline.top,\"undefined\"!=typeof a.width&&null!=a.width&&(l=a.width),\"undefined\"!=typeof a.height&&null!=a.height))m=a.height;\"undefined\"!=typeof a.startStyle&&null!=a.startStyle&&(n=a.startStyle);\"undefined\"!=typeof a.stopStyle&&null!=a.stopStyle&&(o=a.stopStyle);\"fullscreen\"==n&&(f=!0)}try{utilityController.playVideo(p,d,e,f,g,j,k,l,m,n,o,q)}catch(r){c.showAlert(\"playVideo: \"+r)}};c.stringify=function(b){if(\"undefined\"===typeof JSON){var a=\"\",d;if(\"undefined\"==typeof b.length)return c.stringifyArg(b);for(d=0;d<b.length;d++)0<d&&(a+=\",\"),a+=c.stringifyArg(b[d]);return a+\"]\"}return JSON.stringify(b)};c.stringifyArg=function(b){var a,d,e;d=typeof b;a=\"\";if(\"number\"===d||\"boolean\"===d)a+=args;else if(b instanceof Array)a=a+\"[\"+b+\"]\";else if(b instanceof Object){d=!0;a+=\"{\";for(e in b)null!==b[e]&&(d||(a+=\",\"),a=a+'\"'+e+'\":',d=typeof b[e],a=\"number\"===d||\"boolean\"===d?a+b[e]:\"function\"===typeof b[e]?a+'\"\"':b[e]instanceof Object?a+this.stringify(args[i][e]):a+'\"'+b[e]+'\"',d=!1);a+=\"}\"}else b=b.replace(/\\\\/g,\"\\\\\\\\\"),b=b.replace(/\"/g,'\\\\\"'),a=a+'\"'+b+'\"';c.showAlert(\"json:\"+a);return a};getPID=function(b){var a=\"\";null!=b&&\"undefined\"!=typeof b.id&&null!=b.id&&(a=b.id);return a}})();";
    private static final String MRAID_SCRIPT_NAME = "mraid.js";
    protected static final int PLACEHOLDER_ID = 437;
    private static final String PLACEMENT_TYPE_INLINE = "inline";
    private static final String PLACEMENT_TYPE_INTERSTITIAL = "interstitial";
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static final String PROPERTY_ID = "pid";
    protected static final int RELATIVELAYOUT_ID = 438;
    private static final String SEEK_AUDIO = "seekaudio";
    private static final String SEEK_POSITION = "seek";
    private static final String VIDEO_VOLUME = "volume";
    private static int[] attrs = {16843039, 16843040};
    private static String mBridgeScriptPath = "http://dl.dropbox.com/u/30899852/mraid/inmobi_mraid_bridge.js";
    private static String mScriptPath = "http://dl.dropbox.com/u/30899852/mraid/inmobi_mraid.js";
    private static final long serialVersionUID = 7098506283154473782L;
    public static boolean userInitiatedClose = false;
    /* access modifiers changed from: private */
    public Hashtable<String, AVPlayer> audioPlayerList = new Hashtable<>();
    /* access modifiers changed from: private */
    public AVPlayer audioplayer;
    private boolean bGotLayoutParams;
    private boolean bPageFinished;
    private boolean customClose = false;
    /* access modifiers changed from: private */
    public ExpandProperties expandProperties;
    /* access modifiers changed from: private */
    public boolean isBusy = false;
    /* access modifiers changed from: private */
    public boolean isMraid = false;
    public AtomicBoolean isMutexAquired = new AtomicBoolean(false);
    public boolean isTablet = false;
    private boolean lockOrientationValueForInterstitial = false;
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public AdUnit mAdUnit;
    private float mDensity;
    /* access modifiers changed from: private */
    public Activity mExpandedActivity;
    /* access modifiers changed from: private */
    public WebViewClient mExtWebViewClient;
    private Handler mHandler = new Handler() {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$inmobi$androidsdk$ai$container$IMWebView$ViewState;

        static /* synthetic */ int[] $SWITCH_TABLE$com$inmobi$androidsdk$ai$container$IMWebView$ViewState() {
            int[] iArr = $SWITCH_TABLE$com$inmobi$androidsdk$ai$container$IMWebView$ViewState;
            if (iArr == null) {
                iArr = new int[ViewState.values().length];
                try {
                    iArr[ViewState.DEFAULT.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[ViewState.EXPANDED.ordinal()] = 4;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[ViewState.EXPANDING.ordinal()] = 5;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[ViewState.HIDDEN.ordinal()] = 6;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[ViewState.LOADING.ordinal()] = 1;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[ViewState.RESIZED.ordinal()] = 3;
                } catch (NoSuchFieldError e6) {
                }
                $SWITCH_TABLE$com$inmobi$androidsdk$ai$container$IMWebView$ViewState = iArr;
            }
            return iArr;
        }

        public void handleMessage(Message msg) {
            String errInjection;
            String errInjection2;
            String errInjection3;
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "IMWebView->handleMessag: msg:" + msg);
            }
            Bundle data = msg.getData();
            switch (msg.what) {
                case IMWebView.MESSAGE_CLOSE /*1001*/:
                    switch ($SWITCH_TABLE$com$inmobi$androidsdk$ai$container$IMWebView$ViewState()[IMWebView.this.mViewState.ordinal()]) {
                        case 2:
                            if (!IMWebView.this.mIsInterstitialAd) {
                                IMWebView.this.hide();
                                break;
                            } else {
                                IMWebView.this.resetContentsForInterstitials(IMWebView.this.mExpandedActivity);
                                break;
                            }
                        case 4:
                        case 5:
                            IMWebView.this.closeExpanded(IMWebView.this.mExpandedActivity);
                            IMWebView.this.mIsExpandUrlValid = false;
                            break;
                        case R.styleable.com_cauly_android_ad_AdView_gps /*6*/:
                            IMWebView.this.injectJavaScript("window.mraidview.fireErrorEvent(\"Current state is not expanded or default\", \"close\")");
                            break;
                    }
                case IMWebView.MESSAGE_HIDE /*1002*/:
                    IMWebView.this.setVisibility(4);
                    IMWebView.this.setState(ViewState.HIDDEN);
                    break;
                case IMWebView.MESSAGE_SHOW /*1003*/:
                    IMWebView.this.injectJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
                    IMWebView.this.setVisibility(0);
                    break;
                case IMWebView.MESSAGE_EXPAND /*1004*/:
                    if (IMWebView.this.mViewState == ViewState.EXPANDING) {
                        IMWebView.this.doExpand(data);
                        break;
                    }
                    break;
                case IMWebView.MESSAGE_SEND_EXPAND_CLOSE /*1005*/:
                    if (IMWebView.this.mListener != null) {
                        IMWebView.this.mListener.onExpandClose();
                        break;
                    }
                    break;
                case IMWebView.MESSAGE_PLAY_VIDEO /*1007*/:
                    try {
                        IMWebView.this.playVideoImpl(data, IMWebView.this.mExpandedActivity);
                        break;
                    } catch (Exception e) {
                        if (Constants.DEBUG) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    break;
                case IMWebView.MESSAGE_PLAY_AUDIO /*1008*/:
                    IMWebView.this.playAudioImpl(data, IMWebView.this.mExpandedActivity);
                    break;
                case IMWebView.MESSAGE_RAISE_ERROR /*1009*/:
                    String strMsg = data.getString(IMWebView.ERROR_MESSAGE);
                    IMWebView.this.injectJavaScript("window.mraidview.fireErrorEvent(\"" + strMsg + "\", \"" + data.getString(IMWebView.ERROR_ACTION) + "\")");
                    break;
                case IMWebView.MESSAGE_AUDIO_VIDEO_COMPLETED /*1010*/:
                    IMWebView.this.isBusy = false;
                    break;
                case IMWebView.MESSAGE_CLOSE_BUTTON_INTERSTITIAL /*1011*/:
                    IMWebView.this.switchInterstitialCloseButtonState();
                    break;
                case IMWebView.MESSAGE_PAUSE_AUDIO /*1012*/:
                    AVPlayer aplayer = (AVPlayer) IMWebView.this.audioPlayerList.get(data.getString(IMWebView.AUDIO_PLAYER_REF));
                    if (aplayer != null) {
                        aplayer.pause();
                    }
                    break;
                case IMWebView.MESSAGE_PAUSE_VIDEO /*1013*/:
                    AVPlayer player = IMWebView.this.getVideoPlayer(data.getString(IMWebView.PROPERTY_ID));
                    if (player == null) {
                        errInjection3 = "window.mraidview.fireErrorEvent(\"Invalid property ID\", \"pauseVideo\")";
                    } else if (player.getState() != playerState.PLAYING) {
                        errInjection3 = "window.mraidview.fireErrorEvent(\"Invalid player state\", \"pauseVideo\")";
                    } else {
                        player.pause();
                        return;
                    }
                    IMWebView.this.injectJavaScript(errInjection3);
                    break;
                case IMWebView.MESSAGE_CLOSE_VIDEO /*1014*/:
                    ((AVPlayer) msg.obj).releasePlayer(false);
                    break;
                case IMWebView.MESSAGE_HIDE_VIDEO /*1015*/:
                    String pid = data.getString(IMWebView.PROPERTY_ID);
                    AVPlayer player2 = IMWebView.this.getVideoPlayer(pid);
                    if (player2 == null) {
                        errInjection2 = "window.mraidview.fireErrorEvent(\"Invalid property ID\", \"hideVideo\")";
                    } else if (player2.getState() == playerState.RELEASED) {
                        errInjection2 = "window.mraidview.fireErrorEvent(\"Invalid player state\", \"hideVideo\")";
                    } else {
                        IMWebView.this.videoPlayerList.put(pid, player2);
                        player2.hide();
                        player2.releasePlayer(false);
                        return;
                    }
                    IMWebView.this.injectJavaScript(errInjection2);
                    break;
                case IMWebView.MESSAGE_SHOW_VIDEO /*1016*/:
                    String pid2 = data.getString(IMWebView.PROPERTY_ID);
                    AVPlayer player3 = IMWebView.this.getVideoPlayer(pid2);
                    if (player3 == null) {
                        errInjection = "window.mraidview.fireErrorEvent(\"Invalid property ID\", \"showVideo\")";
                    } else if (player3.getState() != playerState.RELEASED) {
                        errInjection = "window.mraidview.fireErrorEvent(\"Invalid player state\", \"showVideo\")";
                    } else if (IMWebView.this.videoPlayer == null || IMWebView.this.videoPlayer.getPropertyID().equalsIgnoreCase(pid2)) {
                        IMWebView.this.videoPlayerList.remove(pid2);
                        Bundle playData = new Bundle();
                        playData.putString(IMWebView.EXPAND_URL, player3.getMediaURL());
                        playData.putParcelable(IMWebView.DIMENSIONS, player3.getPlayDimensions());
                        playData.putParcelable(IMWebView.PLAYER_PROPERTIES, player3.getProperties());
                        IMWebView.this.playVideoImpl(playData, IMWebView.this.mExpandedActivity);
                        return;
                    } else {
                        errInjection = "window.mraidview.fireErrorEvent(\"Show failed. There is already a video playing\", \"showVideo\")";
                    }
                    IMWebView.this.injectJavaScript(errInjection);
                    break;
                case IMWebView.MESSAGE_MUTE_VIDEO /*1017*/:
                    ((AVPlayer) msg.obj).mute();
                    break;
                case IMWebView.MESSAGE_UNMUTE_VIDEO /*1018*/:
                    ((AVPlayer) msg.obj).unMute();
                    break;
                case IMWebView.MESSAGE_SET_VIDEOVOLUME /*1019*/:
                    ((AVPlayer) msg.obj).setVolume(data.getInt(IMWebView.VIDEO_VOLUME));
                    break;
                case IMWebView.MESSAGE_SEEK_VIDEO /*1020*/:
                    ((AVPlayer) msg.obj).seekPlayer(data.getInt(IMWebView.SEEK_POSITION) * 1000);
                    break;
                case IMWebView.MESSAGE_MUTE_AUDIO /*1021*/:
                    AVPlayer aplayer2 = (AVPlayer) IMWebView.this.audioPlayerList.get(data.getString(IMWebView.AUDIO_PLAYER_REF));
                    if (aplayer2 != null) {
                        aplayer2.mute();
                    }
                    break;
                case IMWebView.MESSAGE_UNMUTE_AUDIO /*1022*/:
                    AVPlayer aplayer3 = (AVPlayer) IMWebView.this.audioPlayerList.get(data.getString(IMWebView.AUDIO_PLAYER_REF));
                    if (aplayer3 != null) {
                        aplayer3.unMute();
                    }
                    break;
                case IMWebView.MESSAGE_SET_AUDIOVOLUME /*1023*/:
                    AVPlayer aplayer4 = (AVPlayer) IMWebView.this.audioPlayerList.get(data.getString(IMWebView.AUDIO_PLAYER_REF));
                    if (aplayer4 != null) {
                        aplayer4.setVolume(data.getInt(IMWebView.AUDIO_VOLUME));
                    }
                    break;
                case IMWebView.MESSAGE_SEEK_AUDIO /*1024*/:
                    ((AVPlayer) msg.obj).seekPlayer(data.getInt(IMWebView.SEEK_AUDIO) * 1000);
                    break;
                case IMWebView.MESSAGE_IMBROWSERACTIVITY_DISMISS_SCREEN /*1025*/:
                    if (IMWebView.this.mListener != null) {
                        IMWebView.this.mListener.onDismissAdScreen();
                        break;
                    }
                    break;
                case IMWebView.MESSAGE_HIDE_PLAYERS /*1026*/:
                    IMWebView.this.hidePlayers();
                    break;
                case IMWebView.MESSAGE_OPEN_URL /*1027*/:
                    IMWebView.this.open(data.getString(IMWebView.EXPAND_URL));
                    break;
            }
            super.handleMessage(msg);
        }
    };
    private ViewGroup mIMWebViewParent;
    private int mIndex;
    private int mInitLayoutHeight;
    private int mInitLayoutWidth;
    public boolean mIsExpandUrlValid = false;
    public boolean mIsInterstitialAd = false;
    private boolean mIsViewable = true;
    public IMWebViewListener mListener;
    private String mLocalFilePath;
    private Message mMsgOnInterstitialClosed;
    /* access modifiers changed from: private */
    public Message mMsgOnPageFinished;
    /* access modifiers changed from: private */
    public Message mMsgOnPageFinishedForAdCreativeTesting;
    private Message mMsgOnSearchAdClicked;
    private Sensor mOrientationSensor;
    public IMWebView mOriginalWebviewForExpandUrl = null;
    /* access modifiers changed from: private */
    public Display mSensorDisplay;
    private SensorManager mSensorManager;
    private TimeOut mTimeOut;
    private JSUtilityController mUtilityController;
    /* access modifiers changed from: private */
    public ViewState mViewState = ViewState.LOADING;
    WebChromeClient mWebChromeClient = new WebChromeClient() {
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Log.d(Constants.LOGGING_TAG, "IMWebView-> onJsAlert, " + message);
            return false;
        }
    };
    WebViewClient mWebViewClient = new WebViewClient() {
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "IMWebView-> onPageStarted url: " + url);
            }
            if (IMWebView.this.mExtWebViewClient != null) {
                IMWebView.this.mExtWebViewClient.onPageStarted(view, url, favicon);
            }
            IMWebView.this.isMraid = false;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "IMWebView-> error:" + description);
            }
            if (IMWebView.this.mExtWebViewClient != null) {
                IMWebView.this.mExtWebViewClient.onReceivedError(view, errorCode, description, failingUrl);
            }
            try {
                if (IMWebView.this.mViewState == ViewState.LOADING && IMWebView.this.mMsgOnPageFinished != null) {
                    IMWebView.this.mMsgOnPageFinished.sendToTarget();
                }
            } catch (Exception e) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "Exception in webview loading", e);
                }
            }
        }

        public void onPageFinished(WebView view, String url) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "IMWebView-> onPageFinished, url:" + url);
            }
            if (IMWebView.this.mExtWebViewClient != null) {
                IMWebView.this.mExtWebViewClient.onPageFinished(view, url);
            }
            try {
                if (!IMWebView.this.isMraid && IMWebView.this.mraidURLs.contains(url)) {
                    IMWebView.this.isMraid = true;
                    IMWebView.this.injectJavaScript(IMWebView.MRAID_BRIDGE);
                    IMWebView.this.injectJavaScript(IMWebView.MRAID);
                }
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "IMWebView-> Current State:" + IMWebView.this.mViewState);
                }
                if (IMWebView.this.mViewState == ViewState.LOADING) {
                    if (IMWebView.this.mIsExpandUrlValid) {
                        IMWebView.this.setState(ViewState.EXPANDED);
                    } else {
                        IMWebView.this.setState(ViewState.DEFAULT);
                    }
                    IMWebView.this.injectJavaScript("window.mraidview.fireReadyEvent();");
                    if (!IMWebView.this.mIsInterstitialAd || IMWebView.this.mWebViewIsBrowserActivity) {
                        IMWebView.this.setViewable(true);
                        if (IMWebView.this.getVisibility() == 4) {
                            IMWebView.this.setVisibility(0);
                        }
                    }
                    if (IMWebView.this.mMsgOnPageFinished != null) {
                        IMWebView.this.mMsgOnPageFinished.sendToTarget();
                    }
                    if (IMWebView.this.mMsgOnPageFinishedForAdCreativeTesting != null) {
                        IMWebView.this.mMsgOnPageFinishedForAdCreativeTesting.sendToTarget();
                    }
                }
            } catch (Exception e) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "Exception in onPageFinished", e);
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "IMWebView-> shouldOverrideUrlLoading, url:" + url + "webview id" + view);
            }
            if (IMWebView.this.mAdUnit == null || IMWebView.this.mAdUnit.getAdActionName() != AdActionNames.AdActionName_Search) {
                Uri uri = Uri.parse(url);
                try {
                    if (IMWebView.this.mListener != null && IMWebView.this.isRegisteredProtocol(uri)) {
                        IMWebView.this.mListener.handleRequest(url);
                        return true;
                    } else if (url.startsWith("tel:")) {
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(url));
                        intent.addFlags(268435456);
                        IMWebView.this.mExpandedActivity.startActivity(intent);
                        IMWebView.this.fireOnLeaveApplication();
                        return true;
                    } else if (url.startsWith("mailto:")) {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(url));
                        intent2.addFlags(268435456);
                        IMWebView.this.mExpandedActivity.startActivity(intent2);
                        IMWebView.this.fireOnLeaveApplication();
                        return true;
                    } else if (url.startsWith("about:blank")) {
                        return false;
                    } else {
                        if (url.startsWith("https://") || url.startsWith("market://") || url.contains("play.google.com") || url.contains("market.android.com")) {
                            Intent intent3 = new Intent();
                            intent3.setAction("android.intent.action.VIEW");
                            intent3.setData(uri);
                            intent3.addFlags(268435456);
                            IMWebView.this.mExpandedActivity.startActivity(intent3);
                            IMWebView.this.fireOnLeaveApplication();
                            return true;
                        }
                        IMWebView.this.doHidePlayers();
                        if (IMWebView.this.mWebViewIsBrowserActivity) {
                            return false;
                        }
                        Intent i = new Intent(IMWebView.this.mExpandedActivity, IMBrowserActivity.class);
                        Log.d(Constants.LOGGING_TAG, "IMWebView-> shouldoverride:" + url);
                        i.putExtra(IMBrowserActivity.EXTRA_URL, url);
                        IMBrowserActivity.setWebViewListener(IMWebView.this.mListener);
                        IMWebView.this.mExpandedActivity.startActivity(i);
                        return true;
                    }
                } catch (Exception e) {
                    try {
                        if (url.startsWith("https://") || url.startsWith("market://") || url.contains("play.google.com") || url.contains("market.android.com")) {
                            Intent intent4 = new Intent();
                            intent4.setAction("android.intent.action.VIEW");
                            intent4.setData(uri);
                            intent4.addFlags(268435456);
                            IMWebView.this.mExpandedActivity.startActivity(intent4);
                            IMWebView.this.fireOnLeaveApplication();
                            return true;
                        }
                        IMWebView.this.doHidePlayers();
                        if (IMWebView.this.mWebViewIsBrowserActivity) {
                            return false;
                        }
                        Intent i2 = new Intent(IMWebView.this.mExpandedActivity, IMBrowserActivity.class);
                        Log.d(Constants.LOGGING_TAG, "IMWebView-> open:" + url);
                        i2.putExtra(IMBrowserActivity.EXTRA_URL, url);
                        IMBrowserActivity.setWebViewListener(IMWebView.this.mListener);
                        IMWebView.this.mExpandedActivity.startActivity(i2);
                        return true;
                    } catch (Exception e2) {
                        return false;
                    }
                }
            } else {
                IMWebView.this.handleSearchAd(view, url);
                return true;
            }
        }

        public void onLoadResource(WebView view, String url) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "IMWebView-> onLoadResource:" + url);
            }
            if (IMWebView.this.mExtWebViewClient != null) {
                IMWebView.this.mExtWebViewClient.onLoadResource(view, url);
            }
            if (!IMWebView.this.isMraid && url.contains(IMWebView.MRAID_SCRIPT_NAME)) {
                if (Constants.DEBUG) {
                    Log.d(Constants.LOGGING_TAG, "IMWebView-> onLoadResource:Hippy, Mraid ad alert!...injecting mraid and mraidview object");
                }
                IMWebView.this.isMraid = true;
                String urlData = IMWebView.this.getUrl();
                if (!IMWebView.this.mraidURLs.contains(urlData)) {
                    IMWebView.this.mraidURLs.add(urlData);
                }
                IMWebView.this.injectJavaScript(IMWebView.MRAID_BRIDGE);
                IMWebView.this.injectJavaScript(IMWebView.MRAID);
            }
        }
    };
    /* access modifiers changed from: private */
    public IMWebView mWebViewForExpandUrl;
    /* access modifiers changed from: private */
    public boolean mWebViewIsBrowserActivity;
    /* access modifiers changed from: private */
    public ArrayList<String> mraidURLs = new ArrayList<>();
    public Object mutex = new Object();
    private String orientationValueForInterstitial;
    public int publisherOrientation;
    private final HashSet<String> registeredProtocols = new HashSet<>();
    /* access modifiers changed from: private */
    public int sensorCurOrientation = -5;
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public void onSensorChanged(SensorEvent event) {
            FrameLayout contView;
            int tempExpX;
            int tempExpY;
            if (VERSION.SDK_INT >= 8) {
                IMWebView.this.sensorCurOrientation = IMWebView.this.mSensorDisplay.getRotation();
            } else {
                IMWebView.this.sensorCurOrientation = IMWebView.this.mSensorDisplay.getOrientation();
            }
            if (IMWebView.this.sensorCurOrientation != -5 && IMWebView.this.sensorCurOrientation != IMWebView.this.sensorOldOrientation) {
                try {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "IMWebView-> SensorEventListener, It came inside the listener" + IMWebView.this.sensorCurOrientation);
                    }
                    IMWebView.this.sensorOldOrientation = IMWebView.this.sensorCurOrientation;
                    int curWidth = IMWebView.this.mActivity.getResources().getDisplayMetrics().widthPixels;
                    int curHeight = IMWebView.this.mActivity.getResources().getDisplayMetrics().heightPixels;
                    if (IMWebView.this.isTablet) {
                        IMWebView iMWebView = IMWebView.this;
                        iMWebView.sensorCurOrientation = iMWebView.sensorCurOrientation + 1;
                        if (IMWebView.this.sensorCurOrientation > 3) {
                            IMWebView.this.sensorCurOrientation = 0;
                        }
                        if (Constants.DEBUG) {
                            Log.d(Constants.LOGGING_TAG, "IMWebView-> SensorEventListener, It is a tablet" + IMWebView.this.sensorCurOrientation);
                        }
                    }
                    if (!IMWebView.this.mIsInterstitialAd) {
                        if (IMWebView.this.sensorCurOrientation == 0 || IMWebView.this.sensorCurOrientation == 2) {
                            IMWebView.this.expandProperties.actualWidthRequested = IMWebView.this.expandProperties.portraitWidthRequested;
                            IMWebView.this.expandProperties.actualHeightRequested = IMWebView.this.expandProperties.portraitHeightRequested;
                            if (curWidth > curHeight) {
                                int tempp = curWidth;
                                curWidth = curHeight;
                                curHeight = tempp;
                            }
                        } else {
                            IMWebView.this.expandProperties.actualWidthRequested = IMWebView.this.expandProperties.portraitHeightRequested;
                            IMWebView.this.expandProperties.actualHeightRequested = IMWebView.this.expandProperties.portraitWidthRequested;
                            if (curWidth < curHeight) {
                                int tempp2 = curWidth;
                                curWidth = curHeight;
                                curHeight = tempp2;
                            }
                        }
                        if (IMWebView.this.expandProperties.zeroWidthHeight) {
                            IMWebView.this.expandProperties.actualWidthRequested = curWidth;
                            IMWebView.this.expandProperties.actualHeightRequested = curHeight;
                        }
                        int curHeight2 = curHeight - IMWebView.this.expandProperties.topStuff;
                        if (IMWebView.this.sensorFirstExpand != -5) {
                            if (IMWebView.this.mIsExpandUrlValid) {
                                contView = (FrameLayout) IMWebView.this.mWebViewForExpandUrl.getRootView().findViewById(16908290);
                            } else {
                                contView = (FrameLayout) IMWebView.this.getRootView().findViewById(16908290);
                            }
                            FrameLayout background = null;
                            RelativeLayout rlyout = null;
                            if (contView != null) {
                                background = (FrameLayout) contView.findViewById(IMWebView.BACKGROUND_ID);
                                rlyout = (RelativeLayout) background.findViewById(IMWebView.RELATIVELAYOUT_ID);
                            }
                            if (IMWebView.this.sensorCurOrientation == 0 || IMWebView.this.sensorCurOrientation == 2) {
                                if (Constants.DEBUG) {
                                    Log.d(Constants.LOGGING_TAG, "IMWebView-> SensorEventListener, It is the case from landscape to portrait");
                                }
                                IMWebView.this.expandProperties.width = Math.min(curWidth, IMWebView.this.expandProperties.actualWidthRequested);
                                IMWebView.this.expandProperties.height = Math.min(IMWebView.this.expandProperties.actualHeightRequested, curHeight2 - IMWebView.this.expandProperties.y);
                                int widthDiff = curWidth - (IMWebView.this.expandProperties.x + IMWebView.this.expandProperties.width);
                                if (widthDiff < 0) {
                                    tempExpX = IMWebView.this.expandProperties.x + widthDiff;
                                    if (tempExpX < 0) {
                                        IMWebView.this.expandProperties.width += tempExpX;
                                        tempExpX = 0;
                                    }
                                } else {
                                    tempExpX = IMWebView.this.expandProperties.x;
                                }
                                if (background != null) {
                                    background.setPadding(tempExpX, IMWebView.this.expandProperties.y, 0, 0);
                                    IMWebView.this.expandProperties.currentX = tempExpX;
                                    IMWebView.this.expandProperties.currentY = IMWebView.this.expandProperties.y;
                                    AVPlayer player = IMWebView.this.videoPlayer;
                                    if (IMWebView.this.mIsExpandUrlValid) {
                                        IMWebView.this.mWebViewForExpandUrl.expandProperties.currentX = IMWebView.this.expandProperties.currentX;
                                        IMWebView.this.mWebViewForExpandUrl.expandProperties.currentY = IMWebView.this.expandProperties.currentY;
                                        player = IMWebView.this.mWebViewForExpandUrl.videoPlayer;
                                    }
                                    if (player != null && player.isInlineVideo()) {
                                        Dimensions d = player.getPlayDimensions();
                                        if (d != null && d.x >= 0 && d.y >= 0) {
                                            ((FrameLayout) player.getBackGroundLayout()).setPadding(d.x + tempExpX, IMWebView.this.expandProperties.y + d.y, 0, 0);
                                        }
                                    }
                                    rlyout.setLayoutParams(new LayoutParams(IMWebView.this.expandProperties.width, IMWebView.this.expandProperties.height));
                                    if (IMWebView.this.mIsExpandUrlValid) {
                                        IMWebView.this.mWebViewForExpandUrl.setLayoutParams(new RelativeLayout.LayoutParams(IMWebView.this.expandProperties.width, IMWebView.this.expandProperties.height));
                                        IMWebView.this.mWebViewForExpandUrl.videoValidateWidth = IMWebView.this.expandProperties.width;
                                    } else {
                                        IMWebView.this.setLayoutParams(new RelativeLayout.LayoutParams(IMWebView.this.expandProperties.width, IMWebView.this.expandProperties.height));
                                        IMWebView.this.videoValidateWidth = IMWebView.this.expandProperties.width;
                                    }
                                    if (Constants.DEBUG) {
                                        Log.d(Constants.LOGGING_TAG, "Dimentions: {" + tempExpX + " ," + IMWebView.this.expandProperties.y + " ," + IMWebView.this.expandProperties.width + " ," + IMWebView.this.expandProperties.height + "}");
                                    }
                                }
                            } else if (IMWebView.this.sensorCurOrientation == 1 || IMWebView.this.sensorCurOrientation == 3) {
                                if (Constants.DEBUG) {
                                    Log.d(Constants.LOGGING_TAG, "IMWebView-> SensorEventListener, It is the case from portrait to landscape");
                                }
                                IMWebView.this.expandProperties.height = Math.min(curHeight2, IMWebView.this.expandProperties.actualHeightRequested);
                                IMWebView.this.expandProperties.width = Math.min(IMWebView.this.expandProperties.actualWidthRequested, curWidth - IMWebView.this.expandProperties.x);
                                int heightDiff = curHeight2 - (IMWebView.this.expandProperties.y + IMWebView.this.expandProperties.height);
                                if (heightDiff < 0) {
                                    tempExpY = IMWebView.this.expandProperties.y + heightDiff;
                                    if (tempExpY < 0) {
                                        IMWebView.this.expandProperties.height += tempExpY;
                                        tempExpY = 0;
                                    }
                                } else {
                                    tempExpY = IMWebView.this.expandProperties.y;
                                }
                                if (background != null) {
                                    background.setPadding(IMWebView.this.expandProperties.x, tempExpY, 0, 0);
                                    IMWebView.this.expandProperties.currentX = IMWebView.this.expandProperties.x;
                                    IMWebView.this.expandProperties.currentY = tempExpY;
                                    AVPlayer player2 = IMWebView.this.videoPlayer;
                                    if (IMWebView.this.mIsExpandUrlValid) {
                                        IMWebView.this.mWebViewForExpandUrl.expandProperties.currentX = IMWebView.this.expandProperties.currentX;
                                        IMWebView.this.mWebViewForExpandUrl.expandProperties.currentY = IMWebView.this.expandProperties.currentY;
                                        player2 = IMWebView.this.mWebViewForExpandUrl.videoPlayer;
                                    }
                                    if (player2 != null && player2.isInlineVideo()) {
                                        Dimensions d2 = player2.getPlayDimensions();
                                        if (d2 != null && d2.x >= 0 && d2.y >= 0) {
                                            ((FrameLayout) player2.getBackGroundLayout()).setPadding(IMWebView.this.expandProperties.x + d2.x, d2.y + tempExpY, 0, 0);
                                        }
                                    }
                                    rlyout.setLayoutParams(new LayoutParams(IMWebView.this.expandProperties.width, IMWebView.this.expandProperties.height));
                                    if (IMWebView.this.mIsExpandUrlValid) {
                                        IMWebView.this.mWebViewForExpandUrl.setLayoutParams(new RelativeLayout.LayoutParams(IMWebView.this.expandProperties.width, IMWebView.this.expandProperties.height));
                                        IMWebView.this.mWebViewForExpandUrl.videoValidateWidth = IMWebView.this.expandProperties.width;
                                    } else {
                                        IMWebView.this.setLayoutParams(new RelativeLayout.LayoutParams(IMWebView.this.expandProperties.width, IMWebView.this.expandProperties.height));
                                        IMWebView.this.videoValidateWidth = IMWebView.this.expandProperties.width;
                                    }
                                    if (Constants.DEBUG) {
                                        Log.d(Constants.LOGGING_TAG, "Dimentions: {" + IMWebView.this.expandProperties.x + " ," + tempExpY + " ," + IMWebView.this.expandProperties.width + " ," + IMWebView.this.expandProperties.height + "}");
                                    }
                                }
                            }
                        }
                    }
                    if (IMWebView.this.sensorFirstExpand != -5) {
                        IMWebView.this.orientationChangeEvent(IMWebView.this.sensorCurOrientation);
                    }
                    IMWebView.this.sensorFirstExpand = IMWebView.this.sensorCurOrientation;
                } catch (Exception e) {
                    if (Constants.DEBUG) {
                        Log.w(Constants.LOGGING_TAG, "Exception while changing the container coordinates or width while orientation change", e);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public int sensorFirstExpand = -5;
    /* access modifiers changed from: private */
    public int sensorOldOrientation = -5;
    private boolean tempExpPropsLock = true;
    public boolean useLockOrient;
    /* access modifiers changed from: private */
    public AVPlayer videoPlayer;
    /* access modifiers changed from: private */
    public Hashtable<String, AVPlayer> videoPlayerList = new Hashtable<>();
    public int videoValidateWidth;

    public interface IMWebViewListener {
        void handleRequest(String str);

        boolean onDismissAdScreen();

        boolean onEventFired();

        boolean onExpand();

        boolean onExpandClose();

        boolean onLeaveApplication();

        boolean onReady();

        boolean onResize();

        boolean onResizeClose();

        boolean onShowScreen();
    }

    public static abstract class NewLocationReciever {
        public abstract void OnNewLocation(ViewState viewState);
    }

    class ScrollEater extends SimpleOnGestureListener {
        ScrollEater() {
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return true;
        }
    }

    class TimeOut extends TimerTask {
        int mCount = 0;
        int mProgress = 0;

        TimeOut() {
        }

        public void run() {
            int progress = IMWebView.this.getProgress();
            if (progress == 100) {
                cancel();
            } else if (this.mProgress == progress) {
                this.mCount++;
                if (this.mCount == 3) {
                    try {
                        IMWebView.this.stopLoading();
                    } catch (Exception e) {
                        Log.w(Constants.LOGGING_TAG, "IMWebView-> error in stopLoading");
                        e.printStackTrace();
                    }
                    cancel();
                }
            }
            this.mProgress = progress;
        }
    }

    public enum ViewState {
        LOADING,
        DEFAULT,
        RESIZED,
        EXPANDED,
        EXPANDING,
        HIDDEN
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$inmobi$androidsdk$impl$Constants$playerState() {
        int[] iArr = $SWITCH_TABLE$com$inmobi$androidsdk$impl$Constants$playerState;
        if (iArr == null) {
            iArr = new int[playerState.values().length];
            try {
                iArr[playerState.COMPLETED.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[playerState.HIDDEN.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[playerState.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[playerState.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[playerState.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[playerState.RELEASED.ordinal()] = 7;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[playerState.SHOWING.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            $SWITCH_TABLE$com$inmobi$androidsdk$impl$Constants$playerState = iArr;
        }
        return iArr;
    }

    public IMWebView(Context context, IMWebViewListener listener) {
        super(context);
        this.mListener = listener;
        initialize();
    }

    public IMWebView(Context context, IMWebViewListener listener, boolean isInterstitialAd, boolean miswebviewbrowseractivity) {
        super(context);
        this.mActivity = (Activity) context;
        this.mIsInterstitialAd = isInterstitialAd;
        this.mWebViewIsBrowserActivity = miswebviewbrowseractivity;
        if (this.mIsInterstitialAd) {
            setId(IMWEBVIEW_INTERSTITIAL_ID);
        }
        this.mListener = listener;
        initialize();
    }

    public void registerProtocol(String protocol) {
        if (protocol != null) {
            this.registeredProtocols.add(protocol.toLowerCase());
        }
    }

    public void deregisterProtocol(String protocol) {
        if (protocol != null) {
            this.registeredProtocols.remove(protocol.toLowerCase());
        }
    }

    /* access modifiers changed from: private */
    public boolean isRegisteredProtocol(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return false;
        }
        Iterator<String> it = this.registeredProtocols.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(scheme)) {
                return true;
            }
        }
        return false;
    }

    public void injectJavaScript(String str) {
        if (str != null && this.isMraid) {
            if (Constants.DEBUG && str.length() < 400) {
                Log.d(Constants.LOGGING_TAG, "Injecting JavaScript: " + str);
            }
            super.loadUrl("javascript:" + str);
        }
    }

    public void loadUrl(String url, String dataToInject) {
        loadUrl(url, false, dataToInject);
    }

    public void loadUrl(String url) {
        initStates();
        super.loadUrl(url);
    }

    public void loadData(String data, String mimeType, String encoding) {
        super.loadData(data, mimeType, encoding);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        initStates();
        super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    public void loadFile(File f, String dataToInject) {
        try {
            loadInputStream(new FileInputStream(f), dataToInject);
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception loading file", e);
            }
        }
    }

    public void clearView() {
        reset();
        super.clearView();
    }

    private void reset() {
        if (this.mViewState == ViewState.EXPANDED) {
            closeExpanded(this.mExpandedActivity);
        }
        invalidate();
        this.mUtilityController.deleteOldAds();
        this.mUtilityController.stopAllListeners();
        resetLayout();
    }

    private void loadInputStream(InputStream is, String dataToInject) {
        reset();
        if (this.mTimeOut != null) {
            this.mTimeOut.cancel();
        }
        this.mTimeOut = new TimeOut();
        try {
            this.mLocalFilePath = this.mUtilityController.writeToDiskWrap(is, CURRENT_FILE, true, dataToInject, mBridgeScriptPath, mScriptPath);
            String url = "file://" + this.mLocalFilePath + File.separator + CURRENT_FILE;
            new Timer().schedule(this.mTimeOut, 2000, 2000);
            if (dataToInject != null) {
                injectJavaScript(dataToInject);
            }
            super.loadUrl(url);
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e3) {
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e5) {
                }
            }
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e6) {
                }
            }
            throw th;
        }
    }

    public void loadUrl(String url, boolean dontLoad, String dataToInject) {
        InputStream is;
        if (URLUtil.isValidUrl(url)) {
            if (!dontLoad) {
                this.bPageFinished = false;
                try {
                    URL u = new URL(url);
                    String file = u.getFile();
                    if (url.startsWith("file:///android_asset/")) {
                        is = getContext().getAssets().open(url.replace("file:///android_asset/", Constants.QA_SERVER_URL));
                    } else {
                        is = u.openStream();
                    }
                    loadInputStream(is, dataToInject);
                    return;
                } catch (MalformedURLException e) {
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            super.loadUrl(url);
        }
    }

    public IMWebView(Context context, AttributeSet set) {
        super(context, set);
        initialize();
        getContext().obtainStyledAttributes(set, attrs).recycle();
    }

    private FrameLayout changeContentArea(ExpandProperties props) {
        FrameLayout contentView = (FrameLayout) getRootView().findViewById(16908290);
        replaceByPlaceholder();
        FrameLayout backGround = new FrameLayout(getContext());
        LayoutParams bgfl = new LayoutParams(-1, -1);
        backGround.setId(BACKGROUND_ID);
        backGround.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        backGround.setPadding(props.x, props.y, 0, 0);
        LayoutParams fl = new LayoutParams(props.width, props.height);
        RelativeLayout relLayout = new RelativeLayout(getContext());
        relLayout.setId(RELATIVELAYOUT_ID);
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(props.width, props.height);
        if (this.mIsExpandUrlValid) {
            relLayout.addView(this.mWebViewForExpandUrl, rlp);
        } else {
            relLayout.addView(this, rlp);
        }
        buildCloseButton(relLayout, props.useCustomClose);
        backGround.addView(relLayout, fl);
        contentView.addView(backGround, bgfl);
        return backGround;
    }

    public void replaceByPlaceholder() {
        ViewGroup parent = (ViewGroup) getParent();
        int count = parent.getChildCount();
        int index = 0;
        while (index < count && parent.getChildAt(index) != this) {
            index++;
        }
        this.mIndex = index;
        FrameLayout placeHolder = new FrameLayout(getContext());
        placeHolder.setId(PLACEHOLDER_ID);
        parent.addView(placeHolder, index, new ViewGroup.LayoutParams(getWidth(), getHeight()));
        parent.removeView(this);
        this.mIMWebViewParent = parent;
    }

    private void changeContentAreaSpecial(ExpandProperties props, String url) {
        Intent intent = new Intent(this.mActivity, IMBrowserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("EXPAND_WIDTH", props.width);
        bundle.putInt("EXPAND_HEIGHT", props.height);
        bundle.putBoolean("EXPAND_CUSTOM_CLOSE", props.useCustomClose);
        bundle.putString("EXPAND_ORIENTATION", props.orientation);
        bundle.putInt("EXPAND_BACKGROUND_ID", BACKGROUND_ID);
        bundle.putString("EXPAND_WITH_URL", url);
        intent.putExtras(bundle);
        if (this.mIsExpandUrlValid) {
            IMBrowserActivity.setWebView(this.mWebViewForExpandUrl);
        } else {
            IMBrowserActivity.setWebView(this);
        }
        IMBrowserActivity.setOriginalWebView(this);
        this.mActivity.startActivity(intent);
    }

    private void buildCloseButton(ViewGroup parent, boolean customclose) {
        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams((int) (this.mDensity * 50.0f), (int) (this.mDensity * 50.0f));
        lp2.addRule(11);
        ImageView imgView = new ImageView(getContext());
        if (customclose) {
            imgView.setImageBitmap(bitmapFromJar("assets/close_transparent.png"));
        } else {
            imgView.setImageBitmap(bitmapFromJar("assets/close_button.png"));
        }
        parent.addView(imgView, lp2);
        imgView.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                IMWebView.userInitiatedClose = true;
                IMWebView.this.close();
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doExpand(android.os.Bundle r9) {
        /*
            r8 = this;
            java.lang.String r3 = "expand_url"
            java.lang.String r2 = r9.getString(r3)     // Catch:{ Exception -> 0x00c1 }
            boolean r3 = android.webkit.URLUtil.isValidUrl(r2)     // Catch:{ Exception -> 0x00c1 }
            if (r3 == 0) goto L_0x00bd
            r3 = 1
            r8.mIsExpandUrlValid = r3     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = new com.inmobi.androidsdk.ai.container.IMWebView     // Catch:{ Exception -> 0x00c1 }
            android.content.Context r4 = r8.getContext()     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView$IMWebViewListener r5 = r8.mListener     // Catch:{ Exception -> 0x00c1 }
            r6 = 0
            r7 = 0
            r3.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x00c1 }
            r8.mWebViewForExpandUrl = r3     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            r4 = 1
            r3.mIsExpandUrlValid = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            int r4 = r8.publisherOrientation     // Catch:{ Exception -> 0x00c1 }
            r3.publisherOrientation = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            boolean r4 = r8.tempExpPropsLock     // Catch:{ Exception -> 0x00c1 }
            r3.tempExpPropsLock = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r4 = new com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties     // Catch:{ Exception -> 0x00c1 }
            r4.<init>()     // Catch:{ Exception -> 0x00c1 }
            r3.expandProperties = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r3.expandProperties     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r4 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            int r4 = r4.x     // Catch:{ Exception -> 0x00c1 }
            r3.x = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r3.expandProperties     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r4 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            int r4 = r4.y     // Catch:{ Exception -> 0x00c1 }
            r3.y = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r3.expandProperties     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r4 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            int r4 = r4.currentX     // Catch:{ Exception -> 0x00c1 }
            r3.currentX = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r3.expandProperties     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r4 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            int r4 = r4.currentY     // Catch:{ Exception -> 0x00c1 }
            r3.currentY = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            boolean r4 = r8.useLockOrient     // Catch:{ Exception -> 0x00c1 }
            r3.useLockOrient = r4     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            r3.mOriginalWebviewForExpandUrl = r8     // Catch:{ Exception -> 0x00c1 }
        L_0x006a:
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            boolean r3 = r3.checkFlag     // Catch:{ Exception -> 0x00c1 }
            if (r3 == 0) goto L_0x00f4
            android.app.Activity r3 = r8.mActivity     // Catch:{ Exception -> 0x00c1 }
            r8.setExpandedActivity(r3)     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            android.widget.FrameLayout r0 = r8.changeContentArea(r3)     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            r8.handleOrientation(r3)     // Catch:{ Exception -> 0x00c1 }
            r3 = 0
            r0.setBackgroundColor(r3)     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            int r3 = r3.width     // Catch:{ Exception -> 0x00c1 }
            r8.videoValidateWidth = r3     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            if (r3 == 0) goto L_0x0096
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r4 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            int r4 = r4.width     // Catch:{ Exception -> 0x00c1 }
            r3.videoValidateWidth = r4     // Catch:{ Exception -> 0x00c1 }
        L_0x0096:
            com.inmobi.androidsdk.ai.container.IMWebView$ViewState r3 = com.inmobi.androidsdk.ai.container.IMWebView.ViewState.EXPANDED     // Catch:{ Exception -> 0x00c1 }
            r8.setState(r3)     // Catch:{ Exception -> 0x00c1 }
            java.lang.Object r4 = r8.mutex     // Catch:{ Exception -> 0x00c1 }
            monitor-enter(r4)     // Catch:{ Exception -> 0x00c1 }
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.isMutexAquired     // Catch:{ all -> 0x00f1 }
            r5 = 0
            r3.set(r5)     // Catch:{ all -> 0x00f1 }
            java.lang.Object r3 = r8.mutex     // Catch:{ all -> 0x00f1 }
            r3.notifyAll()     // Catch:{ all -> 0x00f1 }
            monitor-exit(r4)     // Catch:{ all -> 0x00f1 }
            boolean r3 = r8.mIsExpandUrlValid     // Catch:{ Exception -> 0x00c1 }
            if (r3 == 0) goto L_0x00b3
            com.inmobi.androidsdk.ai.container.IMWebView r3 = r8.mWebViewForExpandUrl     // Catch:{ Exception -> 0x00c1 }
            r3.loadUrl(r2)     // Catch:{ Exception -> 0x00c1 }
        L_0x00b3:
            com.inmobi.androidsdk.ai.container.IMWebView$IMWebViewListener r3 = r8.mListener     // Catch:{ Exception -> 0x00c1 }
            if (r3 == 0) goto L_0x00bc
            com.inmobi.androidsdk.ai.container.IMWebView$IMWebViewListener r3 = r8.mListener     // Catch:{ Exception -> 0x00c1 }
            r3.onExpand()     // Catch:{ Exception -> 0x00c1 }
        L_0x00bc:
            return
        L_0x00bd:
            r3 = 0
            r8.mIsExpandUrlValid = r3     // Catch:{ Exception -> 0x00c1 }
            goto L_0x006a
        L_0x00c1:
            r1 = move-exception
            boolean r3 = com.inmobi.androidsdk.impl.Constants.DEBUG
            if (r3 == 0) goto L_0x00da
            java.lang.String r3 = "InMobiAndroidSDK_3.5.0"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Exception in doexpand"
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
        L_0x00da:
            com.inmobi.androidsdk.ai.container.IMWebView$ViewState r3 = com.inmobi.androidsdk.ai.container.IMWebView.ViewState.DEFAULT
            r8.mViewState = r3
            java.lang.Object r4 = r8.mutex
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicBoolean r3 = r8.isMutexAquired     // Catch:{ all -> 0x00ee }
            r5 = 0
            r3.set(r5)     // Catch:{ all -> 0x00ee }
            java.lang.Object r3 = r8.mutex     // Catch:{ all -> 0x00ee }
            r3.notifyAll()     // Catch:{ all -> 0x00ee }
            monitor-exit(r4)     // Catch:{ all -> 0x00ee }
            goto L_0x00bc
        L_0x00ee:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00ee }
            throw r3
        L_0x00f1:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00f1 }
            throw r3     // Catch:{ Exception -> 0x00c1 }
        L_0x00f4:
            com.inmobi.androidsdk.ai.controller.JSController$ExpandProperties r3 = r8.expandProperties     // Catch:{ Exception -> 0x00c1 }
            r8.changeContentAreaSpecial(r3, r2)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.androidsdk.ai.container.IMWebView.doExpand(android.os.Bundle):void");
    }

    public void setExpandedActivity(Activity mexpandedactivity) {
        this.mExpandedActivity = mexpandedactivity;
    }

    public Activity getExpandedActivity() {
        return this.mExpandedActivity;
    }

    private void handleOrientation(ExpandProperties props) {
        try {
            if (!props.lockOrientation && this.publisherOrientation == -1) {
                this.sensorCurOrientation = -5;
                this.sensorOldOrientation = -5;
                this.sensorFirstExpand = -5;
                this.mSensorManager.registerListener(this.sensorEventListener, this.mOrientationSensor, 3);
            }
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception handling the orientation", e);
            }
        }
    }

    public boolean adCreativeLocksOrientation(ExpandProperties props, int curRotation) {
        if (props.orientation.equals("portrait") && curRotation == 0) {
            this.mActivity.setRequestedOrientation(1);
            this.useLockOrient = true;
            return true;
        } else if (!props.orientation.equals("landscape") || curRotation != 1) {
            return false;
        } else {
            this.mActivity.setRequestedOrientation(0);
            this.useLockOrient = true;
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void handleSearchAd(WebView view, String url) {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "IMWebView-> Search query requested:" + url);
        }
        try {
            view.stopLoading();
            int index = url.indexOf("?");
            if (index > 0) {
                String queryString = url.substring(index);
                if (queryString != null) {
                    String targetUrl = this.mAdUnit.getDefaultTargetUrl();
                    this.mAdUnit.setTargetUrl(String.valueOf(targetUrl) + queryString);
                    System.out.println(String.valueOf(targetUrl) + queryString);
                    this.mMsgOnSearchAdClicked.getTarget().obtainMessage(this.mMsgOnSearchAdClicked.what).sendToTarget();
                }
            }
        } catch (Exception e) {
        }
    }

    public boolean getWhetherTablet(int rotation, int screenWidth, int screenHeight) {
        if (screenWidth > screenHeight && (rotation == 0 || rotation == 2)) {
            return true;
        }
        if (screenWidth >= screenHeight || (rotation != 1 && rotation != 3)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void orientationChangeEvent(int currr) {
        String script = "window.mraidview.fireOrientationChangeEvent(" + getCurrentRotation(currr) + ");";
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "JSDisplayController-> " + script);
        }
        injectJavaScript(script);
        if (this.mIsExpandUrlValid) {
            this.mWebViewForExpandUrl.injectJavaScript(script);
        }
    }

    public int getIntegerCurrentRotation() {
        int ttempCurRotation;
        int ttempCurRotation2;
        Display tempDisplay = ((WindowManager) this.mExpandedActivity.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 8) {
            ttempCurRotation = tempDisplay.getRotation();
        } else {
            ttempCurRotation = tempDisplay.getOrientation();
        }
        if (getWhetherTablet(ttempCurRotation2, this.mExpandedActivity.getResources().getDisplayMetrics().widthPixels, this.mExpandedActivity.getResources().getDisplayMetrics().heightPixels)) {
            ttempCurRotation2++;
            if (ttempCurRotation2 > 3) {
                ttempCurRotation2 = 0;
            }
            this.isTablet = true;
        }
        return ttempCurRotation2;
    }

    public String getCurrentRotation(int curR) {
        switch (curR) {
            case 0:
                return "0";
            case 1:
                return "90";
            case 2:
                return "180";
            case R.styleable.com_cauly_android_ad_AdView_age /*3*/:
                return "270";
            default:
                return "-1";
        }
    }

    private void initialize() {
        this.mExpandedActivity = this.mActivity;
        userInitiatedClose = false;
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setBackgroundColor(0);
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.mDensity = this.mActivity.getResources().getDisplayMetrics().density;
        this.bPageFinished = false;
        getSettings().setJavaScriptEnabled(true);
        this.mUtilityController = new JSUtilityController(this, getContext());
        addJavascriptInterface(this.mUtilityController, "utilityController");
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(this.mWebChromeClient);
        this.mSensorManager = (SensorManager) this.mActivity.getSystemService("sensor");
        this.mOrientationSensor = this.mSensorManager.getDefaultSensor(3);
        this.mSensorDisplay = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay();
        this.videoValidateWidth = this.mActivity.getResources().getDisplayMetrics().widthPixels;
    }

    private void initStates() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "IMWebView-> initStates");
        }
        this.mViewState = ViewState.LOADING;
        this.mIsViewable = false;
    }

    public void addJavascriptObject(Object obj, String name) {
        addJavascriptInterface(obj, name);
    }

    public void reinitializeExpandProperties() {
        this.mUtilityController.reinitializeExpandProperties();
    }

    public void deinit() {
        if (this.mViewState == ViewState.EXPANDED || this.mViewState == ViewState.EXPANDING) {
            this.mSensorManager.unregisterListener(this.sensorEventListener);
            close();
        }
    }

    /* access modifiers changed from: private */
    public void closeExpanded(Activity mexpandedactivity) {
        synchronized (this.mutex) {
            this.isMutexAquired.set(false);
            this.mutex.notifyAll();
        }
        if (!this.tempExpPropsLock && this.publisherOrientation == -1) {
            this.mSensorManager.unregisterListener(this.sensorEventListener);
            this.tempExpPropsLock = true;
        }
        resetContents(mexpandedactivity);
        releaseAllPlayers();
        this.mraidURLs.clear();
        if (mexpandedactivity instanceof IMBrowserActivity) {
            setExpandedActivity(this.mActivity);
            mexpandedactivity.finish();
        }
        this.mHandler.sendEmptyMessage(MESSAGE_SEND_EXPAND_CLOSE);
        setVisibility(0);
        this.mIsExpandUrlValid = false;
        if (this.useLockOrient) {
            this.mActivity.setRequestedOrientation(-1);
        }
        setState(ViewState.DEFAULT);
    }

    /* access modifiers changed from: protected */
    public void closeOpened(View openedFrame) {
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).removeView(openedFrame);
        requestLayout();
    }

    public String getState() {
        return this.mViewState.toString().toLowerCase();
    }

    public ViewState getStateVariable() {
        return this.mViewState;
    }

    public void setState(ViewState state) {
        this.mViewState = state;
        if (state != ViewState.EXPANDING) {
            injectJavaScript("window.mraidview.fireStateChangeEvent('" + getState() + "');");
        }
    }

    public boolean isBusy() {
        return this.isBusy;
    }

    public void close() {
        this.mHandler.sendEmptyMessage(MESSAGE_CLOSE);
    }

    public void hide() {
        this.mHandler.sendEmptyMessage(MESSAGE_HIDE);
    }

    public void show() {
        this.mHandler.sendEmptyMessage(MESSAGE_SHOW);
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getContext().getSystemService("connectivity");
    }

    public void setViewable(boolean isViewable) {
        this.mIsViewable = isViewable;
        injectJavaScript("window.mraidview.fireViewableChangeEvent(" + isViewable() + ");");
    }

    public boolean isViewable() {
        return this.mIsViewable;
    }

    public String getPlacementType() {
        if (this.mIsInterstitialAd) {
            return PLACEMENT_TYPE_INTERSTITIAL;
        }
        return PLACEMENT_TYPE_INLINE;
    }

    public void setCustomClose(boolean cusClose) {
        this.customClose = cusClose;
        if (this.mIsInterstitialAd) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(MESSAGE_CLOSE_BUTTON_INTERSTITIAL));
        }
    }

    /* access modifiers changed from: private */
    public void switchInterstitialCloseButtonState() {
        ImageView imgv = (ImageView) this.mExpandedActivity.findViewById(INT_CLOSE_BUTTON);
        if (imgv == null) {
            return;
        }
        if (this.customClose) {
            imgv.setImageBitmap(bitmapFromJar("assets/close_transparent.png"));
        } else {
            imgv.setImageBitmap(bitmapFromJar("assets/close_button.png"));
        }
    }

    public boolean getCustomClose() {
        return this.customClose;
    }

    public void expand(String URL, ExpandProperties props) {
        setState(ViewState.EXPANDING);
        this.mIsExpandUrlValid = false;
        this.isMutexAquired.set(true);
        Message msg = this.mHandler.obtainMessage(MESSAGE_EXPAND);
        Bundle data = new Bundle();
        data.putString(EXPAND_URL, URL);
        msg.setData(data);
        this.expandProperties = props;
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Dimentions: {" + this.expandProperties.x + " ," + this.expandProperties.y + " ," + this.expandProperties.width + " ," + this.expandProperties.height + "}");
        }
        this.tempExpPropsLock = this.expandProperties.lockOrientation;
        this.mHandler.sendMessage(msg);
    }

    public void openURL(String url) {
        doHidePlayers();
        Message msg = this.mHandler.obtainMessage(MESSAGE_OPEN_URL);
        Bundle data = new Bundle();
        data.putString(EXPAND_URL, url);
        msg.setData(data);
        this.mHandler.sendMessage(msg);
    }

    private String recursiveGetCall(String url) {
        try {
            HttpClient client = new DefaultHttpClient();
            HttpContext context = new BasicHttpContext();
            if (client.execute(new HttpGet(url), context).getStatusLine().getStatusCode() != 200) {
                return url;
            }
            HttpUriRequest currentReq = (HttpUriRequest) context.getAttribute("http.request");
            HttpHost currentHost = (HttpHost) context.getAttribute("http.target_host");
            if (currentReq.getURI().isAbsolute()) {
                return currentReq.getURI().toString();
            }
            return String.valueOf(currentHost.toURI()) + currentReq.getURI();
        } catch (Exception e) {
            return url;
        }
    }

    /* access modifiers changed from: private */
    public void open(String url) {
        if (url.startsWith("https://") || url.startsWith("market://") || url.contains("play.google.com") || url.contains("market.android.com")) {
            String finalurl = recursiveGetCall(url);
            if (finalurl != null) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(finalurl));
                intent.addFlags(268435456);
                this.mExpandedActivity.startActivity(intent);
                if (this.mListener != null) {
                    this.mListener.onLeaveApplication();
                    return;
                }
                return;
            }
            return;
        }
        Intent i = new Intent(this.mExpandedActivity, IMBrowserActivity.class);
        Log.d(Constants.LOGGING_TAG, "IMWebView-> open:" + url);
        i.putExtra(IMBrowserActivity.EXTRA_URL, url);
        IMBrowserActivity.setWebViewListener(this.mListener);
        this.mExpandedActivity.startActivity(i);
    }

    public void resetContents(Activity mexpandedactivity) {
        FrameLayout contentView;
        try {
            if (this.mIsExpandUrlValid) {
                contentView = (FrameLayout) this.mWebViewForExpandUrl.getRootView().findViewById(16908290);
            } else {
                contentView = (FrameLayout) getRootView().findViewById(16908290);
            }
            FrameLayout placeHolder = (FrameLayout) this.mActivity.findViewById(PLACEHOLDER_ID);
            FrameLayout background = (FrameLayout) contentView.findViewById(BACKGROUND_ID);
            Log.w(Constants.LOGGING_TAG, "PlaceHolder ID: " + placeHolder + " Bg ID: " + background);
            if (this.mIsExpandUrlValid) {
                this.mWebViewForExpandUrl.releaseAllPlayers();
            }
            if (background != null) {
                if (this.mIsExpandUrlValid) {
                    ((ViewGroup) background.getChildAt(0)).removeView(this.mWebViewForExpandUrl);
                    this.mWebViewForExpandUrl = null;
                } else {
                    ((ViewGroup) background.getChildAt(0)).removeView(this);
                }
                contentView.removeView(background);
            }
            resetLayout();
            if (placeHolder != null) {
                this.mIMWebViewParent.removeView(placeHolder);
                this.mIMWebViewParent.addView(this, this.mIndex);
            }
            this.mIMWebViewParent.invalidate();
        } catch (Exception e) {
            try {
                ViewGroup parent = (ViewGroup) getParent();
                parent.removeAllViews();
                ((ViewGroup) parent.getParent()).removeAllViews();
            } catch (Exception e2) {
            }
            Log.w(Constants.LOGGING_TAG, "Exception while closing the expanded Ad", e);
        }
    }

    private void resetLayout() {
        ViewGroup.LayoutParams lp = getLayoutParams();
        if (this.bGotLayoutParams) {
            lp.height = this.mInitLayoutHeight;
            lp.width = this.mInitLayoutWidth;
        }
        setVisibility(0);
        requestLayout();
    }

    public boolean isPageFinished() {
        return this.bPageFinished;
    }

    public String getSize() {
        return "{ width: " + ((int) (((float) getWidth()) / this.mDensity)) + ", " + "height: " + ((int) (((float) getHeight()) / this.mDensity)) + "}";
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "IMWebView->onAttachedToWindow");
        }
        if (!this.bGotLayoutParams) {
            ViewGroup.LayoutParams lp = getLayoutParams();
            this.mInitLayoutHeight = lp.height;
            this.mInitLayoutWidth = lp.width;
            this.bGotLayoutParams = true;
        }
        super.onAttachedToWindow();
    }

    public WebBackForwardList saveState(Bundle outState) {
        outState.putString(AD_PATH, this.mLocalFilePath);
        return null;
    }

    public WebBackForwardList restoreState(Bundle savedInstanceState) {
        this.mLocalFilePath = savedInstanceState.getString(AD_PATH);
        super.loadUrl("file://" + this.mLocalFilePath + File.separator + CURRENT_FILE);
        return null;
    }

    public void raiseError(String strMsg, String action) {
        Message msg = this.mHandler.obtainMessage(MESSAGE_RAISE_ERROR);
        Bundle data = new Bundle();
        data.putString(ERROR_MESSAGE, strMsg);
        data.putString(ERROR_ACTION, action);
        msg.setData(data);
        this.mHandler.sendMessage(msg);
    }

    public boolean isExpanded() {
        return this.mViewState == ViewState.EXPANDED;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "IMWebView->onDetachedFromWindow");
        }
        this.mUtilityController.stopAllListeners();
        this.mraidURLs.clear();
        if (this.mIsInterstitialAd && !this.mWebViewIsBrowserActivity) {
            try {
                this.mSensorManager.unregisterListener(this.sensorEventListener);
            } catch (Exception e) {
            }
        }
        super.onDetachedFromWindow();
    }

    private AVPlayer getAudioPlayer(String pid, String url, Activity mexpandedactivity) {
        if (!this.audioPlayerList.isEmpty()) {
            this.audioplayer = this.audioPlayerList.get(pid);
            if (this.audioplayer == null) {
                if (this.audioPlayerList.size() > 4) {
                    raiseError("Too many audio players", "playAudio");
                    this.audioplayer = null;
                } else {
                    this.audioplayer = new AVPlayer(mexpandedactivity, this);
                }
            } else if (!this.audioplayer.getMediaURL().equals(url) && url.length() != 0) {
                this.audioplayer.releasePlayer(false);
                this.audioPlayerList.remove(pid);
                this.audioplayer = new AVPlayer(mexpandedactivity, this);
            } else if (this.audioplayer.getState() == playerState.PLAYING) {
                this.audioplayer = null;
            } else if (this.audioplayer.getState() == playerState.PAUSED) {
                this.audioplayer.start();
                this.audioplayer = null;
            } else {
                PlayerProperties tempP = this.audioplayer.getProperties();
                String tempU = this.audioplayer.getMediaURL();
                this.audioplayer.releasePlayer(false);
                this.audioPlayerList.remove(pid);
                this.audioplayer = new AVPlayer(mexpandedactivity, this);
                this.audioplayer.setPlayData(tempP, tempU);
            }
        } else {
            this.audioplayer = new AVPlayer(mexpandedactivity, this);
        }
        return this.audioplayer;
    }

    private synchronized AVPlayer getCurrentAudioPlayer(String pid) {
        AVPlayer player;
        player = null;
        if (this.audioplayer != null && this.audioplayer.getPropertyID().equalsIgnoreCase(pid)) {
            player = this.audioplayer;
        } else if (!this.audioPlayerList.isEmpty() && this.audioPlayerList.containsKey(pid)) {
            player = this.audioPlayerList.get(pid);
        }
        return player;
    }

    public void releaseAllPlayers() {
        if (this.videoPlayer != null) {
            this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
        }
        try {
            for (Entry<String, AVPlayer> item : this.videoPlayerList.entrySet()) {
                item.getValue().releasePlayer(userInitiatedClose);
            }
        } catch (Exception e) {
        }
        this.videoPlayerList.clear();
        this.videoPlayer = null;
        try {
            for (Entry<String, AVPlayer> item2 : this.audioPlayerList.entrySet()) {
                item2.getValue().releasePlayer(userInitiatedClose);
            }
        } catch (Exception e2) {
        }
        userInitiatedClose = false;
        this.audioPlayerList.clear();
        this.audioplayer = null;
    }

    /* access modifiers changed from: 0000 */
    public AVPlayer getHiddenPlayerInstance(String pid) {
        if (!this.videoPlayerList.isEmpty()) {
            return this.videoPlayerList.get(pid);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public boolean handleHiddenPlayer(String pid, String url, Activity mexpandedactivity) {
        if ((url.length() == 0 || URLUtil.isValidUrl(url)) && (url.length() != 0 || this.videoPlayerList.containsKey(pid))) {
            if (this.videoPlayer != null) {
                this.videoPlayer.releasePlayer(false);
            }
            AVPlayer player = getHiddenPlayerInstance(pid);
            if (player == null) {
                this.videoPlayer = new AVPlayer(mexpandedactivity, this);
            } else {
                this.videoPlayer = player;
            }
            if (url.length() == 0) {
                this.videoPlayer.setPlayData(player.getProperties(), player.getMediaURL());
                this.videoPlayer.setPlayDimensions(player.getPlayDimensions());
            }
            this.videoPlayerList.remove(pid);
            return true;
        }
        raiseError(ERR_INVALID_URL, "playVideo");
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean getVideoPlayer(String pid, String url, Activity mexpandedactivity, Dimensions playDimensions) {
        if (this.videoPlayer == null || !pid.equalsIgnoreCase(this.videoPlayer.getPropertyID())) {
            return handleHiddenPlayer(pid, url, mexpandedactivity);
        }
        playerState pState = this.videoPlayer.getState();
        if (!pid.equalsIgnoreCase(this.videoPlayer.getPropertyID())) {
            return true;
        }
        String pUrl = this.videoPlayer.getMediaURL();
        if (url.length() == 0 || url.equalsIgnoreCase(pUrl)) {
            switch ($SWITCH_TABLE$com$inmobi$androidsdk$impl$Constants$playerState()[pState.ordinal()]) {
                case 2:
                    resizeInlineVideo(this.videoPlayer, playDimensions);
                    break;
                case R.styleable.com_cauly_android_ad_AdView_age /*3*/:
                    this.videoPlayer.start();
                    break;
                case R.styleable.com_cauly_android_ad_AdView_gps /*6*/:
                    if (!this.videoPlayer.getProperties().doLoop()) {
                        this.videoPlayer.start();
                        break;
                    }
                    break;
            }
            return false;
        } else if (!URLUtil.isValidUrl(url)) {
            raiseError(ERR_INVALID_URL, "playVideo");
            return false;
        } else {
            this.videoPlayer.releasePlayer(false);
            this.videoPlayer = new AVPlayer(mexpandedactivity, this);
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized AVPlayer getVideoPlayer(String pid) {
        AVPlayer player;
        player = null;
        if (this.videoPlayer != null && this.videoPlayer.getPropertyID().equalsIgnoreCase(pid)) {
            player = this.videoPlayer;
        } else if (!this.videoPlayerList.isEmpty() && this.videoPlayerList.containsKey(pid)) {
            player = this.videoPlayerList.get(pid);
        }
        return player;
    }

    public AdUnit getAdUnit() {
        return this.mAdUnit;
    }

    public void setAdUnit(AdUnit adUnit) {
        this.mAdUnit = adUnit;
    }

    public void requestOnPageFinishedCallback(Message msgOnPageFinished) {
        this.mMsgOnPageFinished = msgOnPageFinished;
    }

    public void pageFinishedCallbackForAdCreativeTesting(Message msgOnPageFinishedForAdCreativeTesting) {
        this.mMsgOnPageFinishedForAdCreativeTesting = msgOnPageFinishedForAdCreativeTesting;
    }

    public void requestOnInterstitialClosed(Message msgOnInterstitialClosed) {
        this.mMsgOnInterstitialClosed = msgOnInterstitialClosed;
    }

    public void requestOnSearchAdClicked(Message msgOnSearchAdClicked) {
        this.mMsgOnSearchAdClicked = msgOnSearchAdClicked;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    /* access modifiers changed from: protected */
    public String getStringFromJarFile(String inSource) {
        InputStream in = null;
        try {
            String file = JSAssetController.class.getClassLoader().getResource(inSource).getFile();
            if (file.startsWith("file:")) {
                file = file.substring(5);
            }
            int pos = file.indexOf("!");
            if (pos > 0) {
                file = file.substring(0, pos);
            }
            JarFile jf = new JarFile(file);
            in = jf.getInputStream(jf.getJarEntry(inSource));
            BufferedReader bis = new BufferedReader(new InputStreamReader(in));
            StringBuilder strBuild = new StringBuilder();
            while (true) {
                String line = bis.readLine();
                if (line == null) {
                    break;
                }
                strBuild.append(line);
                strBuild.append("\n");
            }
            String sb = strBuild.toString();
            if (in == null) {
                return sb;
            }
            try {
                in.close();
            } catch (Exception e) {
            }
            return sb;
        } catch (Exception e2) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception reading the JS file", e2);
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            return null;
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    public static Bitmap bitmapFromJar(String source) {
        InputStream in = null;
        try {
            String file = JSAssetController.class.getClassLoader().getResource(source).getFile();
            if (file.startsWith("file:")) {
                file = file.substring(5);
            }
            int pos = file.indexOf("!");
            if (pos > 0) {
                file = file.substring(0, pos);
            }
            JarFile jf = new JarFile(file);
            InputStream in2 = jf.getInputStream(jf.getJarEntry(source));
            Bitmap bmp = BitmapFactory.decodeStream(in2);
            if (in2 == null) {
                return bmp;
            }
            try {
                in2.close();
            } catch (Exception e) {
            }
            return bmp;
        } catch (Exception e2) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Exception in reading bitmap from Jar", e2);
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            return null;
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    public void playAudioImpl(Bundle data, Activity mexpandedactivity) {
        final PlayerProperties properties = (PlayerProperties) data.getParcelable(PLAYER_PROPERTIES);
        String url = data.getString(EXPAND_URL);
        if (url == null) {
            url = Constants.QA_SERVER_URL;
        }
        this.audioplayer = getAudioPlayer(properties.id, url, mexpandedactivity);
        if (this.audioplayer != null) {
            if (url.length() != 0) {
                this.audioplayer.setPlayData(properties, url);
            }
            this.audioPlayerList.put(properties.id, this.audioplayer);
            FrameLayout contentView = (FrameLayout) getRootView().findViewById(16908290);
            if (properties.isFullScreen()) {
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-1, -1);
                lp.addRule(13);
                this.audioplayer.setLayoutParams(lp);
                RelativeLayout layout = new RelativeLayout(mexpandedactivity);
                layout.setOnTouchListener(new OnTouchListener() {
                    public boolean onTouch(View arg0, MotionEvent arg1) {
                        return true;
                    }
                });
                layout.setBackgroundColor(-16777216);
                contentView.addView(layout, new RelativeLayout.LayoutParams(-1, -1));
                layout.addView(this.audioplayer);
                this.audioplayer.setBackGroundLayout(layout);
                this.audioplayer.requestFocus();
                this.audioplayer.setOnKeyListener(new OnKeyListener() {
                    public boolean onKey(View arg0, int keyValue, KeyEvent keyEvent) {
                        if (4 != keyEvent.getKeyCode() || keyEvent.getAction() != 0) {
                            return false;
                        }
                        if (Constants.DEBUG) {
                            Log.d(Constants.LOGGING_TAG, "Back Button pressed while fullscreen audio is playing ");
                        }
                        IMWebView.this.audioplayer.releasePlayer(true);
                        return true;
                    }
                });
            } else {
                this.audioplayer.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
                contentView.addView(this.audioplayer);
            }
            this.audioplayer.setListener(new AVPlayerListener() {
                public void onPrepared(AVPlayer curaudioplayer) {
                }

                public void onError(AVPlayer curaudioplayer) {
                    onComplete(curaudioplayer);
                }

                public void onComplete(AVPlayer curaudioplayer) {
                    try {
                        if (properties.isFullScreen()) {
                            ViewGroup parent = (ViewGroup) curaudioplayer.getBackGroundLayout().getParent();
                            if (parent != null) {
                                parent.removeView(curaudioplayer.getBackGroundLayout());
                                return;
                            }
                            return;
                        }
                        ViewGroup parent2 = (ViewGroup) curaudioplayer.getParent();
                        if (parent2 != null) {
                            parent2.removeView(curaudioplayer);
                        }
                    } catch (Exception e) {
                        if (Constants.DEBUG) {
                            Log.d(Constants.LOGGING_TAG, "Problem removing the audio relativelayout");
                        }
                    }
                }
            });
            this.audioplayer.play();
        }
    }

    public void playAudio(String url, boolean autoPlay, boolean controls, boolean loop, String startStyle, String stopStyle, String id) {
        synchronized (this.mutex) {
            if (this.isMutexAquired.get()) {
                try {
                    this.mutex.wait();
                } catch (InterruptedException e) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "mutex failed " + e);
                    }
                }
            }
        }
        if (this.mIsInterstitialAd || this.mViewState == ViewState.EXPANDED) {
            PlayerProperties properties = new PlayerProperties();
            properties.setProperties(false, autoPlay, controls, loop, startStyle, stopStyle, id);
            Bundle data = new Bundle();
            data.putString(EXPAND_URL, url);
            data.putParcelable(PLAYER_PROPERTIES, properties);
            Message msg = this.mHandler.obtainMessage(MESSAGE_PLAY_AUDIO);
            msg.setData(data);
            this.mHandler.sendMessage(msg);
            return;
        }
        raiseError(ERR_AUDIO_STATE, "playAudio");
    }

    public void pauseAudio(String id) {
        AVPlayer aplayer = getCurrentAudioPlayer(id);
        if (aplayer == null) {
            raiseError(ERR_INVALID_PID, "pauseAudio");
        } else if (aplayer.getState() != playerState.PLAYING) {
            raiseError(ERR_INVALID_STATE, "pauseAudio");
        } else if (aplayer.isPlaying()) {
            Message msg = this.mHandler.obtainMessage(MESSAGE_PAUSE_AUDIO);
            Bundle data = new Bundle();
            data.putString(AUDIO_PLAYER_REF, id);
            msg.setData(data);
            msg.sendToTarget();
        }
    }

    public void muteAudio(String pid) {
        AVPlayer aplayer = getCurrentAudioPlayer(pid);
        if (aplayer == null) {
            raiseError(ERR_INVALID_PID, "muteAudio");
        } else if (aplayer.getState() == playerState.RELEASED) {
            raiseError(ERR_INVALID_STATE, "muteAudio");
        } else {
            Message msg = this.mHandler.obtainMessage(MESSAGE_MUTE_AUDIO);
            Bundle data = new Bundle();
            data.putString(AUDIO_PLAYER_REF, pid);
            msg.setData(data);
            msg.sendToTarget();
        }
    }

    public void unMuteAudio(String pid) {
        AVPlayer aplayer = getCurrentAudioPlayer(pid);
        if (aplayer == null) {
            raiseError(ERR_INVALID_PID, "unmuteAudio");
        } else if (aplayer.getState() == playerState.RELEASED) {
            raiseError(ERR_INVALID_STATE, "unmuteAudio");
        } else {
            Message msg = this.mHandler.obtainMessage(MESSAGE_UNMUTE_AUDIO);
            Bundle data = new Bundle();
            data.putString(AUDIO_PLAYER_REF, pid);
            msg.setData(data);
            msg.sendToTarget();
        }
    }

    public boolean isAudioMuted(String pid) {
        AVPlayer aplayer = getCurrentAudioPlayer(pid);
        if (aplayer != null) {
            return aplayer.isMediaMuted();
        }
        raiseError(ERR_INVALID_PID, "isAudioMuted");
        return false;
    }

    public void setAudioVolume(String pid, int volume) {
        if (getCurrentAudioPlayer(pid) == null) {
            raiseError(ERR_INVALID_PID, "setAudioVolume");
            return;
        }
        Message msg = this.mHandler.obtainMessage(MESSAGE_SET_AUDIOVOLUME);
        Bundle data = new Bundle();
        data.putInt(AUDIO_VOLUME, volume);
        data.putString(AUDIO_PLAYER_REF, pid);
        msg.setData(data);
        msg.sendToTarget();
    }

    public int getAudioVolume(String pid) {
        AVPlayer aplayer = getCurrentAudioPlayer(pid);
        if (aplayer != null) {
            return aplayer.getVolume();
        }
        raiseError(ERR_INVALID_PID, "getAudioVolume");
        return -1;
    }

    public void seekAudio(String pid, int seekPos) {
        AVPlayer aplayer = getCurrentAudioPlayer(pid);
        if (aplayer == null) {
            raiseError(ERR_INVALID_PID, "seekAudio");
        } else if (aplayer.getState() == playerState.RELEASED) {
            raiseError(ERR_INVALID_STATE, "seekAudio");
        } else {
            Message msg = this.mHandler.obtainMessage(MESSAGE_SEEK_AUDIO);
            Bundle data = new Bundle();
            data.putInt(SEEK_AUDIO, seekPos);
            msg.setData(data);
            msg.obj = aplayer;
            msg.sendToTarget();
        }
    }

    public void playVideoImpl(Bundle data, Activity mexpandedactivity) {
        PlayerProperties properties = (PlayerProperties) data.getParcelable(PLAYER_PROPERTIES);
        Dimensions d = (Dimensions) data.getParcelable(DIMENSIONS);
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Final dimensions: " + d);
        }
        String url = data.getString(EXPAND_URL);
        if (getVideoPlayer(properties.id, url, mexpandedactivity, d)) {
            this.isBusy = true;
            if (url.length() == 0) {
                properties = this.videoPlayer.getProperties();
                d = this.videoPlayer.getPlayDimensions();
                String url2 = this.videoPlayer.getMediaURL();
            } else {
                this.videoPlayer.setPlayData(properties, url);
                this.videoPlayer.setPlayDimensions(d);
            }
            FrameLayout contentView = (FrameLayout) getRootView().findViewById(16908290);
            if (properties.isFullScreen()) {
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-1, -1);
                lp.addRule(13);
                this.videoPlayer.setLayoutParams(lp);
                RelativeLayout layout = new RelativeLayout(mexpandedactivity);
                layout.setOnTouchListener(new OnTouchListener() {
                    public boolean onTouch(View arg0, MotionEvent arg1) {
                        return true;
                    }
                });
                layout.setBackgroundColor(-16777216);
                contentView.addView(layout, new LayoutParams(-1, -1));
                layout.addView(this.videoPlayer);
                this.videoPlayer.setBackGroundLayout(layout);
                this.videoPlayer.requestFocus();
                this.videoPlayer.setOnKeyListener(new OnKeyListener() {
                    public boolean onKey(View arg0, int keyValue, KeyEvent keyEvent) {
                        if (4 != keyEvent.getKeyCode() || keyEvent.getAction() != 0) {
                            return false;
                        }
                        if (Constants.DEBUG) {
                            Log.d(Constants.LOGGING_TAG, "Back Button pressed while fullscreen video is playing ");
                        }
                        IMWebView.this.videoPlayer.releasePlayer(true);
                        return true;
                    }
                });
            } else {
                this.videoPlayer.setLayoutParams(new LayoutParams(d.width, d.height));
                FrameLayout backGround = new FrameLayout(mexpandedactivity);
                if (this.expandProperties == null) {
                    backGround.setPadding(d.x, d.y, 0, 0);
                } else {
                    backGround.setPadding(d.x + this.expandProperties.currentX, d.y + this.expandProperties.currentY, 0, 0);
                }
                contentView.addView(backGround, new LayoutParams(-1, -1));
                this.videoPlayer.setBackGroundLayout(backGround);
                backGround.addView(this.videoPlayer);
            }
            this.videoPlayer.setListener(new AVPlayerListener() {
                public void onPrepared(AVPlayer curvideoplayer) {
                }

                public void onError(AVPlayer curvideoplayer) {
                    onComplete(curvideoplayer);
                }

                public void onComplete(AVPlayer curvideoplayer) {
                    IMWebView.this.isBusy = false;
                    try {
                        ViewGroup parent = (ViewGroup) curvideoplayer.getBackGroundLayout().getParent();
                        if (parent != null) {
                            parent.removeView(curvideoplayer.getBackGroundLayout());
                        }
                        curvideoplayer.setBackGroundLayout(null);
                    } catch (Exception e) {
                        if (Constants.DEBUG) {
                            Log.d(Constants.LOGGING_TAG, "Problem removing the video framelayout or relativelayout depending on video startstyle");
                        }
                    }
                    synchronized (this) {
                        if (IMWebView.this.videoPlayer != null && curvideoplayer.getPropertyID().equalsIgnoreCase(IMWebView.this.videoPlayer.getPropertyID())) {
                            IMWebView.this.videoPlayer = null;
                        }
                    }
                }
            });
            this.videoPlayer.play();
        }
    }

    public void playVideo(String url, boolean audioMuted, boolean autoPlay, boolean controls, boolean loop, Dimensions d, String startStyle, String stopStyle, String id) {
        synchronized (this.mutex) {
            if (this.isMutexAquired.get()) {
                try {
                    this.mutex.wait();
                } catch (InterruptedException e) {
                    if (Constants.DEBUG) {
                        Log.d(Constants.LOGGING_TAG, "mutex failed " + e);
                    }
                }
            }
        }
        if (!this.mIsInterstitialAd && this.mViewState != ViewState.EXPANDED) {
            raiseError(ERR_VIDEO_STATE, "playVideo");
        } else if (this.videoPlayerList.isEmpty() || this.videoPlayerList.size() != 5 || this.videoPlayerList.containsKey(id)) {
            Message msg = this.mHandler.obtainMessage(MESSAGE_PLAY_VIDEO);
            PlayerProperties properties = new PlayerProperties();
            properties.setProperties(audioMuted, autoPlay, controls, loop, startStyle, stopStyle, id);
            Bundle data = new Bundle();
            data.putString(EXPAND_URL, url);
            data.putParcelable(PLAYER_PROPERTIES, properties);
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "Before validation dimension: (" + d.x + ", " + d.y + ", " + d.width + ", " + d.height + ")");
            }
            validateVideoDimensions(d);
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "After validation dimension: (" + d.x + ", " + d.y + ", " + d.width + ", " + d.height + ")");
            }
            data.putParcelable(DIMENSIONS, d);
            msg.setData(data);
            this.mHandler.sendMessage(msg);
        } else {
            raiseError(ERR_HIDDEN_PLAYER_LIMIT, "playVideo");
        }
    }

    public void pauseVideo(String pid) {
        Message msg = this.mHandler.obtainMessage(MESSAGE_PAUSE_VIDEO);
        Bundle data = new Bundle();
        data.putString(PROPERTY_ID, pid);
        msg.setData(data);
        this.mHandler.sendMessage(msg);
    }

    public void closeVideo(String pid) {
        AVPlayer player = getVideoPlayer(pid);
        if (player == null) {
            raiseError(ERR_INVALID_PID, "closeVideo");
        } else if (player.getState() == playerState.RELEASED) {
            raiseError(ERR_INVALID_STATE, "closeVideo");
        } else {
            this.videoPlayerList.remove(pid);
            Message msg = this.mHandler.obtainMessage(MESSAGE_CLOSE_VIDEO);
            msg.obj = player;
            this.mHandler.sendMessage(msg);
        }
    }

    public void hideVideo(String pid) {
        Message msg = this.mHandler.obtainMessage(MESSAGE_HIDE_VIDEO);
        Bundle data = new Bundle();
        data.putString(PROPERTY_ID, pid);
        msg.setData(data);
        this.mHandler.sendMessage(msg);
    }

    public void showVideo(String pid) {
        Message msg = this.mHandler.obtainMessage(MESSAGE_SHOW_VIDEO);
        Bundle data = new Bundle();
        data.putString(PROPERTY_ID, pid);
        msg.setData(data);
        this.mHandler.sendMessage(msg);
    }

    public void muteVideo(String pid) {
        AVPlayer player = getVideoPlayer(pid);
        if (player == null) {
            raiseError(ERR_INVALID_PID, "muteVideo");
        } else if (player.getState() == playerState.RELEASED || player.getState() == playerState.INIT) {
            raiseError(ERR_INVALID_STATE, "muteVideo");
        } else {
            Message msg = this.mHandler.obtainMessage(MESSAGE_MUTE_VIDEO);
            msg.obj = player;
            this.mHandler.sendMessage(msg);
        }
    }

    public void unMuteVideo(String pid) {
        AVPlayer player = getVideoPlayer(pid);
        if (player == null) {
            raiseError(ERR_INVALID_PID, "unMuteVideo");
        } else if (player.getState() == playerState.RELEASED || player.getState() == playerState.INIT) {
            raiseError(ERR_INVALID_STATE, "unMuteVideo");
        } else {
            Message msg = this.mHandler.obtainMessage(MESSAGE_UNMUTE_VIDEO);
            msg.obj = player;
            this.mHandler.sendMessage(msg);
        }
    }

    public void seekVideo(String pid, int seekPos) {
        AVPlayer player = getVideoPlayer(pid);
        if (player == null) {
            raiseError(ERR_INVALID_PID, "seekVideo");
        } else if (player.getState() == playerState.RELEASED || player.getState() == playerState.INIT) {
            raiseError(ERR_INVALID_STATE, "seekVideo");
        } else {
            Message msg = this.mHandler.obtainMessage(MESSAGE_SEEK_VIDEO);
            Bundle data = new Bundle();
            data.putInt(SEEK_POSITION, seekPos);
            msg.setData(data);
            msg.obj = player;
            this.mHandler.sendMessage(msg);
        }
    }

    public boolean isVideoMuted(String pid) {
        AVPlayer player = getVideoPlayer(pid);
        if (player != null) {
            return player.isMediaMuted();
        }
        raiseError(ERR_INVALID_PID, "isVideoMuted");
        return false;
    }

    public void setVideoVolume(String pid, int volume) {
        AVPlayer player = getVideoPlayer(pid);
        if (player == null) {
            raiseError(ERR_INVALID_PID, "setVideoVolume");
        } else if (player.getState() == playerState.RELEASED) {
            raiseError(ERR_INVALID_STATE, "setVideoVolume");
        } else {
            Message msg = this.mHandler.obtainMessage(MESSAGE_SET_VIDEOVOLUME);
            Bundle data = new Bundle();
            data.putInt(VIDEO_VOLUME, volume);
            msg.setData(data);
            msg.obj = player;
            this.mHandler.sendMessage(msg);
        }
    }

    public int getVideoVolume(String pid) {
        AVPlayer player = getVideoPlayer(pid);
        if (player != null) {
            return player.getVolume();
        }
        raiseError(ERR_INVALID_PID, "getVideoVolume");
        return -1;
    }

    private void validateVideoDimensions(Dimensions d) {
        d.width = (int) (((float) d.width) * this.mDensity);
        d.height = (int) (((float) d.height) * this.mDensity);
        d.x = (int) (((float) d.x) * this.mDensity);
        d.y = (int) (((float) d.y) * this.mDensity);
        int closebuttonheight = (int) (this.mDensity * 50.0f);
        int closebuttonwidth = this.videoValidateWidth - ((int) (this.mDensity * 50.0f));
        boolean flag = false;
        if (d.width <= 0 || d.height <= 0) {
            d.width = 1;
            d.height = 1;
            flag = true;
        }
        if (!flag && d.x + d.width > closebuttonwidth && d.x < closebuttonwidth && d.y < closebuttonheight && d.y + d.height > closebuttonheight) {
            d.y = closebuttonheight;
        }
    }

    public void changeContentAreaForInterstitials() {
        try {
            handleOrientationForInterstitial();
            Intent intent = new Intent(this.mActivity, IMBrowserActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("INTERSTITIAL_CUSTOM_CLOSE", getCustomClose());
            if (this.lockOrientationValueForInterstitial) {
                bundle.putString("INTERSTITIAL_ORIENTATION", this.orientationValueForInterstitial);
            } else {
                bundle.putString("INTERSTITIAL_ORIENTATION", "notlock");
            }
            bundle.putInt("INTERSTTIAL_BACKGROUND_ID", INT_BACKGROUND_ID);
            bundle.putInt("INTERSTITIAL_CLOSE_ID", INT_CLOSE_BUTTON);
            intent.putExtras(bundle);
            IMBrowserActivity.setIntWebView(this);
            this.mActivity.startActivity(intent);
        } catch (Exception e) {
            if (Constants.DEBUG) {
                Log.d(Constants.LOGGING_TAG, "changeContentAreaForInterstitial " + e);
                e.printStackTrace();
            }
        }
    }

    public void setExpandPropertiesForInterstitial(boolean ucustomClose, boolean lockorientation, String orient) {
        setCustomClose(ucustomClose);
        this.lockOrientationValueForInterstitial = lockorientation;
        this.orientationValueForInterstitial = orient;
        if (this.mWebViewIsBrowserActivity) {
            handleOrientationFor2Piece();
        }
    }

    private void handleOrientationForInterstitial() {
        getIntegerCurrentRotation();
        int publisherOrientationValueInterstitial = this.mActivity.getRequestedOrientation();
        if (!this.lockOrientationValueForInterstitial && publisherOrientationValueInterstitial == -1) {
            this.sensorCurOrientation = -5;
            this.sensorOldOrientation = -5;
            this.sensorFirstExpand = -5;
            this.mSensorManager.registerListener(this.sensorEventListener, this.mOrientationSensor, 3);
        }
    }

    private void handleOrientationFor2Piece() {
        int tempCurRotation = getIntegerCurrentRotation();
        if (!this.lockOrientationValueForInterstitial) {
            return;
        }
        if (this.orientationValueForInterstitial.equals("portrait")) {
            if (tempCurRotation != 2 || VERSION.SDK_INT < 9) {
                this.mActivity.setRequestedOrientation(1);
            } else {
                this.mActivity.setRequestedOrientation(9);
            }
        } else if (!this.orientationValueForInterstitial.equals("landscape")) {
        } else {
            if (tempCurRotation != 3 || VERSION.SDK_INT < 9) {
                this.mActivity.setRequestedOrientation(0);
            } else {
                this.mActivity.setRequestedOrientation(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void resetContentsForInterstitials(Activity mexpandedactivity) {
        try {
            releaseAllPlayers();
            FrameLayout contentView = (FrameLayout) getRootView().findViewById(16908290);
            RelativeLayout rlParent = (RelativeLayout) contentView.findViewById(INT_BACKGROUND_ID);
            if (rlParent != null) {
                rlParent.removeView(this);
                contentView.removeView(rlParent);
            }
            if (mexpandedactivity instanceof IMBrowserActivity) {
                setExpandedActivity(this.mActivity);
                mexpandedactivity.finish();
            }
            if (this.mMsgOnInterstitialClosed != null) {
                this.mMsgOnInterstitialClosed.sendToTarget();
            }
        } catch (Exception e) {
            Log.w(Constants.LOGGING_TAG, "Exception while closing the Interstitial Ad", e);
        }
    }

    public void setExternalWebViewClient(WebViewClient webViewClient) {
        this.mExtWebViewClient = webViewClient;
    }

    private void resizeInlineVideo(AVPlayer player, Dimensions d) {
        int invalidDim = (int) (-99999.0f * this.mDensity);
        if (player.isInlineVideo() && d.x != invalidDim && d.y != invalidDim) {
            player.setLayoutParams(new LayoutParams(d.width, d.height));
            FrameLayout backGround = (FrameLayout) player.getBackGroundLayout();
            if (this.expandProperties == null) {
                backGround.setPadding(d.x, d.y, 0, 0);
            } else {
                backGround.setPadding(d.x + this.expandProperties.currentX, d.y + this.expandProperties.currentY, 0, 0);
            }
        }
    }

    public void doHidePlayers() {
        this.mHandler.sendEmptyMessage(MESSAGE_HIDE_PLAYERS);
    }

    public void fireOnLeaveApplication() {
        doHidePlayers();
        if (this.mListener != null) {
            this.mListener.onLeaveApplication();
        }
    }

    /* access modifiers changed from: private */
    public void hidePlayers() {
        if (!(this.videoPlayer == null || this.videoPlayer.getState() == playerState.RELEASED)) {
            this.videoPlayerList.put(this.videoPlayer.getPropertyID(), this.videoPlayer);
            this.videoPlayer.hide();
            this.videoPlayer.releasePlayer(false);
        }
        for (Entry<String, AVPlayer> item : this.audioPlayerList.entrySet()) {
            AVPlayer player = item.getValue();
            switch ($SWITCH_TABLE$com$inmobi$androidsdk$impl$Constants$playerState()[player.getState().ordinal()]) {
                case 1:
                    player.releasePlayer(false);
                    this.audioPlayerList.remove(item.getKey());
                    break;
                case 2:
                    player.pause();
                    break;
            }
        }
    }
}
