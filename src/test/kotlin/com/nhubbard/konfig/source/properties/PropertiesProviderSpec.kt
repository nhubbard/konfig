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

package com.nhubbard.konfig.source.properties

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.nhubbard.konfig.source.asValue
import com.nhubbard.konfig.tempFileOf
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.jetbrains.spek.subject.itBehavesLike

object PropertiesProviderSpec : SubjectSpek<PropertiesProvider>({
    subject { PropertiesProvider }

    given("a properties provider") {
        on("create source from reader") {
            val source = subject.reader("type = reader".reader())
            it("should have correct type") {
                assertThat(source.info["type"], equalTo("properties"))
            }
            it("should return a source which contains value from reader") {
                assertThat(source["type"].asValue<String>(), equalTo("reader"))
            }
        }
        on("create source from input stream") {
            val source = subject.inputStream(
                tempFileOf("type = inputStream").inputStream()
            )
            it("should have correct type") {
                assertThat(source.info["type"], equalTo("properties"))
            }
            it("should return a source which contains value from input stream") {
                assertThat(source["type"].asValue<String>(), equalTo("inputStream"))
            }
        }
        on("create source from system properties") {
            System.setProperty("type", "system")
            val source = subject.system()
            it("should have correct type") {
                assertThat(source.info["type"], equalTo("system-properties"))
            }
            it("should return a source which contains value from system properties") {
                assertThat(source["type"].asValue<String>(), equalTo("system"))
            }
        }
        on("create source from an empty file") {
            val file = tempFileOf("")
            it("should return an empty source") {
                assertThat(
                    subject.file(file).tree.children,
                    equalTo(mutableMapOf())
                )
            }
        }
    }
})

object PropertiesProviderInJavaSpec : SubjectSpek<PropertiesProvider>({
    subject { PropertiesProvider.get() }

    itBehavesLike(PropertiesProviderSpec)
})