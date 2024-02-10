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

package com.nhubbard.konfig.source.base

import com.nhubbard.konfig.ConfigSpec
import java.io.Serializable

object FlatConfigForLoad : ConfigSpec("level1.level2") {
    val emptyList by required<List<Int>>()
    val emptySet by required<Set<Int>>()
    val emptyArray by required<IntArray>()
    val emptyObjectArray by required<Array<Int>>()
    val singleElementList by required<List<Int>>()
    val multipleElementsList by required<List<Int>>()
    val flatClass by required<ClassForLoad>()
}

data class ClassForLoad(
    val stringWithComma: String,
    val emptyList: List<Int>,
    val emptySet: Set<Int>,
    val emptyArray: IntArray,
    val emptyObjectArray: Array<Int>,
    val singleElementList: List<Int>,
    val multipleElementsList: List<Int>
) : Serializable