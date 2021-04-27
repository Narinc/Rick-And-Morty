package com.narinc.base.util

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.transition.Slide
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide


@BindingAdapter("src")
fun ImageView.bindSrcUrl(url: String?) = Glide.with(this).load(url).into(this)

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("show")
fun setShow(view: View, show: Boolean) {

    val transition: Transition = Slide(Gravity.BOTTOM)
    transition.setDuration(600)
    transition.addTarget(view)

    TransitionManager.beginDelayedTransition(view.parent as ViewGroup, transition)
    view.visibility = if (show) View.VISIBLE else View.GONE
}