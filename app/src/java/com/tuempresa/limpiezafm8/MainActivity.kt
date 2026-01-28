package com.tuempresa.limpiezafm8

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!Environment.isExternalStorageManager()) {
            startActivity(
                Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
            )
        }

        val request =
            PeriodicWorkRequestBuilder<LimpiezaWorker>(
                7, TimeUnit.DAYS
            ).build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "LimpiezaFM8",
            ExistingPeriodicWorkPolicy.REPLACE,
            request
        )
    }
}
