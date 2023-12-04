package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.local.Pref

class MainActivity : AppCompatActivity() {
    private lateinit var pref: Pref

    private lateinit var tvData: TextView
    private lateinit var etData: EditText
    private lateinit var btnSaveData: Button
    private lateinit var swift: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing Pref
        pref = Pref(this)

        // Initializing views
        initView()

        // Loading data from SharedPreferences
        loadData()

        // Setting up button click listener
        initClickBtn()
    }

    private fun loadData() {
        val savedData = pref.getName()
        tvData.text = savedData
    }

    private fun initClickBtn() {
        btnSaveData.setOnClickListener {
            val dataToSave = etData.text.toString()
            // Save data to SharedPreferences
            pref.saveData(dataToSave)
            // Update TextView with the saved data
            tvData.text = dataToSave
            Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView() {
        tvData = findViewById(R.id.tv_data)
        etData = findViewById(R.id.et_data)
        btnSaveData = findViewById(R.id.btn_save)
        swift = findViewById(R.id.istrue)
    }
}
