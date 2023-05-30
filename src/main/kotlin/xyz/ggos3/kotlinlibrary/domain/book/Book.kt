package xyz.ggos3.kotlinlibrary.domain.book

import jakarta.persistence.*
import xyz.ggos3.kotlinlibrary.util.fail

@Entity
class Book (
    val name: String,

    /**
     * 기존에는 DB Type에 0, 1, 2 와 같이 값이 저장되었지만( Enum의 순서가 바뀌면 위험함 ),
     * @Enumerated 어노테이션을 이용해 Enum의 값 자체를 저장할 수 있다.
     */

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    init {
        if (name.isBlank())
            fail("이름은 비어있을 수 없습니다.")
    }

    companion object {
        fun fixture(
            name: String = "책 이름",
            type: String = "COMPUTER",
            id: Long? = null
        ): Book {
            return Book(
                name = name,
                type = BookType.COMPUTER,
                id = id
            )
        }
    }
}