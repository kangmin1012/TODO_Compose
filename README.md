# TODO_Compose
Compose로 만들어 보는 TODO 앱

## Module
해당 프로젝트는 Multi-Module 구조를 띄고 있으며 Feature 별로 각각의 기능을 담고 있습니다.

<img src="https://github.com/kangmin1012/TODO_Compose/assets/55642709/fbed8432-55bc-4fff-9465-e9de455465be" width="500"/>

### Module Graph 생성하는 방법

```
1. graphviz 설치 (Homebrew 기준)
- brew install graphviz

2. root 프로젝트에서 아래 명령어 실행
- ./gradlew projectDependencyGraph
```
