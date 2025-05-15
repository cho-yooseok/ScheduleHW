
# Schedule Management API

내일배움캠프 Sping6기 과제로 제작한 Spring Boot 기반의 일정 관리 REST API입니다.

사용자는 일정을 생성, 조회, 수정 및 삭제할 수 있습니다.

## 기술 스택

- Java 
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- JPA Auditing

---
##  프로젝트 구조

```java
com.example.schedule
├── controller         // REST API 컨트롤러
├── entity             // JPA 엔티티
├── repository         // JPA Repository 인터페이스
├── service            // 비즈니스 로직 처리
└── ScheduleApplication.java  // 메인 애플리케이션 클래스
```


---
##  API 기능

| 메소드 | 경로 | 설명 |
|--------|------|------|
| `POST`   | `/api/schedules` | 일정 생성 |
| `GET`    | `/api/schedules` | 전체 일정 조회 |
| `GET`    | `/api/schedules/{id}` | 단일 일정 조회 |
| `PUT`    | `/api/schedules/{id}` | 일정 수정 |
| `DELETE` | `/api/schedules/{id}` | 일정 삭제 |


