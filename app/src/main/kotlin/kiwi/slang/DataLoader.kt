import android.content.Context
import org.json.JSONObject
import java.io.InputStream

class DataLoader(private val context: Context) {

    fun loadSlangs(): List<Pair<String, String>> {
        val inputStream: InputStream = context.assets.open("data.json")
        val jsonText = inputStream.bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonText)
        val jsonArray = jsonObject.getJSONArray("slangs")
        return List(jsonArray.length()) { i ->
            val item = jsonArray.getJSONObject(i)
            Pair(item.getString("term"), item.getString("definition"))
        }
    }
}
