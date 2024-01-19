package org.apache.pdfbox.pdmodel.interactive.viewerpreferences;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDViewerPreferences implements COSObjectable {
    public static final String BOUNDARY_ART_BOX = "ArtBox";
    public static final String BOUNDARY_BLEED_BOX = "BleedBox";
    public static final String BOUNDARY_CROP_BOX = "CropBox";
    public static final String BOUNDARY_MEDIA_BOX = "MediaBox";
    public static final String BOUNDARY_TRIM_BOX = "TrimBox";
    public static final String NON_FULL_SCREEN_PAGE_MODE_USE_NONE = "UseNone";
    public static final String NON_FULL_SCREEN_PAGE_MODE_USE_OPTIONAL_CONTENT = "UseOC";
    public static final String NON_FULL_SCREEN_PAGE_MODE_USE_OUTLINES = "UseOutlines";
    public static final String NON_FULL_SCREEN_PAGE_MODE_USE_THUMBS = "UseThumbs";
    public static final String READING_DIRECTION_L2R = "L2R";
    public static final String READING_DIRECTION_R2L = "R2L";
    public COSDictionary prefs;

    public enum BOUNDARY {
        MediaBox,
        CropBox,
        BleedBox,
        TrimBox,
        ArtBox
    }

    public enum DUPLEX {
        Simplex,
        DuplexFlipShortEdge,
        DuplexFlipLongEdge
    }

    public enum NON_FULL_SCREEN_PAGE_MODE {
        UseNone,
        UseOutlines,
        UseThumbs,
        UseOC
    }

    public enum PRINT_SCALING {
        None,
        AppDefault
    }

    public enum READING_DIRECTION {
        L2R,
        R2L
    }

    public PDViewerPreferences(COSDictionary cOSDictionary) {
        this.prefs = cOSDictionary;
    }

    public boolean centerWindow() {
        return this.prefs.getBoolean(COSName.CENTER_WINDOW, false);
    }

    public boolean displayDocTitle() {
        return this.prefs.getBoolean(COSName.DISPLAY_DOC_TITLE, false);
    }

    public boolean fitWindow() {
        return this.prefs.getBoolean(COSName.FIT_WINDOW, false);
    }

    public COSBase getCOSObject() {
        return this.prefs;
    }

    public COSDictionary getDictionary() {
        return this.prefs;
    }

    public String getDuplex() {
        return this.prefs.getNameAsString(COSName.DUPLEX);
    }

    public String getNonFullScreenPageMode() {
        return this.prefs.getNameAsString(COSName.NON_FULL_SCREEN_PAGE_MODE, NON_FULL_SCREEN_PAGE_MODE.UseNone.toString());
    }

    public String getPrintArea() {
        return this.prefs.getNameAsString(COSName.PRINT_AREA, BOUNDARY.CropBox.toString());
    }

    public String getPrintClip() {
        return this.prefs.getNameAsString(COSName.PRINT_CLIP, BOUNDARY.CropBox.toString());
    }

    public String getPrintScaling() {
        return this.prefs.getNameAsString(COSName.PRINT_SCALING, PRINT_SCALING.AppDefault.toString());
    }

    public String getReadingDirection() {
        return this.prefs.getNameAsString(COSName.DIRECTION, READING_DIRECTION.L2R.toString());
    }

    public String getViewArea() {
        return this.prefs.getNameAsString(COSName.VIEW_AREA, BOUNDARY.CropBox.toString());
    }

    public String getViewClip() {
        return this.prefs.getNameAsString(COSName.VIEW_CLIP, BOUNDARY.CropBox.toString());
    }

    public boolean hideMenubar() {
        return this.prefs.getBoolean(COSName.HIDE_MENUBAR, false);
    }

    public boolean hideToolbar() {
        return this.prefs.getBoolean(COSName.HIDE_TOOLBAR, false);
    }

    public boolean hideWindowUI() {
        return this.prefs.getBoolean(COSName.HIDE_WINDOWUI, false);
    }

    public void setCenterWindow(boolean z) {
        this.prefs.setBoolean(COSName.CENTER_WINDOW, z);
    }

    public void setDisplayDocTitle(boolean z) {
        this.prefs.setBoolean(COSName.DISPLAY_DOC_TITLE, z);
    }

    public void setDuplex(DUPLEX duplex) {
        this.prefs.setName(COSName.DUPLEX, duplex.toString());
    }

    public void setFitWindow(boolean z) {
        this.prefs.setBoolean(COSName.FIT_WINDOW, z);
    }

    public void setHideMenubar(boolean z) {
        this.prefs.setBoolean(COSName.HIDE_MENUBAR, z);
    }

    public void setHideToolbar(boolean z) {
        this.prefs.setBoolean(COSName.HIDE_TOOLBAR, z);
    }

    public void setHideWindowUI(boolean z) {
        this.prefs.setBoolean(COSName.HIDE_WINDOWUI, z);
    }

    public void setNonFullScreenPageMode(NON_FULL_SCREEN_PAGE_MODE non_full_screen_page_mode) {
        this.prefs.setName(COSName.NON_FULL_SCREEN_PAGE_MODE, non_full_screen_page_mode.toString());
    }

    public void setPrintArea(String str) {
        this.prefs.setName(COSName.PRINT_AREA, str);
    }

    public void setPrintClip(String str) {
        this.prefs.setName(COSName.PRINT_CLIP, str);
    }

    public void setPrintScaling(PRINT_SCALING print_scaling) {
        this.prefs.setName(COSName.PRINT_SCALING, print_scaling.toString());
    }

    public void setReadingDirection(READING_DIRECTION reading_direction) {
        this.prefs.setName(COSName.DIRECTION, reading_direction.toString());
    }

    public void setViewArea(String str) {
        this.prefs.setName(COSName.VIEW_AREA, str);
    }

    public void setViewClip(BOUNDARY boundary) {
        this.prefs.setName(COSName.VIEW_CLIP, boundary.toString());
    }

    public void setNonFullScreenPageMode(String str) {
        this.prefs.setName(COSName.NON_FULL_SCREEN_PAGE_MODE, str);
    }

    public void setPrintArea(BOUNDARY boundary) {
        this.prefs.setName(COSName.PRINT_AREA, boundary.toString());
    }

    public void setPrintClip(BOUNDARY boundary) {
        this.prefs.setName(COSName.PRINT_CLIP, boundary.toString());
    }

    public void setReadingDirection(String str) {
        this.prefs.setName(COSName.DIRECTION, str);
    }

    public void setViewArea(BOUNDARY boundary) {
        this.prefs.setName(COSName.VIEW_AREA, boundary.toString());
    }

    public void setViewClip(String str) {
        this.prefs.setName(COSName.VIEW_CLIP, str);
    }
}
