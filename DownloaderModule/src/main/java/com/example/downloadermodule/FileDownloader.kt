package com.example.downloadermodule

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Environment

object FileDownloader {

    fun Download(context: Context, fileUrl: String){

        // Replace with your download URL
//        val fileUrl = "https://pl-coding.com/wp-content/uploads/2022/04/pic-squared.jpg"

        val request = DownloadManager.Request(Uri.parse(fileUrl))
        request.setTitle("File Download")
        request.setDescription("Downloading file...")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

        // Set the destination path for the downloaded file
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "sample.pdf")

        // Get the download service and enqueue the request
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = downloadManager.enqueue(request)

        // Set up a BroadcastReceiver to listen for download completion
        val filter = IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        context.registerReceiver(downloadReceiver, filter)

    }

    private val downloadReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val downloadId = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            if (downloadId != -1L) {
                // Handle download completion here
                // You can notify the user or perform any required post-download tasks
            }
        }
    }

}