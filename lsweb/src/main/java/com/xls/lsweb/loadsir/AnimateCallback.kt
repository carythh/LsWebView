package com.xls.lsweb.loadsir

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import com.kingja.loadsir.callback.Callback
import com.xls.lsweb.R

/**
 * Description:TODO
 * Create Time:2017/9/3 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
class AnimateCallback : Callback() {
    private var context: Context? = null
    private var animateView: View? = null


    override  fun onCreateView(): Int {
        return R.layout.layout_animate
    }

    override fun onViewCreate(
        context: Context?,
        view: View?
    ) {
        super.onViewCreate(context, view)
    }

    override fun onAttach(context: Context, view: View) {
        this.context = context
        animateView = view.findViewById(R.id.view_animate)
        val animation: Animation = RotateAnimation(
            0f, 359f, Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        animation.duration = 1000
        animation.repeatCount = Int.MAX_VALUE
        animation.fillAfter = true
        animation.interpolator = LinearInterpolator()
        animateView?.startAnimation(animation)
        Toast.makeText(context.applicationContext, "start animation", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onDetach() {
        super.onDetach()
        animateView?.clearAnimation()
        Toast.makeText(context!!.applicationContext, "stop animation", Toast.LENGTH_SHORT).show()
    }
}