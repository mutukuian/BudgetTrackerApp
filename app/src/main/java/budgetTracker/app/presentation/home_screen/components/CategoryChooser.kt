package budgetTracker.app.presentation.home_screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import budgetTracker.app.R
import budgetTracker.app.presentation.home_screen.Category
import budgetTracker.app.presentation.home_screen.HomeViewModel
import budgetTracker.app.presentation.home_screen.IncomeCategory
import budgetTracker.app.presentation.util.spacing
import com.google.accompanist.flowlayout.FlowRow


@ExperimentalUnitApi
@Composable
fun Category(
    expenseItems: Array<Category> = Category.values()
) {
    FlowRow(
        crossAxisSpacing = MaterialTheme.spacing.small,
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.medium,
            top = MaterialTheme.spacing.medium,
            bottom = MaterialTheme.spacing.medium,
        ),
    ) {
        expenseItems.forEach {
            CategoryTag(category = it)
        }
    }
}@ExperimentalUnitApi
@Composable
fun IncomeCategory(
    expenseItems: Array<IncomeCategory> = IncomeCategory.values()
) {
    FlowRow(
        crossAxisSpacing = MaterialTheme.spacing.small,
        modifier = Modifier.padding(
            start = MaterialTheme.spacing.medium,
            top = MaterialTheme.spacing.medium,
            bottom = MaterialTheme.spacing.medium,
        ),
    ) {
        expenseItems.forEach {
            CategoryT(incomeCategory = it)
        }
    }
}

@ExperimentalUnitApi
@Composable
fun CategoryTag(category: Category,homeViewModel: HomeViewModel = hiltViewModel()) {
    val selected by homeViewModel.category.collectAsState()
    var isSelected = selected.title == category.title
    TextButton(
        modifier = Modifier.padding(end = MaterialTheme.spacing.small),
        onClick = {
            homeViewModel.selectCategory(category)
            isSelected = selected.title == category.title
        },
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.medium,
            vertical = MaterialTheme.spacing.small
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) {
                category.bgRes.copy(alpha = 0.95f)
            } else MaterialTheme.colors.surface, contentColor = if (isSelected) {
                category.colorRes
            } else MaterialTheme.colors.onSurface
        ),
    ) {
        Icon(
            painter = if (!isSelected) {
                painterResource(id = R.drawable.add_cat)
            } else painterResource(id = category.iconRes),
            contentDescription = category.title,
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
        Text(
            text = category.title,
            style = MaterialTheme.typography.button
        )
    }
}
@ExperimentalUnitApi
@Composable
fun CategoryT(incomeCategory:IncomeCategory,homeViewModel: HomeViewModel = hiltViewModel()) {
    val picked by homeViewModel.incomeCategory.collectAsState()
    var isSelected = picked.title == incomeCategory.title
    TextButton(
        modifier = Modifier.padding(end = MaterialTheme.spacing.small),
        onClick = {
            homeViewModel.selectIncomeCategory(incomeCategory)
            isSelected = picked.title == incomeCategory.title
        },
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.medium,
            vertical = MaterialTheme.spacing.small
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) {
                incomeCategory.bgRes.copy(alpha = 0.95f)
            } else MaterialTheme.colors.surface, contentColor = if (isSelected) {
                incomeCategory.colorRes
            } else MaterialTheme.colors.onSurface
        ),
    ) {
        Icon(
            painter = if (!isSelected) {
                painterResource(id = R.drawable.add_cat)
            } else painterResource(id = incomeCategory.iconRes),
            contentDescription = incomeCategory.title,
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
        Text(
            text = incomeCategory.title,
            style = MaterialTheme.typography.button
        )
    }
}



@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun CategoryPreview() {
    Category()
}