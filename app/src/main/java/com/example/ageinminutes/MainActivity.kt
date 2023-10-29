package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener { view ->

            clickDatePicker(view)
        }

    }

    private fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, SelectedYear, SelectedMonth, SelectedDayOfMonth ->
            Toast.makeText(this,
                "The Chosen year is $SelectedYear, The Chosen month is ${SelectedMonth+1} and The Chosen day is $SelectedDayOfMonth",
                Toast.LENGTH_LONG).show()
                val selectedDate = "$SelectedDayOfMonth/${SelectedMonth+1}/$SelectedYear"
                val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)

            val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate = sdf.parse(selectedDate)

        }, year, month, dayOfMonth).show()



    }
}