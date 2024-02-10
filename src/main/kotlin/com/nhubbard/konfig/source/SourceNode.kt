/*
 * Copyright (c) 2017-2024 Uchuhimo
 * Copyright (c) 2024-present Nicholas Hubbard
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for specific language governing permissions and
 * limitations under the License.
 */

package com.nhubbard.konfig.source

import com.nhubbard.konfig.*
import java.util.*

interface SubstitutableNode : ValueNode {
    fun substitute(value: String): TreeNode
    val substituted: Boolean
    val originalValue: Any?
}

class ValueSourceNode(
    override val value: Any,
    override val substituted: Boolean = false,
    override val originalValue: Any? = null
) : SubstitutableNode {
    override fun substitute(value: String): TreeNode {
        return ValueSourceNode(value, true, originalValue ?: this.value)
    }
}

object NullSourceNode : NullNode {
    override val children: MutableMap<String, TreeNode> = emptyMutableMap
}

open class ListSourceNode(
    override val list: List<TreeNode>,
    override var isPlaceHolder: Boolean = false
) : ListNode, MapNode {
    override val children: MutableMap<String, TreeNode>
        get() = Collections.unmodifiableMap(
            list.withIndex().associate { (key, value) -> key.toString() to value }
        )

    override fun withList(list: List<TreeNode>): ListNode {
        return ListSourceNode(list)
    }
}