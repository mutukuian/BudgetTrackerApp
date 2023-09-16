package budgetTracker.app.domain.use_case.write_database

import budgetTracker.app.data.local_database.entity.AccountDto
import budgetTracker.app.domain.repository.TransactionRepository
import javax.inject.Inject

class InsertAccountsUseCase @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
     suspend operator fun invoke(accounts:List<AccountDto>){
        return transactionRepository.insertAccount(accounts)
    }
}