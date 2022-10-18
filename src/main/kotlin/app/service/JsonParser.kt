package app.service

import app.data.Test
import com.google.gson.Gson
import org.springframework.stereotype.Component
import java.io.File

@Component
class JsonParser {

    fun parse(JsonFile: String): Test {
        val gson = Gson()
        val file = File(JsonFile).readText()
        return gson.fromJson(file, Test::class.java)
    }
}
