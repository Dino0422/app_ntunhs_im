package com.example.a5ru6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_male = findViewById<RadioButton>(R.id.radBtn_male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Female)

        val chkbox1 = findViewById<CheckBox>(R.id.ckb1)
        val chkbox2 = findViewById<CheckBox>(R.id.ckb2)
        val chkbox3 = findViewById<CheckBox>(R.id.ckb3)

        radGrp_Gender.setOnCheckedChangeListener(){
                _,checkedID ->
            val gender = radGrp_Gender.findViewById<RadioButton>(checkedID).text.toString()
            Toast.makeText(this,gender,Toast.LENGTH_LONG).show()
        }
    }
}