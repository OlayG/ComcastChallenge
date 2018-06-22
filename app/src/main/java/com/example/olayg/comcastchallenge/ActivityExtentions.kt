package com.example.olayg.comcastchallenge

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImg(imageUrl: String?) {
    Picasso.get().load(imageUrl).fit()
            .placeholder(R.mipmap.ic_launcher_round)
            .into(this)
}

fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(context, this.toString(), duration).apply { show() }
}

fun Any.log(tag: String = "MyLogs") {
    Log.d(tag, this.toString())
}
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commitAllowingStateLoss()
}
fun AppCompatActivity.addFragment(frameId: Int, fragment: Fragment, fragmentTag: String) {
    supportFragmentManager.inTransaction {
        setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        addToBackStack(fragmentTag)
        add(frameId, fragment, fragmentTag)
    }
}