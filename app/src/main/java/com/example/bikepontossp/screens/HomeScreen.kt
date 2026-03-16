package com.example.bikepontossp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryChargingFull
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.ElectricScooter
import androidx.compose.material.icons.filled.LocalParking
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Modelo de dados para pontos próximos
data class NearbyPoint(
    val name: String,
    val type: String,
    val distance: String,
    val isOpen: Boolean,
    val icon: ImageVector
)

// Categorias de filtro
data class Category(val label: String, val icon: ImageVector)

@Composable
fun HomeScreen(
    onProfileClick: () -> Unit = {}
) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    var selectedNavItem by remember { mutableIntStateOf(0) }

    val categories = listOf(
        Category("Todos", Icons.Default.Map),
        Category("Aluguel", Icons.Default.DirectionsBike),
        Category("Recarga", Icons.Default.BatteryChargingFull),
        Category("Ciclovia", Icons.Default.Route),
        Category("Estacionamento", Icons.Default.LocalParking)
    )

    val allPoints = listOf(
        NearbyPoint("Recarga Paulista", "Ponto de recarga", "180m", true, Icons.Default.BatteryChargingFull),
        NearbyPoint("Estação Bike SP", "Aluguel de bike", "340m", true, Icons.Default.DirectionsBike),
        NearbyPoint("Bicicletário Faria Lima", "Estacionamento", "520m", true, Icons.Default.LocalParking),
        NearbyPoint("Scooter Hub Pinheiros", "Aluguel de scooter", "750m", false, Icons.Default.ElectricScooter),
        NearbyPoint("Recarga Vila Madalena", "Ponto de recarga", "910m", true, Icons.Default.BatteryChargingFull)
    )

    val filteredPoints = if (selectedCategory == "Todos") allPoints else allPoints.filter {
        when (selectedCategory) {
            "Aluguel" -> it.type.contains("bike", ignoreCase = true)
            "Recarga" -> it.type.contains("recarga", ignoreCase = true)
            "Ciclovia" -> it.type.contains("ciclovia", ignoreCase = true)
            "Estacionamento" -> it.type.contains("estacionamento", ignoreCase = true)
            else -> true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Mapa placeholder (substituir por GoogleMap quando integrar)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(Color(0xFF0A120A))
        ) {
            // Placeholder visual do mapa
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF0D160D))
            ) {
                Text(
                    text = "Mapa",
                    color = Color(0xFF2A3A2A),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            // Header sobre o mapa
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.Black.copy(alpha = 0.75f),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "BikePontos SP",
                        color = Color(0xFFB6FF00),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFB6FF00))
                        .padding(1.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "VL",
                        color = Color.Black,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Indicador de localização central
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .align(Alignment.Center)
                    .background(Color(0xFFB6FF00), CircleShape)
                    .padding(2.dp)
            )
        }

        // Conteúdo principal
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .background(Color.Black)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .padding(top = 16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // Saudação + pontos
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column {
                        Text(
                            text = "Bom dia,",
                            color = Color.White.copy(alpha = 0.4f),
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Vinicius",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFFB6FF00).copy(alpha = 0.10f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "1.240",
                                color = Color(0xFFB6FF00),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "pontos",
                                color = Color(0xFFB6FF00).copy(alpha = 0.6f),
                                fontSize = 10.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Chips de categoria
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(categories) { category ->
                        FilterChip(
                            selected = selectedCategory == category.label,
                            onClick = { selectedCategory = category.label },
                            label = {
                                Text(
                                    text = category.label,
                                    fontSize = 11.sp
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = category.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(14.dp)
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFFB6FF00),
                                selectedLabelColor = Color.Black,
                                selectedLeadingIconColor = Color.Black,
                                containerColor = Color.White.copy(alpha = 0.06f),
                                labelColor = Color.White.copy(alpha = 0.5f),
                                iconColor = Color.White.copy(alpha = 0.5f)
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = selectedCategory == category.label,
                                borderColor = Color.White.copy(alpha = 0.12f),
                                selectedBorderColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Título da lista
            item {
                Text(
                    text = "Próximos a você",
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Cards dos pontos
            items(filteredPoints) { point ->
                NearbyPointCard(point = point)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Bottom Navigation
        NavigationBar(
            containerColor = Color.Black,
            tonalElevation = 0.dp,
            modifier = Modifier.navigationBarsPadding()
        ) {
            val navItems = listOf(
                Pair("Home", Icons.Default.Map),
                Pair("Explorar", Icons.Default.NearMe),
                Pair("Pontos", Icons.Default.Star),
                Pair("Perfil", Icons.Default.Person)
            )

            navItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedNavItem == index,
                    onClick = {
                        selectedNavItem = index
                        if (index == 3) onProfileClick()
                    },
                    icon = {
                        Icon(
                            imageVector = item.second,
                            contentDescription = item.first,
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    label = {
                        Text(text = item.first, fontSize = 10.sp)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFB6FF00),
                        selectedTextColor = Color(0xFFB6FF00),
                        unselectedIconColor = Color.White.copy(alpha = 0.3f),
                        unselectedTextColor = Color.White.copy(alpha = 0.3f),
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

@Composable
fun NearbyPointCard(point: NearbyPoint) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.04f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = Color.White.copy(alpha = 0.09f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ícone
            Box(
                modifier = Modifier
                    .size(38.dp)
                    .background(
                        color = Color(0xFFB6FF00).copy(alpha = 0.12f),
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = point.icon,
                    contentDescription = null,
                    tint = Color(0xFFB6FF00),
                    modifier = Modifier.size(18.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            // Info
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = point.name,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(2.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = point.type,
                        color = Color.White.copy(alpha = 0.35f),
                        fontSize = 11.sp
                    )
                    Text(
                        text = " · ",
                        color = Color.White.copy(alpha = 0.2f),
                        fontSize = 11.sp
                    )
                    Text(
                        text = if (point.isOpen) "Aberto" else "Fechado",
                        color = if (point.isOpen) Color(0xFFB6FF00) else Color.Red.copy(alpha = 0.7f),
                        fontSize = 11.sp
                    )
                }
            }

            // Distância
            Text(
                text = point.distance,
                color = Color(0xFFB6FF00),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    HomeScreen()
}
