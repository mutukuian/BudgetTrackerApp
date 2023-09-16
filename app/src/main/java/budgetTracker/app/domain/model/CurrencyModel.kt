package budgetTracker.app.domain.model

data class CurrencyModel(
    /*
    users to select their country currency
     */
    val country:String = String(),
    val currencyCode:String = String(),
    val currencySymbol:String = String(),
)
