package com.inmobi.androidsdk.ai.controller;

import android.content.Context;
import android.os.StatFs;
import android.util.Log;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.androidsdk.impl.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.jar.JarFile;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class JSAssetController extends JSController {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public JSAssetController(IMWebView adView, Context c) {
        super(adView, c);
    }

    public String copyTextFromJarIntoAssetDir(String alias, String source) {
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
            String name = writeToDisk(in2, alias, false);
            if (in2 == null) {
                return name;
            }
            try {
                in2.close();
            } catch (Exception e) {
            }
            return name;
        } catch (Exception e2) {
            e2.printStackTrace();
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

    public void addAsset(String alias, String url) {
        HttpEntity entity = getHttpEntity(url);
        InputStream in = null;
        try {
            in = entity.getContent();
            writeToDisk(in, alias, false);
            this.imWebView.injectJavaScript("mraidAdController.addedAsset('" + alias + "' )");
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
        try {
            entity.consumeContent();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private HttpEntity getHttpEntity(String url) {
        try {
            return new DefaultHttpClient().execute(new HttpGet(url)).getEntity();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int cacheRemaining() {
        StatFs stats = new StatFs(this.mContext.getFilesDir().getPath());
        return stats.getFreeBlocks() * stats.getBlockSize();
    }

    public String writeToDisk(InputStream in, String file, boolean storeInHashedDirectory) throws IllegalStateException, IOException {
        byte[] buff = new byte[1024];
        MessageDigest digest = null;
        if (storeInHashedDirectory) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream out = null;
        try {
            out = getAssetOutputString(file);
            while (true) {
                int numread = in.read(buff);
                if (numread <= 0) {
                    break;
                }
                if (storeInHashedDirectory && digest != null) {
                    digest.update(buff);
                }
                out.write(buff, 0, numread);
            }
            out.flush();
            String filesDir = getFilesDir();
            if (storeInHashedDirectory && digest != null) {
                filesDir = moveToAdDirectory(file, filesDir, asHex(digest));
            }
            return String.valueOf(filesDir) + file;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e2) {
                }
            }
        }
    }

    public String writeToDiskWrap(InputStream in, String file, boolean storeInHashedDirectory, String injection, String bridgePath, String mraidPath) throws IllegalStateException, IOException {
        byte[] buff = new byte[1024];
        MessageDigest digest = null;
        if (storeInHashedDirectory) {
            try {
                digest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        ByteArrayOutputStream fromFile = new ByteArrayOutputStream();
        FileOutputStream out = null;
        while (true) {
            try {
                int numread = in.read(buff);
                if (numread <= 0) {
                    break;
                }
                if (storeInHashedDirectory && digest != null) {
                    digest.update(buff);
                }
                fromFile.write(buff, 0, numread);
            } finally {
                if (fromFile != null) {
                    try {
                        fromFile.close();
                    } catch (Exception e2) {
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (Exception e3) {
                    }
                }
            }
        }
        String wholeHTML = fromFile.toString();
        boolean hasHTMLWrap = wholeHTML.indexOf("<html") >= 0;
        StringBuffer wholeHTMLBuffer = null;
        if (hasHTMLWrap) {
            wholeHTMLBuffer = new StringBuffer(wholeHTML);
            int start = wholeHTMLBuffer.indexOf("/mraid_bridge.js");
            wholeHTMLBuffer.replace(start, "/mraid_bridge.js".length() + start, "file:/" + bridgePath);
            int start2 = wholeHTMLBuffer.indexOf("/mraid.js");
            wholeHTMLBuffer.replace(start2, "/mraid.js".length() + start2, "file:/" + mraidPath);
        }
        out = getAssetOutputString(file);
        if (!hasHTMLWrap) {
            out.write("<html>".getBytes());
            out.write("<head>".getBytes());
            out.write("<meta name='viewport' content='user-scalable=no initial-scale=1.0' />".getBytes());
            out.write("<title>Advertisement</title> ".getBytes());
            out.write(("<script src=\"file:/" + bridgePath + "\" type=\"text/javascript\"></script>").getBytes());
            out.write(("<script src=\"file:/" + mraidPath + "\" type=\"text/javascript\"></script>").getBytes());
            if (injection != null) {
                out.write("<script type=\"text/javascript\">".getBytes());
                out.write(injection.getBytes());
                out.write("</script>".getBytes());
            }
            out.write("</head>".getBytes());
            out.write("<body style=\"margin:0; padding:0; overflow:hidden; background-color:transparent;\">".getBytes());
            out.write("<div align=\"center\"> ".getBytes());
        }
        if (!hasHTMLWrap) {
            out.write(fromFile.toByteArray());
        } else {
            out.write(wholeHTMLBuffer.toString().getBytes());
        }
        if (!hasHTMLWrap) {
            out.write("</div> ".getBytes());
            out.write("</body> ".getBytes());
            out.write("</html> ".getBytes());
        }
        out.flush();
        String filesDir = getFilesDir();
        if (!storeInHashedDirectory || digest == null) {
            return filesDir;
        }
        return moveToAdDirectory(file, filesDir, asHex(digest));
    }

    private String moveToAdDirectory(String fn, String filesDir, String subDir) {
        File file = new File(String.valueOf(filesDir) + File.separator + fn);
        new File(String.valueOf(filesDir) + File.separator + "ad").mkdir();
        File dir = new File(String.valueOf(filesDir) + File.separator + "ad" + File.separator + subDir);
        dir.mkdir();
        file.renameTo(new File(dir, file.getName()));
        return String.valueOf(dir.getPath()) + File.separator;
    }

    private String asHex(MessageDigest digest) {
        byte[] hash = digest.digest();
        char[] buf = new char[(hash.length * 2)];
        int x = 0;
        for (int i = 0; i < hash.length; i++) {
            int x2 = x + 1;
            buf[x] = HEX_CHARS[(hash[i] >>> 4) & 15];
            x = x2 + 1;
            buf[x2] = HEX_CHARS[hash[i] & 15];
        }
        return new String(buf);
    }

    private String getFilesDir() {
        return this.mContext.getFilesDir().getPath();
    }

    public FileOutputStream getAssetOutputString(String asset) throws FileNotFoundException {
        File dir = getAssetDir(getAssetPath(asset));
        dir.mkdirs();
        return new FileOutputStream(new File(dir, getAssetName(asset)));
    }

    public void removeAsset(String asset) {
        File dir = getAssetDir(getAssetPath(asset));
        dir.mkdirs();
        new File(dir, getAssetName(asset)).delete();
        this.imWebView.injectJavaScript("mraidAdController.assetRemoved('" + asset + "' )");
    }

    private File getAssetDir(String path) {
        File filesDir = this.mContext.getFilesDir();
        if (Constants.DEBUG) {
            Log.d(Constants.LOGGING_TAG, "Tmp File dir: " + filesDir);
        }
        return new File(String.valueOf(filesDir.getPath()) + File.separator + path);
    }

    private String getAssetPath(String asset) {
        if (asset.lastIndexOf(File.separatorChar) >= 0) {
            return asset.substring(0, asset.lastIndexOf(File.separatorChar));
        }
        return "/";
    }

    private String getAssetName(String asset) {
        String name = asset;
        if (asset.lastIndexOf(File.separatorChar) >= 0) {
            return asset.substring(asset.lastIndexOf(File.separatorChar) + 1);
        }
        return name;
    }

    public String getAssetPath() {
        return "file://" + this.mContext.getFilesDir() + "/";
    }

    public static boolean deleteDirectory(String path) {
        if (path != null) {
            return deleteDirectory(new File(path));
        }
        return false;
    }

    public static boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return path.delete();
    }

    public void deleteOldAds() {
        deleteDirectory(new File(String.valueOf(getFilesDir()) + File.separator + "ad"));
    }

    public void stopAllListeners() {
    }
}
