import com.google.firebase.database.DataSnapshot

class DataLoader {

    private lateinit var data: List<Pair<String, String>>

    fun loadData(dataSnapshot: DataSnapshot): List<Pair<String, String>> {
        data = dataSnapshot.children.mapNotNull {
            val term = it.child("term").getValue(String::class.java)
            val definition = it.child("definition").getValue(String::class.java)
            if (term != null && definition != null) Pair(term, definition) else null
        }
        return data
    }
}
