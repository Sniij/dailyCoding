function solution(progresses, speeds) {
    // 뒤에있는 기능이 먼저되면 앞에있는 기능이 완료될때 같이 배포됨
    // 100-원소 / speeds[i] > [7,3,9] 로 만들고 (Math.ceil() 올림 사용)
    // count = 0에서 1씩 더하고 다음요소가 크면 []인 answer에 넣고 리턴
    let answer = [];
    let proSpeed = [];
    let count = 0;
    for(let i = 0; i< progresses.length; i++){
        proSpeed.push(Math.ceil((100-progresses[i])/speeds[i]))
    }
    
    while(proSpeed.length > 0) {
        let cur = proSpeed[0];
        let count = 0;

        while(proSpeed[0] <= cur) {
            proSpeed.shift();
            count++;
        }
        
        answer.push(count);
    }
    
    return answer
    
}