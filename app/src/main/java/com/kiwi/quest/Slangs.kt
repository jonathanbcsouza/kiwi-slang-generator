import java.util.Random


class Slangs(private val slangs: List<Pair<String, String>>) {

    internal fun getSlangs(): Pair<String, String> {
        val slangGenerator = Random()
        val randomNumber = slangGenerator.nextInt(slangs.size)
        return slangs[randomNumber]
    }
}

