package com.yeatom.huya

import com.yeatom.huya.ui.placeholder.PlaceholderContent
import java.util.ArrayList

object LiveComponent {
    data class LiveItem(val image: String, val title: String) {

    }

    val ITEMS: MutableList<LiveItem> = ArrayList()

    private fun addItem(item: LiveItem) {
        ITEMS.add(item)
    }

    init {
        for (i in  1..60) {
            ITEMS.add(LiveItem("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fp2.music.126.net%2FpSHouT8VRjfLUI9FWLFPhA%3D%3D%2F109951164805642481.jpg&refer=http%3A%2F%2Fp2.music.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1658396095&t=76ca9f903f1e843c6a897c60d2e00274","capper"))
        }
    }
}