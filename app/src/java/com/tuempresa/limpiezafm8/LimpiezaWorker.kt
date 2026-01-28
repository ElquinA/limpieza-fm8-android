package com.tuempresa.limpiezafm8

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.File

class LimpiezaWorker(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {

    override fun doWork(): Result {
        val archivo = File(
            "/storage/emulated/0/Android/data/com.procomsol.devcom/file/Pro-ComSol/Library/0000f9/0083/0902.fm8"
        )

        if (archivo.exists()) {
            archivo.delete()
        }
        return Result.success()
    }
}
