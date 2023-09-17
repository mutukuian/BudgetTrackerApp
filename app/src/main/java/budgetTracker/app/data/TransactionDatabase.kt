package budgetTracker.app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import budgetTracker.app.data.local_database.converters.DateConverter
import budgetTracker.app.data.local_database.entity.AccountDto
import budgetTracker.app.data.local_database.entity.TransactionDto

@TypeConverters(value = [DateConverter::class])
@Database(
    entities = [
    TransactionDto::class,
    AccountDto::class
    ],
    exportSchema = true,
    version = 1
)
abstract class TransactionDatabase:RoomDatabase() {
    abstract val transactionDao:TransactionDao
}