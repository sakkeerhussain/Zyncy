package com.sakkeer.filesync.data.request

import com.sakkeer.filesync.client.BaseTarget

interface RequestQueue {
    fun getActiveRequests(): List<Request>
    fun enqueue(request: Request, target: BaseTarget): Request
    fun deque(request: Request)
}