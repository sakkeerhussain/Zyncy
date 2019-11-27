package com.sakkeer.zyncy.data.request

import com.sakkeer.zyncy.client.BaseTarget

interface RequestQueue {
    fun getActiveRequests(): List<Request>
    fun enqueue(request: Request, target: BaseTarget): Request
    fun deque(request: Request)
    fun getExistingImageRequest(request: Request): Request?
}