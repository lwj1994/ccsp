package com.lwjlol.chunchunsp.demo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateText()

        updateButton.setOnClickListener {
            if (nameEditText.text.isNotEmpty()) {
                UserInfos_CCSP.name = nameEditText.text.toString()
            }
            if (ageEditText.text.isNotEmpty()) {
                UserInfos_CCSP.age = ageEditText.text.toString().toDouble().toInt()
            }
            if (idEditText.text.isNotEmpty()) {
                UserInfos_CCSP.id = idEditText.text.toString().toDouble().toLong()
            }
            UserInfos_CCSP.isMan = manCheckBox.isChecked
            UserInfos_CCSP.temperature = 36.3F
            updateText()
        }

        clearButton.setOnClickListener {
            UserInfos_CCSP.clear()
            updateText()
        }
    }

    private fun updateText() {
        debugTextView.text = "name = ${UserInfos_CCSP.name}" +
                "\n age = ${UserInfos_CCSP.age}" +
                "\n id = ${UserInfos_CCSP.id}" +
                "\n isMan = ${UserInfos_CCSP.isMan}" +
                "\n temperature = ${UserInfos_CCSP.temperature}"
    }

    companion object {
        val sp = App.context.getSharedPreferences("ccsp", Context.MODE_PRIVATE)
        val encrypt by lazy {
            MyCcspCrypt()
        }
    }
}
