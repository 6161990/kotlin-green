# Sealed

```kotlin
fun add(developer: Developer) = when (developer) { // 컴파일 오류 발생
    is FrontendDeveloper -> pool[developer.name] = developer
    is BackendDeveloper -> pool[developer.name] = developer
}
```
* 해당 상황에서는 else 가 없어서 컴파일 오류가 발생하는데 sealed class 키워드를 달아주면 해결된다.
* 하위 클래스를 제한 조건에 따라 정의 컴파일러가 컴파일 시점에 Developer 의 하위 클래스가 무엇무엇이 있는지 확인한다.
* 제한 조건 : Sealed 는 같은 모듈, 같은 패키지 내에서만 작동한다.
* 하위 클래스가 하나 더 추가될 경우, sealed 클래스를 사용하는 when 식에서 컴파일 오류를 내뱉어줘서 해당 시점에 확인할 수 있음.



``근데 이 밖에 sealed 의 사용용도가 더 있지 않을까?``