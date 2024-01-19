package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.listener.BaseRequestListener;

public class ImageOriginRequestListener extends BaseRequestListener {
    public String mControllerId;
    public final ImageOriginListener mImageOriginLister;

    public ImageOriginRequestListener(String str, ImageOriginListener imageOriginListener) {
        this.mImageOriginLister = imageOriginListener;
        this.mControllerId = str;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUltimateProducerReached(java.lang.String r9, java.lang.String r10, boolean r11) {
        /*
            r8 = this;
            com.facebook.drawee.backends.pipeline.info.ImageOriginListener r9 = r8.mImageOriginLister
            if (r9 == 0) goto L_0x00c7
            java.lang.String r0 = r8.mControllerId
            int r1 = r10.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 6
            r7 = 1
            switch(r1) {
                case -1917159454: goto L_0x00ac;
                case -1914072202: goto L_0x00a2;
                case -1683996557: goto L_0x0097;
                case -1579985851: goto L_0x008c;
                case -1307634203: goto L_0x0082;
                case -1224383234: goto L_0x0078;
                case 473552259: goto L_0x006d;
                case 656304759: goto L_0x0063;
                case 957714404: goto L_0x0059;
                case 1019542023: goto L_0x004e;
                case 1023071510: goto L_0x0043;
                case 1721672898: goto L_0x0038;
                case 1793127518: goto L_0x002c;
                case 2109593398: goto L_0x0021;
                case 2113652014: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x00b7
        L_0x0015:
            java.lang.String r1 = "LocalContentUriFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 9
            goto L_0x00b8
        L_0x0021:
            java.lang.String r1 = "PartialDiskCacheProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 5
            goto L_0x00b8
        L_0x002c:
            java.lang.String r1 = "LocalContentUriThumbnailFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 10
            goto L_0x00b8
        L_0x0038:
            java.lang.String r1 = "DataFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 7
            goto L_0x00b8
        L_0x0043:
            java.lang.String r1 = "PostprocessedBitmapMemoryCacheProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 2
            goto L_0x00b8
        L_0x004e:
            java.lang.String r1 = "LocalAssetFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 8
            goto L_0x00b8
        L_0x0059:
            java.lang.String r1 = "BitmapMemoryCacheProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 1
            goto L_0x00b8
        L_0x0063:
            java.lang.String r1 = "DiskCacheProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 4
            goto L_0x00b8
        L_0x006d:
            java.lang.String r1 = "VideoThumbnailProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 13
            goto L_0x00b8
        L_0x0078:
            java.lang.String r1 = "NetworkFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 6
            goto L_0x00b8
        L_0x0082:
            java.lang.String r1 = "EncodedMemoryCacheProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 3
            goto L_0x00b8
        L_0x008c:
            java.lang.String r1 = "LocalFileFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 11
            goto L_0x00b8
        L_0x0097:
            java.lang.String r1 = "LocalResourceFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 12
            goto L_0x00b8
        L_0x00a2:
            java.lang.String r1 = "BitmapMemoryCacheGetProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 0
            goto L_0x00b8
        L_0x00ac:
            java.lang.String r1 = "QualifiedResourceFetchProducer"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x00b7
            r1 = 14
            goto L_0x00b8
        L_0x00b7:
            r1 = -1
        L_0x00b8:
            switch(r1) {
                case 0: goto L_0x00c4;
                case 1: goto L_0x00c4;
                case 2: goto L_0x00c4;
                case 3: goto L_0x00c3;
                case 4: goto L_0x00c1;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00bf;
                case 7: goto L_0x00bd;
                case 8: goto L_0x00bd;
                case 9: goto L_0x00bd;
                case 10: goto L_0x00bd;
                case 11: goto L_0x00bd;
                case 12: goto L_0x00bd;
                case 13: goto L_0x00bd;
                case 14: goto L_0x00bd;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            r2 = 1
            goto L_0x00c4
        L_0x00bd:
            r2 = 6
            goto L_0x00c4
        L_0x00bf:
            r2 = 2
            goto L_0x00c4
        L_0x00c1:
            r2 = 3
            goto L_0x00c4
        L_0x00c3:
            r2 = 4
        L_0x00c4:
            r9.onImageLoaded(r0, r2, r11, r10)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener.onUltimateProducerReached(java.lang.String, java.lang.String, boolean):void");
    }
}
