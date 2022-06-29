package com.example.homework1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var nameEditText: EditText? = null
    var heightEditText: EditText? = null
    var weightEditText: EditText? = null
    var ageEditText: EditText? = null
    var textView: TextView? = null
    var button: Button? = null

    var name: String? = null
    var height: Int? = null
    var weight: Double? = null
    var age: Int? = null

    val invalidMessage = "Данные введены некорректно"
    val nameLength = 50
    val wheightMax = 250
    val maxAge = 150

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button?.setOnClickListener {
            changeTextView()
        }
    }

    fun changeTextView() {
        textView = findViewById(R.id.textView)
        if (initAge() && initWeight() && initHeight() && initName()) {
            textView?.text = "Ответ: ${calculateHoroscope()}"
        } else {
            textView?.text = invalidMessage
        }
    }

    fun calculateHoroscope(): Double = name?.length!! * height!! * age!! / weight!! // !!!!!!!!!!

    fun initName(): Boolean {
        nameEditText = findViewById(R.id.et_name)
        if (nameEditText?.text?.toString().equals("")) return false
        name = nameEditText?.text.toString()
        return name?.length in 1..nameLength
    }

    fun initHeight(): Boolean {
        heightEditText = findViewById(R.id.et_height)
        if (heightEditText?.text?.toString().equals("")) return false
        height = heightEditText?.text.toString().toInt()
        return height in 1 until wheightMax
    }

    fun initWeight(): Boolean {
        weightEditText = findViewById(R.id.et_weight)
        if (weightEditText?.text?.toString().equals("")) return false
        weight = weightEditText?.text.toString().toDouble()
        return weight!! in 1.0..wheightMax.toDouble()
    }

    fun initAge(): Boolean {
        ageEditText = findViewById(R.id.et_age)
        if (ageEditText?.text?.toString().equals("")) return false
        age = ageEditText?.text.toString().toInt()
        return age in 1..maxAge
    }
}