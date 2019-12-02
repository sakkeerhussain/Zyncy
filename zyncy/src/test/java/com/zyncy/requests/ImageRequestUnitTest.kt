package com.zyncy.requests

import com.zyncy.client.ImageTarget
import com.zyncy.data.repository.ImageRepository
import com.zyncy.data.request.ImageRequest
import com.zyncy.data.request.ImageRequestBuilderImpl
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito

class ImageRequestUnitTest {

    val TEST_URL = "http://test.com/photo.jpg"
    val PLACE_HOLDER_IMAGE_RESOURCE_ID = 1
    val ERROR_IMAGE_RESOURCE_ID = 2

    @Test
    fun requestBuilderTest() {

        val mockImageRepository = Mockito.mock(ImageRepository::class.java)
        val mockTarget = Mockito.mock(ImageTarget::class.java)

        val request = ImageRequestBuilderImpl(mockImageRepository, TEST_URL)
            .addHeader("Authorization", "token goes here")
            .placeholder(PLACE_HOLDER_IMAGE_RESOURCE_ID)
            .errorImage(ERROR_IMAGE_RESOURCE_ID)
            .toTarget(mockTarget)

        assert(request is ImageRequest)

        val imageReqest = request as ImageRequest
        assertEquals(imageReqest.url, TEST_URL)
        assertEquals(imageReqest.placeHolderImageResource, PLACE_HOLDER_IMAGE_RESOURCE_ID)
        assertEquals(imageReqest.errorImageResource, ERROR_IMAGE_RESOURCE_ID)
        assertEquals(imageReqest.targets.size, 1)
        assertEquals(imageReqest.targets[0], mockTarget)
    }
}