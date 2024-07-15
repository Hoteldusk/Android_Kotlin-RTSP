package com.dusk.rstp_test

import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource
import com.google.android.exoplayer2.ui.PlayerView

class MainActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        enableEdgeToEdge()

        playerView = findViewById(R.id.player_view)

        // 에러남
//        player = ExoPlayer.Builder(this).build()

        player = SimpleExoPlayer.Builder(this).build()

        playerView.player = player


        //rtsp://210.99.70.120:1935/live/cctv026.stream 충청남도 천안시 세무서 CCTV
        val meidaItem = MediaItem.fromUri(Uri.parse("rtsp://210.99.70.120:1935/live/cctv026.stream"))

        val mediaSource = RtspMediaSource.Factory().createMediaSource(meidaItem)

        player.setMediaSource(mediaSource)
        player.prepare()
        player.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}