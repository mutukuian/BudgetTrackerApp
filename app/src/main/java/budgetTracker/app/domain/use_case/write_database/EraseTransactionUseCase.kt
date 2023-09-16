package budgetTracker.app.domain.use_case.write_database

import budgetTracker.app.domain.repository.DataStoreRepository
import budgetTracker.app.domain.repository.TransactionRepository
import javax.inject.Inject

class EraseTransactionUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    operator fun invoke(){
        transactionRepository.eraseTransaction()
    }
}