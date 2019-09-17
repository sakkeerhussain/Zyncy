package com.sakkeerhussain.filesync.data.request

import com.sakkeerhussain.filesync.ui.client.BaseTarget

interface RequestQueue {
    fun enqueue(request: Request, target: BaseTarget): Request
}