package com.example.a5ru6

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_male = findViewById<RadioButton>(R.id.radBtn_male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Female)

        val chkbox1 = findViewById<CheckBox>(R.id.ckb1)
        val chkbox2 = findViewById<CheckBox>(R.id.ckb2)
        val chkbox3 = findViewById<CheckBox>(R.id.ckb3)

        val btn_send = findViewById<Button>(R.id.btn_send)

        val applyDate = findViewById<EditText>(R.id.editTextDate2)

        radGrp_Gender.setOnCheckedChangeListener(){
                _,checkedID ->
            val gender = radGrp_Gender.findViewById<RadioButton>(checkedID).text.toString()
            Toast.makeText(this,gender,Toast.LENGTH_LONG).show()
        }

        btn_send.setOnClickListener{
            var msg=""
            if (chkbox1.isChecked()){
                msg = msg + chkbox1.getText().toString()
            }
            if (chkbox2.isChecked()){
                msg = msg + "、"+ chkbox2.getText().toString()
            }
            if (chkbox3.isChecked()){
                msg = msg + "、"+ chkbox3.getText().toString()
            }
            //Toast.makeText(this@MainActivity,"你選的是" + msg,Toast .LENGTH_SHORT).show()
            val content = "ID:${findViewById<EditText>(R.id.editTextTextPersonName2).text.toString()}\n" +
                    "pwd:${findViewById<EditText>(R.id.editTextTextPersonName3).text.toString()}\n" +
                    "Name:${findViewById<EditText>(R.id.bth_send).text.toString()}\n" +
                    "Birthday:${findViewById<EditText>(R.id.editTextDate2).text.toString()}\n" +
                    "Gender:${findViewById<RadioButton>(radGrp_Gender.checkedRadioButtonId).text.toString()}"
            val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
            builder
                .setMessage(content + "\n" + "興趣:${msg}")
                .setTitle("輸入內容")
                .setPositiveButton("確認") { dialog, _ -> }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        applyDate.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, {_, year, month, day ->
                run {
                    var format = "${setDateFormat(year, month, day)}"
                    applyDate.setText(format)
                }
            }, year, month, day).show()
        }


        }
    private fun setDateFormat(year: Int, month: Int, day: Int): String{
        return "$year-${month + 1}-$day"
    }
}



