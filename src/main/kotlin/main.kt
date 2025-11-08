fun main() {
    commission()
}

fun commission() {
    val amount = 78000
    val monthAmount = 50000
    val card = "Mastercard"

    println(typeOfCard(card, monthAmount, amount))
    println(typeOfCard(amount = amount))
}

fun typeOfCard(card: String = "Мир", transferSumMonth: Int = 0, amount: Int): String {
    var commission = 0.0
    if(transferSumMonth > 600_000) {
        return "Лимит за этот месяц превышен"
    } else if(amount > 150_000){
        return "Лимит за этот день превышен"
    } else if (card == "Mastercard" || card == "Maestro") {
        if(amount in 300.. 75_000) {
            commission = 0.0
        } else {
            amount * 0.006 +20
        }
    } else if (card == "Visa" || card == "Мир") {
        val transfer  = amount * 0.0075
        commission = if (transfer < 35)  35.0 else transfer
    } else if (card == "VK Pay") {
        commission = 0.0
    }
    return "Коммисия составит $commission рублей"
}