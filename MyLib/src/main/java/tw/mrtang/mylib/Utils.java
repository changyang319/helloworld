package tw.mrtang.mylib;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class Utils {


    static public String getVersionCode(Context context){
        PackageManager packageManager=context.getPackageManager();
        PackageInfo packageInfo;
        String versionCode = "";
        try {
            packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            versionCode = packageInfo.versionCode + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "(" + versionCode + ")";
    }


    static public String getVersionName(Context context){
        PackageManager packageManager=context.getPackageManager();
        PackageInfo packageInfo;
        String versionName = "";
        try {
            packageInfo=packageManager.getPackageInfo(context.getPackageName(),0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "v" + versionName;
    }


    public static boolean verifyInstaller(final Context context) {

        final String PLAY_STORE_APP_ID = "com.android.vending";

        final String installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());

        return installer != null

                && installer.startsWith(PLAY_STORE_APP_ID);
    }

    public static boolean verifyAppExist(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        Intent i = manager.getLaunchIntentForPackage(packageName);
        if (i == null) {
            return false;
        }
        return true;
    }
}
