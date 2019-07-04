package me.aluceps.practicedeeplink

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.aluceps.practicedeeplink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
        handle(intent, LaunchBy.ON_CREATE)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handle(intent, LaunchBy.ON_NEW_INTENT)
    }

    @SuppressLint("SetTextI18n")
    private fun handle(intent: Intent?, from: LaunchBy) {
        if (intent == null || intent.action != Intent.ACTION_VIEW) return
        val uri = intent.dataString?.let { Uri.parse(it) } ?: return
        Log.d("### $from:${intent.action}", "scheme=${uri.scheme} host=${uri.host} path=${uri.path}")
    }

    enum class LaunchBy {
        ON_CREATE,
        ON_NEW_INTENT,
    }
}

}