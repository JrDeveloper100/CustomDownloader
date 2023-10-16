package com.example.customdownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.downloadermodule.FileDownloader

class MainActivity : AppCompatActivity() {
    private lateinit var btnDownload : Button
    private lateinit var url_et : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDownload = findViewById(R.id.btnDownload)
        url_et = findViewById(R.id.url_et)

        btnDownload.setOnClickListener {
            Toast.makeText(this,"Download Started",Toast.LENGTH_SHORT).show()
            FileDownloader.Download(this,url_et.text.toString())
        }

    }
}