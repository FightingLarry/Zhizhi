package me.zhizhi.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

public class Utils {

    private static final String TAG = "Utils";

    public static final int IO_BUFFER_SIZE = 8 * 1024;

    public static String bytesToHexString(byte[] bytes) {
        // http://stackoverflow.com/questions/332079
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * Get the memory class of this device (approx. per-app memory limit)
     * 
     * @param context
     * @return
     */
    public static int getMemoryClass(Context context) {
        return ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
    }

    public static boolean hasFroyo() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasKitkat() {
        return Build.VERSION.SDK_INT >= 19/*Build.VERSION_CODES.KITKAT*/;
    }

    public static boolean hasIceCreamSandwich() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    /**
     * Get the size in bytes of a bitmap.
     * 
     * @param bitmap
     * @return size in bytes
     */
    @TargetApi(12)
    public static int getBitmapSize(Bitmap bitmap) {
        if (Utils.hasHoneycombMR1()) {
            return bitmap.getByteCount();
        }
        // Pre HC-MR1
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /**
     * 判断手机是否合法，弱验证11位数�?
     */
    private static Pattern mMobileValidPattern = Pattern.compile("^\\d{11}$");

    public static boolean isMobileValid(String data) {
        Matcher matcher = mMobileValidPattern.matcher(data);
        return matcher.matches();
    }

    /**
     * 判断手机是否合法，严格验�?11位数�?
     */
    private static Pattern mMobileStrictValidPattern = Pattern
            .compile("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");

    public static boolean isMobileStrictValid(String data) {
        Matcher matcher = mMobileStrictValidPattern.matcher(data);
        return matcher.matches();
    }

    /**
     * 1. 密码的长度不设上限�?? <br>
     * 2. 支持英文，数字，符号�? <br>
     * 符号（根据当前iOS用户可能打出的符号列出）�? - �? �?
     * �?/\:;()$€£¥₩¢&§@".�?,?¿!¡'’�?�`[]{}#%‰^*+=_|~<> <br>
     * 错误提醒：密码含有不支持的字�?
     * 
     * @time 2014�?09�?26�?15:38:14<br>
     * 
     */
    private static Pattern mPasswordValidPattern = Pattern
            .compile("^[0-9a-zA-Z-–�?��??/\\\\:;\\[\\]()$€£¥₩¢&§@\".�?,?¿!¡'’�?�`{}#%‰^*+=_|~<>]{6,}$");

    public static boolean isPasswordValid(String data) {
        Matcher matcher = mPasswordValidPattern.matcher(data);
        return matcher.matches();
    }

    /**
     * 获取经纬�?
     * 
     * @param context
     * @return
     */
    public static double[] getLatitudeAndLongitude(Context context) {
        double[] latLong = null;

        //使用标准集合，让系统自动选择可用的最佳位置提供器，提供位�?
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//高精�?
        criteria.setAltitudeRequired(false);//不要求海�?
        criteria.setBearingRequired(false);//不要求方�?
        criteria.setCostAllowed(true);//允许有花�?
        criteria.setPowerRequirement(Criteria.POWER_HIGH);//低功�?
        LocationManager loctionManager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        //从可用的位置提供器中，匹配以上标准的�?佳提供器
        String provider = loctionManager.getBestProvider(criteria, true);
        if (TextUtils.isEmpty(provider)) {
            provider = LocationManager.GPS_PROVIDER;
        }
        //获得�?后一次变化的位置
        Location location = loctionManager.getLastKnownLocation(provider);
        if (location != null) {
            latLong = new double[2];
            latLong[0] = location.getLatitude();
            latLong[1] = location.getLongitude();
        } else {
            Log.d(TAG, "can't find Location info");
        }
        return latLong;
    }

    public static String formatTime(long time) {
        Calendar serverCal = Calendar.getInstance(Locale.CHINA);
        serverCal.setTimeInMillis(time);

        Calendar nowCal = Calendar.getInstance(Locale.CHINA);
        nowCal.setTimeInMillis(System.currentTimeMillis());

        String timeStr;
        if (serverCal.get(Calendar.YEAR) == nowCal.get(Calendar.YEAR)
                && serverCal.get(Calendar.DAY_OF_YEAR) == nowCal.get(Calendar.DAY_OF_YEAR)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.CHINA);
            timeStr = sdf.format(new Date(time));
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd", Locale.CHINA);
            timeStr = sdf.format(new Date(time));
        }
        return timeStr;
    }

    public static long millisToSeconds(long millis) {
        return millis > 0 ? (Math.round((millis) / 1000f)) : 0;
    }

    public static boolean isCellIdAvailable(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE))
                .getCellLocation() != null;
    }

    @TargetApi(11)
    public static void enableStrictMode() {
        if (Utils.hasGingerbread()) {
            StrictMode.ThreadPolicy.Builder threadPolicyBuilder = new StrictMode.ThreadPolicy.Builder()
                    .detectAll().penaltyLog();
            StrictMode.VmPolicy.Builder vmPolicyBuilder = new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyLog();
            StrictMode.setThreadPolicy(threadPolicyBuilder.build());
            StrictMode.setVmPolicy(vmPolicyBuilder.build());
        }
    }

    /**
     * 将字符串数组转化�? 逗号分割的字符串
     * */
    public static String stringArray2StringWithComma(List<String> array) {

        if (CollectionUtils.isEmpty(array)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串集合转化�? 逗号分割的字符串
     * */
    public static String stringSet2StringWithComma(HashSet<String> set) {

        if (CollectionUtils.isEmpty(set)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int size = set.size();
        int i = 0;
        for (String string : set) {
            sb.append(string);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }

        return sb.toString();
    }

    /**
     * 将字符串map转化�? 逗号分割的字符串
     * */
    public static String stringMap2StringWithComma(HashMap<String, String> map) {

        if (CollectionUtils.isEmpty(map)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int size = map.size();
        int i = 0;

        for (String string : map.keySet()) {
            sb.append(string);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }

        return sb.toString();
    }

    /**
     * 压缩文件，生成在File目录下的文件
     * 
     * @param data
     * @param fileName
     * */

    public static boolean doGzip(String data, File file) {
        boolean result = Boolean.FALSE;

        ByteArrayInputStream inputStream = null;
        BufferedOutputStream out = null;

        try {
            if (file.exists()) {
                file.delete();
            } else {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            inputStream = new ByteArrayInputStream(data.getBytes());
            out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
            int lg = -1;
            byte buffer[] = new byte[Utils.IO_BUFFER_SIZE];
            while ((lg = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, lg);
            }
        } catch (Exception e) {
            result = Boolean.TRUE;
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (inputStream != null) {
                    inputStream.close();
                }

                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {
                result = Boolean.TRUE;
                e.printStackTrace();
            }
        }

        return result;
    }

    //
    public static String getErrorInfoFromException(Exception e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        }
    }

    public static String getExceptionInfo(Throwable ex) {
        Writer writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);
        ex.printStackTrace(pw);
        pw.close();
        String error = writer.toString();
        return error;
    }

    /**
     * 是否支持EL2.0 ,如果不支持则不能使用滤镜
     * 
     * @param context
     * @return
     */
    public static boolean supportsOpenGLES2(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        return configurationInfo.reqGlEsVersion >= 0x20000;
    }

    /**
     * �?查是否支持GL2.0，如果不支持就GLSurfaceView 不能进行任何操作
     * 
     * @param context
     * @return
     */
    public static boolean checkGL20Support(Context context) {
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay display = egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);

        int[] version = new int[2];
        egl.eglInitialize(display, version);

        int EGL_OPENGL_ES2_BIT = 4;
        int[] configAttribs = { EGL10.EGL_RED_SIZE, 4, EGL10.EGL_GREEN_SIZE, 4,
                EGL10.EGL_BLUE_SIZE, 4, EGL10.EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
                EGL10.EGL_NONE };

        EGLConfig[] configs = new EGLConfig[10];
        int[] num_config = new int[1];
        egl.eglChooseConfig(display, configAttribs, configs, 10, num_config);
        egl.eglTerminate(display);
        return num_config[0] > 0;
    }

    /**
     * 保持长宽比缩小Bitmap
     * 
     * @param bitmap
     * @param maxWidth
     * @param maxHeight
     * @return
     */
    public static Bitmap resizeBitmap(Bitmap bitmap, int maxWidth, int maxHeight) {

        int originWidth = bitmap.getWidth();
        int originHeight = bitmap.getHeight();

        // no need to resize
        if (originWidth < maxWidth && originHeight < maxHeight) {
            return bitmap;
        }

        int width = originWidth;
        int height = originHeight;

        // 若图片过�?, 则保持长宽比缩放图片
        if (originWidth > maxWidth) {
            width = maxWidth;

            double i = originWidth * 1.0 / maxWidth;
            height = (int) Math.floor(originHeight / i);

            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        }

        // 若图片过�?, 则从上端截取
        if (height > maxHeight) {
            height = maxHeight;
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        }
        return bitmap;
    }

    public static int getAge(long birthDay, long currentTimel) {
        //        if (birthDay < 1) {
        //            return 0;
        //        }
        if (currentTimel == 0) {
            return 0;
        }

        if (birthDay > System.currentTimeMillis()) {
            //例如当地时间不准怎么�?
            return 0;
        }
        Calendar birth = Calendar.getInstance();
        birth.setTimeInMillis(currentTimel - birthDay);
        return birth.get(Calendar.YEAR) - 1970;
    }

    public static int getAge(Date birthDay) {
        return getAge(birthDay.getTime(), System.currentTimeMillis());
    }

    /**
     * 获取内存的大�? 单位M
     * 
     * @return
     */
    public static int getTotalMemory() {
        String str1 = "/proc/meminfo";// 系统内存信息文件
        String str2;
        String[] arrayOfString;
        int initial_memory = 0;
        try {
            FileReader localFileReader = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
            str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大�?

            arrayOfString = str2.split("\\s+");
            //            for (String num : arrayOfString) {
            //                Log.i(str2, num + "\t");
            //            }

            initial_memory = Integer.valueOf(arrayOfString[1]).intValue();// 获得系统总内存，单位是KB
            if (initial_memory > 0) {
                initial_memory = initial_memory / 1024;//换算成M
            }
            localBufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return initial_memory;
    }

    /**
     * 获取我们能够用的�?大图�? 单位Byte。最�?2M <br>
     * 例如�?�?512内存的机子可以传512k<br>
     * 1G的机子最大可以传1M的图�?<br>
     * 2G及其以上的机子最大可以传2M的图�?
     * 
     * 
     * @return
     */
    public static long getMaxImageLength() {
        return Math.min(4098, getTotalMemory()) * 1024L;
    }
}
