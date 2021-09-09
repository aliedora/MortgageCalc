package mortgage_calculator

import kotlin.math.pow

class MortgageCalculator(
    firstPayment: Int = 5000000,
    mortageSum: Int = 14500000,
    var percent: Double = 8.1,
    var term: Int = 6
) {
    var monthPayment: Int = 0
    var debtTotalValue: Int = 0
    var monthlyPercentRate: Double = 0.0
    var totalPercent = 0

    init {
        monthlyPercentRate = percent / 12 / 100
        Log.print(monthlyPercentRate)
        term *= 12
        debtTotalValue = (mortageSum - firstPayment)
    }

    fun calculateMonthPayment() {
        val totalMortgagePercentValue = (1 + monthlyPercentRate).pow(term)
        Log.print(totalMortgagePercentValue)
        monthPayment =
                (debtTotalValue * monthlyPercentRate * totalMortgagePercentValue / (totalMortgagePercentValue - 1)).toInt()
        Log.print("Месячный взнос по кредиту = $monthPayment")
    }


    fun addAdditionalPaymentToCorrectSum(additionalPayment: Int = 0) {
        debtTotalValue = (debtTotalValue - additionalPayment)
        Log.print("!!!!!!!!!!Сумма основного долга после уменьшения $debtTotalValue")

    }

    fun calculateMonthPaymentsWithPercents(
        additionalsPaymentsList: HashMap<Int, Int>,
        paymentValueAdditionalConstant: Int
    ) {
        var percentPart: Int
        var mainPart: Int
        for (month in 1..term) {
            percentPart = (debtTotalValue * monthlyPercentRate).toInt()
            mainPart = (monthPayment - percentPart) + paymentValueAdditionalConstant
            Log.print("Месяц $month")
            Log.print("Сумма уплаченный процентов = $percentPart, Тело кредита = $mainPart")
            totalPercent += percentPart
            debtTotalValue -= mainPart
            for (element in additionalsPaymentsList) {
                if (element.key == month) {
                    addAdditionalPaymentToCorrectSum(element.value)
                }
            }

            if (debtTotalValue <= monthPayment) {
                Log.print("Сэкономлено месяцев " + (term - month))
                Log.print("Всего процентов $totalPercent")
                break
            }
            Log.print("Остаток долга $debtTotalValue")
        }
    }


}