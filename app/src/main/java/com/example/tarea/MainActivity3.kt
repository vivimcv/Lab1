package com.example.tarea

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tarea.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val v1 = findViewById<VideoView>(R.id.idvideo)
        v1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.batman)
        val mc: MediaController = MediaController(this)
        mc.setAnchorView(v1)
        v1.setMediaController(mc)
    }

    fun onClick(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}