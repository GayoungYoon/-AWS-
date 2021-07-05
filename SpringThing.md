# Spring 관련 정리

### Rest에서의 HTTP CRUD Mapping
- CREATE - POST
- READ - GET
- UPDATE - PUT
- DELETE - DELETE

### Model 객체
1. 클라이언트의 요청 
2. 컨트롤러로 진입 <br/>
  2.1. 뷰의 요청경로지정(`@RequestMapping("/posts/save")`) <br/>
  2.2. 메소드 인자로 Model 전달받음 - 서버 템플릿 엔진에서 사용할 수 있는 객체
3. 비즈니스 로직 처리 후 Model 객체를 뷰로 리턴
```
model.addAttribute("변수이름","변수에 넣을 데이터값");
model.addAttribute("posts","postsService.findAllDesc());
```
4. 뷰(jsp/mustache 등)에서 조회시 ${변수이름} 으로 조회
