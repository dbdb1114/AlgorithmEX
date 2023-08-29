function solution(board) {
    let obj = {};
    
    for( let i = 0; i < board.length; i++){
        for (let j = 0; j < board.length; j++) {
            if( board[i][j] === 1 ) {
                
                const minusI = i - 1 < 0 ? i : i - 1;
                const plusI = i + 1 >= board.length ? i : i + 1 ;
                const minusJ = j - 1 < 0 ? j : j - 1;
                const plusJ = j + 1 >= board.length ? j : j + 1;
                
                obj[minusI + "" + j] = 1
                obj[minusI + "" + minusJ] = 1
                obj[i + "" + minusJ] = 1
                obj[plusI + "" + minusJ] = 1
                obj[i + "" + j] = 1
                obj[plusI + "" + j] = 1
                obj[minusI + "" + plusJ] = 1
                obj[i + "" + plusJ] = 1
                obj[plusI + "" + plusJ] = 1
            }
        }
    }    
    
    const res = Object.keys(obj);
    console.log(res);
    const result = (board.length * board.length) - res.length;
    return result;
    
}