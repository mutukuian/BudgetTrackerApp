package budgetTracker.app.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun writeOnBoardingKeyToDataStore(completed:Boolean) //adds user if has completed on boarding to datastore
    suspend fun readOnBoardingKeyFromDataStore():Flow<Boolean> //reads if user is onboard to datastore or not

    suspend fun writeCurrencyToDataStore(currency:String) //add currency the user has selected

    suspend fun readCurrencyFromDataStore():Flow<String> //reads the currency selected by the user

    suspend fun writeExpenseLimitToDataStore(amount:Double) //adds expense limit set by user to the datastore

    suspend fun readExpenseLimitFromDataStore():Flow<Double> //reads the expense limit set by user

    suspend fun writeLimitKeyToDataStore(enabled:Boolean) //adds if user has enabled setExpenseLimit button

    suspend fun readLimitKeyFromDataStore():Flow<Boolean>

    suspend fun writeLimitDurationToDataStore(duration:Int) //sets duration for limit to last

    suspend fun readLimitDurationFromDataStore():Flow<Int>

    suspend fun eraseDataStore() //erases all the data in the dataStore


}