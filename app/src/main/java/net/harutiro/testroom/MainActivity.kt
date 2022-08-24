package net.harutiro.testroom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.*
import net.harutiro.testroom.ui.theme.TestRoomTheme

@OptIn(DelicateCoroutinesApi::class)
class MainActivity : ComponentActivity() {

    private lateinit var db:MemoDatabase
    private lateinit var dao:MemoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        this.db = Room.databaseBuilder(
            this,
            MemoDatabase::class.java,
            "memo.db"
        ).build()

        this.dao = this.db.memoDAO()





        setContent {
            TestRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    Column(

                    ){
                        Button(
                            onClick = {
                                GlobalScope.launch{
                                    val memo = Memo(id = 0,memo = "sample!!")
                                    dao.insert(memo)
                                }
                            }
                        ){
                            Text("insert")
                        }

                        Button(
                            onClick = {

                            }
                        ){
                            Text("test")
                        }
                    }


                }
            }
        }
    }

    override fun onStart(){
        super.onStart()

        this.dao.getAll().observe(this, Observer {
            println(it)
        })
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestRoomTheme {
//        Greeting("Android")
    }
}