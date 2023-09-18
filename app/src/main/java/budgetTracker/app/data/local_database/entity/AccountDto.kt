package budgetTracker.app.data.local_database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import budgetTracker.app.domain.model.Account

@Entity(tableName = "accounts_table")
data class AccountDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo("account")
    val accountType:String,

    @ColumnInfo("balance")
    var balance: Double,

    @ColumnInfo("income")
    var income: Double,

    @ColumnInfo("expense")
    var expense: Double
){
    fun toAccount():Account = Account(
        accountType,
        balance,
        income,
        expense
    )
}
