package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;


/*
* 비밀번호는 최소 8자 이상 12자 이하여야 한다
* 비밀번호 8작 미만 또는 12자 초과인 경우 IllegolArgumentException 예외를 발생시킨다
* 경계조건에 대해 테스트 코드를 작성해야 한다.
* */

/*
* 1. 문서화 역할
* 2. 코드에 결함을 발견하는 역할
* 3. 리팩토링 시 안정성 확보
* 4. 테스 하기 쉬운 코드를 작성하다 보면 더 낮은 결합도를 가진 설계를 얻을 수 있음
* */

public class PasswordValidatorTest {
        /*
        1. 문서화 역할 -> 이러한 부분으로 어떤한 것을 테스트 하는지를 확인할 수 있습니다
        */
        @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다")
        @Test
        void validatePasswordTest(){
            assertThatCode(()-> PasswordValidator.validate("serverwizard"))
                    .doesNotThrowAnyException();
        }

        @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
        void validatePasswordTest2(String password){

            assertThatCode(()-> PasswordValidator.validate("aabb"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("비밀번호는 최소 8이상 12자 이하여야 한다.");
        }
}
