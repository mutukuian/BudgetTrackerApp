package budgetTracker.app.domain.use_case.read_database

import budgetTracker.app.data.local_database.entity.AccountDto
import budgetTracker.app.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAccountUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    operator fun invoke(account:String):Flow<AccountDto>{
        return transactionRepository.getAccount(account)
    }
}