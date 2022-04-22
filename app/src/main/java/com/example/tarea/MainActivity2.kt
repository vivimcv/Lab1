package com.example.tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.example.tarea.ui.gallery.GalleryFragment

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val v1 = findViewById<VideoView>(R.id.idvideo)
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.twilight)
        val mc:MediaController = MediaController(this)
        mc.setAnchorView(v1)
        v1.setMediaController(mc)
    }

    fun onClick(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}