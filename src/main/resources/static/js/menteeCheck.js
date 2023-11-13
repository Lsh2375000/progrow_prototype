// 이메일을 입력 받는 input 태그의 id : email
// 인증받기 버튼 태그의 id : emailAuth
// 인증 번호를 입력 받는 input 태그의 id : authCode
// 입력한 인증 번호와 이메일로 받은 인증 번호가 일치하는지 여부를 보여주는 span 태그의 id : emailAuthWarn

// 이메일 정규식 검사
$("#email").on("keyup", function () {
    console.log("이메일 인식함")
    let regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    //console.log("email : "+$memail.val());
    if (!regExp.test($("#email").val())) {
        // console.log("형식 미확인");
        emchk = false;

        $("#mailTxt").html("<span id='chkmail'>이메일 형식이 맞지 않습니다</span>");

        $("#chkmail").css({
            "color": "#FA3E3E",
            "font-weight": "bold",
            "font-size": "15px",
            "position": "absolute",
            "padding-top": "25px",
            "z-index" : "-1"
        });

    } else {
        emchk = true;

        console.log("형식 확인");
        $("#mailTxt").html("<span id='chkmail'>이메일을 형식을 확인했습니다</span>")

        $("#chkmail").css({
            "color": "#0D6EFD",
            "font-weight": "bold",
            "font-size": "15px",
            "position": "absolute",
            "padding-top": "25px",
            "z-index" : "-1"
        })
    }
});


//인증하기 버튼을 눌렀을 때 동작
$("#emailAuth").click(function () {
    const email = $("#email").val(); //사용자가 입력한 이메일 값 얻어오기
    //Ajax로 전송
    $.ajax({
        url: './sendConfirmMail?mailTo=' + email, // 비동기로 회원이 작성한 이메일을 주소로 보낸다.
        data: {
            mail: email // 이메일을 json형태로 보낸다
        },
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log("result : " + result);
            $("#authCode").attr("disabled", false);
            // 여기에 인증번호 유효시간 출력하는 코드 작성
            code = result;
            alert("인증 코드가 입력하신 이메일로 전송 되었습니다.");
        }
    }); //End Ajax
});

// 인증번호 일치 여부 비동기로 확인하기
$("#authCode").on("keyup", function () {
    const inputCode = $("#authCode").val(); //인증번호 입력 칸에 작성한 내용 가져오기
    let okCode; // 일치여부의 반환 값을 담을 변수 선언

    $.ajax({ // 메일로 보낸 인증번호를 비동기방식으로 세션에 저장된 인증번호와 비교한다.
        url: './isConfirmKey', // 인증 여부 확인할 주소값
        data: { // json형태로 메일로 받은 인증키를 담아서 보내준다.
            confirmKey: inputCode // Value : Key
        },
        type: 'POST',
        dataType: 'json',
        success: function (result) { // URL로 보낸 인증코드를 확인해서 true로 반환 되면 콜백함수 실행
            console.log("okCode : " + result);
            okCode = result; // success 콜백 함수에서 okCode 변수를 설정합니다.

            if (okCode) {

                $("#emailAuthWarn").html('인증번호가 일치합니다.');
                $("#emailAuthWarn").css({
                    "color": "#0D6EFD",
                    "font-weight": "bold",
                    "font-size": "15px",
                    "position": "absolute",
                    "z-index" : "-1"
                });
                $('#emailAuth').attr('disabled', true);
                $('#email').attr('readonly', true);
                $("#registerBtn").attr("disabled", false);

            } else if (okCode == false){

                $("#emailAuthWarn").html('인증번호가 불일치 합니다. 다시 확인해주세요!');
                $("#emailAuthWarn").css({
                    "color": "#FA3E3E",
                    "font-weight": "bold",
                    "font-size": "15px",
                    "position": "absolute",
                    "z-index" : "-1"});
                $("#registerBtn").attr("disabled", true);
                const btnSubmit = document.querySelector('.btn-submit');
                btnSubmit.addEventListener('click', function (e) {
                    alert('이메일인증이 완료 되지 않았습니다.')
                    e.preventDefault();
                });
            }
        }
    }); //End Ajax
});



// // 비밀번호 입력
// $('.passwd').on("focusout", function () {
//     isChk();
//     const passwdChk = $('.passwdChk').val();
//     const passwd = $('.passwd').val();
//     if (passwd != passwdChk || passwd.length < 8) {
//         // 비밀 번호와 비밀번호 확인이 다르거나 비밀번호 입력칸이 비어있거나 비밀번호가 8자리 미만이면
//         $("#chkTxt").html('비밀번호가 일치하지 않습니다.');
//         $("#chkTxt").css({
//             "color": "#FA3E3E",
//             "font-weight": "bold",
//             "font-size": "15px",
//             "position": "absolute",
//             "padding-top": "40px",
//             "z-index": "-1"
//         });
//     }
// });
// // 비밀번호 확인
// $('.passwdChk').on("keyup", function () {
//     isChk();
// });
//
//
//
//
// function isChk() {
//
//     const passwdChk = $('.passwdChk').val();
//     const passwd = $('.passwd').val();
//
//     if (passwd.length < 8) { // 비밀번호가 8자리 미만이면
//
//         $("#pswCon").html('비밀번호는 9자리 이상입력해야 합니다.');
//
//         $("#pswCon").css({
//             "color": "#FA3E3E",
//             "font-weight": "bold",
//             "font-size": "15px",
//             "position": "absolute",
//             "padding-top": "40px",
//             "z-index" : "-1"
//         });
//     }
//     else if (passwd.length > 8 && passwd === passwdChk && passwd !== '') { // 비밀번호가 비어있지 않고, 완벽히 일치 하고, 비밀번호가 9자리 이상이면
//         $("#pswCon").html(''); // 비밀번호 조건 메시지 초기화
//         $("#chkTxt").html('비밀번호가 일치합니다');
//         $("#chkTxt").css({
//             "color": "#0D6EFD",
//             "font-weight": "bold",
//             "font-size": "15px",
//             "position": "absolute",
//             "padding-top": "40px",
//             "z-index" : "-1"
//         });
//     }
//     // end All if()
// } // end isChk()


