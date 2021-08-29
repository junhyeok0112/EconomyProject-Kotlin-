package org.techtown.economyproject

import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ViewPortHandler
import java.text.DecimalFormat


class MyValueFormatter : ValueFormatter() {
    private val mFormat: DecimalFormat

    fun getFormattedValue(
        value: Float,
        entry: Map.Entry<*, *>?,
        dataSetIndex: Int,
        viewPortHandler: ViewPortHandler?
    ): String {
        // write your logic here
        return mFormat.format(value).toString() // e.g. append a dollar-sign
    }

    init {
        mFormat = DecimalFormat("###,###,##0.0") // use one decimal
    }
}