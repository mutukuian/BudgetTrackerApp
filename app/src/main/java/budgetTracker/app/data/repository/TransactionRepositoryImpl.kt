package budgetTracker.app.data.repository

import budgetTracker.app.data.TransactionDao
import budgetTracker.app.data.local_database.entity.AccountDto
import budgetTracker.app.data.local_database.entity.TransactionDto
import budgetTracker.app.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao
) :TransactionRepository{
    override suspend fun insertTransaction(dailyExpense: TransactionDto) {
        transactionDao.insertTransaction(dailyExpense)
    }

    override suspend fun insertAccount(accounts: List<AccountDto>) {
        transactionDao.insertAccounts(accounts)
    }

    override fun getDailyTransaction(entryDate: String): Flow<List<TransactionDto>> {
        return transactionDao.getDailyTransaction(entryDate)
    }

    override fun getTransactionByAccountType(accountType: String): Flow<List<TransactionDto>> {
        return transactionDao.getTransactionByAccount(accountType)
    }

    override fun getAccount(account: String): Flow<AccountDto> {
       return transactionDao.getAccount(account)
    }

    override fun getAccounts(): Flow<List<AccountDto>> {
       return transactionDao.getAccounts()
    }

    override fun getAllTransactions(): Flow<List<TransactionDto>> {
        return transactionDao.getAllTransactions()
    }

    override fun eraseTransaction() {
       transactionDao.eraseTransaction()
    }

    override fun getCurrentDayExpTransaction(): Flow<List<TransactionDto>> {
        return transactionDao.getCurrentDayExpTransaction()
    }

    override fun getWeeklyExpTransaction(): Flow<List<TransactionDto>> {
        return transactionDao.getWeeklyExpTransaction()
    }

    override fun getMonthlyExpTransaction(): Flow<List<TransactionDto>> {
        return transactionDao.getMonthlyExpTransaction()
    }

    override fun get3DayTransaction(transactionType: String): Flow<List<TransactionDto>> {
        return transactionDao.get3DayTransaction(transactionType)
    }

    override fun get7DayTransaction(transactionType: String): Flow<List<TransactionDto>> {
        return transactionDao.get7DayTransaction(transactionType)
    }

    override fun get14DayTransaction(transactionType: String): Flow<List<TransactionDto>> {
        return transactionDao.get14DayTransaction(transactionType)
    }

    override fun startOfTheMonthTransaction(transactionType: String): Flow<List<TransactionDto>> {
        return transactionDao.getStartOfMonthTransaction(transactionType)
    }

    override fun getLastMonthTransaction(transactionType: String): Flow<List<TransactionDto>> {
       return transactionDao.getLastMonthTransaction(transactionType)
    }

    override fun getTransactionByType(transactionType: String): Flow<List<TransactionDto>> {
      return transactionDao.getTransactionByType(transactionType)
    }
}