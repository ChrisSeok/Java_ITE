/**
 *  JavaScript code를 작성해요!
 */
/* JavaScript 함수 */
function myFunc(){
	//console.log("소리없는 아우성") //콘솔 출력
	//$("*").css("color","red");
	//$("#myLi").remove(); // id 선택자
	//$("div,input").css("background-color","yellow"); // div, input 두 개의 태그명을 찾는다
	//$(".myStyle").css("color","blue")
	//$("ol > li").css("background-color","red") //ol이 자식으로 가지는 li를 찾는다.
	$("div ul").css("background-color","blue");//div의 후손인 ul ... 공백=후손
	$("#myLi + li").text("멍멍이"); //myLi 다음에 나오는 li 선택
	//attr()이 메서드는 속성의 값을 알아내거나 변경할 때 사용한다.
	$("[type]").attr("value","변경되었어요!"); //속성 중 type이라는 애를 다 찾자
}