package budgetTracker.app.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import budgetTracker.app.data.TransactionDao
import budgetTracker.app.data.TransactionDatabase
import budgetTracker.app.data.repository.DataStoreRepositoryImpl
import budgetTracker.app.data.repository.TransactionRepositoryImpl
import budgetTracker.app.domain.repository.DataStoreRepository
import budgetTracker.app.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BudgetModule {


    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context):DataStoreRepository{
        return DataStoreRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun providesTransactionDao(database: TransactionDatabase) = database.transactionDao

    @Provides
    @Singleton
    fun providesTransactionRepository(transactionDao: TransactionDao):TransactionRepository{
        return TransactionRepositoryImpl(transactionDao)
    }

    @Provides
    @Singleton
    fun providesTransactionDatabase(@ApplicationContext context: Context):TransactionDatabase{
        return Room.databaseBuilder(context,TransactionDatabase::class.java,"transactionDB")
            .fallbackToDestructiveMigration()
            .build()
    }


}