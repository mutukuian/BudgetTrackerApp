package budgetTracker.app.domain.use_case.write_datastore

import budgetTracker.app.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditLimitKeyUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    suspend operator fun invoke(enabled:Boolean){
        dataStoreRepository.writeLimitKeyToDataStore(enabled)
    }
}