package budgetTracker.app.domain.repository

import budgetTracker.app.data.local_database.entity.AccountDto
import budgetTracker.app.data.local_database.entity.TransactionDto
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    suspend fun insertTransaction(dailyExpense:TransactionDto)
    suspend fun insertAccount(accounts:List<AccountDto>)
    fun getDailyTransaction(entryDate:String):Flow<List<TransactionDto>>

    fun getTransactionByAccountType(accountType:String):Flow<List<TransactionDto>>

    fun getAccount(account:String):Flow<AccountDto>

    fun getAccounts():Flow<List<AccountDto>>

    fun getAllTransactions():Flow<List<TransactionDto>>

    fun eraseTransaction()

    fun getCurrentDayExpTransaction():Flow<List<TransactionDto>>

    fun getWeeklyExpTransaction():Flow<List<TransactionDto>>

    fun getMonthlyExpTransaction():Flow<List<TransactionDto>>

    fun get3DayTransaction(transactionType:String):Flow<List<TransactionDto>>

    fun get7DayTransaction(transactionType:String):Flow<List<TransactionDto>>

    fun get14DayTransaction(transactionType:String):Flow<List<TransactionDto>>

    fun startOfTheMonthTransaction(transactionType:String):Flow<List<TransactionDto>>

    fun getLastMonthTransaction(transactionType:String):Flow<List<TransactionDto>>

    fun getTransactionByType(transactionType:String):Flow<List<TransactionDto>>


}