package wovelizer
    
class Wovelizer(words: List<String>) { 
    val WOVELS: List<Char> = listOf('A', 'E', 'I', 'O', 'U')
    val wordMap: MutableMap<String, Int> = doWordMap(words)
    
    private fun doWordMap(words: List<String>): MutableMap<String, Int>{
        var wordMap: MutableMap<String, Int> = mutableMapOf<String, Int>()
        for(word in words) wordMap[word] = wordWovelCount(word)
        return wordMap
    }
    
    private fun wordWovelCount(word: String): Int {
        var total: Int = 0
        for(target in WOVELS) total += word.uppercase().filter { it == target }.count()
        return total
    }

    fun getWords(wovelCount: String): MutableList<String> {
        val words: MutableList<String> = mutableListOf<String>()
        wordMap.filter { it.value == wovelCount.toInt() }.forEach { words.add(it.key) }
        return words
    }
}


fun main() {
    val logic: Wovelizer = Wovelizer(getInput())
    
    while(true) {

        println("Desired wovel count? [ 'end' to stop]")
        val amount: String = readLine()!!.toString()
        if(amount == "end") break
        val found: List<String> = logic.getWords(amount)
        found.forEach { print(it + "\n") }

    }
}


fun getInput(): List<String> {
    println("Enter # of words, you want to wovelize.")
    val amount: Int = readLine()!!.toInt()
    var words: MutableList<String> = mutableListOf<String>()
    
    for(i in 1..amount) {
        println("Enter word #" + i.toString())
        words.add(readLine()!!.toString())
    }
    
    return words
}

main()