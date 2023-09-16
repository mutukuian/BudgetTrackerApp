package budgetTracker.app.domain.model

import java.util.Date

data class Transaction(
    /*
    contains date of occurance of a transaction and the amount of money been transacted
    and the category the transaction belongs and from which account the transaction is been performed
    */

    val date: Date,
    val dateOfEntry:String,
    val amount:Double,
    val category:String,
    val account:String,
    val transactionType:String, //defines if the transaction is an expense or income
    val title:String //gives name to a particular transaction
)
