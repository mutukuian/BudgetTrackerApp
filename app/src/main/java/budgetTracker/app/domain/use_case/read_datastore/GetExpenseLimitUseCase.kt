package budgetTracker.app.domain.use_case.read_datastore

import budgetTracker.app.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetExpenseLimitUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke():Flow<Double>{
        return dataStoreRepository.readExpenseLimitFromDataStore()
    }
}