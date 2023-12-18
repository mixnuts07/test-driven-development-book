// https://jp-seemore.com/app/14920/#toc10
package unitSample

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import org.junit.jupiter.api.assertThrows
import javax.xml.crypto.Data

class SampleTest {
    @Test
    fun `足し算の結果が正しいことを確認する`() {
        val result = 3 + 2;
        assertEquals(5, result, "3+2は5である")
    }
}

class AssertionTest {
    @Test
    fun `リストに特定の要素が含まれていることを確認する`() {
        val list = listOf("apple", "banana", "cherry")
        assertTrue("apple" in list, "リストにappleが含まれているべき")
    }
}

class MockTest {
    interface FruitService {
        fun getPrice(fruit: String): Int
    }
    @Test
    fun `リスト内の果物の価格を取得する`() {
        val mockService = mockk<FruitService>()

        every { mockService.getPrice("apple") } returns 100
        every { mockService.getPrice("banana") } returns 200

        val applePrice = mockService.getPrice("apple")
        val bananaPrice = mockService.getPrice("banana")

        assertEquals(100, applePrice, "appleの価格は100円であるべき")
        assertEquals(200, bananaPrice, "bananaの価格は200円であるべき")
    }
}

class GroupingTest {
    @Nested
    inner class AppleTests {
        @Test
        fun `appleのテスト1`() {
            assertEquals(1,1)
        }
        @Test
        fun `appleのテスト2`() {
            assertEquals(2, 2)
        }
    }
    @Nested
    inner class BananaTests {
        @Test
        fun `bananaのテスト1`() {
            assertEquals(3, 3)
        }
    }
}

class ExceptionService {
    fun divide(a: Int, b: Int): Int {
        if (b == 0) {
           throw IllegalArgumentException("0での除算はできません")
        }
        return a / b
    }
}
class ExceptionHandlerTest {
    @Test
    fun `0で除算した際に例外が投げられていることを検証する`() {
        val exceptionService = ExceptionService()
        val exception = assertThrows<IllegalArgumentException>{exceptionService.divide(10,0)}
        assert(exception.message == "0での除算はできません")
    }
}

class Calculator {
    fun add(a: Int, b:Int) = a + b
}
//TODO parameterizedTestをかく

class AsyncService {
    suspend fun asyncAdd(a:Int, b: Int): Int {
        return a + b
    }
}
// TODO コルーチンのテストを書く
class AsyncTest {
    @Test
    suspend fun `非同期の加算処理をテストする`() {
        val asyncService = AsyncService()
        val result = asyncService.asyncAdd(3, 7)
        assertEquals(10, result)
    }
}

interface Database {
    fun fetchNameById(id: Int): String
}
class MockDatabase: Database {
    override fun fetchNameById(id: Int): String = "MockUser"
}
class UserService(private val database: Database) {
    fun getUserName(id: Int): String = database.fetchNameById(id)
}
class DITest {
    @Test
    fun `ユーザー名を取得するテスト`() {
        val mockDatabase = MockDatabase()
        val userService = UserService(mockDatabase)
        val result = userService.getUserName(1)
        assertEquals("MockUser", result)
    }
}
//TODO ExtensionTest
//TODO CoroutineTest
//TODO CustomAnnotationTest
//TODO ExternalLibraryTest
//TODO MobileUnitTest
//TODO DatabaseTest
//TODO UITest
//TODO CustomMatcherTest
//TODO CoreModuleTest
//TODO externalFrameworkTest