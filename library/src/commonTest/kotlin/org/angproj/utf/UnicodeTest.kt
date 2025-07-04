package org.angproj.utf

import kotlin.math.max
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class UnicodeTest : UnicodeAware {

    fun languageForEach(action: (Language) -> Unit): Unit {
        Language.entries.forEach { action(it) }
    }

    fun languageScriptBlockForEach(language: Language, action: (UtfBlock) -> Unit) {
        language.lang.scripts.forEach { script ->
            script.blocks.forEach { block ->
                action(block)
            }
        }
    }

    @Test
    fun testLanguagesPassthrough() = languageForEach { language ->
        val policy = Policy(FilterPolicy.PASSTHROUGH, Unicode.createFilter(language))
        languageScriptBlockForEach(language) { block ->
            val rangeSize = block.range.sumOf { octetSize(it) } - block.noUse.sumOf { octetSize(it) }
            val buffer = DummyBuffer(ByteArray(rangeSize), policy)
            block.range.forEach { cp ->
                if(cp !in block.noUse) buffer.write(cp.toCodePoint())
            }
            buffer.rewind()
            block.range.forEach { cp ->
                if(cp !in block.noUse) assertEquals(cp, buffer.read().value)
            }
        }
    }

    @Test
    fun testLanguagesPassthroughNoUse() = languageForEach { language ->
        val policy = Policy(FilterPolicy.PASSTHROUGH, Unicode.createFilter(language))
        languageScriptBlockForEach(language) { block ->
            val noUseSize = block.noUse.sumOf { octetSize(it) }
            val noUseList = block.noUse.toList()
            val buffer = DummyBuffer(ByteArray(noUseSize), policy)
            noUseList.forEach { cp ->
                buffer.write(cp.toCodePoint())
            }
            buffer.rewind()
            noUseList.forEach { cp ->
                assertEquals(cp, buffer.read().value)
            }
        }
    }

    @Test
    fun testLanguagesEscape() = languageForEach { language ->
        val policy = Policy(FilterPolicy.ESCAPE, Unicode.createFilter(language))
        languageScriptBlockForEach(language) { block ->
            val rangeSize = block.range.sumOf { octetSize(it) } - block.noUse.sumOf { octetSize(it) }
            val buffer = DummyBuffer(ByteArray(rangeSize), policy)
            block.range.forEach { cp ->
                if(cp !in block.noUse) buffer.write(cp.toCodePoint())
            }
            buffer.rewind()
            block.range.forEach { cp ->
                if(cp !in block.noUse) assertEquals(cp, buffer.read().value)
            }
        }
    }

    @Test
    fun testLanguagesEscapeNoUseRead() = languageForEach { language ->
        val policy = Policy(FilterPolicy.ESCAPE, Unicode.createFilter(language))

        languageScriptBlockForEach(language) { block ->
            val noUseList = block.noUse.toList()
            val buffer = DummyBuffer(ByteArray(4), policy)

            noUseList.forEach { cp ->
                buffer.rewind()
                buffer.writeTrust(cp.toCodePoint())
                buffer.rewind()
                assertEquals(AbstractUnicodeAware.REPLACEMENT_CHARACTER, buffer.read().value)
            }
        }
    }

    @Test
    fun testLanguagesEscapeNoUseWrite() = languageForEach { language ->
        val policy = Policy(FilterPolicy.ESCAPE, Unicode.createFilter(language))

        languageScriptBlockForEach(language) { block ->
            val noUseSize = max(block.noUse.sumOf { octetSize(it) }, block.noUse.size * AbstractUnicodeAware.REPLACEMENT_CHARACTER_SIZE)
            val noUseList = block.noUse.toList()
            val buffer = DummyBuffer(ByteArray(noUseSize), policy)

            noUseList.forEach { cp ->
                buffer.rewind()
                buffer.write(cp.toCodePoint())
                buffer.rewind()
                assertEquals(AbstractUnicodeAware.REPLACEMENT_CHARACTER, buffer.readTrust().value)
            }
        }
    }

    @Test
    fun testLanguagesSecurity() = languageForEach { language ->
        val policy = Policy(FilterPolicy.SECURITY, Unicode.createFilter(language))

        languageScriptBlockForEach(language) { block ->
            val rangeSize = block.range.sumOf { octetSize(it) } - block.noUse.sumOf { octetSize(it) }
            val buffer = DummyBuffer(ByteArray(rangeSize), policy)

            block.range.forEach { cp ->
                if(cp !in block.noUse) buffer.write(cp.toCodePoint())
            }
            buffer.rewind()
            block.range.forEach { cp ->
                if(cp !in block.noUse) assertEquals(cp, buffer.read().value)
            }
        }
    }

    @Test
    fun testLanguagesSecurityNoUseRead() = languageForEach { language ->
        val policy = Policy(FilterPolicy.SECURITY, Unicode.createFilter(language))

        languageScriptBlockForEach(language) { block ->
            val buffer = DummyBuffer(ByteArray(4), policy)
            val noUseList = block.noUse.toList()

            noUseList.forEach { cp ->
                buffer.rewind()
                buffer.writeTrust(cp.toCodePoint())
                buffer.rewind()
                assertFailsWith<UnicodeError> {
                    buffer.read()
                }
            }
        }
    }

    @Test
    fun testLanguagesSecurityNoUseWrite() = languageForEach { language ->
        val policy = Policy(FilterPolicy.SECURITY, Unicode.createFilter(language))

        languageScriptBlockForEach(language) { block ->
            val buffer = DummyBuffer(ByteArray(4), policy)
            val noUseList = block.noUse.toList()

            noUseList.forEach { cp ->
                buffer.rewind()
                assertFailsWith<UnicodeError> {
                    buffer.write(cp.toCodePoint())
                }
            }
        }
    }
}