package budgetTracker.app.domain.use_case.write_datastore

import budgetTracker.app.domain.repository.DataStoreRepository
import javax.inject.Inject

class EditLimitDurationUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
){
    suspend operator fun invoke(duration:Int){
        dataStoreRepository.writeLimitDurationToDataStore(duration)
    }
}