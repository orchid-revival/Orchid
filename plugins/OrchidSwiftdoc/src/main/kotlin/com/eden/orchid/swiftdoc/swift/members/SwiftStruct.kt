package com.eden.orchid.swiftdoc.swift.members

import com.eden.orchid.api.OrchidContext
import com.eden.orchid.swiftdoc.swift.SwiftAttributes
import com.eden.orchid.swiftdoc.swift.SwiftMember
import com.eden.orchid.swiftdoc.swift.SwiftStatement
import org.json.JSONObject

class SwiftStruct(context: OrchidContext, data: JSONObject, origin: SwiftStatement)
    : SwiftMember(context, data, "struct", origin),
        SwiftAttributes {

    override lateinit var attributes: List<String>

    override fun init() {
        super.init()
        initAttributes(data)
    }
}