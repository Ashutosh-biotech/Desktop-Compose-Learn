package com.learning

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class TodoViewModel {
    var items by mutableStateOf(listOf<TodoItem>())
        private set
    var filter by mutableStateOf("All")
        private set
    private var nextId = 0

    fun add(text: String) {
        if (text.isBlank()) return
        items = items + TodoItem(id = nextId++, text = text.trim())
    }

    fun toggle(id: Int) {
        items = items.map { if (it.id == id) it.copy(isDone = !it.isDone) else it }
    }

    fun delete(id: Int) {
        items = items.filter { it.id != id }
    }

    fun setFilter(f: String) { filter = f }

    val filtered get() = when (filter) {
        "Active" -> items.filter { !it.isDone }
        "Done"   -> items.filter {  it.isDone }
        else     -> items
    }

    val doneCount   get() = items.count {  it.isDone }
    val activeCount get() = items.count { !it.isDone }
}