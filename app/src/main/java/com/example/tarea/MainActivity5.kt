package com.example.tarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val v1 = findViewById<VideoView>(R.id.idvideo)
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.castillo)
        val mc: MediaController = MediaController(this)
        mc.setAnchorView(v1)
        v1.setMediaController(mc)
    }

    fun onClick(view: View) {}
}