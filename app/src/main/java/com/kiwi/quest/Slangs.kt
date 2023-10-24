import android.content.Context
import java.util.Random

class Slangs(context: Context) {
    private val dataLoader = DataLoader(context)
    private val slangs = dataLoader.loadSlangs()

    internal fun getSlangs(): Pair<String, String> {
        val slangGenerator = Random()
        val randomNumber = slangGenerator.nextInt(slangs.size)
        return slangs[randomNumber]
    }
}
