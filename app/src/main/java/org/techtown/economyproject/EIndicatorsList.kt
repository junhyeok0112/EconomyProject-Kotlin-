package org.techtown.economyproject

data class EIndicatorsList(                         //내용들을 가지고 있는 List
    val list_total_count: Int,
    val row: List<EIndicatorsResult>
)