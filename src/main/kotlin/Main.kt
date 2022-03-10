package ru.netology.kotlin023

const val MIN_PURCHASE = 200

fun main() {
    val accumulatedPurchase = 17000
    var currentPurchase: Int = 0
    var isMeloman: Boolean = true

    while (true) {
        print("Для расчёта скидки, введите сумму покупки (минимум $MIN_PURCHASE р.): ")
        val userInput = readLine()

        try {
            currentPurchase = userInput?.toInt()!!
        } catch (e: Exception) {
            println("Прошу ввести целое число больше нуля")
            continue
        }

        if (currentPurchase < MIN_PURCHASE) {
            println("Прошу ввести целое число больше нуля")
            continue
        }

        break
    }

    // Сумма со скидкой в копейках, для удобства расчёта и вывода
    var discountedValue =
        if (accumulatedPurchase <= 1000)
            currentPurchase * 100
        else {
            if (accumulatedPurchase <= 10_000)
                (currentPurchase - 100) * 100
            else
                (currentPurchase * 0.95 * 100).toInt()
        }
    if (isMeloman)
        discountedValue = (discountedValue * 0.99).toInt()

    val discountAmount = currentPurchase * 100 - discountedValue

    println("Сумма к оплате, с учётом скидки, ${discountedValue / 100} руб. ${discountedValue % 100} коп.")
    println("Сумма скидки, ${discountAmount / 100} руб. ${discountAmount % 100} коп.")
}