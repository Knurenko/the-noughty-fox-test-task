package com.example.thenoughtyfoxtestapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.thenoughtyfoxtestapp.presentation.screens.comments.MainScreenRoute
import com.example.thenoughtyfoxtestapp.presentation.screens.one_comment.FullCommentRoute

/**
 * @author Knurenko Bogdan 05.03.2024
 */
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            MainScreenRoute(onCommentSelected = { commentId -> navController.navigate("${Routes.COMMENT}/$commentId") })
        }
        composable(
            "${Routes.COMMENT}/{commentId}",
            arguments = listOf(navArgument("commentId") { type = NavType.IntType })
        ) { navBackStack ->
            val commentId = navBackStack.arguments?.getInt("commentId") ?: return@composable
            FullCommentRoute(commentId = commentId, onNavigateBack = { navController.navigateUp() })
        }
    }
}

object Routes {
    const val HOME = "home"
    const val COMMENT = "comment"
}