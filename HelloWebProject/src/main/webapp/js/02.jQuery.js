// val() 메서드와  
 
function myFunc(){
	 //text()는 인자가 없으면 값을 알아내는 기능, 있으면 값을 변경.
	//id가 apple인 element를 찾아서 text를 알아내라
	//console.log($("#apple").text()); //사과
	//console.log($("#apple + li").text()); // 파인애플
	//console.log($("ul > li.myList").text()); //ul의 자식 li 중에 클래스가 myList인 것
//태그 사이의 값 > text()함수로 가져온다.
//val()함수
	console.log($("#uid").val());  // 선택된 Element에 대해(이 Element가 사용자 입력 양식인 경우)
    							   // 사용자가 입력한 값을 알아올 때 사용.
	console.log($("ol > li:first").text()); //li중의 첫 번째 요소
	console.log($("ol > li:last").text()); //li중의 순서상 마지막 요소
	console.log($("ol > li:nth-child(1)").text()); //nth-child(n) , 1부터 시작
	
}