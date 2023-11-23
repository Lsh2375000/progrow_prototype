// qna 게시판
async function getQ1(qBoardNo) {
    const result = await axios.get(`/qReplies/list/${qBoardNo}`);
    // console.log(result);
    return result.data;
}

async function getQList({qBoardNo, page, size, goLast}) {
    const result = await axios.get(`/qReplies/list/${qBoardNo}?=page${page}`, {params: {page, size}});
    if (goLast) {
        const total = result.data.total;
        const lastPage = parseInt(Math.ceil(total/size));

        return getQList({qBoardNo:qBoardNo, page:lastPage, size:size})
    }
    // console.log(result);
    return result.data;
}

async function addQReply(replyObj) {
    const response = await axios.post(`/qReplies/`, replyObj);
    return response;
}

async function getQReply(qRno) {
    const response = await axios.get(`/qReplies/${qRno}`);
    return response.data;
}

async function modifyQReply(replyObj) {
    const response = await axios.put(`/qReplies/${replyObj.qRno}`, replyObj);
    return response.data;
}

async function removeQReply(qRno) {
    const response = await axios.delete(`/qReplies/${qRno}`);
    return response.data;
}