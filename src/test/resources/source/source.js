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

// noinspection BadExpressionStatementJS

({
    level1: {
        level2: {
            empty: null,
            literalEmpty: null,
            present: 1,
            boolean: false,
            int: 1,
            short: 2,
            byte: 3,
            bigInteger: 4,
            long: 4,
            double: 1.5,
            float: -1.5,
            bigDecimal: 1.5,
            char: "a",
            string: "string",
            offsetTime: "10:15:30+01:00",
            offsetDateTime: "2007-12-03T10:15:30+01:00",
            zonedDateTime: "2007-12-03T10:15:30+01:00[Europe/Paris]",
            localDate: "2007-12-03",
            localTime: "10:15:30",
            localDateTime: "2007-12-03T10:15:30",
            date: "2007-12-03T10:15:30Z",
            year: "2007",
            yearMonth: "2007-12",
            instant: "2007-12-03T10:15:30.00Z",
            duration: "P2DT3H4M",
            simpleDuration: "200millis",
            size: "10k",
            enum: "LABEL2",
            array: {
                boolean: [
                    true,
                    false
                ],
                byte: [
                    1,
                    2,
                    3
                ],
                short: [
                    1,
                    2,
                    3
                ],
                int: [
                    1,
                    2,
                    3
                ],
                long: [
                    4,
                    5,
                    6
                ],
                float: [
                    -1.0,
                    0.0,
                    1.0
                ],
                double: [
                    -1.0,
                    0.0,
                    1.0
                ],
                char: [
                    "a",
                    "b",
                    "c"
                ],
                object: {
                    boolean: [
                        true,
                        false
                    ],
                    int: [
                        1,
                        2,
                        3
                    ],
                    string: [
                        "one",
                        "two",
                        "three"
                    ],
                    enum: [
                        "LABEL1",
                        "LABEL2",
                        "LABEL3"
                    ]
                }
            },
            list: [
                1,
                2,
                3
            ],
            mutableList: [
                1,
                2,
                3
            ],
            listOfList: [
                [
                    1,
                    2
                ],
                [
                    3,
                    4
                ]
            ],
            set: [
                1,
                2,
                1
            ],
            sortedSet: [
                2,
                1,
                1,
                3
            ],
            map: {
                a: 1,
                b: 2,
                c: 3
            },
            intMap: {
                1: "a",
                2: "b",
                3: "c"
            },
            sortedMap: {
                c: 3,
                b: 2,
                a: 1
            },
            listOfMap: [
                {
                    a: 1,
                    b: 2
                },
                {
                    a: 3,
                    b: 4
                }
            ],
            nested: [
                [
                    [
                        {
                            a: 1
                        }
                    ]
                ]
            ],
            pair: {
                first: 1,
                second: 2
            },
            clazz: {
                empty: null,
                literalEmpty: null,
                present: 1,
                boolean: false,
                int: 1,
                short: 2,
                byte: 3,
                bigInteger: 4,
                long: 4,
                double: 1.5,
                float: -1.5,
                bigDecimal: 1.5,
                char: "a",
                string: "string",
                offsetTime: "10:15:30+01:00",
                offsetDateTime: "2007-12-03T10:15:30+01:00",
                zonedDateTime: "2007-12-03T10:15:30+01:00[Europe/Paris]",
                localDate: "2007-12-03",
                localTime: "10:15:30",
                localDateTime: "2007-12-03T10:15:30",
                date: "2007-12-03T10:15:30Z",
                year: "2007",
                yearMonth: "2007-12",
                instant: "2007-12-03T10:15:30.00Z",
                duration: "P2DT3H4M",
                simpleDuration: "200millis",
                size: "10k",
                enum: "LABEL2",
                booleanArray: [
                    true,
                    false
                ],
                nested: [
                    [
                        [
                            {
                                a: 1
                            }
                        ]
                    ]
                ]
            }
        }
    }
})