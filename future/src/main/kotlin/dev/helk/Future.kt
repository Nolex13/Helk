package dev.helk

import java.util.concurrent.CompletableFuture


fun <T> Future(callback: () -> T): CompletableFuture<T> =
    CompletableFuture.supplyAsync(callback)
        .exceptionally {
            val unwrappedError: Throwable = it.cause ?: it
            throw unwrappedError
        }