# 사용 기술

- Git
- GitHub
- java 17
- Spring MVC
- Vue.js or React   
	- axios, webpack, lodash
- MariaDB
---

# 개발 도메인 리스트
## track 1 : 단위 서비스
1. 소스 (source-service)
	- 소스 crud
	- 유입 정책 crud
2. 교사 (teacher-service)
	- 교사 crud
3. 배정 (assign-service)
	- 배정 정책 crud
	- 교사 배정 순차 루프 리스트 crud
	- 교사 배정 보정 리스트 cru
4. 스프링 클라우드 구축 (service-registry, config-server)
	- Eureka2
	- config-server

## track 2 : 서비스 통합
1. 소스
	- 체험 신청
		- 소스 => 배정 execute => 소스 write
2. 교사
	- 교사 배정 등록
		- 교사 => 배정 write
	- 교사 배정 일괄 중지
		- 교사 => 배정 write

![image](https://user-images.githubusercontent.com/37289223/203723794-11c8e396-e29c-47f6-a4fa-dc4877631222.png)

---
# 브랜치 전략
1. 메인 브렌치
  - 상시 유지되는 브렌치
    1. main 통합 브렌치 (develop)
       - main branch를 develop branch로 사용한다.
       - product 단계의 branch는 없기 때문.
2. 보조 브렌치
   1. 개개인의 feature 브렌치(topic branch)
      - develop 브렌치로 부터 나온다.
      - develop 브렌치로 merge 한다.
      - master, main, develop, release-*, hotfix-* 를 제외한 이름으로 한다.

