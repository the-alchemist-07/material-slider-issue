package com.example.materialsliderissue

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.materialsliderissue.databinding.ActivityMainBinding
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setListeners()
    }

    private fun init() {
        val minValue = 0
        val maxValue = 500050000
        val stepSize = 50000

        binding.apply {
            slider.valueFrom = minValue.toFloat()
            slider.valueTo = maxValue.toFloat()
            slider.stepSize = stepSize.toFloat()
        }
    }

    private fun setListeners() {
        binding.slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(p0: Slider) {}
            override fun onStopTrackingTouch(slider: Slider) {
                binding.tvSelectedValue.text = slider.value.toInt().toString()
            }
        })
    }
}
