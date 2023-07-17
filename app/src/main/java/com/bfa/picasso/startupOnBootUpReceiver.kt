package com.bfa.picasso

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class startupOnBootUpReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            val activityIntent = context.packageManager.getLaunchIntentForPackage(context.packageName)
            activityIntent?.let {
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(it)
            }

        }
    }
}