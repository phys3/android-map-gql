package com.damjan.courts.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.damjan.courts.ui.add_event.AddEventScreen
import com.damjan.courts.ui.find_event.FindEventScreen
import com.damjan.courts.ui.home.HomeScreen
import javax.sql.DataSource

@Composable
fun CourtsNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination =  NavRoutes.Home.name,
        modifier = modifier
            .fillMaxSize()
    ) {
        composable(route = NavRoutes.Home.name) {
            HomeScreen(
                goToAdd = { navController.navigate(NavRoutes.AddEvent.name)},
                goToFind = { navController.navigate(NavRoutes.FindEvent.name)},
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            )
        }
        composable(route = NavRoutes.AddEvent.name) {
            AddEventScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            )
        }
        composable(route = NavRoutes.FindEvent.name) {
            FindEventScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            )
        }
    }
}