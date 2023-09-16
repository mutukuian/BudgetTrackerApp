package budgetTracker.app.data.local_database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import budgetTracker.app.domain.model.Transaction
import java.util.Date

@Entity(tableName = "transaction_table")
data class TransactionDto(

    @PrimaryKey
    @ColumnInfo(name = "timestamp")
    val date: Date,

    @ColumnInfo("entry_date")
    val dateOfEntry:String,

    @ColumnInfo("amount")
    val amount:Double,

    @ColumnInfo("account")
    val account:String,

    @ColumnInfo("category")
    val category:String,

    @ColumnInfo("transaction_type")
    val transactionType:String,

    @ColumnInfo("transaction_title")
    val title:String

){
    fun toTransaction():Transaction = Transaction(
        date,
        dateOfEntry,
        amount,
        category,
        transactionType,
        title,
        account
    )
}


