package com.anderson.categories;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.anderson.AndroidUtils;


/**
 * Created by cesarferreira on 01/11/14.
 */
public class screen {

    protected screen() {
    }


    public static final String LDPI_DENSITY_NAME    = "ldpi";
    public static final String MDPI_DENSITY_NAME    = "mdpi";
    public static final String HDPI_DENSITY_NAME    = "hdpi";
    public static final String TVDPI_DENSITY_NAME   = "tvdpi";
    public static final String XHDPI_DENSITY_NAME   = "xhdpi";
    public static final String XXHDPI_DENSITY_NAME  = "xxhdpi";
    public static final String XXXHDPI_DENSITY_NAME = "xxxhdpi";

    /**
     * Gets the {@link WindowManager} from the context.
     *
     * @return {@link WindowManager} The window manager.
     */
    public static WindowManager getWindowManager() {
        return (WindowManager) AndroidUtils.getContext().getSystemService(Context.WINDOW_SERVICE);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int getWindowHeight() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        return size.y;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static int getWindowWidth() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        return size.x;
    }

    public static Integer getSmallestScreenWidthDp() {
        Configuration config = AndroidUtils.getContext().getResources().getConfiguration();
        return config.smallestScreenWidthDp;
    }

    public static Integer getScreenWidthDp() {
        Configuration config = AndroidUtils.getContext().getResources().getConfiguration();
        return config.screenWidthDp;
    }

    public static Boolean isLdpiDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi == DisplayMetrics.DENSITY_LOW;
    }

    public static Boolean isMdpiDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM;
    }

    public static Boolean isHdpiDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi == DisplayMetrics.DENSITY_HIGH;
    }

    public static Boolean isXhdpiDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH;
    }

    public static Boolean isTVdpiDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi == DisplayMetrics.DENSITY_TV;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static Boolean isXXhdpiDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi == DisplayMetrics.DENSITY_XXHIGH;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static Boolean isXXXhdpiDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.densityDpi == DisplayMetrics.DENSITY_XXXHIGH;
    }

    public static String getScreenDensity() {
        String density = string.EMPTY;
        if (screen.isLdpiDensity()) {
            density = LDPI_DENSITY_NAME;
        } else if (screen.isMdpiDensity()) {
            density = MDPI_DENSITY_NAME;
        } else if (screen.isHdpiDensity()) {
            density = HDPI_DENSITY_NAME;
        } else if (screen.isXhdpiDensity()) {
            density = XHDPI_DENSITY_NAME;
        } else if (screen.isTVdpiDensity()) {
            density = TVDPI_DENSITY_NAME;
        } else if (screen.isXXhdpiDensity()) {
            density = XXHDPI_DENSITY_NAME;
        } else if (screen.isXXXhdpiDensity()) {
            density = XXXHDPI_DENSITY_NAME;
        }
        return density;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static Integer getLargestScreenWidthPx() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return Math.max(size.x, size.y);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public static Integer getScreenWidthPx() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return An int value to represent px equivalent to dp depending on device density
     */
    public static int convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (int) (dp * (metrics.densityDpi / 160f));
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px      A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return An int value to represent dp equivalent to px value
     */
    public static int convertPixelsToDp(int px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (int) (px / (metrics.densityDpi / 160f));
    }

    public static float convertSpDimenToSp(int spDimenResId, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return context.getResources().getDimensionPixelSize(spDimenResId) / metrics.scaledDensity;
    }

    public static int convertDimenToPixel(int dimenResId) {
        return (int) AndroidUtils.getContext().getResources().getDimension(dimenResId);
    }

    /**
     * Current device DPI
     *
     * @return amount of DPIs
     */
    public static int deviceDPI() {
        return AndroidUtils.getContext().getResources().getDisplayMetrics().densityDpi;
    }

    /**
     * Current device resolution
     *
     * @return the resolution
     */
    public static String deviceResolution() {
        DisplayMetrics metrics = AndroidUtils.getContext().getResources().getDisplayMetrics();
        return String.valueOf(metrics.widthPixels) + "x" + metrics.heightPixels;
    }
}
