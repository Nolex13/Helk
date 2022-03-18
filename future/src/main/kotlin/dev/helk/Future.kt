package dev.helk

import java.util.concurrent.CompletableFuture


@Suppress("FunctionName")
fun <T> Future(callback: () -> T): CompletableFuture<T> =
    CompletableFuture.supplyAsync(callback)
        .exceptionally {
            throw it.cause ?: it
        }