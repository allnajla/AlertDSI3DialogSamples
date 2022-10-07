package com.example.alertdialog

import android.app.ProgressDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onBackPressed() {
        val builder =AlertDialog.Builder(this)
        builder.setTitle("Are you sure !")
        builder.setMessage("Do you want to close the app? ")
        builder.setPositiveButton("Yes",{dialogInterface : DialogInterface, i:Int-> finish()})
        builder.setNegativeButton("No",{dialogInterface: DialogInterface, i:Int->})
        builder.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder =AlertDialog.Builder(this)
        val dialog = builder.create()
        val dialogView = layoutInflater.inflate(R.layout.progress_dialog,null)
        val message= dialogView.findViewById<TextView>(R.id.message)
        message.text= "Please wait..."
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.show()
        Handler(Looper.getMainLooper()).postDelayed({dialog.dismiss()},5000)

    }
}