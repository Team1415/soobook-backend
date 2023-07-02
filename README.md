# soobook-backend
수북 Backend

## 로컬에서 redis, mysql, adminer 실행

### docker-compose

- 최초 실행

```bash
docker-compose up
```

- 기존에 실행했던 도커 컨테이너 중지

```bash
docker-compose stop
```

- 기존에 실행했던 도커 컨테이너 재실행

```bash
docker-compose start
```

- docker-compose 값 수정되어 처음부터 다시 띄우기

```bash
docker-compose down
docker-compose up
```

### redis

- redis-cli 접속
    - ```bash
    docker exec -it az-redis redis-cli
    ```

### mysql

- dbeaver에서 mysql 접속
    - connection 정보에서 driver properties, allowPublicKeyRetrieval = `true`로 설정
    - server host : `localhost`
    - port : `3306`
    - database : `soobook-database`
    - username : `root`
    - password : `verysecret`

## flyway

### flyway 설명

- ddl, dml 형상관리를 위한 플러그인
- `src/main/resources/flyway/ddl`에 ddl을, `src/main/resources/flyway/dml/local`에 dml을 생성

### SQL File Convention

```
V{sprint #}_{jira ticket #}_{seq}__{sql method}_{table name}.sql
```

- ddl의 `seq`는 1부터 시작
- dml의 `seq`는 101부터 시작

### 명령어

- 스프링 실행하면 자동으로 flyway가 적용됨
- 수동으로 flyway 적용
    - ```bash
    ./gradlew flywayMigrate
    ```
- flyway 적용된 것 수동으로 삭제
    - ```bash
    ./gradlew flywayClean
    ```

## spotless

```bash
./gradlew spotlessApply
```

- 혹은 intelliJ의 플러그인 `spotless gradle`을 사용
