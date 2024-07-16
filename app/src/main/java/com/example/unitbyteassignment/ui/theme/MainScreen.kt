import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.example.unitbyteassignment.ui.theme.UnitByteAssignmentTheme
import com.example.unitbyteassignment.R

@Composable
fun MainScreens() {
    // Dummy Lottie animation composition
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.lottie))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )

    // Dummy progress value (between 0.0 to 1.0)
    val songProgress = 0.33f

    UnitByteAssignmentTheme {
        Surface(color = Color.Black) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween, // Place items with space between
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Monday 15",
                        style = TextStyle(
                            color = Color(0xFFF3AFA8), // Peach color
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 48.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    LottieAnimation(
                        modifier = Modifier.size(700.dp), // Adjust size to 700dp
                        composition = composition,
                        progress = { progress }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Senorita",
                            style = TextStyle(
                                color = Color(0xFFF3AFA8),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            textAlign = TextAlign.Left,
                            modifier = Modifier.padding(start = 12.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f)) // Spacer to push icons to the left
                        IconButton(
                            onClick = { /* Handle Pause Icon Click */ },
                            modifier = Modifier
                                .size(48.dp)
                                .padding(end = 16.dp), // Add padding to the end (right side)
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.playbutton),
                                    contentDescription = "Pause",
                                    tint = Color.White // Set icon tint color directly
                                )
                            }
                        )
                        IconButton(
                            onClick = { /* Handle Next Icon Click */ },
                            modifier = Modifier.size(48.dp),
                            content = {
                                Icon(
                                    painter = painterResource(id = R.drawable.next),
                                    contentDescription = "Next",
                                    tint = Color.White // Set icon tint color directly
                                )
                            }
                        )

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Shawn Mendes, Camila Cabello",
                            style = TextStyle(
                                color = Color(0xFFF3AFA8),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            textAlign = TextAlign.Left,
                            modifier = Modifier.padding(start = 12.dp)
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                // LinearProgressIndicator placed at the bottom with padding and slight elevation
                LinearProgressIndicator(
                    progress = songProgress,
                    color = Color(0xFFF3AFA8), // Peach color
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 8.dp,
                            horizontal = 16.dp
                        ) // Add padding from bottom and sides
                        .offset(
                            y = (-60.dp) // Offset upwards by 8dp
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreens() {
    MainScreens()
}
