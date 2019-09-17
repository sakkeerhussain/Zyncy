package com.sakkeerhussain.filecache.data.request

import com.sakkeerhussain.filecache.ui.client.BaseTarget

interface RequestQueue {
    fun enqueue(request: Request, target: BaseTarget): Request
}