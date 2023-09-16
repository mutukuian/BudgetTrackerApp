package budgetTracker.app.data.local_database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import budgetTracker.app.domain.model.Account

@Entity(tableName = "accounts_table")
data class AccountDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:String,

    @ColumnInfo("account")
    val accountType:String,

    @ColumnInfo("balance")
    val balance: Double,

    @ColumnInfo("income")
    val income: Double,

    @ColumnInfo("expense")
    val expense: Double
){
    fun toAccount():Account = Account(
        accountType,
        balance,
        income,
        expense
    )
}
