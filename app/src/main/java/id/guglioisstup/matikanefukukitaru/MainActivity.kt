package id.guglioisstup.matikanefukukitaru

import android.os.Bundle
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val sysBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sysBars.left, sysBars.top, sysBars.right, sysBars.bottom)
            insets
        }

        val videoView = findViewById<VideoView>(R.id.videoView)

        val videoUri = "android.resource://${packageName}/raw/video".toUri()

        videoView.setVideoURI(videoUri)

        videoView.setOnCompletionListener {
            finishAffinity()
        }

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = false
            videoView.start()
        }
    }
}
