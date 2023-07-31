## 코테스트 관련 라이브러리

#### Dependencies

```kotlin
testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutinesVersion")

testImplementation("io.mockk:mockk:$mockkVersion")
testImplementation("io.kotest.extensions:kotest-extensions-spring:$kotestExtensionsSpringVersion")
testImplementation("org.mockito.kotlin:mockito-kotlin:$mockitoVersion")
위의 코드는 Kotlin 기반의 테스트 프레임워크인 Kotest와 Kotlin Coroutines에 대한 의존성 설정을 보여줍니다. 
```

##### 1. io.kotest:`kotest-runner-junit5`:$kotestVersion
```text
이 의존성은 Kotest 테스트 프레임워크의 JUnit 5 지원을 위한 러너(runner) 라이브러리입니다.
Kotest는 Kotlin 기반의 테스트 프레임워크로, JUnit 5와 함께 사용하여 코틀린 테스트를 작성하고 실행하는 데 사용됩니다.
이 라이브러리를 사용하면 JUnit 5의 테스트 러너로 Kotest 테스트를 실행할 수 있습니다.   
```   


##### 2. io.kotest:`kotest-assertions-core`:$kotestVersion
```text
이 의존성은 Kotest 테스트 프레임워크의 기본적인 어서션(assertion) 라이브러리입니다.
Kotest는 다양한 어서션 함수를 제공하여 테스트 코드에서 예상되는 결과와 실제 결과를 비교하고 검증하는 데 사용됩니다.
이 라이브러리를 사용하면 Kotlin에서 편리하게 테스트 코드의 어서션을 작성할 수 있습니다.
```   


##### 3. org.jetbrains.kotlinx:`kotlinx-coroutines-test`:$kotlinCoroutinesVersion
```text
이 의존성은 Kotlin Coroutines의 테스트 지원 라이브러리입니다.
Kotlin Coroutines는 비동기 프로그래밍을 지원하는 라이브러리로, 코틀린에서 쉽게 비동기 코드를 작성하고 실행할 수 있도록 도와줍니다.
kotlinx-coroutines-test 라이브러리를 사용하면 테스트 시에 Kotlin Coroutines를 테스트하기 위한 유틸리티 함수와 기능을 제공받을 수 있습니다.
예를 들어, 테스트에서 코루틴 실행을 제어하고 테스트용 디스패처러(dispatcher)를 사용할 수 있도록 도와줍니다.
```   


##### 4. `io.mockk:mockk`:$mockkVersion
```text
io.mockk:mockk는 Kotlin 기반의 목(mock) 라이브러리입니다. 
목 라이브러리는 테스트 시에 가짜 객체를 생성하고 제어하는데 사용되며, 특히 테스트 대상 객체가 다른 객체와 상호작용할 때 그 상호작용을 검증하고 제어하는 데 유용합니다.   

1. Mock 객체 생성: mockk() 함수를 사용하여 코틀린 클래스의 목 객체를 생성합니다. 생성된 목 객체는 기존 클래스의 인스턴스와 비슷하지만, 테스트 중에 원하는 방식으로 동작할 수 있습니다.
2. 동작 정의: every , just , coEvery , coJust  등의 함수를 사용하여 목 객체의 메서드가 특정한 입력에 대해 어떻게 동작해야 하는지를 정의합니다.
3. 호출 검증: verify , coVerify  등의 함수를 사용하여 목 객체의 메서드가 특정한 방법으로 호출되었는지 검증합니다.
4. 스텁과 예외 처리: every  함수를 사용하여 목 객체의 메서드가 특정한 입력에 대해 어떤 값을 반환하도록 스텁(stub) 설정하거나 예외를 던지도록 정의할 수 있습니다.
```   


##### 5. `io.kotest.extensions:kotest-extensions-spring`:$kotestExtensionsSpringVersion
```text
Kotest와 Spring Framework를 함께 사용할 때 편리하게 테스트를 작성하고 실행할 수 있도록 지원하는 Kotest 확장(extension) 라이브러리입니다.
Kotest는 Kotlin 기반의 강력한 테스트 프레임워크이며, Spring Framework는 자바(Java) 기반의 애플리케이션 개발을 위한 강력한 프레임워크입니다. 
이 라이브러리는 두 프레임워크를 통합하여 코틀린과 스프링을 함께 사용하는 프로젝트에서 테스트 코드를 더욱 쉽고 효율적으로 작성할 수 있도록 도와줍니다.

kotest-extensions-spring 라이브러리의 기능은 다음과 같습니다:   
1. Spring TestContext Framework와의 통합: kotest-extensions-spring은 Spring TestContext Framework와 통합되어, 스프링 컨텍스트를 자동으로 로드하고 관리할 수 있습니다. 따라서 테스트 클래스에 @SpringBootTest @ContextConfiguration등의 스프링 테스트 애노테이션을 사용하지 않아도 됩니다.   
2. Spring Bean 지원: kotest-extensions-spring은 테스트에서 스프링 빈(Spring Bean)을 쉽게 주입받을 수 있도록 지원합니다. 테스트 클래스에서 @Autowired애노테이션을 사용하여 스프링 빈을 주입받을 수 있습니다.   
3. 코틀린 DSL: Kotest의 강력한 DSL을 활용하여 스프링 테스트를 작성할 수 있습니다. kotest-extensions-spring라이브러리는 코틀린 DSL을 사용하여 스프링 테스트를 보다 간결하고 가독성 있게 작성할 수 있도록 도와줍니다.
```
   

##### 6. `org.mockito.kotlin:mockito-kotlin`:$mockitoVersion
```text
org.mockito.kotlin:mockito-kotlin:$mockitoVersion 은 Kotlin에서 Mockito 라이브러리를 사용하기 위한 편의성을 제공하는 Mockito Kotlin 모듈입니다.
이에 대응하여 Mockito Kotlin 모듈은 Kotlin 코드와 Mockito를 함께 사용할 때 더 편리하게 사용할 수 있도록 Kotlin 특화된 확장 함수를 제공합니다. 
이를 통해 Kotlin 코드에서 더 쉽게 목 객체를 생성하고, 호출 검증을 수행하며, 스텁을 정의할 수 있습니다.
    
📍   
io.mockk:mockk:$mockkVersion 와 다른점?
io.mockk:mockk Kotlin에 특화된 목 라이브러리.
kotlin:mockito 는 주로 Java와 Kotlin을 함께 사용하는 프로젝트에서 사용되며, 기존의 Mockito를 Kotlin 환경에서 편리하게 사용하고자 하는 경우에 적합합니다
    
Kotlin의 강점과 특성을 최대한 활용하고자 하는 경우에는 io.mockk:mockk 를 고려해보고,
기존의 Mockito와의 호환성을 중요시 하는 경우에는 org.mockito.kotlin:mockito-kotlin` 를 선택하는 것이 좋습니다.
```