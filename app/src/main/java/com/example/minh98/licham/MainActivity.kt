package com.example.minh98.licham

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var lichAm: TextView
    lateinit var canChi: TextView
    lateinit var datePicker: DatePicker
    lateinit var date: Calendar
    lateinit var btnCheck: Button
    lateinit var btnShow: Button
     var d: Int = 0
     var m: Int = 0
     var y: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addView()
        addListener()
        update()
    }

     fun addView() {
        lichAm = findViewById(R.id.lichAm) as TextView
        canChi = findViewById(R.id.canChi) as TextView
        datePicker = findViewById(R.id.datePicker) as DatePicker
        date = Calendar.getInstance()
        btnCheck = findViewById(R.id.btnCheck) as Button
        btnShow = findViewById(R.id.btnShow) as Button
        val an = AnimationUtils.loadAnimation(this, R.anim.an)
        val hien = AnimationUtils.loadAnimation(this, R.anim.hien)

    }

     fun addListener() {
        btnCheck.setOnClickListener {
            date.set(datePicker.year, datePicker.month, datePicker.dayOfMonth)
            update()
        }
        btnShow.setOnClickListener { showDialog(idDialog) }

    }

    override fun onCreateDialog(id: Int): Dialog? {

        if (id == idDialog)
            return DatePickerDialog(this, ListenerDialog, 1, 1, 1)
        return null
    }

    internal var ListenerDialog: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        y = year
        m = month
        d = dayOfMonth
    }

    private fun update() {
        val d = date.get(Calendar.DAY_OF_MONTH)
        val m = date.get(Calendar.MONTH) + 1
        val y = date.get(Calendar.YEAR)

        Toast.makeText(this, d.toString() + "/" + m + "/" + y, Toast.LENGTH_SHORT).show()
        val amLich = VietCalendar.minh(d, m, y)
        lichAm.text = amLich.get(Calendar.DAY_OF_MONTH).toString() + "/" + amLich.get(Calendar.MONTH) + "/" + amLich.get(Calendar.YEAR)
        val can = amLich.get(Calendar.YEAR) % 10
        val chi = amLich.get(Calendar.YEAR) % 12
        canChi.text = getCan(can) + " " + getChi(chi)
    }

    internal fun getCan(i: Int): String {
        return when (i) {
            0 ->  "Canh"
            1 ->  "Tân"
            2 ->  "Nhâm"
            3 ->  "Quý"
            4 ->  "Giáp"
            5 ->  "Ất"
            6 ->  "Bính"
            7 ->  "Đinh"
            8 ->  "Mậu"
            9 ->  "Kỷ"
            else-> ""
        }

    }

    internal fun getChi(i: Int): String {
        return when (i) {
            0 ->  "Thân"
            1 ->  "Dậu"
            2 ->  "Tuất"
            3 ->  "Hợi"
            4 ->  "Tý"
            5 ->  "Sửu"
            6 ->  "Dần"
            7 ->  "Mão"
            8 ->  "Thìn"
            9 ->  "Tỵ"
            10 ->  "Ngọ"
            11 ->  "Mùi"
            else -> ""
        }

    }

    companion object {
         val idDialog = 1
    }
}
