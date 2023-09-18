package budgetTracker.app.domain.use_case

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

open class GetDateUseCase @Inject constructor() {
    open operator fun invoke(): String {
        return getDate()
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDate(): String {
        return SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().time)
    }
}