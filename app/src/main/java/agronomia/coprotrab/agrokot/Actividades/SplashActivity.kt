package agronomia.coprotrab.agrokot.Actividades

import agronomia.coprotrab.agrokot.R
import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import java.util.concurrent.Delayed
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity() {
    private val ANIMATION_DURATION: Long = 2000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startAnimation()

        textSplash.visibility = View.INVISIBLE

    }
    private fun startAnimation() {
        // Intro animation configuration.
        val valueAnimator = ValueAnimator.ofFloat(2f,1f)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            imageSplash.scaleX = value
            imageSplash.scaleY = value

        }
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = ANIMATION_DURATION

        // Set animator listener.
        val intent = Intent(this, MainActivity::class.java)
        valueAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {}
            override fun onAnimationEnd(p0: Animator?) {

                Timer().schedule(2000){
                startActivity(intent)
                finish()
                }
            }
            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationStart(p0: Animator?) {}
        })
        // Start animation.

        valueAnimator.start()
    }
}