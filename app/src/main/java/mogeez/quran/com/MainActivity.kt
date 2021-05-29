package mogeez.quran.com

import android.content.DialogInterface
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counter = findViewById<MaterialTextView>(R.id.counter)
        val next = findViewById<MaterialButton>(R.id.next)
        var count = 0
        mediaPlayer = MediaPlayer.create(this, R.raw.ayah)
        mediaPlayer.setOnCompletionListener {
            count++
            counter.text = "$count"
            mediaPlayer.start()
        }

        mediaPlayer.start()

        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle(R.string.memory_test)
            .setIcon(R.drawable.logo)
            .setNegativeButton(
                R.string.no
            ) { dialog, which ->
                dialog.dismiss()
                mediaPlayer.start()
            }
            .setPositiveButton(
                R.string.yes
            ) { dialog, which ->
                dialog.dismiss()
                mediaPlayer.release()
                next.isEnabled = false
                next.isClickable = false
            }
            .setMessage(R.string.finish_test_message)

        next.setOnClickListener {
            mediaPlayer.pause()
            dialog.show()
        }
    }

    override fun onStop() {
        if (mediaPlayer != null)
            mediaPlayer.release()
        super.onStop()
    }
}