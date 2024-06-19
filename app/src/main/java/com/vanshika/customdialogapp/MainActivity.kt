package com.vanshika.customdialogapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var fab : FloatingActionButton ?= null
    var name : EditText ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.fab)
        name = findViewById(R.id.etName)
        fab?.setOnClickListener {
            Dialog(this).apply {
                setContentView(R.layout.layout_dialogue)
                show()
                val etName = this.findViewById<EditText>(R.id.etEnterYourText)
                val btnSubmit: Button = this.findViewById(R.id.btSubmit)
                val btnCancel: Button = this.findViewById(R.id.btCancel)
                btnSubmit.setOnClickListener {
                    if (etName?.text?.toString().isNullOrEmpty()) {
                        etName?.error = resources.getString(R.string.enter_your_name)
                    } else {
                        name?.setText(etName?.text?.toString())
                        this.dismiss()
                    }
                }
                btnCancel.setOnClickListener {
                    this.dismiss()
                }
            }
        }
    }
}