package budgetTracker.app.domain.use_case.write_database

import budgetTracker.app.data.local_database.entity.TransactionDto
import budgetTracker.app.domain.repository.TransactionRepository
import javax.inject.Inject

class InsertNewTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {

    suspend operator fun invoke(dailyExpense: TransactionDto){
        return transactionRepository.insertTransaction(dailyExpense)
    }
}