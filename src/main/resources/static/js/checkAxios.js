    async function isEmail(inputId) { // 이메일 비동기 존재 확인
        // console.log(inputId);
        const request = await axios.post('/member/isEmail', null, {
            params: {email : inputId},
            responseType: 'text'
        });
        // console.log(request.data);

        return request.data;
    }

    async function sendEmail(email, isEmail) {
        const request = await axios.get(`/member/resetPassword/`,null, {
            params: {email: email, isEmail: isEmail}
        });

        return request.data;
    }


    async function checkId(inputId) { // 이메일 비동기 중복확인
        // console.log(inputId);
        const request = await axios.post('/member/idCheck', null, {
            params: {mentee_id : inputId},
            responseType: 'text'
        });
        // console.log(request.data);
        return request.data;
    }

    async function checkNickname(nickname) { // 닉네임 비동기 중복확인
        // console.log(nickname);
        const request = await axios.post('/member/nicknameCheck', null, {
            params: {nickname : nickname},
            responseType: 'text'
        });
        // console.log(request.data);

        return request.data;
    }

    async function sendConfirmMail(mailTo) { // 이메일 인증키 발송
        // console.log("sendConfirmMail");
        // console.log(mailTo);
        const request = await axios.get(`/member/sendConfirmMail?mailTo=${mailTo}`);

        return request.data;
    }

    async function matchConfirmKey(confirmKey) { // 이메일 인증키 확인
        // console.log(confirmKey);
        const request = await axios.post('/member/matchConfirmKey', null, {
            params: { confirmKey: confirmKey },
            responseType: 'text'
        });

        // console.log("axios: " + request.data);
        return request.data;
    }

    async function matchCurrentPw(inputPw) {
        console.log('matchCurrentPw')
        const request = await axios.post('/member/passwordCheck', null, {
           params: { inputPw: inputPw },
           responseType:'text'
        });

        return request.data;
    }