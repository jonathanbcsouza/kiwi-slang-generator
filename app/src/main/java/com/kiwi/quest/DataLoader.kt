import com.google.firebase.database.DataSnapshot

class DataLoader {

    private lateinit var slangs: List<Pair<String, String>>

    fun loadSlangs(dataSnapshot: DataSnapshot): List<Pair<String, String>> {
        slangs = dataSnapshot.children.mapNotNull {
            val term = it.child("term").getValue(String::class.java)
            val definition = it.child("definition").getValue(String::class.java)
            if (term != null && definition != null) Pair(term, definition) else null
        }
        return slangs
    }
}
