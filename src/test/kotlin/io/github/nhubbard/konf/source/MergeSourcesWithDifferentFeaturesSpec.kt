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

package io.github.nhubbard.konf.source

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import io.github.nhubbard.konf.Config
import io.github.nhubbard.konf.source.helpers.ServicingConfig
import io.github.nhubbard.konf.source.helpers.mergeSourcesWithDifferentFeaturesContent
import io.github.nhubbard.konf.source.hocon.hocon
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object MergeSourcesWithDifferentFeaturesSpec : Spek({
    on("load from merged sources") {
        val config = Config {
            addSpec(ServicingConfig)
        }.withSource(
            Source.from.hocon.string(mergeSourcesWithDifferentFeaturesContent) + Source.from.env()
        )
        it("should contain the item") {
            assertThat(config[ServicingConfig.baseURL], equalTo("https://service/api"))
            assertThat(config[ServicingConfig.url], equalTo("https://service/api/index.html"))
        }
    }
})
