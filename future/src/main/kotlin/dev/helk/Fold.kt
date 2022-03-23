package dev.helk

import java.util.concurrent.CompletableFuture

fun <T> CompletableFuture<T>.fold(
    onFailure: (throwable: Throwable) -> T,
    onSuccess: (result: T) -> T
): CompletableFuture<T> =
    this.thenApply {
        onSuccess(it)
    }.exceptionally {
        onFailure(it.cause ?: it)
    }