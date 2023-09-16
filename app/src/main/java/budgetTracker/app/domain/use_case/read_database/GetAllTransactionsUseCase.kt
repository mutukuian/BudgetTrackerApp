package budgetTracker.app.domain.use_case.read_database

import budgetTracker.app.data.local_database.entity.TransactionDto
import budgetTracker.app.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTransactionsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    operator fun invoke():Flow<List<TransactionDto>>{
        return transactionRepository.getAllTransactions()
    }
}