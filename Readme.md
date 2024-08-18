# 무신사 코디 서비스

Musinsa Codi Service는 브랜드 및 상품 관리를 위한 API를 제공하며, 카테고리별 최저가 상품 및 브랜드 정보를 
손쉽게 조회할 수 있는 서비스입니다. 
이 서비스는 Spring Boot를 기반으로 개발되었으며, 데이터베이스와의 상호작용은 MyBatis를 사용하여 처리합니다. 
API 문서는 Swagger UI를 통해 제공되며, 
선택적 사용 도구인 H2 데이터베이스 사용은 최소화하여 구현했습니다.

## 구현 범위
### 1. API 기능
- **브랜드 관리**
    - 브랜드 등록
    - 브랜드 수정
    - 브랜드 삭제
- **상품 관리**
    - 상품 등록
    - 상품 수정
    - 상품 삭제
- **상품 조회**
    - 카테고리별 최저가 상품 및 브랜드 조회
    - 단일 브랜드의 모든 카테고리 상품 최저가 및 총액 조회
    - 특정 카테고리 내 최저가/최고가 브랜드와 상품 가격 조회

### 2. 전역 예외 처리
- **GlobalExceptionHandler**: 애플리케이션 전반에 걸쳐 발생하는 예외를 처리합니다.
    - **DuplicateKeyException**: 중복된 키가 존재할 때 처리
    - **DataIntegrityViolationException**: 데이터 무결성 위반 시 처리
    - **SQLException**: 데이터베이스 오류 처리
    - **ResourceNotFoundException**: 리소스가 존재하지 않을 때 404 응답 반환

### 3. Swagger를 통한 API 문서화
- Swagger를 사용하여 API 문서 및 테스트 UI를 제공합니다.
- `/swagger-ui/index.html` 경로에서 API 문서를 확인할 수 있습니다.

## 개발 환경
- **Java 버전:** 21
- **Spring Boot 버전:** 3.3.2
- **빌드 도구:** Gradle

## 애플리케이션 실행
1. Git에서 main 브랜치를 최신 상태로 pull 합니다.
2. Gradle을 사용하여 프로젝트를 클린 빌드합니다.
3. 애플리케이션을 실행합니다.
4. 기본적으로 애플리케이션은 http://localhost:8080에서 시작됩니다.
5. h2 db 접속 : http://localhost:8080/h2-console
   - jdbc url : jdbc:h2:mem:testdb
   - User Name : sa
   - Password : 

# 테스트 코드
- 각 서비스에 대해 단위 테스트 및 통합 테스트가 포함되어 있습니다. 
- 모든 기능에 대한 테스트 코드를 통해 서비스의 안정성을 보장합니다.

## 스웨거
- http://localhost:8080/swagger-ui/index.html


