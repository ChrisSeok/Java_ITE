/**
 *  
 */
/* JavaScript 함수 */
function myFunc(){
	//text()는 tag 사이에 있는 글자를 하나의 문자열로 만들어서 추출하는 함수이다.
	//type이 checkbox인 element찾기, 그 중에 (사용자에 의해)체크가 되어있는것만 찾을거야
	//jQuery는 무조건 선택-메서드 형식임.
	//반복문은 each()메서드.
	//each()안에서만 쓸거에요 > 이름이 필요가 없음! 외부에서 이 함수를 사용할 일이 없기 때문에.
	// = 익명함수 
	$("[type=checkbox]:checked + span").each(function(idx, item) { //콜백 함수
		//idx : 반복되는 index의 값. 처음에는 0, 그 다음에는 1,...
 		//item : 앞쪽에서 나오는 반복대상이 되는 문서객체(selector가 아니라 문서객체)
 		console.log($(item).text()); // 반복해서 따로따로 처리 가능
 	})
	

}