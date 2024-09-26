package com.nautilus.sikamdisapp.helper

import android.content.Context
import android.content.Intent
import com.nautilus.sikamdisapp.view.RekmedActivity

object  helpp {
    fun startActivity(context: Context , targetActivity: Class<*>) {
        val intent = Intent(context, targetActivity)
        context.startActivity(intent)
    }
}