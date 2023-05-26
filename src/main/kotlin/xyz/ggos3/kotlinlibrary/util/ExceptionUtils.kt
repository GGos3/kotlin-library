package xyz.ggos3.kotlinlibrary.util

fun fail(
    message: String = ""
): Nothing {
    throw IllegalArgumentException(message)
}