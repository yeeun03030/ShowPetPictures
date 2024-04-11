package kr.ac.kopo.showpetpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    lateinit var checkStart: Switch
    lateinit var linearSub: LinearLayout
    lateinit var rg: RadioGroup
//    lateinit var radioDog: RadioButton
//    lateinit var radioCat: RadioButton
//    lateinit var radioRabbit: RadioButton
    lateinit var btnInit: Button
    lateinit var btnFinish: Button
    lateinit var imgV: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkStart = findViewById<Switch>(R.id.checkStart)
        linearSub = findViewById<LinearLayout>(R.id.linearSub)
        rg = findViewById<RadioGroup>(R.id.rg)
        btnFinish = findViewById<Button>(R.id.btnFinish)
        btnInit = findViewById<Button>(R.id.btnInit)
        imgV = findViewById<ImageView>(R.id.imgV)

        linearSub.visibility = View.INVISIBLE

        checkStart.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                linearSub.visibility = View.VISIBLE
            } else {
                linearSub.visibility = View.INVISIBLE
            }
        }

        btnFinish.setOnClickListener(btnListener)
        btnInit.setOnClickListener(btnListener)

//        btnDone.setOnClickListener {
//            when(rg.checkedRadioButtonId) {
//                R.id.radioDog -> imgV.setImageResource(R.drawable.dog)
//                R.id.radioCat -> imgV.setImageResource(R.drawable.cat1)
//                R.id.radioRabbit -> imgV.setImageResource(R.drawable.rabbit)
//            }
//        }

        rg.setOnCheckedChangeListener { buttonView, isChecked ->
            when(rg.checkedRadioButtonId) {
                R.id.radioOreo -> imgV.setImageResource(R.drawable.android_oreo)
                R.id.radioPie -> imgV.setImageResource(R.drawable.android_pie)
                R.id.radioQ -> imgV.setImageResource(R.drawable.android_q)
            }
        }
    }

    val btnListener = OnClickListener {
        when (it.id) {
            R.id.btnFinish -> finish()
            R.id.btnInit -> {
                checkStart.isChecked = false
                linearSub.visibility = INVISIBLE
            }
        }
    }
}