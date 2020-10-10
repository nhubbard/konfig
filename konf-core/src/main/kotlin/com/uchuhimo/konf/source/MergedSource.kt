/*
 * Copyright 2017-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uchuhimo.konf.source

import com.uchuhimo.konf.Feature
import com.uchuhimo.konf.MergedMap
import com.uchuhimo.konf.Path
import com.uchuhimo.konf.TreeNode
import java.util.Collections

class MergedSource(val facade: Source, val fallback: Source) : Source {
    override val info: SourceInfo = SourceInfo(
        "facade" to facade.description,
        "fallback" to fallback.description
    )

    override val tree: TreeNode = facade.tree.withFallback(fallback.tree)

    override val features: Map<Feature, Boolean>
        get() = MergedMap(
            Collections.unmodifiableMap(fallback.features),
            Collections.unmodifiableMap(facade.features)
        )

    override fun substituted(root: Source, enabled: Boolean, errorWhenUndefined: Boolean): Source {
        val substitutedFacade = facade.substituted(root, enabled, errorWhenUndefined)
        val substitutedFallback = fallback.substituted(root, enabled, errorWhenUndefined)
        if (substitutedFacade === facade && substitutedFallback === fallback) {
            return this
        } else {
            return MergedSource(substitutedFacade, substitutedFallback)
        }
    }

    override fun lowercased(enabled: Boolean): Source {
        val lowercasedFacade = facade.lowercased(enabled)
        val lowercasedFallback = fallback.lowercased(enabled)
        if (lowercasedFacade === facade && lowercasedFallback === fallback) {
            return this
        } else {
            return MergedSource(lowercasedFacade, lowercasedFallback)
        }
    }

    override fun littleCamelCased(enabled: Boolean): Source {
        val littleCamelCasedFacade = facade.littleCamelCased(enabled)
        val littleCamelCasedFallback = fallback.littleCamelCased(enabled)
        if (littleCamelCasedFacade === facade && littleCamelCasedFallback === fallback) {
            return this
        } else {
            return MergedSource(littleCamelCasedFacade, littleCamelCasedFallback)
        }
    }

    override fun getNodeOrNull(path: Path, lowercased: Boolean, littleCamelCased: Boolean): TreeNode? {
        val facadeNode = facade.getNodeOrNull(path, lowercased, littleCamelCased)
        val fallbackNode = fallback.getNodeOrNull(path, lowercased, littleCamelCased)
        return if (facadeNode != null) {
            if (fallbackNode != null) {
                facadeNode.withFallback(fallbackNode)
            } else {
                facadeNode
            }
        } else {
            fallbackNode
        }
    }
}
