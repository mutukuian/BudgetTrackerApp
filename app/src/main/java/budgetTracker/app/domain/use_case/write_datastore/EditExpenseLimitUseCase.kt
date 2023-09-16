package budgetTracker.app.domain.use_case.write_datastore

import budgetTracker.app.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditExpenseLimitUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
){
    suspend operator fun invoke(amount:Double){
        dataStoreRepository.writeExpenseLimitToDataStore(amount)
    }
}