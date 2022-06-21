package com.yeatom.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MenuItem
import androidx.core.view.forEachIndexed
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class LottieBottomNavigationView(context: Context, attrs: AttributeSet?) : BottomNavigationView(context, attrs) {
    lateinit var preSelectedMenuItem: MenuItem
    private val icons: HashMap<Int, String> = HashMap()

    fun setLottieResources(resources: Array<String>) {
        menu.forEachIndexed { index, item ->
            getLottieDrawable(resources[index]).also {
                icons[item.itemId] = resources[index]
                item.icon = it
            }

            if (index == 0) {
                post {
                    item.isChecked = true
                    (item.icon as LottieDrawable).playAnimation()
                    preSelectedMenuItem = item
                }
            }
        }
    }

    private fun getLottieDrawable(
        animation: String
    ): LottieDrawable {
        return LottieDrawable().apply {
            val result = LottieCompositionFactory.fromAssetSync(
                context.applicationContext, animation
            )
            callback = this@LottieBottomNavigationView
            composition = result.value
        }
    }


    override fun setOnItemSelectedListener(listener: OnItemSelectedListener?) {
        super.setOnItemSelectedListener {
            listener?.onNavigationItemSelected(it)
            if (it != preSelectedMenuItem) {
                (it.icon as LottieDrawable).playAnimation()
                preSelectedMenuItem.icon = getLottieDrawable(icons[preSelectedMenuItem.itemId]!!)
            }
            preSelectedMenuItem = it
            true
        }
    }

    override fun setOnItemReselectedListener(listener: NavigationBarView.OnItemReselectedListener?) {
        super.setOnItemReselectedListener {
        }
    }
}