package budgetTracker.app.domain.model

data class Account(
    /*
  contains the name of the account,amount held in the account,
  income coming into the account
  and the expenses of the account
     */

    val account:String,
    val amount:Double,
    val income:Double,
    val expense:Double
)
