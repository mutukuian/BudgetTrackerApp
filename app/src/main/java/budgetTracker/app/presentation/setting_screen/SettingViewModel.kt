package budgetTracker.app.presentation.setting_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import budgetTracker.app.data.local_database.entity.AccountDto
import budgetTracker.app.domain.use_case.read_datastore.GetCurrencyUseCase
import budgetTracker.app.domain.use_case.read_datastore.GetExpenseLimitUseCase
import budgetTracker.app.domain.use_case.read_datastore.GetLimitDurationUseCase
import budgetTracker.app.domain.use_case.read_datastore.GetLimitKeyUseCase
import budgetTracker.app.domain.use_case.write_database.EraseTransactionUseCase
import budgetTracker.app.domain.use_case.write_database.InsertAccountsUseCase
import budgetTracker.app.domain.use_case.write_datastore.EditExpenseLimitUseCase
import budgetTracker.app.domain.use_case.write_datastore.EditLimitDurationUseCase
import budgetTracker.app.domain.use_case.write_datastore.EditLimitKeyUseCase
import budgetTracker.app.domain.use_case.write_datastore.EraseDataStoreUseCase
import budgetTracker.app.presentation.home_screen.Account
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getCurrencyUseCase: GetCurrencyUseCase,
    private val insertAccountsUseCase: InsertAccountsUseCase,
    private val eraseTransactionUseCase: EraseTransactionUseCase,
    private val getExpenseLimitUseCase: GetExpenseLimitUseCase,
    private val editExpenseLimitUseCase: EditExpenseLimitUseCase,
    private val getLimitKeyUseCase: GetLimitKeyUseCase,
    private val editLimitKeyUseCase: EditLimitKeyUseCase,
    private val editLimitDurationUseCase: EditLimitDurationUseCase,
    private val getLimitDurationUseCase: GetLimitDurationUseCase,
    private val eraseDatastoreUseCase: EraseDataStoreUseCase
) : ViewModel() {

    var currency = MutableStateFlow(String())
        private set

    var expenseLimit = MutableStateFlow(0.0)
        private set

    var expenseLimitDuration = MutableStateFlow(0)
        private set

    var reminderLimit = MutableStateFlow(false)
        private set

    init {
        viewModelScope.launch(IO) {
            getCurrencyUseCase().collect { selectedCurrency->
                currency.value = selectedCurrency
            }
        }

        viewModelScope.launch(IO) {
            getExpenseLimitUseCase().collect { expenseAmount ->
                expenseLimit.value = expenseAmount
            }
        }

        viewModelScope.launch(IO) {
            getLimitKeyUseCase().collect { limitKey ->
                reminderLimit.value = limitKey
            }
        }

        viewModelScope.launch(IO) {
            getLimitDurationUseCase().collect { duration ->
                expenseLimitDuration.value = duration
            }
        }
    }

    fun eraseTransaction() {
        viewModelScope.launch(IO) {
            // reset account
            insertAccountsUseCase(
                listOf(
                    AccountDto(1, Account.CASH.title, 0.0, 0.0, 0.0),
                    AccountDto(2, Account.BANK.title, 0.0, 0.0, 0.0),
                    AccountDto(3, Account.CARD.title, 0.0, 0.0, 0.0)
                )
            )
            // erase transactions
            eraseTransactionUseCase()
            // erase datastore
            eraseDatastoreUseCase()
        }
    }

    fun editExpenseLimit(amount: Double) {
        viewModelScope.launch(IO) {
            editExpenseLimitUseCase(amount)
        }
    }

    fun editLimitKey(enabled: Boolean) {
        viewModelScope.launch(IO) {
            editLimitKeyUseCase(enabled)
        }
    }

    fun editLimitDuration(duration: Int) {
        viewModelScope.launch(IO) {
            editLimitDurationUseCase(duration)
        }
    }
}