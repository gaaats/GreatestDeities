package com.kiloo.subwaysurfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kiloo.subwaysurfo.GooodClass.Companion.dfrrgtgjsoupCheck
import com.kiloo.subwaysurfo.GooodClass.Companion.oooooooooone
import com.kiloo.subwaysurfo.GooodClass.Companion.tvoooooooooooo
import com.kiloo.subwaysurfo.databinding.ActivityMainBinding
import com.kiloo.subwaysurfo.gamagame.GameHoolderActivity
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var jsoupfrgt: String

    lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        jsoupfrgt = ""
        val jobaaaaa = GlobalScope.launch(Dispatchers.IO) {
            jsoupfrgt = coTaskdfrgt()
        }

        runBlocking {
            try {
                jobaaaaa.join()

                if (jsoupfrgt == dfrrgtgjsoupCheck) {
                    Intent(applicationContext, GameHoolderActivity::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, LeeeetsDoNotDoNotActivity::class.java).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }
    private fun frtghyyhyyh(link: String) {
        val uuuuuuuurl = URL(link)
        val urlConnectionnnnnnnnn = uuuuuuuurl.openConnection() as HttpURLConnection

        try {
            val rgtgthy = urlConnectionnnnnnnnn.inputStream.bufferedReader().readText()
            if (rgtgthy.isNotEmpty()) {

                jsoupfrgt = rgtgthy
            }
        } catch (ex: Exception) {

        } finally {
            urlConnectionnnnnnnnn.disconnect()
        }
    }


    private suspend fun coTaskdfrgt(): String {

        val forJsoupSetNamingftgtt =
            "${oooooooooone}${tvoooooooooooo}"

        withContext(Dispatchers.IO) {
            frtghyyhyyh(forJsoupSetNamingftgtt)
        }
        return jsoupfrgt
    }


}
