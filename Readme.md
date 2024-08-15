# IP 관리 시스템

이 프로젝트는 Spring Boot를 사용하여 구축된 IP 관리 시스템입니다. 
애플리케이션은 IP 주소 범위의 조회, 등록, 삭제, 할당, 반환의 기능을 수행하며
IP는 계층적 구조를 통해 관리합니다.
 
## Develop Environment

- **JDK 버전:** 17
- **Spring Boot 버전:** 3.3.2
- **빌드 도구:** Gradle 버전.** 8.4


## 설계 의도

1. **메모리 성능 향상 : ConcurrentHashMap을 사용하여 메모리 성능을 최적화
2. 활용 목적별 패키지 및 클래스 분리
3. 접근제어자를 통한 최소한의 노출로 캡슐화 구현
4. 중복 코드 최소화를 통한 응집도 향상 및 결합도 감소 구현
5. 단일 책임 원칙에 입각한 메소드 구현으로 복잡도 최소화
6. 직관적인 ENUM 사용으로 가독성 향상



## 아키텍처 구조

1. **컨트롤러 (Controller)**
2. **서비스 (Service)**
3. **레퍼지토리 (Repository)**
4. **모델 (Model)**
6. **유틸리티 (Util)**
7. **구성 (Config)**
8. **예외 (Exception)**

## 애플리케이션 실행
1. Gradle 빌드
2. Tomcat 실행
3. 애플리케이션은 http://localhost:8080에서 시작합니다.

## 스웨거
http://localhost:8080/swagger-ui/index.html


