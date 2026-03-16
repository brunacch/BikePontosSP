package com.example.bikepontossp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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

data class Achievement(
    val icon: ImageVector,
    val label: String,
    val earned: Boolean
)

data class MenuItem(
    val icon: ImageVector,
    val label: String,
    val isDanger: Boolean = false
)

@Composable
fun UserProfileScreen(
    onHomeClick: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    var selectedNavItem by remember { mutableIntStateOf(3) }

    val achievements = listOf(
        Achievement(Icons.Default.EmojiEvents, "Primeiro check-in", true),
        Achievement(Icons.Default.Star, "5 visitas", true),
        Achievement(Icons.Default.DirectionsBike, "Ciclista ativo", true),
        Achievement(Icons.Default.Route, "10 trajetos", false),
        Achievement(Icons.Default.Lock, "Desbloqueie", false)
    )

    val menuItems = listOf(
        MenuItem(Icons.Default.Person, "Editar perfil"),
        MenuItem(Icons.Default.Timeline, "Histórico de trajetos"),
        MenuItem(Icons.Default.Settings, "Configurações"),
        MenuItem(Icons.Default.ExitToApp, "Sair da conta", isDanger = true)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // Header
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFF0A120A)
                        )
                        .statusBarsPadding()
                        .padding(horizontal = 18.dp, vertical = 14.dp)
                ) {
                    // Título + engrenagem
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Meu Perfil",
                            color = Color.White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .background(
                                    color = Color.White.copy(alpha = 0.07f),
                                    shape = CircleShape
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color.White.copy(alpha = 0.12f),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Configurações",
                                tint = Color.White.copy(alpha = 0.5f),
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Avatar + info
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(58.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFB6FF00))
                                .border(
                                    width = 3.dp,
                                    color = Color(0xFFB6FF00).copy(alpha = 0.3f),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "VL",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column {
                            Text(
                                text = "Vinicius Lima",
                                color = Color.White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "vini@email.com",
                                color = Color.White.copy(alpha = 0.35f),
                                fontSize = 11.sp
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFB6FF00).copy(alpha = 0.1f),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color(0xFFB6FF00).copy(alpha = 0.25f),
                                        shape = RoundedCornerShape(20.dp)
                                    )
                                    .padding(horizontal = 8.dp, vertical = 3.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(0xFFB6FF00),
                                    modifier = Modifier.size(10.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Ciclista Prata",
                                    color = Color(0xFFB6FF00),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Stats
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf(
                            Pair("1.240", "Pontos"),
                            Pair("47", "Check-ins"),
                            Pair("12", "Conquistas")
                        ).forEach { (value, label) ->
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .background(
                                        color = Color.White.copy(alpha = 0.04f),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.White.copy(alpha = 0.08f),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .padding(vertical = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = value,
                                        color = Color(0xFFB6FF00),
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = label,
                                        color = Color.White.copy(alpha = 0.3f),
                                        fontSize = 9.sp
                                    )
                                }
                            }
                        }
                    }
                }

                HorizontalDivider(color = Color.White.copy(alpha = 0.07f), thickness = 1.dp)
            }

            // Conquistas
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "CONQUISTAS RECENTES",
                    color = Color(0xFFB6FF00).copy(alpha = 0.5f),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.07.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(achievements) { achievement ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .background(
                                        color = if (achievement.earned)
                                            Color(0xFFB6FF00).copy(alpha = 0.12f)
                                        else
                                            Color.White.copy(alpha = 0.04f),
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = if (achievement.earned)
                                            Color(0xFFB6FF00).copy(alpha = 0.25f)
                                        else
                                            Color.White.copy(alpha = 0.08f),
                                        shape = RoundedCornerShape(12.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = achievement.icon,
                                    contentDescription = achievement.label,
                                    tint = if (achievement.earned)
                                        Color(0xFFB6FF00)
                                    else
                                        Color.White.copy(alpha = 0.2f),
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(color = Color.White.copy(alpha = 0.07f), thickness = 1.dp)
            }

            // Menu de conta
            item {
                Spacer(modifier = Modifier.height(14.dp))
                Text(
                    text = "CONTA",
                    color = Color(0xFFB6FF00).copy(alpha = 0.5f),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.07.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
            }

            items(menuItems) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                color = if (item.isDanger)
                                    Color.Red.copy(alpha = 0.08f)
                                else
                                    Color(0xFFB6FF00).copy(alpha = 0.1f),
                                shape = RoundedCornerShape(9.dp)
                            )
                            .border(
                                width = 1.dp,
                                color = if (item.isDanger)
                                    Color.Red.copy(alpha = 0.15f)
                                else
                                    Color(0xFFB6FF00).copy(alpha = 0.2f),
                                shape = RoundedCornerShape(9.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = if (item.isDanger) Color.Red.copy(alpha = 0.8f) else Color(0xFFB6FF00),
                            modifier = Modifier.size(15.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = item.label,
                        color = if (item.isDanger)
                            Color.Red.copy(alpha = 0.8f)
                        else
                            Color.White.copy(alpha = 0.75f),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )

                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = Color.White.copy(alpha = 0.2f),
                        modifier = Modifier.size(16.dp)
                    )
                }

                if (!menuItems.last().label.equals(item.label)) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Color.White.copy(alpha = 0.06f),
                        thickness = 1.dp
                    )
                }
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
                        if (index == 0) onHomeClick()
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfilePreview() {
    UserProfileScreen()
}
