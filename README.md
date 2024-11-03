# LogiCraft

LogiCraft는 기존 Warehouse Management System(WMS)의 복잡한 의존성을 개선하기 위해 설계된 토이 프로젝트입니다. 모놀리식 아키텍처를 유지하면서도 기능을 도메인 단위의 모듈로 나누어 이벤트 기반 설계를 도입했습니다. 이 접근 방식은 모듈 간의 결합도를 줄이고, 비즈니스 로직의 독립성과 확장성을 높이는 데 중점을 두고 있습니다.

## 프로젝트 아키텍처

LogiCraft는 모놀리식 구조를 따르지만, 명확히 분리된 모듈(도메인) 간의 이벤트 드리븐 아키텍처로 설계되었습니다. 각 모듈은 특정 비즈니스 기능을 담당하며, 이벤트를 발행하고 구독함으로써 독립적으로 동작합니다. 주요 모듈은 다음과 같습니다:

- **Core**: 비즈니스 프로세스를 오케스트레이션하고 이벤트를 관리합니다.
- **Common**: 공통적으로 사용하는 유틸리티 및 설정이 포함됩니다.
- **Master Data**: 창고, 로케이션 등 마스터 데이터를 관리합니다.
- **Inbound**: 입고 처리와 관련된 로직을 담당합니다.
- **Outbound**: 출고 기능을 처리합니다.
- **Inventory**: 재고 관리 기능을 담당하며, Lot 기반의 세부 조정을 지원합니다.
- **Lot Management**: 재고의 Lot 속성 및 추적 관리를 처리합니다.
- **Serial Number**: 시리얼 넘버 기반의 데이터 관리를 지원합니다.
- **Purchase Order**: 발주 및 구매 관련 비즈니스 로직을 관리합니다.

## 기술 스택

- **언어**: Kotlin
- **프레임워크**: Spring Boot
- **데이터베이스**: PostgreSQL
- **이벤트 처리**: Spring 이벤트를 활용한 이벤트 기반 통신
- **비동기 처리**: 코루틴을 통한 비동기 프로세싱
- **컨테이너**: Docker, Docker Compose

## 주요 기능

- **이벤트 기반 오케스트레이션**: Core 모듈이 이벤트를 발행하고 각 모듈이 이를 처리하여 비즈니스 로직을 실행합니다.
- **헥사고날 아키텍처**: 각 모듈은 포트와 어댑터 패턴을 사용해 외부 의존성을 분리하여 높은 응집도와 확장성을 제공합니다.
- **창고 관리**: 창고 및 로케이션의 생성 및 수정.
- **입고/출고 관리**: 물품의 입고 및 출고 처리.
- **재고 관리**: Lot 및 시리얼 넘버를 기반으로 한 상세한 재고 관리.
- **확장성**: 새로운 비즈니스 기능을 쉽게 추가할 수 있도록 설계되었습니다.

## 설치 및 실행

### 로컬 환경에서 실행

1. 이 저장소를 클론합니다:
   ```bash
   git clone https://github.com/LiamKim-DaeYong/LogiCraft.git
   ```
2. 프로젝트 디렉토리로 이동합니다:
   ```bash
   cd LogiCraft
   ```
3. 애플리케이션을 빌드하고 실행합니다:
   ```bash
   ./gradlew bootRun
   ```

## 사전 요구사항
- JDK 21 이상이 설치되어 있어야 합니다.
- Docker 및 Docker Compose가 설치되어 있어야 합니다.