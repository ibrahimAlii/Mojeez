package mogeez.quran.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class TestIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_intro)

        findViewById<MaterialButton>(R.id.next)
            .setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
    }
}