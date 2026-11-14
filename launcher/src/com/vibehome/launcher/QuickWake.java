package com.vibehome.launcher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

/** Starts the stock idle screensaver on firmware that turns off the projection light while dreaming. */
final class QuickWake {
    private QuickWake() {}

    static void start(Activity activity) {
        if ("HY320".equals(Build.MODEL) && "UI_Veng.projector.20241225.164550".equals(Build.DISPLAY)) {
            try {
                activity.startActivity(new Intent("com.google.android.pano.action.SLEEP")
                        .setPackage("com.android.tv.settings"));
                return;
            } catch (ActivityNotFoundException | SecurityException unavailable) {
                // TV Settings may be absent or disabled.
            }
        }
        Toast.makeText(activity, "Sleep Mode is unavailable on this firmware", Toast.LENGTH_SHORT).show();
    }
}
