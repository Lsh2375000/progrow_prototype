document.addEventListener('DOMContentLoaded', function() {
    document.querySelector('span.btnFindZipcode').addEventListener('click', execDaumPostcode);

    function execDaumPostcode() {
        /* 상황에 맞춰서 변경해야 하는 부분 */
        const zipcode = document.getElementById('zipcode');
        const address01 = document.getElementById('address01');
        const address02 = document.getElementById('address02');

        /* 수정없이 사용 하는 부분 */
        new daum.Postcode({
            oncomplete: function (data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if (data.userSelectedType === 'R') {
                    //법정동명이 있을 경우 추가한다.
                    if (data.bname !== '') {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if (data.buildingName !== '') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                zipcode.value = data.zonecode; //5자리 새우편번호 사용
                address01.value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                address02.focus();
            }
        }).open();
    }

    const btnSubmit = document.querySelector('.btn-submit');

    btnSubmit.addEventListener('click', function (e) {
        // 필수 요소 유효성 검사

        const mentee_id = document.querySelector('.mentee_id').value;
        const passwd = document.querySelector('.passwd').value;
        const passwdChk = document.querySelector('.passwdChk').value;
        const age = document.querySelector('.age').value;
        const nickname = document.querySelector('.nickname').value;

        if (mentee_id === '') {
            alert('이메일 인증을 해주세요')
            e.preventDefault();
            return;
        }
        else if (passwd === '') {
            alert('비밀번호를 입력해 주세요')
            e.preventDefault();
            return;
        }
        validatePassword();
        if (age === '') {
            alert('나이를 입력해 주세요')
            e.preventDefault();
            return;
        }
        else if (nickname === '') {
            alert('닉네임을 입력해 주세요')
            e.preventDefault();
            return;
        }
    });





    function validatePassword() {
        const password = document.getElementsByName("passwd")[0].value;
        const confirmPassword = document.getElementsByName("passwdChk")[0].value;
        const pattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

        if (password != confirmPassword) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return false;
        }

        if (!pattern.test(password)) {
            alert("비밀번호는 8자 이상이며, 영문 대/소문자, 숫자, 특수문자가 각각 하나 이상 포함되어야 합니다.");
            return false;
        }

        return true;
    }
});