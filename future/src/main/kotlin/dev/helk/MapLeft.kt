package dev.helk

import java.util.concurrent.CompletableFuture

fun <T> CompletableFuture<T>.mapLeft(callback: (error: Throwable) -> Throwable ): CompletableFuture<T> =
    this.exceptionally {
        throw callback(it.cause ?: it)
    }