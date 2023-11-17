async function get1(boardNo){
    const result = await axios.get(`/replies/list/${boardNo}`);
    console.log(result);
}