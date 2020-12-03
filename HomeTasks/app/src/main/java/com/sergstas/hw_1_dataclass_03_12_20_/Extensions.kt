package com.sergstas.hw_1_dataclass_03_12_20_

fun ArrayList<ClientData>.bubbleSort() {
    for (i in 0 until this.size)
        for (j in i until this.size)
            if (this[j].ID < this[i].ID) {
                val temp = this[j]
                this[j] = this[i]
                this[i] = temp
            }
}