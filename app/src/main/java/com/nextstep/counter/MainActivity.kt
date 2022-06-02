package com.nextstep.counter

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import com.nextstep.counter.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBindingView()
        setupListener()
    }

    private fun setupBindingView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvCounter.text = count.toString()
    }

    private fun setupListener() {
        binding.btnCounter.setOnClickListener {
            countUp()
        }
    }

    private fun countUp() {
        val expected = count + COUNTER_UNIT
        ValueAnimator
            .ofInt(count, expected)
            .apply {
                duration = COUNTER_DURATION
                addUpdateListener {
                    binding.tvCounter.text = it.animatedValue.toString()
                }
                doOnEnd {
                    count = expected
                }
                start()
            }
    }

    companion object {
        private const val COUNTER_UNIT = 100
        private const val COUNTER_DURATION = 2000L
    }
}
