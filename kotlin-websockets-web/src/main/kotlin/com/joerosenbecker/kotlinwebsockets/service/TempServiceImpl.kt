package com.joerosenbecker.kotlinwebsockets.service

import org.springframework.stereotype.Service

@Service
class TempServiceImpl : TempService {
    override fun something(): String {
        return "Thing";
    }
}