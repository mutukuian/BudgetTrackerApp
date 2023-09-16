package budgetTracker.app.domain.use_case

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class GetDateUseCase @Inject constructor() {
    private fun getDate():String{
        return  SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().time)
    }
}