package com.mpl.androidapp.exception;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import org.eclipse.paho.client.mqttv3.util.Debug;

public class UnityExceptionHandler implements UncaughtExceptionHandler {
    public static UnityExceptionHandler S_mInstance = null;
    public static final String TAG = "UnityExceptionHandler";
    public String AndroidVersion;
    public String Board;
    public String Brand;
    public Context CurContext;
    public final HashMap<String, String> CustomParameters = new HashMap<>();
    public String Device;
    public String Display;
    public String FilePath;
    public String FingerPrint;
    public String Host;
    public String ID;
    public String Manufacturer;
    public String Model;
    public String PackageName;
    public String PhoneModel;
    public UncaughtExceptionHandler PreviousHandler;
    public String Product;
    public String Tags;
    public long Time;
    public String Type;
    public String User;
    public String VersionName;
    public ExceptionHandlerCallback exceptionCallback;
    public ICrashListener mCrashListener;

    public interface ExceptionHandlerCallback {
        void sendCrashMessage(String str);
    }

    public interface ICrashListener {
        void onFatalCrash(String str);

        void onNonFatalCrash(String str);
    }

    private String CreateCustomInfoString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.CustomParameters.keySet()) {
            GeneratedOutlineSupport.outline103(sb, next, " = ", this.CustomParameters.get(next), "\n");
        }
        return sb.toString();
    }

    private String CreateInformationString() {
        ReCollectInformation(this.CurContext);
        StringBuilder outline78 = GeneratedOutlineSupport.outline78("", "Version : ");
        outline78.append(this.VersionName);
        StringBuilder outline782 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline78.toString(), "\n"), "Package : ");
        outline782.append(this.PackageName);
        StringBuilder outline783 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline782.toString(), "\n"), "FilePath : ");
        outline783.append(this.FilePath);
        StringBuilder outline784 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline783.toString(), "\n"), EventsConstants.PROP_PHONE_MODEL);
        outline784.append(this.PhoneModel);
        StringBuilder outline785 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline784.toString(), "\n"), "Android Version : ");
        outline785.append(this.AndroidVersion);
        StringBuilder outline786 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline785.toString(), "\n"), "Board : ");
        outline786.append(this.Board);
        StringBuilder outline787 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline786.toString(), "\n"), "Brand : ");
        outline787.append(this.Brand);
        StringBuilder outline788 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline787.toString(), "\n"), "Device : ");
        outline788.append(this.Device);
        StringBuilder outline789 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline788.toString(), "\n"), "Display : ");
        outline789.append(this.Display);
        StringBuilder outline7810 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline789.toString(), "\n"), "Finger Print : ");
        outline7810.append(this.FingerPrint);
        StringBuilder outline7811 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7810.toString(), "\n"), "Manufacturer : ");
        outline7811.append(this.Manufacturer);
        StringBuilder outline7812 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7811.toString(), "\n"), "Host : ");
        outline7812.append(this.Host);
        StringBuilder outline7813 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7812.toString(), "\n"), "ID : ");
        outline7813.append(this.ID);
        StringBuilder outline7814 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7813.toString(), "\n"), "Model : ");
        outline7814.append(this.Model);
        StringBuilder outline7815 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7814.toString(), "\n"), "Product : ");
        outline7815.append(this.Product);
        StringBuilder outline7816 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7815.toString(), "\n"), "Tags : ");
        outline7816.append(this.Tags);
        StringBuilder outline7817 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7816.toString(), "\n"), "Time : ");
        outline7817.append(this.Time);
        StringBuilder outline7818 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7817.toString(), "\n"), "Type : ");
        outline7818.append(this.Type);
        StringBuilder outline7819 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7818.toString(), "\n"), "User : ");
        outline7819.append(this.User);
        StringBuilder outline7820 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7819.toString(), "\n"), "Total Internal memory : ");
        outline7820.append(getTotalInternalMemorySize());
        StringBuilder outline7821 = GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(outline7820.toString(), "\n"), "Available Internal memory : ");
        outline7821.append(getAvailableInternalMemorySize());
        return GeneratedOutlineSupport.outline50(outline7821.toString(), "\n");
    }

    private String[] GetErrorFileList() {
        File file = new File(GeneratedOutlineSupport.outline62(new StringBuilder(), this.FilePath, "/"));
        file.mkdir();
        return file.list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(".stacktrace");
            }
        });
    }

    private void ReCollectInformation(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.VersionName = packageInfo.versionName;
            this.PackageName = packageInfo.packageName;
            this.PhoneModel = Build.MODEL;
            this.AndroidVersion = VERSION.RELEASE;
            this.Board = Build.BOARD;
            this.Brand = Build.BRAND;
            this.Device = Build.DEVICE;
            this.Display = Build.DISPLAY;
            this.FingerPrint = Build.FINGERPRINT;
            this.Manufacturer = Build.MANUFACTURER;
            this.Host = Build.HOST;
            this.ID = Build.ID;
            this.Model = Build.MODEL;
            this.Product = Build.PRODUCT;
            this.Tags = Build.TAGS;
            this.Time = Build.TIME;
            this.Type = Build.TYPE;
            this.User = Build.USER;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void SaveAsFile(String str) {
        try {
            int nextInt = new Random().nextInt(99999);
            FileOutputStream openFileOutput = this.CurContext.openFileOutput("stack-" + nextInt + ".stacktrace", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
        } catch (Exception unused) {
        }
    }

    private void SendErrorMail(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        String outline52 = GeneratedOutlineSupport.outline52("Crash Body\n\n", str, "\n\n");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"postmaster@alocaly.com"});
        intent.putExtra("android.intent.extra.TEXT", outline52);
        intent.putExtra("android.intent.extra.SUBJECT", "Crash Subject");
        intent.setType("message/rfc822");
        context.startActivity(Intent.createChooser(intent, "Title:"));
    }

    private boolean bIsThereAnyErrorFile() {
        return GetErrorFileList().length > 0;
    }

    private long getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static UnityExceptionHandler getInstance() {
        if (S_mInstance == null) {
            S_mInstance = new UnityExceptionHandler();
        }
        return S_mInstance;
    }

    private long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public void AddCustomData(String str, String str2) {
        this.CustomParameters.put(str, str2);
    }

    public void CheckErrorAndSendMail(Context context) {
        try {
            this.FilePath = context.getFilesDir().getAbsolutePath();
            if (bIsThereAnyErrorFile()) {
                StringBuilder sb = new StringBuilder();
                String[] GetErrorFileList = GetErrorFileList();
                int length = GetErrorFileList.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    String str = GetErrorFileList[i];
                    int i3 = i2 + 1;
                    if (i2 <= 5) {
                        sb.append("New Trace collected :\n");
                        sb.append("=====================\n ");
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.FilePath + "/" + str));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        }
                        bufferedReader.close();
                    }
                    new File(this.FilePath + "/" + str).delete();
                    i++;
                    i2 = i3;
                }
                SendErrorMail(context, sb.toString());
            }
        } catch (Exception unused) {
        }
    }

    public void Init(Context context, ExceptionHandlerCallback exceptionHandlerCallback) {
        this.exceptionCallback = exceptionHandlerCallback;
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.PreviousHandler = defaultUncaughtExceptionHandler;
        if (defaultUncaughtExceptionHandler != null) {
            defaultUncaughtExceptionHandler.hashCode();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.CurContext = context;
    }

    public void setCrashListener(ICrashListener iCrashListener) {
        this.mCrashListener = iCrashListener;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append("Error Report collected on : ");
        sb.append(date);
        sb.append("\n");
        sb.append("\n");
        sb.append("Information :");
        GeneratedOutlineSupport.outline103(sb, "\n", Debug.separator, "\n", "\n");
        GeneratedOutlineSupport.outline102(sb, CreateInformationString(), "Custom Information :\n", "=====================\n");
        sb.append(CreateCustomInfoString());
        sb.append("\n\n");
        sb.append("Stack : \n");
        sb.append("======= \n");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        sb.append(stringWriter.toString());
        sb.append("\n");
        sb.append("Cause : \n");
        sb.append("======= \n");
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
            sb.append(stringWriter);
        }
        printWriter.close();
        sb.append("****  End of current Report ***");
        ICrashListener iCrashListener = this.mCrashListener;
        if (iCrashListener != null) {
            iCrashListener.onFatalCrash(sb.toString());
        }
        SaveAsFile(sb.toString());
        ExceptionHandlerCallback exceptionHandlerCallback = this.exceptionCallback;
        if (exceptionHandlerCallback != null) {
            exceptionHandlerCallback.sendCrashMessage(th.getMessage());
        }
        this.PreviousHandler.uncaughtException(thread, th);
    }
}
