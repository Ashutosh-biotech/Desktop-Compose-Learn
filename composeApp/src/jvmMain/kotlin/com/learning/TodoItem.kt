package com.learning

data class TodoItem(
    val id: Int,
    val text: String,
    val isDone: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)
