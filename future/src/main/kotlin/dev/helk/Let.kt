package dev.helk

import java.util.concurrent.CompletableFuture

fun <T> CompletableFuture<T>.let(callback: (result: T) -> Unit){
    callback(this.join())
}