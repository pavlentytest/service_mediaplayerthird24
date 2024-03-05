package com.example.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

object NotificationHelper {
    private const val CHANNEL_ID="ID"

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(context: Context) {
        val notificationManager = context.getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Test",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
    }

    fun buildNotification(context: Context) : Notification {


        return NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Title")
            .setContentText("Mediaplayer is running!")
            .setSmallIcon(R.drawable.outline_add_circle_24)
            //  .setLargeIcon(R.drawable.outline_add_circle_24)
            //   .setLargeIcon(myBitmap)
            // .setStyle(NotificationCompat.BigPictureStyle()
            //     .bigPicture(myBitmap)
            //   .bigLargeIcon(null))
            .build()
    }
}