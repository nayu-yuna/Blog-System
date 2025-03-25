# Blog-System

### 1단계: 회원 관리 기능

- **회원 가입 기능**
    - ID, 비밀번호(암호화), 이메일, 닉네임 저장
    - 각 필드 유효성 검사:
        - ID: 6-30글자
        - 비밀번호: 12-50글자, 영문/숫자/특수문자(`!@#$%^&*`) 각 2글자 이상 포함
        - 이메일: 이메일 형식, 100글자 이하
        - 닉네임: 3~50글자
    - ID 중복 검사
    - API 구현 결과 
      - 회원가입 URL: http://localhost:8080/api/users/register
  ```json
  Reqister :
       {
           "id": "testuser",
           "password": "Test12345!@#",
           "userEmail": "testuser@example.com",
           "nickname": "Test User"
       }
  Response :
       {
           "success": true,
           "message": "회원 가입이 완료되었습니다."
       }
- **로그인 기능**
  - JWT 액세스 토큰 발급 (유효기간 무한)
  - 토큰은 메모리에만 저장(영속화 X)
  - 인증이 필요한 API 호출 시 HTTP 헤더의 `Authorization: Bearer {token}` 형식으로 전송
  - API 구현 결과
    - 회원가입 URL: http://localhost:8080/api/users/login
  ```json
  Reqister :
       {
           "id": "testuser",
           "password": "Test12345!@#",
           "userEmail": "testuser@example.com",
           "nickname": "Test User"
       }
  Response :
       {
           "success": true,
           "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
       }
