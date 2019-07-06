package me.aluceps.practicedeeplink

import android.annotation.SuppressLint
import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import me.aluceps.practicedeeplink.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
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
        viewModel.apply {
            this.from = from
            this.uri = uri
            this.datetime = Date()
        }
    }
}