package com.sakkeerhussain.filesync.data.request

import com.sakkeerhussain.filesync.client.BaseTarget

interface RequestQueue {
    fun enqueue(request: Request, target: BaseTarget): Request
}