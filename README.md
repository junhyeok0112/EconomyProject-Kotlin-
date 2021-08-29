# EconomyProject-Kotlin-

자바로 만들었던 프로젝트를 Kotlin으로 고치고 요즘 나오고 사용되는 라이브러리, jetpack등을 이용한 코드로 유지보수했습니다.


사용기술
1. Navigation
  - Activity들로 구성되어있던 xml을 Fragment로 모두 바꾸었고 이 Fragment들 사이에서 Navigation을 이용해서 이동하게 했습니다.
  - safe args를 이욯해서 프래그먼트끼리의 데이터 전달
2. RecyclerView
  - 100대 경제지표를 RecyclerView로 구현해서 보여줌
3. Retrofit2
  - 한국은행 통계 시스템 API를 이용해서 데이터를 가져옵니다.
  - API 서버에서 결과를 가져옵니다.
  - 사용한 주요 경제지표들에 대한 1년간의 데이터를 가져옵니다.
4. 프래그먼트 웹뷰에서 뒤로가기 버튼 작동 구현
5. Spinner
  - 각 6개의 경제지표 마다 선택하면 그 경제지표의 변화를 보여줄 수 있게합니다.
7. MPChart
  - 주요 6개 경제지표에 대한 1년간의 변화를 꺽은선형 그래프로 보여줍니다.

- 개선 가능 사항 : ViewModel에 Retrofit에 받아온 데이터들을 저장하고 MVVM 패턴으로 바꿀 수 있습니다.
