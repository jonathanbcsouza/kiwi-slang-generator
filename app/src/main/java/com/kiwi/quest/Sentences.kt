import java.util.Random


class Sentences(private val data: List<Pair<String, String>>) {

    internal fun getSlangs(): Pair<String, String> {
        val randomizedData = Random()
        val randomNumber = randomizedData.nextInt(data.size)
        return data[randomNumber]
    }
}

