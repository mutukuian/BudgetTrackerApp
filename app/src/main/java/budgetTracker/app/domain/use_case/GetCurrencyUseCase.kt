package budgetTracker.app.domain.use_case

import budgetTracker.app.domain.model.CurrencyModel
import java.util.*
import javax.inject.Inject

class GetCurrencyUseCase @Inject constructor() {

    operator fun invoke():List<CurrencyModel>{
        val currencies = mutableListOf<CurrencyModel>()
        val countries = mutableListOf<String>()
        val allLocal = Locale.getAvailableLocales()

        allLocal.forEach { locale ->
            val countryName = locale.displayCountry

            try {
                val  currencyCode = Currency.getInstance(locale).currencyCode
                val currency = Currency.getInstance(currencyCode)

                val currencySymbol = currency.getSymbol(locale)

                val currencyModel =CurrencyModel(countryName,currencyCode,currencySymbol)
                if (countryName.trim().isNotEmpty() && !countries.contains(countryName))
                    countries.add(countryName)
                currencies.add(currencyModel)
            }catch (e:Exception){ }
        }
        return currencies.sortedBy { it.country }
    }
}