package com.learning

data class TodoItem(
    val id: Int,
    val title: String,
    val isDone: Boolean,
    val createdAt: Long = System.currentTimeMillis()
)
